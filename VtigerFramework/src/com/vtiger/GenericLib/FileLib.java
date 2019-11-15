package com.vtiger.GenericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * FileLib class used to read, write data from the Excel file, property file and write data into the Excel file, property file
 * @author Manoj
 * 
 */
public class FileLib {

	public static String path="../VtigerFramework/Files/searchOpportunityTSData.xlsx";
	
	public static String getPropertyvalue(String key) throws IOException {
		
		FileInputStream fio=new FileInputStream("../VtigerFramework/Files/commonData.properties");
		Properties pfile=new Properties();
		pfile.load(fio);
		String value = pfile.getProperty(key);
		return value;
	}

	public static String getExcelData(String shit,int rowno,int cellno) throws EncryptedDocumentException, FileNotFoundException, IOException {
		
		Workbook book=WorkbookFactory.create((new FileInputStream(path)));
		Sheet sheet = book.getSheet(shit);
		Row row=sheet.getRow(rowno);
		Cell cell = row.getCell(cellno);
		String value = cell.getStringCellValue();
		return value;
	}
	
}


/*String value = WorkbookFactory.create(new FileInputStream(path)).getSheet(shit).getRow(rowno).getCell(cellno).getStringCellValue();*/