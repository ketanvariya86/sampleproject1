package com.ikkon.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SystemLogsPage {
	WebDriver driver;
	
	public SystemLogsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//h4[text()='System Logs']") public WebElement SystemLogLabel;

	public boolean VerifySystemLogsLabel()
	{
		return SystemLogLabel.getText().equals("System Logs");
	}
}
