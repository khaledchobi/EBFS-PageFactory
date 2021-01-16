package com.ebfs.qa.properties;

public interface ProductCategoryPageProperties {

    public final String HEADER_LOGO_HOME_PAGE_XPATH = ("//div[@id='header_logo']");
    public final String SIGN_IN_XPATH = ("//a[@class='login' and @title='Log in to your customer account']");
    public final String SIGN_OUT_XPATH = ("//a[@title='Log me out']");

    public final String SIGN_IN_LINK = "http://ebfs.bruteforcesolution.net/ebfs/index.php?controller=authentication&back=my-account";
    public final String MY_ACCOUNT_LINK = ("http://ebfs.bruteforcesolution.net/ebfs/index.php?controller=my-account");

    public final String BTN_SIGN_IN_XPATH = ("//button[@id='SubmitLogin']");
    public final String SIGN_IN_EMAIL_XPATH = ("//input[@id='email']");
    public final String SIGN_IN_PASSWORD_XPATH = ("//input[@id='passwd']");

    public final String LNK_PRODUCT_CATEGORY_WOMEN_XPATH = ("//footer[@id='footer']/div/section[2]/div/div/ul/li[1]/a");
    public final String LNK_PRODUCT_CATEGORY_MAN_XPATH = ("//footer[@id='footer']/div/section[2]/div/div/ul/li[2]/a");


    public final String MENU_WOMEN_XPATH = ("//a[@class='sf-with-ul' and @title='Women']");
    public final String SUBCATEGORIES_FIELD_WOMEN_XPATH = ("//div[@id='subcategories']");
    public final String SUBCATEGORIES_HEADER_IMAGE_WOMEN_XPATH = ("//div[@class='content_scene_cat']");
    public final String SUBCATEGORIES_HEADER_BG_WOMEN_XPATH = ("//div[@class='content_scene_cat_bg']");

    public final String LNK_SUBCATEGORIES_TOPS_XPATH = ("//div[@class='subcategory-image']/a[@title='Tops']");
    public final String SUBCATEGORIES_HEADER_IMAGE_TOPS_XPATH = ("//div[@class='content_scene_cat']");
    public final String SUBCATEGORIES_HEADER_BG_TOPS_XPATH = ("//div[@class='content_scene_cat_bg']");
    public final String LNK_SUBCATEGORIES_DRESSES_XPATH = ("//div[@class='subcategory-image']/a[@title='Dresses']");
    public final String SUBCATEGORIES_HEADER_IMAGE_DRESSES_XPATH = ("//div[@class='content_scene_cat']");
    public final String SUBCATEGORIES_HEADER_BG_DRESSES_XPATH = ("//div[@class='content_scene_cat_bg']");
    public final String LNK_SUBCATEGORIES_CASUAL_DRESSES_XPATH = ("//div[@id='subcategories']//li[1]/div/a");
    public final String LNK_SUBCATEGORIES_EVENING_DRESSES_XPATH = ("//div[@id='subcategories']//li[2]/div/a");
    public final String LNK_SUBCATEGORIES_SUMMER_DRESSES_XPATH = ("//div[@id='subcategories']//li[3]/div/a");
    public final String FORM_SORT_BY_XPATH = ("//form[@id='productsSortForm']");
    public final String LNK_SORT_BY_XPATH = ("//div[@id='uniform-selectProductSort']");

    public final String SELECT_PRODUCT_SORT_XPATH = ("//select[@id='selectProductSort']");
    public final String SELECT_BY_VISIBLE_TEXT_PRICE_LOWEST_FIRST_XPATH = ("Price: Lowest first");
    public final String SELECT_BY_VISIBLE_TEXT_PRICE_HIGHEST_FIRST_XPATH = ("Price: Highest first");
    public final String SELECT_BY_VISIBLE_TEXT_PRODUCT_A_TO_Z_XPATH = ("Product Name: A to Z");
    public final String SELECT_BY_VISIBLE_TEXT_PRODUCT_Z_TO_A_XPATH = ("Product Name: Z to A");
    public final String SELECT_BY_VISIBLE_TEXT_IN_STOCK_XPATH = ("In stock");
    public final String SELECT_BY_VISIBLE_TEXT_REFERENCE_LOWEST_FIRST_XPATH = ("Reference: Lowest first");
    public final String SELECT_BY_VISIBLE_TEXT_REFERENCE_HIGHEST_FIRST_XPATH = ("Reference: Highest first");



