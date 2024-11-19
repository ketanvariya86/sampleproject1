package com.ikkon.pageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	// Create local object of WebDriver
	WebDriver ldriver;

		public DashboardPage(WebDriver rdriver)
		{
			ldriver = rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
		
		public void VerifyDashboardPageURL()
		{
			String actualUrl = ldriver.getCurrentUrl();
			String expectedUrl = "https://ikkon.ae/dashboard";
			assertEquals(actualUrl,expectedUrl);
		}
		
}
