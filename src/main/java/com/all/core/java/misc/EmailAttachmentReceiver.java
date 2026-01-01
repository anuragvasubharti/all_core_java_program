package com.all.core.java.misc;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import jakarta.mail.Address;
import jakarta.mail.Folder;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.NoSuchProviderException;
import jakarta.mail.Part;
import jakarta.mail.Session;
import jakarta.mail.Store;
import jakarta.mail.internet.MimeBodyPart;

/**
 * This program demonstrates how to download e-mail messages and save
 * attachments into files on disk.
 *
 * @author www.codejava.net
 *
 */
public class EmailAttachmentReceiver {
	private String saveDirectory;

	/**
	 * Sets the directory where attached files will be stored.
	 * 
	 * @param dir absolute path of the directory
	 */
	public void setSaveDirectory(String dir) {
		this.saveDirectory = dir;
	}

	/**
	 * Downloads new messages and saves attachments to disk if any.
	 * 
	 * @param host
	 * @param port
	 * @param userName
	 * @param password
	 */
	public void downloadEmailAttachments(String host, String port, String userName, String password) {
		Properties properties = new Properties();
		properties.setProperty("mail.store.protocol", "imaps");

		// server setting
		// properties.put("mail.pop3.host", host);
		// properties.put("mail.pop3.port", port);

		// SSL setting
		// properties.setProperty("mail.pop3.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		// properties.setProperty("mail.pop3.socketFactory.fallback", "false");
		// properties.setProperty("mail.pop3.socketFactory.port",String.valueOf(port));

		// Session session = Session.getDefaultInstance(properties);
		Session session = Session.getDefaultInstance(properties, null);

		try {
			// connects to the message store
			// Store store = session.getStore("pop3");
			// store.connect(userName, password);

			Store store = session.getStore("imaps");
			store.connect("imap.gmail.com", "anuragvasubharti@gmail.com", "change_password");

			System.out.println(store);

			Folder[] folders = store.getDefaultFolder().list("*");
			for (Folder folder : folders) {
				if ((folder.getType() & Folder.HOLDS_MESSAGES) != 0) {
					// if ((folder.getType() & Folder.HOLDS_FOLDERS) != 0) {
					System.out.println(folder.getFullName() + ": " + folder.getMessageCount());
				}
			}

			// opens the inbox folder
			Folder folderInbox = store.getFolder("INBOX");
			// folderInbox.open(Folder.READ_ONLY);
			folderInbox.open(Folder.READ_WRITE);

			// fetches new messages from server
			Message[] arrayMessages = folderInbox.getMessages();
			System.out.println("MAILS: " + arrayMessages.length);

			for (int i = 0; i < arrayMessages.length; i++) {
				Message message = arrayMessages[i];
				Address[] fromAddress = message.getFrom();
				String from = fromAddress[0].toString();
				String subject = message.getSubject();
				String sentDate = message.getSentDate().toString();

				String contentType = message.getContentType();
				String messageContent = "";

				// store attachment file name, separated by comma
				String attachFiles = "";

				if (contentType.contains("multipart")) {
					// content may contain attachments
					Multipart multiPart = (Multipart) message.getContent();
					int numberOfParts = multiPart.getCount();
					for (int partCount = 0; partCount < numberOfParts; partCount++) {
						MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
						if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
							// this part is attachment
							String fileName = part.getFileName();
							attachFiles += fileName + ", ";
							part.saveFile(saveDirectory + File.separator + fileName);
						} else {
							// this part may be the message content
							messageContent = part.getContent().toString();
						}
					}

					if (attachFiles.length() > 1) {
						attachFiles = attachFiles.substring(0, attachFiles.length() - 2);
					}
				} else if (contentType.contains("text/plain") || contentType.contains("text/html")) {
					Object content = message.getContent();
					if (content != null) {
						messageContent = content.toString();
					}
				}

				// print out details of each message
				System.out.println("Message #" + (i + 1) + ":");
				System.out.println("\t From: " + from);
				System.out.println("\t Subject: " + subject);
				System.out.println("\t Sent Date: " + sentDate);
				// System.out.println("\t Message: " + messageContent);
				System.out.println("\t Attachments: " + attachFiles);
			}

			// disconnect
			folderInbox.close(false);
			store.close();
		} catch (NoSuchProviderException ex) {
			System.out.println("No provider for pop3.");
			ex.printStackTrace();
		} catch (MessagingException ex) {
			System.out.println("Could not connect to the message store");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Runs this program with Gmail POP3 server
	 */
	public static void main(String[] args) {
		String host = "pop.gmail.com";
		String port = "995";
		String userName = "anuragvasubharti";
		String password = "change_password";

		String saveDirectory = "D:/AnuragAttachment";

		EmailAttachmentReceiver receiver = new EmailAttachmentReceiver();
		receiver.setSaveDirectory(saveDirectory);
		receiver.downloadEmailAttachments(host, port, userName, password);

	}
}