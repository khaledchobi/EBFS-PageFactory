package com.ebfs.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebfs.qa.base.TestBase;
import com.ebfs.qa.properties.HomePageProperties;
import org.testng.Assert;

public class HomePage extends TestBase {

	@FindBy(xpath = HomePageProperties.IMG_LOGO_XPATH)
	@CacheLookup
	WebElement logo;

	@FindBy(xpath = HomePageProperties.LNK_CONTACT_US_XPATH)
	WebElement contactsLink;

	@FindBy(xpath = HomePageProperties.LNK_SIGN_IN_XPATH)
	WebElement signInLink;

	@FindBy(xpath = HomePageProperties.LNK_PRODUCT_CATEGORY_XPATH)
	WebElement productCategoryLink;

	@FindBy(xpath = HomePageProperties.NEWS_LETTER_SUCCESS_XPATH)
	WebElement newsLetterSuccess;

	@FindBy(xpath = HomePageProperties.MENU_WOMEN_XPATH)
	WebElement menuWomen;

	@FindBy(xpath = HomePageProperties.MENU_DRESS_XPATH)
	WebElement menuDress;

	@FindBy(xpath = HomePageProperties.MENU_TSHIRTS_XPATH)
	WebElement menuTshirts;

	@FindBy(xpath = HomePageProperties.MENU_BRUTEFORCE_XPATH)
	WebElement menuBruteForce;

	@FindBy(xpath = HomePageProperties.FEATURE_PRODUCTS_XPATH)
	WebElement featureProducts;

	@FindBy(xpath = HomePageProperties.CHECKOUT_CART_XPATH)
	WebElement checkoutCart;

	@FindBy(xpath = HomePageProperties.CHECKOUT_CART_EMPTY_XPATH)
	WebElement checkoutCartEmpty;

	@FindBy(xpath = HomePageProperties.LNK_QUICK_VIEW_XPATH)
	WebElement quickViewLink;

	@FindBy(xpath = HomePageProperties.LNK_WISHLIST_XPATH)
	WebElement wishListLink;

	@FindBy(xpath = HomePageProperties.TXT_ORDER_HISTORY_XPATH)
	WebElement orderHistoryText;

	@FindBy(xpath = HomePageProperties.LNK_BEST_SELLER_XPATH)
	WebElement bestSellerLink;

	@FindBy(xpath = HomePageProperties.LNK_POPULAR_XPATH)
	WebElement popularLink;

	@FindBy(xpath = HomePageProperties.LNK_SEARCH_BOX_XPATH)
	WebElement searchBox;

	@FindBy(xpath = HomePageProperties.LNK_PRINTED_DRESS_IMAGE_XPATH)
	WebElement printedDressImage;

	@FindBy(xpath = HomePageProperties.LNK_FOLLOW_FACEBOOK_XPATH)
	WebElement followFacebookLink;

	@FindBy(xpath = HomePageProperties.URL_FACEBOOK_PAGE_XPATH)
	WebElement facebookPageUrl;

	@FindBy(xpath = HomePageProperties.BTN_CREATE_ACCOUNT_XPATH)
	WebElement btnCreateAccount;

	@FindBy(xpath = HomePageProperties.BTN_REGISTER_SUBMIT_XPATH)
	WebElement btnRegisterSubmit;

	@FindBy(xpath = HomePageProperties.BTN_MY_WISHLIST_XPATH)
	WebElement myWishList;

	@FindBy(xpath = HomePageProperties.SECTION_DATA_SHEET_XPATH)
	WebElement sectionDataSheet;
	

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public boolean verifyLogoDisplayed(){
		return logo.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink(){
		contactsLink.click();
		return new ContactsPage();
	}

	public SignInPage clickOnSignInLink(){
		signInLink.click();
		return new SignInPage();
	}

	public ProductCategoryPage clickOnProductCategoryLink(){
		productCategoryLink.click();
		return new ProductCategoryPage();
	}

	public boolean verifyNewsLetterSuccessDisplayed(){
		return newsLetterSuccess.isDisplayed();
	}

	public boolean verifyMenuWomenDisplayed(){
		return menuWomen.isDisplayed();
	}

	public boolean verifyMenuDressDisplayed(){
		return menuDress.isDisplayed();
	}

	public boolean verifyMenuTshirtsDisplayed(){
		return menuTshirts.isDisplayed();
	}

	public boolean verifyMenuBruteForceDisplayed(){
		return menuBruteForce.isDisplayed();
	}

	public boolean verifyFeatureProductsDisplayed(){
		return featureProducts.isDisplayed();
	}

	public boolean verifyCheckoutCartDisplayed(){
		return checkoutCart.isDisplayed();
	}

	public boolean verifyCheckoutCartEmptyDisplayed(){
		return checkoutCartEmpty.isDisplayed();
	}

	public boolean verifyQuickViewLinkDisplayed(){
		return quickViewLink.isDisplayed();
	}

	public boolean verifyWishListLinkDisplayed(){
		return wishListLink.isDisplayed();
	}

	public boolean verifyOrderHistoryDisplayed(){
		return orderHistoryText.isDisplayed();
	}

	public boolean verifyBestSellerLinkDisplayed(){
		return bestSellerLink.isDisplayed();
	}

	public boolean verifyPopularLinkDisplayed(){
		return popularLink.isDisplayed();
	}

	public boolean verifySearchBoxDisplayed(){
		return searchBox.isDisplayed();
	}

	public boolean verifyPrintedDressImageDisplayed(){
		return printedDressImage.isDisplayed();
	}

	public boolean verifyFollowFacebookLinkDisplayed(){
		return followFacebookLink.isDisplayed();
	}

	public boolean verifyCreateAccountButtonDisplayed(){
		return btnCreateAccount.isDisplayed();
	}

	public boolean verifyRegisterSubmitButtonDisplayed(){
		return btnRegisterSubmit.isDisplayed();
	}

	public boolean verifyFacebookPageUrlDisplayed(){
		return facebookPageUrl.isDisplayed();
	}

	public boolean verifySectionDataSheetDisplayed(){
		return sectionDataSheet.isDisplayed();
	}

	public boolean verifyMyWishListDisplayed(){
		return myWishList.isDisplayed();
	}


	
		
	
	
	
	
	

}
