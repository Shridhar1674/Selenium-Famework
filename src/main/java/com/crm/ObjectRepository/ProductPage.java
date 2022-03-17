package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage 
{
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement createProductsLookUpImg;
	
	public ProductPage(WebDriver driver)
	
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateProductsLookUpImg() {
		return createProductsLookUpImg;
	}
	
	//business library
	/**
	 * *
	 * This method will click on the Create prduct lookup img
	 */
	public void clickOnProductLookUpImg()
	{
		createProductsLookUpImg.click();
	}
}
    
