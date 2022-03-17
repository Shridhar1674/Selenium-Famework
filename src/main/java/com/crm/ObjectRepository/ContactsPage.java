package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage 
{
	//declaration
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createContactLookImg;
	
	//Initialization
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getCreateContactLookImg() 
	{
		return createContactLookImg;
	}
	
	//Business library
	public void clickOnCreateContactImg()
	{
		createContactLookImg.click();
	}
}
