package com.InBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "uid")
	WebElement txtusername;
	@FindBy(name = "password")
	WebElement txtpassword;
	@FindBy(name = "btnLogin")
	WebElement submit;
	@FindBy(linkText = "Log out")
	WebElement lnkLogout;

	public void setusername(String username) {
		txtusername.sendKeys(username);
	}

	public void setpassword(String password) {
		txtpassword.sendKeys(password);
	}

	public void clicksubmit() {
		submit.click();
	}

	public void clicklgout() {
		lnkLogout.click();
	}

}
