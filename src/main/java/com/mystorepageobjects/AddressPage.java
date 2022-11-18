package com.mystorepageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddressPage extends BaseClass
{
	Action action=new Action();
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	private WebElement proceedToCheckOut;
	
	public AddressPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public ShippingPage clickToCheckOut()
	{
		action.click(driver, proceedToCheckOut,"//span[text()='Proceed to checkout']");
		return new ShippingPage();
	}
}
