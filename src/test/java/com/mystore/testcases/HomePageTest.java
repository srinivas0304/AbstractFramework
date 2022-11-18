package com.mystore.testcases;

import org.testng.annotations.Test;
import com.mystore.base.BaseClass;
import com.mystorepageobjects.HomePage;
import com.mystorepageobjects.IndexPage;
import com.mystorepageobjects.LoginPage;

public class HomePageTest extends BaseClass
{
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Test(groups = "Smoke")
	public void wishListTest() throws Throwable
	{
		indexPage=new IndexPage();
		loginPage=indexPage.clickSign();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
//		boolean res=homePage.validateMyWishList();
//		Assert.assertTrue(res);	
	}
	
	@Test(groups = "Smoke")
	public void orderHistoryTest() throws Throwable
	{
		indexPage=new IndexPage();
		loginPage=indexPage.clickSign();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
//		boolean res=homePage.validateOrderHistory();
//		Assert.assertTrue(res);
	}
	
}
