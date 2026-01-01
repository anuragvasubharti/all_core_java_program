package com.all.core.java.email.smtp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public class SMTPDialogTwo {

	private static final Logger logger = Logger.getLogger(SMTPDialogTwo.class.getName());

	/*
	 * https://www.gammadyne.com/relaying_denied.htm
	 * 
	 * "Relaying" is when you send email to one mail server, expecting it to pass
	 * the email on to its intended recipient who resides on a different mail server
	 * (known as "non-local email"). A mail server will produce a "Relaying Denied"
	 * error when an unauthorized user attempts to send non-local email.
	 * 
	 * The server error comes in many forms. Here are some of the most common ones:
	 * 
	 * 550 Relaying denied 550 Relay not permitted 550 Relaying not allowed 550
	 * 5.7.1 Unable to Relay 550 5.7.1 <john@example.com>... Relaying denied 553
	 * SMTP Relaying Denied 553 sorry, that domain isn't in my list of allowed
	 * rcpthosts (#5.7.1) 554 <john@example.com>: Relay access denied
	 * 
	 * Mail servers will not relay mail from just anyone. Otherwise, spammers could
	 * flood the mail server, making it do their dirty work. You must be authorized
	 * to use a mail server for relaying. Unauthorized users will always receive the
	 * "Relaying Denied" error.
	 */

	public static void SMTPDialog(String email) {

		String Error_User_Unknown = "Error: User Unknown";

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

				if (response.contains("")) {
					System.out.println("");
				} else if (response.contains("")) {
					System.out.println("Error: User Unknown");
				}

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
