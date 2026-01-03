package com.all.core.java.misc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.logging.Logger;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Create Password Protected PDF using iText
 */
public class CreatePasswordProtectedPdfExample {
	private static final Logger logger = Logger.getLogger(CreatePasswordProtectedPdfExample.class.getName());

	public static void main(String[] args) {

		try {

			String pdfFilePath = "E:\\Project-Anurag\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\input_output\\Infosys_F16_00687656_2017.pdf";
			OutputStream fos = new FileOutputStream(new File(pdfFilePath));
			Document document = new Document();
			PdfWriter pdfWriter = PdfWriter.getInstance(document, fos);
			String userPassword = "a";
			String ownerPassword = "b";
			// 🔐 Enable encryption BEFORE opening the document
			pdfWriter.setEncryption(userPassword.getBytes(), ownerPassword.getBytes(), PdfWriter.ALLOW_PRINTING,
					PdfWriter.ENCRYPTION_AES_128);
			document.open();
			document.add(new Paragraph("This is Password protected PDF file"));
			document.close();
			fos.close();
			System.out.println("PDF created successfully at:");
			System.out.println(pdfFilePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
