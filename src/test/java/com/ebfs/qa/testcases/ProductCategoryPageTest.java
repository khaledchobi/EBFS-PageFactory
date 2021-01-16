package com.ebfs.qa.testcases;

import com.aventstack.extentreports.Status;
import com.ebfs.qa.base.TestBase;
import com.ebfs.qa.pages.HomePage;
import com.ebfs.qa.pages.ProductCategoryPage;
import com.ebfs.qa.properties.ProductCategoryPageProperties;
import com.ebfs.qa.util.TestUtil;
import com.qa.ExtentReportListener.ExtentTestManager;
import org.apache.log4j.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ProductCategoryPageTest extends TestBase {
    //WebDriver driver;
    HomePage homePage;
    TestUtil testUtil;
    ProductCategoryPage productCategoryPage;
    //String sheetName = "SignIn";
    ExtentTestManager extentTestManager;
    //TestUtil testUtil = new TestUtil();

    public ProductCategoryPageTest() {
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

    @Test(priority = 20)
    public void verifyNavigateToProductCategoryPageTest() throws InterruptedException {
        // 2.1. User should be able to navigate to one of the product category page by clicking Dresses/T-Shirts.
        ExtentTestManager.getTest().log(Status.INFO, "Verify Product Category Page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Thread.sleep(3000);
        // Menu Dresses
        driver.findElement(By.xpath(ProductCategoryPageProperties.MENU_DRESSES_XPATH)).click();

        // Dress text displayed
        Assert.assertTrue(productCategoryPage.verifyDressTextDisplayed());

        Thread.sleep(3000);
        // Checkbox Categories Summer Dresses
        driver.findElement(By.xpath(ProductCategoryPageProperties.CHECKBOX_CATEGORY_SUMMER_DRESSES_XPATH)).click();

        Thread.sleep(3000);
        // Checkbox Categories Evening Dresses
        driver.findElement(By.xpath(ProductCategoryPageProperties.CHECKBOX_CATEGORY_EVENING_DRESSES_XPATH)).click();

        Thread.sleep(3000);
        // Checkbox Categories Casual Dresses
        driver.findElement(By.xpath(ProductCategoryPageProperties.CHECKBOX_CATEGORY_CASUAL_DRESSES_XPATH)).click();

        Thread.sleep(3000);
        // Checkbox Size
        driver.findElement(By.xpath(ProductCategoryPageProperties.CHECKBOX_SIZE_MEDIUM_XPATH)).click();

        Thread.sleep(3000);
        // Checkbox Color Yellow
        driver.findElement(By.xpath(ProductCategoryPageProperties.CHECKBOX_COLOR_YELLOW_XPATH)).click();

        Thread.sleep(3000);
        // Checkbox Availability In Stock
        driver.findElement(By.xpath(ProductCategoryPageProperties.CHECKBOX_AVAILABILITY_IN_STOCK_XPATH)).click();

        Thread.sleep(3000);
        // Menu T-Shirts
        driver.findElement(By.xpath(ProductCategoryPageProperties.MENU_TSHIRTS_XPATH)).click();

        // T-Shirts text displayed
        Assert.assertTrue(productCategoryPage.verifyTShirtsTextDisplayed());

    }

    @Test(priority = 21)
    public void verifySubCategoryLinkTest() throws InterruptedException {
        // 2.2. Sub-Categories link should be presented to the User.
        ExtentTestManager.getTest().log(Status.INFO, "Verify Sub Category Link Page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Thread.sleep(3000);
        // Menu Women
        driver.findElement(By.xpath(ProductCategoryPageProperties.MENU_WOMEN_XPATH)).click();

        Thread.sleep(3000);
        // Subcategories Field
        //driver.findElement(By.xpath(ProductCategoryPageProperties.SUBCATEGORIES_FIELD_WOMEN_XPATH)).isDisplayed();
        Assert.assertTrue(productCategoryPage.verifySubcategoryFieldWomenDisplayed());
        driver.findElement(By.xpath(ProductCategoryPageProperties.SUBCATEGORIES_HEADER_IMAGE_WOMEN_XPATH)).isDisplayed();
        driver.findElement(By.xpath(ProductCategoryPageProperties.SUBCATEGORIES_HEADER_BG_WOMEN_XPATH)).isDisplayed();


        Thread.sleep(3000);
        // Subcategories TOPS Link
        //driver.findElement(By.xpath(ProductCategoryPageProperties.LNK_SUBCATEGORIES_TOPS_XPATH)).isDisplayed();
        Assert.assertTrue(productCategoryPage.verifySubcategoryLinkTopsDisplayed());
        driver.findElement(By.xpath(ProductCategoryPageProperties.LNK_SUBCATEGORIES_TOPS_XPATH)).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.SUBCATEGORIES_HEADER_IMAGE_TOPS_XPATH)).isDisplayed();
        driver.findElement(By.xpath(ProductCategoryPageProperties.SUBCATEGORIES_HEADER_BG_TOPS_XPATH)).isDisplayed();


        Thread.sleep(3000);
        // Menu Women
        driver.findElement(By.xpath(ProductCategoryPageProperties.MENU_WOMEN_XPATH)).click();

        Thread.sleep(3000);
        // Subcategories Field
        driver.findElement(By.xpath(ProductCategoryPageProperties.SUBCATEGORIES_FIELD_WOMEN_XPATH)).isDisplayed();
        driver.findElement(By.xpath(ProductCategoryPageProperties.SUBCATEGORIES_HEADER_IMAGE_WOMEN_XPATH)).isDisplayed();
        driver.findElement(By.xpath(ProductCategoryPageProperties.SUBCATEGORIES_HEADER_BG_WOMEN_XPATH)).isDisplayed();
        Assert.assertTrue(productCategoryPage.verifySubcategoryFieldWomenDisplayed());

        Thread.sleep(3000);
        // Subcategories DRESSES Link
        //driver.findElement(By.xpath(ProductCategoryPageProperties.LNK_SUBCATEGORIES_DRESSES_XPATH)).isDisplayed();
        Assert.assertTrue(productCategoryPage.verifySubcategoryLinkDressesDisplayed());
        driver.findElement(By.xpath(ProductCategoryPageProperties.LNK_SUBCATEGORIES_DRESSES_XPATH)).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.SUBCATEGORIES_HEADER_IMAGE_DRESSES_XPATH)).isDisplayed();
        driver.findElement(By.xpath(ProductCategoryPageProperties.SUBCATEGORIES_HEADER_BG_DRESSES_XPATH)).isDisplayed();

        Thread.sleep(3000);
        // Subcategories CASUAL DRESSES Link
        Assert.assertTrue(productCategoryPage.verifySubcategoryLinkCasualDressesDisplayed());
        // Subcategories EVENING DRESSES Link
        Assert.assertTrue(productCategoryPage.verifySubcategoryLinkEveningDressesDisplayed());
        // Subcategories SUMMER DRESSES Link
        Assert.assertTrue(productCategoryPage.verifySubcategoryLinkSummerDressesDisplayed());


    }

    @Test(priority = 22)
    public void verifySortFunctionalityTest() throws InterruptedException {
        // 2.3. Sort Functionality is available for User to sort the products.
        ExtentTestManager.getTest().log(Status.INFO, "Verify Sort Functionality availability Page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Thread.sleep(3000);
        // Menu Women
        driver.findElement(By.xpath(ProductCategoryPageProperties.MENU_WOMEN_XPATH)).click();

        Thread.sleep(3000);
        // Subcategories Field
        //driver.findElement(By.xpath(ProductCategoryPageProperties.SUBCATEGORIES_FIELD_WOMEN_XPATH)).isDisplayed();
        Assert.assertTrue(productCategoryPage.verifySubcategoryFieldWomenDisplayed());
        driver.findElement(By.xpath(ProductCategoryPageProperties.SUBCATEGORIES_HEADER_IMAGE_WOMEN_XPATH)).isDisplayed();
        driver.findElement(By.xpath(ProductCategoryPageProperties.SUBCATEGORIES_HEADER_BG_WOMEN_XPATH)).isDisplayed();


        // Sort By Form
        //driver.findElement(By.xpath("//form[@id='productsSortForm']")).isDisplayed();
        Assert.assertTrue(productCategoryPage.verifySortByFormDisplayed());
        // Sort By Link
        //driver.findElement(By.xpath("//div[@id='uniform-selectProductSort']")).isDisplayed();
        Assert.assertTrue(productCategoryPage.verifySortByLinkDisplayed());


        Thread.sleep(3000);
        // Select Sort By
        Select priceLowestFirst = new Select(driver.findElement(By.xpath(ProductCategoryPageProperties.SELECT_PRODUCT_SORT_XPATH)));
        //priceLowestFirst.selectByValue("price:asc");
        priceLowestFirst.selectByVisibleText(ProductCategoryPageProperties.SELECT_BY_VISIBLE_TEXT_PRICE_LOWEST_FIRST_XPATH);
        //Assert.assertTrue(productCategoryPage.verifySelectProductSortDisplayed()); // Not working

        Thread.sleep(3000);
        Select priceHighestFirst = new Select(driver.findElement(By.xpath(ProductCategoryPageProperties.SELECT_PRODUCT_SORT_XPATH)));
        priceHighestFirst.selectByVisibleText(ProductCategoryPageProperties.SELECT_BY_VISIBLE_TEXT_PRICE_HIGHEST_FIRST_XPATH);

        Thread.sleep(3000);
        Select productNameAtoZ = new Select(driver.findElement(By.xpath(ProductCategoryPageProperties.SELECT_PRODUCT_SORT_XPATH)));
        productNameAtoZ.selectByVisibleText(ProductCategoryPageProperties.SELECT_BY_VISIBLE_TEXT_PRODUCT_A_TO_Z_XPATH);

        Thread.sleep(3000);
        Select productNameZtoA = new Select(driver.findElement(By.xpath(ProductCategoryPageProperties.SELECT_PRODUCT_SORT_XPATH)));
        productNameZtoA.selectByVisibleText(ProductCategoryPageProperties.SELECT_BY_VISIBLE_TEXT_PRODUCT_Z_TO_A_XPATH);

        Thread.sleep(3000);
        Select inStock = new Select(driver.findElement(By.xpath(ProductCategoryPageProperties.SELECT_PRODUCT_SORT_XPATH)));
        inStock.selectByVisibleText(ProductCategoryPageProperties.SELECT_BY_VISIBLE_TEXT_IN_STOCK_XPATH);

        Thread.sleep(3000);
        Select referenceLowestFirst = new Select(driver.findElement(By.xpath(ProductCategoryPageProperties.SELECT_PRODUCT_SORT_XPATH)));
        referenceLowestFirst.selectByVisibleText(ProductCategoryPageProperties.SELECT_BY_VISIBLE_TEXT_REFERENCE_LOWEST_FIRST_XPATH);

        Thread.sleep(3000);
        Select referenceHighestFirst = new Select(driver.findElement(By.xpath(ProductCategoryPageProperties.SELECT_PRODUCT_SORT_XPATH)));
        referenceHighestFirst.selectByVisibleText(ProductCategoryPageProperties.SELECT_BY_VISIBLE_TEXT_REFERENCE_HIGHEST_FIRST_XPATH);

        Thread.sleep(3000);

    }

    @Test(priority = 23)
    public void verifyGridOrListViewTest() throws InterruptedException {
        // 2.4. User can change the view of the product list by clicking Grid or List.
        ExtentTestManager.getTest().log(Status.INFO, "Verify Grid or List Functionality availability in Product Page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Thread.sleep(3000);
        // Menu Women
        driver.findElement(By.xpath(ProductCategoryPageProperties.MENU_WOMEN_XPATH)).click();

        Thread.sleep(3000);
        // Subcategories Field
        //driver.findElement(By.xpath(ProductCategoryPageProperties.SUBCATEGORIES_FIELD_WOMEN_XPATH)).isDisplayed();
        Assert.assertTrue(productCategoryPage.verifySubcategoryFieldWomenDisplayed());
        driver.findElement(By.xpath(ProductCategoryPageProperties.SUBCATEGORIES_HEADER_IMAGE_WOMEN_XPATH)).isDisplayed();
        driver.findElement(By.xpath(ProductCategoryPageProperties.SUBCATEGORIES_HEADER_BG_WOMEN_XPATH)).isDisplayed();


        Thread.sleep(3000);
        // Product View Field
        //driver.findElement(By.xpath("//ul[@class='display hidden-xs']")).isDisplayed();
        Assert.assertTrue(productCategoryPage.verifyProductViewFieldDisplayed());

        Thread.sleep(3000);
        // List View
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_VIEW_BY_LIST_XPATH)).click();

        // Add to Wishlist under list view
        Assert.assertTrue(productCategoryPage.verifyListViewAddtoWishlistDisplayed());

        Thread.sleep(3000);
        // Grid View
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_VIEW_BY_GRID_XPATH)).click();
        Thread.sleep(3000);

    }

    @Test(priority = 24)
    public void verifyNumberOfProductsViewTest() throws InterruptedException {
        // 2.5. Number of products showing should display on the page.
        ExtentTestManager.getTest().log(Status.INFO, "Verify Number of products showing on the Page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Thread.sleep(3000);
        // Menu Women
        driver.findElement(By.xpath(ProductCategoryPageProperties.MENU_WOMEN_XPATH)).click();

        Thread.sleep(3000);
        // Number of Products showing on right top
        Assert.assertTrue(productCategoryPage.verifyNumberOfProductsRightTopDisplayed());

        // Product Count showing under sort by
        Assert.assertTrue(productCategoryPage.verifyProductCountTopLeftDisplayed());

        // Product Count showing lower left
        Assert.assertTrue(productCategoryPage.verifyProductCountBottomLeftDisplayed());



    }

    @Test(priority = 25)
    public void verifyFilterProductsLeftNavigationTest() throws InterruptedException {
        // 2.6. User should be able to filter products from left navigation by Size,Color, Compositions, Style, Properties, Availability, Manufacture and Condition.
        ExtentTestManager.getTest().log(Status.INFO, "Verify filter products from left navigation on the Page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Thread.sleep(2000);
        // Menu Dresses
        driver.findElement(By.xpath(ProductCategoryPageProperties.MENU_DRESSES_XPATH)).click();

        Thread.sleep(2000);
        // Summer Dresses
        driver.findElement(By.xpath(ProductCategoryPageProperties.CHECKBOX_CATEGORY_SUMMER_DRESSES_XPATH)).click();

        Assert.assertTrue(productCategoryPage.verifyCheckBoxConditionNewEnabled());

        Thread.sleep(3000);
        // Evening Dresses
        driver.findElement(By.xpath(ProductCategoryPageProperties.CHECKBOX_CATEGORY_EVENING_DRESSES_XPATH)).click();

        Thread.sleep(3000);
        // Casual Dresses
        driver.findElement(By.xpath(ProductCategoryPageProperties.CHECKBOX_CATEGORY_CASUAL_DRESSES_XPATH)).click();

        Thread.sleep(3000);
        // Size Small
        driver.findElement(By.xpath(ProductCategoryPageProperties.CHECKBOX_SIZE_SMALL_XPATH)).click();

        Thread.sleep(3000);
        // Color Yellow
        driver.findElement(By.xpath(ProductCategoryPageProperties.CHECKBOX_COLOR_GREEN_XPATH)).click();

        Thread.sleep(3000);
        // Composition Polyester
        driver.findElement(By.xpath(ProductCategoryPageProperties.CHECKBOX_COMPOSITION_POLYESTER_XPATH)).click();

        Thread.sleep(3000);
        // Styles Girly
        driver.findElement(By.xpath(ProductCategoryPageProperties.CHECKBOX_STYLES_GIRLY_XPATH)).click();

        Thread.sleep(3000);
        // Properties Midi Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.CHECKBOX_PROPERTIES_MIDI_DRESS_XPATH)).click();

        Thread.sleep(3000);
        // Availability In Stock
        driver.findElement(By.xpath(ProductCategoryPageProperties.CHECKBOX_AVAILABILITY_IN_STOCK_XPATH)).click();

        Thread.sleep(3000);
        // Manufacturer Fashion Manufacturer
        driver.findElement(By.xpath(ProductCategoryPageProperties.CHECKBOX_MANUFACTURER_FASHION_MANUFACTURER_XPATH)).click();


        Thread.sleep(3000);
        // Condition New
        driver.findElement(By.xpath(ProductCategoryPageProperties.CHECKBOX_CONDITION_NEW_XPATH)).click();

        Assert.assertTrue(productCategoryPage.verifyPriceRangeSliderDisplayed());

        Thread.sleep(2000);
        WebElement sourceElement = driver.findElement(By.xpath(ProductCategoryPageProperties.SLIDER_PRICE_RANGE_BEGINNING_XPATH));
        WebElement targetElement = driver.findElement(By.xpath(ProductCategoryPageProperties.SLIDER_PRICE_RANGE_ENDING_XPATH));
        Actions moveSlider = new Actions(driver);
        Action action = moveSlider.dragAndDropBy(sourceElement, 50, 0).build();
        action.perform();

        Thread.sleep(3000);
        // Menu T-Shirts
        driver.findElement(By.xpath(ProductCategoryPageProperties.MENU_TSHIRTS_XPATH)).click();



    }

    @Test(priority = 26)
    public void verifyFilterProductsPriceRangeTest() throws InterruptedException {
        // 2.7. User should be able to filter item using the Price Range bar.
        ExtentTestManager.getTest().log(Status.INFO, "Verify filter products using the Price Range bar on the Page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Thread.sleep(2000);
        // Menu Dresses
        //driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[2]/a")).click();
        driver.findElement(By.xpath(ProductCategoryPageProperties.MENU_DRESSES_XPATH)).click();

        Thread.sleep(2000);
        Assert.assertTrue(productCategoryPage.verifyCheckBoxSummerDressEnabled());

        // Summer Dresses
        driver.findElement(By.xpath(ProductCategoryPageProperties.CHECKBOX_CATEGORY_SUMMER_DRESSES_XPATH)).click();
        Thread.sleep(2000);
        Assert.assertTrue(productCategoryPage.verifyCheckBoxSummerDressSelected());

        Assert.assertTrue(productCategoryPage.verifyPriceRangeSliderDisplayed());

        Thread.sleep(3000);
        WebElement sourceElement = driver.findElement(By.xpath(ProductCategoryPageProperties.SLIDER_PRICE_RANGE_BEGINNING_XPATH));
        WebElement targetElement = driver.findElement(By.xpath(ProductCategoryPageProperties.SLIDER_PRICE_RANGE_ENDING_XPATH));
        Actions moveSlider = new Actions(driver);
        Action action = moveSlider.dragAndDropBy(sourceElement, 50, 0).build();
        action.perform();
        Action action1 = moveSlider.dragAndDropBy(targetElement, -50, 0).build();
        action1.perform();


        Thread.sleep(3000);


    }

    @Test(priority = 27)
    public void verifyDiscoverOurStoresLinkTest() throws InterruptedException {
        // 2.8. User should be able to find the store location by clicking “Discover Our Stores”
        ExtentTestManager.getTest().log(Status.INFO, "Verify to find the store location by clicking “Discover Our Stores” on the Page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.FOOTER_INFORMATION_LNK_OUR_STORES_XPATH)).click();

        driver.findElement(By.xpath(ProductCategoryPageProperties.TXT_BOX_SITEMAP_YOUR_LOCATION_XPATH)).sendKeys("11 Mary Butler Dr, 06385, Waterford, Connecticut, United States");

        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_SITEMAP_SEARCH_LOCATION_XPATH)).click();



    }

    @Test(priority = 28)
    public void verifyMouseOverProductViewTest() throws InterruptedException {
        // 2.9. Add to Cart or More Button should be visible when user mouse over to product.
        ExtentTestManager.getTest().log(Status.INFO, "Verify mouse over to view Add to Cart or More Button on the Page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Thread.sleep(3000);
        WebElement sourceElement = driver.findElement(By.xpath(ProductCategoryPageProperties.HOME_FEATURE_PRODUCT_LIST_01_XPATH));

        Actions actions = new Actions(driver);
        actions.moveToElement(sourceElement).perform();

        Assert.assertTrue(productCategoryPage.verifyFeatureProductList_01_AddToCartDisplayed());
        Assert.assertTrue(productCategoryPage.verifyFeatureProductList_01_MoreDisplayed());

        Thread.sleep(3000);

    }

    @Test(priority = 29)
    public void verifyInOrOutOfStockIconViewTest() throws InterruptedException {
        // 2.10. In Stock/Out of Stock icon should display for each item.
        ExtentTestManager.getTest().log(Status.INFO, "Verify In Stock/Out of Stock icon should display for each item on the Page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.HOME_FEATURE_PRODUCT_TSHIRTS_XPATH)).click();

        Thread.sleep(3000);
        // In Stock/Out of Stock icon
        Assert.assertTrue(productCategoryPage.verifyFeatureProductInStockIconDisplayed());

        Thread.sleep(3000);

    }

    @Test(priority = 30)
    public void verifyMouseOverProductQuickViewTest() throws InterruptedException {
        // 2.11. Quick View link should be visible when user mouse over to product
        ExtentTestManager.getTest().log(Status.INFO, "Verify mouse over to view Quick View link on the Page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Thread.sleep(3000);
        WebElement sourceElement = driver.findElement(By.xpath(ProductCategoryPageProperties.HOME_FEATURE_PRODUCT_LIST_01_XPATH));

        Actions actions = new Actions(driver);
        actions.moveToElement(sourceElement).perform();
        Thread.sleep(3000);

        Assert.assertTrue(productCategoryPage.verifyFeatureProductList_01_QuickViewDisplayed());
        Thread.sleep(3000);


    }

    @Test(priority = 31)
    public void verifyDifferentLinkInformationTest() throws InterruptedException {
        // 2.12. Information with different link is available for User.
        ExtentTestManager.getTest().log(Status.INFO, "Verify Information with different link is available on the Page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Thread.sleep(3000);
        // Menu Women
        driver.findElement(By.xpath(ProductCategoryPageProperties.MENU_WOMEN_XPATH)).click();

        Thread.sleep(3000);
        // Subcategories Field
        Assert.assertTrue(productCategoryPage.verifySubcategoryFieldWomenDisplayed());

        // Product Information Links
        Assert.assertTrue(productCategoryPage.verifyProductInformationBlockTitleDisplayed());

        Assert.assertTrue(productCategoryPage.verifyProductInformationDeliveryLinkEnabled());
        Assert.assertTrue(productCategoryPage.verifyProductInformationLegalNoticeLinkEnabled());
        Assert.assertTrue(productCategoryPage.verifyProductInformationTermsAndConditionLinkEnabled());
        Assert.assertTrue(productCategoryPage.verifyProductInformationAboutUsLinkEnabled());
        Assert.assertTrue(productCategoryPage.verifyProductInformationSecurePaymentLinkEnabled());
        Assert.assertTrue(productCategoryPage.verifyProductInformationOurStoresLinkEnabled());

        Thread.sleep(3000);



    }

    @Test(priority = 32)
    public void verifyAddMultipleProductToCartTest() throws InterruptedException {
        // 2.13. User should be able to add multiple product to cart from Product Category page.
        ExtentTestManager.getTest().log(Status.INFO, "Verify to add multiple product to cart from Product Category page.");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Thread.sleep(3000);
        // Menu Women
        driver.findElement(By.xpath(ProductCategoryPageProperties.MENU_WOMEN_XPATH)).click();

        Thread.sleep(3000);
        WebElement TShirts = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_TSHIRTS_XPATH));
        Actions actions = new Actions(driver);
        actions.moveToElement(TShirts).perform();

        Thread.sleep(3000);
        // Add to cart T-Shirts
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_TSHIRTS_ADD_TO_CART_XPATH)).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();

        Thread.sleep(3000);
        WebElement printedDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_DRESS_XPATH));
        actions.moveToElement(printedDress).perform();

        Thread.sleep(3000);
        // Add to cart Printed Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_DRESS_ADD_TO_CART_XPATH)).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();

        Thread.sleep(3000);
        WebElement printedChiffonDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_CHIFFON_DRESS_XPATH));
        actions.moveToElement(printedChiffonDress).perform();

        Thread.sleep(3000);
        // Add to cart Printed Chiffon Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_CHIFFON_DRESS_ADD_TO_CART_XPATH)).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();

        Thread.sleep(3000);
        WebElement printedSummerDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_SUMMER_DRESS_XPATH));
        actions.moveToElement(printedSummerDress).perform();

        Thread.sleep(3000);
        // Add to cart Printed Summer Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_SUMMER_DRESS_ADD_TO_CART_XPATH)).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PROCEED_TO_CHECKOUT_XPATH)).click();


        Thread.sleep(3000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());

        Thread.sleep(3000);
        // Proceed to Checkout
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_PROCEED_TO_CHECKOUT_XPATH)).click();

        Thread.sleep(3000);
        // Sign Button Displayed
        Assert.assertTrue(productCategoryPage.verifySignInButtonDisplayed());
        Thread.sleep(3000);


    }

    @Test(priority = 33)
    public void verifyProductAddedCartUpdatedTest() throws InterruptedException {
        // 2.14. Cart should be updated after product added to cart.
        ExtentTestManager.getTest().log(Status.INFO, "Verify Cart updated after product added to cart on the Page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Thread.sleep(3000);
        // Menu Women
        driver.findElement(By.xpath(ProductCategoryPageProperties.MENU_WOMEN_XPATH)).click();

        Thread.sleep(3000);
        WebElement TShirts = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_TSHIRTS_XPATH));
        Actions actions = new Actions(driver);
        actions.moveToElement(TShirts).perform();

        Thread.sleep(3000);
        // Add to cart T-Shirts
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_TSHIRTS_ADD_TO_CART_XPATH)).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();

        Thread.sleep(3000);
        WebElement printedDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_DRESS_XPATH));
        actions.moveToElement(printedDress).perform();

        Thread.sleep(3000);
        // Add to cart Printed Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_DRESS_ADD_TO_CART_XPATH)).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();

        Thread.sleep(3000);
        WebElement printedChiffonDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_CHIFFON_DRESS_XPATH));
        actions.moveToElement(printedChiffonDress).perform();

        Thread.sleep(3000);
        // Add to cart Printed Chiffon Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_CHIFFON_DRESS_ADD_TO_CART_XPATH)).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();

        Thread.sleep(3000);
        WebElement printedSummerDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_SUMMER_DRESS_XPATH));
        actions.moveToElement(printedSummerDress).perform();

        Thread.sleep(3000);
        // Add to cart Printed Summer Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_SUMMER_DRESS_ADD_TO_CART_XPATH)).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PROCEED_TO_CHECKOUT_XPATH)).click();


        Thread.sleep(3000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());

        Thread.sleep(3000);
        // Proceed to Checkout
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_PROCEED_TO_CHECKOUT_XPATH)).click();

        Thread.sleep(3000);
        // Sign Button Displayed
        Assert.assertTrue(productCategoryPage.verifySignInButtonDisplayed());
        Thread.sleep(3000);

        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_EMAIL_XPATH)).sendKeys("khaledhasanb@gmail.com");
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_PASSWORD_XPATH)).sendKeys("khaled1234567890");

        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_SIGN_IN_XPATH)).click();
        Thread.sleep(3000);

        Thread.sleep(3000);
        // Proceed to Checkout Address
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_PROCEED_TO_CHECKOUT_ADDRESS_XPATH)).click();

        Thread.sleep(3000);
        // Terms of service Checkbox
        driver.findElement(By.xpath(ProductCategoryPageProperties.CHECKBOX_TERMS_OF_SERVICE_XPATH)).click();

        Thread.sleep(3000);
        // Proceed to Checkout Shipping
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_PROCEED_TO_CHECKOUT_SHIPPING_XPATH)).click();

        Thread.sleep(3000);
        // Your Payment Method Heading Displayed
        Assert.assertTrue(productCategoryPage.verifyYourPaymentMethodHeadingDisplayed());

        Thread.sleep(3000);


    }

    @Test(priority = 34)
    public void verifyProductOverlayCheckOutButtonTest() throws InterruptedException {
        //  2.15. Check out button should be available for user from Product Overlay.
        ExtentTestManager.getTest().log(Status.INFO, "Verify Check out button available for user from Product Overlay on the Page");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // With add products in Cart
        Thread.sleep(3000);
        // Menu Women
        driver.findElement(By.xpath(ProductCategoryPageProperties.MENU_WOMEN_XPATH)).click();


        Thread.sleep(3000);
        WebElement printedSummerDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_SUMMER_DRESS_XPATH));
        Actions actions = new Actions(driver);
        actions.moveToElement(printedSummerDress).perform();

        Thread.sleep(3000);
        // Add to cart Printed Summer Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_SUMMER_DRESS_ADD_TO_CART_XPATH)).click();
        // Proceed To Checkout Button Enabled
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        // Proceed to Check out Button in Product Overlay
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PROCEED_TO_CHECKOUT_XPATH)).click();


        Thread.sleep(3000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());


        Thread.sleep(3000);
        // Proceed to Checkout
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_PROCEED_TO_CHECKOUT_XPATH)).click();

        Thread.sleep(3000);
        // Go to Homepage
        driver.findElement(By.xpath(ProductCategoryPageProperties.HEADER_LOGO_HOME_PAGE_XPATH)).click();

        Thread.sleep(3000);
        WebElement shoppingCart = driver.findElement(By.xpath(ProductCategoryPageProperties.VIEW_MY_SHOPPING_CART_XPATH));
        actions.moveToElement(shoppingCart).perform();

        Thread.sleep(3000);
        // Click Checkout Button
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_CHECK_OUT_SHOPPING_CART_XPATH)).click();

        Thread.sleep(3000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());

        Thread.sleep(3000);
        // Go to Homepage
        driver.findElement(By.xpath(ProductCategoryPageProperties.HEADER_LOGO_HOME_PAGE_XPATH)).click();

        Thread.sleep(3000);
        // Sign In Button clicked
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_XPATH)).click();

        Thread.sleep(3000);
        // Sign Button Displayed
        Assert.assertTrue(productCategoryPage.verifySignInButtonDisplayed());

        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_EMAIL_XPATH)).sendKeys("khaledhasanb@gmail.com");
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_PASSWORD_XPATH)).sendKeys("khaled1234567890");

        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_SIGN_IN_XPATH)).click();
        Thread.sleep(3000);

        WebElement shoppingCart_01 = driver.findElement(By.xpath(ProductCategoryPageProperties.VIEW_MY_SHOPPING_CART_XPATH));
        actions.moveToElement(shoppingCart_01).perform();

        Thread.sleep(3000);
        // Click Check Out button
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_CHECK_OUT_SHOPPING_CART_XPATH)).click();

        Thread.sleep(3000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());

        Thread.sleep(3000);
        // Log Out from Account
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_OUT_XPATH)).click();




    }

    @Test(priority = 35)
    public void verifyCheckOutButtonNavigateToShoppingCartTest() throws InterruptedException {
        //  2.16. Check out button should navigate to shopping cart summary page.
        ExtentTestManager.getTest().log(Status.INFO, "Verify Check out button navigate to shopping cart summary page.");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Without add any product
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.VIEW_MY_SHOPPING_CART_XPATH)).click();

        Thread.sleep(3000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());

        Thread.sleep(3000);
        // Sign In Button clicked
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_XPATH)).click();

        Thread.sleep(3000);
        // Sign Button Displayed
        Assert.assertTrue(productCategoryPage.verifySignInButtonDisplayed());

        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_EMAIL_XPATH)).sendKeys("khaledhasanb@gmail.com");
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_PASSWORD_XPATH)).sendKeys("khaled1234567890");
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_SIGN_IN_XPATH)).click();
        Thread.sleep(3000);

        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.VIEW_MY_SHOPPING_CART_XPATH)).click();

        Thread.sleep(3000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());

        Thread.sleep(3000);
        // Log Out from Account
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_OUT_XPATH)).click();

        Thread.sleep(3000);
        // Go to Homepage
        driver.findElement(By.xpath(ProductCategoryPageProperties.HEADER_LOGO_HOME_PAGE_XPATH)).click();

        // With add products in Cart
        Thread.sleep(3000);
        // Menu Women
        driver.findElement(By.xpath(ProductCategoryPageProperties.MENU_WOMEN_XPATH)).click();

        Thread.sleep(3000);
        WebElement TShirts = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_TSHIRTS_XPATH));
        Actions actions = new Actions(driver);
        actions.moveToElement(TShirts).perform();

        Thread.sleep(3000);
        // Add to cart T-Shirts
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_TSHIRTS_ADD_TO_CART_XPATH)).click();
        //driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PROCEED_TO_CHECKOUT_XPATH)).isDisplayed();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();

        Thread.sleep(3000);
        WebElement printedDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_DRESS_XPATH));
        actions.moveToElement(printedDress).perform();

        Thread.sleep(3000);
        // Add to cart Printed Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_DRESS_ADD_TO_CART_XPATH)).click();
        //driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PROCEED_TO_CHECKOUT_XPATH)).isDisplayed();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();

        Thread.sleep(3000);
        WebElement printedChiffonDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_CHIFFON_DRESS_XPATH));
        actions.moveToElement(printedChiffonDress).perform();

        Thread.sleep(3000);
        // Add to cart Printed Chiffon Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_CHIFFON_DRESS_ADD_TO_CART_XPATH)).click();
        //driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PROCEED_TO_CHECKOUT_XPATH)).isDisplayed();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH)).click();

        Thread.sleep(3000);
        WebElement printedSummerDress = driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_SUMMER_DRESS_XPATH));
        actions.moveToElement(printedSummerDress).perform();

        Thread.sleep(3000);
        // Add to cart Printed Summer Dress
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PRINTED_SUMMER_DRESS_ADD_TO_CART_XPATH)).click();
        //driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PROCEED_TO_CHECKOUT_XPATH)).isDisplayed();
        Assert.assertTrue(productCategoryPage.verifyProceedToCheckoutProductOverlayEnabled());
        Thread.sleep(3000);
        driver.findElement(By.xpath(ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PROCEED_TO_CHECKOUT_XPATH)).click();


        Thread.sleep(3000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());

        Thread.sleep(3000);
        // Proceed to Checkout
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_PROCEED_TO_CHECKOUT_XPATH)).click();

        Thread.sleep(3000);
        // Go to Homepage
        driver.findElement(By.xpath(ProductCategoryPageProperties.HEADER_LOGO_HOME_PAGE_XPATH)).click();

        Thread.sleep(3000);
        WebElement shoppingCart = driver.findElement(By.xpath(ProductCategoryPageProperties.VIEW_MY_SHOPPING_CART_XPATH));
        actions.moveToElement(shoppingCart).perform();

        Assert.assertTrue(productCategoryPage.verifyCheckOutButtonEnabled());
        //Thread.sleep(3000);
        // Click Checkout Button
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_CHECK_OUT_SHOPPING_CART_XPATH)).click();

        Thread.sleep(3000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());

        Thread.sleep(3000);
        // Go to Homepage
        driver.findElement(By.xpath(ProductCategoryPageProperties.HEADER_LOGO_HOME_PAGE_XPATH)).click();

        Thread.sleep(3000);
        // Sign In Button clicked
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_IN_XPATH)).click();

        Thread.sleep(3000);
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
        Thread.sleep(3000);
        // Click Check Out button
        driver.findElement(By.xpath(ProductCategoryPageProperties.BTN_CHECK_OUT_SHOPPING_CART_XPATH)).click();

        Thread.sleep(3000);
        // SHOPPING-CART SUMMARY displayed
        Assert.assertTrue(productCategoryPage.verifyShoppingCartSummaryTitleDisplayed());

        Thread.sleep(3000);
        // Log Out from Account
        driver.findElement(By.xpath(ProductCategoryPageProperties.SIGN_OUT_XPATH)).click();





    }



    @AfterMethod
    public void close(){
        driver.quit();
    }


}
