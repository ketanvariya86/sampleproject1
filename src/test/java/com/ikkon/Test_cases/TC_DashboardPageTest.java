package com.ikkon.Test_cases;

import java.io.IOException;

import org.testng.Assert;

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
		logger.info("TC_ashboardPageTest: Login button clicked");
		
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
	// TC: Click on "Total Users" from dashboard page and verify that "Users" page is opened with all users list ////and also match the total user count with the total listed users on the users list page.
	public void VerifyAllUsersListByClickingOnTotalUsers() throws InterruptedException, IOException
	{
		logger.info("============== Click on 'Total Users' from dashboard page and verify that 'Users' page is opened with all users list test case execution started ===============");
		
		DashboardPage DPage = new DashboardPage(driver);
		DPage.DashboardTabClicked();
		logger.info("Dashboard tab clicked from left menu");
		Thread.sleep(3000);
		
		DPage.TotalUsersClick();
		logger.info("TC_DashboardPageTest: Clicked on 'Total Users'");
		
		Thread.sleep(3000);
		UsersPage UPage = new UsersPage(driver);
		
		if(UPage.UsersPageListURLWithAllUsers() == true)
		{
			logger.info("All users list page is opened successfully by clicking on 'Total Users' link from Dashboard");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("All users list page is not opened successfully by clicking on 'Total Users' link from Dashboard");
			captureScreenShot(driver,"VerifyAllUsersListByClickingOnTotalUsers");			
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 3)
	// TC : Click on 'Active Users' from dashboard page and verify that 'Users' page is opened including active users list
	public void VerifyActiveUsersListByClickingOnActiveUsers() throws InterruptedException, IOException
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
		
		if(UPage.UsersPageListURLWithActiveUsers() == true)
		{
			logger.info("Active Users list page is opened with by clicking on Active users from Dashboard");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Active Users list page is not opened with by clicking on Active users from Dashboard");
			captureScreenShot(driver,"VerifyInactiveUsersListByClickingOnInactiveUsers");			
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority = 4)
	// TC : Click on 'Inactive Users' from dashboard page and verify that 'Users' page is opened including inactive users list
	public void VerifyInactiveUsersListByClickingOnInactiveUsers() throws InterruptedException, IOException
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

		if(UPage.UsersPageListURLWithInActiveUsers() == true)
		{
			logger.info("In-Active Users list page is opened by clicking on inactive users list from Dashboard");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("In-Active Users list page is not opened by clicking on inactive users list from Dashboard");
			captureScreenShot(driver,"VerifyInactiveUsersListByClickingOnInactiveUsers");			
			Assert.assertTrue(false);
		}
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
	
	public void VerifyAgencyUsersListByClickingOnAgencyUsers() throws InterruptedException
	{
		logger.info("============== Click on 'Brand Users' from dashboard page and verify that 'Users' page is opened with agency users list test case execution started ===============");
		
		DashboardPage DPage = new DashboardPage(driver);
		DPage.DashboardTabClicked();
		logger.info("Dashboard tab clicked from left menu");
		Thread.sleep(5000);
		
		DPage.AgencyUsersClick();
		logger.info("TC_DashboardPageTest: Clicked on 'Agencies Users'");
		
		Thread.sleep(3000);
		UsersPage UPage = new UsersPage(driver);
		
		UPage.UsersPageURLWithAgencyUsers();
		logger.info("TC_DashboardPageTest: Users list page is opened with all Agency users list");
		logger.info("============== Click on 'Agency Users' from dashboard page and verify that 'Users' page is opened with all agency users test case execution completed ===============");
	}
	
	@Test(priority = 8)
	//TC: Total Users shown on dashboard is match with the total listed users on the users page
	public void VerifyTotalUsersOnDashboardAndTotalListeadUsersOnUsersPage() throws InterruptedException, IOException
	{		
		DashboardPage Dpage = new DashboardPage(driver);
		Dpage.DashboardTabClicked();
		Thread.sleep(2000);
		Dpage.VerifyTotalUsersLabel();
		logger.info("'Total Users' count is exist/displayed on Dashboard Page");
		
		int TotalUserOnDashboardPage = Dpage.GetTotalUserCount();
		
		
		Dpage.TotalUsersClick();
		logger.info("Total Users count is clicked");
		Thread.sleep(2000);

		
		UsersPage UPage = new UsersPage(driver);
		int TotalUsers = UPage.GetTotalUsersFromTheUsersList();
		System.out.println("Total Users: " + TotalUsers);
		logger.info("Total Users : ", + TotalUsers);
		
		if(TotalUserOnDashboardPage == TotalUsers)
		{
			logger.info("Total Users shown on Dashboard is matched with total users listead on Users list page");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Total Users shown on Dashboard is not matched with total users listead on Users list page");
//			Dpage.DashboardTabClicked();
			captureScreenShot(driver,"VerifyTotalUsersOnDashboardAndTotalListeadUsersOnUsersPage");
			Assert.assertTrue(false);
		}
	}
	
	
	@Test(priority = 9)
	//TC: Total Active Users Count shown on dashboard is match with the total listed Active users on the users page
	public void VerifyActiveUsersCountOnDashboardAndTotalListeadActiveUsersOnUsersPage() throws InterruptedException, IOException
	{		
		DashboardPage Dpage = new DashboardPage(driver);
		Dpage.DashboardTabClicked();
		Thread.sleep(2000);
		Dpage.VerifyActiveUsersLabel();
		logger.info("'Active Users' count is exist/displayed on Dashboard Page");
		
		int TotalActiveUserOnDashboardPage = Dpage.GetTotalActiveUserCount();
		
		
		Dpage.ActiveUsersClick();
		logger.info("Clicked on 'Active Users'");
		Thread.sleep(2000);

		
		UsersPage UPage = new UsersPage(driver);
		int TotalUsers = UPage.GetTotalUsersFromTheUsersList();
		System.out.println("Total Active Users: " + TotalUsers);
		logger.info("Total Active Users : ", + TotalUsers);
		
		if(TotalActiveUserOnDashboardPage == TotalUsers)
		{
			logger.info("Total Active Users count shown on Dashboard is matched with total Active users listead on Users list page");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Total Active Users shown on Dashboard is not matched with total Active users listead on Users list page");
//			Dpage.DashboardTabClicked();
			captureScreenShot(driver,"VerifyActiveUsersCountOnDashboardAndTotalListeadActiveUsersOnUsersPage");
			Assert.assertTrue(false);
		}
	}
	
	
	@Test(priority = 10)
	//TC: Total In-Active Users Count shown on dashboard is match with the total listed In-Active users on the users page
	public void VerifyInActiveUsersCountOnDashboardAndTotalListeadInActiveUsersOnUsersPage() throws InterruptedException, IOException
	{		
		DashboardPage Dpage = new DashboardPage(driver);
		Dpage.DashboardTabClicked();
		Thread.sleep(2000);
		Dpage.VerifyInactiveUsersLabel();
		logger.info("In-Active Users' count is exist/displayed on Dashboard Page");
		
		int TotalInactiveUserOnDashboardPage = Dpage.GetTotalInActiveUserCount();
		
		
		Dpage.InactiveUsersClick();
		logger.info("Clicked on 'Inactive Users'");
		Thread.sleep(2000);

		
		UsersPage UPage = new UsersPage(driver);
		int TotalUsers = UPage.GetTotalUsersFromTheUsersList();
		System.out.println("Total Inactive Users: " + TotalUsers);
		logger.info("Total Inactive Users : ", + TotalUsers);
		
		if(TotalInactiveUserOnDashboardPage == TotalUsers)
		{
			logger.info("Total Inactive Users count shown on Dashboard is matched with total Inactive users listead on Users list page");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Total Inactive Users shown on Dashboard is not matched with total Inactive users listead on Users list page");
//			Dpage.DashboardTabClicked();
			captureScreenShot(driver,"VerifyInActiveUsersCountOnDashboardAndTotalListeadInActiveUsersOnUsersPage");
			Assert.assertTrue(false);
		}
	}
	
	
	@Test(priority = 11)
	//TC: Total Audio Influencers Count shown on dashboard is match with the total listed Audio Influencers on the users page
	public void VerifyAudioInfluencersCountOnDashboardAndTotalListeadAudioInfluencersOnUsersPage() throws InterruptedException, IOException
	{		
		DashboardPage Dpage = new DashboardPage(driver);
		Dpage.DashboardTabClicked();
		Thread.sleep(2000);
		Dpage.VerifyInfluencerUsersLabel();
		logger.info("'Audio Influencers' count is exist/displayed on Dashboard Page");
		
		int TotalAudioInfluencersOnDashboardPage = Dpage.GetTotalAudioInfluencersCount();
		
		
		Dpage.InfluencerUsersClick();
		logger.info("Clicked on 'Inactive Users'");
		Thread.sleep(2000);

		
		UsersPage UPage = new UsersPage(driver);
		int TotalUsers = UPage.GetTotalUsersFromTheUsersList();
		System.out.println("Total Audio Influencers: " + TotalUsers);
		logger.info("Total Audio Influencers : ", + TotalUsers);
		
		if(TotalAudioInfluencersOnDashboardPage == TotalUsers)
		{
			logger.info("Total Audio Influencers count shown on Dashboard is matched with total Audio Influencers listead on Users list page");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Total Audio Influencers count shown on Dashboard is not matched with total Audio Influencers listead on Users list page");
//			Dpage.DashboardTabClicked();
			captureScreenShot(driver,"VerifyAudioInfluencersCountOnDashboardAndTotalListeadAudioInfluencersOnUsersPage");
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 12)
	//TC: Total Brand Users Count shown on dashboard is match with the total listed Brand users on the users page
	public void VerifyBrandUsersCountOnDashboardAndTotalListeadBrandUsersOnUsersPage() throws InterruptedException, IOException
	{		
		DashboardPage Dpage = new DashboardPage(driver);
		Dpage.DashboardTabClicked();
		Thread.sleep(2000);
		Dpage.VerifyBrandUsersLabel();
		logger.info("'Brand Users' count is exist/displayed on Dashboard Page");
		
		int TotalBrandUsersOnDashboardPage = Dpage.GetTotalBrandUsersCount();
		
		
		Dpage.BrandUsersClick();
		logger.info("Clicked on 'Brand Users'");
		Thread.sleep(2000);

		
		UsersPage UPage = new UsersPage(driver);
		int TotalUsers = UPage.GetTotalUsersFromTheUsersList();
		System.out.println("Total Brand Users: " + TotalUsers);
		logger.info("Total Brand Users : ", + TotalUsers);
		
		if(TotalBrandUsersOnDashboardPage == TotalUsers)
		{
			logger.info("Total Brand Users count shown on Dashboard is matched with total Brand Users listead on Users list page");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Total Brand Users count shown on Dashboard is not matched with total Brand Users listead on Users list page");
//			Dpage.DashboardTabClicked();
			captureScreenShot(driver,"VerifyBrandUsersCountOnDashboardAndTotalListeadBrandUsersOnUsersPage");
			Assert.assertTrue(false);
		}
	}
	

	@Test(priority = 13)
	//TC: Total Agencies Users Count shown on dashboard is match with the total listed Agencies users on the users page
	public void VerifyAgenciesUsersCountOnDashboardAndTotalListeadAgenciesUsersOnUsersPage() throws InterruptedException, IOException
	{		
		DashboardPage Dpage = new DashboardPage(driver);
		Dpage.DashboardTabClicked();
		Thread.sleep(2000);
		Dpage.VerifyAgenciesUsersLabel();
		logger.info("'Agencies Users' count is exist/displayed on Dashboard Page");
		
		int TotalAgenciesUsersOnDashboardPage = Dpage.GetTotalAgenciesUsersCount();
		
		
		Dpage.AgencyUsersClick();
		logger.info("Clicked on 'Agencies Users'");
		Thread.sleep(2000);

		
		UsersPage UPage = new UsersPage(driver);
		int TotalUsers = UPage.GetTotalUsersFromTheUsersList();
		System.out.println("Total Agencie Users : " + TotalUsers);
		logger.info("Total Agencie Users : ", + TotalUsers);
		
		if(TotalAgenciesUsersOnDashboardPage == TotalUsers)
		{
			logger.info("Total Agencies Users count shown on Dashboard is matched with total Agencies Users listead on Users list page");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Total Agencies Users count shown on Dashboard is not matched with total Agencies Users listead on Users list page");
//			Dpage.DashboardTabClicked();
			captureScreenShot(driver,"VerifyAgenciesUsersCountOnDashboardAndTotalListeadAgenciesUsersOnUsersPage");
			Assert.assertTrue(false);
		}
	}

}
