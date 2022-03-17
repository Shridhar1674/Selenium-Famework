package Com.Crm.OrganizationTests;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;

public class CreatOrgWithInDTypeTest extends BaseClass
{
 @Test
 public void createContactWithOrgTest() throws Throwable
 {
		//Step 3: navigate to organizations link
		driver.findElement(By.linkText("Organizations")).click();
		
		//Step 4: click on create Organization link I'm
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//Step 5:create org with mandatory fields
		driver.findElement(By.name("accountname")).sendKeys("ALL STATES");
		
		//Step 6: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
 }
 }