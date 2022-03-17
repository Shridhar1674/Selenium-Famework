package com.crm.GenericLibrary;

import java.awt.Robot;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consist of all generic methods related to WebDriverAcion
 * @author acer
 *
 */
public class WebDriverUtility {
	
	private static final String KeyPress = null;
	private static final String VW_ENTER = null;
	private static final String KeyEvent = null;
	private static final String winId = null;

	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
/**
 * this method will wait for 20 seconds for the page to load	
 * @param driver
 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
/**
 * this method will wait for 10 seconds for the element to be clickable
 * @param driver
 * @param element
 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait Wait = new WebDriverWait(driver, 10);
		Wait.until(ExpectedConditions.visibilityOf(element));			
	}
	/**
	 * This method will wait for 20 seconds for the element to be visible
	 * @param driver
	 * @param element
	 */
	
	public void waitForElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will select the data from dropdown using index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element,int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * This method will select the data from dropdown using visible text
	 * @param element
	 * @param text
	 */
	public void select(WebElement element,String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * This method will select the data from the dropdown using value
	 * @param text
	 * @param element
	 */
	public void select(String text,WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByValue(text);
	}
	/**
	 * This method will perform mouse Hover action
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will perform drag and drop action 
	 * @param driver
	 * @param src
	 * @param target
	 */
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement target)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, target).perform();
	}
	
	/**
	 * This method will double click on the element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element);
	}
	
	/**
	 * This method will double click on Webpage
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This method will right click on webpage
	 * @param driver
	 */
	public void rightClick(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method will right click on element
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method will press enter Key
	 * @param driver
	 */
	public void enterKeyPress(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	
	/**
	 * This method will switch the frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will switch the frame based on name or ID
	 * @param driver
	 * @param nameorId
	 */
	public void switchToFrame(WebDriver driver,String nameorId)
	{
		driver.switchTo().frame(nameorId);
	}
	
	/**
	 * This method will switch the frame based on address of the element
	 * @param driver
	 * @param address
	 */
	public void switchToFrame(WebDriver driver,WebElement address)
	{
		driver.switchTo().frame(address);
	}
	/**
	 * this method will accept alert pop-up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * this method will cancel the alert pop-up
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * this method will switch to window depending on partiall window title
	 * @param driver
	 * @param partialWintitle
	 */
	public void switchToWindow(WebDriver driver, String partialWintitle)
	{
		 //Step 1: use getwindowHandles to capture all window ids
		 Set<String> windows = driver.getWindowHandles();
		 
		 //Step 2: iterate thru the windows
		 Iterator<String> it = windows.iterator();
		 
		 //Step 3: check whether there is next window
		 while(it.hasNext())
		 {
			 //Step 4: capture current window id
			 String winId = it.next();

		 //Step 5:switch to current window and capture title
		String currentWinTitle = driver.switchTo().window(winId).getTitle();
		
		//Step 6: check whether the current window is expected
		if(currentWinTitle.contains(partialWintitle))
		{
			break;
		}	
   }	
}
	/**
	 * this method will takeScreenshot and store it in folder called as screenshot
	 * @param driver
	 * @param screenShotName
	 * @throws IOException 
	 */
	public void getScreenShot(WebDriver driver,String screenShotName) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./Screenshot/"+screenShotName+".png");	
		FileUtils.copyFile(src, dst);
		
	 }
	/**
	 * this method perform randomm scroll
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)","");
	}
	public void waitforPageLoad(WebDriver driver) {
		// TODO Auto-generated method stub	
	}
}

