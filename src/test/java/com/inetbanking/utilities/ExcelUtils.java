package com.inetbanking.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	private static String Test_Data=System.getProperty("user.dir")+"/src/test/java/com/inetbanking/testData/TestData.xlsx";
	private static Workbook book;
	private static Sheet sheet;
	
	
	public static Object[][] testData(String sheetName)
	{
		try {
			FileInputStream fs = new FileInputStream(Test_Data);
			book=WorkbookFactory.create(fs);
			sheet=book.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int k=0; k<sheet.getRow(0).getLastCellNum();k++)
			{
				 data[i][k] = sheet.getRow(i+1).getCell(k).toString();
				
			}
		}
		 System.out.println(Arrays.deepToString(data));
	return data;
		
		
	}
}
