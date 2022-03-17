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
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationPage;

public class CreateContactWithOrgTest extends BaseClass 
{
	@Test(groups = "regressionSuite")
	public void createContactWithOrgTest() throws Throwable
	{
		
	    
	    //read data from excel sheet
	   String lastname = eLib.readDataFromExcel("Contacts", 1, 2)+"_"+jLib.getRandomNumber();
	   String leadsource = eLib.readDataFromExcel("Contacts", 4, 3);
	   
		//Step 4 : Navigate to organization link
		HomePage hp = new HomePage(driver);
		hp.ClickOnOrgLnk();
		
		//Step 5 : Click on create organization link
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOnCreateOrgImg();
		
		//Step 6 : enter mandatory fields and save
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createNewOrg(lastname);
		
		//Step 7 : Verify the organization
		OrganizationInfoPage oip = new 	OrganizationInfoPage(driver);
		String header = oip.OrgNameInfo();
		if(header.contains(lastname))
		{
			System.out.println(header);
			System.out.println("Data is verified");
		}
		else
		{
			System.out.println(header);
			System.out.println("Org Not Created");
		}
		
		//Step 8 : Navigate to contacts link
		hp.ClickOnContactLnk();
		
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactImg();
		
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.createNewContact(lastname, leadsource);

		//Step 9: Verify for contact
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.contactNameInfo();
		if(contactHeader.contains(lastname))
		{
			System.out.println(contactHeader +" contact created+");
		}
		else
		{
			System.out.println("Contact not created");
		}
		
		

}
	
	

}			
				