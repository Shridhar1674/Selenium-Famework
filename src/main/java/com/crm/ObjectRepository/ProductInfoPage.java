package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductInfoPage {
	
	@FindBy(xpath = "///span[@class='lvHeaderText']")
	private WebElement productHeader;
	
	public ProductInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductHeader() {
		return productHeader;
	}
	
	//business library
    /**
     * this method will fetch the product header text
     * @return
     */
	public String productInfo()
	{
		String prodHeader = productHeader.getText();
		return prodHeader;
	}

}
