package com.automation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	// takeScreenShot, handle alert, handle frame, handle window, javaScriptExecutor
	
	public String captureScreenShot(WebDriver driver) {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String ssPath = System.getProperty("user.dir") + "/Screenshots/" + getCurrentDateTime() + ".png";
		try {
			FileHandler.copy(src, new File(ssPath));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return ssPath;
	}

	
	public String getCurrentDateTime() {
		
		DateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		
		return dateFormat.format(currentDate);
	}

	
	public void handleAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	
	public void switchFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	
	public void switchWindlow(WebDriver driver,String s) {
		driver.switchTo().window(s);
	}
	
	
}
