package com.all.core.java.email.smtp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public class SMTPDialogOne {

	private static final Logger logger = Logger.getLogger(SMTPDialogOne.class.getName());

	public static void main(String[] args) {

		String mailServer = "mxb-0000ec05.gslb.pphosted.com";
		int port = 25;
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
			// Read the server's response to HELO
			System.out.println("Server: " + reader.readLine());
			// Send QUIT command
			String quitCommand = "QUIT\r\n";
			System.out.print("Client: " + quitCommand);
			writer.write(quitCommand.getBytes());
			writer.flush();
			// Read the server's response to QUIT
			System.out.println("Server: " + reader.readLine());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
