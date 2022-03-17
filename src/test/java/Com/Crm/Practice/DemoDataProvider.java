package Com.Crm.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoDataProvider 
{
	@Test (dataProvider = "getData")
	
	public void demoDataProvider(String Name, String Number)
	{
		System.out.println(Name+"----"+Number);
	}
	@DataProvider
	
	public Object[][] getData()
	{
		Object[][] obj = new Object[2][2];
				
		obj[0][0]="Shridhar";
		obj[0][1]="8310061360";
		
		obj[1][0]="Sagar";
		obj[1][1]="9741190906";
		
		return obj;
	}
}
