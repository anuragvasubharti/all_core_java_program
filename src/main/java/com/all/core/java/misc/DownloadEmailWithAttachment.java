package com.all.core.java.misc;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import jakarta.mail.Folder;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.Part;
import jakarta.mail.Session;
import jakarta.mail.Store;

public class DownloadEmailWithAttachment {

	public static void main(String args[]) throws Exception {

		// gmail pop3 host name
		String host = "pop.gmail.com";
		// your email id like nayanrami@gmail.com
		String username = "anuragvasubharti@gmail.com"; // Put here Gmail Username without @ sign
		// Your Email Password For Account
		String password = "change_password";

		Session session = Session.getInstance(new Properties(), null);
		Store store = session.getStore("pop3s");
		store.connect(host, username, password);

		// Your INBOX Folder --->>
		Folder folder = store.getFolder("INBOX");

		folder.open(Folder.READ_ONLY);

		Message message[] = folder.getMessages();

		for (int i = 0; i < message.length; i++) {
			System.out.println(i + ": " + message[i].getFrom()[0] + "\t" + message[i].getSubject());
			System.out.println("Wanted the content? [Y to read/Q to end]");
			String ans = "y";
			ans = ans.toLowerCase();
			if ("y".equals(ans)) {
				Object content = message[i].getContent();
				if (content instanceof Multipart) {
					handleMultipart((Multipart) content);
				} else {
					handlePart(message[i]);
				}
			} else if ("q".equals(ans)) {
				break;
			}
		}
		folder.close(false);
		store.close();
	}

	public static void handleMultipart(Multipart multipart) throws MessagingException, IOException {
		for (int i = 0; i < multipart.getCount(); i++) {
			handlePart(multipart.getBodyPart(i));
		}
	}

	public static void handlePart(Part part) throws MessagingException, IOException {
		String dposition = part.getDisposition();
		String cType = part.getContentType();
		if (dposition == null) {
			System.out.println("Null+ cType");
			if ((cType.length() >= 10) && (cType.toLowerCase().substring(0, 10).equals("text/plain"))) {
				part.writeTo(System.out);
			} else {
				System.out.println("Other: " + cType);
				part.writeTo(System.out);
			}
		} else if (dposition.equalsIgnoreCase(Part.ATTACHMENT)) {
			System.out.println("Attachment part.getFileName()" + " : " + cType);
			saveFile(part.getFileName(), part.getInputStream());
		} else if (dposition.equalsIgnoreCase(Part.INLINE)) {
			System.out.println("Inline part.getFileName()" + " : " + cType);
			saveFile(part.getFileName(), part.getInputStream());
		} else {
			System.out.println("Other dposition");
		}
	}

	public static void saveFile(String filename, InputStream input) throws IOException {
		if (filename == null) {
			filename = File.createTempFile("MailAttacheFile", ".out").getName();
		}
		System.out.println("Downloading Attachment...");
		File file = new File(filename);
		for (int i = 0; file.exists(); i++) {
			file = new File(filename + i);
		}
		FileOutputStream fos = new FileOutputStream(file);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		BufferedInputStream bis = new BufferedInputStream(input);
		int fByte;
		while ((fByte = bis.read()) != -1) {
			bos.write(fByte);
		}
		bos.flush();
		bos.close();
		bis.close();
		System.out.println("Downloaded Attachment...");
	}
}
