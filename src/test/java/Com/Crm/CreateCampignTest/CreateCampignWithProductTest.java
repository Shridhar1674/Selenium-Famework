package Com.Crm.CreateCampignTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.testng.annotations.Test;

public class CreateCampignWithProductTest 
{
	@Test
	
	public void createCampignWithProdTest() throws Throwable
	{
/*ganerate random numbers*/
		Random ran = new Random();
		int random = ran.nextInt();
		
		/*read all the data*/
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		
		
		
		
		
		
		
	}

}
