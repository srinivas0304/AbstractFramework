package com.mystore.actionInterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ActionInterface 
{
	//added all user actions abstract methods to achieve abstraction
	
	public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele);
	public void click(WebDriver driver, WebElement ele, String path);
	public boolean isDisplayed(WebDriver driver, WebElement ele);
	public boolean type(WebElement ele, String text);
	public boolean findElement(WebDriver driver, WebElement ele);
	public void imlicitWait(WebDriver driver, int timeOut);
	public void explicitWait(WebDriver driver, WebElement ele, int timeOut);
	public String getTitle(WebDriver driver);
	public boolean selectByVisibleText(String visibleText, WebElement ele);
	public boolean JSClick(WebDriver driver, WebElement ele) throws Exception;
	public void fluentWait(WebDriver driver,WebElement element, int timeOut);
	
}
