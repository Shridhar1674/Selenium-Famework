package Com.Crm.ContactTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

public class CreateContactWithLeadSource extends BaseClass 
{
    @Test
	
	public void createContactswithLeadSource() throws Throwable
	{
	
		
		//Step 3 : Reading Data from Excel file
		String cntName = eLib.readDataFromExcel("Contacts", 1, 1)+"_"+jLib.getRandomNumber();
		String typDrDown = eLib.readDataFromExcel("Contacts", 3, 3);
		
		
		
		//Step 6 : Navigate to contacts tab and click on application
		HomePage hp = new HomePage(driver);
		hp.ClickOnContactLnk();
		
		//Step 7 : Click on add contacts link
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		
		//Step 8 : Creating Organization with leadsource
		 CreateContactPage ccp = new CreateContactPage(driver);
		 ccp.createNewContact(typDrDown);
	}

}
