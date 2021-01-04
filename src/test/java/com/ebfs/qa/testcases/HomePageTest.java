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
	public void verifyLogoTest(){ //1.1. BruteForce the power of choice..... Logo should be visible to all users.
		extentTestManager.getTest().log(Status.INFO, "Verify Logo in the Home Page");
		Assert.assertTrue(homePage.verifyLogoDisplayed());
	}

	@Test(priority = 3)
	public void verifyNavigateWomenLinkTest(){ // 1.2. There will be 4 options present to the user in Home page to navigate to different sections. Women, Dresses, T-Shirts, BruteForce.
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
	public void verifyNavigateDressLinkTest(){ // 1.2. There will be 4 options present to the user in Home page to navigate to different sections. Women, Dresses, T-Shirts, BruteForce.

		extentTestManager.getTest().log(Status.INFO, "Verify navigate to different sections. Dresses in the Home Page");

		Assert.assertTrue(homePage.verifyMenuDressDisplayed());

	}

	@Test(priority = 5)
	public void verifyNavigateTshirtsLinkTest(){ // 1.2. There will be 4 options present to the user in Home page to navigate to different sections. Women, Dresses, T-Shirts, BruteForce.

		extentTestManager.getTest().log(Status.INFO, "Verify navigate to different sections. T-shirts in the Home Page");

		Assert.assertTrue(homePage.verifyMenuTshirtsDisplayed());

	}

	@Test(priority = 6)
	public void verifyNavigateBruteForceLinkTest(){ // 1.2. There will be 4 options present to the user in Home page to navigate to different sections. Women, Dresses, T-Shirts, BruteForce.

		extentTestManager.getTest().log(Status.INFO, "Verify navigate to different sections. BruteForce in the Home Page");

		Assert.assertTrue(homePage.verifyMenuBruteForceDisplayed());

	}

	@Test(priority = 7)
	public void verifyFeatureProductsVisibleTest(){ // 1.4. Featured Products should be visible to Users

		extentTestManager.getTest().log(Status.INFO, "Verify Featured Products visible to Users in the Home Page");

		Assert.assertTrue(homePage.verifyFeatureProductsDisplayed());

	}

	@Test(priority = 8)
	public void verifyCheckoutCartVisibleTest(){ // 1.5. Checkout Cart should be visible to users with Empty.

		extentTestManager.getTest().log(Status.INFO, "Verify Featured Products visible to Users in the Home Page");

		Assert.assertTrue(homePage.verifyCheckoutCartDisplayed());
		Assert.assertTrue(homePage.verifyCheckoutCartEmptyDisplayed());

	}

	@Test(priority = 9)
	public void verifyQuickViewLinkTest() throws InterruptedException { // 1.6. User should be able to view the product details layer by clicking quick view Link.

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
	public void verifyProductWishListTest() throws InterruptedException { // 1.7. User should be able to add the product to wish list from product details layer.
		extentTestManager.getTest().log(Status.INFO, "Verify Product can added to wish list from product details layer in the Home Page");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement elements = driver.findElement(By.className("login"));
		elements.click();

		driver.findElement(By.id("email")).sendKeys("khaledhasanb@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("khaled1234567890");
		Thread.sleep(3000);
		driver.findElement(By.id("SubmitLogin")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@id='header_logo']")).click();


		driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[1]/div/div[2]/h5/a")).click();

		Thread.sleep(3000);
		// Wish List Button Link
		driver.findElement(By.xpath("//a[@id='wishlist_button']")).click();
		// Quit the close button
		driver.findElement(By.xpath("//a[@class='fancybox-item fancybox-close']")).click();
		Thread.sleep(3000);
		// Go to User Account
		driver.findElement(By.xpath("//a[@title='View my customer account']")).click();

		Thread.sleep(3000);
		// Go to Wish List link
		driver.findElement(By.xpath("//a[@title='My wishlists']")).click();
		Thread.sleep(3000);

		Assert.assertTrue(homePage.verifyWishListLinkDisplayed());
		// View Wish List text in the link
		driver.findElement(By.xpath("//*[@id=\"wishlist_33\"]/td[1]/a")).click();
		Thread.sleep(3000);
		// Save Wish List Items
		driver.findElement(By.xpath("//a[@title='Save']")).click();
		Thread.sleep(3000);
		// Close Wish List Items
		driver.findElement(By.xpath("//a[@id='hideSendWishlist']")).click();


		Thread.sleep(3000);
		// Logout Account
		driver.findElement(By.xpath("//a[@class='logout' and @title='Log me out']")).click();

	}

	@Test(priority = 11)
	public void verifyDetailOrderViewLinkTest() throws InterruptedException { // 1.8. User should be able to view details order from My Account section.
		extentTestManager.getTest().log(Status.INFO, "Verify to view details order from My Account section in the Home Page");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement elements = driver.findElement(By.className("login"));
		elements.click();

		driver.findElement(By.id("email")).sendKeys("khaledhasanb@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("khaled1234567890");
		Thread.sleep(3000);
		driver.findElement(By.id("SubmitLogin")).click();
		Thread.sleep(3000);

		// Order History and Details link
		driver.findElement(By.xpath("//a[@title='Orders']")).click();
		// My Order Link (Same as above link)
		//driver.findElement(By.xpath("//a[@title='My orders']")).click();

		WebElement actual = driver.findElement(By.xpath("//h1[contains(text(),'Order history')]"));
		WebElement expected = driver.findElement(By.xpath("//h1[@class='page-heading bottom-indent']"));

		Assert.assertTrue(homePage.verifyOrderHistoryDisplayed());

		if (actual.equals(expected)){
			System.out.println("Pass");
		}
		else{
			System.out.println("Failed");
		}

		Thread.sleep(3000);
		// Logout Account
		driver.findElement(By.xpath("//a[@class='logout' and @title='Log me out']")).click();


	}
	
	@Test(priority = 12)
	public void verifyContactUsLinkTest(){ // 1.9. Contact Us Link should be presented to the user.
		extentTestManager.getTest().log(Status.INFO, "Verify Contact Us Link in the Home Page");
		contactsPage = homePage.clickOnContactsLink();
		
		Assert.assertTrue(contactsPage.verifyContactsLabel());
	}

	@Test(priority = 13)
	public void verifyBestSellerLinkTest() throws InterruptedException { // 1.1.1. User should be able to filter result using popular or best seller link
		extentTestManager.getTest().log(Status.INFO, "Verify Filter result sing popular or best seller link in the Home Page");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement elements = driver.findElement(By.className("login"));
		elements.click();

		driver.findElement(By.id("email")).sendKeys("khaledhasanb@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("khaled1234567890");
		Thread.sleep(3000);
		driver.findElement(By.id("SubmitLogin")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@id='header_logo']")).click();

		Assert.assertTrue(homePage.verifyBestSellerLinkDisplayed());
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='blockbestsellers']")).click();

		Assert.assertTrue(homePage.verifyPopularLinkDisplayed());
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='homefeatured']")).click();

		Thread.sleep(3000);
		// Logout Account
		driver.findElement(By.xpath("//a[@class='logout' and @title='Log me out']")).click();



	}

	@Test(priority = 14)
	public void verifyNewsLetterLinkTest(){ // 1.1.2. User should be subscribe/unsubscribe for Upcoming newsletter.
		extentTestManager.getTest().log(Status.INFO, "Verify Newsletter Link working in the Home Page");

		/*String email = "khaled011@gmail.com";
		WebElement txtBxEmail = driver.findElement(By.xpath("//input[@id='newsletter-input']"));
		txtBxEmail.sendKeys(email);

		//driver.findElement(By.xpath("//button[@name='submitNewsletter']"));
		driver.findElement(By.xpath("//button[@name='submitNewsletter']")).click();
		Assert.assertTrue(homePage.verifyNewsLetterSuccessDisplayed());*/

		// Newsletter : You have successfully subscribed to this newsletter.

		/*WebElement actual = driver.findElement(By.xpath("//p[contains(text(),'Newsletter : You have successfully subscribed to this newsletter.')]"));

		//WebElement expected = driver.findElement(By.xpath("//p[contains(text(),' Newsletter : This email address is already registered.')]"));

		if (actual.isDisplayed()){
			System.out.println("Pass");
		}
		else{
			System.out.println("Failed");
		}*/

	}

	@Test(priority = 15)
	public void verifySearchBoxTest() throws InterruptedException { // 1.1.3. User should be able to search for specific products by keyword.

		extentTestManager.getTest().log(Status.INFO, "Verify to search for specific products by keyword in the Home Page");
		Assert.assertTrue(homePage.verifySearchBoxDisplayed());
		// Search box
		driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys("Dress");

		driver.findElement(By.xpath("//button[@class='btn btn-default button-search']")).click();
		Thread.sleep(3000);
		Assert.assertTrue(homePage.verifyPrintedDressImageDisplayed());
		Thread.sleep(3000);

	}

	@Test(priority = 16)
	public void verifyFollowFacebookLinkTest() throws InterruptedException { // 1.1.4. User should be presented to follow us on Facebook link.

		extentTestManager.getTest().log(Status.INFO, "Verify to follow us on Facebook link in the Home Page");
		Assert.assertTrue(homePage.verifyFollowFacebookLinkDisplayed());
		// Follow Us FaceBook Link
		driver.findElement(By.xpath("//li[@class='facebook']")).click();

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
		driver.navigate().to("http://ebfs.bruteforcesolution.net/ebfs/index.php");

		WebElement elements = driver.findElement(By.className("login"));
		elements.click();

		driver.findElement(By.id("email")).sendKeys("khaledhasanb@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("khaled1234567890");
		Thread.sleep(3000);
		driver.findElement(By.id("SubmitLogin")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("//div[@id='header_logo']")).click();

		Assert.assertTrue(homePage.verifyFollowFacebookLinkDisplayed());
		// Follow Us FaceBook Link
		driver.findElement(By.xpath("//li[@class='facebook']")).click();

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


	@Test(priority = 17)
	public void verifyRegistrationProcessTest() throws InterruptedException { // 1.1.5. User should be able to register by clicking Login link

		extentTestManager.getTest().log(Status.INFO, "Verify to register by clicking Login link in the Home Page");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@class='login']")).click();

		Assert.assertTrue(homePage.verifyCreateAccountButtonDisplayed());
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("khaledhasan003@gmail.com");
		driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Khaled");
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("Hasan");
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("9293368556");

		Select days = new Select(driver.findElement(By.xpath("//select[@id='days']")));
		days.selectByIndex(11);
		Select months = new Select(driver.findElement(By.xpath("//select[@id='months']")));
		months.selectByValue("3");
		Select years = new Select(driver.findElement(By.xpath("//select[@id='years']")));
		years.selectByVisibleText("2000  ");

		driver.findElement(By.xpath("//input[@id='newsletter']")).click();
		Thread.sleep(3000);

		Assert.assertTrue(homePage.verifyRegisterSubmitButtonDisplayed());
		driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
		Thread.sleep(3000);
		// Logout Account
		driver.findElement(By.xpath("//a[@class='logout' and @title='Log me out']")).click();

		Thread.sleep(3000);
	}



	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}


}
