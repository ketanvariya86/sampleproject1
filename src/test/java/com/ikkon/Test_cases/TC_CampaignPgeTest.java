package com.ikkon.Test_cases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.ikkon.pageObjects.CampaignPage;

public class TC_CampaignPgeTest extends BaseClass{
	
	@Test(priority=1)
	//Verify the first page loads with 10 campaigns listed (Basic Functionality)
	public void VerifyCampaignListOnFirstPage() throws Exception
	{
		
		TC_SignInPageTest SIPTest = new TC_SignInPageTest();
		SIPTest.OpenSignInPage();
		SIPTest.SignInWithAdmin();
		
		TC_MenuPageTest MPTest = new TC_MenuPageTest();
		MPTest.CampaignPageOpened();		
		logger.info("Campaign tab is clicked and Campaign list page is opened");
		
		CampaignPage CPage = new CampaignPage(driver);
		int TotalPages = CPage.GetTotalPages();
		int TotalCampaignsOnThePage = CPage.GetCampaignCountOnThePage();
		if(TotalPages < 3)
		{
			logger.info("There is something wrong as no campaign available on the page");
			captureScreenShot(driver,"VerifyCampaignListonFirstPage");
			Assert.assertTrue(false);
		}
		else
		{
			if(TotalCampaignsOnThePage >= 1 && TotalCampaignsOnThePage< 10)
			{
				logger.info("Skiping the test case as Total campaign on the page is less that 10. Total available campaign is: " + TotalCampaignsOnThePage);
				throw new SkipException("Skiping the test case as Total campaign on the page is less that 10. Total available campaign is: " + TotalCampaignsOnThePage);
			}
			else if(TotalCampaignsOnThePage == 10)					
			{
				logger.info("First Page contains 10 campaigns");
				Assert.assertTrue(true);
			}
			else
			{
				logger.info("First Page contains more than 10 campaigns. Total campaigns shown on the page is: " + TotalCampaignsOnThePage);
				captureScreenShot(driver,"VerifyCampaignListonFirstPage");
				Assert.assertTrue(false);
			}
		}		
	}
	
	
	@Test(priority=2)
	//Verify that the "Previous" button is disabled on the first page (Edge Case)
	public void VerifyPreviousButtonStatusOnFirstPage() throws IOException  
	{
		CampaignPage CPage = new CampaignPage(driver);
		if(CPage.GoToPreviousPageButtonStatus()==false)
		{
			logger.info("Pass: Go to Previous Page button is disabled");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Fail: Go to Previous Page button is enabled");
			captureScreenShot(driver,"VerifyPreviousButtonStatusOnFirstPage");
			Assert.assertTrue(false);
		}
	}
	@Test(priority=3)
	//Verify that the "Previous" button gets enabled when user is on the first page and go to next(other) page
	public void VerifyPreviousButtonStausWhenSwitchFromFirstPageToAnotherPage() throws IOException, InterruptedException
	{
		CampaignPage CPage = new CampaignPage(driver);
		CPage.GoToSecondPage();
		Thread.sleep(1000);
		logger.info("clicked on 2nd page in pagination");

		if(CPage.GoToPreviousPageButtonStatus()==true)
		{
			logger.info("Pass: Go to Previous Page button is enabled");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Fail: Go to Previous Page button is disabled");
			captureScreenShot(driver,"VerifyPreviousButtonStatusOnFirstPage");
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority=4)
	//Verify that the "Next" button gets disabled when user is on the last page
	public void VerifyNextButtonStatusWhenUserIsOnLastPage() throws IOException, InterruptedException
	{
		driver.navigate().refresh();
		CampaignPage CPage = new CampaignPage(driver);
		Thread.sleep(1000);
		CPage.GoToLastPage();
		Thread.sleep(1000);
		if(CPage.GoToNextPageButtonStatus()==false)
		{
			logger.info("Pass: Go to Next Page button is disabled");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Fail: Go to Next Page button is enabled");
			captureScreenShot(driver,"VerifyNextButtonStatusWhenUserIsOnLastPage");
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority=5)
	//Verify that the "Previous" button and "Next" buttons are disabled when there is only one/single page available
	public void VerifyPreviousAndNextButtonStatusWhenOnlySinglePageAvailable() throws Exception
	{
		
		CampaignPage CPage = new CampaignPage(driver);
		int TotalPages = CPage.GetTotalPages();
		if(TotalPages < 3)
		{
			logger.info("There is something wrong as no campaign available on the page");
			captureScreenShot(driver,"VerifyCampaignListonFirstPage");
			Assert.assertTrue(false);
		}
		else
		{
			if(TotalPages > 3)
			{
				logger.info("Skiping the test case as Total campaign pages available are: " + TotalPages);
				throw new SkipException("Skiping the test case as Total pages are more than 3. Total Pages are : " + TotalPages);
			}
			else					
			{
				if(CPage.GoToPreviousPageButtonStatus()== false && CPage.GoToNextPageButtonStatus() == false)
				{
					logger.info("Pass: Previous and Next buttons are disabled");
					Assert.assertTrue(true);
				}
				else
				{
					logger.info("Fail: Previous OR Next buttons are enabled which is not expected ");
					captureScreenShot(driver, browser);
					Assert.assertTrue(false);					
				}

			}

		}		
	}
}