package com.qa.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.automation.base.TestBase;

public class OrangeHrmLoginPage extends TestBase
{
	@FindBy(xpath = "//div[@class='orangehrm-login-slot-wrapper']//div[1]/div//input[@name='username']")
	WebElement orangeHRMUserName;

	@FindBy(xpath = "//div//input[@name='password']")
	WebElement orangeHRMPassword;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement loginBtn;
	
	public OrangeHrmLoginPage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void loginFunctionality()
	{
		orangeHRMUserName.sendKeys(prop.getProperty("userName"));
		test.log(Status.INFO,"Entered username is: "+prop.getProperty("userName"));
		orangeHRMPassword.sendKeys(prop.getProperty("password"));
		test.log(Status.INFO,"Entered password is: "+prop.getProperty("password"));
		loginBtn.click();
		test.log(Status.INFO,"Clicked login button successfully");
	}
	
	public void verifyLoginTitle()
	{
		String expectedTitle = "OrangeHRM";
		test.log(Status.INFO,"Expected title is: "+expectedTitle);
		String actualTitle = driver.getTitle();
		test.log(Status.INFO,"Actual title is: "+actualTitle);
		Assert.assertEquals(expectedTitle,actualTitle);
				
		
	}
}

