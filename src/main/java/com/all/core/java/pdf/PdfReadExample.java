package com.all.core.java.pdf;

//https://www.qoppa.com/pdfsecure/
import java.util.TreeSet;
import java.util.logging.Logger;

import com.all.core.java.misc.GenerateBday;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class PdfReadExample {

	private static final Logger logger = Logger.getLogger(PdfReadExample.class.getName());

	private static final String FILE_PATH = "E:\\Project-Anurag\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\input_output\\Infosys_F16_00687656_2017.PDF";

	public static void main(String[] args) {

		GenerateBday generateBday = new GenerateBday();
		TreeSet<String> passwords = generateBday.bDay();
		for (String password : passwords) {
			try {
				System.out.println("Trying password: " + password);
				PdfReader reader = new PdfReader(FILE_PATH, password.getBytes());
				if (reader.isEncrypted()) {
					System.out.println("✅ PASSWORD FOUND: " + password);
					String text = PdfTextExtractor.getTextFromPage(reader, 1);
					System.out.println("Page 1 Content:\n" + text);
					reader.close();
					break;
				}
				reader.close();
			} catch (Exception e) {
				// Wrong password → ignore
			}
		}
	}
}
