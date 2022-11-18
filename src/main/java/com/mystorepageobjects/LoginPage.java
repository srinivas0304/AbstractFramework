package com.mystorepageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass 
{

	Action action=new Action();
	
	@FindBy(id = "email")
	private WebElement username;

	@FindBy(name = "passwd")
	private WebElement password;

	@FindBy(xpath = "//button[@id='SubmitLogin']")
	private WebElement signInBtn;

	@FindBy(id = "email_create")
	private WebElement emailForNewAccount;

	@FindBy(xpath = "//i[@class='icon-user left']")
	private WebElement createNewAccountBtn;

	public LoginPage() 
	{
		PageFactory.initElements(driver, this);
	}

	public HomePage login(String uname, String pass) throws Exception
	{
		action.type(username, uname);
		action.type(password, pass);
		Thread.sleep(2000);
		action.click(driver, signInBtn,"//a[contains(text(),'Sign in')]");		
		return new HomePage();
	}

	public AddressPage login1(String uname, String pass) throws Exception 
	{
		action.type(username, uname);
		action.type(password, pass);
		Thread.sleep(2000);
		action.click(driver, signInBtn,"//button[@id='SubmitLogin']");
		//Thread.sleep(5000);
		return new AddressPage();
	}
	
	public AccountCreationPage createNewAccount(String newMail) 
	{
		action.type(emailForNewAccount, newMail);
		action.click(driver, createNewAccountBtn,"//i[@class='icon-user left']");
		return new AccountCreationPage();
	}
}
