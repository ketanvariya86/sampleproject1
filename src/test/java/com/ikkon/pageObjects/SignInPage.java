package com.ikkon.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	//1. Create an web driver local object
	WebDriver ldriver;
	
	//2. Create a constructor and pass web driver as an argument
	public SignInPage(WebDriver rdriver) {
		this.ldriver = rdriver;
		//Call PageFactory.initElements method for Pagefactory as below
		PageFactory.initElements(rdriver, this);
	}
	
	
	// Identify WebElement for SignInPage
	@FindBy(xpath = "//h3[text()=\"Sign in to IKKON\"]") public WebElement SignInPageName;
	
	
	// Get page name action
	public String GetPageName() {
		String pagename = SignInPageName.getText();
		return pagename;
	}
	
}
