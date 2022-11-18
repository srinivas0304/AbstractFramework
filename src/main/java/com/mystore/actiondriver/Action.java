package com.mystore.actiondriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mystore.actionInterface.ActionInterface;

public class Action implements ActionInterface
{
	@Override
	public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);

	}
	@Override
	public void click(WebDriver driver, WebElement ele, String path)
	{
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(path))).sendKeys(ele,Keys.ENTER).build().perform();
		
//		Actions act1 = new Actions(driver);
//		act1.moveToElement(ele1).click().build().perform();
		
	}
	@Override
	public boolean findElement(WebDriver driver, WebElement ele)
	{
		boolean flag=false;
		
		try
		{
			ele.isDisplayed();
			flag=true;
		}
		catch(Exception e)
		{
			flag =false;
		}
		finally
		{
			if(flag)
			{
				System.out.println("Successfully found element at");
			}
			else 
			{
				System.out.println("Unable to locate element at");
			}
		}
		return flag;
	}
	@Override
	public boolean isDisplayed(WebDriver driver, WebElement ele)
	{
		boolean flag=false;
		flag=findElement(driver,ele);
		if(flag)
		{
			flag=ele.isDisplayed();
			if(flag)
			{
				System.out.println("The element is displayed");
			}
			else
			{
				System.out.println("The element is not displayed");
			}	
		}
		else
		{
			System.out.println("Not displayed");
		}
		return flag;
	}
	@Override
	public boolean type(WebElement ele, String text)
	{
		boolean flag=false;
		try
		{
			flag =ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
			flag=true;
		}
		catch(Exception e)
		{
			System.out.println("Location not found");
		}
		finally
		{
			if(flag)
			{
				System.out.println("successfully entered value");
			}
			else 
			{
				System.out.println("unable to enter value");
			}
		}
		return flag;
	}
	@Override
	public void imlicitWait(WebDriver driver, int timeOut)
	{
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}
	@Override
	public void explicitWait(WebDriver driver, WebElement ele, int timeOut)
	{
		WebDriverWait wait=new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.visibilityOfAllElements(ele));
	}
	@Override
	public String getTitle(WebDriver driver)
	{
		boolean flag=false;
		
		String text =driver.getTitle();
		if(flag)
		{
			System.out.println("Title of the page is: \""+text+"\"");
		}
		return text;
	}
	@Override
	public boolean selectByVisibleText(String visibleText, WebElement ele)
	{
		boolean flag=false;
		try
		{
			Select s=new Select(ele);
			s.selectByVisibleText(visibleText);
			flag=true;
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			if(flag)
			{
				System.out.println("Option selected by visibletext");
			}
			else
			{
				System.out.println("Option not selected by visibletext");
			}
		}
	}
	@Override
	public boolean JSClick(WebDriver driver, WebElement ele) throws Exception
	{
		boolean flag=false;
		try
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", ele);
			
			flag =true;
		}
		catch(Exception e)
		{
			throw e;
		}
		finally
		{
			if(flag)
			{
				System.out.println("click action is performed");
			}
			else
			{
				System.out.println("click action is not performed");
			}
		}
		return flag;
	}
	@Override
	public void fluentWait(WebDriver driver,WebElement element, int timeOut)
	{
	    Wait<WebDriver> wait = null;
	    try {
	        wait = new FluentWait<WebDriver>((WebDriver) driver)
	        		.withTimeout(Duration.ofSeconds(20))
	        	    .pollingEvery(Duration.ofSeconds(2))
	        	    .ignoring(Exception.class);
	        wait.until(ExpectedConditions.visibilityOf(element));
	        element.click();
	    }catch(Exception e) {
	    }
	}
}
