package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.BaseClass;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.ExcelUtils;

public class LoginTest_DD extends BaseClass {

	@DataProvider(name="TestData")
	public Object[] get_userData() {
		Object dat[]= ExcelUtils.testData("Sheet1");
		return dat;
	}

	@Test(dataProvider ="TestData")
	public void test_Data(String UserN, String Passw) throws Exception {
		LoginPage lp = new LoginPage(driver);

		logger.info("Launched URL");
		lp.setUsername(UserN);
		logger.info("Username as been passed");
		lp.setPassword(Passw);
		logger.info("Password has been set");
		lp.clickBtn();
		if (driver.getTitle().equals(getTitle())) {
			Assert.assertTrue(true);

		} else {
			takeScreenshot(driver, "LoginTest");
			Assert.assertTrue(false);

		}
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
			
		}
		
		
	}
	
	
	public boolean isAlertPresent() //user defined method created to check alert is presetn or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	}

