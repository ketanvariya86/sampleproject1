package com.ikkon.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener{
	
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void configureReport()
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd-HH.mm.ss").format(new Date());
		String reportName = "iKKON-TestReport-" + timeStamp + ".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Extent_Report/" + reportName);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		//add system information/environment info to reports
		reports.setSystemInfo("Machine:", "Kanhasoft - 062");
		reports.setSystemInfo("OS", "Windows 10 Pro");
		reports.setSystemInfo("Browser:", "Chrome");
		reports.setSystemInfo("User Name:", "Admin");
		
		//Configuration to change look and feel of reports
		htmlReporter.config().setDocumentTitle("Test Case Execution Extent Listener Report Demo");
		htmlReporter.config().setReportName("iKKON Test Case Execution Report");
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	//OnStart method is called when any Test starts.
	public void onStart(ITestContext Result)
	{
		configureReport();
		System.out.println("On Start method invoked...");
	}
	
	//OnFinish method is called after all Tests are executed
	public void onFinish(ITestContext Result)
	{
		System.out.println("On Finished method invoked......");
		reports.flush();//it is mandatory to call flush method to ensure information is written to started reporter.
	}
	
	// When Test case get failed, this method is called.
	public void onTestFailure(ITestResult Result)
	{
		System.out.println("Name of test method failed:" + Result.getName());
		test =reports.createTest(Result.getName());//Create entry in html report
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of the failed test case is: " + Result.getName(), ExtentColor.RED));
		
		String screenShotPath = System.getProperty("user.dir") + "\\ScreenShots\\" + Result.getName() + ".png";
		File screenShotFile = new File(screenShotPath);
		//File screenShotFile = new File(screenShotPath);
		if(screenShotFile.exists())
		{
			test.fail("Captured Screenshot is below:" + test.addScreenCaptureFromPath(screenShotPath));
		}
	}

	// When Test case get skipped, this method is called.
	public void onTestSkipped(ITestResult Result)
	{
		System.out.println("Name of test method skipped:" + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip test case is: " + Result.getName(), ExtentColor.YELLOW));
	}
	
	// When Test case get Started, this method is called.
	public void onTestStart(ITestResult Result)
	{
		System.out.println("Name of test method started:" + Result.getName());
	}
	
	// When Test case get passed, this method is called.
	public void onTestSuccess(ITestResult Result)
	{
		System.out.println("Name of test method successfully executed:" + Result.getName());
		test = reports.createTest(Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is: " + Result.getName(), ExtentColor.GREEN));
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result)
	{
	
	}
}
