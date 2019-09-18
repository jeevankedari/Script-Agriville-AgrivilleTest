package com.agriville.qa.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataUtil 
{
	XSSFWorkbook wb;
	XSSFSheet sheet;

// METHOD TO LOAD THE "TEST DATA" EXCEL FILE
	
	public ExcelDataUtil(String ExcelPath)
	{
		try 
		{
			File src = new File(ExcelPath);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);			
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}

// METHOD TO NAVIGATE TO RESPECTIVE WORKSHEET AND RETURN "STRING" DATA FROM REQUIRED ROW AND COLUMN 	
	
	public String getData(String WorkSheetName, int row, int column)
	{
		sheet = wb.getSheet(WorkSheetName);
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
// METHOD TO NAVIGATE TO RESPECTIVE WORKSHEET AND RETURN "BOOLEAN" DATA FROM REQUIRED ROW AND COLUMN 	
	
	public boolean getBooleanData(String WorkSheetName, int row, int column)
	{
		sheet = wb.getSheet(WorkSheetName);
		boolean data = sheet.getRow(row).getCell(column).getBooleanCellValue();
		return data;
	}	
	
// METHOD TO NAVIGATE TO RESPECTIVE WORKSHEET AND RETURN "INTEGER" DATA FROM REQUIRED ROW AND COLUMN 	
	
	public int getNumericData(String WorkSheetName, int row, int column)
	{
		sheet = wb.getSheet(WorkSheetName);
		int data = (int) sheet.getRow(row).getCell(column).getNumericCellValue();
		return data;
	}
	
	
// METHOD TO NAVIGATE TO RESPECTIVE WORKSHEET AND RETURN "XSSF" DATA FROM REQUIRED ROW AND COLUMN 	
	
	public XSSFCell getXSSFData(String WorkSheetName, int row, int column)
	{
		sheet = wb.getSheet(WorkSheetName);
		XSSFCell data = (XSSFCell) sheet.getRow(row).getCell(column);
		data.setCellType(CellType.NUMERIC);
		return data;
	}
			
// METHOD TO NAVIGATE TO RESPECTIVE WORKSHEET AND RETURN "DOUBLE" DATA FROM REQUIRED ROW AND COLUMN 	
	
	public double getDoubleData(String WorkSheetName, int row, int column)
	{
		sheet = wb.getSheet(WorkSheetName);
		double data = sheet.getRow(row).getCell(column).getNumericCellValue();
		return data;
	}
	
// METHOD TO CLOSE THE EXCEL INSTANCE 	
	
	public void closeExcel()
	{
		try 
		{
			wb.close();
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
}
