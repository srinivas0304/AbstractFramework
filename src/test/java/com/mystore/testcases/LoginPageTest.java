package com.mystore.testcases;

import org.testng.annotations.Test;
import com.mystore.base.BaseClass;
import com.mystorepageobjects.AddressPage;
import com.mystorepageobjects.HomePage;
import com.mystorepageobjects.IndexPage;
import com.mystorepageobjects.LoginPage;

public class LoginPageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	AddressPage addressPage;

	@Test(groups = { "Smoke", "Sanity" })
	public void loginTest() throws Throwable {
		indexPage = new IndexPage();
		loginPage = indexPage.clickSign();
		// homePage=loginPage.login(prop.getProperty("username"),
		// prop.getProperty("password"));
		addressPage = loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));

//		String actualUrl=addressPage.getCurrentUrl();	
//		String expectedUrl="http://automationpractice.com/index.php?controller=authentication&back=my-account";
//		String expectedUrl="http://automationpractice.com/index.php?controller=my-account";
//		Assert.assertEquals(actualUrl, expectedUrl);
	}
}
