package Com.Crm.OrganizationTests;

import java.sql.DriverManager;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateOrganizationTest {
	
	@Test
	public void createOrgTest()
	{
		//Step 1: open the browser
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		
		//step 2: login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		Assert.fail();
		
		//step 3: navigate to organization link
		driver.findElement(By.linkText("organization")).click();
		
		
		//step 4: click on create organization link
		driver.findElement(By.xpath("Organizations")).click();
		
		//step 5: click org with mandtory fields
		driver.findElement(By.name("accountname")).sendKeys("ALL STATES");
		
		//step 6: save
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.quit();
		
		
		
		
		
	}

}
