package Com.Crm.Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LaunchBrowserTest {
	
	@Test
	public void launchBrowserTest()
	{
		WebDriver driver=new ChromeDriver(); 
		System.out.println("my first program");
	}

}
