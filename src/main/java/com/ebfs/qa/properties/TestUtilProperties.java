package com.ebfs.qa.properties;

public interface TestUtilProperties {
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;

	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir") + "/src/main/java/com/ebfs/qa/testdata/EBFSTestData.xlsx";

	public String FRAME_MAIN_PANEL = "mainpanel";
}
