package com.all.core.java.email.smtp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.xbill.DNS.Lookup;
import org.xbill.DNS.MXRecord;
import org.xbill.DNS.Record;
import org.xbill.DNS.TextParseException;
import org.xbill.DNS.Type;

public class SMTPEmailValidatorTwo {

	private static final Logger logger = Logger.getLogger(SMTPEmailValidatorTwo.class.getName());

	public static void main(String[] args) throws Exception {

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

				System.out.println("Checking: " + email);
				boolean isValid = validateEmail(email);

				if (isValid) {
					validEmails.add(email);
					System.out.println("✅ Valid: " + email);
				} else {
					invalidEmails.add(email);
					System.out.println("❌ Invalid: " + email);
				}
			}

			writeToFile(validOutputFile, validEmails);
			writeToFile(invalidOutputFile, invalidEmails);
			System.out.println("Validation finished.");
		}
	}

	private static boolean validateEmail(String email) {

		try {
			String domain = email.substring(email.indexOf('@') + 1);
			List<String> mxRecords = getMXRecords(domain);

			if (mxRecords.isEmpty()) {
				System.out.println("⚠️ No MX records found for domain: " + domain);
				return false;
			}

			for (String mxHost : mxRecords) {
				try (Socket socket = new Socket(mxHost, 25)) {
					BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

					if (!readResponse(reader).startsWith("220"))
						return false;

					sendCommand(writer, "HELO test.com");
					if (!readResponse(reader).startsWith("250"))
						return false;

					sendCommand(writer, "MAIL FROM:<test@test.com>");
					if (!readResponse(reader).startsWith("250"))
						return false;

					sendCommand(writer, "RCPT TO:<" + email + ">");
					String rcptResponse = readResponse(reader);

					sendCommand(writer, "QUIT");
					readResponse(reader); // read quit response

					if (rcptResponse.startsWith("250") || rcptResponse.startsWith("251")) {
						return true;
					} else if (rcptResponse.startsWith("550")) {
						return false;
					} else {
						System.out.println("⚠️ Unexpected RCPT TO response: " + rcptResponse);
						return false;
					}

				} catch (IOException e) {
					System.out.println("⚠️ Could not connect to MX host: " + mxHost);
					// Try next MX host
				}
			}
		} catch (Exception e) {
			System.out.println("❌ Error validating email: " + email + " => " + e.getMessage());
		}

		return false;
	}

	private static List<String> getMXRecords(String domain) throws TextParseException {

		Record[] records = new Lookup(domain, Type.MX).run();
		List<String> mxHosts = new ArrayList<>();

		if (records != null) {
			for (Record record : records) {
				MXRecord mx = (MXRecord) record;
				mxHosts.add(mx.getTarget().toString());
			}
		}

		return mxHosts;
	}

	private static void sendCommand(BufferedWriter writer, String command) throws IOException {

		writer.write(command + "\r\n");
		writer.flush();
	}

	private static String readResponse(BufferedReader reader) throws IOException {

		String response = reader.readLine();
		return response != null ? response : "";
	}

	private static void writeToFile(String filename, List<String> emails) throws IOException {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
			for (String email : emails) {
				writer.write(email);
				writer.newLine();
			}
		}
	}
}