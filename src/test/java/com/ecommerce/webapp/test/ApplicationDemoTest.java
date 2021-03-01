package com.ecommerce.webapp.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class ApplicationDemoTest {
	
	WebDriver driver;

	final String amazonSiteURL = "https://www.amazon.in/";

	final String chromeDriverPath = "/usr/bin/chromedriver";

	@Test(groups = "Chrome" ,priority=0)
	public void lauchChromeTest() {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver();
		driver.get(amazonSiteURL);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

	@Test(groups = "Chrome", dependsOnMethods = "lauchChromeTest", priority=1)
	void verifyAmazonHomePageTitle() {
		String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		System.out.println(Thread.currentThread().getId());
		assertEquals(driver.getTitle(), expected);
		
	}

	@Test(groups = "Chrome", dependsOnMethods = "lauchChromeTest",priority=2)
	void verifyAmazonHomePageSourceURL() {
		System.out.println(Thread.currentThread().getId());
		assertEquals(driver.getCurrentUrl(), amazonSiteURL);
		driver.close();
	}

}
