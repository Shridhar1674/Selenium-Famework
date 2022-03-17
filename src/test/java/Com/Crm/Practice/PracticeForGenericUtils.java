package Com.Crm.Practice;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;

public class PracticeForGenericUtils
{
	
	@Test
	
	public void practice() throws Throwable
	{
		JavaUtility jlib = new JavaUtility();
		int ran = jlib.getRandomNumber();
	    String dt = jlib.getSystemDate();
		String date = jlib.getSystemDateInFormate();
		System.out.println(ran + date);
		System.out.println(date);
		
		PropertyFileUtility plib = new PropertyFileUtility();
		String brows = plib.readDataFromPropertyFile("browser");
		System.out.println(brows);
		
	}

}
