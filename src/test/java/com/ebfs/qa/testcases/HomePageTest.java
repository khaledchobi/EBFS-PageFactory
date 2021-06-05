package com.ebfs.qa.testcases;

import com.ebfs.qa.properties.HomePageProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();		
		homePage = new HomePage();
		extentTestManager = new ExtentTestManager();
	}
	
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest(){
		extentTestManager.getTest().log(Status.INFO, "Verify Home Page Title");
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, HomePageTestProperties.EXP_HOMEPAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void verifyLogoTest(){
		//1.1. BruteForce the power of choice..... Logo should be visible to all users.
		extentTestManager.getTest().log(Status.INFO, "Verify Logo in the Home Page");
		Assert.assertTrue(homePage.verifyLogoDisplayed());
	}

	@Test(priority = 3)
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

	@Test(priority = 4)
	public void verifyNavigateDressLinkTest(){
		// 1.2. There will be 4 options present to the user in Home page to navigate to different sections. Women, Dresses, T-Shirts, BruteForce.

		extentTestManager.getTest().log(Status.INFO, "Verify navigate to different sections. Dresses in the Home Page");

		Assert.assertTrue(homePage.verifyMenuDressDisplayed());

	}

	@Test(priority = 5)
	public void verifyNavigateTshirtsLinkTest(){ //
		// 1.2. There will be 4 options present to the user in Home page to navigate to different sections. Women, Dresses, T-Shirts, BruteForce.

		extentTestManager.getTest().log(Status.INFO, "Verify navigate to different sections. T-shirts in the Home Page");

		Assert.assertTrue(homePage.verifyMenuTshirtsDisplayed());

	}

	@Test(priority = 6)
	public void verifyNavigateBruteForceLinkTest(){
		// 1.2. There will be 4 options present to the user in Home page to navigate to different sections. Women, Dresses, T-Shirts, BruteForce.

		extentTestManager.getTest().log(Status.INFO, "Verify navigate to different sections. BruteForce in the Home Page");

		Assert.assertTrue(homePage.verifyMenuBruteForceDisplayed());

	}

	@Test(priority = 7)
	public void verifyFeatureProductsVisibleTest(){
		// 1.4. Featured Products should be visible to Users

		extentTestManager.getTest().log(Status.INFO, "Verify Featured Products visible to Users in the Home Page");

		Assert.assertTrue(homePage.verifyFeatureProductsDisplayed());

	}

	@Test(priority = 8)
	public void verifyCheckoutCartVisibleTest(){
		// 1.5. Checkout Cart should be visible to users with Empty.

		extentTestManager.getTest().log(Status.INFO, "Verify Featured Products visible to Users in the Home Page");

		Assert.assertTrue(homePage.verifyCheckoutCartDisplayed());
		Assert.assertTrue(homePage.verifyCheckoutCartEmptyDisplayed());

	}

	@Test(priority = 9)
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

	@Test(priority = 10)
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

	@Test(priority = 11)
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
	
	@Test(priority = 12)
	public void verifyContactUsLinkTest(){
		// 1.9. Contact Us Link should be presented to the user.
		extentTestManager.getTest().log(Status.INFO, "Verify Contact Us Link in the Home Page");
		contactsPage = homePage.clickOnContactsLink();
		Assert.assertTrue(contactsPage.verifyContactsLabel());
	}

	@Test(priority = 13)
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
	public void verifyNewsLetterLinkTest() throws InterruptedException {
		// 1.1.2. User should be subscribe/unsubscribe for Upcoming newsletter.
		extentTestManager.getTest().log(Status.INFO, "Verify Newsletter Link working in the Home Page");

		String email = "khaled0117@gmail.com";
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

		if (actual.isDisplayed()){
			System.out.println("Pass");
		}
		else{
			System.out.println("Failed");
		}

		Thread.sleep(3000);
	}

	@Test(priority = 15)
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

	@Test(priority = 16)
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
	public void verifyRegistrationProcessTest() throws InterruptedException {
		// 1.1.5. User should be able to register by clicking Login link

		extentTestManager.getTest().log(Status.INFO, "Verify to register by clicking Login link in the Home Page");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(HomePageProperties.LNK_SIGN_IN_XPATH)).click();

		Assert.assertTrue(homePage.verifyCreateAccountButtonDisplayed());
		driver.findElement(By.xpath(HomePageProperties.REGISTRATION_EMAIL_XPATH)).sendKeys("khaledhasan010@gmail.com");
		driver.findElement(By.xpath(HomePageProperties.BTN_CREATE_AN_ACCOUNT_XPATH)).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath(HomePageProperties.BTN_RADIO_MALE_XPATH)).click();
		driver.findElement(By.xpath(HomePageProperties.REGISTRATION_FIRST_NAME_XPATH)).sendKeys("Khaled");
		driver.findElement(By.xpath(HomePageProperties.REGISTRATION_LAST_NAME_XPATH)).sendKeys("Hasan");
		driver.findElement(By.xpath(HomePageProperties.REGISTRATION_PASSWORD_XPATH)).sendKeys("khaled1234567890");

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
		// Logout Account
		driver.findElement(By.xpath(HomePageProperties.SIGN_OUT_XPATH)).click();
		Thread.sleep(3000);
	}



	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}


}