    public final String MENU_DRESSES_XPATH = ("//div[@id='block_top_menu']/ul/li[2]/a");
    public final String TXT_DRESSES_XPATH = ("//span[@class='cat-name']");
    public final String MENU_TSHIRTS_XPATH = ("//div[@id='block_top_menu']/ul/li[3]/a");
    public final String TXT_TSHIRTS_XPATH = ("//span[@class='cat-name']");
    public final String CHECKBOX_CATEGORY_SUMMER_DRESSES_XPATH = ("//input[@id='layered_category_11']");
    public final String CHECKBOX_CATEGORY_EVENING_DRESSES_XPATH = ("//input[@id='layered_category_10']");
    public final String CHECKBOX_CATEGORY_CASUAL_DRESSES_XPATH = ("//input[@id='layered_category_9']");
    public final String CHECKBOX_SIZE_SMALL_XPATH = ("//input[@id='layered_id_attribute_group_1']");
    public final String CHECKBOX_SIZE_MEDIUM_XPATH = ("//input[@id='layered_id_attribute_group_2']");
    public final String CHECKBOX_SIZE_LARGE_XPATH = ("//input[@id='layered_id_attribute_group_3']");

    public final String CHECKBOX_COLOR_BEIGE_XPATH = ("//input[@id='layered_id_attribute_group_7']");
    public final String CHECKBOX_COLOR_WHITE_XPATH = ("//input[@id='layered_id_attribute_group_8']");
    public final String CHECKBOX_COLOR_BLACK_XPATH = ("//input[@id='layered_id_attribute_group_11']");
    public final String CHECKBOX_COLOR_ORANGE_XPATH = ("//input[@id='layered_id_attribute_group_13']");
    public final String CHECKBOX_COLOR_BLUE_XPATH = ("//input[@id='layered_id_attribute_group_14']");
    public final String CHECKBOX_COLOR_GREEN_XPATH = ("//input[@id='layered_id_attribute_group_15']");
    public final String CHECKBOX_COLOR_YELLOW_XPATH = ("//input[@id='layered_id_attribute_group_16']");
    public final String CHECKBOX_COLOR_PINK_XPATH = ("//input[@id='layered_id_attribute_group_24']");

    public final String CHECKBOX_COMPOSITION_COTTON_XPATH = ("//input[@id='layered_id_feature_5']");
    public final String CHECKBOX_COMPOSITION_POLYESTER_XPATH = ("//input[@id='layered_id_feature_1']");
    public final String CHECKBOX_COMPOSITION_VISCOSE_XPATH = ("//input[@id='layered_id_feature_3']");

    public final String CHECKBOX_STYLES_CASUAL_XPATH = ("//input[@id='layered_id_feature_11']");
    public final String CHECKBOX_STYLES_DRESSY_XPATH = ("//input[@id='layered_id_feature_16']");
    public final String CHECKBOX_STYLES_GIRLY_XPATH = ("//input[@id='layered_id_feature_13']");

    public final String CHECKBOX_PROPERTIES_COLORFUL_DRESS_XPATH = ("//input[@id='layered_id_feature_18']");
    public final String CHECKBOX_PROPERTIES_MAXI_DRESS_XPATH = ("//input[@id='layered_id_feature_21']");
    public final String CHECKBOX_PROPERTIES_MIDI_DRESS_XPATH = ("//input[@id='layered_id_feature_20']");
    public final String CHECKBOX_PROPERTIES_SHORT_DRESS_XPATH = ("//input[@id='layered_id_feature_19']");

