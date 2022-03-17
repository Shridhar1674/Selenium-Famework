package Com.Crm.ContactTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class ContactCheckBoxLastBoxSelect extends BaseClass
{
	@Test
	
	public void contactCheckBoxLastBoxSelect() throws Throwable {
		HomePage hp = new HomePage(driver);
		hp.ClickOnContactLnk();
		
		WebElement ele =driver.findElement(By.xpath("(//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id'])[last()]"));
		wLib.scrollAction(driver);
		Thread.sleep(5000);
		ele.click();
		Thread.sleep(3000);
	}

}
