package com.all.core.java.email.smtp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Logger;

public class SmtpDialogExample {

	private static final Logger logger = Logger.getLogger(SmtpDialogExample.class.getName());

	public static void main(String[] args) {

		String host = "techzert-com.mail.protection.outlook.com";
		int port = 25; // Standard SMTP port
		String from = "your-email@example.com";
		String to = "recipient@example.com";
		try (Socket socket = new Socket(host, port);
				PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
			// Read server's initial response
			System.out.println("Server: " + in.readLine());
			// Send HELO command
			sendCommand(out, in, "HELO localhost");
			// Send MAIL FROM command
			sendCommand(out, in, "MAIL FROM:<" + from + ">");
			// Send RCPT TO command
			sendCommand(out, in, "RCPT TO:<" + to + ">");
			// Send QUIT command
			sendCommand(out, in, "QUIT");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private static void sendCommand(PrintWriter out, BufferedReader in, String command) throws Exception {
		
		System.out.println("Client: " + command);
		out.println(command);
		String response = in.readLine();
		System.out.println("Server: " + response);
	}
}
