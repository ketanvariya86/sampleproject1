package com.ikkon.Test_cases;

//import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.ikkon.pageObjects.DashboardPage;
import com.ikkon.pageObjects.HomePage;
import com.ikkon.pageObjects.SignInPage;
import com.ikkon.pageObjects.UsersPage;

public class TC_DashboardPageTest extends BaseClass {

	
	
	
	// TC-03 : After login with Admin, verify all labels shown on Dashboard 	
	@Test(priority = 1)
	public void VerifyDashboardPageLabelsAfterAdminUserLogin() throws InterruptedException
	{
		logger.info("================== After login with Admin, verify all labels shown on Dashboard execution started ==================");
		HomePage Hpage = new HomePage(driver);
		Hpage.ClickOnLogin();
		logger.info("TC_DashboardPageTest: Login button clicked");
		
		SignInPage Spage = new SignInPage(driver);
		Spage.EnterEmailId();
		logger.info("TC_DashboardPageTest: EmailId is entered");
		
		Spage.EnterPassword();
		logger.info("TC_DashboardPageTest: Password is entered");
		
		Spage.ClickOnSubmitToLogin();
		logger.info("TC_DashboardPageTest: Submit button is clicked");
		
		Thread.sleep(5000);
		DashboardPage Dpage = new DashboardPage(driver);
		Dpage.VerifyTotalUsersLabel();
		logger.info("TC_DashboardPageTest: 'Total Users' count is exist/displayed on Dashboard Page");
		
		Dpage.VerifyActiveUsersLabel();
		logger.info("TC_DashboardPageTest: 'Active Users' count is exist/displayed on Dashboard Page");
		
		Dpage.VerifyInactiveUsersLabel();
		logger.info("TC_DashboardPageTest: 'Inactive Users' count is exist/displayed on Dashboard Page");
		
		Dpage.VerifyInfluencerUsersLabel();
		logger.info("TC_DashboardPageTest: 'Influencer Users' count is exist/displayed on Dashboard Page");
		
		
		Dpage.VerifyBrandUsersLabel();
		logger.info("TC_DashboardPageTest: 'Brand Users' count is exist/displayed on Dashboard Page");
		
		Dpage.VerifyAgenciesUsersLabel();
		logger.info("TC_DashboardPageTest: 'Agencies Users' count is exist/displayed on Dashboard Page");
		
		Dpage.VerifyInfluencerCampaignLabel();
		logger.info("TC_DashboardPageTest: 'Influencer Campaign' count is exist/displayed on Dashboard Page");
		
		Dpage.VerifyPendingLabel();
		logger.info("TC_DashboardPageTest: 'Pending' count is exist/displayed on Dashboard Page under Influencer campaign section");
		
		Dpage.VerifyRejectedLabel();
		logger.info("TC_DashboardPageTest: 'Reject' count is exist/displayed on Dashboard Page under Influencer campaign section");
		
		Dpage.VerifyInfluencerCampaignActiveLabel();
		logger.info("TC_DashboardPageTest: 'Active' label is exist/displayed on Dashboard page under Influencer Campaign section");
		
		Dpage.VerifyInfluencerCampaignCompletedLabel();
		logger.info("TC_DashboardPageTest: 'Completed' label is exist/displayed on Dashboard page under Influencer Campaign section");
		
		Dpage.VerifyUpcomingLabel();
		logger.info("TC_DashboardPageTest: 'Upcoming' label is exist/displayed on Dashboard page under Influencer campaign section");
		
		Dpage.VerifyCampaignAnalysisLabel();
		logger.info("TC_DashboardPageTest: 'Campaign Analysis' chart label is exist/displayed on Dashboard page");
		
		Dpage.VerifyDraftLabel();
		logger.info("TC_DashboardPageTest: 'Draft' label is exist/displayed on Dashboard page under campaign Analysis chart");
		
		Dpage.VerifyRequestsLabel();
		logger.info("TC_DashboardPageTest: 'Requist' label is exist/displayed on Dashboard page under campaign Analysis chart");
		
		Dpage.VerifyReviewLabel();
		logger.info("TC_DashboardPageTest: 'Review' label is exist/displayed on Dashboard page under campaign Analysis chart");
		
		Dpage.VerifyCampaignAnalysisCompletedLabel();
		logger.info("TC_DashboardPageTest: 'Completed' label is exist/displayed on Dashboard page under campaign Analysis chart");
		
		Dpage.VerifyCampaignAnalysisActiveLabel();
		logger.info("TC_DashboardPageTest: 'Active' label is exist/displayed on Dashboard page under campaign Analysis chart");
		
		Dpage.VerifyInactiveLabel();
		logger.info("TC_DashboardPageTest: 'Inactive' label is exist/displayed on Dashboard page under campaign Analysis chart");
		
		Dpage.VerifyInfluencerPlatformsAnalysisLabel();
		logger.info("TC_DashboardPageTest: 'Influencer Platform Analysis' chart label is exist/displayed on Dashboard page");
		
		Dpage.VerifyYouTubeLabel();
		logger.info("TC_DashboardPageTest: 'YouTube' label is exist/displayed on Dashboard page under Influencer Platform Analysis chart");
		
		Dpage.VerifyInstagramLabel();
		logger.info("TC_DashboardPageTest: 'Instagram' label is exist/displayed on Dashboard page under Influencer Platform Analysis chart");
		
		Dpage.VerifyTikTokLabel();
		logger.info("TC_DashboardPageTest: 'TikTok' label is exist/displayed on Dashboard page under Influencer Platform Analysis chart");
		
		Dpage.VerifySpotifyLabel();
		logger.info("TC_DashboardPageTest: 'Spotify' label is exist/displayed on Dashboard page under Influencer Platform Analysis chart");
	
		logger.info("================== After login with Admin, verify all labels shown on Dashboard execution completed ==================");
	}
	
