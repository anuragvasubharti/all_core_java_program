package com.all.core.java.email.sender;

import java.util.Properties;
import java.util.logging.Logger;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailSenderFour {

	private static final Logger logger = Logger.getLogger(EmailSenderFour.class.getName());

	public static void main(String[] args) {

		// SMTP server information
		// String host = "smtp.example.com";
		String host = "smtp.gmail.com";
		String port = "587";
		// String mailFrom = "your-email@example.com";
		// String password = "your-email-password";
		String mailFrom = "anuragvasubharti";
		String password = "jnjibasgtglbcflv";
		// Outgoing email information
		String mailTo = "anuragvasubharti@gmail.com"; // Replace with the recipient's email address
		String subject = "Test Email";
		String message = "This is a test email message";
		// Set SMTP properties
		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", port);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		// Create a session with the SMTP server
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mailFrom, password);
			}
		});

		try {
			// Create a new email message
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(mailFrom));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
			msg.setSubject(subject);
			msg.setText(message);
			// Send the email
			Transport.send(msg);
			System.out.println("Email sent successfully.");

		} catch (MessagingException e) {
			e.printStackTrace();
			System.err.println("Failed to send email: " + e.getMessage());
		}
	}
}
