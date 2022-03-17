package Com.Crm.ContactTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;


@Listeners (com.crm.GenericLibrary.ListnerImplementationClass.class)
  public class CreateContactTest extends BaseClass
  {
	
	@Test
	public void createContactsTest() throws Throwable 
	{
		String lastname = eLib.readDataFromExcel("Contacts", 1, 2);
		
		
		//step4: navigate to contact and create contact with mandatory fields
	   HomePage hp=new HomePage(driver);
	   hp.ClickOnContactLnk();
	   Assert.fail();
	   
	   ContactsPage cp = new ContactsPage(driver);
	   cp.clickOnCreateContactImg();
	   
	   CreateContactPage ccp = new CreateContactPage(driver);
	   ccp.createNewContact(lastname);
	   
	   //verify for contact
	   ContactInfoPage cip = new ContactInfoPage(driver);
	   String actHeader = cip.contactNameInfo();
	   if(actHeader.contains(lastname))
	   {
		   System.out.println(actHeader+"----> Contact Created");
	   }
	   else
	   {
		   System.out.println("contact not created");
	   }
	   
	}

}


