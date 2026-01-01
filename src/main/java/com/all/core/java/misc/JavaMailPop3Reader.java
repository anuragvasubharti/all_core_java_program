package com.all.core.java.misc;

import java.util.Properties;

import jakarta.mail.Folder;
import jakarta.mail.Message;
import jakarta.mail.Session;
import jakarta.mail.Store;

public class JavaMailPop3Reader {
	
	public static void main(String args[]) throws Exception {
		/*
		 * Incoming Mail Server (POP3): pop.mail.yahoo.com (Use SSL, port: 995) Outgoing
		 * Mail Server (SMTP): smtp.mail.yahoo.com (Use SSL, port: 465, use
		 * authentication) Account Name/Username: <Your Yahoo Mail address> Email
		 * address: <Your Yahoo <Your Yahoo Mail password>
		 */
		// mail server connection parameters
		String host = "pop.mail.yahoo.com";
		String user = "anuragvasubharti";
		String password = "change_password";
		// connect to my pop3 inbox
		Properties properties = System.getProperties();
		Session session = Session.getDefaultInstance(properties);
		Store store = session.getStore("pop3");
		store.connect(host, 995, user, password);
		Folder inbox = store.getFolder("Inbox");
		System.out.println("inbox " + inbox);
		inbox.open(Folder.READ_ONLY);
		// get the list of inbox messages
		Message[] messages = inbox.getMessages();
		if (messages.length == 0)
			System.out.println("No messages found.");
		for (int i = 0; i < messages.length; i++) {
			// stop after listing ten messages
			if (i > 10) {
				System.exit(0);
				inbox.close(true);
				store.close();
			}
			System.out.println("Message " + (i + 1));
			System.out.println("From : " + messages[i].getFrom()[0]);
			System.out.println("Subject : " + messages[i].getSubject());
			System.out.println("Sent Date : " + messages[i].getSentDate());
			System.out.println();
		}
		inbox.close(true);
		store.close();
	}
}
