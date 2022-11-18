package com.mystorepageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass
{
	Action action=new Action();
	
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	private WebElement signInBtn;
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	private WebElement myStorelogo;
	
	@FindBy(id="search_query_top")
	private WebElement searchBox;
	
	@FindBy(xpath="//button[@name='submit_search']")
	private WebElement submitBtn;
	
	
	public IndexPage()//constructor to initilization the values for above elements
	{
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickSign() 
	{
		action.fluentWait(driver, signInBtn, 10);
		action.click(driver, signInBtn,"//a[contains(text(),'Sign in')]");
		return new LoginPage();
	}
	
	public boolean validateLogo()
	{
		//System.out.println("verify logo");
		return action.isDisplayed(driver, myStorelogo);
	}
	
	public String getMyStoreTitle()
	{
		String myStroreTitle=driver.getTitle();
		return myStroreTitle;
	}
	
	public SearchResultPage searchProduct(String producyName)
	{
		action.type(searchBox, producyName);
		action.click(driver, submitBtn,"//button[@name='submit_search']");
		return new SearchResultPage();
	}
	
	
	
}