	@Test (priority = 2)
	// TC: Click on "Total Users" from dashboard page and verify that "Users" page is opened with all users list
	public void VerifyAllUsersListByClickingOnTotalUsers() throws InterruptedException
	{
		logger.info("============== Click on 'Total Users' from dashboard page and verify that 'Users' page is opened with all users list test case execution started ===============");
		
		DashboardPage DPage = new DashboardPage(driver);
		DPage.DashboardTabClicked();
		logger.info("Dashboard tab clicked from left menu");
		
		DPage.TotalUsersClick();
		logger.info("TC_DashboardPageTest: Clicked on 'Total Users'");
		
		Thread.sleep(3000);
		UsersPage UPage = new UsersPage(driver);
		
		UPage.UsersPageListURLWithAllUsers();
		logger.info("TC_DashboardPageTest: Users list page is opened with all users list");
		logger.info("============== Click on 'Total Users' from dashboard page and verify that 'Users' page is opened with all users list test case execution completed ===============");
	}
	
	@Test(priority = 3)
	// TC : Click on 'Active Users' from dashboard page and verify that 'Users' page is opened including active users list
	public void VerifyActiveUsersListByClickingOnActiveUsers() throws InterruptedException
	{
		logger.info("============== Click on 'Active Users' from dashboard page and verify that 'Users' page is opened including active users list test case execution started ===============");
		
		DashboardPage DPage = new DashboardPage(driver);
		DPage.DashboardTabClicked();
		logger.info("Dashboard tab clicked from left menu");
		Thread.sleep(5000);
		
		DPage.ActiveUsersClick();
		logger.info("TC_DashboardPageTest: Clicked on 'Active Users'");
		
		Thread.sleep(3000);
		UsersPage UPage = new UsersPage(driver);
		
		UPage.UsersPageListURLWithAllUsers();
		logger.info("TC_DashboardPageTest: Users list page is opened with all users list");
		logger.info("============== Click on 'Active Users' from dashboard page and verify that 'Users' page is opened including active users test case execution completed ===============");
	}
	
