package com.mystorepageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AccountCreationPage extends BaseClass
{
	Action action=new Action();
	
	@FindBy(xpath="//h1[text()='Create an account']")
	private WebElement formTitle;
		
	public AccountCreationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateAccountCreatePage()
	{
		return action.isDisplayed(driver, formTitle);
	}
}
