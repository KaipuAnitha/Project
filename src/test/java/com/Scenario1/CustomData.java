package com.Scenario1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class CustomData 
{
	public XSSFWorkbook wb;

	@DataProvider(name = "Excel")
	public Object[][] excelData() {
		File f1 = new File(System.getProperty("user.dir") + "//TestData//Data.xlsx");

		FileInputStream fis;
		Object arr[][] = null;
		try {
			fis = new FileInputStream(f1);
			wb = new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet("userdata");
			// Number of rows
			int row = sheet.getPhysicalNumberOfRows();
			System.out.println("Total Number of cells are:"+row);
			int cell = sheet.getRow(0).getPhysicalNumberOfCells();
			System.out.println("Total Number of cells are:"+cell);

			arr = new Object[row-1][cell];

			for (int i = 1; i < row; i++) {
				for (int j = 0; j < cell; j++) {
					arr[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
					System.out.print(arr[i-1][j]+"  ");

				}
				System.out.println();

			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arr;

}
	
	
}
	
	
	
	
	
	
	
	


