package com.InBanking.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCust {
public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/V4/manager/Managerhomepage.php");
		driver.findElement(By.linkText("New Customer")).click();
		Thread.sleep(3000);
		System.out.println("clicked on login");
		
		driver.switchTo().frame("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0");
		System.out.println("Switched to frame 1");
		Thread.sleep(3000);
		driver.switchTo().frame("ad_iframe");
		System.out.println("Switched to frame 2");
		Thread.sleep(3000);
		driver.findElement(By.id("dismiss-button"));
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.findElement(By.name("name")).sendKeys("Rushikesh");
	}
}
