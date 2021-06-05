package com.ebfs.qa.testcases;

import com.ebfs.qa.properties.HomePageProperties;
import com.ebfs.qa.properties.TestUtilProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HomePageTest extends TestBase {
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	ExtentTestManager extentTestManager;

	public HomePageTest() {
		super();
	}
	
	@BeforeMethod(groups= {"BAF"})
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		extentTestManager = new ExtentTestManager();
	}
	
	
	//@Test(priority = 1)
	public void verifyHomePageTitleTest(){
		extentTestManager.getTest().log(Status.INFO, "Verify Home Page Title");
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, HomePageTestProperties.EXP_HOMEPAGE_TITLE);

	}
	
	@Test(priority = 2, groups= {"SmokeTest"})
	public void verifyLogoTest() throws Exception{
		//1.1. BruteForce the power of choice..... Logo should be visible to all users.
		extentTestManager.getTest().log(Status.INFO, "Verify Logo in the Home Page");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(homePage.verifyLogoDisplayed());

		testUtil.setExcelFile(TestUtilProperties.TESTDATA_SHEET_PATH, TestUtilProperties.sheetName);
		String email = testUtil.getCellData(1,1);
		String password = testUtil.getCellData(1,2);

		WebElement signIn = driver.findElement(By.xpath(HomePageProperties.LNK_SIGN_IN_XPATH));
		signIn.click();

		WebElement txtBxEmail = driver.findElement(By.xpath(HomePageProperties.SIGN_IN_EMAIL_XPATH));
		txtBxEmail.sendKeys(email);

		WebElement txtBxPassword =driver.findElement(By.xpath(HomePageProperties.SIGN_IN_PASSWORD_XPATH));
		txtBxPassword.sendKeys(password);

		driver.findElement(By.xpath(HomePageProperties.BTN_SIGN_IN_XPATH)).click();

		Assert.assertTrue(homePage.verifySignInLogoDisplayed());

		if(driver.findElement(By.xpath(HomePageProperties.IMG_LOGO_XPATH)).isDisplayed()) {
			Assert.assertTrue(homePage.verifySignInLogoDisplayed());
			testUtil.setCellData("Pass", 1,5, TestUtilProperties.TESTDATA_SHEET_PATH);
		}else {
			testUtil.setCellData("Fail", 1,5, TestUtilProperties.TESTDATA_SHEET_PATH);
			Thread.sleep(2000);
		}
		Thread.sleep(2000);
	}

	//@Test(priority = 3)
	public void verifyNavigateWomenLinkTest(){
		// 1.2. There will be 4 options present to the user in Home page to navigate to different sections. Women, Dresses, T-Shirts, BruteForce.
		extentTestManager.getTest().log(Status.INFO, "Verify navigate to different sections. Women, Dresses, T-Shirts, BruteForce in the Home Page");

		Assert.assertTrue(homePage.verifyMenuWomenDisplayed());
		driver.findElement(By.xpath(HomePageProperties.MENU_WOMEN_XPATH)).click();
		Assert.assertTrue(homePage.verifyMenuDressDisplayed());
		driver.findElement(By.xpath(HomePageProperties.MENU_DRESS_XPATH)).click();
		Assert.assertTrue(homePage.verifyMenuTshirtsDisplayed());
		driver.findElement(By.xpath(HomePageProperties.MENU_TSHIRTS_XPATH)).click();
		Assert.assertTrue(homePage.verifyMenuBruteForceDisplayed());
		driver.findElement(By.xpath(HomePageProperties.MENU_BRUTEFORCE_XPATH)).click();

	}

	//@Test(priority = 4)
	public void verifyNavigateDressLinkTest(){
		// 1.2. There will be 4 options present to the user in Home page to navigate to different sections. Women, Dresses, T-Shirts, BruteForce.

		extentTestManager.getTest().log(Status.INFO, "Verify navigate to different sections. Dresses in the Home Page");

		Assert.assertTrue(homePage.verifyMenuDressDisplayed());

	}

	//@Test(priority = 5)
	public void verifyNavigateTshirtsLinkTest(){ //
		// 1.2. There will be 4 options present to the user in Home page to navigate to different sections. Women, Dresses, T-Shirts, BruteForce.

		extentTestManager.getTest().log(Status.INFO, "Verify navigate to different sections. T-shirts in the Home Page");

		Assert.assertTrue(homePage.verifyMenuTshirtsDisplayed());

	}

	//@Test(priority = 6)
	public void verifyNavigateBruteForceLinkTest(){
		// 1.2. There will be 4 options present to the user in Home page to navigate to different sections. Women, Dresses, T-Shirts, BruteForce.

		extentTestManager.getTest().log(Status.INFO, "Verify navigate to different sections. BruteForce in the Home Page");

		Assert.assertTrue(homePage.verifyMenuBruteForceDisplayed());

	}

	@Test(priority = 7, groups= {"SmokeTest"}, enabled = false)
	public void verifyFeatureProductsVisibleTest(){
		// 1.4. Featured Products should be visible to Users

		extentTestManager.getTest().log(Status.INFO, "Verify Featured Products visible to Users in the Home Page");

		Assert.assertTrue(homePage.verifyFeatureProductsDisplayed());
		List<WebElement> popularProductsName = driver.findElements(By.xpath(HomePageProperties.FEATURE_PRODUCTS_NAME_LISTS_XPATH));
		List<WebElement>  popularProducts = driver.findElements(By.xpath(HomePageProperties.FEATURE_PRODUCTS_BOX_LISTS_XPATH));
		if(popularProductsName.size() == 8){
			System.out.println("PASSED..");
		}else{
			System.out.println("Failed..");
		}
		Assert.assertTrue(homePage.verifyFeatureProductsListDisplayed());
		for(WebElement element: popularProductsName){
			System.out.println("Product Name: " + element.getText());
		}

		Actions act = new Actions(driver);
		List<WebElement>  linkQuickView = driver.findElements(By.xpath(HomePageProperties.FEATURE_PRODUCTS_QUICK_VIEW_LISTS_XPATH));
		for(int i=0; i< popularProducts.size(); i++){
			act.moveToElement(popularProducts.get(i)).build().perform();
			//Thread.sleep(2000);
			System.out.println("Text Name: " + linkQuickView.get(i).getText());
			Assert.assertTrue(linkQuickView.get(i).isDisplayed());
		}

	}

	@Test(priority = 8, groups = {"Regression"})
	public void verifyCheckoutCartVisibleTest(){
		// 1.5. Checkout Cart should be visible to users with Empty.

		extentTestManager.getTest().log(Status.INFO, "Verify Featured Products visible to Users in the Home Page");

		Assert.assertTrue(homePage.verifyCheckoutCartDisplayed());
		Assert.assertTrue(homePage.verifyCheckoutCartEmptyDisplayed());

	}

	//@Test(priority = 9)
	public void verifyQuickViewLinkTest() throws InterruptedException {
		// 1.6. User should be able to view the product details layer by clicking quick view Link.

		extentTestManager.getTest().log(Status.INFO, "Verify Users able to click and view Product Details in the Home Page");

		Assert.assertTrue(homePage.verifyQuickViewLinkDisplayed());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(HomePageProperties.LNK_QUICK_VIEW_XPATH)).click();
		driver.switchTo().parentFrame();
		driver.switchTo().frame(1);

		Thread.sleep(2000);
		driver.findElement(By.xpath(HomePageProperties.BTN_MY_WISHLIST_XPATH)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(HomePageProperties.BTN_MY_WISHLIST_CLOSE_XPATH)).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath(HomePageProperties.PRODUCT_IMAGE_TSHIRTS_01_XPATH)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(HomePageProperties.PRODUCT_IMAGE_TSHIRTS_02_XPATH)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(HomePageProperties.PRODUCT_IMAGE_TSHIRTS_03_XPATH)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(HomePageProperties.PRODUCT_IMAGE_TSHIRTS_04_XPATH)).click();

		Thread.sleep(2000);
		//Assert.assertTrue(homePage.verifyMyWishListDisplayed());

		driver.switchTo().parentFrame();
		driver.findElement(By.xpath(HomePageProperties.BTN_FANCY_POPUP_XPATH));


	}

	//@Test(priority = 10)
	public void verifyProductWishListTest() throws InterruptedException {
		// 1.7. User should be able to add the product to wish list from product details layer.
		extentTestManager.getTest().log(Status.INFO, "Verify Product can added to wish list from product details layer in the Home Page");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement elements = driver.findElement(By.xpath(HomePageProperties.LNK_SIGN_IN_XPATH));
		elements.click();

		driver.findElement(By.xpath(HomePageProperties.SIGN_IN_EMAIL_XPATH)).sendKeys("khaledhasanb@gmail.com");
		driver.findElement(By.xpath(HomePageProperties.SIGN_IN_PASSWORD_XPATH)).sendKeys("khaled1234567890");
		Thread.sleep(3000);
		driver.findElement(By.xpath(HomePageProperties.BTN_SIGN_IN_XPATH)).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(HomePageProperties.HEADER_LOGO_HOME_PAGE_XPATH)).click();

		driver.findElement(By.xpath(HomePageProperties.HOME_FEATURE_PRODUCT_TSHIRTS_XPATH)).click();

		Thread.sleep(3000);
		// Wish List Button Link
		driver.findElement(By.xpath(HomePageProperties.BTN_MY_WISHLIST_XPATH)).click();
		// Quit the close button
		driver.findElement(By.xpath(HomePageProperties.BTN_FANCY_POPUP_XPATH)).click();
		Thread.sleep(3000);
		// Go to User Account
		driver.findElement(By.xpath(HomePageProperties.LNK_CUSTOMER_ACCOUNT_XPATH)).click();

		Thread.sleep(3000);
		// Go to Wish List link
		driver.findElement(By.xpath(HomePageProperties.BTN_LNK_ACCOUNT_MY_WISHLISTS_XPATH)).click();
		Thread.sleep(3000);

		Assert.assertTrue(homePage.verifyWishListLinkDisplayed());
		// View Wish List text in the link
		driver.findElement(By.xpath(HomePageProperties.LNK_WISHLIST_XPATH)).click();
		Thread.sleep(3000);
		// Save Wish List Items
		driver.findElement(By.xpath(HomePageProperties.MY_WISHLISTS_ITEM_SAVE_XPATH)).click();
		Thread.sleep(3000);
		// Close Wish List Items
		driver.findElement(By.xpath(HomePageProperties.MY_WISHLISTS_ITEM_CLOSE_XPATH)).click();


		Thread.sleep(3000);
		// Logout Account
		driver.findElement(By.xpath(HomePageProperties.SIGN_OUT_XPATH)).click();

	}

	//@Test(priority = 11)
	public void verifyDetailOrderViewLinkTest() throws InterruptedException {
		// 1.8. User should be able to view details order from My Account section.
		extentTestManager.getTest().log(Status.INFO, "Verify to view details order from My Account section in the Home Page");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement elements = driver.findElement(By.xpath(HomePageProperties.LNK_SIGN_IN_XPATH));
		elements.click();

		driver.findElement(By.xpath(HomePageProperties.SIGN_IN_EMAIL_XPATH)).sendKeys("khaledhasanb@gmail.com");
		driver.findElement(By.xpath(HomePageProperties.SIGN_IN_PASSWORD_XPATH)).sendKeys("khaled1234567890");
		Thread.sleep(3000);
		driver.findElement(By.xpath(HomePageProperties.BTN_SIGN_IN_XPATH)).click();
		Thread.sleep(3000);

		// Order History and Details link
		driver.findElement(By.xpath(HomePageProperties.BTN_LNK_ACCOUNT_ORDER_HISTORY_AND_DETAILS_XPATH)).click();
		// My Order Link (Same as above link)
		//driver.findElement(By.xpath(HomePageProperties.LNK_MY_ACCOUNT_MY_ORDERS_XPATH)).click();

		WebElement actual = driver.findElement(By.xpath(HomePageProperties.TXT_ORDER_HISTORY_XPATH));
		WebElement expected = driver.findElement(By.xpath(HomePageProperties.TXT_ORDER_HISTORY_CLONE_XPATH));

		Assert.assertTrue(homePage.verifyOrderHistoryDisplayed());

		if (actual.equals(expected)){
			System.out.println("Pass");
		}
		else{
			System.out.println("Failed");
		}

		Thread.sleep(3000);
		// Logout Account
		driver.findElement(By.xpath(HomePageProperties.SIGN_OUT_XPATH)).click();


	}
	
	//@Test(priority = 12)
	public void verifyContactUsLinkTest(){
		// 1.9. Contact Us Link should be presented to the user.
		extentTestManager.getTest().log(Status.INFO, "Verify Contact Us Link in the Home Page");
		contactsPage = homePage.clickOnContactsLink();
		Assert.assertTrue(contactsPage.verifyContactsLabel());
	}

	//@Test(priority = 13)
	public void verifyBestSellerLinkTest() throws InterruptedException {
		// 1.1.1. User should be able to filter result using popular or best seller link
		extentTestManager.getTest().log(Status.INFO, "Verify Filter result sing popular or best seller link in the Home Page");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement elements = driver.findElement(By.xpath(HomePageProperties.LNK_SIGN_IN_XPATH));
		elements.click();

		driver.findElement(By.xpath(HomePageProperties.SIGN_IN_EMAIL_XPATH)).sendKeys("khaledhasanb@gmail.com");
		driver.findElement(By.xpath(HomePageProperties.SIGN_IN_PASSWORD_XPATH)).sendKeys("khaled1234567890");
		Thread.sleep(3000);
		driver.findElement(By.xpath(HomePageProperties.BTN_SIGN_IN_XPATH)).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(HomePageProperties.HEADER_LOGO_HOME_PAGE_XPATH)).click();

		Assert.assertTrue(homePage.verifyBestSellerLinkDisplayed());
		Thread.sleep(3000);
		driver.findElement(By.xpath(HomePageProperties.LNK_BEST_SELLER_XPATH)).click();

		Assert.assertTrue(homePage.verifyPopularLinkDisplayed());
		Thread.sleep(3000);
		driver.findElement(By.xpath(HomePageProperties.LNK_POPULAR_XPATH)).click();

		Thread.sleep(3000);
		// Logout Account
		driver.findElement(By.xpath(HomePageProperties.SIGN_OUT_XPATH)).click();



	}

	//@Test(priority = 14)
	public void verifyNewsLetterLinkTest() throws Exception {
		// 1.1.2. User should be subscribe/unsubscribe for Upcoming newsletter.
		extentTestManager.getTest().log(Status.INFO, "Verify Newsletter Link working in the Home Page");

		testUtil.setExcelFile(TestUtilProperties.TESTDATA_SHEET_PATH, TestUtilProperties.sheetNewsletter);
		String email = testUtil.getCellData(1,1);

		WebElement txtBxEmail = driver.findElement(By.xpath(HomePageProperties.TXT_BOX_EMAIL_FOR_NEWSLETTER_XPATH));
		txtBxEmail.clear();
		txtBxEmail.sendKeys(email);

		Thread.sleep(3000);
		//driver.findElement(By.xpath(HomePageProperties.BTN_SUBMIT_NEWSLETTER_XPATH));
		driver.findElement(By.xpath(HomePageProperties.BTN_SUBMIT_NEWSLETTER_XPATH)).click();
		Assert.assertTrue(homePage.verifyNewsLetterSuccessDisplayed());

		// Newsletter : You have successfully subscribed to this newsletter.

		WebElement actual = driver.findElement(By.xpath(HomePageProperties.NEWS_LETTER_SUCCESS_XPATH));

		//WebElement expected = driver.findElement(By.xpath("//p[contains(text(),' Newsletter : This email address is already registered.')]"));

		//WebElement alertNewsletter = driver.findElement(By.xpath(HomePageProperties.NEWS_LETTER_UN_SUCCESS_XPATH));

		if (actual.isDisplayed()){
			System.out.println("Pass");
		}
		else{
			System.out.println("Failed");
		}

		Thread.sleep(3000);

		//driver.getCurrentUrl();
		/*if(actual.isDisplayed()) {
			testUtil.setCellData("Pass", 1,2, TestUtilProperties.TESTDATA_SHEET_PATH);
		}else {
			testUtil.setCellData("Fail", 1,2, TestUtilProperties.TESTDATA_SHEET_PATH);
			Thread.sleep(2000);
		}*/

		if(actual.getText().equals("Newsletter : You have successfully subscribed to this newsletter.")) {
			testUtil.setCellData("Pass", 1,2, TestUtilProperties.TESTDATA_SHEET_PATH);
		}else {
			testUtil.setCellData("Fail", 1,2, TestUtilProperties.TESTDATA_SHEET_PATH);
			Thread.sleep(2000);
		}
	}

	//@Test(priority = 15)
	public void verifySearchBoxTest() throws InterruptedException {
		// 1.1.3. User should be able to search for specific products by keyword.

		extentTestManager.getTest().log(Status.INFO, "Verify to search for specific products by keyword in the Home Page");
		Assert.assertTrue(homePage.verifySearchBoxDisplayed());
		// Search box
		driver.findElement(By.xpath(HomePageProperties.TXT_BOX_SEARCH_TOP_XPATH)).sendKeys("Dress");

		driver.findElement(By.xpath(HomePageProperties.BTN_SUBMIT_SEARCH_TOP_XPATH)).click();
		Thread.sleep(3000);
		Assert.assertTrue(homePage.verifyPrintedDressImageDisplayed());
		Thread.sleep(3000);

	}

	//@Test(priority = 16)
	public void verifyFollowFacebookLinkTest() throws InterruptedException {
		// 1.1.4. User should be presented to follow us on Facebook link.

		extentTestManager.getTest().log(Status.INFO, "Verify to follow us on Facebook link in the Home Page");
		Assert.assertTrue(homePage.verifyFollowFacebookLinkDisplayed());
		// Follow Us FaceBook Link
		driver.findElement(By.xpath(HomePageProperties.LNK_FOLLOW_FACEBOOK_XPATH)).click();

		Set<String> windowsTabbed = driver.getWindowHandles();
		Iterator<String> it = windowsTabbed.iterator();
		while (it.hasNext()) {
			String Window = it.next();
			driver.switchTo().window(Window);
			if (driver.getTitle().equals("eBFS - the power of choice")){
				driver.close();
			}
		}

		Thread.sleep(3000);
		//driver.navigate().to("http://ebfs.bruteforcesolution.net/ebfs/index.php");
		driver.navigate().to(prop.getProperty("url"));

		WebElement elements = driver.findElement(By.xpath(HomePageProperties.LNK_SIGN_IN_XPATH));
		elements.click();

		driver.findElement(By.xpath(HomePageProperties.SIGN_IN_EMAIL_XPATH)).sendKeys("khaledhasanb@gmail.com");
		driver.findElement(By.xpath(HomePageProperties.SIGN_IN_PASSWORD_XPATH)).sendKeys("khaled1234567890");
		Thread.sleep(3000);
		driver.findElement(By.xpath(HomePageProperties.BTN_SIGN_IN_XPATH)).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(HomePageProperties.HEADER_LOGO_HOME_PAGE_XPATH)).click();

		Assert.assertTrue(homePage.verifyFollowFacebookLinkDisplayed());
		// Follow Us FaceBook Link
		driver.findElement(By.xpath(HomePageProperties.LNK_FOLLOW_FACEBOOK_XPATH)).click();

		Set<String> windowsTabbed1 = driver.getWindowHandles();
		Iterator<String> it1 = windowsTabbed1.iterator();
		while (it1.hasNext()) {
			String Window = it1.next();

			driver.switchTo().window(Window);
			if (driver.getTitle().equals("eBFS - the power of choice")){
				driver.close();
			}
		}

		Thread.sleep(3000);
	}


	//@Test(priority = 17)
	public void verifyRegistrationProcessTest() throws Exception {
		// 1.1.5. User should be able to register by clicking Login link

		extentTestManager.getTest().log(Status.INFO, "Verify to register by clicking Login link in the Home Page");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		testUtil.setExcelFile(TestUtilProperties.TESTDATA_SHEET_PATH, TestUtilProperties.sheetRegistration);
		String email = testUtil.getCellData(1,1);
		String firstName = testUtil.getCellData(1,2);
		String lastName = testUtil.getCellData(1,3);
		String password = testUtil.getCellData(1,4);


		driver.findElement(By.xpath(HomePageProperties.LNK_SIGN_IN_XPATH)).click();

		Assert.assertTrue(homePage.verifyCreateAccountButtonDisplayed());

		WebElement txtBxEmail = driver.findElement(By.xpath(HomePageProperties.REGISTRATION_EMAIL_XPATH));
		txtBxEmail.clear();
		txtBxEmail.sendKeys(email);

		driver.findElement(By.xpath(HomePageProperties.BTN_CREATE_AN_ACCOUNT_XPATH)).click();

		//Thread.sleep(2000);
		try {
			driver.findElement(By.xpath(HomePageProperties.TXT_REGISTRATION_ERR_EMAIL_XPATH));

			System.out.println("An account using this email address has already been registered. Please enter a valid password or request a new one.");
			testUtil.setCellData("Err Email Failed", 1, 5, TestUtilProperties.TESTDATA_SHEET_PATH);
			Thread.sleep(2000);
			driver.quit();

		}
		catch (NoSuchElementException e) {

			driver.findElement(By.xpath(HomePageProperties.BTN_RADIO_MALE_XPATH)).click();

			WebElement txtFirstName = driver.findElement(By.xpath(HomePageProperties.REGISTRATION_FIRST_NAME_XPATH));
			txtFirstName.clear();
			txtFirstName.sendKeys(firstName);

			WebElement txtLastName = driver.findElement(By.xpath(HomePageProperties.REGISTRATION_LAST_NAME_XPATH));
			txtLastName.clear();
			txtLastName.sendKeys(lastName);

			WebElement txtPassword = driver.findElement(By.xpath(HomePageProperties.REGISTRATION_PASSWORD_XPATH));
			txtPassword.clear();
			txtPassword.sendKeys(password);

			Select days = new Select(driver.findElement(By.xpath(HomePageProperties.REGISTRATION_DOB_DAYS_XPATH)));
			days.selectByIndex(16);
			Select months = new Select(driver.findElement(By.xpath(HomePageProperties.REGISTRATION_DOB_MONTHS_XPATH)));
			months.selectByValue("3");
			Select years = new Select(driver.findElement(By.xpath(HomePageProperties.REGISTRATION_DOB_YEARS_XPATH)));
			years.selectByValue("1981");

			driver.findElement(By.xpath(HomePageProperties.REGISTRATION_CHECKBOX_NEWSLETTER_XPATH)).click();
			Thread.sleep(3000);

			Assert.assertTrue(homePage.verifyRegisterSubmitButtonDisplayed());
			driver.findElement(By.xpath(HomePageProperties.BTN_REGISTER_ACCOUNT_XPATH)).click();
			Thread.sleep(3000);

			WebElement actual = driver.findElement(By.xpath(HomePageProperties.TXT_REGISTRATION_CONFIRMATION_ACCOUNT_XPATH));
			if (actual.isDisplayed()) {
				testUtil.setCellData("Pass", 1, 5, TestUtilProperties.TESTDATA_SHEET_PATH);
			} else {
				testUtil.setCellData("Fail", 1, 5, TestUtilProperties.TESTDATA_SHEET_PATH);
				Thread.sleep(2000);
			}

		/*driver.getCurrentUrl();
		if(driver.getCurrentUrl().equals("http://ebfs.bruteforcesolution.net/ebfs/index.php?controller=my-account")) {
			testUtil.setCellData("Pass", 1,5, TestUtilProperties.TESTDATA_SHEET_PATH);
		}else {
			testUtil.setCellData("Fail", 1,5, TestUtilProperties.TESTDATA_SHEET_PATH);
			Thread.sleep(2000);
		}*/


			// Logout Account
			driver.findElement(By.xpath(HomePageProperties.SIGN_OUT_XPATH)).click();
			Thread.sleep(3000);
		}

	}



	
	
	@AfterMethod(groups= {"BAF"})
	public void tearDown(){
		driver.quit();
	}


}
