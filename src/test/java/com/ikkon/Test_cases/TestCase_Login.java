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

public class TestCase_Login {
	
	WebDriver driver;
	
	@BeforeTest
	public void beforetest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.get("https://ikkon.ae/");
	}

	
	@Test
	public void openLoginPage() throws InterruptedException {
		HomePage hpage = new HomePage(driver);
		hpage.ClickOnLogin();
		Thread.sleep(1000);
		
		SignInPage spage = new SignInPage(driver);
		String pagename = spage.GetPageName();
		assertEquals("Sign in to IKKON", pagename);

		Thread.sleep(1000);
	}
	
	
	// Teardown method
	@AfterTest(enabled = true)
	public void aftertest() {
		driver.close();
		driver.quit();
	}	
}
