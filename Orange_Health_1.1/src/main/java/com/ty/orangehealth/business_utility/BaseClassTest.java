package com.ty.orangehealth.business_utility;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.xml.XmlTest;

import com.ty.orangehealth.Generic_Utility.FileUtility;
import com.ty.orangehealth.Generic_Utility.ThreadSafeClass;


public class BaseClassTest {
	protected FileUtility readData = new FileUtility();
	protected WebDriver driver;
	public static WebDriver sdriver;
	@BeforeSuite
	public void configBS() {
		System.out.println("DB coonection created");
	}
	
	
	
	@BeforeClass
	public void configBC(XmlTest test) {
		String browser = System.getProperty("browser");
		if(browser == null || browser.isBlank()) {
			browser = test.getParameter("browser");
			if(browser == null || browser.isBlank()) {
				browser = readData.fromProperties("browser");
			}
		}
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else {
			throw new IllegalArgumentException("Invalid browser : " + browser);
		}
		
		ThreadSafeClass.setDriver(driver);
		driver = ThreadSafeClass.getDriver();
		sdriver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(readData.fromProperties("url"));
		System.out.println("before class");
		
	}
	
	
	@AfterClass
	public void configAC() {
		driver.quit();
	}
	
	@AfterSuite
	public void configAS() {
		readData.closeWorkbook();
		System.out.println("DB coonection closed");
	}
}
