package com.logs;

import org.testng.log4testng.Logger;

public class Log 
{
	//initialize log4j logs
	
	public static Logger log=Logger.getLogger(Log.class);
	
	public static void startTestCase(String sTestCaseName)
	{
		log.info("-------------"+sTestCaseName+"Test Start --------------");
	}
	public static void endTestCase(String eTestCaseName)
	{
		log.info("--------------"+eTestCaseName+"End Test--------------");
	}
	
	//Need to create below methods so that they can called
	
	public static void info(String infoMessage)
	{
		log.info(infoMessage);
	}
	
	public static void warn(String warnMessage)
	{
		log.warn(warnMessage);
	}
	
	public static void error(String errorMessage)
	{
		log.error(errorMessage);
	}
	
	public static void fatal(String fatalMessage)
	{
		log.fatal(fatalMessage);
	}
}
