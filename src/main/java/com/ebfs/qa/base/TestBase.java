package com.ebfs.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.ebfs.qa.util.WebEventListener;
import com.ebfs.qa.properties.TestBaseProperties;
import com.ebfs.qa.properties.TestUtilProperties;
import org.testng.Assert;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(TestBaseProperties.CONFIG_PATH);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		String browserType = prop.getProperty("browser");
		
		switch(browserType){
			case "chrome":
				System.setProperty(TestBaseProperties.CHROME_DRIVER, TestBaseProperties.CHROME_DRIVER_PATH);	
				driver = new ChromeDriver();
				break;
				
			case "FF":
				System.setProperty(TestBaseProperties.FIREFOX_DRIVER, TestBaseProperties.FIREFOX_DRIVER_PATH);	
				driver = new FirefoxDriver();
				break;
				
			default:
				System.out.println("browser : " + browserType + " is invalid, Launching Chrome as browser of choice..");
						
		}
		
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		//driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtilProperties.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtilProperties.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}

	
	
	
	

}
