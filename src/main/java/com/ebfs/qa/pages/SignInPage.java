package com.ebfs.qa.pages;

import com.ebfs.qa.base.TestBase;
import com.ebfs.qa.properties.ContactsPageProperties;
import com.ebfs.qa.properties.HomePageProperties;
import com.ebfs.qa.properties.SignInPageProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignInPage extends TestBase {

    @FindBy(xpath = SignInPageProperties.SIGN_IN_LINK)
    WebElement signInLink;


    @FindBy(id="id_contact")
    WebElement subjectHeading;

    @FindBy(id="email")
    WebElement email;

    @FindBy(name="id_order")
    WebElement orderReference;

    @FindBy(id = "fileUpload")
    WebElement textFileUpload;

    //TO-DO: Add all the Missing WebElement in the Contact Us page


    // Initializing the Page Objects:
    public SignInPage() {
        PageFactory.initElements(driver, this);
    }


    public boolean verifySignInLink(){
        return signInLink.isDisplayed();
    }

    /*public SignInPage clickOnSignInLink(){
        signInLink.click();
        return new SignInPage();
    }*/


    public void selectSubjectHeadingByVisibleText(String text){
        Select select = new Select(subjectHeading);
        select.selectByVisibleText(text);
    }

    //TO-DO: Add all the Missing Action in the Contact Us page


}
