package edu.training.testingPrograms;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		
		//Reading the contents of excel
		 for (String[] row : readExcel()) {
			 System.out.println(Arrays.toString(row)); 
		 }
	}

	public static String[] [] readExcel(){
		String[][] data = null ;
		int rowCount;
		
		try {
			FileInputStream fis = new FileInputStream(".//src/test/resources/DataSheet.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheetAt(0);	

			// get the number of rows
			rowCount = sheet.getLastRowNum();

			// get the number of columns
			int columnCount = sheet.getRow(0).getLastCellNum();
			
			data = new String[rowCount+1][columnCount];

			// loop through the rows
			for(int i=0; i <= rowCount; i++){
				try {
					XSSFRow row = sheet.getRow(i);
					for(int j=0; j < columnCount; j++){ // loop through the columns
						try {
							String cellValue = "";
							try{
								cellValue = row.getCell(j).getStringCellValue();
							}catch(NullPointerException e){

							}

							data[i][j]  = cellValue; // add to the data array
						} catch (Exception e) {
							e.printStackTrace();
						}				
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			fis.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
}