    public final String CHECKBOX_AVAILABILITY_IN_STOCK_XPATH = ("//input[@id='layered_quantity_1']");
    public final String CHECKBOX_MANUFACTURER_FASHION_MANUFACTURER_XPATH = ("//input[@id='layered_manufacturer_1']");
    public final String CHECKBOX_CONDITION_NEW_XPATH = ("//input[@id='layered_condition_new']");

    public final String SLIDER_PRICE_RANGE_BEGINNING_XPATH = ("//div[@id='layered_price_slider']/a[1]");
    public final String SLIDER_PRICE_RANGE_ENDING_XPATH = ("//div[@id='layered_price_slider']/a[2]");

    public final String PRODUCT_VIEW_FIELD_XPATH = ("//ul[@class='display hidden-xs']");
    public final String PRODUCT_VIEW_BY_LIST_XPATH = ("//li[@id='list']");
    public final String LIST_VIEW_ADD_TO_WISHLIST_XPATH = ("//div[@id='center_column']/ul/li[1]//div[3]//div[3]/div[1]/a");
    public final String PRODUCT_VIEW_BY_GRID_XPATH = ("//li[@id='grid']");

    public final String NUMBER_OF_PRODUCTS_RIGHT_TOP_XPATH = ("//span[@class='heading-counter']");
    public final String PRODUCT_COUNT_TOP_LEFT_XPATH = ("//div[@class='top-pagination-content clearfix']/div[2]");
    public final String PRODUCT_COUNT_BOTTOM_LEFT_XPATH = ("//div[@class='bottom-pagination-content clearfix']/div[2]");

    public final String HOME_FEATURE_PRODUCT_LIST_01_XPATH = ("//ul[@id='homefeatured']/li[1]");
    public final String HOME_FEATURE_PRODUCT_LIST_01_ADD_TO_CART_XPATH = ("//ul[@id='homefeatured']/li[1]/div/div[2]/div[2]/a[1]");
    public final String HOME_FEATURE_PRODUCT_LIST_01_MORE_XPATH = ("//ul[@id='homefeatured']/li[1]/div/div[2]/div[2]/a[2]");
    public final String LNK_HOME_FEATURE_PRODUCT_LIST_01_QUICK_VIEW_XPATH = ("//ul[@id='homefeatured']/li[1]/div/div[1]/div/a[2]");

    public final String HOME_FEATURE_PRODUCT_TSHIRTS_XPATH = ("//ul[@id='homefeatured']/li[1]/div/div[2]/h5/a");
    public final String HOME_FEATURE_PRODUCT_IN_STOCK_ICON_XPATH = ("//p[@id='availability_statut']");


    public final String PRODUCT_CONTAINER_WOMEN_TSHIRTS_XPATH = ("//div[@id='center_column']/ul/li[1]/div");
    public final String PRODUCT_CONTAINER_WOMEN_TSHIRTS_ADD_TO_CART_XPATH = ("//div[@id='center_column']/ul/li[1]/div/div[2]/div[2]/a[1]/span");
    public final String PRODUCT_CONTAINER_WOMEN_CONTINUE_SHOPPING_XPATH = ("//div[@id='layer_cart']/div[1]/div[2]/div[4]/span");


    public final String PRODUCT_CONTAINER_WOMEN_PRINTED_DRESS_XPATH = ("//div[@id='center_column']/ul/li[3]/div");
    public final String PRODUCT_CONTAINER_WOMEN_PRINTED_DRESS_ADD_TO_CART_XPATH = ("//div[@id='center_column']/ul/li[3]/div/div[2]/div[2]/a[1]/span");

    public final String PRODUCT_CONTAINER_WOMEN_PRINTED_CHIFFON_DRESS_XPATH = ("//div[@id='center_column']/ul/li[7]/div");
    public final String PRODUCT_CONTAINER_WOMEN_PRINTED_CHIFFON_DRESS_ADD_TO_CART_XPATH = ("//div[@id='center_column']/ul/li[7]/div/div[2]/div[2]/a[1]/span");

