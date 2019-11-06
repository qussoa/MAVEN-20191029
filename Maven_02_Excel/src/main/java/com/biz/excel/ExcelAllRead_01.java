package com.biz.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Hello world!
 *
 */
public class ExcelAllRead_01 {
	public static void main(String[] args) {
		String exFile = "src/main/java/com/biz/excel/학생정보(2019-10-10).xlsx";
		FileInputStream file = null;
		XSSFWorkbook workbook = null;

		try {
			file = new FileInputStream(exFile);
			workbook = new XSSFWorkbook(file);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int rowIndex = 0;
		int colIndex = 0;
		XSSFSheet xSheet = workbook.getSheet("학생정보");

		// 현재 열린 sheet의 data가 저장된 row 개수를 가져와라
		int rows = xSheet.getPhysicalNumberOfRows();
		for (rowIndex = 0; rowIndex < rows; rowIndex++) {
			XSSFRow curRow = xSheet.getRow(rowIndex);
			int cols = curRow.getPhysicalNumberOfCells();
			for (colIndex = 0; colIndex < cols; colIndex++) {
				XSSFCell cell = curRow.getCell(colIndex);
				if (cell == null)
					continue;
				else {
					System.out.print(cell.toString()+"\t");
				}
			}
			System.out.println();
		}

		System.out.println("Hello World!");
	}
}
