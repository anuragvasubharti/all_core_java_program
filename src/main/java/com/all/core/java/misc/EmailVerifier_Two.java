package com.all.core.java.misc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailVerifier_Two {

	private static final Logger logger = Logger.getLogger(EmailVerifier_Two.class.getName());

	public static void main(String[] args) {
		
		// file with emails, one per line
		String filePath = "E:\\Project-Anurag\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\input_output\\emails.txt"; 

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String email;
			while ((email = br.readLine()) != null) {
				System.out.println(email + " -> " + (isEmailDeliverable(email) ? "DELIVERABLE" : "FAILED"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean isEmailDeliverable(String email) {
		try {
			// Set properties for SMTP
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com"); // using Gmail SMTP as example
			props.put("mail.smtp.port", "25"); // standard SMTP port
			props.put("mail.smtp.timeout", "5000");

			Session session = Session.getInstance(props);

			// Create test message
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("anuragvasubharti@gmail.com")); // sender email
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.setSubject("Test Email");
			message.setText("This is a test.");

			// Try to connect to SMTP server
			Transport transport = session.getTransport("smtp");
			transport.connect(); // no auth, just check server connection
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();

			return true; // if no exception, email is deliverable
		} catch (MessagingException e) {
			return false; // failed to deliver
		}
	}
}
