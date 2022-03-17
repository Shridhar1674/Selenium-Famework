package Com.Crm.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeRetryAnalyser 
{
	@Test(retryAnalyzer = com.crm.GenericLibrary.ReteryAnalyserIMplementation.class)
	
	public void practiceRetry()
	{
		System.out.println("this is test 1");
		Assert.fail();
		System.out.println("this is passed");
	}

}
