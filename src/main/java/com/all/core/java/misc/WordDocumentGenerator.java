package com.all.core.java.misc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.logging.Logger;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class WordDocumentGenerator {

	private static final Logger logger = Logger.getLogger(WordDocumentGenerator.class.getName());

	public static void main(String[] args) {

		DecimalFormat df = new DecimalFormat("000"); // Format: 001, 002, ..., 500
		
		// Change this to your desired output folder
		String outputDir = "E:\\all_corejava_program\\src\\main\\java\\com\\all\\corejava\\program"; 
		for (int i = 1; i <= 500; i++) {
			// Create document name
			String fileName = "Job-Description-" + df.format(i) + ".docx";
			// Create a new Word document
			try (XWPFDocument document = new XWPFDocument();
					FileOutputStream out = new FileOutputStream(outputDir + fileName)) {
				// Add sample content
				XWPFParagraph paragraph = document.createParagraph();
				XWPFRun run = paragraph.createRun();
				run.setText("This is the content of " + fileName);
				run.setTextHighlightColor("yellow");
				// Save the document
				document.write(out);
				System.out.println("Created: " + fileName);
			} catch (IOException e) {
				System.err.println("Error creating file " + fileName + ": " + e.getMessage());
			}
		}
		System.out.println();
		System.out.println("All documents created successfully.");
	}
}
