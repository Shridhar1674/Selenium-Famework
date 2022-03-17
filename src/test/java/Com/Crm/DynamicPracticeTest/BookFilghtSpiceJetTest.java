package Com.Crm.DynamicPracticeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class BookFilghtSpiceJetTest 
{
	public class BookFlightSpiceJetTest 
	{
		@Test
		public void bookFligt() throws Throwable
		{
			ChromeOptions options= new ChromeOptions();
			options.addArguments("disable-notifications");
			WebDriver driver=new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.get("https://www.spicejet.com/");
		
			driver.findElement(By.xpath("//div[text()='round trip']")).click();
			 
			 WebElement ele = driver.findElement(By.xpath("//div[text()='From']"));
			 ele.click();
			 ele.sendKeys("BLR");
			 
			 driver.findElement(By.xpath("//div[text()='Bengaluru']")).click();
			 
			 driver.findElement(By.xpath("//div[text()='To']/following::input[@type='text']")).sendKeys("Mumbai");
			 
			 String dDateXpath="//div[text()='July ']/ancestor::div[@data-testid='undefined-month-July-2022']/descendant::div[text()='7']";
			 driver.findElement(By.xpath(dDateXpath)).click();
			
			 String retDateXpath = "//div[text()='August ']/ancestor::div[@data-testid='undefined-month-August-2022']/descendant::div[text()='7']";
			 driver.findElement(By.xpath(retDateXpath)).click();
			 Thread.sleep(4000);
			 driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();
			
			
			 driver.quit();
			
		}

	}

}
