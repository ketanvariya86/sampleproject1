package com.ikkon.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	WebDriver ldriver;
	
	public CampaignPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//h4[text()='Campaigns']") public WebElement CampaignLabel;
	
	public boolean VerifyCampignPage()
	{
		return CampaignLabel.getText().equals("Campaigns/");
	}
}
