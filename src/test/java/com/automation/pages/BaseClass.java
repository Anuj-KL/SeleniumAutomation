package com.automation.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.automation.utility.BrowserUtility;
import com.automation.utility.ExcelDataReader;
import com.automation.utility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	
	
    public WebDriver driver;   
    public ExcelDataReader excel;   
    public ExtentReports report;
    public ExtentTest logger;
    Helper helper = new Helper();
    
    
    @BeforeSuite
    public void setUpSuite() {
    	
    	Reporter.log("Suite is getting ready", true);
    	excel = new ExcelDataReader();
    	report= new ExtentReports();
    	ExtentSparkReporter spark = new ExtentSparkReporter(new File(System.getProperty("user.dir") + "/Reports/spark.html"));
    	
    	report.attachReporter(spark);
    	
    	
    }
	
	@BeforeClass
	public void setUp() {
		driver = BrowserUtility.setBrowser(driver, "Chrome", "https://ui.cogmento.com");
	}
	

	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			logger.fail("Failed");
			logger.addScreenCaptureFromPath(helper.captureScreenShot(driver));
		}
		
		report.flush();
				
	}
	
	
	@AfterSuite
	public void tearDown() {
		BrowserUtility.quitBrowser(driver);
		Reporter.log("Session has been ended", true);
	}
	
	
}
