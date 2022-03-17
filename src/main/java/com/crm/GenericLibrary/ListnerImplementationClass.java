package com.crm.GenericLibrary;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.streaming.SXSSFRow.FilledCellIterator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementationClass implements ITestListener {
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
	 String MethodName = result.getMethod().getMethodName();
	 test = report.createTest(MethodName);
	}

	public void onTestSuccess(ITestResult result) {
		 String MethodName = result.getMethod().getMethodName();
		 test.log(Status.PASS,MethodName+"----->passed");
		
	}

	public void onTestFailure(ITestResult result) {
		String path = null;
		 String MethodName = result.getMethod().getMethodName()+"-";
		 
	//Step 1: Configure screenshot name
		 String screenshotName = MethodName+new JavaUtility().getSystemDateInFormate();
		 System.out.println(screenshotName);
		 
		 //Step 2: using screenshot method from webDriver Utility
		 try {
			// new WebDriverUtility().getScreenShot(BaseClass.sDriver, screenshotName);
			 EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sDriver);
			 File src = eDriver.getScreenshotAs(OutputType.FILE);
			 //string pa = System.getProperties("user.dir")+"/Screenshot/"+screenshotName+".png";
			 path = "./Screenshot/"+screenshotName+".png";
			 File dst = new File(path);
			 FileUtils.copyFile(src, dst);
		 }catch (Throwable e) {
			 //TODO Auto-generated catch block
			 e.printStackTrace();
		 }
		 test.log(Status.FAIL, MethodName+"---->Failed");
		 //it will capture the exception and log it in the report
		 test.log(Status.FAIL, result.getThrowable());
		 test.addScreenCaptureFromPath(path);
	}

	public void onTestSkipped(ITestResult result) {
		 String MethodName = result.getMethod().getMethodName();
		 test.log(Status.SKIP, MethodName+"---> skipped");
		 //it will capture the exception and log it in the report
		 test.log(Status.SKIP, result.getThrowable());
	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	
	}

	public void onStart(ITestContext context) {
		
		//Execution will start here
		/*Configure the report*/
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtentReports/Report"+new JavaUtility().getSystemDate());
		htmlReport.config().setDocumentTitle("SDET-30 Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Selenium Execution Report");
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("basr url", "https://localhost8888");
		report.setSystemInfo("Reporter Name", "acer");
	}

	public void onFinish(ITestContext context) {
		
		//consolidate all the parameters and generate the report
		report.flush();
		
	}
	
}
