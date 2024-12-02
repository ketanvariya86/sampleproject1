package com.ikkon.Test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ikkon.pageObjects.AgencyPage;
import com.ikkon.pageObjects.BrandPage;
import com.ikkon.pageObjects.CampaignPage;
import com.ikkon.pageObjects.DashboardPage;
import com.ikkon.pageObjects.MatchmakingPage;
import com.ikkon.pageObjects.MenuPage;

public class TC_MenuPageTest extends BaseClass{
	
	
	//	TC: Click on Dashboard and verify that "Dashboard" page is opened
	@Test
	public void DashboardPageOpened() throws InterruptedException {
		DashboardPage DPage = new DashboardPage(driver);
		DPage.DashboardTabClicked();
		logger.info("Dashboard tab is clicked from left menu bar");
		Thread.sleep(5000);
		DPage.VerifyDashboardPageURL();
		logger.info("Dahsboard tab is opened successfully");
		
	}
	
	//	TC: Click on "Agency" and verify that "Agency" page is opened
	@Test
	public void AgencyPageOpened() throws InterruptedException {
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
			Assert.fail("Agency Page did not opened");
		}
		
		logger.info("============= Click on 'Agency' and verify that 'Agency' page is opened test case execution completed =============");
		
	}
	
	@Test
	//	Click on "Brand" and verify that "Brand" page is opened
	
	public void BrandPageOpened()
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
			Assert.fail("Brand page did not opened");
		}
		logger.info("============= Click on 'Brand' tab and verify that 'Brand' tab is opened test case execution Completed =============");		
	}
		
	@Test
	// TC:	Click on "Campaign" and verify that "Campaign" page is opened
	public void CampaignPageOpened() {
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
			Assert.fail("Campaign page did not opened");
		}
		
		logger.info("============= Click on 'Campaign' tab and verify that 'Campaign' tab is opened test case execution Completed =============");
	}
	
	@Test
	//	Click on "Matchmaking" and verify that "Matchmaking" page is opened
	public void MatchmakingPageOpened() {
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
			Assert.fail("Matchmaking tab did not opened");
		}
	}
	
	
	//	Click on "Users" tab and verify that "Users" list page is opened
	//	Click on "System Log" and verify that "System Log" page is opened
	

}
