package com.ebfs.qa.testcases;

import com.aventstack.extentreports.Status;
import com.ebfs.qa.base.TestBase;
import com.ebfs.qa.pages.HomePage;
import com.ebfs.qa.pages.SignInPage;
import com.ebfs.qa.properties.HomePageProperties;
import com.ebfs.qa.properties.TestUtilProperties;
import com.ebfs.qa.util.TestUtil;
import com.qa.ExtentReportListener.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInPageTest extends TestBase {
    //WebDriver driver;
    HomePage homePage;
    TestUtil testUtil;
    SignInPage signInPage;
    String sheetName = "SignIn";
    ExtentTestManager extentTestManager;
    //TestUtil testUtil = new TestUtil();

    public SignInPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException{
        initialization();
        testUtil = new TestUtil();
        signInPage = new SignInPage();
        homePage = new HomePage();
        //signInPage = homePage.clickOnSignInLink(); // This link clicked for Sign In Page

    }

    @Test(priority = 18)
    public void verifyLogin() throws Exception { // 1.3. Registered user should be able to Login from Home Page.

        testUtil.setExcelFile(TestUtilProperties.TESTDATA_SHEET_PATH, TestUtilProperties.sheetName);
        String email = testUtil.getCellData(1,1);
        String password = testUtil.getCellData(1,2);

        ExtentTestManager.getTest().log(Status.INFO, "Verify Sign In Page");


        WebElement signIn = driver.findElement(By.xpath(HomePageProperties.LNK_SIGN_IN_XPATH));
        signIn.click();

        WebElement txtBxEmail = driver.findElement(By.xpath(HomePageProperties.SIGN_IN_EMAIL_XPATH));
        txtBxEmail.sendKeys(email);

        WebElement txtBxPassword =driver.findElement(By.xpath(HomePageProperties.SIGN_IN_PASSWORD_XPATH));
        txtBxPassword.sendKeys(password);

        driver.findElement(By.xpath(HomePageProperties.BTN_SIGN_IN_XPATH)).click();



        Assert.assertEquals("My account - eBFS - the power of choice", driver.getTitle());
        System.out.println(driver.getTitle());



        //testUtil.setCellData("Pass", 1,3, TestUtilProperties.TESTDATA_SHEET_PATH);

        driver.getCurrentUrl();
        if(driver.getCurrentUrl().equals("http://ebfs.bruteforcesolution.net/ebfs/index.php?controller=my-account")) {
            testUtil.setCellData("Pass", 1,3, TestUtilProperties.TESTDATA_SHEET_PATH);
        }else {
            testUtil.setCellData("Fail", 1,3, TestUtilProperties.TESTDATA_SHEET_PATH);
            Thread.sleep(2000);
        }

    }

    @Test(priority = 19)
    public void verifyLoginPassErr() throws Exception { // 1.3. Registered user should be able to Login from Home Page.

        testUtil.setExcelFile(TestUtilProperties.TESTDATA_SHEET_PATH, TestUtilProperties.sheetName);
        String email = testUtil.getCellData(3,1);
        String password = testUtil.getCellData(3,2);

        ExtentTestManager.getTest().log(Status.INFO, "Verify Sign In Page");


        WebElement signIn = driver.findElement(By.xpath(HomePageProperties.LNK_SIGN_IN_XPATH));
        signIn.click();

        WebElement txtBxEmail = driver.findElement(By.xpath(HomePageProperties.SIGN_IN_EMAIL_XPATH));
        txtBxEmail.sendKeys(email);

        WebElement txtBxPassword =driver.findElement(By.xpath(HomePageProperties.SIGN_IN_PASSWORD_XPATH));
        txtBxPassword.sendKeys(password);


        driver.findElement(By.xpath(HomePageProperties.BTN_SIGN_IN_XPATH)).click();


        WebElement errMessage =driver.findElement(By.xpath(HomePageProperties.ERR_MESSAGE));
        Assert.assertEquals("Authentication failed.", errMessage.getText());


        //testUtil.setCellData("Pass", 1,3, TestUtilProperties.TESTDATA_SHEET_PATH);

        driver.getCurrentUrl();
        if(driver.getCurrentUrl().equals("http://ebfs.bruteforcesolution.net/ebfs/index.php?controller=my-account")) {
            testUtil.setCellData("Pass", 3,3, TestUtilProperties.TESTDATA_SHEET_PATH);
        }else {
            testUtil.setCellData("Fail", 3,3, TestUtilProperties.TESTDATA_SHEET_PATH);
            Thread.sleep(2000);
        }



    }

    @Test(priority = 20)
    public void verifyLoginUserErr() throws Exception { // 1.3. Registered user should be able to Login from Home Page.

        testUtil.setExcelFile(TestUtilProperties.TESTDATA_SHEET_PATH, TestUtilProperties.sheetName);
        String email = testUtil.getCellData(4,1);
        String password = testUtil.getCellData(4,2);

        ExtentTestManager.getTest().log(Status.INFO, "Verify Sign In Page");


        WebElement signIn = driver.findElement(By.xpath(HomePageProperties.LNK_SIGN_IN_XPATH));
        signIn.click();

        WebElement txtBxEmail = driver.findElement(By.xpath(HomePageProperties.SIGN_IN_EMAIL_XPATH));
        txtBxEmail.sendKeys(email);

        WebElement txtBxPassword =driver.findElement(By.xpath(HomePageProperties.SIGN_IN_PASSWORD_XPATH));
        txtBxPassword.sendKeys(password);


        driver.findElement(By.xpath(HomePageProperties.BTN_SIGN_IN_XPATH)).click();


        WebElement errMessage =driver.findElement(By.xpath(HomePageProperties.ERR_MESSAGE));
        Assert.assertEquals("Authentication failed.", errMessage.getText());


        //testUtil.setCellData("Pass", 1,3, TestUtilProperties.TESTDATA_SHEET_PATH);

        driver.getCurrentUrl();
        if(driver.getCurrentUrl().equals("http://ebfs.bruteforcesolution.net/ebfs/index.php?controller=my-account")) {
            testUtil.setCellData("Pass", 4,3, TestUtilProperties.TESTDATA_SHEET_PATH);
        }else {
            testUtil.setCellData("Fail", 4,3, TestUtilProperties.TESTDATA_SHEET_PATH);
            Thread.sleep(2000);
        }



    }

    @AfterMethod
    public void close(){
        driver.quit();
    }


}
