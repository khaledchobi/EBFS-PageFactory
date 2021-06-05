package com.ebfs.qa.properties;

public interface TestBaseProperties {
	
	public final String CONFIG_PATH = System.getProperty("user.dir")+ "/src/main/java/com/ebfs/qa/config/config.properties"; 

	public final String CHROME_DRIVER = "webdriver.chrome.driver";
	public final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver";
	public final String FIREFOX_DRIVER = "webdriver.gecko.driver";
	public final String FIREFOX_DRIVER_PATH = System.getProperty("user.dir") + "/src/main/resources/drivers/geckodriver";
	
}
