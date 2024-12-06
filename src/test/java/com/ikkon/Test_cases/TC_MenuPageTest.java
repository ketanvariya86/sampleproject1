package com.ikkon.Test_cases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ikkon.pageObjects.AgencyPage;
import com.ikkon.pageObjects.BrandPage;
import com.ikkon.pageObjects.CampaignPage;
import com.ikkon.pageObjects.DashboardPage;
import com.ikkon.pageObjects.MatchmakingPage;
import com.ikkon.pageObjects.MenuPage;
import com.ikkon.pageObjects.NotificaitonTrayPage;
import com.ikkon.pageObjects.NotificationPage;
import com.ikkon.pageObjects.SystemLogsPage;
import com.ikkon.pageObjects.UsersPage;

public class TC_MenuPageTest extends BaseClass{
	
	
	//	TC: Click on Dashboard and verify that "Dashboard" page is opened
	@Test(priority = 7)
	public void DashboardPageOpened() throws InterruptedException {
		DashboardPage DPage = new DashboardPage(driver);
		DPage.DashboardTabClicked();
		logger.info("Dashboard tab is clicked from left menu bar");
		Thread.sleep(5000);
		DPage.VerifyDashboardPageURL();
		logger.info("Dahsboard tab is opened successfully");
		
	}
	
	//	TC: Click on "Agency" and verify that "Agency" page is opened
	@Test(priority = 1)
	public void AgencyPageOpened() throws InterruptedException, IOException {
		logger.info("============= Click on 'Agency' and verify that 'Agency' page is opened test case execution started =============");;
		TC_SignInPageTest SIPT = new TC_SignInPageTest();
		SIPT.OpenSignInPage();
		SIPT.SignInWithAdmin();
		MenuPage MPage = new MenuPage(driver);
		MPage.AgencyTabClicked();
		logger.info("Agency Tab clicked from left menu bar");
		AgencyPage APage = new AgencyPage(driver);
		
		if(APage.verifyAgencyLabel())
		{
			logger.info("Agency Page opened successfully");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Agency Page did not opened");
			captureScreenShot(driver,"AgencyPageOpened");
			Assert.fail("Agency Page did not opened");
		}
		
		logger.info("============= Click on 'Agency' and verify that 'Agency' page is opened test case execution completed =============");
		
	}
	
	@Test(priority = 2)
	//	Click on "Brand" and verify that "Brand" page is opened
	
	public void BrandPageOpened() throws IOException
	{
		logger.info("============= Click on 'Brand' tab and verify that 'Brand' tab is opened test case execution started =============");
		MenuPage MPage = new MenuPage(driver);
		MPage.BrandTabClicked();
		logger.info("Brand Tab Clicked From Left menu Bar");
		
		BrandPage BPage = new BrandPage(driver);
		if(BPage.verifyBrandLabel())
		{
			logger.info("Brand Page is opened successfully");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Brand Page did not opened");
			captureScreenShot(driver, "BrandPageOpened");
			Assert.fail("Brand page did not opened");
		}
		logger.info("============= Click on 'Brand' tab and verify that 'Brand' tab is opened test case execution Completed =============");		
	}
		
	@Test(priority = 3)
	// TC:	Click on "Campaign" and verify that "Campaign" page is opened
	public void CampaignPageOpened() throws IOException 
	{
		logger.info("============= Click on 'Campaign' tab and verify that 'Campaign' tab is opened test case execution started =============");
		
		MenuPage MPage = new MenuPage(driver);
		MPage.CampaignTabClicked();
		logger.info("Campaign Tab Clicked from left menu bar");
		
		CampaignPage CPage = new CampaignPage(driver);
		
		if(CPage.VerifyCampignPage())
		{
			logger.info("Campaign page is opened");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Campaign page did not opened");
			captureScreenShot(driver, "CampaignPageOpened");
			Assert.fail("Campaign page did not opened");
		}
		
		logger.info("============= Click on 'Campaign' tab and verify that 'Campaign' tab is opened test case execution Completed =============");
	}
	
