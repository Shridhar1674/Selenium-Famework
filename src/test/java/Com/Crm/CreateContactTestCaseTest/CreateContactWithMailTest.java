package Com.Crm.CreateContactTestCaseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CreateContactWithMailTest 
{
	@Test
	
	public void createContactWithMailTest() throws Throwable
	{
		/*load all the nessasary data*/
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
		/*load all the excel data*/
		FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\Test Data.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
	    Sheet sh = wb.getSheet("Contacts");
	    Row ro = sh.getRow(1);
	    Cell ce = ro.getCell(2);
	    String LASTNAME = ce.getStringCellValue();
	    
	    /*launch the browser*/
	    WebDriver driver = null;
	    if(BROWSER.equalsIgnoreCase("chrome"))
	    {
	    	driver = new ChromeDriver();
	    }
	    else if(BROWSER.equalsIgnoreCase("firefox"))
	    {
	    	driver = new FirefoxDriver();
	    }
	    else
	    	
	    {
	    	System.out.println("invalid data");
	    }
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		/*save the contact*/
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

	}

}
