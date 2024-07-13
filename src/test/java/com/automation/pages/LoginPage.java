package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	@FindBy(name="email") WebElement userEmail;
	
	@FindBy(name="password") WebElement userPassword;
	
	@FindBy(xpath="//*[text()='Login']")   WebElement loginButton;
	
	
	public void loginToApplication(String email,String password) {
		
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		loginButton.click();
	}
}
