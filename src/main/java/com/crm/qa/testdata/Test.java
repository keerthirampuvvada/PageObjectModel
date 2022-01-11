package com.crm.qa.testdata;


import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class Test
{
public static void main(String[] args) throws Exception {

	
	System.setProperty("webdriver.chrome.driver", "\\EclipseWorkSpace\\Seleniumdownloads\\chrome\\chromedriver_win32\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	//ExcelWrite exe = new ExcelWrite();
//	exe.writeExcel();
	
	// FileInputStream fis = new FileInputStream("\\ExcelWrite\\POMContacts.xlsx");
	
	//C:\EclipseWorkSpace\FreeCrmTest\src\main\java\com\crm\qa\testdata\POMContacts.xlsx
	 FileInputStream fis = new FileInputStream("\\ExcelWrite\\output2.xlsx");

 // connection to the excel file
// XSSFWorkbook wb = new XSSFWorkbook();
 XSSFWorkbook  wb = new XSSFWorkbook(fis);

 XSSFSheet sh = wb.getSheet("Keerthi Sheet");
 
 // XSSFSheet sh = wb.getSheet("Contacts");
 XSSFRow row = null;
// System.out.println("2");
 int rowCount = sh.getPhysicalNumberOfRows();
  row = sh.getRow(0);
 
	int colCount = row.getLastCellNum();
	 System.out.println(""+rowCount);
	System.out.println("Column Count :- " + colCount);
 
  
 
 

		 for (int i = 0; i < rowCount; i++) 
		 {
				 
				    for (int j=0;j<colCount;j++) {
				  
				 	  String searchvalue = sh.getRow(i).getCell(j).getStringCellValue();
					  //String dropdown = sh.getRow(i).getCell(j).getStringCellValue();
					  //String execute = sh.getRow(i).getCell(j).getStringCellValue();
				
					  System.out.print(" "+searchvalue);
					 // System.out.println(dropdown);
					//  System.out.println(execute);
					
				    }
				
				  System.out.println();
			   
		 }
  driver.close();
  wb.close();
   

}

}

