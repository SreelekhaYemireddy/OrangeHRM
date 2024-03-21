package com.qa.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Adminpage {
	
	//xpaths
	@FindBy(xpath = "//div[@class='orangehrm-header-container']/button[@type='button']")
	WebElement addbtn;
	
	@FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active']/div[@class='oxd-select-text-input'])[1]")
	WebElement role;
	
	@FindBy(xpath = "//label[text()='Status']/../..//div[@class='oxd-select-text-input']")
	WebElement status;
	
	@FindBy(xpath= "//input[@placeholder='Type for hints...']")
	WebElement empname;
	
	@FindBy(xpath="//label[text()='Username']/../../div//input[@class='oxd-input oxd-input--active']")
	WebElement username;

	@FindBy(xpath= "(//input[@type='password'])[1]/../..//input[@class='oxd-input oxd-input--active']")
	WebElement password;
	
	@FindBy(xpath= "//label[text()='Confirm Password']/../..//input[@class='oxd-input oxd-input--active']")
	WebElement confirmpwd;

	@FindBy(xpath="//button[@type='submit']")
	WebElement savebtn;
	
	
	
	
	
}
