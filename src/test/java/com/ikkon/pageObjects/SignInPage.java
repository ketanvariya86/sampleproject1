package com.ikkon.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ikkon.utilities.ReadConfig;

public class SignInPage {
	//1. Create an web driver local object
	WebDriver ldriver;
	
	//2. Create a constructor and pass web driver as an argument
	public SignInPage(WebDriver rdriver) {
		this.ldriver = rdriver;
		//Call PageFactory.initElements method for Pagefactory as below
		PageFactory.initElements(rdriver, this);
	}
	
	
	// Identify WebElement 
	//SignInPage Identification
	@FindBy(xpath = "//h3[text()=\"Sign in to IKKON\"]") public WebElement SignInPageName;
	
	//Email Address Locator
	@FindBy(xpath = "//input[@id=\'email\']") WebElement Email;
	
	//Password Address Locator
	@FindBy(id = "password") WebElement Password;
	
	//Submit button Locator to login
	@FindBy(xpath = "//div[@class=\'MuiBox-root css-1hugnkq\']//button[@type=\'submit\']") WebElement LoginSubmit;
	
	// Get page name action
	public String GetPageName() {
		String pagename = SignInPageName.getText();
		return pagename;
	}
	
	
	// create a ReadConfig class object to read Email address and password
	ReadConfig readConfig = new ReadConfig();
	String email = readConfig.adminUserEmailId();
	public void EnterEmailId()
	{
		Email.sendKeys(email);
	}
	
	String password = readConfig.adminUserPassword();
	public void EnterPassword()
	{
		Password.sendKeys(password);
	}
	
	public void ClickOnSubmitToLogin()
	{
		LoginSubmit.click();
	}
}
