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

public class EmailSenderSeven {

	private static final Logger logger = Logger.getLogger(EmailSenderSeven.class.getName());

	public static void main(String[] args) {

		// Recipient's email ID needs to be mentioned.
		String to = "anjalis@bestinfosystems.co.in";
		// Sender's email ID needs to be mentioned
		String from = "sakshivirhajobsearch@gmail.com";
		final String username = "sakshivirhajobsearch"; // your email username
		final String password = "jbalvrfypajbrlzm"; // your email password
		// Assuming you are sending email from through outlook.com server
		String host = "smtp.gmail.com";
		// Get system properties
		Properties properties = new Properties();
		// Setup mail server
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "587"); // TLS port
		// Get the Session object.
		Session session = Session.getInstance(properties, new jakarta.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
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
