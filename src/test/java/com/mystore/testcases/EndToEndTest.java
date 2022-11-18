package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.mystore.base.BaseClass;
import com.mystorepageobjects.AddToCartPage;
import com.mystorepageobjects.AddressPage;
import com.mystorepageobjects.HomePage;
import com.mystorepageobjects.IndexPage;
import com.mystorepageobjects.LoginPage;
import com.mystorepageobjects.OrderConfirmationPage;
import com.mystorepageobjects.OrderPage;
import com.mystorepageobjects.OrderSummaryPage;
import com.mystorepageobjects.PaymentPage;
import com.mystorepageobjects.SearchResultPage;
import com.mystorepageobjects.ShippingPage;

public class EndToEndTest extends BaseClass
{
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCart;
	OrderPage orderPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummaryPage;
	OrderConfirmationPage orderConfirmationPage;
	
	
	@Test(groups = "Regression")
	public void endToEndTest() throws Throwable
	{
		indexPage=new IndexPage();
		searchResultPage=indexPage.searchProduct("shirt");
		addToCart=searchResultPage.clickOnProduct();
		addToCart.enterQuantity("2");
		addToCart.selectSize("M");
		addToCart.clickOnAddToCart();
		orderPage=addToCart.clickOnCheckOut();
		loginPage=orderPage.clickOnCheckOut();
		addressPage=loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
		shippingPage=addressPage.clickToCheckOut();
		shippingPage.clickOnCheckBox();
		paymentPage=shippingPage.clickOnCheckoutBtn();
		orderSummaryPage=paymentPage.clickOnPayment();
		orderConfirmationPage=orderSummaryPage.clickOnConfirmOrder();
		String actualMessage=orderConfirmationPage.validateConfirmMessage();
		String expectedMessage="Your order on My Store is complete.";
		Assert.assertEquals(actualMessage, expectedMessage);
		
	}
}
