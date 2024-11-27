package com.ikkon.Test_cases;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import com.ikkon.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	// Create readconfig file object to get baseUrl and browser value
	ReadConfig readconfig = new ReadConfig();
	String url = readconfig.getBaseUrl();
	String browser = readconfig.getBrowser();
	
	// Create webdriver object
	public static WebDriver driver;
	// Create logger object
	public static Logger logger;
	
	@BeforeClass
	// Create setup method
	public void setup()
	{
		// For logging
		logger = LogManager.getLogger("IKKON");

		logger.info("================ Setup method execution started ================");
		switch(browser.toLowerCase())
		{
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				logger.info("chrome browser object created");
				break;
				
			case "msedge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				logger.info("msedge browser object created");
				break;
				
			case "firefox":	
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				logger.info("firefox browser object created");
				break;
				
			default:
				driver = null;
				break;				
		}
		
		// Create implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Maximize the opened window
		driver.manage().window().maximize();
		
		logger.info("Browser Setup completed As Browser opened and maximized");
		
		driver.get(url);
		logger.info("URL Opened");
		
		logger.info("================ Setup method execution completed ================");
	}
	
	@AfterClass
	public void tearDown()
	{
		logger.info("================ tearDown method execution started ================");
		driver.close();
		logger.info("browser closed");
		driver.quit();
		logger.info("browser quitted");
		logger.info("================ tearDown method exectuion completed ================");
	}
}