	@Test(priority = 4)
	//	Click on "Matchmaking" and verify that "Matchmaking" page is opened
	public void MatchmakingPageOpened() throws IOException 
	{
		logger.info("============= Click on 'Matchmaking' and verify that 'Matchmaking' page is opened test case execution started =============");
		MenuPage MPage = new MenuPage(driver);
		MPage.MatchmakingTabClicked();
		logger.info("Matchmaking tab is pressed/clicked from left menu bar");
		
		MatchmakingPage MMPage= new MatchmakingPage(driver);
		if(MMPage.verifyFindPerfectMatchLabel())
		{
			logger.info("Matchmaking page is opend");
			Assert.assertTrue(true);
		}
		else
		{	
			logger.error("Matchmaking tab did not opened");
			captureScreenShot(driver, "MatchmakingPageOpened");
			Assert.fail("Matchmaking tab did not opened");
		}
		
		logger.info("============= Click on 'Matchmaking' and verify that 'Matchmaking' page is opened test case execution completed =============");
	}
	
	@Test(priority = 5)
	//	Click on "Users" tab and verify that "Users" list page is opened
	public void UsersPageIsOpened() throws IOException
	{
		logger.info("============= Click on 'Users' tab and verify that 'Users' list page is opened test case execution started =============");
		MenuPage MPage = new MenuPage(driver);
		MPage.UsersTabClicked();
		logger.info("Users tab is clicked");
		
		UsersPage UPage = new UsersPage(driver);
		if(UPage.VerifyUsersLabel())
		{
			logger.info("Users page opened successfully");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Users page did not opened");
			captureScreenShot(driver,"UsersPageIsOpened");
			Assert.fail("Users Page did not opened");
		}
		
		logger.info("============= Click on 'Users' tab and verify that 'Users' list page is opened test case execution completed =============");
	}
	
	@Test(priority = 6)
	//	Click on "System Log" and verify that "System Log" page is opened
	public void SystemLogsPageIsOpened() throws IOException
	{
		logger.info("============= Click on 'System Log' and verify that 'System Log' page is opened test case execution started =============");
		MenuPage MPage = new MenuPage(driver);
		MPage.SystemLogTabClicked();
		logger.info("System Log tab is clicked");
		
		SystemLogsPage SLPage = new SystemLogsPage(driver);
		if(SLPage.VerifySystemLogsLabel())
		{
			logger.info("System Logs page is opened");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("System Logs page did not opened");
			captureScreenShot(driver,"SystemLogsPageIsOpened");
			Assert.fail("System Logs page did not opened");
		}
		
		logger.info("============= Click on 'System Log' and verify that 'System Log' page is opened test case execution completed =============");
	}
	
	@Test(priority = 8)
	//Click on notification icon and verify that notification tray is opened where click on "View All" button and verify that Notification page is opened
	public void NotificationPageIsOpened() throws InterruptedException, IOException
	{
		logger.info("Click on notification icon and verify that notification tray is opened where click on 'View All' button and verify that Notification page is opened test case execution started");
		Thread.sleep(2000);

		MenuPage MPage = new MenuPage(driver);
		MPage.ClickOnNotificationIcon();
		
		System.out.println("Clicked on notificaiton icon");
		
		Thread.sleep(2000);
		NotificaitonTrayPage NTPage = new NotificaitonTrayPage(driver);
		if(NTPage.VerifyViewAllButton())
		{
			logger.info("'View All' button is visible");
			Assert.assertTrue(true);
			NTPage.ClickOnViewAllButton();
			logger.info("'View All' button is clicked");
		}
		else
		{
			logger.info("'View All' button is not available/displayed in notification tray");
			captureScreenShot(driver,"NotificationPageIsOpened");
			Assert.fail("'View All' button is not available/displayed in Notificaiton tray");
		}
		
		NotificationPage NPage = new NotificationPage(driver);
		if(NPage.VerifyNotificationsLabel())
		{
			logger.info("Notification page is opened");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Notificaiton page did not opened");
			captureScreenShot(driver,"NotificationPageIsOpened");
			Assert.fail("Notification page did not opened");
		}
		logger.info("Click on notification icon and verify that notification tray is opened where click on 'View All' button and verify that Notification page is opened test case execution completed");
	}

}
