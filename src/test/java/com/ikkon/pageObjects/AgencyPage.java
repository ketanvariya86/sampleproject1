package com.ikkon.pageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AgencyPage {
	WebDriver ldriver;
	
	public AgencyPage(WebDriver rdriver) 
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	// Page Elements
	@FindBy(xpath = "//h4[text()='Agency']") public WebElement AgentLabel;
	
	//Action mthods
	public boolean verifyAgencyLabel()
	{
//		String ExpactedLabel = "Agency";
//		String ActualLabel = AgentLabel.getText(); 
//		Assert.assertEquals(ActualLabel, ExpactedLabel);		
		return AgentLabel.getText().equals("Agency");
	}
}
