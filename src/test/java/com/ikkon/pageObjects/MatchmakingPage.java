package com.ikkon.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MatchmakingPage {
	WebDriver ldriver;
	
	public MatchmakingPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//h4[text()='Find Perfect Match']") 
	WebElement FindPerfectMatchLabel;
	
	public boolean verifyFindPerfectMatchLabel()
	{
		return FindPerfectMatchLabel.getText().equals("Find Perfect Match/");
	}
	
	
}
