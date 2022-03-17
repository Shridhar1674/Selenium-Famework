package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage 
{
	//Step 1: Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactHeaderText;
	
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getContactHeaderText() {
		return contactHeaderText;
	}
	//Business library
	public String contactNameInfo()
	{
		return contactHeaderText.getText();
	}
}
