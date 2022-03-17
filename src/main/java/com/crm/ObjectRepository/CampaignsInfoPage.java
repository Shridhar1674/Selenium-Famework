package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsInfoPage 
{
	@FindBy(xpath = "///span[@class='dvHeaderText']")
	private WebElement campaingHeader;

public void CampaignInfoPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getCampaingHeader() {
	return campaingHeader;
}
  //bussiness library
public String campaignInfo()
{
	String campaignHeaderName = campaingHeader.getText();
	return campaignHeaderName;
	
}
}

