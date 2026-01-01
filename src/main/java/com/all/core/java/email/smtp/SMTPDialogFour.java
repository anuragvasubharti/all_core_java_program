package com.all.core.java.email.smtp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public class SMTPDialogFour {

	private static final Logger logger = Logger.getLogger(SMTPDialogFour.class.getName());

	public static void main(String[] args) {

		String mailServer = "mxa-0006eb01.gslb.pphosted.com"; // Replace with the actual mail server
		int port = 25; // SMTP port
		try (Socket socket = new Socket(mailServer, port);
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				OutputStream writer = socket.getOutputStream()) {
			// Read the server's initial response
			String initialResponse = reader.readLine();
			System.out.println("Server: " + initialResponse);
			// Send HELO command
			sendCommand(writer, reader, "HELO example.com");
			// Send MAIL FROM command
			sendCommand(writer, reader, "MAIL FROM:<sender@example.com>");
			// Send RCPT TO command
			sendCommand(writer, reader, "RCPT TO:<recipient@example.com>");
			// Send DATA command
			sendCommand(writer, reader, "DATA");
			// Send email headers and body, end with a single dot on a line
			writer.write("Subject: Test Email\r\n".getBytes());
			writer.write("From: sender@example.com\r\n".getBytes());
			writer.write("To: recipient@example.com\r\n".getBytes());
			writer.write("\r\n".getBytes()); // Empty line to separate headers from body
			writer.write("This is a test email sent from a Java program.\r\n".getBytes());
			writer.write(".\r\n".getBytes());
			writer.flush();
			// Read response to email data
			String dataResponse = reader.readLine();
			System.out.println("Server: " + dataResponse);
			// Send QUIT command
			sendCommand(writer, reader, "QUIT");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void sendCommand(OutputStream writer, BufferedReader reader, String command) throws Exception {

		System.out.print("Client: " + command + "\r\n");
		writer.write((command + "\r\n").getBytes());
		writer.flush();
		String response = reader.readLine();
		System.out.println("Server: " + response);
	}
}
