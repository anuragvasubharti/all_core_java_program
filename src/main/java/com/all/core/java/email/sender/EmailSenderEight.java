package com.all.core.java.email.sender;

import java.util.Properties;
import java.util.logging.Logger;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailSenderEight {
	
	private static final Logger logger = Logger.getLogger(EmailSenderEight.class.getName());

	public static void main(String[] args) {
		
		// Replace with your email details
		final String username = "sakshivirhajobsearch";
		final String password = "jbalvrfypajbrlzm";
		final String recipientEmail = "anjalis@bestinfosystems.co.in"; // replace with a valid recipient email
		final String subject = "Test Email with High Priority";
		final String body = "This is a test email with high priority from a Java program.";
		// Set up the SMTP server properties
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		// Get the Session object
		Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			// Create a default MimeMessage object
			Message message = new MimeMessage(session);
			// Set From: header field
			message.setFrom(new InternetAddress(username));
			// Set To: header field
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
			// Set Subject: header field
			message.setSubject(subject);
			// Set the actual message
			message.setText(body);
			// Set email priority to high
			message.setHeader("X-Priority", "1"); // 1 (High), 3 (Normal), 5 (Low)
			message.setHeader("Priority", "Urgent");
			message.setHeader("Importance", "high");
			// Send the message
			Transport.send(message);
			System.out.println("High priority email sent successfully");
			
		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.println("Failed to send email: " + e.getMessage());
		}
	}
}
