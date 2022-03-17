package Com.Crm.Practice;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;
import com.mysql.cj.result.Row;

public class ReasDataFromExcelSheetTest {
	
	@Test
	
	public void readDataFromExcelSheetTest() throws Throwable
	{
		//step 1: load the file
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\New Microsoft Excel Worksheet.xlsx");
		
		//step2: creat the workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//step 3: get the sheet
		Sheet sh=wb.getSheet("Sheet1");
		
		
		//step 4:get the row
		Row ro=(Row) sh.getRow(0);
		
		
	  }
		

}
