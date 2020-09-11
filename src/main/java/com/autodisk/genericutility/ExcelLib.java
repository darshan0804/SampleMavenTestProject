package com.autodisk.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Darshan
 *
 */
public class ExcelLib {
	String filepath = "./resource/TestData.xlsx";
	/**
	 * used to read the data from Exel sheet based on parameter
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @return
	 * @throws Throwable
	 */

	public String getExcelData(String sheetName , int rowNum , int colNum) throws Throwable
	{
		FileInputStream fis = new FileInputStream(filepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		return row.getCell(colNum).getStringCellValue();
		
		
		
	}
	
	
	/**
	 * used to read the databack to excel based on parameter
	 * @param sheetName
	 * @param rowNum
	 * @param colNum
	 * @param data
	 * @throws Throwable
	 */
	public void setExcelData(String sheetName , int rowNum , int colNum , String data) throws Throwable
	{
		FileInputStream fis = new FileInputStream(filepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.createRow(rowNum);
		Cell cel = row.createCell(colNum);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(filepath);
		wb.write(fos);
		wb.close();
		
	}
		
	}
	

	
	

