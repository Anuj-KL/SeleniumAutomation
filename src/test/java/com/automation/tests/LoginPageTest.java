package com.automation.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;

public class LoginPageTest extends BaseClass {
	
	
	
	@Test	
    public void testLoginPage() {
		
		logger = report.createTest("Login to application");
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting application");
		
		loginPage.loginToApplication(excel.getStringData("UserData", 0, 0), excel.getStringData("UserData", 0, 1));	
		System.out.println("Push and trigger build");
		
	}
}
