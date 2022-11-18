package com.mystorepageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class ShippingPage extends BaseClass {
//	@FindBy(xpath="//input[@id='cgv']")
//	WebElement checkBox;
//	
//	@FindBy(xpath="//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
//	WebElement checkOutBtn;
//	
//	public ShippingPage()
//	{
//		PageFactory.initElements(driver, this);
//	}
//	
//	public void checkTheTerms() throws InterruptedException
//	{
//		Thread.sleep(2000);
//		Action.scrollByVisibilityOfElement(driver, checkBox);
//		Action.click(driver, checkBox,"//input[@id='cgv']");
//	}
//	
//	public PaymentPage clickOnProceedToCheckOut() throws Exception
//	{
//		Thread.sleep(2000);
//		Action.JSClick(driver, checkOutBtn);
//		//Action.click(driver, checkOutBtn,"//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]");
//		//checkOutBtn.click();
//		return new PaymentPage();
//	}

	@FindBy(id = "cgv")
	private WebElement checkBox;
	@FindBy(xpath = "//button/span[contains(text(),'Proceed to checkout')]")
	private WebElement checkOutBtn;
	@FindBy(xpath = "(//div[@id='columns']//a/i)[1]")
	private WebElement homeIcon;

	public ShippingPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnCheckBox() throws Exception {
		new Action().scrollByVisibilityOfElement(driver, homeIcon);
		new Action().JSClick(driver, checkBox);
	}

	public PaymentPage clickOnCheckoutBtn() {
		new Action().click(driver, checkOutBtn, "//button/span[contains(text(),'Proceed to checkout')]");
		return new PaymentPage();
	}

}
