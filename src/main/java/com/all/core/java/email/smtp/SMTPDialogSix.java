package com.all.core.java.email.smtp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public class SMTPDialogSix {

	private static final Logger logger = Logger.getLogger(SMTPDialogSix.class.getName());

	public static void SMTPDialog(String email) {

		String Error_User_Unknown = "Error: User Unknown";
		String Error_Delivery_Loop = "Error: Delivery Loop Detected";

		String mailServer = "mxb-0000ec05.gslb.pphosted.com";
		int port = 25;
		String senderEmail = "sender@example.com";
		// String senderEmail = "anuragvasubharti@gmail.com";

		String recipientEmail = email; // Change this to the email you want to test

		try (Socket socket = new Socket(mailServer, port);
				BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				OutputStream writer = socket.getOutputStream()) {

			// Read the server's initial response
			System.out.println("Server: " + reader.readLine());

			// Send HELO command
			String heloCommand = "HELO example.com\r\n";
			System.out.print("Client: " + heloCommand);
			writer.write(heloCommand.getBytes());
			writer.flush();
			System.out.println("Server: " + reader.readLine());

			// Send MAIL FROM command
			String mailFromCommand = "MAIL FROM:<" + senderEmail + ">\r\n";
			System.out.print("Client: " + mailFromCommand);
			writer.write(mailFromCommand.getBytes());
			writer.flush();
			System.out.println("Server: " + reader.readLine());

			// Send RCPT TO command
			String rcptToCommand = "RCPT TO:<" + recipientEmail + ">\r\n";
			System.out.print("Client: " + rcptToCommand);
			writer.write(rcptToCommand.getBytes());
			writer.flush();
			String response = reader.readLine();
			System.out.println("------- Server: " + response);

			if (response != null) {
				// Check if the response contains "550 5.1.1 User Unknown"
				if (response.contains("550 5.1.1")) {
					System.out.println("Error: User Unknown");
					System.out.println();
					// return Error_User_Unknown;
				} else if (response.contains("5.4.6")) {
					// Check if the response indicates a delivery loop
					System.out.println("Error: Delivery Loop Detected");
					System.out.println();
					// return Error_Delivery_Loop;
				}
			}

			// Send QUIT command
			String quitCommand = "QUIT\r\n";
			System.out.print("Client: " + quitCommand);
			writer.write(quitCommand.getBytes());
			writer.flush();
			System.out.println("Server: " + reader.readLine());
			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
