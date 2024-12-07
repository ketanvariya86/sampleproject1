package com.ikkon.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrandPage {
	WebDriver ldriver;
	
	public BrandPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(xpath = "//h4[text()='Brands']") public WebElement BrandPageLabel;
	
	public boolean verifyBrandLabel()
	{
		return BrandPageLabel.getText().equals("Brands/");
	}
}
