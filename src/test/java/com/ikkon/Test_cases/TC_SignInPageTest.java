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
		
		if(PwdErrMsg.equals("Password is required..."))
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
		logger.info("Email and Password fields are cleared");
		SIP.EnterEmailId();
		logger.info("Email is entered");
		SIP.ClickOnSubmitToLogin();
		logger.info("Clicked on Submit button");
				
		String PwdErrMsg = SIP.GetPasswordErrorMessage();
		
		if(PwdErrMsg.equals("Password is required...."))
		{
			logger.info("'Password is required' error message is shown");
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("'Password is required' error message is not shown");
			captureScreenShot(driver,"LoginWithoutEnteringPassword");
			Assert.fail("'Password is required' error message is not shown");
		}
	}

	@Test(priority = 4)
	//	TC: Enter only password field(Without entering email) and click on "Submit" button and verify that related validation message is shown like ""Email is required"

	public void LoginWithoutEnteringEmail() throws IOException
	{
		SignInPage SIP = new SignInPage(driver);
		SIP.ClearCredentials();
		logger.info("Credentials are cleared for Email ID and Password are cleared");
		SIP.EnterPassword();
		logger.info("Password is entered");
		SIP.ClickOnSubmitToLogin();
		logger.info("Submit button clicked");
		
		if(SIP.GetEmailErrorMessage().equals("Email is required"))
		{
			logger.info("'Email is required' error message is shown");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("Email is required' error message is not shown");
			captureScreenShot(driver, "LoginWithoutEnteringEmail");
			Assert.fail("Email is required' error message is not shown");
		}
	}
	
	@Test(priority = 5)
	//	Enter invalid Email and correct credentials and verify that related validation message is shown like "Invalid email address"
	public void LoginWithInvalidEmailAndCorrectPassword() throws IOException
	{
		SignInPage SIP = new SignInPage(driver);
		SIP.ClearCredentials();
		logger.info("Login and Password fields are cleared");
		SIP.EnterInvalidEmailID();
		logger.info("Invalid Email entered in Email field");
		SIP.EnterPassword();
		logger.info("Password is entered in password field");
		if(SIP.GetEmailErrorMessage().equals("Invalid email address"))
		{
			logger.info("'Invalid email address' error message is shown");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("'Invalid email address' error message is not shown");			
			captureScreenShot(driver, "LoginWithInvalidEmailAndCorrectPassword");
			Assert.fail("'Invalid email address' error message is not shown");
		}
		
	}
	
	@Test(priority = 6)
	//	Enter correct Email and invalid password(less than 6 character) and verify that related validation message is shown like "Password must be at least 6 characters"
	public void LoginEmailAndInvalidPassword() throws IOException
	{
		SignInPage SIP = new SignInPage(driver);
		SIP.ClearCredentials();
		logger.info("Email and Password fields are cleared");
		SIP.EnterEmailId();
		logger.info("Email id is entered in the email box");
		SIP.EnterInvalidPassword();
		logger.info("Invalid password is entered in the password text box");
		if(SIP.GetPasswordErrorMessage().equals("Password must be at least 6 characters"))
		{
			logger.info("'Password must be at least 6 characters' error message is shown");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("'Password must be at least 6 characters' error message is not shown");
			captureScreenShot(driver, "LoginEmailAndInvalidPassword");
			Assert.fail("'Password must be at least 6 characters' error message is not shown");
		}
	}
	
	
		
	@Test (priority = 7)	
	// TC-02 : Admin: Enter correct credentials(Email id and Password) and click on "Submit" button and verify that user is able to login successfully
	public void SignInWithAdmin()throws InterruptedException{
		logger.info("================== 'Verify that Admin is able to sign in successfully with correct credentials' execution started ==================");
//		HomePage hpage = new HomePage(driver);
//		hpage.ClickOnLogin();
//		logger.info("Login button clicked");
//		Thread.sleep(5000);
		
		SignInPage spage = new SignInPage(driver);
		spage.ClearCredentials();
		Thread.sleep(1000);
		
		spage.EnterEmailId();
		Thread.sleep(1000);
		logger.info("Admin user email address is entered");
		spage.EnterPassword();
		logger.info("Admin user password is entered");
		
		spage.ClickOnSubmitToLogin();
//		logger.info("Submit button clicked");
		Thread.sleep(5000);		
		DashboardPage dpage = new DashboardPage(driver);
		
		dpage.VerifyLoggedInSuccessfullyMsg();
		logger.info("Logged In Successfully Message shown");
		Thread.sleep(3000);
		dpage.VerifyDashboardPageURL();
		logger.info("Admin User Logged In successfully");
		logger.info("================== 'Verify that Admin is able to sign in successfully with correct credentials' execution completed ==================");
	}

	// TC-03: User Logout
	@Test(priority = 8)
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
