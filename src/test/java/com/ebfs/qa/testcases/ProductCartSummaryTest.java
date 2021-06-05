package com.ebfs.qa.testcases;

import com.aventstack.extentreports.Status;
import com.ebfs.qa.base.TestBase;
import com.ebfs.qa.pages.HomePage;
import com.ebfs.qa.pages.ProductCategoryPage;
import com.ebfs.qa.properties.ProductCategoryPageProperties;
import com.ebfs.qa.testcase.properties.ContactsPageTestProperties;
import com.ebfs.qa.testcase.properties.HomePageTestProperties;
import com.ebfs.qa.testcase.properties.ProductCategoryPageTestProperties;
import com.ebfs.qa.util.TestUtil;
import com.qa.ExtentReportListener.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ProductCartSummaryTest extends TestBase {
    //WebDriver driver;
    HomePage homePage;
    TestUtil testUtil;
    ProductCategoryPage productCategoryPage;
    //String sheetName = "SignIn";
    ExtentTestManager extentTestManager;
    //TestUtil testUtil = new TestUtil();

    public ProductCartSummaryTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException{
        initialization();
        testUtil = new TestUtil();
        productCategoryPage = new ProductCategoryPage();
        homePage = new HomePage();
        //productCategoryPage = homePage.clickOnProductCategoryLink(); // This link clicked for Menu Women Link
        //productCategoryPage = productCategoryPage.clickOnProductCategoryLink(); // This link clicked for Categories Women link

    }

    @Test(priority = 36)
    public void verifyNumberOfItemsAddedToCartTest() throws InterruptedException {
        // 3.1. Shopping Cart Summary page should display number of items added to the cart.
        ExtentTestManager.getTest().log(Status.INFO, "Verify Number of items added to cart displayed on the Shopping Cart Summary page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // With add products in Cart
        Thread.sleep(1000);
        // Menu Women
        driver.findElement(By.xpath(ProductCategoryPageProperties.MENU_WOMEN_XPATH)).click();

        Thread.sleep(1000);
        WebElement TShirts = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_TSHIRTS_XPATH));
        Actions actions = new Actions(driver);
        actions.moveToElement(TShirts).perform();

        Thread.sleep(1000);
        // Add to cart T-Shirts
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_TSHIRTS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();

        Thread.sleep(3000);
        WebElement printedDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_DRESS_XPATH));
        actions.moveToElement(printedDress).perform();

        Thread.sleep(1000);
        // Add to cart Printed Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_DRESS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();


        Thread.sleep(1000);
        WebElement printedChiffonDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_CHIFFON_DRESS_XPATH));
        actions.moveToElement(printedChiffonDress).perform();

        Thread.sleep(1000);
        // Add to cart Printed Chiffon Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_CHIFFON_DRESS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();


        Thread.sleep(1000);
        WebElement printedSummerDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_SUMMER_DRESS_XPATH));
        actions.moveToElement(printedSummerDress).perform();

        Thread.sleep(1000);
        // Add to cart Printed Summer Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_SUMMER_DRESS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PROCEED_TO_CHECKOUT_XPATH)).click();


        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());

        Thread.sleep(1000);
        // Proceed to Checkout
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_PROCEED_TO_CHECKOUT_XPATH)).click();

        Thread.sleep(1000);
        // Go to Homepage
        driver.findElement(By.xpath(ProductCategoryPageProperties.HEADER_LOGO_HOME_PAGE_XPATH)).click();

        Thread.sleep(1000);
        WebElement shoppingCart = driver.findElement(By.xpath(ProductCategoryPageProperties.VIEW_MY_SHOPPING_CART_XPATH));
        actions.moveToElement(shoppingCart).perform();

        Assert.assertTrue(productCategoryPage.verifyCheckOutButtonEnabled());
        Thread.sleep(1000);
        // Click Checkout Button
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_CHECK_OUT_SHOPPING_CART_XPATH)).click();

        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());

        Thread.sleep(1000);
        // Go to Homepage
        driver.findElement(By.xpath(ProductCategoryPageProperties.HEADER_LOGO_HOME_PAGE_XPATH)).click();

        Thread.sleep(1000);
        // Sign In Button clicked
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_XPATH)).click();

        Thread.sleep(1000);
        // Sign Button Displayed
        Assert.assertTrue(productCategoryPage.verifySignInButtonDisplayed());

        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_EMAIL_XPATH)).sendKeys("khaledhasanb@gmail.com");
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_PASSWORD_XPATH)).sendKeys("khaled1234567890");
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_SIGN_IN_XPATH)).click();
        Thread.sleep(3000);

        WebElement shoppingCart_01 = driver.findElement(By.xpath(ProductCategoryPageProperties.VIEW_MY_SHOPPING_CART_XPATH));
        actions.moveToElement(shoppingCart_01).perform();

        Assert.assertTrue(productCategoryPage.verifyCheckOutButtonEnabled());
        Thread.sleep(1000);
        // Click Check Out button
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_CHECK_OUT_SHOPPING_CART_XPATH)).click();

        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());

        Thread.sleep(1000);
        // Log Out from Account
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_OUT_XPATH)).click();





    }

    @Test(priority = 37)
    public void verifyDeleteItemsFromShoppingCartTest() throws InterruptedException {
        // 3.2. User should be able to delete the item.
        ExtentTestManager.getTest().log(Status.INFO, "Verify User able to delete item on the Shopping Cart Summary page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // With add products in Cart
        Thread.sleep(1000);
        // Menu Women
        driver.findElement(By.xpath(ProductCategoryPageProperties.MENU_WOMEN_XPATH)).click();

        Thread.sleep(1000);
        WebElement TShirts = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_TSHIRTS_XPATH));
        Actions actions = new Actions(driver);
        actions.moveToElement(TShirts).perform();

        Thread.sleep(1000);
        // Add to cart T-Shirts
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_TSHIRTS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();

        Thread.sleep(3000);
        WebElement printedDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_DRESS_XPATH));
        actions.moveToElement(printedDress).perform();

        Thread.sleep(1000);
        // Add to cart Printed Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_DRESS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();


        Thread.sleep(1000);
        WebElement printedChiffonDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_CHIFFON_DRESS_XPATH));
        actions.moveToElement(printedChiffonDress).perform();

        Thread.sleep(1000);
        // Add to cart Printed Chiffon Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_CHIFFON_DRESS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();


        Thread.sleep(1000);
        WebElement printedSummerDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_SUMMER_DRESS_XPATH));
        actions.moveToElement(printedSummerDress).perform();

        Thread.sleep(1000);
        // Add to cart Printed Summer Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_SUMMER_DRESS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PROCEED_TO_CHECKOUT_XPATH)).click();


        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());

        Thread.sleep(1000);
        // Proceed to Checkout
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_PROCEED_TO_CHECKOUT_XPATH)).click();

        Thread.sleep(1000);
        // Go to Homepage
        driver.findElement(By.xpath(ProductCategoryPageProperties.HEADER_LOGO_HOME_PAGE_XPATH)).click();

        Thread.sleep(1000);
        WebElement shoppingCart = driver.findElement(By.xpath(ProductCategoryPageProperties.VIEW_MY_SHOPPING_CART_XPATH));
        actions.moveToElement(shoppingCart).perform();

        Assert.assertTrue(productCategoryPage.verifyCheckOutButtonEnabled());
        Thread.sleep(1000);
        // Click Checkout Button
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_CHECK_OUT_SHOPPING_CART_XPATH)).click();

        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());

        // Delete Items from Shopping Cart T-Shirts Before Sign In
        driver.findElement(By.xpath(ProductCategoryPageProperties.DELETE_ITEM_SHOPPING_CART_TSHIRTS_XPATH)).click();

        Thread.sleep(1000);
        // Go to Homepage
        driver.findElement(By.xpath(ProductCategoryPageProperties.HEADER_LOGO_HOME_PAGE_XPATH)).click();

        Thread.sleep(1000);
        // Sign In Button clicked
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_XPATH)).click();

        Thread.sleep(1000);
        // Sign Button Displayed
        Assert.assertTrue(productCategoryPage.verifySignInButtonDisplayed());

        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_EMAIL_XPATH)).sendKeys("khaledhasanb@gmail.com");
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_PASSWORD_XPATH)).sendKeys("khaled1234567890");
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_SIGN_IN_XPATH)).click();
        Thread.sleep(3000);

        WebElement shoppingCart_01 = driver.findElement(By.xpath(ProductCategoryPageProperties.VIEW_MY_SHOPPING_CART_XPATH));
        actions.moveToElement(shoppingCart_01).perform();

        Assert.assertTrue(productCategoryPage.verifyCheckOutButtonEnabled());
        Thread.sleep(1000);
        // Click Check Out button
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_CHECK_OUT_SHOPPING_CART_XPATH)).click();

        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());

        // Delete Items from Shopping Cart After Sign In
        driver.findElement(By.xpath(ProductCategoryPageProperties.DELETE_ITEM_SHOPPING_CART_PRINTED_DRESS_AFTER_SIGN_IN_XPATH)).click();

        Thread.sleep(2000);
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());
        Thread.sleep(3000);
        // Log Out from Account
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_OUT_XPATH)).click();




    }

    @Test(priority = 38)
    public void verifyIncreaseDecreaseQuantityOfItemAddedTest() throws InterruptedException {
        // 3.3 User should be able to increase/decrease the quantity of each item added.
        ExtentTestManager.getTest().log(Status.INFO, "Verify increase/decrease the quantity of each item added on the Shopping Cart Summary page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // With add products in Cart
        Thread.sleep(1000);
        // Menu Women
        driver.findElement(By.xpath(ProductCategoryPageProperties.MENU_WOMEN_XPATH)).click();

        Thread.sleep(1000);
        WebElement TShirts = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_TSHIRTS_XPATH));
        Actions actions = new Actions(driver);
        actions.moveToElement(TShirts).perform();

        Thread.sleep(1000);
        // Add to cart T-Shirts
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_TSHIRTS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();

        Thread.sleep(3000);
        WebElement printedDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_DRESS_XPATH));
        actions.moveToElement(printedDress).perform();

        Thread.sleep(1000);
        // Add to cart Printed Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_DRESS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();

        Thread.sleep(1000);
        WebElement printedChiffonDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_CHIFFON_DRESS_XPATH));
        actions.moveToElement(printedChiffonDress).perform();

        Thread.sleep(1000);
        // Add to cart Printed Chiffon Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_CHIFFON_DRESS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();

        Thread.sleep(1000);
        WebElement printedSummerDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_SUMMER_DRESS_XPATH));
        actions.moveToElement(printedSummerDress).perform();

        Thread.sleep(1000);
        // Add to cart Printed Summer Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_SUMMER_DRESS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PROCEED_TO_CHECKOUT_XPATH)).click();

        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());

        Thread.sleep(1000);
        // Proceed to Checkout
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_PROCEED_TO_CHECKOUT_XPATH)).click();

        Thread.sleep(1000);
        // Go to Homepage
        driver.findElement(By.xpath(ProductCategoryPageProperties.HEADER_LOGO_HOME_PAGE_XPATH)).click();

        Thread.sleep(1000);
        WebElement shoppingCart = driver.findElement(By.xpath(ProductCategoryPageProperties.VIEW_MY_SHOPPING_CART_XPATH));
        actions.moveToElement(shoppingCart).perform();

        Assert.assertTrue(productCategoryPage.verifyCheckOutButtonEnabled());
        Thread.sleep(1000);
        // Click Checkout Button
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_CHECK_OUT_SHOPPING_CART_XPATH)).click();

        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());

        // Increase the quantity of each item added in Shopping Cart Before Sign In
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_TSHIRTS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_TSHIRTS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_TSHIRTS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_XPATH)).click();

        Thread.sleep(1000);
        // Go to Homepage
        driver.findElement(By.xpath(ProductCategoryPageProperties.HEADER_LOGO_HOME_PAGE_XPATH)).click();

        WebElement shoppingCart_02 = driver.findElement(By.xpath(ProductCategoryPageProperties.VIEW_MY_SHOPPING_CART_XPATH));
        Thread.sleep(1000);
        actions.moveToElement(shoppingCart_02).perform();

        Thread.sleep(1000);
        // Click Checkout Button
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_CHECK_OUT_SHOPPING_CART_XPATH)).click();

        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());

        // Decrease the quantity of each item added in Shopping Cart Before Sign In
        driver.findElement(By.xpath(ProductCategoryPageProperties.DECREASE_ITEM_SHOPPING_CART_TSHIRTS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.DECREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_XPATH)).click();

        Thread.sleep(1000);
        // Go to Homepage
        driver.findElement(By.xpath(ProductCategoryPageProperties.HEADER_LOGO_HOME_PAGE_XPATH)).click();

        Thread.sleep(1000);
        // Sign In Button clicked
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_XPATH)).click();

        Thread.sleep(1000);
        // Sign Button Displayed
        Assert.assertTrue(productCategoryPage.verifySignInButtonDisplayed());

        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_EMAIL_XPATH)).sendKeys("khaledhasanb@gmail.com");
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_PASSWORD_XPATH)).sendKeys("khaled1234567890");
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_SIGN_IN_XPATH)).click();
        Thread.sleep(3000);

        WebElement shoppingCart_01 = driver.findElement(By.xpath(ProductCategoryPageProperties.VIEW_MY_SHOPPING_CART_XPATH));
        actions.moveToElement(shoppingCart_01).perform();

        Assert.assertTrue(productCategoryPage.verifyCheckOutButtonEnabled());
        Thread.sleep(1000);
        // Click Check Out button
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_CHECK_OUT_SHOPPING_CART_XPATH)).click();

        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());

        // Decrease the quantity of each item added in Shopping Cart After Sign In
        driver.findElement(By.xpath(ProductCategoryPageProperties.DECREASE_ITEM_SHOPPING_CART_TSHIRTS_AFTER_SIGN_IN_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.DECREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_AFTER_SIGN_IN_XPATH)).click();

        Thread.sleep(2000);
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());
        Thread.sleep(3000);
        // Log Out from Account
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_OUT_XPATH)).click();



    }


    @Test(priority = 39)
    public void verifyTotalCostAndShippingCostTest() throws InterruptedException {
        // 3.4. Total Cost and Shipping cost should display.
        ExtentTestManager.getTest().log(Status.INFO, "Verify Total Cost and Shipping cost displayed on the Shopping Cart Summary page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // With add products in Cart
        Thread.sleep(1000);
        // Menu Women
        driver.findElement(By.xpath(ProductCategoryPageProperties.MENU_WOMEN_XPATH)).click();

        Thread.sleep(1000);
        WebElement TShirts = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_TSHIRTS_XPATH));
        Actions actions = new Actions(driver);
        actions.moveToElement(TShirts).perform();

        Thread.sleep(1000);
        // Add to cart T-Shirts
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_TSHIRTS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();

        Thread.sleep(3000);
        WebElement printedDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_DRESS_XPATH));
        actions.moveToElement(printedDress).perform();

        Thread.sleep(1000);
        // Add to cart Printed Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_DRESS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();

        Thread.sleep(1000);
        WebElement printedChiffonDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_CHIFFON_DRESS_XPATH));
        actions.moveToElement(printedChiffonDress).perform();

        Thread.sleep(1000);
        // Add to cart Printed Chiffon Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_CHIFFON_DRESS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();

        Thread.sleep(1000);
        WebElement printedSummerDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_SUMMER_DRESS_XPATH));
        actions.moveToElement(printedSummerDress).perform();

        Thread.sleep(1000);
        // Add to cart Printed Summer Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_SUMMER_DRESS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PROCEED_TO_CHECKOUT_XPATH)).click();

        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());
        // Total Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartTotalCostDisplayed());
        // Shipping Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartShippingCostDisplayed());

        Thread.sleep(1000);
        // Proceed to Checkout
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_PROCEED_TO_CHECKOUT_XPATH)).click();

        Thread.sleep(1000);
        // Go to Homepage
        driver.findElement(By.xpath(ProductCategoryPageProperties.HEADER_LOGO_HOME_PAGE_XPATH)).click();

        Thread.sleep(1000);
        WebElement shoppingCart = driver.findElement(By.xpath(ProductCategoryPageProperties.VIEW_MY_SHOPPING_CART_XPATH));
        actions.moveToElement(shoppingCart).perform();

        Assert.assertTrue(productCategoryPage.verifyCheckOutButtonEnabled());
        Thread.sleep(1000);
        // Click Checkout Button
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_CHECK_OUT_SHOPPING_CART_XPATH)).click();

        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());
        // Increase the quantity of each item added in Shopping Cart Before Sign In
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_TSHIRTS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_TSHIRTS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_TSHIRTS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_XPATH)).click();

        // Total Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartTotalCostDisplayed());
        // Shipping Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartShippingCostDisplayed());

        Thread.sleep(1000);
        // Go to Homepage
        driver.findElement(By.xpath(ProductCategoryPageProperties.HEADER_LOGO_HOME_PAGE_XPATH)).click();

        WebElement shoppingCart_02 = driver.findElement(By.xpath(ProductCategoryPageProperties.VIEW_MY_SHOPPING_CART_XPATH));
        Thread.sleep(1000);
        actions.moveToElement(shoppingCart_02).perform();

        Thread.sleep(1000);
        // Click Checkout Button
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_CHECK_OUT_SHOPPING_CART_XPATH)).click();

        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());

        // Decrease the quantity of each item added in Shopping Cart Before Sign In
        driver.findElement(By.xpath(ProductCategoryPageProperties.DECREASE_ITEM_SHOPPING_CART_TSHIRTS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.DECREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_XPATH)).click();

        // Total Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartTotalCostDisplayed());
        // Shipping Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartShippingCostDisplayed());

        Thread.sleep(1000);
        // Go to Homepage
        driver.findElement(By.xpath(ProductCategoryPageProperties.HEADER_LOGO_HOME_PAGE_XPATH)).click();

        Thread.sleep(1000);
        // Sign In Button clicked
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_XPATH)).click();

        Thread.sleep(1000);
        // Sign Button Displayed
        Assert.assertTrue(productCategoryPage.verifySignInButtonDisplayed());

        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_EMAIL_XPATH)).sendKeys("khaledhasanb@gmail.com");
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_PASSWORD_XPATH)).sendKeys("khaled1234567890");
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_SIGN_IN_XPATH)).click();
        Thread.sleep(3000);

        WebElement shoppingCart_01 = driver.findElement(By.xpath(ProductCategoryPageProperties.VIEW_MY_SHOPPING_CART_XPATH));
        actions.moveToElement(shoppingCart_01).perform();

        Assert.assertTrue(productCategoryPage.verifyCheckOutButtonEnabled());
        Thread.sleep(1000);
        // Click Check Out button
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_CHECK_OUT_SHOPPING_CART_XPATH)).click();

        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());

        // Decrease the quantity of each item added in Shopping Cart After Sign In
        driver.findElement(By.xpath(ProductCategoryPageProperties.DECREASE_ITEM_SHOPPING_CART_TSHIRTS_AFTER_SIGN_IN_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.DECREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_AFTER_SIGN_IN_XPATH)).click();

        Thread.sleep(2000);
        // Total Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartTotalCostDisplayed());
        // Shipping Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartShippingCostDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());
        Thread.sleep(3000);
        // Log Out from Account
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_OUT_XPATH)).click();



    }

    @Test(priority = 40)
    public void verifyContinueShoppingLinkTest() throws InterruptedException {
        // 3.5. Continue Shopping link should be available for user.
        ExtentTestManager.getTest().log(Status.INFO, "Verify Continue Shopping link available on the Shopping Cart Summary page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // With add products in Cart
        Thread.sleep(1000);
        // Menu Women
        driver.findElement(By.xpath(ProductCategoryPageProperties.MENU_WOMEN_XPATH)).click();

        Thread.sleep(1000);
        WebElement TShirts = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_TSHIRTS_XPATH));
        Actions actions = new Actions(driver);
        actions.moveToElement(TShirts).perform();

        Thread.sleep(1000);
        // Add to cart T-Shirts
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_TSHIRTS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();

        Thread.sleep(3000);
        WebElement printedDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_DRESS_XPATH));
        actions.moveToElement(printedDress).perform();

        Thread.sleep(1000);
        // Add to cart Printed Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_DRESS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();

        Thread.sleep(1000);
        WebElement printedChiffonDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_CHIFFON_DRESS_XPATH));
        actions.moveToElement(printedChiffonDress).perform();

        Thread.sleep(1000);
        // Add to cart Printed Chiffon Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_CHIFFON_DRESS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();

        Thread.sleep(1000);
        WebElement printedSummerDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_SUMMER_DRESS_XPATH));
        actions.moveToElement(printedSummerDress).perform();

        Thread.sleep(1000);
        // Add to cart Printed Summer Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_SUMMER_DRESS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PROCEED_TO_CHECKOUT_XPATH)).click();

        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());
        // Total Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartTotalCostDisplayed());
        // Shipping Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartShippingCostDisplayed());
        // Continue Shopping Link Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartContinueShoppingLinkDisplayed());

        Thread.sleep(1000);
        // Proceed to Checkout
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_PROCEED_TO_CHECKOUT_XPATH)).click();

        Thread.sleep(1000);
        // Go to Homepage
        driver.findElement(By.xpath(ProductCategoryPageProperties.HEADER_LOGO_HOME_PAGE_XPATH)).click();

        Thread.sleep(1000);
        WebElement shoppingCart = driver.findElement(By.xpath(ProductCategoryPageProperties.VIEW_MY_SHOPPING_CART_XPATH));
        actions.moveToElement(shoppingCart).perform();

        Assert.assertTrue(productCategoryPage.verifyCheckOutButtonEnabled());
        Thread.sleep(1000);
        // Click Checkout Button
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_CHECK_OUT_SHOPPING_CART_XPATH)).click();

        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());
        // Increase the quantity of each item added in Shopping Cart Before Sign In
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_TSHIRTS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_TSHIRTS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_TSHIRTS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_XPATH)).click();

        // Total Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartTotalCostDisplayed());
        // Shipping Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartShippingCostDisplayed());
        // Continue Shopping Link Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartContinueShoppingLinkDisplayed());

        Thread.sleep(1000);
        // Go to Homepage
        driver.findElement(By.xpath(ProductCategoryPageProperties.HEADER_LOGO_HOME_PAGE_XPATH)).click();

        WebElement shoppingCart_02 = driver.findElement(By.xpath(ProductCategoryPageProperties.VIEW_MY_SHOPPING_CART_XPATH));
        Thread.sleep(1000);
        actions.moveToElement(shoppingCart_02).perform();

        Thread.sleep(1000);
        // Click Checkout Button
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_CHECK_OUT_SHOPPING_CART_XPATH)).click();

        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());

        // Decrease the quantity of each item added in Shopping Cart Before Sign In
        driver.findElement(By.xpath(ProductCategoryPageProperties.DECREASE_ITEM_SHOPPING_CART_TSHIRTS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.DECREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_XPATH)).click();

        // Total Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartTotalCostDisplayed());
        // Shipping Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartShippingCostDisplayed());
        // Continue Shopping Link Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartContinueShoppingLinkDisplayed());

        Thread.sleep(1000);
        // Go to Homepage
        driver.findElement(By.xpath(ProductCategoryPageProperties.HEADER_LOGO_HOME_PAGE_XPATH)).click();

        Thread.sleep(1000);
        // Sign In Button clicked
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_XPATH)).click();

        Thread.sleep(1000);
        // Sign Button Displayed
        Assert.assertTrue(productCategoryPage.verifySignInButtonDisplayed());

        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_EMAIL_XPATH)).sendKeys("khaledhasanb@gmail.com");
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_PASSWORD_XPATH)).sendKeys("khaled1234567890");
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_SIGN_IN_XPATH)).click();
        Thread.sleep(3000);

        WebElement shoppingCart_01 = driver.findElement(By.xpath(ProductCategoryPageProperties.VIEW_MY_SHOPPING_CART_XPATH));
        actions.moveToElement(shoppingCart_01).perform();

        Assert.assertTrue(productCategoryPage.verifyCheckOutButtonEnabled());
        Thread.sleep(1000);
        // Click Check Out button
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_CHECK_OUT_SHOPPING_CART_XPATH)).click();

        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());

        // Decrease the quantity of each item added in Shopping Cart After Sign In
        driver.findElement(By.xpath(ProductCategoryPageProperties.DECREASE_ITEM_SHOPPING_CART_TSHIRTS_AFTER_SIGN_IN_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.DECREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_AFTER_SIGN_IN_XPATH)).click();

        Thread.sleep(2000);
        // Total Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartTotalCostDisplayed());
        // Shipping Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartShippingCostDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());
        // Continue Shopping Link Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartContinueShoppingLinkDisplayed());
        Thread.sleep(3000);
        // Log Out from Account
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_OUT_XPATH)).click();



    }

    //@Test(priority = 41)
    public void verifyCreateNewAccountAfterShoppingTest() throws InterruptedException {
        // 3.6. User should be able to create a new account.
        ExtentTestManager.getTest().log(Status.INFO, "Verify User able to create a new account on the Shopping Cart Summary page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // With add products in Cart
        Thread.sleep(1000);
        // Menu Women
        driver.findElement(By.xpath(ProductCategoryPageProperties.MENU_WOMEN_XPATH)).click();

        Thread.sleep(1000);
        WebElement TShirts = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_TSHIRTS_XPATH));
        Actions actions = new Actions(driver);
        actions.moveToElement(TShirts).perform();

        Thread.sleep(1000);
        // Add to cart T-Shirts
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_TSHIRTS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();

        Thread.sleep(3000);
        WebElement printedDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_DRESS_XPATH));
        actions.moveToElement(printedDress).perform();

        Thread.sleep(1000);
        // Add to cart Printed Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_DRESS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();

        Thread.sleep(1000);
        WebElement printedChiffonDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_CHIFFON_DRESS_XPATH));
        actions.moveToElement(printedChiffonDress).perform();

        Thread.sleep(1000);
        // Add to cart Printed Chiffon Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_CHIFFON_DRESS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();

        Thread.sleep(1000);
        WebElement printedSummerDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_SUMMER_DRESS_XPATH));
        actions.moveToElement(printedSummerDress).perform();

        Thread.sleep(1000);
        // Add to cart Printed Summer Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_SUMMER_DRESS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PROCEED_TO_CHECKOUT_XPATH)).click();

        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());
        // Total Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartTotalCostDisplayed());
        // Shipping Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartShippingCostDisplayed());
        // Continue Shopping Link Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartContinueShoppingLinkDisplayed());

        Thread.sleep(1000);
        // Proceed to Checkout
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_PROCEED_TO_CHECKOUT_XPATH)).click();

        Thread.sleep(1000);
        // Go to Homepage
        driver.findElement(By.xpath(ProductCategoryPageProperties.HEADER_LOGO_HOME_PAGE_XPATH)).click();

        Thread.sleep(1000);
        WebElement shoppingCart = driver.findElement(By.xpath(ProductCategoryPageProperties.VIEW_MY_SHOPPING_CART_XPATH));
        actions.moveToElement(shoppingCart).perform();

        Assert.assertTrue(productCategoryPage.verifyCheckOutButtonEnabled());
        Thread.sleep(1000);
        // Click Checkout Button
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_CHECK_OUT_SHOPPING_CART_XPATH)).click();

        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());
        // Increase the quantity of each item added in Shopping Cart Before Sign In
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_TSHIRTS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_TSHIRTS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_TSHIRTS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_XPATH)).click();

        // Total Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartTotalCostDisplayed());
        // Shipping Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartShippingCostDisplayed());
        // Continue Shopping Link Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartContinueShoppingLinkDisplayed());

        Thread.sleep(1000);
        // Go to Homepage
        driver.findElement(By.xpath(ProductCategoryPageProperties.HEADER_LOGO_HOME_PAGE_XPATH)).click();

        WebElement shoppingCart_02 = driver.findElement(By.xpath(ProductCategoryPageProperties.VIEW_MY_SHOPPING_CART_XPATH));
        Thread.sleep(1000);
        actions.moveToElement(shoppingCart_02).perform();

        Thread.sleep(1000);
        // Click Checkout Button
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_CHECK_OUT_SHOPPING_CART_XPATH)).click();

        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());

        // Decrease the quantity of each item added in Shopping Cart Before Sign In
        driver.findElement(By.xpath(ProductCategoryPageProperties.DECREASE_ITEM_SHOPPING_CART_TSHIRTS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.DECREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_XPATH)).click();

        // Total Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartTotalCostDisplayed());
        // Shipping Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartShippingCostDisplayed());
        // Continue Shopping Link Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartContinueShoppingLinkDisplayed());

        Thread.sleep(1000);
        // Go to Homepage
        driver.findElement(By.xpath(ProductCategoryPageProperties.HEADER_LOGO_HOME_PAGE_XPATH)).click();

        Thread.sleep(1000);
        // Sign In Button clicked
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_XPATH)).click();

        Thread.sleep(1000);
        // Sign Button Displayed
        Assert.assertTrue(productCategoryPage.verifySignInButtonDisplayed());

        // Email Input
        driver.findElement(By.xpath(ProductCategoryPageProperties.REGISTRATION_EMAIL_XPATH)).sendKeys("khaled2004@gmail.com");
        // Create an Account Button clicked
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_CREATE_AN_ACCOUNT_XPATH)).click();

        // Radio Button Male clicked
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_RADIO_MALE_XPATH)).click();

        // First Name input
        driver.findElement(By.xpath(ProductCategoryPageProperties.REGISTRATION_FIRST_NAME_XPATH)).sendKeys("Khaled");
        // Last Name input
        driver.findElement(By.xpath(ProductCategoryPageProperties.REGISTRATION_LAST_NAME_XPATH)).sendKeys("Hasan");
        // Password input
        driver.findElement(By.xpath(ProductCategoryPageProperties.REGISTRATION_PASSWORD_XPATH)).sendKeys("20225");
        // Select Days
        Select days = new Select(driver.findElement(By.xpath(ProductCategoryPageProperties.REGISTRATION_DOB_DAYS_XPATH)));
        days.selectByValue("16");
        // Select Months
        Select months = new Select(driver.findElement(By.xpath(ProductCategoryPageProperties.REGISTRATION_DOB_MONTHS_XPATH)));
        months.selectByValue("3");
        // Select Years
        Select years = new Select(driver.findElement(By.xpath(ProductCategoryPageProperties.REGISTRATION_DOB_YEARS_XPATH)));
        years.selectByValue("1981");

        // Checkout Box Newsletter
        driver.findElement(By.xpath(ProductCategoryPageProperties.REGISTRATION_CHECKBOX_NEWSLETTER_XPATH)).click();
        // Checkout Box Option
        driver.findElement(By.xpath(ProductCategoryPageProperties.REGISTRATION_CHECKBOX_OPTION_XPATH)).click();

        Thread.sleep(5000);
        // Register Button clicked
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_REGISTER_ACCOUNT_XPATH)).click();

        Thread.sleep(1000);
        WebElement shoppingCart_01 = driver.findElement(By.xpath(ProductCategoryPageProperties.VIEW_MY_SHOPPING_CART_XPATH));
        actions.moveToElement(shoppingCart_01).perform();

        Assert.assertTrue(productCategoryPage.verifyCheckOutButtonEnabled());
        Thread.sleep(1000);
        // Click Check Out button
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_CHECK_OUT_SHOPPING_CART_XPATH)).click();

        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());

        // Decrease the quantity of each item added in Shopping Cart After Registered
        driver.findElement(By.xpath(ProductCategoryPageProperties.DECREASE_ITEM_SHOPPING_CART_TSHIRTS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.DECREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_XPATH)).click();

        Thread.sleep(2000);
        // Total Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartTotalCostDisplayed());
        // Shipping Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartShippingCostDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());
        // Continue Shopping Link Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartContinueShoppingLinkDisplayed());
        Thread.sleep(3000);
        // Log Out from Account
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_OUT_XPATH)).click();

        Thread.sleep(1000);


    }


    @Test(priority = 42)
    public void verifyRegisterUserLogInAfterShoppingTest() throws InterruptedException {
        // 3.7. Registered user should be able to login
        ExtentTestManager.getTest().log(Status.INFO, "Verify Registered user able to login on the Shopping Cart Summary page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // With add products in Cart
        Thread.sleep(1000);
        // Menu Women
        driver.findElement(By.xpath(ProductCategoryPageProperties.MENU_WOMEN_XPATH)).click();

        Thread.sleep(1000);
        WebElement TShirts = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_TSHIRTS_XPATH));
        Actions actions = new Actions(driver);
        actions.moveToElement(TShirts).perform();

        Thread.sleep(1000);
        // Add to cart T-Shirts
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_TSHIRTS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();

        Thread.sleep(3000);
        WebElement printedDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_DRESS_XPATH));
        actions.moveToElement(printedDress).perform();

        Thread.sleep(1000);
        // Add to cart Printed Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_DRESS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();

        Thread.sleep(1000);
        WebElement printedChiffonDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_CHIFFON_DRESS_XPATH));
        actions.moveToElement(printedChiffonDress).perform();

        Thread.sleep(1000);
        // Add to cart Printed Chiffon Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_CHIFFON_DRESS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();

        Thread.sleep(1000);
        WebElement printedSummerDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_SUMMER_DRESS_XPATH));
        actions.moveToElement(printedSummerDress).perform();

        Thread.sleep(1000);
        // Add to cart Printed Summer Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_SUMMER_DRESS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PROCEED_TO_CHECKOUT_XPATH)).click();

        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());
        // Total Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartTotalCostDisplayed());
        // Shipping Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartShippingCostDisplayed());
        // Continue Shopping Link Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartContinueShoppingLinkDisplayed());

        Thread.sleep(1000);
        // Proceed to Checkout
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_PROCEED_TO_CHECKOUT_XPATH)).click();

        Thread.sleep(1000);
        // Go to Homepage
        driver.findElement(By.xpath(ProductCategoryPageProperties.HEADER_LOGO_HOME_PAGE_XPATH)).click();

        Thread.sleep(1000);
        WebElement shoppingCart = driver.findElement(By.xpath(ProductCategoryPageProperties.VIEW_MY_SHOPPING_CART_XPATH));
        actions.moveToElement(shoppingCart).perform();

        Assert.assertTrue(productCategoryPage.verifyCheckOutButtonEnabled());
        Thread.sleep(1000);
        // Click Checkout Button
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_CHECK_OUT_SHOPPING_CART_XPATH)).click();

        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());
        // Increase the quantity of each item added in Shopping Cart Before Sign In
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_TSHIRTS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_TSHIRTS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_TSHIRTS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_XPATH)).click();

        // Total Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartTotalCostDisplayed());
        // Shipping Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartShippingCostDisplayed());
        // Continue Shopping Link Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartContinueShoppingLinkDisplayed());

        Thread.sleep(1000);
        // Go to Homepage
        driver.findElement(By.xpath(ProductCategoryPageProperties.HEADER_LOGO_HOME_PAGE_XPATH)).click();

        WebElement shoppingCart_02 = driver.findElement(By.xpath(ProductCategoryPageProperties.VIEW_MY_SHOPPING_CART_XPATH));
        Thread.sleep(1000);
        actions.moveToElement(shoppingCart_02).perform();

        Thread.sleep(1000);
        // Click Checkout Button
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_CHECK_OUT_SHOPPING_CART_XPATH)).click();

        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());

        // Decrease the quantity of each item added in Shopping Cart Before Sign In
        driver.findElement(By.xpath(ProductCategoryPageProperties.DECREASE_ITEM_SHOPPING_CART_TSHIRTS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.DECREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_XPATH)).click();

        // Total Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartTotalCostDisplayed());
        // Shipping Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartShippingCostDisplayed());
        // Continue Shopping Link Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartContinueShoppingLinkDisplayed());

        Thread.sleep(1000);
        // Go to Homepage
        driver.findElement(By.xpath(ProductCategoryPageProperties.HEADER_LOGO_HOME_PAGE_XPATH)).click();

        Thread.sleep(1000);
        // Sign In Button clicked
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_XPATH)).click();

        Thread.sleep(1000);
        // Sign Button Displayed
        Assert.assertTrue(productCategoryPage.verifySignInButtonDisplayed());

        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_EMAIL_XPATH)).sendKeys("khaledhasanb@gmail.com");
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_PASSWORD_XPATH)).sendKeys("khaled1234567890");
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_SIGN_IN_XPATH)).click();
        Thread.sleep(3000);

        String myAccountPageTitle = productCategoryPage.verifyMyAccountTitle();
        Assert.assertEquals(myAccountPageTitle, ProductCategoryPageTestProperties.EXP_MY_ACCOUNT_PAGE_TITLE);


        if(driver.getCurrentUrl().equals(ProductCategoryPageProperties.MY_ACCOUNT_LINK)) {
            System.out.println("Link is correct");
        }else {
            System.out.println("Link is not correct");

        }

        if(driver.getTitle().equals(ProductCategoryPageTestProperties.EXP_MY_ACCOUNT_PAGE_TITLE)) {
            System.out.println("title is correct");
        }else {
            System.out.println("title is not correct");

        }

        Thread.sleep(1000);
        WebElement shoppingCart_01 = driver.findElement(By.xpath(ProductCategoryPageProperties.VIEW_MY_SHOPPING_CART_XPATH));
        actions.moveToElement(shoppingCart_01).perform();

        Assert.assertTrue(productCategoryPage.verifyCheckOutButtonEnabled());
        Thread.sleep(1000);
        // Click Check Out button
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_CHECK_OUT_SHOPPING_CART_XPATH)).click();

        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());

        // Decrease the quantity of each item added in Shopping Cart After Sign In
        driver.findElement(By.xpath(ProductCategoryPageProperties.DECREASE_ITEM_SHOPPING_CART_TSHIRTS_AFTER_SIGN_IN_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.DECREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_AFTER_SIGN_IN_XPATH)).click();

        Thread.sleep(2000);
        // Total Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartTotalCostDisplayed());
        // Shipping Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartShippingCostDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());
        // Continue Shopping Link Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartContinueShoppingLinkDisplayed());
        Thread.sleep(3000);
        // Log Out from Account
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_OUT_XPATH)).click();

        Thread.sleep(1000);


    }

    @Test(priority = 43)
    public void verifyDifferentDeliveryMethodOptionTest() throws InterruptedException {
        // 3.8. Different delivery method option should be available for user to select.
        ExtentTestManager.getTest().log(Status.INFO, "Verify Different delivery method option available for user to select on the Shopping Cart Summary page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        Thread.sleep(1000);


    }

    @Test(priority = 44)
    public void verifyDifferentPaymentMethodTest() throws InterruptedException {
        // 3.9. Different payment method should be presented to user.
        ExtentTestManager.getTest().log(Status.INFO, "Verify Different payment method presented to user on the Shopping Cart Summary page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // With add products in Cart
        Thread.sleep(1000);
        // Menu Women
        driver.findElement(By.xpath(ProductCategoryPageProperties.MENU_WOMEN_XPATH)).click();

        Thread.sleep(1000);
        WebElement TShirts = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_TSHIRTS_XPATH));
        Actions actions = new Actions(driver);
        actions.moveToElement(TShirts).perform();

        Thread.sleep(1000);
        // Add to cart T-Shirts
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_TSHIRTS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();

        Thread.sleep(3000);
        WebElement printedDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_DRESS_XPATH));
        actions.moveToElement(printedDress).perform();

        Thread.sleep(1000);
        // Add to cart Printed Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_DRESS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();

        Thread.sleep(1000);
        WebElement printedChiffonDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_CHIFFON_DRESS_XPATH));
        actions.moveToElement(printedChiffonDress).perform();

        Thread.sleep(1000);
        // Add to cart Printed Chiffon Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_CHIFFON_DRESS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();

        Thread.sleep(1000);
        WebElement printedSummerDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_SUMMER_DRESS_XPATH));
        actions.moveToElement(printedSummerDress).perform();

        Thread.sleep(1000);
        // Add to cart Printed Summer Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_SUMMER_DRESS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PROCEED_TO_CHECKOUT_XPATH)).click();

        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());
        // Total Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartTotalCostDisplayed());
        // Shipping Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartShippingCostDisplayed());
        // Continue Shopping Link Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartContinueShoppingLinkDisplayed());

        Thread.sleep(1000);
        // Proceed to Checkout
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_PROCEED_TO_CHECKOUT_XPATH)).click();

        Thread.sleep(1000);
        // Go to Homepage
        driver.findElement(By.xpath(ProductCategoryPageProperties.HEADER_LOGO_HOME_PAGE_XPATH)).click();

        Thread.sleep(1000);
        WebElement shoppingCart = driver.findElement(By.xpath(ProductCategoryPageProperties.VIEW_MY_SHOPPING_CART_XPATH));
        actions.moveToElement(shoppingCart).perform();

        Assert.assertTrue(productCategoryPage.verifyCheckOutButtonEnabled());
        Thread.sleep(1000);
        // Click Checkout Button
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_CHECK_OUT_SHOPPING_CART_XPATH)).click();

        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());
        // Increase the quantity of each item added in Shopping Cart Before Sign In
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_TSHIRTS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_TSHIRTS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_TSHIRTS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_XPATH)).click();

        // Total Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartTotalCostDisplayed());
        // Shipping Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartShippingCostDisplayed());
        // Continue Shopping Link Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartContinueShoppingLinkDisplayed());

        Thread.sleep(1000);
        // Go to Homepage
        driver.findElement(By.xpath(ProductCategoryPageProperties.HEADER_LOGO_HOME_PAGE_XPATH)).click();

        WebElement shoppingCart_02 = driver.findElement(By.xpath(ProductCategoryPageProperties.VIEW_MY_SHOPPING_CART_XPATH));
        Thread.sleep(1000);
        actions.moveToElement(shoppingCart_02).perform();

        Thread.sleep(1000);
        // Click Checkout Button
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_CHECK_OUT_SHOPPING_CART_XPATH)).click();

        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());

        // Decrease the quantity of each item added in Shopping Cart Before Sign In
        driver.findElement(By.xpath(ProductCategoryPageProperties.DECREASE_ITEM_SHOPPING_CART_TSHIRTS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.DECREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_XPATH)).click();

        // Total Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartTotalCostDisplayed());
        // Shipping Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartShippingCostDisplayed());
        // Continue Shopping Link Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartContinueShoppingLinkDisplayed());

        Thread.sleep(1000);
        // Go to Homepage
        driver.findElement(By.xpath(ProductCategoryPageProperties.HEADER_LOGO_HOME_PAGE_XPATH)).click();

        Thread.sleep(1000);
        // Sign In Button clicked
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_XPATH)).click();

        Thread.sleep(1000);
        // Sign Button Displayed
        Assert.assertTrue(productCategoryPage.verifySignInButtonDisplayed());

        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_EMAIL_XPATH)).sendKeys("khaledhasanb@gmail.com");
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_PASSWORD_XPATH)).sendKeys("khaled1234567890");
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_SIGN_IN_XPATH)).click();
        Thread.sleep(3000);

        String myAccountPageTitle = productCategoryPage.verifyMyAccountTitle();
        Assert.assertEquals(myAccountPageTitle, ProductCategoryPageTestProperties.EXP_MY_ACCOUNT_PAGE_TITLE);


        if(driver.getCurrentUrl().equals(ProductCategoryPageProperties.MY_ACCOUNT_LINK)) {
            System.out.println("Link is correct");
        }else {
            System.out.println("Link is not correct");

        }

        if(driver.getTitle().equals(ProductCategoryPageTestProperties.EXP_MY_ACCOUNT_PAGE_TITLE)) {
            System.out.println("title is correct");
        }else {
            System.out.println("title is not correct");

        }

        Thread.sleep(1000);
        WebElement shoppingCart_01 = driver.findElement(By.xpath(ProductCategoryPageProperties.VIEW_MY_SHOPPING_CART_XPATH));
        actions.moveToElement(shoppingCart_01).perform();

        Assert.assertTrue(productCategoryPage.verifyCheckOutButtonEnabled());
        Thread.sleep(1000);
        // Click Check Out button
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_CHECK_OUT_SHOPPING_CART_XPATH)).click();

        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());

        // Decrease the quantity of each item added in Shopping Cart After Sign In
        driver.findElement(By.xpath(ProductCategoryPageProperties.DECREASE_ITEM_SHOPPING_CART_TSHIRTS_AFTER_SIGN_IN_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.DECREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_AFTER_SIGN_IN_XPATH)).click();

        Thread.sleep(2000);
        // Total Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartTotalCostDisplayed());
        // Shipping Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartShippingCostDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());
        // Continue Shopping Link Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartContinueShoppingLinkDisplayed());

        Thread.sleep(2000);
        //Proceed To Checkout Summary To Address
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_PROCEED_TO_CHECKOUT_XPATH)).click();
        //Proceed To Checkout Summary Address To Shipping
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_PROCEED_TO_CHECKOUT_ADDRESS_XPATH)).click();

        //Checkbox of Terms of Service
        driver.findElement(By.xpath(ProductCategoryPageProperties.CHECKBOX_TERMS_OF_SERVICE_XPATH)).click();

        //Proceed To Checkout Summary Shipping To Payment Method
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_PROCEED_TO_CHECKOUT_SHIPPING_XPATH)).click();

        Thread.sleep(3000);
        // Pay by Credit Card Displayed
        Assert.assertTrue(productCategoryPage.verifyPayByCreditCardMethodLinkDisplayed());
        // Pay By Bank Wire Displayed
        Assert.assertTrue(productCategoryPage.verifyPayByBankWireMethodLinkDisplayed());
        // Pay By Check Displayed
        Assert.assertTrue(productCategoryPage.verifyPayByCheckMethodLinkDisplayed());

        Thread.sleep(3000);
        // Log Out from Account
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_OUT_XPATH)).click();

        Thread.sleep(3000);



    }


    @Test(priority = 45)
    public void verifyGiftWrapOptionTest() throws InterruptedException {
        // 3.10. Gift wrap option should be available for user.
        ExtentTestManager.getTest().log(Status.INFO, "Verify Gift wrap option available for user on the Shopping Cart Summary page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // With add products in Cart
        Thread.sleep(1000);
        // Menu Women
        driver.findElement(By.xpath(ProductCategoryPageProperties.MENU_WOMEN_XPATH)).click();

        Thread.sleep(1000);
        WebElement TShirts = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_TSHIRTS_XPATH));
        Actions actions = new Actions(driver);
        actions.moveToElement(TShirts).perform();

        Thread.sleep(1000);
        // Add to cart T-Shirts
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_TSHIRTS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();

        Thread.sleep(3000);
        WebElement printedDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_DRESS_XPATH));
        actions.moveToElement(printedDress).perform();

        Thread.sleep(1000);
        // Add to cart Printed Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_DRESS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();

        Thread.sleep(1000);
        WebElement printedChiffonDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_CHIFFON_DRESS_XPATH));
        actions.moveToElement(printedChiffonDress).perform();

        Thread.sleep(1000);
        // Add to cart Printed Chiffon Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_CHIFFON_DRESS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();

        Thread.sleep(1000);
        WebElement printedSummerDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_SUMMER_DRESS_XPATH));
        actions.moveToElement(printedSummerDress).perform();

        Thread.sleep(1000);
        // Add to cart Printed Summer Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_SUMMER_DRESS_ADD_TO_CART_XPATH)).click();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PROCEED_TO_CHECKOUT_XPATH)).click();

        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());
        // Total Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartTotalCostDisplayed());
        // Shipping Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartShippingCostDisplayed());
        // Continue Shopping Link Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartContinueShoppingLinkDisplayed());

        Thread.sleep(1000);
        // Proceed to Checkout
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_PROCEED_TO_CHECKOUT_XPATH)).click();

        Thread.sleep(1000);
        // Go to Homepage
        driver.findElement(By.xpath(ProductCategoryPageProperties.HEADER_LOGO_HOME_PAGE_XPATH)).click();

        Thread.sleep(1000);
        WebElement shoppingCart = driver.findElement(By.xpath(ProductCategoryPageProperties.VIEW_MY_SHOPPING_CART_XPATH));
        actions.moveToElement(shoppingCart).perform();

        Assert.assertTrue(productCategoryPage.verifyCheckOutButtonEnabled());
        Thread.sleep(1000);
        // Click Checkout Button
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_CHECK_OUT_SHOPPING_CART_XPATH)).click();

        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());
        // Increase the quantity of each item added in Shopping Cart Before Sign In
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_TSHIRTS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_TSHIRTS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_TSHIRTS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.INCREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_XPATH)).click();

        // Total Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartTotalCostDisplayed());
        // Shipping Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartShippingCostDisplayed());
        // Continue Shopping Link Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartContinueShoppingLinkDisplayed());

        Thread.sleep(1000);
        // Go to Homepage
        driver.findElement(By.xpath(ProductCategoryPageProperties.HEADER_LOGO_HOME_PAGE_XPATH)).click();

        WebElement shoppingCart_02 = driver.findElement(By.xpath(ProductCategoryPageProperties.VIEW_MY_SHOPPING_CART_XPATH));
        Thread.sleep(1000);
        actions.moveToElement(shoppingCart_02).perform();

        Thread.sleep(1000);
        // Click Checkout Button
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_CHECK_OUT_SHOPPING_CART_XPATH)).click();

        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());

        // Decrease the quantity of each item added in Shopping Cart Before Sign In
        driver.findElement(By.xpath(ProductCategoryPageProperties.DECREASE_ITEM_SHOPPING_CART_TSHIRTS_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.DECREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_XPATH)).click();

        // Total Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartTotalCostDisplayed());
        // Shipping Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartShippingCostDisplayed());
        // Continue Shopping Link Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartContinueShoppingLinkDisplayed());

        Thread.sleep(1000);
        // Go to Homepage
        driver.findElement(By.xpath(ProductCategoryPageProperties.HEADER_LOGO_HOME_PAGE_XPATH)).click();

        Thread.sleep(1000);
        // Sign In Button clicked
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_XPATH)).click();

        Thread.sleep(1000);
        // Sign Button Displayed
        Assert.assertTrue(productCategoryPage.verifySignInButtonDisplayed());

        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_EMAIL_XPATH)).sendKeys("khaledhasanb@gmail.com");
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_PASSWORD_XPATH)).sendKeys("khaled1234567890");
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_SIGN_IN_XPATH)).click();
        Thread.sleep(3000);

        String myAccountPageTitle = productCategoryPage.verifyMyAccountTitle();
        Assert.assertEquals(myAccountPageTitle, ProductCategoryPageTestProperties.EXP_MY_ACCOUNT_PAGE_TITLE);


        if(driver.getCurrentUrl().equals(ProductCategoryPageProperties.MY_ACCOUNT_LINK)) {
            System.out.println("Link is correct");
        }else {
            System.out.println("Link is not correct");

        }

        if(driver.getTitle().equals(ProductCategoryPageTestProperties.EXP_MY_ACCOUNT_PAGE_TITLE)) {
            System.out.println("title is correct");
        }else {
            System.out.println("title is not correct");

        }

        Thread.sleep(1000);
        WebElement shoppingCart_01 = driver.findElement(By.xpath(ProductCategoryPageProperties.VIEW_MY_SHOPPING_CART_XPATH));
        actions.moveToElement(shoppingCart_01).perform();

        Assert.assertTrue(productCategoryPage.verifyCheckOutButtonEnabled());
        Thread.sleep(1000);
        // Click Check Out button
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_CHECK_OUT_SHOPPING_CART_XPATH)).click();

        Thread.sleep(1000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());

        // Decrease the quantity of each item added in Shopping Cart After Sign In
        driver.findElement(By.xpath(ProductCategoryPageProperties.DECREASE_ITEM_SHOPPING_CART_TSHIRTS_AFTER_SIGN_IN_XPATH)).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.DECREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_AFTER_SIGN_IN_XPATH)).click();

        Thread.sleep(2000);
        // Total Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartTotalCostDisplayed());
        // Shipping Cost Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartShippingCostDisplayed());
        // Number of items added to the cart Displayed
        Assert.assertTrue(productCategoryPage.verifyNumberOfItemsAddedToCartDisplayed());
        // Continue Shopping Link Displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartContinueShoppingLinkDisplayed());

        Thread.sleep(2000);
        //Proceed To Checkout Summary To Address
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_PROCEED_TO_CHECKOUT_XPATH)).click();
        //Proceed To Checkout Summary Address To Shipping
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_PROCEED_TO_CHECKOUT_ADDRESS_XPATH)).click();

        Thread.sleep(2000);
        //Checkbox of Gift wrap option
        Assert.assertTrue(productCategoryPage.verifyCheckBoxGiftWrapOptionEnabled());
        driver.findElement(By.xpath(ProductCategoryPageProperties.CHECKBOX_GIFT_WRAP_OPTION_XPATH)).click();
        // Gift Message Box
        driver.findElement(By.xpath(ProductCategoryPageProperties.TEXTAREA_GIFT_MESSAGE_BOX_XPATH)).sendKeys("I want to wrap my box in Gift wrapping Matt paper.");
        Thread.sleep(2000);
        //Checkbox of Terms of Service
        driver.findElement(By.xpath(ProductCategoryPageProperties.CHECKBOX_TERMS_OF_SERVICE_XPATH)).click();
        Thread.sleep(4000);

        //Proceed To Checkout Summary Shipping To Payment Method
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_PROCEED_TO_CHECKOUT_SHIPPING_XPATH)).click();


        // Pay by Credit Card Displayed
        Assert.assertTrue(productCategoryPage.verifyPayByCreditCardMethodLinkEnabled());
        // Pay By Bank Wire Displayed
        Assert.assertTrue(productCategoryPage.verifyPayByBankWireMethodLinkEnabled());
        // Pay By Check Displayed
        Assert.assertTrue(productCategoryPage.verifyPayByCheckMethodLinkEnabled());

        Thread.sleep(3000);
        // Log Out from Account
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_OUT_XPATH)).click();

        Thread.sleep(3000);



    }




    @AfterMethod
    public void close(){
        driver.quit();
    }


}
