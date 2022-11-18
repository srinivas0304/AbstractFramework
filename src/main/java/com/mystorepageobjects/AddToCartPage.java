package com.mystorepageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass
{
	Action action=new Action();
	
	@FindBy(id="quantity_wanted")
	private WebElement quantity;
	
	@FindBy(name="group_1")
	private WebElement size;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="//div[@class='layer_cart_product col-xs-12 col-md-6']//h2")
	private WebElement addToCartMessage;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOutBtn;
	
	public AddToCartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterQuantity(String quantity1)
	{
		action.type(quantity, quantity1);
	}
	
	public void selectSize(String size1)
	{
		action.selectByVisibleText(size1, size);
	}
	
	public void clickOnAddToCart() throws InterruptedException
	{
		action.click(driver, addToCartBtn,"//span[text()='Add to cart']");
	}
	public boolean validateAddToCart() throws InterruptedException
	{
		action.fluentWait(driver, addToCartMessage, 10);
		return action.isDisplayed(driver, addToCartMessage);
	}
	
	public OrderPage clickOnCheckOut() throws Exception
	{
		action.fluentWait(driver, proceedToCheckOutBtn, 10);
		action.JSClick(driver, proceedToCheckOutBtn);
		return new OrderPage();
	}
	
}
