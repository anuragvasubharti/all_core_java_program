package com.all.core.java.pdf;

// http://downloads.snowtide.com/javadoc/PDFxStream/3.6.0/
// https://www.snowtide.com/help/2.7.0/extracting-text-from-pdf-documents
import java.util.TreeSet;
import java.util.logging.Logger;

import com.all.core.java.misc.GenerateBday;
import com.itextpdf.text.pdf.PdfReader;

public class DecryptWithPassword {

	private static final Logger logger = Logger.getLogger(DecryptWithPassword.class.getName());

	static int count;

	public static void main(String[] args) {

		String pdfFilePath = "E:\\Project-Anurag\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\input_output\\Infosys_F16_00687656_2017.PDF";
		GenerateBday generateBday = new GenerateBday();
		TreeSet<String> bDayTreeSet = generateBday.bDay();
		System.out.println("Total passwords: " + bDayTreeSet.size());
		for (String password : bDayTreeSet) {
			try {
				System.out.println("Trying password: " + password);
				PdfReader reader = new PdfReader(pdfFilePath, password.getBytes());
				if (reader.isEncrypted()) {
					System.out.println("PDF is not encrypted");
				} else {
					System.out.println("✅ Password FOUND: " + password);
				}
				reader.close();
				break; // stop after success
			} catch (Exception e) {
				// wrong password → ignore
			}
			if (++count == 10)
				break;
		}
	}
}
