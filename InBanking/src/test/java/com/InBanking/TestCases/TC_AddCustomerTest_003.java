package com.InBanking.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.InBanking.PageObjects.AddCustomerPage;
import com.InBanking.PageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		LoginPage lp = new LoginPage(driver);
		lp.setusername(username);
		logger.info("User name is provided");
		lp.setpassword(password);
		logger.info("Passsword is provided");
		lp.clicksubmit();
		logger.info("clicked on login");
		Thread.sleep(3000);

		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		Thread.sleep(3000);
		logger.info("clicked On AddNewCustomer");

		driver.switchTo().frame(0);
		driver.switchTo().frame("ad_iframe");
		driver.findElement(By.id("dismiss-button")).click();
		driver.switchTo().defaultContent();
		
		logger.info("providing customer details....");
		addcust.custName("Rushikesh");
		addcust.custgender("male");
		Thread.sleep(1000);
		addcust.custdob("31", "01", "1997");
		Thread.sleep(2000);
		addcust.custaddress("INDIA");
		addcust.custcity("Pune");
		addcust.custstate("Maharashtra");
		addcust.custpinno("410504");
		addcust.custtelephoneno("987890091");

		String email = randomestring() + "@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();

		Thread.sleep(3000);
		logger.info("validation started....");

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (res == true) {
			Assert.assertTrue(true);
			logger.info("test case passed....");
		} else {
			logger.info("test case failed....");
			captureScreenshot(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
	}
}
