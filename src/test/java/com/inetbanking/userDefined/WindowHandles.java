package com.inetbanking.userDefined;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowHandles {

	public static String parentWindow = "";

	public static void switchWindow(WebDriver driver, String titleWindow) {

		parentWindow = driver.getWindowHandle();
		java.util.Iterator<String> iterator = driver.getWindowHandles().iterator();
		while (iterator.hasNext()) {
			String child = iterator.next();
			WebDriver p = driver.switchTo().window(child);
			String title = p.getTitle();
			if (title.equals(titleWindow)) {
				break;
			}
		}
	}

	public static void maximize(WebDriver driver, String window) {
		try {
			switchWindow(driver, window);
			driver.manage().window().maximize();
		} catch (Exception e) {
		}
	}

	// getWindowTitles

	public static void getWindowTitles(WebDriver driver) {
		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();
		Iterator<String> p = s.iterator();
		while (p.hasNext()) {
			String q = p.next();
			if (!parent.equals(q)) {
				driver.switchTo().window(q);
				System.out.println(driver.switchTo().window(q).getTitle());
			}
		}
	}

}
