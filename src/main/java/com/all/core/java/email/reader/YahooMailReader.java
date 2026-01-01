package com.all.core.java.email.reader;

import java.util.Properties;
import java.util.logging.Logger;

import jakarta.mail.BodyPart;
import jakarta.mail.Folder;
import jakarta.mail.Message;
import jakarta.mail.Session;
import jakarta.mail.Store;
import jakarta.mail.internet.MimeMultipart;

public class YahooMailReader {

	private static final Logger logger = Logger.getLogger(YahooMailReader.class.getName());

	public static void main(String[] args) {

		// Set up mail server properties
		Properties properties = new Properties();
		properties.put("mail.store.protocol", "imaps");
		properties.put("mail.imaps.host", "imap.mail.yahoo.com");
		properties.put("mail.imaps.port", "993");
		properties.put("mail.imaps.ssl.enable", "true");
		// Get the session object

		Session session = Session.getDefaultInstance(properties);
		try {
			// Connect to the Yahoo Mail server
			Store store = session.getStore("imaps");
			store.connect("imap.mail.yahoo.com", "anuragvasubhartijobs", "pnuxnbipbanwrhoi");
			// Open the inbox folder
			Folder inbox = store.getFolder("INBOX");
			inbox.open(Folder.READ_ONLY);
			// Fetch messages from the server
			Message[] messages = inbox.getMessages();
			// Iterate through the messages
			for (int i = 0; i < messages.length; i++) {
				Message message = messages[i];
				System.out.println("Email Number " + (i + 1));
				System.out.println("Subject: " + message.getSubject());
				System.out.println("From: " + message.getFrom()[0]);
				System.out.println("Text: " + getTextFromMessage(message));
				System.out.println("---------------------------------");
			}
			// Close the store and folder objects
			inbox.close(false);
			store.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Helper method to get the text content of a message
	private static String getTextFromMessage(Message message) throws Exception {

		String result = "";
		if (message.isMimeType("text/plain")) {
			result = message.getContent().toString();
		} else if (message.isMimeType("multipart/*")) {
			MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
			result = getTextFromMimeMultipart(mimeMultipart);
		}
		return result;
	}

	private static String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws Exception {

		StringBuilder result = new StringBuilder();
		int count = mimeMultipart.getCount();
		for (int i = 0; i < count; i++) {
			BodyPart bodyPart = mimeMultipart.getBodyPart(i);
			if (bodyPart.isMimeType("text/plain")) {
				result.append(bodyPart.getContent());
				break;
			} else if (bodyPart.isMimeType("text/html")) {
				String html = (String) bodyPart.getContent();
				result.append(org.jsoup.Jsoup.parse(html).text());
			}
		}
		return result.toString();
	}
}
