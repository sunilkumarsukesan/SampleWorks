package edu.training.testingPrograms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {

	public static void main(String[] args) throws IOException {
		int rowCount;
		String data[] = new String [4];

		FileInputStream fis = new FileInputStream(".//src/test/resources/DataSheet.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);	

		// get the number of rows
		rowCount = sheet.getLastRowNum();

		//getting input for each and every value
		Scanner input = new Scanner(System.in);
		String [] fields = {"First Name","Second Name","email","PhoneNumber"};
		for (int i=0;i<=3;i++)
		{
			System.out.println("Enter the "+ fields[i]);
			data[i]=input.nextLine();
		}
		input.close();

		//creating a new row after the non empty row
		Row row = sheet.createRow(rowCount+1); 
		int cellnum = 0; 
		for (Object obj : data) { 

			// this line creates a cell in the next column of that row 
			Cell cell = row.createCell(cellnum++); 
			if (obj instanceof String) 
				cell.setCellValue((String)obj); 
			else if (obj instanceof Integer) 
				cell.setCellValue((Integer)obj); 
		} 
		try { 
			// this Writes the Datasheet workbook 
			FileOutputStream out = new FileOutputStream(".//src/test/resources/DataSheet.xlsx"); 
			workbook.write(out); 
			out.close(); 
			workbook.close();
			System.out.println("DataSheet.xlsx is successfully written!!"); 
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
		}
	}

}
