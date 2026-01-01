package com.all.core.java.email.smtp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public class SMTPDialogThree {

	private static final Logger logger = Logger.getLogger(SMTPDialogThree.class.getName());

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
			String heloCommand = "HELO example.com\r\n";
			System.out.print("Client: " + heloCommand);
			writer.write(heloCommand.getBytes());
			writer.flush();
			String heloResponse = reader.readLine();
			System.out.println("Server: " + heloResponse);
			// Send MAIL FROM command
			String mailFromCommand = "MAIL FROM:<sender@example.com>\r\n";
			System.out.print("Client: " + mailFromCommand);
			writer.write(mailFromCommand.getBytes());
			writer.flush();
			String mailFromResponse = reader.readLine();
			System.out.println("Server: " + mailFromResponse);
			// Send RCPT TO command
			String rcptToCommand = "RCPT TO:<recipient@example.com>\r\n";
			System.out.print("Client: " + rcptToCommand);
			writer.write(rcptToCommand.getBytes());
			writer.flush();
			String rcptToResponse = reader.readLine();
			System.out.println("Server: " + rcptToResponse);
			// Send QUIT command
			String quitCommand = "QUIT\r\n";
			System.out.print("Client: " + quitCommand);
			writer.write(quitCommand.getBytes());
			writer.flush();
			String quitResponse = reader.readLine();
			System.out.println("Server: " + quitResponse);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
