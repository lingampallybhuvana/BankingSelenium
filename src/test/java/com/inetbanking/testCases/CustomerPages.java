package com.inetbanking.testCases;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.BaseClass;
import com.inetbanking.pageObjects.CustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class CustomerPages extends  BaseClass {

	@Test
	public void CustDetails() throws InterruptedException
	{
		LoginPage lp = new LoginPage(driver);
		
		
		logger.info("Launched URL");
		lp.setUsername(getUsername());
		logger.info("Username as been passed");
		lp.setPassword(getPassword());
		logger.info("Password has been set");
		lp.clickBtn();
		
		Thread.sleep(3000);
		
		CustomerPage addcust=new CustomerPage(driver);
		
		addcust.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		
		
		addcust.custName("Pavan");
		addcust.custgender("male");
		addcust.custdob("10","15","1985");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");
		
		addcust.custemailid(BaseClass.randomString()+"gmail.com");
		addcust.custpassword("abcdef");
		addcust.custsubmit();
	}

}
