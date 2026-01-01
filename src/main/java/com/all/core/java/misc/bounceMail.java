package com.all.core.java.misc;

import java.util.Properties;
import java.util.logging.Logger;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;


//Code used to send mail
public class bounceMail {

	private static final Logger logger = Logger.getLogger(bounceMail.class.getName());
	String host, port, emailid, username, password;
	Properties props = System.getProperties();
	Session l_session = null;
	Session l_session1 = null;

	public void sendMessage(String toEmail, String subject, String msg) {

		host = "smtp.mail.yahoo.com";
		port = "465";
		emailid = "anuragvasubhartijobs@yahoo.com";
		username = "anuragvasubhartijobs@yahoo.com";
		password = "change_password";
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		// props.put("mail.debug", "true");
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.socketFactory.port", port);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		// props.put("mail.smtp.from", "bounceemailid"); // not working
		l_session = Session.getInstance(props, new jakarta.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		// l_session.setDebug(true); // Enable the debug mode
		try {
			MimeMessage message = new MimeMessage(l_session);
			// message.addFrom(InternetAddress.parse("bounceemail@yahoo.com")); // not
			// working
			// message.setReplyTo(InternetAddress.parse("bounceemail@yahoo.com")); // not
			// working
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
			message.setSubject(subject);
			message.setContent(msg, "text/html");
			Transport.send(message);
			System.out.println("Message Sent");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static public void main(String args[]) {
		bounceMail b = new bounceMail();
		b.sendMessage("anuragvasubhartijobs@yahoo.com", "Test", "test Mail");
	}
}
