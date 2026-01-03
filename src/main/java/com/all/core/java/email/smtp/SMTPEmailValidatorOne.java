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

public class SMTPEmailValidatorOne {

	private static final Logger logger = Logger.getLogger(SMTPEmailValidatorOne.class.getName());

	public static void main(String[] args) throws Exception {

		String inputFile = "E:\\Project-Anurag\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\input_output\\emails.txt";
		String validOutputFile = "E:\\Project-Anurag\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\input_output\\valid_emails.txt";
		String invalidOutputFile = "E:\\Project-Anurag\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\input_output\\invalid_emails.txt";

		List<String> validEmails = new ArrayList<>();
		List<String> invalidEmails = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
			String email;
			while ((email = reader.readLine()) != null) {
				email = email.trim();
				if (email.isEmpty())
					continue;

				boolean isValid = validateEmail(email);
				if (isValid) {
					validEmails.add(email);
					System.out.println(email + " is VALID");
				} else {
					invalidEmails.add(email);
					System.out.println(email + " is INVALID");
				}
			}

			writeToFile(validOutputFile, validEmails);
			writeToFile(invalidOutputFile, invalidEmails);
		}
	}

	private static boolean validateEmail(String email) {

		try {
			String domain = email.substring(email.indexOf('@') + 1);
			List<String> mxHosts = getMXRecords(domain);

			if (mxHosts.isEmpty())
				return false;

			for (String mx : mxHosts) {
				try (Socket socket = new Socket(mx, 25)) {
					BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

					// Read initial response
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

					// Quit connection
					sendCommand(writer, "QUIT");
					readResponse(reader);

					// Valid if response is 250 or 251
					return rcptResponse.startsWith("250") || rcptResponse.startsWith("251");
				} catch (IOException e) {
					// Try next MX
				}
			}
		} catch (Exception e) {
			return false;
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
