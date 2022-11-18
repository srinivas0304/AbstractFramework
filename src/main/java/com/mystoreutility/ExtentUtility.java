package com.mystoreutility;

import java.io.File;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.mystore.base.BaseClass;

public class ExtentUtility extends BaseClass
{
	public static ExtentReports extent;
	public static ExtentTest test;
	//public static WebDriver driver;
	
	public static void extentUtility()
	{
		extent=new ExtentReports();
		File path=new File("MystoretestcasePass.html");
		ExtentSparkReporter sparkReport=new ExtentSparkReporter("./SparkReports/"+path);
		extent.attachReporter(sparkReport);
	}
	public static void flushMethod()
	{
		extent.flush();
	}
}
