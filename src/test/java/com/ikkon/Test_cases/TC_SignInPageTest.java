package com.ikkon.Test_cases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.ikkon.pageObjects.DashboardPage;
import com.ikkon.pageObjects.HomePage;
import com.ikkon.pageObjects.SignInPage;

public class TC_SignInPageTest extends BaseClass {

	// TC-01 : Verify that Sign In page is opened or not
	@Test(priority = 1)	
	public void OpenSignInPage() throws InterruptedException {

		logger.info("================== 'Verify that Sign In page is opened or not' execution started ==================");
		HomePage hpage = new HomePage(driver); 
		hpage.ClickOnLogin();
		logger.info("Login button clicked");
		Thread.sleep(1000);
		  
		SignInPage spage = new SignInPage(driver); 
		String pagename =spage.GetPageName(); 
		assertEquals("Sign in to IKKON", pagename);
		logger.info("SignIn page verified");
		logger.info("================== 'Verify that Sign In page is opened or not' execution completed ==================");
	}
	
	// TC-02 : Verify that Admin is able to sign in successfully with correct credentials	
	@Test (priority = 2)	
	public void SignInWithAdmin()throws InterruptedException{
		logger.info("================== 'Verify that Admin is able to sign in successfully with correct credentials' execution started ==================");
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
		Thread.sleep(10000);
		
		DashboardPage dpage = new DashboardPage(driver);
		dpage.VerifyDashboardPageURL();
		logger.info("Admin User Logged In successfully");
		logger.info("================== 'Verify that Admin is able to sign in successfully with correct credentials' execution completed ==================");
	}

	// TC-03: User Logout
	@Test(priority = 3)
	public void Logout() throws InterruptedException
	{
		logger.info("================== User Logout test case execution started ==================");
		DashboardPage Dpage = new DashboardPage(driver);
		Dpage.ProfileNameClick();
		logger.info("TC_DashboardPageTest: Profile name clicked");
		Thread.sleep(1000);
		Dpage.LogoutClick();
		logger.info("TC_DashboardPageTest: Logout button clicked");
		Thread.sleep(1000);
		HomePage Hpage = new HomePage(driver);
		Hpage.VerifyLoginButton();
		logger.info("TC_DashboardPageTest: Lotout done successfully as Login button is displayed. ");

		logger.info("================== User Logout test case execution completed ==================");
	}


}
