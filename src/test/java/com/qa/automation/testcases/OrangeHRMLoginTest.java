package com.qa.automation.testcases;

import java.io.IOException;

import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.qa.automation.base.TestBase;
import com.qa.automation.pages.OrangeHrmLoginPage;
import com.qa.automation.util.UtilFunctions;

public class OrangeHRMLoginTest extends TestBase {
	public void loginFunctionality() {
		test = extent.createTest("Orange HRM logim functionality");
		test.assignCategory("Regression test");

		OrangeHrmLoginPage login = new OrangeHrmLoginPage();
		login.loginFunctionality();
		login.verifyLoginTitle();
	}

	public void checkResult(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName() + "Test Failed");
			test.log(Status.FAIL, "Test case Failed is" + result.getThrowable());
			test.fail(MarkupHelper.createLabel(result.getName() + "Test case Failed", ExtentColor.RED));

			String screenshotPath = UtilFunctions.getScreenshot(result.getName());
			test.fail(result.getThrowable().getMessage(),
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			test.addScreenCaptureFromPath(screenshotPath);

		} else if (result.getStatus() == ITestResult.SKIP) {
			test.skip(MarkupHelper.createLabel(result.getName() + "Test case skipped", ExtentColor.YELLOW));
			test.skip(result.getThrowable());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.pass(MarkupHelper.createLabel("Test passed", ExtentColor.GREEN));
		}
	}

}
