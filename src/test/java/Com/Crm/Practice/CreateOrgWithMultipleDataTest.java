package Com.Crm.Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;

public class CreateOrgWithMultipleDataTest
{
	    //Create Obj for all utilities
		PropertyFileUtility plib = new PropertyFileUtility();
		ExcelFileUtility elib = new ExcelFileUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		JavaUtility jlib = new JavaUtility();
		
		@Test(dataProvider = "OrgtestData")
		public void createOrgWithMltipleData(String orgName, String indType) throws Throwable
		{
			//read data 
			String BROWSER = plib.readDataFromPropertyFile("browser");
			String URL = plib.readDataFromPropertyFile("url");
			String USERNAME = plib.readDataFromPropertyFile("username");
			String PASSWORD = plib.readDataFromPropertyFile("password");
			
			String orgname = orgName+jlib.getRandomNumber();
		
			//launch the application
			WebDriver driver = null;
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("FIREFOX"))
			{
				driver = new FirefoxDriver();
			}
			else
			{
				System.out.println("invalid browser");
			}
			
			wlib.maximizeWindow(driver);
			wlib.waitForPageLoad(driver);
			driver.get(URL);
			
			//login to application
			LoginPage lp = new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
			Reporter.log("login successful",true);
			
			//navigate to organization
			HomePage hp = new HomePage(driver);
			hp.ClickOnContactLnk();
			Reporter.log("Navigated to Organization", true);
			
			//create Org
			OrganizationInfoPage op = new OrganizationInfoPage(driver);
		    op.ClickOnCreateOrgImg();
			Reporter.log("click on create org link",true);
			
			//create new org
			CreateOrganizationPage cop = new CreateOrganizationPage(driver);
			cop.createNewOrg(orgname);
			Reporter.log("create org with industry type",true);
			
			//validate
			OrganizationInfoPage oip = new OrganizationInfoPage(driver);
			String actHeader = oip.OrgNameInfo();
			if (actHeader.contains(orgname)) {
				System.out.println("passed");
			}
			else
			{
				System.out.println("failed");
			}
			Reporter.log("verification successful",true);		
			
			//logout
			hp.signOutOfApp(driver);
			driver.quit();
		}
		
		@DataProvider(name = "OrgtestData")
		public Object[][] getData() throws Throwable
		{
			Object[][] data = elib.readmultipleDataFromExcel("OrgMultipleData");
			return data;
		}

}
