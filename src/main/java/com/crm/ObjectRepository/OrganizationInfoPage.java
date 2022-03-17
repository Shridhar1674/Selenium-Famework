package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage 
{
	//Step 1:Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement OnCreateOrgImg;
	
	//Step 2: initialization
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Step 3: utilization

	public WebElement getHeaderText() {
		return headerText;
	}
	//business library
		public String OrgNameInfo()
		{
			 String orgInfo = headerText.getText();
			 return orgInfo;
		}

		public void setHeaderText(WebElement headerText) {
			this.headerText = headerText;
		}

		public void ClickOnCreateOrgImg() {
			// TODO Auto-generated method stub
			
		}
		
}
