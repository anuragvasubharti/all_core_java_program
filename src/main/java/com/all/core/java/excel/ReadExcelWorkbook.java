package com.all.core.java.excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * This example demonstrates opening a workbook and reading its elements
 */
public class ReadExcelWorkbook {

	private static final Logger logger = Logger.getLogger(ReadExcelWorkbook.class.getName());

	public static void main(String[] args) throws IOException {

		FileInputStream fileIn = null;
		FileOutputStream fileOut = null;
		XSSFWorkbook wb = null;
		try {
			fileIn = new FileInputStream("C:\\Users\\Anurag\\Desktop\\New folder\\Book1 - No.xlsx");
			POIFSFileSystem fs = new POIFSFileSystem(fileIn);
			wb = new XSSFWorkbook(fs.toString());
			XSSFSheet sheet = wb.getSheetAt(0);
			XSSFRow row0 = sheet.getRow(0);
			XSSFRow row1 = sheet.getRow(1);
			if (row1 != null) {
				System.out.println(row0.getCell(0) + " : " + row1.getCell(0));
				System.out.println(row0.getCell(1) + " : " + row1.getCell(1));
				System.out.println(row0.getCell(2) + " : " + row1.getCell(2));
			} else {
				System.out.println("Either of rows 0 or 1 is empty");
			}

		} finally {
			if (wb != null)
				// wb.close();
				if (fileOut != null)
					fileOut.close();
			if (fileIn != null)
				fileIn.close();
		}
	}
}
