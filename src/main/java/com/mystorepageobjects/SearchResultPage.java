package com.mystorepageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass
{
	Action action=new Action();
	
	@FindBy(xpath="//div[@class='product-image-container']//img[@title='Faded Short Sleeve T-shirts']")
	private WebElement productResult;
	
	public SearchResultPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean isProductAvailable()
	{
		return action.isDisplayed(driver, productResult);
	}
	
	public AddToCartPage clickOnProduct() throws InterruptedException
	{
		Thread.sleep(2000);
		action.click(driver, productResult,"//div[@class='product-image-container']//img[@title='Faded Short Sleeve T-shirts']");
		return new AddToCartPage();
	}
}
