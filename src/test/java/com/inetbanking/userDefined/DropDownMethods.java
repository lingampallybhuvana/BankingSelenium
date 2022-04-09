package com.inetbanking.userDefined;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDownMethods {

	public static void selectbyValueByText(WebDriver driver, WebDriverWait wait, By locator, String text) {
		WaitMethods.elementVisiblity(wait, locator);
		Select s = new Select(driver.findElement(locator));
		s.selectByVisibleText(text);
	}

	public static void selectbyValueByIndex(WebDriver driver, WebDriverWait wait, By locator, int index) {
		WaitMethods.elementVisiblity(wait, locator);
		Select s = new Select(driver.findElement(locator));
		s.selectByIndex(index);
	}

	public static void selectbyValueByValue(WebDriver driver, WebDriverWait wait, By locator, String textValue) {
		WaitMethods.elementVisiblity(wait, locator);
		Select s = new Select(driver.findElement(locator));
		s.selectByValue(textValue);
	}

	// getfirstSelectedoptionsWhich returns the selected value
	public static String getFirstSelectedOption(WebDriver driver, WebDriverWait wait, By locator) {
		WaitMethods.elementVisiblity(wait, locator);
		Select s = new Select(driver.findElement(locator));
		return s.getFirstSelectedOption().getText();
	}

	// List from the dropDownValues

	public static List<String> getListFromtheDropDown(WebDriver driver, WebDriverWait wait, By locator)
	{
		List<String> dropDownValues = new ArrayList<String>();
		
		WaitMethods.elementVisiblity(wait, locator);
		Select s = new Select(driver.findElement(locator));
		List<WebElement> p=s.getOptions();
		
		for(WebElement we:p)
		{
			dropDownValues.add(we.getText());
		}
		return dropDownValues;
	}

}
