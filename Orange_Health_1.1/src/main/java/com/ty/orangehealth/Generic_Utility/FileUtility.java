package com.ty.orangehealth.Generic_Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	private Properties pobj;
	private Workbook wb;
	public FileUtility(){
		loadPropertiesClass();
		loadWorkbook();
	}
	
	public void loadPropertiesClass() {
		try (FileInputStream fis = new FileInputStream("./Test-Data/OH_CD.properties")) {
			pobj = new Properties();
			pobj.load(fis);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception occured while loading properties class");
			e.printStackTrace();
		}
	}
	
	public void loadWorkbook() {
		try(FileInputStream fis = new FileInputStream("./Test-Data/TestScriptData.xlsx")) {
			wb = WorkbookFactory.create(fis);
			
		} catch (IOException e) {
			System.out.println("Excpetion occured whie loading workbook");
			e.printStackTrace();
		}
	}
	
	
	public String fromProperties(String key) {
		String data = pobj.getProperty(key);
		if (data == null || data.isBlank()) {
			throw new IllegalArgumentException("invalid data in properties file : " + data);
		}
		return data;
	}
	
	public String fromExcel(String sheet, int rownum, int cellnum) {
		Sheet sh = wb.getSheet(sheet);
		String data = sh.getRow(rownum).getCell(cellnum).toString();
		if (data == null || data.isBlank()) {
			throw new IllegalArgumentException("invalid data in Excel file : " + data);
		}
		
		return data;
	}

	public String fromExcel(String path, String sheet, int rownum, int cellnum) {
		String data = "";
		try(FileInputStream fis = new FileInputStream(path)) {
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheet);
			data = sh.getRow(rownum).getCell(cellnum).toString();
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (data == null || data.isBlank()) {
			throw new IllegalArgumentException("invalid data in Excel file : " + data);
		}
		return data;
	}
	
	public void closeWorkbook() {
		try {
			if(wb == null) {
				throw new IllegalArgumentException("Workbook is null ");
			}
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
