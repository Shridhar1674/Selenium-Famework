package Com.Crm.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyFilePractise
{
      @Test
      public void propertyFile() throws IOException
      {
    	  
      
	//Step 1: read the file
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
			
			//Step 2: Create Obj of Properties
			Properties pObj= new Properties();
		     pObj.load(fis);
			
			
			//Step 3:read the data
		     String URL = pObj.getProperty("url");
			
			
			//Verification
			System.out.println(URL);
}
}