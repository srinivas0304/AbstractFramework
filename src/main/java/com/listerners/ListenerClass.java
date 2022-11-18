package com.listerners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.captureScreenshot.Screenshot;
import com.mystoreutility.ExtentUtility;

public class ListenerClass extends ExtentUtility implements ITestListener
{
	//Screenshot s=new Screenshot();
	@Override
	public void onTestStart(ITestResult result) 
	{
		test=extent.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test case pass ", ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		/*this is where i did mistake*/
		
//		if(result.getStatus()==ITestResult.FAILURE)
//		{
//			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"Test case failed", null));
//			test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+"red", null));
//			String pathScreenshot;
//			try 
//			{
//				pathScreenshot = Screenshot.capture(driver, result.getName());
//				test.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(pathScreenshot,result.getName()).build());
//				//test.fail("Screenshot attached"+MediaEntityBuilder.createScreenCaptureFromPath(pathScreenshot,result.getName()).build());
//			} catch (Exception e) 
//			{
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+"Test case failed", ExtentColor.RED));
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+"red", ExtentColor.RED));
		String pathScreenshot;
		try 
		{
			pathScreenshot = Screenshot.capture(driver, result.getName());
			test.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(pathScreenshot,result.getName()).build());
			//test.fail("Screenshot attached"+MediaEntityBuilder.createScreenCaptureFromPath(pathScreenshot,result.getName()).build());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	@Override
	public void onTestSkipped(ITestResult result) 
	{
		if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, "Skipped test case is: "+result.getName());
		}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) 
	{
	
	}

	@Override
	public void onStart(ITestContext context) 
	{
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		
	}
	
}
