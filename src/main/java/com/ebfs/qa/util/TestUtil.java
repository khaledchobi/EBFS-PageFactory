package com.ebfs.qa.util;

import java.io.*;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.ebfs.qa.base.TestBase;
import com.ebfs.qa.properties.TestUtilProperties;

public class TestUtil extends TestBase {

	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;

	// From ExcelUtils below 4
	public XSSFWorkbook excelBook;
	public XSSFSheet excelSheet;
	public XSSFRow row;
	public XSSFCell cell;

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TestUtilProperties.TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}


	// From ExcelUtils below 3
	public void setExcelFile(String path, String sheetName)throws Exception{
		try{
			//open the excel
			FileInputStream excelFile = new FileInputStream(path);  // pass the path
			excelBook = new XSSFWorkbook(excelFile); // pass the file
			excelSheet = excelBook.getSheet(sheetName);  // pass the sheet

		}catch(Exception e){
			throw e;
		}
	}

	public String getCellData(int rowNum, int colNum)throws Exception{

		try{
			cell = excelSheet.getRow(rowNum).getCell(colNum);
			String cellData = cell.getStringCellValue();

			return cellData;

		}catch(Exception e){
			return "";
		}

	}

	public void setCellData(String result, int rowNum, int colNum, String path)throws Exception{
		try{
			row = excelSheet.getRow(rowNum);
			cell = row.getCell(colNum, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);

			if(cell ==null){
				cell = row.createCell(colNum);
				cell.setCellValue(result);
			}else{
				cell.setCellValue(result);
			}


			FileOutputStream fileOut = new FileOutputStream(path);
			excelBook.write(fileOut);

			fileOut.flush();

			fileOut.close();


		}catch(Exception e){
			throw e;
		}
	}

	
}
