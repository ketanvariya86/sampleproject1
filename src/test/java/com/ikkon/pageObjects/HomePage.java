package com.ikkon.pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	// 1. Create onject of webdriver
	WebDriver ldriver;
	
	// 2. Create constructor and it's name should be same as class name
	public HomePage(WebDriver rdriver) {
		ldriver = 	rdriver;	
		
		// needs to write for PageFactory
		
		PageFactory.initElements(rdriver, this);
	}

	//	If use page object mode needs to write below line for element locator.
	//	By LoginButton = By.xpath("//button[text()='Login']");
	
	// If use page factory then needs to write below line for element locator 
	@FindBy(xpath = "//button[text()='Login']") public WebElement LoginButton;
	
	
	public void ClickOnLogin() {
		try {
			// Needs to write below line for doing action when use page object model
			//	driver.findElement(LoginButton).click();
			
			// Needs to write below line for doing action when user page factory 
			LoginButton.click();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exceptions caught: " + e.getMessage());
		}
	}
}
