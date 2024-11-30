package com.ikkon.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {
	
	WebDriver ldriver;
	public MenuPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	// different tab objects/locators
	@FindBy(xpath = "//span[text()='Agency']") public WebElement AgencyTab;
	@FindBy(xpath = "//span[text()='Brand']") public WebElement BrandTab;
	@FindBy(xpath = "//span[text()='Campaign']") public WebElement CampaignTab;
	@FindBy(xpath = "//span[text()='Matchmaking']") public WebElement MatchmakingTab;
	@FindBy(xpath = "//span[text()='Users']") public WebElement UsersTab;
	@FindBy(xpath = "//span[text()='System Log']") public WebElement SystemLogTab;
	
	public void AgencyTabClicked()
	{
		AgencyTab.click();
	}
	
	public void BrandTabClicked()
	{
		BrandTab.click();
	}
	
	public void CampaignTabClicked()
	{
		CampaignTab.click();
	}
	
	public void MatchmakingTabClicked()
	{
		MatchmakingTab.click();
	}
	
	public void UsersTabClicked()
	{
		UsersTab.click();
	}
	
	public void SystemLogTabClicked()
	{
		SystemLogTab.click();
	}
}
