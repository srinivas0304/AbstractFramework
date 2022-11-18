package com.captureScreenshot;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot
{
	public static String capture(WebDriver driver, String fileName) throws Exception 
	{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		//TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination = new File (System.getProperty("user.dir") + ".\\Screenshots\\" + fileName + "_" + dateName + ".jpg");
		//File finalDestination = new File(destination);
		FileUtils.copyFile(source, destination);
		return destination.getAbsolutePath();
	}

	public static String getCurrenTime()
	{
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}
}
