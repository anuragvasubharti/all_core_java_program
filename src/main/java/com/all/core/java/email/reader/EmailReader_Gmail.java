package com.all.core.java.email.reader;

import java.util.Properties;
import java.util.logging.Logger;

import jakarta.mail.Address;
import jakarta.mail.AuthenticationFailedException;
import jakarta.mail.Folder;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.NoSuchProviderException;
import jakarta.mail.Session;
import jakarta.mail.Store;
import jakarta.mail.internet.InternetAddress;
//https://myaccount.google.com/u/1/apppasswords?pli=1&rapt=AEjHL4Mg2xYwCllQKS3US6zdqUrMHAHd5EgC7p8fJK2yNPe1URQb10eDZNuNtS7CWQhbTACYm5VSa4ElVp_fcoVggl8D3-d324gI9FycWw-uxXbLd7GpgGk

public class EmailReader_Gmail {
	
	private static final Logger logger = Logger.getLogger(EmailReader_Gmail.class.getName());
	
	public static void main(String[] args) {
		
		logger.info("this is a information log message");
		String host = "imap.gmail.com";
		String username = "clouddevopsrecruitment@gmail.com"; // 🔁 Replace with your Gmail ID
		String password = "vasu2516vasu"; // 🔁 Replace with Gmail App Password
		// Set properties for Gmail IMAP with SSL
		Properties props = new Properties();
		props.put("mail.store.protocol", "imaps");
		props.put("mail.imaps.host", host);
		props.put("mail.imaps.port", "993");
		props.put("mail.imaps.ssl.enable", "true");
		logger.info("Session ---------------------> " + props);
		
		try {
			// Create session and connect to Gmail
			Session session = Session.getInstance(props);
			Store store = session.getStore("imaps");
			store.connect(username, password);
			// Open inbox
			Folder inbox = store.getFolder("INBOX");
			inbox.open(Folder.READ_ONLY);
			// Fetch messages
			Message[] messages = inbox.getMessages();
			System.out.println("Total Messages: " + messages.length);
			// Print sender email IDs
			for (int i = 0; i < messages.length; i++) {
				Message msg = messages[i];
				Address[] froms = msg.getFrom();
				String sender = froms == null ? null : ((InternetAddress) froms[0]).getAddress();
				System.out.println("Email " + (i + 1) + " from: " + sender);
			}
			// Close connections
			inbox.close(false);
			store.close();
		} catch (NoSuchProviderException e) {
			System.err.println("IMAPS protocol not found. Make sure jakarta.mail jar is in classpath.");
			e.printStackTrace();
		} catch (AuthenticationFailedException e) {
			System.err.println("Authentication failed. Check your email/password or App Password.");
			e.printStackTrace();
		} catch (MessagingException e) {
			System.err.println("Messaging error occurred.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
