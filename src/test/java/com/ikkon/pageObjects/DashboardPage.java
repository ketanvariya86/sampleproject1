package com.ikkon.pageObjects;

import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertTrue;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class DashboardPage {
	// Create local object of WebDriver
	WebDriver ldriver;

		public DashboardPage(WebDriver rdriver)
		{
			ldriver = rdriver;
			PageFactory.initElements(rdriver, this);
		}
	// Locators
		@FindBy(xpath = "//h6[text()='Total Users']") public WebElement TotalUsers;
		@FindBy(xpath = "//h6[text()='Active Users']") public WebElement ActiveUsers;
		@FindBy(xpath = "//h6[text()='Inactive Users']") public WebElement InactiveUsers;
	//	@FindBy(xpath = "//h6[text()=\'Influencer User's\']") public WebElement InfluencerUsers;
		@FindBy(xpath = "//div[@class='MuiBox-root css-3xl87r']") public WebElement InfluencerUsers;
		@FindBy(xpath = "//h6[text()='Brand Users']") public WebElement BrandUsers;
		@FindBy(xpath = "//h6[text()='Agencies Users']") public WebElement AgenciesUsers;
		@FindBy(xpath = "//h5[text()='Audio Influencer Campaign']") public WebElement InfluencerCampaign;
		@FindBy(xpath = "//p[text()='Pending']") public WebElement Pending;
		@FindBy(xpath = "//p[text()='Rejected']") public WebElement Rejected;
		@FindBy(xpath = "//p[text()='Active'][@class='MuiTypography-root MuiTypography-body1 css-1990hm5']") public WebElement InfluencerCampaignActive;
		@FindBy(xpath = "//div[@class = 'MuiBox-root css-6gplk5']//p[text()='Completed']") public WebElement InfluencerCampaignCompleted;
		@FindBy(xpath = "//p[text()='Upcoming']") public WebElement Upcoming;
		@FindBy(xpath = "//h5[text()='Campaign Analysis'] ") public WebElement CampaignAnalysis;
		@FindBy(xpath = "//p[text()='Draft']") public WebElement Draft;
		@FindBy(xpath = "//p[text()='Requests']") public WebElement Requests;
		@FindBy(xpath = "//p[text()='Review']") public WebElement Review;
		@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1op1nui'][text()='Completed']") public WebElement CampaignAnalysisCompleted;
		@FindBy(xpath = "//p[text()='Active'][@class='MuiTypography-root MuiTypography-body1 css-1op1nui']") public WebElement CampaignAnalysisActive;
		@FindBy(xpath = "//p[text()='Inactive']") public WebElement Inactive;
		@FindBy(xpath = "//h5[text()='Audio Influencer Platforms Analysis']") public WebElement InfluencerPlatformsAnalysis;
		@FindBy(xpath = "//p[text()='YouTube']") public WebElement YouTube;
		@FindBy(xpath = "//p[text()='Instagram']") public WebElement Instagram;
		@FindBy(xpath = "//p[text()='TikTok']") public WebElement TikTok;
		@FindBy(xpath = "//p[text()='Spotify']") public WebElement Spotify;
		@FindBy(xpath = "//div[@class='MuiBox-root css-759u60']") public WebElement profilename;
		@FindBy(xpath = "//li[text()='Logout']") public WebElement Logout;
		@FindBy(xpath = "//span[text()='Dashboard']") public WebElement DashboardTab;
		@FindBy(xpath = "//div[text()='Logged in successfully']") public WebElement LoggedInSuccessfullyMsg;
		
		public void VerifyDashboardPageURL()
		{
			String actualUrl = ldriver.getCurrentUrl();
			String expectedUrl = "https://ikkon.ae/dashboard";
			assertEquals(actualUrl,expectedUrl);
		}
		
		public void VerifyLoggedInSuccessfullyMsg()
		{
			String Msg = LoggedInSuccessfullyMsg.getText();
			assertEquals(Msg, "Logged in successfully");
		}
	
		/*
		 * public boolean VerifyTotalUsersLabel() { return TotalUsers.isDisplayed(); }
		 */
		
		public void VerifyTotalUsersLabel()
		{				
			try {
				Assert.assertTrue(TotalUsers.isDisplayed());
			} catch (NoSuchElementException e) {
					String errorMessage = "Total Users label is not displayed";
			        Reporter.log(errorMessage, true); // Logs the error in the TestNG report
			        Assert.fail(errorMessage);       // Fails the test with a custom message
					
			}
		}
		
		public boolean VerifyActiveUsersLabel()
		{
			return ActiveUsers.isDisplayed();
		}
		
		public boolean VerifyInactiveUsersLabel()
		{
			return InactiveUsers.isDisplayed();
		}
		
		public boolean VerifyInfluencerUsersLabel()
		{
			return InfluencerUsers.isDisplayed();
		}
		
		public boolean VerifyBrandUsersLabel()
		{
			return BrandUsers.isDisplayed();
		}
		
		public boolean VerifyAgenciesUsersLabel()
		{
			return AgenciesUsers.isDisplayed();
		}
		public boolean VerifyInfluencerCampaignLabel()
		{
			return InfluencerCampaign.isDisplayed();
		}
		
		public boolean VerifyPendingLabel()
		{
			return Pending.isDisplayed();
		}
		
		public boolean VerifyRejectedLabel()
		{
			return Rejected.isDisplayed();
		}
		
		public boolean VerifyInfluencerCampaignActiveLabel()
		{
			return InfluencerCampaignActive.isDisplayed();
		}
		
		public boolean VerifyInfluencerCampaignCompletedLabel()
		{
			return InfluencerCampaignCompleted.isDisplayed();
		}
		
		public boolean VerifyUpcomingLabel()
		{
			return Upcoming.isDisplayed();
		}
		
		public boolean VerifyCampaignAnalysisLabel()
		{
			return CampaignAnalysis.isDisplayed();
		}
		
		public boolean VerifyDraftLabel()
		{
			return Draft.isDisplayed();
		}
		
		public boolean VerifyRequestsLabel()
		{
			return Requests.isDisplayed();
		}
		
		public boolean VerifyReviewLabel()
		{
			return Review.isDisplayed();
		}
		
		public boolean VerifyCampaignAnalysisCompletedLabel()
		{
			return CampaignAnalysisCompleted.isDisplayed();
		}
		
		public boolean VerifyCampaignAnalysisActiveLabel()
		{
			return CampaignAnalysisActive.isDisplayed();
		}
		
		public boolean VerifyInactiveLabel()
		{
			return Inactive.isDisplayed();
		}
		
		public boolean VerifyInfluencerPlatformsAnalysisLabel()
		{
			return InfluencerPlatformsAnalysis.isDisplayed();
		}
		
		public boolean VerifyYouTubeLabel()
		{
			return YouTube.isDisplayed();			
		}
				
		public boolean VerifyInstagramLabel()
		{
			return Instagram.isDisplayed();
		}
		
		public boolean VerifyTikTokLabel()
		{
			return TikTok.isDisplayed();
		}
		
		public boolean VerifySpotifyLabel()
		{
			return Spotify.isDisplayed();
		}
		
		public void ProfileNameClick()
		{
			profilename.click();
		}
		
		public void LogoutClick()
		{
			Logout.click();
		}
		
		public void TotalUsersClick()
		{
			TotalUsers.click();
		}
		
		public void DashboardTabClicked()
		{
			DashboardTab.click();
		}
		
		public void ActiveUsersClick()
		{
			ActiveUsers.click();
		}
		
		public void InactiveUsersClick()
		{
			InactiveUsers.click();
		}
		
		public void InfluencerUsersClick()
		{
			InfluencerUsers.click();
		}
		
		public void BrandUsersClick()
		{
			BrandUsers.click();
		}
		
		public void AgencyUsersClick()
		{
			AgenciesUsers.click();
		}
}
