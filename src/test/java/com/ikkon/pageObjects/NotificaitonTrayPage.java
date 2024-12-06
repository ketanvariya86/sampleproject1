package com.ikkon.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificaitonTrayPage {
	WebDriver driver;
	
	public NotificaitonTrayPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
		
	@FindBy(xpath = "//button[text()='View All']") public WebElement ViewAllButton;
	
	
	public boolean VerifyViewAllButton()
	{
		return ViewAllButton.isDisplayed();
	}
	
	public void ClickOnViewAllButton()
	{
		ViewAllButton.click();
	}
}
