package com.ikkon.pageObjects;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;

public class CampaignPage {
	WebDriver ldriver;
	int LastPageNumber = 0;
	private static final Logger logger = LogManager.getLogger("IKKON");
	
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
	@FindBy(xpath = "//div[@id='mui-component-select-status']") public WebElement StatusDropdown;
	@FindBy(xpath = "//li[@data-value='draft']") public WebElement Draft;
	@FindBy(xpath = "//li[@data-value='active']") public WebElement Active;
	@FindBy(xpath = "//li[@data-value='in_active']") public WebElement InActive;
	@FindBy(xpath = "//li[@data-value='request_for_influencer']") public WebElement RequestForInfluencer;
	@FindBy(xpath = "//li[@data-value='review_influencer']") public WebElement ReviewInfluencer;
	@FindBy(xpath = "//li[@data-value='influencer_confirmed']") public WebElement InfluencerConfirmed;
	@FindBy(xpath = "//li[@data-value='completed']") public WebElement Completed;
	@FindBy(xpath = "//tbody[@class='MuiTableBody-root css-1xnox0e']//tr//td[2]") public List<WebElement> FilteredCampaignListStatus;
	
	
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
	
	public void ClickOnStatusDropdown()
	{
		StatusDropdown.click();
	}
	
	public void SelectStatus(String status)
	{

		switch (status)
		{
			case "Draft":
				Draft.click();
				logger.info("Draft is selected");
				break;
				
			case "Active":
				Active.click();
				logger.info("Active is selected");
				break;
				
			case "In Active":
				InActive.click();
				logger.info("'In Active' is selected");
				break;
				
			case "Request for influencer":
				RequestForInfluencer.click();
				logger.info("'Request for influencer' is selected");
				break;
				
			case "Review influencer":
				ReviewInfluencer.click();
				logger.info("'Review influencer' is selected");
				break;
				
			case "Influencer Confirmed":	
				InfluencerConfirmed.click();
				logger.info("'Influencer Confirmed' is selected");
				break;
				
			case "Completed":	
				Completed.click();
				logger.info("'Completed' is selected");
				break;
				
			 default:
				 logger.info("Unknown Status As" + status + " is not found in the status dropdown.");
	                // Handle the case if status is unknown				
		}
	}
	

	
	public boolean VerifyGetFilteredCampaignListStatus(String ExpectedStatus)
	{
		String Status;
		boolean StatusFlag = false;

		System.out.println("Expected Status: " + ExpectedStatus);
		
		logger.info("Campaign list size is: " + FilteredCampaignListStatus.size());
		if (FilteredCampaignListStatus.size() == 0)
		{
			logger.info("Skiping the test case as Total filtered campaigns are: " + FilteredCampaignListStatus.size());
			throw new SkipException("Skiping the test case as Total filtered campaigns are: " + FilteredCampaignListStatus.size());
		}
		else
		{
			for(int i = 0; i < FilteredCampaignListStatus.size(); i++)
			{
				Status = FilteredCampaignListStatus.get(i).getText().trim();
				System.out.println("Actual Status: " + Status);
				if(Status.equals(ExpectedStatus))
				{
					StatusFlag = true;
				}
				else
				{
					StatusFlag = false;
					break;
				}
			}

			return StatusFlag;

		}		
	}
}
