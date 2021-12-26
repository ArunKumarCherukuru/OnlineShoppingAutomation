package com.SampleFramework.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static Workbook workbook;
	private static Sheet sheet;
	private static Cell cell;

	public void setExcelFile(String excelFilePath, String sheetName) throws IOException {
		// Create an object of File class to open xls file
		File file = new File(excelFilePath);

		// Create an object of FileInputStream class to read excel file
		FileInputStream inputStream = new FileInputStream(file);

		// creating workbook instance that refers to .xls file
		workbook = new XSSFWorkbook(inputStream);

		// creating a Sheet object
		sheet = workbook.getSheet(sheetName);
	}

	public String getCellData(int rowNumber, int cellNumber) {
		// getting the cell value from rowNumber and cell Number
		cell = sheet.getRow(rowNumber).getCell(cellNumber);

		// returning the cell value as string
		return cell.getStringCellValue();
	}

	public int getCellDataNumericValue(int rowNumber, int cellNumber) {
		// getting the cell value from rowNumber and cell Number
		cell = sheet.getRow(rowNumber).getCell(cellNumber);

		// returning the cell value as string
		return (int) cell.getNumericCellValue();
	}

	public int getRowCountInSheet() {
		int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		return rowcount;
	}

	public void setCellValue(int rowNum, int cellNum, String cellValue, String excelFilePath) throws IOException {
		// creating a new cell in row and setting value to it
		sheet.getRow(rowNum).createCell(cellNum).setCellValue(cellValue);

		FileOutputStream outputStream = new FileOutputStream(excelFilePath);
		workbook.write(outputStream);
	}
}