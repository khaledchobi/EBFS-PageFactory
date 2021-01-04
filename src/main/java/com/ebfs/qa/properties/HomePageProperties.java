package com.ebfs.qa.properties;

public interface HomePageProperties {

	public final String LNK_CONTACT_US_XPATH ="//div[@id='contact-link']//a[contains(text(),'Contact us')]";
	public final String IMG_LOGO_XPATH = "//img[@class='logo img-responsive']";
	public final String LNK_SIGN_IN_XPATH = ("//a[@class='login' and @title='Log in to your customer account']");

	public final String NEWS_LETTER_SUCCESS_XPATH = ("//p[contains(text(),'Newsletter : You have successfully subscribed to this newsletter.')]");

	public final String MENU_WOMEN_XPATH = "//a[@class='sf-with-ul' and @title='Women']";
	public final String MENU_DRESS_XPATH = "//*[@id=\"block_top_menu\"]/ul/li[2]/a";
	public final String MENU_TSHIRTS_XPATH = "//*[@id=\"block_top_menu\"]/ul/li[3]/a";
	public final String MENU_BRUTEFORCE_XPATH = "//a[@title='BruteForce']";

	public final String FEATURE_PRODUCTS_XPATH = "//img[@class='replace-2x img-responsive' and @itemprop='image']";
	public final String CHECKOUT_CART_XPATH = "//a[@title='View my shopping cart']";
	public final String CHECKOUT_CART_EMPTY_XPATH = "//span[@class='ajax_cart_no_product']";

	public final String LNK_QUICK_VIEW_XPATH = "//img[@class='replace-2x img-responsive']";
	public final String LNK_WISHLIST_XPATH = "//*[@id=\"wishlist_33\"]/td[1]/a";
	public final String TXT_ORDER_HISTORY_XPATH = "//h1[contains(text(),'Order history')]";
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
