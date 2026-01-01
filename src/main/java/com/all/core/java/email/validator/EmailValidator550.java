package com.all.core.java.email.validator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class EmailValidator550 {

	private static final Logger logger = Logger.getLogger(EmailValidator550.class.getName());

	public static void main(String[] args) {

		String inputFile = "E:\\Project\\core_java_email_mailbox_checker\\emails.txt";
		String validOutputFile = "E:\\Project\\core_java_email_mailbox_checker\\valid_emails.txt";
		String invalidOutputFile = "E:\\Project\\core_java_email_mailbox_checker\\invalid_emails.txt";

		List<String> validEmails = new ArrayList<>();
		List<String> invalidEmails = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
			String email;
			while ((email = reader.readLine()) != null) {
				email = email.trim();
				if (email.isEmpty())
					continue;

				// Simulate response from SMTP server
				String smtpResponse = simulateSMTPCheck(email);

				System.out.println("Checking: " + email + " => " + smtpResponse);

				if (smtpResponse.contains("550 5.1.1")) {
					invalidEmails.add(email);
				} else {
					validEmails.add(email);
				}
			}

			// Write valid emails
			writeToFile(validOutputFile, validEmails);
			writeToFile(invalidOutputFile, invalidEmails);

			System.out.println("\nValidation complete.");
			System.out.println("Valid emails saved to: " + validOutputFile);
			System.out.println("Invalid emails saved to: " + invalidOutputFile);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Simulate SMTP response based on dummy logic
	private static String simulateSMTPCheck(String email) {

		// Example rule: emails with "invalid" in them are rejected
		if (email.toLowerCase().contains("invalid") || email.endsWith("@fake.com")) {
			return "550 5.1.1 The email account that you tried to reach does not exist.";
		}
		return "250 2.1.5 OK";
	}

	// Helper to write results to file
	private static void writeToFile(String filename, List<String> emails) throws IOException {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
			for (String email : emails) {
				writer.write(email);
				writer.newLine();
			}
		}
	}
}
