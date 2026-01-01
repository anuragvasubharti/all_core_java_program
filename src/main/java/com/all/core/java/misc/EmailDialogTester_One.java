package com.all.core.java.misc;

import java.util.Properties;
import java.util.logging.Logger;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailDialogTester_One {

	private static final Logger logger = Logger.getLogger(EmailDialogTester_One.class.getName());

	public static void main(String[] args) {

		String host = "techzert-com.mail.protection.outlook.com";
		String from = "your-email@example.com";
		String to = "recipient@example.com";
		final String username = "your-email@example.com"; // your email username
		final String password = "your-email-password"; // your email password
		Properties properties = new Properties();
		// Setup mail server
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "587"); // TLS port
		// Get the Session object.
		Session session = Session.getInstance(properties, new jakarta.mail.Authenticator() {
			protected jakarta.mail.PasswordAuthentication getPasswordAuthentication() {
				return new jakarta.mail.PasswordAuthentication(username, password);
			}
		});
		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);
			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));
			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			// Set Subject: header field
			message.setSubject("SMTP Server Dialog Test");
			// Now set the actual message
			message.setText("This is a test message to verify SMTP server dialog.");
			// Send message
			Transport transport = session.getTransport("smtp");
			transport.connect(host, username, password);
			System.out.println("Connected to SMTP server successfully.");
			transport.sendMessage(message, message.getAllRecipients());
			System.out.println("Sent message successfully.");
			transport.close();
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
