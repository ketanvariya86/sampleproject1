package com.ikkon.Test_cases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.ikkon.pageObjects.DashboardPage;
import com.ikkon.pageObjects.HomePage;
import com.ikkon.pageObjects.SignInPage;

public class TC_SignInPageTest extends BaseClass {

	// TC-01 : Verify that Sign In page is opened or not
	@Test(priority = 1)	
	public void openSignInPage() throws InterruptedException {

		HomePage hpage = new HomePage(driver); 
		hpage.ClickOnLogin();
		logger.info("Login button clicked");
		Thread.sleep(1000);
		  
		SignInPage spage = new SignInPage(driver); 
		String pagename =spage.GetPageName(); 
		assertEquals("Sign in to IKKON", pagename);
		logger.info("SignIn page verified");
	}
	
	
	// TC-02 : Verify that Admin is able to sign in successfully with correct credentials	
	@Test (priority = 2)	
	public void signInWithAdmin()throws InterruptedException{
		HomePage hpage = new HomePage(driver);
		hpage.ClickOnLogin();
		logger.info("Login button clicked");
		Thread.sleep(1000);
		
		SignInPage spage = new SignInPage(driver);
		spage.EnterEmailId();
		logger.info("Admin user email address is entered");
		spage.EnterPassword();
		logger.info("Admin user password is entered");
		spage.ClickOnSubmitToLogin();
		logger.info("Submit button clicked");
		Thread.sleep(5000);
		
		DashboardPage dpage = new DashboardPage(driver);
		dpage.VerifyDashboardPageURL();
		logger.info("Admin User Logged In successfully");

	}
	
	// TC-03 : After login with Admin, verify all labels shown on Dashboard 	
	@Test(priority = 3)
	public void VerifyDashboardPageLabelsWithAdminUserLogin() throws InterruptedException
	{
		Thread.sleep(5000);
		DashboardPage dpage = new DashboardPage(driver);
		dpage.VerifyTotalUsersLabel();
		logger.info("'Total Users' count is exist/displayed on Dashboard Page");
		
		dpage.VerifyActiveUsersLabel();
		logger.info("'Active Users' count is exist/displayed on Dashboard Page");
		
		dpage.VerifyInactiveUsersLabel();
		logger.info("'Inactive Users' count is exist/displayed on Dashboard Page");
		
		dpage.VerifyInfluencerUsersLabel();
		logger.info("'Influencer Users' count is exist/displayed on Dashboard Page");
		
		
		dpage.VerifyBrandUsersLabel();
		logger.info("'Brand Users' count is exist/displayed on Dashboard Page");
		
		dpage.VerifyAgenciesUsersLabel();
		logger.info("'Agencies Users' count is exist/displayed on Dashboard Page");
		
		dpage.VerifyInfluencerCampaignLabel();
		logger.info("'Influencer Campaign' count is exist/displayed on Dashboard Page");
		
		dpage.VerifyPendingLabel();
		logger.info("'Pending' count is exist/displayed on Dashboard Page under Influencer campaign section");
		
		dpage.VerifyRejectedLabel();
		logger.info("'Reject' count is exist/displayed on Dashboard Page under Influencer campaign section");
		
		dpage.VerifyInfluencerCampaignActiveLabel();
		logger.info("'Active' label is exist/displayed on Dashboard page under Influencer Campaign section");
		
		dpage.VerifyInfluencerCampaignCompletedLabel();
		logger.info("'Completed' label is exist/displayed on Dashboard page under Influencer Campaign section");
		
		dpage.VerifyUpcomingLabel();
		logger.info("'Upcoming' label is exist/displayed on Dashboard page under Influencer campaign section");
		
		dpage.VerifyCampaignAnalysisLabel();
		logger.info("'Campaign Analysis' chart label is exist/displayed on Dashboard page");
		
		dpage.VerifyDraftLabel();
		logger.info("'Draft' label is exist/displayed on Dashboard page under campaign Analysis chart");
		
		dpage.VerifyRequestsLabel();
		logger.info("'Requist' label is exist/displayed on Dashboard page under campaign Analysis chart");
		
		dpage.VerifyReviewLabel();
		logger.info("'Review' label is exist/displayed on Dashboard page under campaign Analysis chart");
		
		dpage.VerifyCampaignAnalysisCompletedLabel();
		logger.info("'Completed' label is exist/displayed on Dashboard page under campaign Analysis chart");
		
		dpage.VerifyCampaignAnalysisActiveLabel();
		logger.info("'Active' label is exist/displayed on Dashboard page under campaign Analysis chart");
		
		dpage.VerifyInactiveLabel();
		logger.info("'Inactive' label is exist/displayed on Dashboard page under campaign Analysis chart");
		
		dpage.VerifyInfluencerPlatformsAnalysisLabel();
		logger.info("'Influencer Platform Analysis' chart label is exist/displayed on Dashboard page");
		
		dpage.VerifyYouTubeLabel();
		logger.info("'YouTube' label is exist/displayed on Dashboard page under Influencer Platform Analysis chart");
		
		dpage.VerifyInstagramLabel();
		logger.info("'Instagram' label is exist/displayed on Dashboard page under Influencer Platform Analysis chart");
		
		dpage.VerifyTikTokLabel();
		logger.info("'TikTok' label is exist/displayed on Dashboard page under Influencer Platform Analysis chart");
		
		dpage.VerifySpotifyLabel();
		logger.info("'Spotify' label is exist/displayed on Dashboard page under Influencer Platform Analysis chart");
	}
}
