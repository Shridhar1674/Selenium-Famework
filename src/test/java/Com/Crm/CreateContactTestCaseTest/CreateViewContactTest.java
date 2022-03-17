package Com.Crm.CreateContactTestCaseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.testng.annotations.Test;

public class CreateViewContactTest
{
	@Test
	
	public void createViewContactTest() throws Throwable
	
	{
		/*load all the nessasary data*/
		
		FileInputStream fis =new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj =new Properties();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("browser");
		String URl = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
		/*load all the excel data*/
		
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Test Data.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Contacts");
		Row ro = sh.getRow(1);
		Cell ce = ro.getCell(2);
		String LASTNAME = ce.getStringCellValue();
		
		/*launch the browser*/
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URl);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		/*save the contact*/
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.findElement(By.xpath("//img[@title='Last Viewed']")).click();
		 WebElement ele = driver.findElement(By.xpath("(//a[.='" +LASTNAME+ "'])[1]"));
		 Actions a=new Actions(driver);
		 a.doubleClick(ele);
		
		/*verification*/
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(contactHeader.contains(LASTNAME))
		{
			System.out.println(contactHeader);
			System.out.println("contact is created");
		}
		else
		{
			System.out.println(contactHeader);
			System.out.println("contact is not created");
			
		}
		
		/*verification*/
		String lastviewedContact = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(lastviewedContact.contains(LASTNAME))
		{
			System.out.println(lastviewedContact);
			System.out.println("yes it is last viwed conatct");
		}
		else
		{
			System.out.println(lastviewedContact);
		    System.out.println("it is not the last viewed conatct");
		}
		driver.findElement(By.xpath("//input[@title='Duplicate [Alt+U]'][1]")).click();
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]'][1]")).click();
		
		 WebElement elem = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 Actions act=new Actions(driver);
		 act.moveToElement(elem).perform();
		 driver.findElement(By.linkText("Sign Out")).click();
		 
		 /* close the browser*/
		 driver.quit();
			
		
		
	}
	

}
