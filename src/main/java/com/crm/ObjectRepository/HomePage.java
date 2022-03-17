package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class HomePage extends WebDriverUtility{
	//Step 1: Declaration
	@FindBy(linkText = "Organizations")
	private WebElement Organizationlnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement Contactslnk;
	
	@FindBy(linkText = "Products")
	private WebElement Productslnk;
	
	@FindBy(linkText = "More")
	private WebElement Morelnk;
	
	@FindBy(linkText = "Campaigns")
	private WebElement Campaignslnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorlnk;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutlnk;
	
	//Step 2: initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOrganizationlnk() {
		return Organizationlnk;
	}

	public WebElement getContactslnk() {
		return Contactslnk;
	}

	public WebElement getProductslnk() {
		return Productslnk;
	}

	public WebElement getMorelnk() {
		return Morelnk;
	}

	public WebElement getCampaignslnk() {
		return Campaignslnk;
	}

	public WebElement getAdministratorlnk() {
		return administratorlnk;
	}

	public WebElement getSignOutlnk() {
		return SignOutlnk;
	}
	
	//Business Library
	public void ClickOnOrgLnk()
	{
		Organizationlnk.click();
	}
	public void ClickOnContactLnk()
	{
		Contactslnk.click();
	}
	public void signOutOfApp(WebDriver driver)
	{
		mouseHover(driver, administratorlnk);
		SignOutlnk.click();
	}

}