    public final String PRODUCT_CONTAINER_WOMEN_PRINTED_SUMMER_DRESS_XPATH = ("//div[@id='center_column']/ul/li[6]/div");
    public final String PRODUCT_CONTAINER_WOMEN_PRINTED_SUMMER_DRESS_ADD_TO_CART_XPATH = ("//div[@id='center_column']/ul/li[6]/div/div[2]/div[2]/a[1]/span");
    public final String PRODUCT_CONTAINER_WOMEN_PROCEED_TO_CHECKOUT_XPATH = ("//div[@id='layer_cart']/div[1]/div[2]/div[4]/a");

    public final String SHOPPING_CART_SUMMARY_TITLE_XPATH = ("//h1[@id='cart_title']");
    public final String BTN_PROCEED_TO_CHECKOUT_XPATH = ("//div[@id='center_column']/p[2]/a[1]");
    public final String BTN_PROCEED_TO_CHECKOUT_ADDRESS_XPATH = ("//button[@name='processAddress']");
    public final String CHECKBOX_GIFT_WRAP_OPTION_XPATH = ("//input[@id='gift']");
    public final String TEXTAREA_GIFT_MESSAGE_BOX_XPATH = ("//textarea[@id='gift_message']");
    public final String CHECKBOX_TERMS_OF_SERVICE_XPATH = ("//input[@id='cgv']");
    public final String BTN_PROCEED_TO_CHECKOUT_SHIPPING_XPATH = ("//button[@name='processCarrier']");
    public final String YOUR_PAYMENT_METHOD_HEADING_XPATH = ("//div[@id='center_column']/h1");
    public final String FORM_PAY_BY_CREDIT_CARD_XPATH = ("//form[@id='simplify-payment-form']");
    public final String LNK_PAY_BY_BANK_WIRE_XPATH = ("//div[@id='HOOK_PAYMENT']/div[1]/div/p/a");
    public final String LNK_PAY_BY_CHECK_XPATH = ("//div[@id='HOOK_PAYMENT']/div[2]/div/p/a");

    public final String VIEW_MY_SHOPPING_CART_XPATH = ("//a[@title='View my shopping cart']");
    public final String BTN_CHECK_OUT_SHOPPING_CART_XPATH = ("//a[@id='button_order_cart']/span");

    public final String NUMBER_OF_ITEMS_ADDED_TO_CART_XPATH = ("//span[@class='heading-counter']");

    public final String DELETE_ITEM_SHOPPING_CART_TSHIRTS_XPATH = ("//tr[@id='product_1_1_0_0']/td[7]/div/a");
    public final String DELETE_ITEM_SHOPPING_CART_PRINTED_DRESS_AFTER_SIGN_IN_XPATH = ("//tr[@id='product_3_13_0_175']/td[7]/div/a");
    public final String INCREASE_ITEM_SHOPPING_CART_TSHIRTS_XPATH = ("//a[@id='cart_quantity_up_1_1_0_0']");
    public final String INCREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_XPATH = ("//a[@id='cart_quantity_up_3_13_0_0']");
    public final String DECREASE_ITEM_SHOPPING_CART_TSHIRTS_XPATH = ("//a[@id='cart_quantity_down_1_1_0_0']");
    public final String DECREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_XPATH = ("//a[@id='cart_quantity_down_3_13_0_0']");
    public final String DECREASE_ITEM_SHOPPING_CART_TSHIRTS_AFTER_SIGN_IN_XPATH = ("//a[@id='cart_quantity_down_1_1_0_175']");
    public final String DECREASE_ITEM_SHOPPING_CART_PRINTED_DRESS_AFTER_SIGN_IN_XPATH = ("//a[@id='cart_quantity_down_3_13_0_175']");
    public final String SHOPPING_CART_TOTAL_COST_XPATH = ("//span[@id='total_price']");
    public final String SHOPPING_CART_SHIPPING_COST_XPATH = ("//td[@id='total_shipping']");
    public final String LNK_SHOPPING_CART_CONTINUE_SHOPPING_XPATH = ("//a[@title='Continue shopping']");


