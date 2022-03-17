package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility
{
	//Step 1: Declaration
	@FindBy(name = "lastname")
	private WebElement lastnameEdt;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@alt='Select']")
	private WebElement orgNameLookUpImg;
	
	@FindBy(name = "leadsource")
	private WebElement leadSourceDropdown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(name = "leadsource")
	private WebElement leadsourceDropDown;


	//initialization
	public CreateContactPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

		
	//utilization
	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}

	public WebElement getOrgNameLookUpImg() {
		return orgNameLookUpImg;
	}

	public WebElement getLeadSourceDropdown() {
		return leadSourceDropdown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	public void setLeadSourceDropdown(WebElement leadSourceDropdown) {
		this.leadSourceDropdown = leadSourceDropdown;
	}
		
	//Business Library
	public void createNewContact( String lastname)
	{
		lastnameEdt.sendKeys(lastname);
		saveBtn.click();
	}
	
	public void createNewContact(String lastname, String leadSource)
	{
		lastnameEdt.sendKeys(lastname);
		select(leadSource, leadSourceDropdown);
		saveBtn.click();
	}
	
}
