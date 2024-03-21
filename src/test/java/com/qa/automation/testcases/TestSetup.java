package com.qa.automation.testcases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.qa.automation.base.TestBase;

public class TestSetup extends TestBase
{
	@BeforeSuite
	public void setUp()
	{
		readPropertyFile();
		driverInitialization();
		setExtentReport();
	}
	@AfterSuite
	public void tearDown()
	{
		extent.flush();
		driver.quit();
	}
}
