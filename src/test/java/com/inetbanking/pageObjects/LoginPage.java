package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public static WebDriver rdriver;

	public LoginPage(WebDriver ldriver) {
		rdriver = ldriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	@CacheLookup
	WebElement submitBtn;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	@CacheLookup
	WebElement lnkLogout;
	
	public void setUsername(String user)
	{
		username.sendKeys(user);		
	}
	
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickBtn()
	{
		submitBtn.click();
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
	
	

}
