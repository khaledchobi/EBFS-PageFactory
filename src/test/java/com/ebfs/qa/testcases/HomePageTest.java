package com.ebfs.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.ebfs.qa.base.TestBase;
import com.ebfs.qa.pages.ContactsPage;
import com.ebfs.qa.pages.HomePage;
import com.ebfs.qa.testcase.properties.HomePageTestProperties;
import com.ebfs.qa.util.TestUtil;
import com.qa.ExtentReportListener.ExtentTestManager;

public class HomePageTest extends TestBase {
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	ExtentTestManager extentTestManager;

	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();		
		homePage = new HomePage();
		extentTestManager = new ExtentTestManager();
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		extentTestManager.getTest().log(Status.INFO, "Verify Home Page Title");
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, HomePageTestProperties.EXP_HOMEPAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifyLogoTest(){
		extentTestManager.getTest().log(Status.INFO, "Verify Logo in the Home Page");
		Assert.assertTrue(homePage.verifyLogoDisplayed());
	}
	
	@Test(priority=3)
	public void verifyContactUsLinkTest(){
		extentTestManager.getTest().log(Status.INFO, "Verify Contact Us Link in the Home Page");
		contactsPage = homePage.clickOnContactsLink();
		
		Assert.assertTrue(contactsPage.verifyContactsLabel());
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	

}
