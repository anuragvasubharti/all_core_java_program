package com.all.core.java.email.sender;

import java.util.Properties;
import java.util.logging.Logger;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailSenderSix {

	private static final Logger logger = Logger.getLogger(EmailSenderSix.class.getName());

	public static void main(String[] args) {

		// Recipient's email ID needs to be mentioned.
		String to = "recipient@example.com";
		// Sender's email ID needs to be mentioned
		String from = "your-email@example.com";
		// Assuming you are sending email from through outlook.com server
		String host = "techzert-com.mail.protection.outlook.com";
		// Get system properties
		Properties properties = System.getProperties();
		// Setup mail server
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.port", "25"); // Default port for SMTP
		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);
			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));
			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			// Set Subject: header field
			message.setSubject("This is the Subject Line");
			// Now set the actual message
			message.setText("This is the actual message");
			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
