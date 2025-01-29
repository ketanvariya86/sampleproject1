package com.ikkon.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class UsersPage {
	WebDriver ldriver;
//	int LastPageNumber = 0;
	public UsersPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		
		PageFactory.initElements(rdriver,this);
	}
	
	
	@FindBy(xpath = "//h4[text()='Users']") public WebElement UsersLabel; 
	@FindBy(xpath = "//ul[@class='MuiPagination-ul css-nhb8h9']//li") public List<WebElement> TotalPages;
	@FindBy(xpath = "//tr[@class='MuiTableRow-root css-1kvt75p']") public List<WebElement> TotalUsers;
	
	public boolean UsersPageListURLWithAllUsers()
	{
		String currentPageUrl;
		String expectedPageUrl = "https://ikkon.ae/user/:all";
	
		currentPageUrl = ldriver.getCurrentUrl();
		System.out.println("Current Page URL = " + currentPageUrl);
//		Assert.assertEquals(currentPageUrl,expectedPageUrl);
		if (currentPageUrl.equals(expectedPageUrl))
		{
			return true;
		}
		else
		{
			return false;
		}

	}
	
	public boolean UsersPageListURLWithActiveUsers()
	{
		String currentPageUrl;
		String expectedPageUrl = "https://ikkon.ae/user/:active";
		currentPageUrl = ldriver.getCurrentUrl();
		System.out.println("Current Page URL = " + currentPageUrl);
//		Assert.assertEquals(currentPageUrl,expectedPageUrl);
		if (currentPageUrl.equals(expectedPageUrl))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean  UsersPageListURLWithInActiveUsers()
	{
		String currentPageUrl;
		String expectedPageUrl = "https://ikkon.ae/user/:inActive";
		currentPageUrl = ldriver.getCurrentUrl();
		System.out.println("Current Page URL = " + currentPageUrl);
//		Assert.assertEquals(currentPageUrl,expectedPageUrl);
		if (currentPageUrl.equals(expectedPageUrl))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void UsersPageListURLWithInfluencerUsers()
	{
		String currentPageUrl;
		String expectedPageUrl = "https://ikkon.ae/user/:influencer";
		currentPageUrl = ldriver.getCurrentUrl();
		Assert.assertEquals(currentPageUrl, expectedPageUrl);
	}
	
	public void UsersPageURLWithBrandUsers()
	{
		String currentPageUrl = ldriver.getCurrentUrl();
		String expectedPageUrl = "https://ikkon.ae/user/:brand";
		Assert.assertEquals(currentPageUrl,expectedPageUrl);
	}
	
	public void UsersPageURLWithAgencyUsers()
	{
		String currentPageUrl = ldriver.getCurrentUrl();
		String expectedPageUrl = "https://ikkon.ae/user/:agency";
		Assert.assertEquals(currentPageUrl,expectedPageUrl);
	}
	
	public boolean VerifyUsersLabel()
	{
		return UsersLabel.getText().equals("Users");
	}
	
	public void GoToLastPage()
	{
		int LastPageNumber = TotalPages.size() - 2;
		WebElement LastPageButtonXPath = ldriver.findElement(By.xpath("//button[@aria-label='Go to page " + LastPageNumber + "']"));
		LastPageButtonXPath.click();
	}
	
	public int GetTotalUsersFromTheUsersList() throws InterruptedException
	{
		
		int TotalPage = TotalPages.size();	//7
		System.out.println("TotalListOfPage: " + TotalPage); // 7
		
		int LastPageIndex = TotalPage - 2; // 5
		System.out.println("LastPageIndex: " + LastPageIndex); // 5
		
		String LastPageNumber = TotalPages.get(LastPageIndex).getText(); // 7
		System.out.println("LastPageNumber: " + LastPageNumber); //7
		
		int LPN = 0 ;		
		LPN = Integer.parseInt(LastPageNumber);
		System.out.println("Last Page Number in Integer: " + LPN);
		if (LPN >1)
		{
			WebElement LastPageButtonXPath = ldriver.findElement(By.xpath("//button[@aria-label='Go to page " + LPN + "']"));
			
			System.out.println(LastPageButtonXPath);
			LastPageButtonXPath.click();
			System.out.println("LastPage button clicked");
			Thread.sleep(2000);
			int UsersOnTheLastPage = TotalUsers.size();
			int TotalUsersCount = (10 * (LPN-1))+ UsersOnTheLastPage;
			return TotalUsersCount;
		}
		else
		{
			int TotalUsersCount = TotalUsers.size();
			return TotalUsersCount;
		}
		
	}
}
