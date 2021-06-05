package com.ebfs.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.ebfs.qa.base.TestBase;
import com.ebfs.qa.pages.ContactsPage;
import com.ebfs.qa.pages.HomePage;
import com.ebfs.qa.testcase.properties.ContactsPageTestProperties;
import com.ebfs.qa.util.TestUtil;
import com.qa.ExtentReportListener.ExtentTestManager;

/**
 * @author Saney Alam
 *
 */
public class ContactsPageTest extends TestBase{
	
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;	
	String sheetName = "contacts";
	ExtentTestManager extentTestManager;
	   
	public ContactsPageTest(){
			super();
			
	}
	
	
	/**
	 * @throws InterruptedException
	 */
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();		
		homePage = new HomePage();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel(){
		ExtentTestManager.getTest().log(Status.INFO, "Verify Contact Us Page Label");
		Assert.assertTrue(contactsPage.verifyContactsLabel(), ContactsPageTestProperties.ERROR_MSG);
	}
	
		
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
		
}
