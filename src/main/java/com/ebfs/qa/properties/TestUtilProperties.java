package com.ebfs.qa.properties;

public interface TestUtilProperties {
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;

	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir") + "/src/main/java/com/ebfs/qa/testdata/EBFSTestData.xlsx";
	public static final String sheetName = "SignIn";
	public static final String sheetNewsletter = "NewsLetter";
	public static final String sheetRegistration = "Registration";

	public static final String sheetResults = "TestResults";

	//public static final String sheetName_Register = "Register";

	public String FRAME_MAIN_PANEL = "mainpanel";
}
