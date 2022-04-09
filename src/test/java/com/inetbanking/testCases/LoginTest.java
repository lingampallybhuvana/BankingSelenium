package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.BaseClass;
import com.inetbanking.pageObjects.LoginPage;

public class LoginTest extends BaseClass {
	
	
	@Test
	public void LoginTest() throws IOException
	{
		LoginPage lp = new LoginPage(driver);
		
		logger.info("Launched URL");
		lp.setUsername(getUsername());
		logger.info("Username as been passed");
		lp.setPassword(getPassword());
		logger.info("Password has been set");
		lp.clickBtn();
		if (driver.getTitle().equals(getTitle())) {
			Assert.assertTrue(true);
			
		}
		else
		{
			takeScreenshot(driver,"LoginTest");
			Assert.assertTrue(false);
			
		}
	}

}
