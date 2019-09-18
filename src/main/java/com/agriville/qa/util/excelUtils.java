package com.agriville.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


import com.agriville.qa.base.TestBase;

public class excelUtils extends TestBase 
{
	public static String TESTDATA_SHEET_PATH ="E://Script Agriville//AgrivilleTest//src//main//java//com//agriville//qa//testdata//Agriville.xlsx";
	public static Workbook book; 
	public static Sheet sheet;
	public static Object[][] AgrivilleTestData(String sheetName) throws EncryptedDocumentException, InvalidFormatException
	{
					FileInputStream file=null;
					try
					{
						file=new FileInputStream(TESTDATA_SHEET_PATH);
					}
						catch(FileNotFoundException e)
						{
							e.printStackTrace();
						}
									try
									{
										book = WorkbookFactory.create(file);
									}
									catch(InvalidFormatException e)
									{
									e.printStackTrace();
									}
									catch(IOException e)
									{
											e.printStackTrace();
									}
									
								sheet=book.getSheet(sheetName);
								Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
								for(int Row=0;Row<sheet.getLastRowNum();Row++)
								{	
							     

									for(int Col=0;Col<sheet.getRow(0).getLastCellNum();Col++)
									{
										data[Row][Col]=sheet.getRow(Row+1).getCell(Col).toString();
										

				
									}
									
								}
								
		return data;
		
	}
}