    public final String REGISTRATION_EMAIL_XPATH = ("//input[@id='email_create']");
    public final String BTN_CREATE_AN_ACCOUNT_XPATH = ("//button[@id='SubmitCreate']");
    public final String BTN_RADIO_MALE_XPATH = ("//input[@id='id_gender1']");
    public final String REGISTRATION_FIRST_NAME_XPATH = ("//input[@id='customer_firstname']");
    public final String REGISTRATION_LAST_NAME_XPATH = ("//input[@id='customer_lastname']");
    public final String REGISTRATION_PASSWORD_XPATH = ("//input[@id='passwd']");
    public final String REGISTRATION_DOB_DAYS_XPATH = ("//select[@id='days']");
    public final String REGISTRATION_DOB_MONTHS_XPATH = ("//select[@id='months']");
    public final String REGISTRATION_DOB_YEARS_XPATH = ("//select[@id='years']");
    public final String REGISTRATION_CHECKBOX_NEWSLETTER_XPATH = ("//input[@id='newsletter']");
    public final String REGISTRATION_CHECKBOX_OPTION_XPATH = ("//input[@id='optin']");
    public final String BTN_REGISTER_ACCOUNT_XPATH = ("//button[@id='submitAccount']");


    public final String FOOTER_INFORMATION_TITLE_XPATH = ("//section[@id='block_various_links_footer']/h4");
    public final String FOOTER_INFORMATION_LNK_SPECIALS_XPATH = ("//a[@title='Specials']");
    public final String FOOTER_INFORMATION_LNK_NEW_PRODUCTS_XPATH = ("//a[@title='New products']");
    public final String FOOTER_INFORMATION_LNK_BEST_SELLERS_XPATH = ("//a[@title='Best sellers']");
    public final String FOOTER_INFORMATION_LNK_OUR_STORES_XPATH = ("//a[@title='Our stores']");
    public final String FOOTER_INFORMATION_LNK_CONTACT_US_XPATH = ("//a[@title='Contact us']");
    public final String FOOTER_INFORMATION_LNK_TERMS_AND_CONDITION_OF_USE_XPATH = ("//a[@title='Terms and conditions of use']");
    public final String FOOTER_INFORMATION_LNK_ABOUT_US_XPATH = ("//a[@title='About us']");
    public final String FOOTER_INFORMATION_LNK_SITEMAP_XPATH = ("//a[@title='Sitemap']");


    public final String PRODUCT_INFORMATION_TITLE_XPATH = ("//section[@id='informations_block_left_1']/p");
    public final String PRODUCT_INFORMATION_LNK_DELIVERY_XPATH = ("//section[@id='informations_block_left_1']/div/ul/li[1]/a");
    public final String PRODUCT_INFORMATION_LNK_LEGAL_NOTICE_XPATH = ("//section[@id='informations_block_left_1']/div/ul/li[2]/a");
    public final String PRODUCT_INFORMATION_LNK_TERMS_AND_CONDITIONS_OF_USE_XPATH = ("//section[@id='informations_block_left_1']/div/ul/li[3]/a");
    public final String PRODUCT_INFORMATION_LNK_ABOUT_US_XPATH = ("//section[@id='informations_block_left_1']/div/ul/li[4]/a");
    public final String PRODUCT_INFORMATION_LNK_SECURE_PAYMENT_XPATH = ("//section[@id='informations_block_left_1']/div/ul/li[5]/a");
    public final String PRODUCT_INFORMATION_LNK_OUR_STORES_XPATH = ("//section[@id='informations_block_left_1']/div/ul/li[6]/a");



    public final String TXT_BOX_SITEMAP_YOUR_LOCATION_XPATH = ("//input[@id='addressInput']");
    public final String BTN_SITEMAP_SEARCH_LOCATION_XPATH = ("//button[@name='search_locations']");




}
