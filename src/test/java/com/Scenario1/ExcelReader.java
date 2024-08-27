package com.Scenario1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelReader 
{
	
  @Test
  public void readData() throws IOException  
  {
	  //File
	  File f1=new File(System.getProperty("user.dir")+"//TestData//Data.xlsx");
	  FileInputStream fs=new FileInputStream(f1);
	  
	  //workbook
	  XSSFWorkbook wb=new XSSFWorkbook(fs);
	  
	  //Number of rows
	  int rows =  wb.getSheet("userdata").getPhysicalNumberOfRows();
	  System.out.println("Total number of rows are:"+rows);
	  
	  
	  //Number of cells
	  int cells = wb.getSheet("userdata").getRow(0).getPhysicalNumberOfCells();
	  System.out.println("Total number of cells are:"+cells);
	  
	  //Create an array for same size of file
	  Object data[][]=new Object[rows-1][cells];
	  
	  //iterate array and read data from file and save it inside file
	  for(int i=1;i<rows;i++)
	  {
		  for(int j=0;j<cells;j++)
		  {
			data[i-1][j] = wb.getSheet("userdata").getRow(i).getCell(j).getStringCellValue();
			System.out.print(data[i-1][j]+"  ");
		  }
		  System.out.println();
	  }
	  
  }
}
