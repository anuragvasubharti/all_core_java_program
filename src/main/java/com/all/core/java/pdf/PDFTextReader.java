package com.all.core.java.pdf;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFTextReader {

	private static final Logger logger = Logger.getLogger(PDFTextReader.class.getName());

	static String pdfToText(String filePath) {

		File file = new File(filePath);
		if (file.exists()) {
			System.err.println("File does not exist: " + filePath);
			return null;
		}
		try (PDDocument document = PDDocument.load(file)) {
			PDFTextStripper stripper = new PDFTextStripper();
			return stripper.getText(document);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {

		String pdfPath = "C:\\Users\\Anurag\\Documents\\Bluetooth Exchange Folder\\My_Statement_1 May, 2018_30 May, 2018_8074863953.pdf";
		String txtPath = "C:\\Users\\Anurag\\Documents\\Bluetooth Exchange Folder\\My_Statement_1 May, 2018_30 May, 2018_8074863953.txt";
		String content = pdfToText(pdfPath);
		if (content == null) {
			System.out.println("No text extracted.");
			return;
		}
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(txtPath))) {
			writer.write(content);
			System.out.println("Text extracted successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
