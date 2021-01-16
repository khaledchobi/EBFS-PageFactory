package com.ebfs.qa.properties;

public interface HomePageProperties {

	public final String HEADER_LOGO_HOME_PAGE_XPATH = ("//div[@id='header_logo']");
	public final String LNK_SIGN_IN_XPATH = ("//a[@class='login' and @title='Log in to your customer account']");
	public final String LNK_CUSTOMER_ACCOUNT_XPATH = ("//a[@title='View my customer account']");
	public final String SIGN_OUT_XPATH = ("//a[@class='logout' and @title='Log me out']");

	public final String SIGN_IN_LINK = "http://ebfs.bruteforcesolution.net/ebfs/index.php?controller=authentication&back=my-account";
	public final String MY_ACCOUNT_LINK = ("http://ebfs.bruteforcesolution.net/ebfs/index.php?controller=my-account");

	public final String BTN_SIGN_IN_XPATH = ("//button[@id='SubmitLogin']");
	public final String SIGN_IN_EMAIL_XPATH = ("//input[@id='email']");
	public final String SIGN_IN_PASSWORD_XPATH = ("//input[@id='passwd']");

	public final String REGISTRATION_EMAIL_XPATH = ("//input[@id='email_create']");
	public final String BTN_CREATE_AN_ACCOUNT_XPATH = ("//button[@id='SubmitCreate']");
	public final String BTN_RADIO_MALE_XPATH = ("//input[@id='id_gender1']");
	public final String BTN_RADIO_FEMALE_XPATH = ("//input[@id='id_gender2']");
	public final String REGISTRATION_FIRST_NAME_XPATH = ("//input[@id='customer_firstname']");
	public final String REGISTRATION_LAST_NAME_XPATH = ("//input[@id='customer_lastname']");
	public final String REGISTRATION_PASSWORD_XPATH = ("//input[@id='passwd']");
	public final String REGISTRATION_DOB_DAYS_XPATH = ("//select[@id='days']");
	public final String REGISTRATION_DOB_MONTHS_XPATH = ("//select[@id='months']");
	public final String REGISTRATION_DOB_YEARS_XPATH = ("//select[@id='years']");
	public final String REGISTRATION_CHECKBOX_NEWSLETTER_XPATH = ("//input[@id='newsletter']");
	public final String REGISTRATION_CHECKBOX_OPTION_XPATH = ("//input[@id='optin']");
	public final String BTN_REGISTER_ACCOUNT_XPATH = ("//button[@id='submitAccount']");

	public final String BTN_LNK_ACCOUNT_MY_WISHLISTS_XPATH = "//a[@title='My wishlists']";
	public final String MY_WISHLISTS_ITEM_SAVE_XPATH = "//a[@title='Save']";
	public final String MY_WISHLISTS_ITEM_CLOSE_XPATH = "//a[@id='hideSendWishlist']";
	public final String BTN_LNK_ACCOUNT_ORDER_HISTORY_AND_DETAILS_XPATH = "//a[@title='Orders']";
	public final String LNK_MY_ACCOUNT_MY_ORDERS_XPATH = "//a[@title='My orders']";
	public final String TXT_ORDER_HISTORY_XPATH = "//h1[contains(text(),'Order history')]";
	public final String TXT_ORDER_HISTORY_CLONE_XPATH = "//h1[@class='page-heading bottom-indent']";

	public final String LNK_CONTACT_US_XPATH ="//div[@id='contact-link']//a[contains(text(),'Contact us')]";
	public final String IMG_LOGO_XPATH = "//img[@class='logo img-responsive']";
	public final String LNK_PRODUCT_CATEGORY_XPATH = ("//a[@title='Women' and @class='sf-with-ul']");

	public final String TXT_BOX_EMAIL_FOR_NEWSLETTER_XPATH = ("//input[@id='newsletter-input']");
	public final String BTN_SUBMIT_NEWSLETTER_XPATH = ("//button[@name='submitNewsletter']");
	public final String NEWS_LETTER_SUCCESS_XPATH = ("//p[contains(text(),'Newsletter : You have successfully subscribed to this newsletter.')]");

	public final String TXT_BOX_SEARCH_TOP_XPATH = "//input[@id='search_query_top']";
	public final String BTN_SUBMIT_SEARCH_TOP_XPATH = ("//button[@class='btn btn-default button-search']");

	public final String MENU_WOMEN_XPATH = "//a[@class='sf-with-ul' and @title='Women']";
	public final String MENU_DRESS_XPATH = "//*[@id=\"block_top_menu\"]/ul/li[2]/a";
	public final String MENU_TSHIRTS_XPATH = "//*[@id=\"block_top_menu\"]/ul/li[3]/a";
	public final String MENU_BRUTEFORCE_XPATH = "//a[@title='BruteForce']";

	public final String HOME_FEATURE_PRODUCT_TSHIRTS_XPATH = ("//ul[@id='homefeatured']/li[1]/div/div[2]/h5/a");

	public final String FEATURE_PRODUCTS_XPATH = "//img[@class='replace-2x img-responsive' and @itemprop='image']";
	public final String CHECKOUT_CART_XPATH = "//a[@title='View my shopping cart']";
	public final String CHECKOUT_CART_EMPTY_XPATH = "//span[@class='ajax_cart_no_product']";

	public final String LNK_QUICK_VIEW_XPATH = "//img[@class='replace-2x img-responsive']";
	public final String LNK_WISHLIST_XPATH = "//tr[@id='wishlist_34']/td[1]/a";
	public final String LNK_BEST_SELLER_XPATH = "//a[@class='blockbestsellers']";
	public final String LNK_POPULAR_XPATH = "//a[@class='homefeatured']";
	public final String LNK_SEARCH_BOX_XPATH = "//input[@id='search_query_top']";
	public final String LNK_PRINTED_DRESS_IMAGE_XPATH = "//img[@class='replace-2x img-responsive' and @src='http://ebfs.bruteforcesolution.net/ebfs/img/p/1/0/10-home_default.jpg']";
	public final String LNK_FOLLOW_FACEBOOK_XPATH = "//li[@class='facebook']";
	public final String URL_FACEBOOK_PAGE = "https://www.facebook.com/bruteforcesolutionsinc";
	public final String URL_FACEBOOK_PAGE_XPATH = "//link[@href='https://m.facebook.com/bruteforcesolutionsinc/' and @media='handheld']";
	public final String BTN_CREATE_ACCOUNT_XPATH = "//button[@id='SubmitCreate']";
	public final String BTN_REGISTER_SUBMIT_XPATH = "//button[@id='submitAccount']";


	public final String BTN_MY_WISHLIST_XPATH = "//a[@id='wishlist_button']";
	public final String BTN_MY_WISHLIST_CLOSE_XPATH = "//*[@id=\"product\"]/div[2]/div/div/a";
	public final String PRODUCT_IMAGE_TSHIRTS_01_XPATH = "//img[@class='img-responsive' and @id='thumb_1']";
	public final String PRODUCT_IMAGE_TSHIRTS_02_XPATH = "//img[@class='img-responsive' and @id='thumb_2']";
	public final String PRODUCT_IMAGE_TSHIRTS_03_XPATH = "//img[@class='img-responsive' and @id='thumb_3']";
	public final String PRODUCT_IMAGE_TSHIRTS_04_XPATH = "//img[@class='img-responsive' and @id='thumb_4']";


	public final String BTN_FANCY_POPUP_XPATH = "//a[@class='fancybox-item fancybox-close']";


	public final String SECTION_DATA_SHEET_XPATH = "//section[@class='page-product-box'][1]";



}
