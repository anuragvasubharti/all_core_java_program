package com.all.core.java.email.sender;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class SendEmail {

	private static final Logger logger = LogManager.getLogger(SendEmail.class);

	public static void main(String[] args) {

		String to = "sonoojaiswal1988@gmail.com";// change accordingly
		String from = "sonoojaiswal1987@gmail.com";// change accordingly
		String host = "localhost";// or IP address
		// Get the session object
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		Session session = Session.getDefaultInstance(properties);
		// compose the message

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Ping");
			message.setText("Hello, this is example of sending email  ");
			// Send message
			Transport.send(message);
			System.out.println("message sent successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
