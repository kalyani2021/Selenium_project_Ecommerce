package com.store.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfig {

	public static Object[][] readFromExcel(String filePath, String sheetName) throws IOException {
		File file = new File(filePath);
		FileInputStream inputStream = new FileInputStream(file);
		XSSFWorkbook book = new XSSFWorkbook(inputStream);
		Sheet sheet = book.getSheet(sheetName);
		
		int rowCount = sheet.getLastRowNum();
		Row headerRow = sheet.getRow(0);
		Object[][] data = new Object[rowCount][1];
		 DataFormatter formatter = new DataFormatter();
	  for (int i = 1; i <= rowCount; i++) {
			Hashtable<String, String> dataVal = new Hashtable<String, String> ();
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				 Cell cell1 = headerRow.getCell(j);
				
				 String strValue = formatter.formatCellValue(cell1);
				 String strValue2 = formatter.formatCellValue(row.getCell(j));
				 dataVal.put(strValue, strValue2);
				/* switch (cell1.getCellType()) 
	             {
	             
	             case STRING:
	            	 dataVal.put(String.valueOf(cell1.getStringCellValue()), String.valueOf(row.getCell(j).getStringCellValue()));
	                 break;
	                 
	             case NUMERIC:
	            	 dataVal.put(String.valueOf(cell1.getNumericCellValue()),String.valueOf(row.getCell(j).getNumericCellValue()));
	                 break;
	                 
	             case BOOLEAN:
	            	   dataVal.put(String.valueOf(cell1.getBooleanCellValue()),String.valueOf(row.getCell(j).getBooleanCellValue()));
	                 break;
	                 
	             case FORMULA:
	            	 dataVal.put(String.valueOf(cell1.getCellFormula()),String.valueOf(row.getCell(j).getCellFormula()));
	                 break;
	                 
	             default:
	                 System.out.println();}*/
	         
	             
			}
			data[i-1][0] = dataVal;
		
			/*
			 * for(int i=0;i<rowCount+1;i++) {
			 * 
			 * 
			 * Cell cell1 = sheet.getRow(i).getCell(0);
			 * 
			 * switch (cell1.getCellType()) {
			 * 
			 * case STRING: System.out.println(cell1.getRichStringCellValue().getString());
			 * break;
			 * 
			 * case NUMERIC: if (DateUtil.isCellDateFormatted(cell1)) {
			 * System.out.println(cell1.getDateCellValue()); } else {
			 * System.out.println(cell1.getNumericCellValue()); } break;
			 * 
			 * case BOOLEAN: System.out.println(cell1.getBooleanCellValue()); break;
			 * 
			 * case FORMULA: System.out.println(cell1.getCellFormula()); break;
			 * 
			 * default: System.out.println(); }
			 */
             
             //String data0= cell1.getStringCellValue();
             //System.out.println("Test Data From Excel : "+data0);
		
         }
	  book.close();
		inputStream.close();
		return data;
	
	}
}
