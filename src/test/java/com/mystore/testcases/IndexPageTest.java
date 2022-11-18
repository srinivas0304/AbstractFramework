package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.mystore.base.BaseClass;
import com.mystorepageobjects.IndexPage;

public class IndexPageTest extends BaseClass {
	IndexPage ip;

	@Test(groups = "Smoke")
	public void verifyLogo() {
		ip = new IndexPage();
		boolean res = ip.validateLogo();
		Assert.assertTrue(res);
	}

	@Test(groups = "Smoke")
	public void verifyTitle() {
		String title = ip.getMyStoreTitle();
		String exp = "My Store";
		Assert.assertEquals(title, exp);
	}

}
