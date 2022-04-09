package com.inetbanking.userDefined;

import org.openqa.selenium.WebDriver;

public class AlertMethods {

	/**
	 * Closing the Alert
	 * 
	 * @param driver
	 */
	public static void closeAlertPopup(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * Accept the alerts
	 * @param driver
	 */
	public static void acceptAlertPopup(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

}
