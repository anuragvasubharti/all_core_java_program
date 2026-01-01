package com.all.core.java.misc;

import java.util.Properties;
import java.util.logging.Logger;

import jakarta.mail.Message;
import jakarta.mail.SendFailedException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;


public class EmailVerifier_One {
	private static final Logger logger = Logger.getLogger(EmailVerifier_One.class.getName());

	public static boolean isAddressValid(String email) {
		try {
			// Set mail server properties
			Properties properties = new Properties();
			properties.put("mail.smtp.host", "smtp.yahoo.com");
			properties.put("mail.smtp.port", "25");
			properties.put("mail.smtp.auth", "false");
			properties.put("mail.smtp.starttls.enable", "true");
			// properties.put("mail.store.protocol", "imaps");
			// properties.put("mail.imaps.host", "imap.gmail.com");
			// properties.put("mail.imaps.port", "993");
			// properties.put("mail.imaps.ssl.enable", "true");
			// Get the Session object
			Session session = Session.getInstance(properties);
			// Create a new empty message
			MimeMessage message = new MimeMessage(session);
			// Set the sender's email address
			message.setFrom(new InternetAddress("anuragvasubharti@yahoo.com"));
			// Set the recipient's email address
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			// Try to connect to the mail server
			Transport transport = session.getTransport("smtp");
			transport.connect();
			// Try to send the message (it won't actually be sent)
			transport.sendMessage(message, message.getAllRecipients());
			// Close the connection
			transport.close();
			return true; // If no exception is thrown, the email address is valid
		} catch (SendFailedException sfe) {
			// If an AddressException is caught, the email address is not valid
			return false;
		} catch (Exception e) {
			// Handle other exceptions (e.g., connection issues)
			e.printStackTrace();
			return false;
		}
	}

	public static void main(String[] args) {
		String email = "test@example.com";
		boolean result = isAddressValid("anuragvasubharti@yahoo.com");
		System.out.println("Is email valid? " + result);
	}
}
