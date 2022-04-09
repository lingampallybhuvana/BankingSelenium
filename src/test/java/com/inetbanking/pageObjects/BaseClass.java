package com.inetbanking.pageObjects;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig rs = new ReadConfig();

	private String baseURL = rs.getURL();
	private String username = rs.getUsername();
	private String password = rs.getPassword();
	private String title = "Guru99 Bank Manager HomePage";
	public static Logger logger;
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public static WebDriver driver;

	public String getBaseURL() {
		return baseURL;
	}

	public void setBaseURL(String baseURL) {
		this.baseURL = baseURL;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		if(br.equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			System.out.println("Pass the browser in the XML file");
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get(getBaseURL());
		driver.manage().window().maximize();
		logger = logger.getLogger("Selenium");
		PropertyConfigurator.configure("Log4j.properties");

		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();

	}
	
	public void takeScreenshot(WebDriver driver, String tname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File targer = new File(System.getProperty("user.dir")+"ScreenShots"+tname+".png");
		FileUtils.copyFile(source, targer);
		logger.info("ScreenShot taken");
		
	}
	
	//RandomString
	public static String randomString()
	{
		return RandomStringUtils.randomAlphabetic(8);
	}
	
	public static String randomNumber()
	{
		return RandomStringUtils.randomNumeric(8);
	}

}
