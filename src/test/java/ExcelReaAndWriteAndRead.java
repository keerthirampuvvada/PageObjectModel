import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReaAndWriteAndRead {

	public static void main(String[] args) throws Exception 
	{
		write();
	}

public static void write()
	{

		try
		   {
		       FileInputStream myxls = new FileInputStream("C:\\ExcelWrite\\output2.xlsx");
		       XSSFWorkbook wb = new XSSFWorkbook(myxls);
		      // XSSFRow row = null;
		  	//   File file = new File("C:\\ExcelWrite\\output2.xlsx");
		  	   XSSFSheet sh = wb.getSheet("Keerthi Sheet");
		       int lastRow=sh.getLastRowNum();
		       System.out.println(lastRow);
		       XSSFRow row = sh.createRow(++lastRow);
		       int rowCount = sh.getPhysicalNumberOfRows();
		 	  row = sh.getRow(0);
		 	 
		 		int colCount = row.getLastCellNum();
		       
		 		  System.out.println("row count"+rowCount);
		 		 System.out.println("column  count"+colCount);
		       
		       for (int i = 0; i < rowCount; i++) 
				 {
						 
						    for (int j=0;j<colCount;j++) {
						  
						 	  String searchvalue = sh.getRow(i).getCell(j).getStringCellValue();
							  //String dropdown = sh.getRow(i).getCell(j).getStringCellValue();
							  //String execute = sh.getRow(i).getCell(j).getStringCellValue();
						
							  System.out.println(searchvalue);
							 // System.out.println(dropdown);
							//  System.out.println(execute);
							
						    }
						
						  
					   
				 }
		       
		       
		       	row.createCell(0).setCellValue("Keerthi21");
				row.createCell(1).setCellValue("Prasanthi21");
				 row.createCell(2).setCellValue("Vishnu21");
				 row.createCell(3).setCellValue("Hasini21");
		       
		       
		       myxls.close();
		       FileOutputStream output_file =new FileOutputStream(new File("C:\\ExcelWrite\\output2.xlsx"));  
		       //write changes
		       wb.write(output_file);
		       output_file.close();
		       
		       output_file.close();
		       System.out.println(" is successfully written");
		    }
		    catch(Exception e)
		    {
		    }
}

}
