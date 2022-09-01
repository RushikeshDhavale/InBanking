package com.InBanking.TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.InBanking.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void LoginTest() throws IOException, InterruptedException {
		logger.info("Url is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setusername(username);
		logger.info("Entered Username");
		lp.setpassword(password);
		logger.info("Entered Password");
		Thread.sleep(1000);
		lp.clicksubmit();
		logger.info("Clicked on submit");
		Thread.sleep(3000);
		
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			logger.info("Login Test Passed");
			Assert.assertTrue(true);
			Thread.sleep(2000);
		} else {
			logger.info("Login Test failed");
			captureScreenshot(driver, "LoginTest");
			Assert.assertTrue(false);
			Thread.sleep(2000);
		}
	}

}
