package com.inetbanking.userDefined;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitMethods {

	public static WebDriverWait wait;
	public static WebDriver driver;

	public static void waitInitializationFordriver() {
		wait = new WebDriverWait(driver, 60);
	}

	public static void waitForElement(WebDriverWait wait, By locator) {
		WebElement element = null;
		try {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (Exception e) {
			element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		}

	}
	

public static WebElement elementVisiblity(WebDriverWait wait, By locator)
{
	WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	return el;
}
}

