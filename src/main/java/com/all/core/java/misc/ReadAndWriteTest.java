package com.all.core.java.misc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;

public class ReadAndWriteTest {

	static int totalRead = 0;
	static int totalUnique = 0;
	static int totalValid = 0;
	static int totalInvalid = 0;

	public static void main(String[] args) {
		String inputFile = "E:\\Project-Anurag\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\input_output\\InputEmail2.txt";
		String outputFile = "E:\\Project-Anurag\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\input_output\\OutputEmail2.txt";
		// TreeSet = sorted + unique
		Set<String> uniqueEmails = new TreeSet<>();
		// ✅ Try-with-resources (NO leaks)
		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
				BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
			String line;
			while ((line = reader.readLine()) != null) {
				totalRead++;
				uniqueEmails.add(line.trim());
			}
			totalUnique = uniqueEmails.size();
			for (String email : uniqueEmails) {
				if (emailValidator(email)) {
					writer.write(email);
					writer.newLine();
					totalValid++;
				} else {
					totalInvalid++;
				}
			}
			System.out.println("===== SUMMARY =====");
			System.out.println("Total Read      : " + totalRead);
			System.out.println("Total Unique    : " + totalUnique);
			System.out.println("Total Valid     : " + totalValid);
			System.out.println("Total Invalid   : " + totalInvalid);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ✅ RFC-compliant email validation
	public static boolean emailValidator(String email) {
		try {
			InternetAddress address = new InternetAddress(email);
			address.validate();
			return true;
		} catch (AddressException e) {
			return false;
		}
	}
}
