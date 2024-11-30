package com.ikkon.Test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ikkon.pageObjects.AgencyPage;
import com.ikkon.pageObjects.MenuPage;

public class TC_MenuPageTest extends BaseClass{
	
	
	//	TC: Click on Dashboard and verify that "Dashboard" page is opened
	@Test
	public void DashboardPageOpened() {
		
	}
	
	//	TC: Click on "Agency" and verify that "Agency" page is opened
	@Test
	public void AgencyPageOpened() throws InterruptedException {
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
		

//		Assert.assertTrue(APage.verifyAgencyLabel(), "Agency Page Is Not Opened");
//		logger.info("Agency Label verified");
//		String ActualLabel = APage.GetAgentLable();	
//		String ExpactedLabel = "Agency1";
//		Assert.assertEquals(ActualLabel, ExpactedLabel);
	}
	
	//	Click on "Campaign" and verify that "Campaign" page is opened
	//	Click on "Matchmaking" and verify that "Matchmaking" page is opened
	//	Click on "Users" tab and verify that "Users" list page is opened
	//	Click on "System Log" and verify that "System Log" page is opened
	

}
