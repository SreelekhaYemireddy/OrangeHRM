package com.qa.automation.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.stream.FileImageInputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestBase 
{
	public static WebDriver driver;
	public static Properties prop;
	public static ExtentTest test;
	public static ExtentReports extent;
	public static ExtentTest childTest;
	public static ExtentHtmlReporter htmlReporter;
	
	
	
	public void driverInitialization()
	{
		driver = new ChromeDriver();
		driver.get(prop.getProperty("appUrl"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("loadTime")), TimeUnit.SECONDS);
		
	}
	
	public void readPropertyFile()
	
	{
		try {
			FileInputStream propFile = new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
			prop = new Properties();
			prop.load(propFile);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	public void setExtentReport() {

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReports/OrangeHRMExtentReport.html");
		htmlReporter.config().setDocumentTitle("Orange HRM Automation Report");
		htmlReporter.config().setReportName("Regression Testing");
		htmlReporter.config().setTheme(Theme.DARK); // STANDARD

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("Host Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "Sreelekha");
	}
}