	@Test(priority = 4)
	// TC : Click on 'Inactive Users' from dashboard page and verify that 'Users' page is opened including inactive users list
	public void VerifyInactiveUsersListByClickingOnInactiveUsers() throws InterruptedException
	{
		logger.info("============== Click on 'Inactive Users' from dashboard page and verify that 'Users' page is opened including active users list test case execution started ===============");
		
		DashboardPage DPage = new DashboardPage(driver);
		DPage.DashboardTabClicked();
		logger.info("Dashboard tab clicked from left menu");
		Thread.sleep(5000);
		
		DPage.InactiveUsersClick();
		logger.info("TC_DashboardPageTest: Clicked on 'Inactive Users'");
		
		Thread.sleep(3000);
		UsersPage UPage = new UsersPage(driver);
		
		UPage.UsersPageListURLWithAllUsers();
		logger.info("TC_DashboardPageTest: Users list page is opened with all inactive users list");
		logger.info("============== Click on 'Inactive Users' from dashboard page and verify that 'Users' page is opened including inactive users test case execution completed ===============");
	}
	
	@Test(priority = 5)
	// TC : Click on 'Influencer Users' from dashboard page and verify that 'Users' page is opened with influencer users list
	public void VerifyInfluencerUsersListByClickingOnInfluencerUsers() throws InterruptedException
	{
		logger.info("============== Click on 'Influencer Users' from dashboard page and verify that 'Users' page is opened with influencer users list test case execution started ===============");
		
		DashboardPage DPage = new DashboardPage(driver);
		DPage.DashboardTabClicked();
		logger.info("Dashboard tab clicked from left menu");
		Thread.sleep(5000);
		
		DPage.InfluencerUsersClick();;
		logger.info("TC_DashboardPageTest: Clicked on 'Influencer Users'");
		
		Thread.sleep(3000);
		UsersPage UPage = new UsersPage(driver);
		
		UPage.UsersPageListURLWithInfluencerUsers();
		logger.info("TC_DashboardPageTest: Users list page is opened with all influencer users list");
		logger.info("============== Click on 'Influencer Users' from dashboard page and verify that 'Users' page is opened with all influencer users test case execution completed ===============");
	}


	@Test (priority = 6)
	// TC : Click on 'Brand Users' from dashboard page and verify that 'Users' page is opened with brand users list

	public void VerifyBrandUsersListByClickingOnBrandUsers() throws InterruptedException
	{
		logger.info("============== Click on 'Brand Users' from dashboard page and verify that 'Users' page is opened with brand users list test case execution started ===============");
		
		DashboardPage DPage = new DashboardPage(driver);
		DPage.DashboardTabClicked();
		logger.info("Dashboard tab clicked from left menu");
		Thread.sleep(5000);
		
		DPage.BrandUsersClick();;
		logger.info("TC_DashboardPageTest: Clicked on 'Brand Users'");
		
		Thread.sleep(3000);
		UsersPage UPage = new UsersPage(driver);
		
		UPage.UsersPageURLWithBrandUsers();
		logger.info("TC_DashboardPageTest: Users list page is opened with all Brand users list");
		logger.info("============== Click on 'Brand Users' from dashboard page and verify that 'Users' page is opened with all brand users test case execution completed ===============");
	}

	@Test (priority = 7)
	// TC : Click on 'Influencer Users' from dashboard page and verify that 'Users' page is opened with influencer users list
	
	public void VerifyAgencyUsersListByClickingOnBrandUsers() throws InterruptedException
	{
		logger.info("============== Click on 'Brand Users' from dashboard page and verify that 'Users' page is opened with agency users list test case execution started ===============");
		
		DashboardPage DPage = new DashboardPage(driver);
		DPage.DashboardTabClicked();
		logger.info("Dashboard tab clicked from left menu");
		Thread.sleep(5000);
		
		DPage.AgencyUsersClick();
		logger.info("TC_DashboardPageTest: Clicked on 'Brand Users'");
		
		Thread.sleep(3000);
		UsersPage UPage = new UsersPage(driver);
		
		UPage.UsersPageURLWithAgencyUsers();
		logger.info("TC_DashboardPageTest: Users list page is opened with all Agency users list");
		logger.info("============== Click on 'Agency Users' from dashboard page and verify that 'Users' page is opened with all agency users test case execution completed ===============");
	}

}
