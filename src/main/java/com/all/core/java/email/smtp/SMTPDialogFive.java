package com.all.core.java.email.smtp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

public class SMTPDialogFive {

	private static final Logger logger = Logger.getLogger(SMTPDialogFive.class.getName());

	public static void main(String[] args) {

		String serverAddress = "smtp.example.com";
		int port = 25;
		try {
			// Connect to the SMTP server
			Socket socket = new Socket(serverAddress, port);
			// Create input and output streams
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			// Wait for server response
			String response = reader.readLine();
			System.out.println("Server: " + response);
			// Send EHLO command to identify the client
			writer.println("EHLO example.com");
			writer.flush();
			response = reader.readLine();
			System.out.println("Server: " + response);
			// Send MAIL FROM command
			writer.println("MAIL FROM:<sender@example.com>");
			writer.flush();
			response = reader.readLine();
			System.out.println("Server: " + response);
			// Send RCPT TO command
			writer.println("RCPT TO:<recipient@example.com>");
			writer.flush();
			response = reader.readLine();
			System.out.println("Server: " + response);
			// Send DATA command to start email data transfer
			writer.println("DATA");
			writer.flush();
			response = reader.readLine();
			System.out.println("Server: " + response);
			// Send email content
			writer.println("Subject: Test Email");
			writer.println("From: sender@example.com");
			writer.println("To: recipient@example.com");
			writer.println();
			writer.println("This is a test email.");
			writer.println(".");
			writer.flush();
			response = reader.readLine();
			System.out.println("Server: " + response);
			// Send QUIT command to close the connection
			writer.println("QUIT");
			writer.flush();
			response = reader.readLine();
			System.out.println("Server: " + response);
			// Close the socket
			socket.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
