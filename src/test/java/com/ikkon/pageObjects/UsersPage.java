package com.ikkon.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class UsersPage {
	WebDriver ldriver;
	
	public UsersPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver,this);
	}
	
	
	@FindBy(xpath = "//h4[text()='Users']") public WebElement UsersLabel; 
	
	public void UsersPageListURLWithAllUsers()
	{
		String currentPageUrl;
		String expectedPageUrl = "https://ikkon.ae/user/:all";
		currentPageUrl = ldriver.getCurrentUrl();
		System.out.println("Current Page URL = " + currentPageUrl);
		Assert.assertEquals(currentPageUrl,expectedPageUrl);
	}
	
	public void UsersPageListURLWithInfluencerUsers()
	{
		String currentPageUrl;
		String expectedPageUrl = "https://ikkon.ae/user/:influencer";
		currentPageUrl = ldriver.getCurrentUrl();
		Assert.assertEquals(currentPageUrl, expectedPageUrl);
	}
	
	public void UsersPageURLWithBrandUsers()
	{
		String currentPageUrl = ldriver.getCurrentUrl();
		String expectedPageUrl = "https://ikkon.ae/user/:brand";
		Assert.assertEquals(currentPageUrl,expectedPageUrl);
	}
	
	public void UsersPageURLWithAgencyUsers()
	{
		String currentPageUrl = ldriver.getCurrentUrl();
		String expectedPageUrl = "https://ikkon.ae/user/:agency";
		Assert.assertEquals(currentPageUrl,expectedPageUrl);
	}
	
	public boolean VerifyUsersLabel()
	{
		return UsersLabel.getText().equals("Users");
	}
	
}
