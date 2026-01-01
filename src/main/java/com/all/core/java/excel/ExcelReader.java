package com.all.core.java.excel;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {

	private static final Logger logger = Logger.getLogger(ExcelReader.class.getName());

	public static final String SAMPLE_XLSX_FILE_PATH = "C:\\Users\\Anurag\\Desktop\\New folder\\Book1 - Yes.xlsx";

	public static void main(String[] args) throws IOException, InvalidFormatException {

		Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));
		System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets");
		// Print sheet names
		workbook.forEach(sheet -> System.out.println("=> " + sheet.getSheetName()));
		// Read first sheet
		Sheet sheet = workbook.getSheetAt(0);
		DataFormatter formatter = new DataFormatter();
		System.out.println("\nReading Excel Data:\n");
		for (Row row : sheet) {
			for (Cell cell : row) {
				System.out.print(formatter.formatCellValue(cell) + "\t");
			}
			System.out.println();
		}
		workbook.close();
	}

	// OPTIONAL: Detailed cell handling (if needed)
	private static void printCellValue(Cell cell) {

		switch (cell.getCellType()) {
		case BOOLEAN:
			System.out.print(cell.getBooleanCellValue());
			break;
		case STRING:
			System.out.print(cell.getStringCellValue());
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				System.out.print(cell.getDateCellValue());
			} else {
				System.out.print(cell.getNumericCellValue());
			}
			break;
		case FORMULA:
			System.out.print(cell.getCellFormula());
			break;
		case BLANK:
		default:
			System.out.print("");
		}
		System.out.print("\t");
	}
}
