package com.inetbanking.userDefined;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CountMethods {
	
	
	public static int getElementNumber(WebDriver driver, WebDriverWait wait, By locator)
	{
		int size=0;
		
		try {
			
			WaitMethods.waitForElement(wait, locator);
			size = driver.findElements(locator).size();
			return size;
			
		} catch (Exception e) {
			return size;
		}
		
	}
	
	public static List<WebElement> listOfWebElement(WebDriver driver, WebDriverWait wait, By locator)
	{
		List<WebElement> el = null;
		
		try {
			WaitMethods.elementVisiblity(wait, locator);
			el = driver.findElements(locator);
			return el;
		} catch (Exception e) {
			
			return el;
		}
	}
	
	

}
