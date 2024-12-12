package com.ikkon.Test_cases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
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
	
	@Test(priority = 2)	
//	Click on Login button without entering credentials(Email id and Password) and verify that related validation message is shown like "Email is required" and "Password is required"
	public void LoginWithoutEnteringCredentials() throws IOException
	{
		logger.info("================= Test Case Started: Login without entering credentials");
		SignInPage SIP = new SignInPage(driver);
		SIP.ClearCredentials();
		SIP.ClickOnSubmitToLogin();
		String EmailErrMsg = SIP.GetEmailErrorMessage();
		if(EmailErrMsg.equals("Email is required"))
		{
			logger.info("'Email is required' error message is shown");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("'Email is required' error message is not shown");
			captureScreenShot(driver,"LoginWithoutEnteringCredentials");
			Assert.fail("'Email is required' error message is not shown");
		}
		String PwdErrMsg = SIP.GetPasswordErrorMessage();
		
		if(PwdErrMsg.equals("Password is required"))
		{
			logger.info("'Password is required' error message is shown");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("'Password is required' error message is shown");
			captureScreenShot(driver,"LoginWithoutEnteringCredentials");
			Assert.fail("'Password is required' error message is shown");
		}
	}
	
	@Test(priority = 3)	
//	Enter only email id(without entering password) and click on "Submit" button and verify that related validation message is shown like "Password is required"
	public void LoginWithoutEnteringPassword() throws IOException
	{
		logger.info("================= Test Case Started: Login without entering credentials");
		SignInPage SIP = new SignInPage(driver);
		SIP.ClearCredentials();
		SIP.EnterEmailId();
		SIP.ClickOnSubmitToLogin();
				
		String PwdErrMsg = SIP.GetPasswordErrorMessage();
		
		if(PwdErrMsg.equals("Password is required...."))
		{
			logger.info("'Password is required' error message is shown");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("'Password is required' error message is shown");
			captureScreenShot(driver,"LoginWithoutEnteringPassword");
			Assert.fail("'Password is required' error message is shown");
		}
	}
	
	// TC-02 : Admin: Enter correct credentials(Email id and Password) and click on "Submit" button and verify that user is able to login successfully	
	@Test (priority = 4)	
	public void SignInWithAdmin()throws InterruptedException{
		logger.info("================== 'Verify that Admin is able to sign in successfully with correct credentials' execution started ==================");
		HomePage hpage = new HomePage(driver);
		hpage.ClickOnLogin();
		logger.info("Login button clicked");
		Thread.sleep(5000);
		
		SignInPage spage = new SignInPage(driver);
		spage.ClearCredentials();
		Thread.sleep(1000);
		
		spage.EnterEmailId();
		Thread.sleep(3000);
		logger.info("Admin user email address is entered");
		spage.EnterPassword();
		logger.info("Admin user password is entered");
		
		spage.ClickOnSubmitToLogin();
		logger.info("Submit button clicked");
		Thread.sleep(5000);		
		DashboardPage dpage = new DashboardPage(driver);
		
		dpage.VerifyLoggedInSuccessfullyMsg();
		logger.info("Logged In Successfully Message shown");
		Thread.sleep(5000);
		dpage.VerifyDashboardPageURL();
		logger.info("Admin User Logged In successfully");
		logger.info("================== 'Verify that Admin is able to sign in successfully with correct credentials' execution completed ==================");
	}

	// TC-03: User Logout
	@Test(priority = 5)
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

	

//	Enter only password field(Without entering email) and click on "Submit" button and verify that related validation message is shown like ""Email is required"
//	Enter invalid Email and correct credentials and verify that related validation message is shown like "Invalid email address"
//	Enter correct Email and invalid password(less than 6 character) and verify that related validation message is shown like "Password must be at least 6 characters"
	

}
