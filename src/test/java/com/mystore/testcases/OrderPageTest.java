package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.mystore.base.BaseClass;
import com.mystorepageobjects.AddToCartPage;
import com.mystorepageobjects.IndexPage;
import com.mystorepageobjects.LoginPage;
import com.mystorepageobjects.OrderPage;
import com.mystorepageobjects.SearchResultPage;

public class OrderPageTest extends BaseClass
{
	IndexPage indexPage;
	LoginPage loginPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCart;
	OrderPage orderPage;
	
	@Test(groups = "Regression")
	public void verifyTotalPrice() throws Exception
	{
		indexPage=new IndexPage();
		searchResultPage=indexPage.searchProduct("shirt");
		addToCart=searchResultPage.clickOnProduct();
		addToCart.enterQuantity("2");
		addToCart.selectSize("M");
		addToCart.clickOnAddToCart();
		orderPage=addToCart.clickOnCheckOut();
		Double unitPrice=orderPage.getUnitPrice();
		Double totalPrice=orderPage.getTotalPrice();
		Double totalExpectedPrice=(unitPrice*2)+2;
		Assert.assertEquals(totalPrice, totalExpectedPrice);	
	}
}
