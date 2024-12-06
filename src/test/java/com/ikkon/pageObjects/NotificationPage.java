package com.ikkon.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationPage {
	WebDriver driver;
	public NotificationPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h4[text()='Notifications']") WebElement NotificationsLabel;
	
	public boolean VerifyNotificationsLabel()
	{
		return NotificationsLabel.getText().equals("Notifications");
	}
}
