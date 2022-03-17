package Com.Crm.Practice;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromSuiteXMLfileTest {
	
	@Test
	
	public void readDataFromXML(XmlTest xml)
	{
		String BROWSER = xml.getParameter("browser");
		String URL=xml.getParameter("url");
		String USERNAME=xml.getParameter("username");
		String PASSWORD=xml.getParameter("password");

		
		
	}
	
}
