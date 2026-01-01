package com.all.core.java.misc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import jakarta.mail.Address;
import jakarta.mail.Folder;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.NoSuchProviderException;
import jakarta.mail.Session;
import jakarta.mail.Store;
/**
 * My JavaMail email address extractor. A JavaMail API example.
 * 
 * @author https://alvinalexander.com/blog/post/java/i-need-get-all-of-my-email-addresses-out-of-imap-mailbox
 */
public class AddressExtractor {

	static int countGetFrom = 0;
	static int countRemoveQuotes = 0;

	public static void main(String[] args) {

		Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", "imaps");
		// Properties props = new Properties();
		// String host = args[0];
		// String username = args[1];
		// String password = args[2];
		// String provider = "pop3";
		String provider = "imaps";

		try {
			// Connect to the server
			Session session = Session.getDefaultInstance(props, null);
			Store store = session.getStore(provider);
			store.connect("imap.mail.yahoo.com", "anuragvasubharti", "change_password");

			// open the inbox folder
			Folder folder = store.getFolder("MAILER-DAEMON");
			folder.open(Folder.READ_ONLY);

			// get a list of javamail messages as an array of messages
			Message[] messages = folder.getMessages();

			ArrayList arrayList = new ArrayList();

			// TreeSet treeSet = new TreeSet();
			System.out.println("messages.length " + messages.length);
			// for (int i = 0; i < messages.length; i++) {
			for (int i = 0; i < 999; i++) {
				String from = getFrom(messages[i]);
				// System.out.println("Out if form " + from);
				if (from != null) {
					from = removeQuotes(from);
					// System.out.println("In if form " + from);
					// treeSet.add(from);
					arrayList.add(from);
				}
			}

			// The name of the file to write.
			String fileNameOut = "D:\\workspaceKepler\\CoreJavaPoject\\src\\YahooEmailAnurag.txt";
			// Assume default encoding.
			FileWriter fileWriter = new FileWriter(fileNameOut);

			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			Iterator it = arrayList.iterator();
			// Iterator it = treeSet.iterator();
			while (it.hasNext()) {
				System.out.println("from: " + it.next());
				String str = (String) it.next();
				bufferedWriter.write(str + ";");
				bufferedWriter.newLine();
			}

			// Always close files.
			bufferedWriter.close();
			// close the inbox folder but do not
			// remove the messages from the server
			folder.close(false);
			store.close();
		} catch (IOException e) {
			System.err.println("Exception");
		} catch (NoSuchProviderException nspe) {
			System.err.println("invalid provider name");
		} catch (MessagingException me) {
			System.err.println("messaging exception");
			me.printStackTrace();
		}
	}

	private static String getFrom(Message javaMailMessage) throws MessagingException {
		String from = "";
		Address a[] = javaMailMessage.getFrom();
		if (a == null)
			return null;
		// System.out.println("Address "+ a.length);
		for (int i = 0; i < a.length; i++) {
			Address address = a[i];
			// System.out.println("address " + address);
			// System.out.println("address.toString() " +address.toString());
			// System.out.println("from1 " + from);
			from = from + address.toString();
			System.out.println("from2 " + from);
			countGetFrom++;
		}
		System.out.println("countGetFrom: " + countGetFrom);
		return from;
	}

	private static String removeQuotes(String stringToModify) {
		// System.out.println("stringToModify " + stringToModify);
		int indexOfFind = stringToModify.indexOf(stringToModify);
		// System.out.println("indexOfFind " + indexOfFind);
		if (indexOfFind < 0)
			return stringToModify;

		StringBuffer oldStringBuffer = new StringBuffer(stringToModify);
		StringBuffer newStringBuffer = new StringBuffer();
		for (int i = 0, length = oldStringBuffer.length(); i < length; i++) {
			char c = oldStringBuffer.charAt(i);
			if (c == '"' || c == '\'') {
				// do nothing
				// System.out.println("//do nothing");
			} else {
				newStringBuffer.append(c);
				// System.out.println("append(c)" + newStringBuffer);
				countRemoveQuotes++;
			}

		}
		// System.out.println("countRemoveQuotes: "+ countRemoveQuotes);
		return new String(newStringBuffer);
	}

}