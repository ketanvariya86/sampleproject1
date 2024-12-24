package com.ikkon.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	WebDriver ldriver;
	int LastPageNumber = 0;
	
	public CampaignPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//h4[text()='Campaigns']") public WebElement CampaignLabel;
	@FindBy(xpath = "//ul[@class='MuiPagination-ul css-nhb8h9']//li") public List<WebElement> TotalPages;
	@FindBy(xpath = "//tr[@class='MuiTableRow-root css-1kvt75p']") public List<WebElement> TotalListCampaignsOnThePage;
	@FindBy(xpath = "//button[@aria-label='Go to previous page']") public WebElement GoToPreviousPageButton;
	@FindBy(xpath = "//button[@aria-label='Go to page 2']") public WebElement GoToPage2Button;
	//@FindBy(xpath = LastPageXPath) public WebElement GoToLastPageButton;
	@FindBy(xpath = "//button[@aria-label='Go to next page']") public WebElement GoToNextPageButton;
	
	public boolean VerifyCampignPage()
	{
		return CampaignLabel.getText().equals("Campaigns");
	}
	
	public int GetTotalPages()
	{
		return TotalPages.size();
	}
	
	public int GetCampaignCountOnThePage()
	{
		return TotalListCampaignsOnThePage.size();
	}
	
	public boolean GoToPreviousPageButtonStatus()
	{
		return GoToPreviousPageButton.isEnabled();
	}
	
	public void GoToSecondPage()
	{
		GoToPage2Button.click();
	}

	public void GoToLastPage()
	{
		LastPageNumber = TotalPages.size() - 2;
		WebElement LastPageButtonXPath = ldriver.findElement(By.xpath("//button[@aria-label='Go to page " + LastPageNumber + "']"));
		LastPageButtonXPath.click();
	}
	public boolean GoToNextPageButtonStatus()
	{
		return GoToNextPageButton.isEnabled();
	}
}
