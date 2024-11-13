package com.ikkon.Test_cases;

import static org.testng.Assert.assertEquals;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ikkon.pageObjects.HomePage;
import com.ikkon.pageObjects.SignInPage;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_LoginPageTest extends BaseClass {

	@Test
	public void openLoginPage() throws InterruptedException {

		System.out.println(url);

		driver.get(url);
		logger.info("URL Opened");
		
		HomePage hpage = new HomePage(driver); 
		hpage.ClickOnLogin();
		logger.info("Login button clicked");
		Thread.sleep(1000);
		  
		SignInPage spage = new SignInPage(driver); 
		String pagename =spage.GetPageName(); 
		assertEquals("Sign in to IKKON", pagename);
		logger.info("SignIn page verified");
	}

}
