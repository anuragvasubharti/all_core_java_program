package com.all.core.java.misc;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Properties;
import java.util.logging.Logger;

import jakarta.mail.Flags;
import jakarta.mail.Folder;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.NoSuchProviderException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Store;
import jakarta.mail.search.FlagTerm;

//read the mail
public class CheckingMail {

	private static final Logger logger = Logger.getLogger(CheckingMail.class.getName());

	public static void check(String host, String storeType, String user, String password) {
		try {

			// create properties field
			Properties properties = new Properties();
			properties.put("mail.imap.host", host);
			properties.put("mail.imap.port", "993");
			properties.put("mail.imap.starttls.enable", "true");
			Session emailSession = Session.getDefaultInstance(properties);

			Session session = Session.getInstance(properties, new jakarta.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("anuragvasubhartijobs@yahoo.com", "change_password");
				}
			});
			System.out.println("session " + session);

			Store store = emailSession.getStore("imaps");
			store.connect(host, user, password);

			// create the folder object and open it
			Folder emailFolder = store.getFolder("MAILER-DAEMON");
			emailFolder.open(Folder.READ_ONLY);

			// retrieve the messages from the folder in an array and print it
			Message[] messages = emailFolder.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
			System.out.println("messages.length --- " + messages.length);
			int bcnt = 0;

			String str, filename = null;
			int index = 0;
			for (int i = 0, n = messages.length; i < n; i++) {
				Message message = messages[i];
				System.out.println("---> " + message.getFrom()[0].toString());
				System.out.println("---q->" + message.getContent().toString());
				/*
				 * if(message.getFrom()[0].toString().contains("MAILER-DAEMON")){ bcnt++; }
				 */

				BufferedReader reader = new BufferedReader(new StringReader(message.getContent().toString()));
				while ((str = reader.readLine()) != null) {
					index = str.indexOf("filename");
					if (index > -1) {
						filename = str.substring(index + 9); // 9 characters -> "filename="
						if (filename.length() > 0)
							System.out.println("Attachment  : " + filename);
					}
				}
				System.out.println("---------------------------------");
				System.out.println("Email Number " + (i + 1));
				System.out.println("Subject: " + message.getSubject());
				System.out.println("From: " + message.getFrom()[0]);

				Object content = message.getContent();
				if (content instanceof String)
					System.out.println("String");

				if (content instanceof Multipart) {
					Multipart multipart = (Multipart) content;
					for (int j = 0; j < multipart.getCount(); j++) {
						System.out.println(multipart.getBodyPart(j).getFileName());
					}
				}

				for (int j = 0; j < message.getAllRecipients().length; j++) {
					System.out.println("Recipients " + j + " : " + message.getAllRecipients()[j]);
				}
				System.out.println("Date: " + message.getSentDate());
			}
			System.out.println("Bounce count : " + bcnt);

			// close the store and folder objects
			emailFolder.close(false);
			store.close();

		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String host = "imap.mail.yahoo.com";
		String mailStoreType = "imap";
		String username = "anuragvasubhartijobs@yahoo.com";
		String password = "change_password";
		check(host, mailStoreType, username, password);

	}

}
