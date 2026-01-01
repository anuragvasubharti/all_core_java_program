package com.all.core.java.email.sender;

import java.util.Properties;
import java.util.logging.Logger;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.SendFailedException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailSenderFive {
	
	private static final Logger logger = Logger.getLogger(EmailSenderFive.class.getName());

	public static void main(String[] args) {
		
		final String username = "your_email@example.com";
		final String password = "your_email_password";
		// SMTP server settings
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.example.com");
		props.put("mail.smtp.port", "587");
		// Create a session with authentication
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			// Create a MimeMessage object
			Message message = new MimeMessage(session);
			// Set From: header field
			message.setFrom(new InternetAddress("your_email@example.com"));
			// Set To: header field
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("recipient@example.com"));
			// Set Subject: header field
			message.setSubject("Testing Subject");
			// Set Message: content
			message.setText("This is a test email.");
			// Send the message
			Transport.send(message);
			System.out.println("Email sent successfully.");
			
		} catch (MessagingException e) {
			if (e instanceof SendFailedException) {
				SendFailedException sfe = (SendFailedException) e;
				/*
				 * if (sfe.getReturnCode() == SendFailedException.RELAYING_DENIED) {
				 * System.out.println("SMTP relaying denied. Check SMTP server settings."); }
				 * else { System.out.println("Failed to send email: " + e.getMessage()); }
				 */
			} else {
				System.out.println("Failed to send email: " + e.getMessage());
			}
		}
	}
}
