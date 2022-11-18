package com.mystorepageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass
{
	Action action=new Action();
	
	@FindBy(xpath="//li[@class='lnk_wishlist']//span")
	private WebElement myWishList;
	
	@FindBy(xpath="//a[@title='Orders']//span")
	private WebElement orderHistory;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateMyWishList()
	{
		action.fluentWait(driver, myWishList, 10);
		return action.isDisplayed(driver, myWishList);
	}
	
	public boolean validateOrderHistory()
	{
		return action.isDisplayed(driver, orderHistory);
	}
	
//	public String getCurrentUrl()
//	{
//		String homePageUrl=driver.getCurrentUrl();
//		return homePageUrl;
//	}
}
