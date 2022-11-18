package com.mystorepageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass
{
	Action action=new Action();
	
	@FindBy(xpath = "//td[@class='cart_unit']/span/span")
	private WebElement unitPrice;

	@FindBy(id = "total_price")
	private WebElement totalPrice;

	@FindBy(xpath="(//a[@title='Proceed to checkout'])[2]")
	private WebElement proceedToCheckOutBtn;

	public OrderPage() 
	{
		PageFactory.initElements(driver, this);
	}

	public double getUnitPrice() 
	{
		String unitPrice1 = unitPrice.getText();
		String unit = unitPrice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalUnitPrice = Double.parseDouble(unit);
		return finalUnitPrice / 100;
	}

	public double getTotalPrice() 
	{
		String totalPrice1 = totalPrice.getText();
		String tot = totalPrice1.replaceAll("[^a-zA-Z0-9]", "");
		double finalTotalPrice = Double.parseDouble(tot);
		return finalTotalPrice/100;
	}

	public LoginPage clickOnCheckOut() throws Throwable 
	{
		//Action.scrollByVisibilityOfElement(driver, proceedToCheckOutBtn);
		//Action.fluentWait(driver, proceedToCheckOutBtn, 10);
		//Action.JSClick(driver, proceedToCheckOutBtn);
		Thread.sleep(5000);
		action.click(driver, proceedToCheckOutBtn,"(//a[@title='Proceed to checkout'])[2]");
		return new LoginPage();
	}
}
