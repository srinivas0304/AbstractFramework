package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.mystore.base.BaseClass;
import com.mystorepageobjects.AddToCartPage;
import com.mystorepageobjects.IndexPage;
import com.mystorepageobjects.SearchResultPage;

public class AddToCartTest extends BaseClass {

	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCart;

	@Test(groups = { "Sanity", "Regression" })
	public void addToCart() throws Exception {
		indexPage = new IndexPage();
		searchResultPage = indexPage.searchProduct("shirt");
		addToCart = searchResultPage.clickOnProduct();
		addToCart.enterQuantity("2");
		addToCart.selectSize("M");
		addToCart.clickOnAddToCart();
		boolean res = addToCart.validateAddToCart();
		Assert.assertTrue(res);
	}
}
