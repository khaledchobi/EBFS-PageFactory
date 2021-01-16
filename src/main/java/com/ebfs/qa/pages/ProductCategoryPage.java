package com.ebfs.qa.pages;

import com.ebfs.qa.base.TestBase;
import com.ebfs.qa.properties.ProductCategoryPageProperties;
import com.ebfs.qa.properties.SignInPageProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductCategoryPage extends TestBase {
    @FindBy(xpath = SignInPageProperties.SIGN_IN_LINK)
    WebElement signInLink;

    @FindBy(xpath = ProductCategoryPageProperties.LNK_PRODUCT_CATEGORY_WOMEN_XPATH)
    WebElement productCategoryLink;

    @FindBy(id="id_contact")
    WebElement subjectHeading;

    @FindBy(id="email")
    WebElement email;

    @FindBy(name="id_order")
    WebElement orderReference;

    @FindBy(id = "fileUpload")
    WebElement textFileUpload;

    @FindBy(xpath = ProductCategoryPageProperties.TXT_DRESSES_XPATH)
    WebElement dressText;

    @FindBy(xpath = ProductCategoryPageProperties.TXT_TSHIRTS_XPATH)
    WebElement tShirtsText;

    @FindBy(xpath = ProductCategoryPageProperties.SUBCATEGORIES_FIELD_WOMEN_XPATH)
    WebElement subcategoryFieldWomen;

    @FindBy(xpath = ProductCategoryPageProperties.LNK_SUBCATEGORIES_TOPS_XPATH)
    WebElement subcategoryLinkTops;

    @FindBy(xpath = ProductCategoryPageProperties.LNK_SUBCATEGORIES_DRESSES_XPATH)
    WebElement subcategoryLinkDresses;

    @FindBy(xpath = ProductCategoryPageProperties.LNK_SUBCATEGORIES_CASUAL_DRESSES_XPATH)
    WebElement subcategoryLinkCasualDresses;

    @FindBy(xpath = ProductCategoryPageProperties.LNK_SUBCATEGORIES_EVENING_DRESSES_XPATH)
    WebElement subcategoryLinkEveningDresses;

    @FindBy(xpath = ProductCategoryPageProperties.LNK_SUBCATEGORIES_SUMMER_DRESSES_XPATH)
    WebElement subcategoryLinkSummerDresses;

    @FindBy(xpath = ProductCategoryPageProperties.FORM_SORT_BY_XPATH)
    WebElement sortByForm;

    @FindBy(xpath = ProductCategoryPageProperties.LNK_SORT_BY_XPATH)
    WebElement sortByLink;

    @FindBy(xpath = ProductCategoryPageProperties.SELECT_PRODUCT_SORT_XPATH)
    WebElement selectProductSort;

    @FindBy(xpath = ProductCategoryPageProperties.PRODUCT_VIEW_FIELD_XPATH)
    WebElement productViewField;

    @FindBy(xpath = ProductCategoryPageProperties.LIST_VIEW_ADD_TO_WISHLIST_XPATH)
    WebElement listViewAddtoWishlist;

    @FindBy(xpath = ProductCategoryPageProperties.NUMBER_OF_PRODUCTS_RIGHT_TOP_XPATH)
    WebElement numberOfProductsRightTop;

    @FindBy(xpath = ProductCategoryPageProperties.PRODUCT_COUNT_TOP_LEFT_XPATH)
    WebElement productCountTopLeft;

    @FindBy(xpath = ProductCategoryPageProperties.PRODUCT_COUNT_BOTTOM_LEFT_XPATH)
    WebElement productCountBottomLeft;

    @FindBy(xpath = ProductCategoryPageProperties.CHECKBOX_CONDITION_NEW_XPATH)
    WebElement checkBoxConditionNew;

    @FindBy(xpath = ProductCategoryPageProperties.CHECKBOX_CATEGORY_SUMMER_DRESSES_XPATH)
    WebElement checkBoxSummerDress;

    @FindBy(xpath = ProductCategoryPageProperties.SLIDER_PRICE_RANGE_BEGINNING_XPATH)
    WebElement priceRangeSlider;

    @FindBy(xpath = ProductCategoryPageProperties.HOME_FEATURE_PRODUCT_LIST_01_ADD_TO_CART_XPATH)
    WebElement featureProductList_01_AddToCart;

    @FindBy(xpath = ProductCategoryPageProperties.HOME_FEATURE_PRODUCT_LIST_01_MORE_XPATH)
    WebElement featureProductList_01_More;

    @FindBy(xpath = ProductCategoryPageProperties.LNK_HOME_FEATURE_PRODUCT_LIST_01_QUICK_VIEW_XPATH)
    WebElement featureProductList_01_QuickView;

    @FindBy(xpath = ProductCategoryPageProperties.SHOPPING_CART_SUMMARY_TITLE_XPATH)
    WebElement shoppingCartSummaryTitle;

    @FindBy(xpath = ProductCategoryPageProperties.BTN_SIGN_IN_XPATH)
    WebElement signInButton;

    @FindBy(xpath = ProductCategoryPageProperties.PRODUCT_CONTAINER_WOMEN_PROCEED_TO_CHECKOUT_XPATH)
    WebElement proceedToCheckoutProductOverlay;

    @FindBy(xpath = ProductCategoryPageProperties.BTN_CHECK_OUT_SHOPPING_CART_XPATH)
    WebElement checkOutButton;

    @FindBy(xpath = ProductCategoryPageProperties.NUMBER_OF_ITEMS_ADDED_TO_CART_XPATH)
    WebElement numberOfItemsAddedToCart;

    @FindBy(xpath = ProductCategoryPageProperties.SHOPPING_CART_TOTAL_COST_XPATH)
    WebElement shoppingCartTotalCost;

    @FindBy(xpath = ProductCategoryPageProperties.SHOPPING_CART_SHIPPING_COST_XPATH)
    WebElement shoppingCartShippingCost;

    @FindBy(xpath = ProductCategoryPageProperties.LNK_SHOPPING_CART_CONTINUE_SHOPPING_XPATH)
    WebElement shoppingCartContinueShoppingLink;

    @FindBy(xpath = ProductCategoryPageProperties.FORM_PAY_BY_CREDIT_CARD_XPATH)
    WebElement payByCreditCardMethodLink;

    @FindBy(xpath = ProductCategoryPageProperties.LNK_PAY_BY_BANK_WIRE_XPATH)
    WebElement payByBankWireMethodLink;

    @FindBy(xpath = ProductCategoryPageProperties.LNK_PAY_BY_CHECK_XPATH)
    WebElement payByCheckMethodLink;

    @FindBy(xpath = ProductCategoryPageProperties.CHECKBOX_GIFT_WRAP_OPTION_XPATH)
    WebElement checkBoxGiftWrapOption;

    @FindBy(xpath = ProductCategoryPageProperties.PRODUCT_INFORMATION_TITLE_XPATH)
    WebElement productInformationBlockTitle;

    @FindBy(xpath = ProductCategoryPageProperties.PRODUCT_INFORMATION_LNK_DELIVERY_XPATH)
    WebElement productInformationDeliveryLink;

    @FindBy(xpath = ProductCategoryPageProperties.PRODUCT_INFORMATION_LNK_LEGAL_NOTICE_XPATH)
    WebElement productInformationLegalNoticeLink;

    @FindBy(xpath = ProductCategoryPageProperties.PRODUCT_INFORMATION_LNK_TERMS_AND_CONDITIONS_OF_USE_XPATH)
    WebElement productInformationTermsAndConditionLink;

    @FindBy(xpath = ProductCategoryPageProperties.PRODUCT_INFORMATION_LNK_ABOUT_US_XPATH)
    WebElement productInformationAboutUsLink;

    @FindBy(xpath = ProductCategoryPageProperties.PRODUCT_INFORMATION_LNK_SECURE_PAYMENT_XPATH)
    WebElement productInformationSecurePaymentLink;

    @FindBy(xpath = ProductCategoryPageProperties.PRODUCT_INFORMATION_LNK_OUR_STORES_XPATH)
    WebElement productInformationOurStoresLink;

    @FindBy(xpath = ProductCategoryPageProperties.YOUR_PAYMENT_METHOD_HEADING_XPATH)
    WebElement yourPaymentMethodHeading;

    @FindBy(xpath = ProductCategoryPageProperties.HOME_FEATURE_PRODUCT_IN_STOCK_ICON_XPATH)
    WebElement featureProductInStockIcon;

    //TO-DO: Add all the Missing WebElement in the Contact Us page


    // Initializing the Page Objects:
    public ProductCategoryPage() {
        PageFactory.initElements(driver, this);
    }


    public boolean verifySignInLink(){
        return signInLink.isDisplayed();
    }

    public ProductCategoryPage clickOnProductCategoryLink(){
        productCategoryLink.click();
        return new ProductCategoryPage();
    }


    public void selectSubjectHeadingByVisibleText(String text){
        Select select = new Select(subjectHeading);
        select.selectByVisibleText(text);
    }

    public boolean verifyDressTextDisplayed(){
        return dressText.isDisplayed();
    }

    public boolean verifyTShirtsTextDisplayed(){
        return tShirtsText.isDisplayed();
    }

    public boolean verifySubcategoryFieldWomenDisplayed(){
        return subcategoryFieldWomen.isDisplayed();
    }

    public boolean verifySortByFormDisplayed(){
        return sortByForm.isDisplayed();
    }

    public boolean verifySortByLinkDisplayed(){
        return sortByLink.isDisplayed();
    }

    public boolean verifySelectProductSortDisplayed(){
        return selectProductSort.isDisplayed();
    }



    public boolean verifySubcategoryLinkTopsDisplayed(){
        return subcategoryLinkTops.isDisplayed();
    }

    public boolean verifySubcategoryLinkDressesDisplayed(){
        return subcategoryLinkDresses.isDisplayed();
    }

    public boolean verifySubcategoryLinkCasualDressesDisplayed(){
        return subcategoryLinkCasualDresses.isDisplayed();
    }

    public boolean verifySubcategoryLinkEveningDressesDisplayed(){
        return subcategoryLinkEveningDresses.isDisplayed();
    }

    public boolean verifySubcategoryLinkSummerDressesDisplayed(){
        return subcategoryLinkSummerDresses.isDisplayed();
    }

    public boolean verifyProductViewFieldDisplayed(){
        return productViewField.isDisplayed();
    }

    public boolean verifyListViewAddtoWishlistDisplayed(){
        return listViewAddtoWishlist.isDisplayed();
    }

    public boolean verifyNumberOfProductsRightTopDisplayed(){
        return numberOfProductsRightTop.isDisplayed();
    }

    public boolean verifyProductCountTopLeftDisplayed(){
        return productCountTopLeft.isDisplayed();
    }

    public boolean verifyProductCountBottomLeftDisplayed(){
        return productCountBottomLeft.isDisplayed();
    }

    public boolean verifyCheckBoxConditionNewEnabled(){
        return checkBoxConditionNew.isEnabled();
    }

    public boolean verifyCheckBoxSummerDressEnabled(){
        return checkBoxSummerDress.isEnabled();
    }

    public boolean verifyCheckBoxSummerDressSelected(){
        return checkBoxSummerDress.isSelected();
    }

    public boolean verifyPriceRangeSliderDisplayed(){
        return priceRangeSlider.isDisplayed();
    }

    public boolean verifyFeatureProductList_01_AddToCartDisplayed(){
        return featureProductList_01_AddToCart.isDisplayed();
    }

    public boolean verifyFeatureProductList_01_MoreDisplayed(){
        return featureProductList_01_More.isDisplayed();
    }

    public boolean verifyFeatureProductList_01_QuickViewDisplayed(){
        return featureProductList_01_QuickView.isDisplayed();
    }

    public boolean verifyShoppingCartSummaryTitleDisplayed(){
        return shoppingCartSummaryTitle.isDisplayed();
    }

    public boolean verifySignInButtonDisplayed(){
        return signInButton.isDisplayed();
    }

    public String verifyMyAccountTitle(){
        return driver.getTitle();
    }

    public boolean verifyProceedToCheckoutProductOverlayEnabled(){
        return proceedToCheckoutProductOverlay.isEnabled();
    }

    public boolean verifyCheckOutButtonEnabled(){
        return checkOutButton.isEnabled();
    }

    public boolean verifyNumberOfItemsAddedToCartDisplayed(){
        return numberOfItemsAddedToCart.isEnabled();
    }

    public boolean verifyShoppingCartTotalCostDisplayed(){
        return shoppingCartTotalCost.isEnabled();
    }

    public boolean verifyShoppingCartShippingCostDisplayed(){
        return shoppingCartShippingCost.isEnabled();
    }

    public boolean verifyShoppingCartContinueShoppingLinkDisplayed(){
        return shoppingCartContinueShoppingLink.isDisplayed();
    }

    public boolean verifyPayByCreditCardMethodLinkDisplayed(){
        return payByCreditCardMethodLink.isDisplayed();
    }

    public boolean verifyPayByCreditCardMethodLinkEnabled(){
        return payByCreditCardMethodLink.isEnabled();
    }


    public boolean verifyPayByBankWireMethodLinkDisplayed(){
        return payByBankWireMethodLink.isDisplayed();
    }

    public boolean verifyPayByBankWireMethodLinkEnabled(){
        return payByBankWireMethodLink.isEnabled();
    }


    public boolean verifyPayByCheckMethodLinkDisplayed(){
        return payByCheckMethodLink.isDisplayed();
    }

    public boolean verifyPayByCheckMethodLinkEnabled(){
        return payByCheckMethodLink.isEnabled();
    }



    public boolean verifyCheckBoxGiftWrapOptionEnabled(){
        return checkBoxGiftWrapOption.isEnabled();
    }

    public boolean verifyProductInformationBlockTitleDisplayed(){
        return productInformationBlockTitle.isDisplayed();
    }

    public boolean verifyProductInformationDeliveryLinkEnabled(){
        return productInformationDeliveryLink.isEnabled();
    }

    public boolean verifyProductInformationLegalNoticeLinkEnabled(){
        return productInformationLegalNoticeLink.isEnabled();
    }

    public boolean verifyProductInformationTermsAndConditionLinkEnabled(){
        return productInformationTermsAndConditionLink.isEnabled();
    }

    public boolean verifyProductInformationAboutUsLinkEnabled(){
        return productInformationAboutUsLink.isEnabled();
    }

    public boolean verifyProductInformationSecurePaymentLinkEnabled(){
        return productInformationSecurePaymentLink.isEnabled();
    }

    public boolean verifyProductInformationOurStoresLinkEnabled(){
        return productInformationOurStoresLink.isEnabled();
    }


    public boolean verifyYourPaymentMethodHeadingDisplayed(){
        return yourPaymentMethodHeading.isDisplayed();
    }



    public boolean verifyFeatureProductInStockIconDisplayed(){
        return featureProductInStockIcon.isDisplayed();
    }



    //TO-DO: Add all the Missing Action in the Contact Us page

}
