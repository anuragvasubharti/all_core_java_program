package com.all.core.java.email.reader;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.SortTerm;

import jakarta.mail.BodyPart;
import jakarta.mail.Flags;
import jakarta.mail.Folder;
import jakarta.mail.Header;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.Part;
import jakarta.mail.Session;
import jakarta.mail.Store;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.search.AndTerm;
import jakarta.mail.search.DateTerm;
import jakarta.mail.search.FlagTerm;
import jakarta.mail.search.FromTerm;
import jakarta.mail.search.NotTerm;
import jakarta.mail.search.OrTerm;
import jakarta.mail.search.ReceivedDateTerm;
import jakarta.mail.search.SearchTerm;
import jakarta.mail.search.SubjectTerm;

/**
 * @author PRITOM
 * @date 2016-11-25
 */
public class ReadEmailFromServer {

	private static final Logger logger = Logger.getLogger(ReadEmailFromServer.class.getName());
	
	public static void main(String[] args) {

		// gmail();
		// bleep();
		yahoo();
		// office();
	}

	private static void office() {

		String PROTOCOL = "imaps", HOST = "outlook.office365.com", USER = "xxxxx@outlook.com", PASSWORD = "xxxxx",
				ENCRYPTION_TYPE = "tls", PORT = "993";
		readEmail(PROTOCOL, HOST, USER, PASSWORD, ENCRYPTION_TYPE, PORT);
	}

	private static void yahoo() {

		String PROTOCOL = "imaps", HOST = "mail.yahoo.com", USER = "anuragvasubharti@yahoo.com",
				PASSWORD = "Vasu2516Vasu", ENCRYPTION_TYPE = "tls", PORT = "993";
		readEmail(PROTOCOL, HOST, USER, PASSWORD, ENCRYPTION_TYPE, PORT);
	}

	private static void bleep() {

		String PROTOCOL = "imaps", HOST = "bleep.xxxxx.com", USER = "pritom@xxxxx.com", PASSWORD = "xxxxx",
				ENCRYPTION_TYPE = "tls", PORT = "993";
		readEmail(PROTOCOL, HOST, USER, PASSWORD, ENCRYPTION_TYPE, PORT);
	}

	private static void gmail() {

		String PROTOCOL = "imaps", HOST = "imap.gmail.com", USER = "anuragvasubharti@gmail.com",
				PASSWORD = "Vasu2516Vasu", ENCRYPTION_TYPE = "tls", PORT = "993";
		readEmail(PROTOCOL, HOST, USER, PASSWORD, ENCRYPTION_TYPE, PORT);
	}

	private static void readEmail(String PROTOCOL, String HOST, String USER, String PASSWORD, String ENCRYPTION_TYPE,
			String PORT) {

		Properties props = new Properties();
		props.setProperty("mail.store.protocol", PROTOCOL);

		if (ENCRYPTION_TYPE.length() > 0 && ENCRYPTION_TYPE.equalsIgnoreCase("none")) {

			if (PROTOCOL.equalsIgnoreCase("imap")) {

				props.setProperty("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				props.setProperty("mail.imap.socketFactory.fallback", "false");
				props.setProperty("mail.imap.ssl.enable", "true");
				props.setProperty("mail.imap.socketFactory.port", PORT.length() > 0 ? PORT : "993");
				if (ENCRYPTION_TYPE.equalsIgnoreCase("tls")) {
					props.setProperty("mail.imap.starttls.enable", "true");
				}
			} else if (PROTOCOL.equalsIgnoreCase("pop3")) {

				props.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
				props.setProperty("mail.pop3.socketFactory.fallback", "false");
				props.setProperty("mail.pop3.ssl.enable", "true");
				props.setProperty("mail.pop3.socketFactory.port", PORT.length() > 0 ? PORT : "995");
				if (ENCRYPTION_TYPE.equalsIgnoreCase("tls")) {
					props.setProperty("mail.pop3.starttls.enable", "true");
				}
			}
		}
		try {
			Session session = Session.getInstance(props, null);
			Store store = session.getStore();
			store.connect(HOST, USER, PASSWORD);
			printAllFolders(store);
			IMAPFolder inbox = (IMAPFolder) store.getFolder("INBOX");
			inbox.open(Folder.READ_ONLY);
			SortTerm[] sortTerms = new SortTerm[1];
			System.out.println("sortTerms: " + sortTerms.length);
			System.out.println("SortTerm.ARRIVAL: " + SortTerm.ARRIVAL);
			sortTerms[0] = SortTerm.ARRIVAL;
			System.out.println("sortTerms[0]: " + sortTerms[0].toString());
			Message[] messages = inbox.getSortedMessages(sortTerms, getSearchCriteria());
			int maxReadNumber = 1;
			int total = messages.length > maxReadNumber ? maxReadNumber : messages.length;
			println("\nTotal_Email = " + messages.length);
			boolean ascending = false;

			for (int index = 0; index < total; index++) {

				int message_index = ascending ? index : messages.length - index - 1;
				Message message = messages[message_index];
				String subject = message.getSubject();
				println("-------------------------------------------------------------------------------------------");
				println("-------------------------------------------------------------------------------------------");
				println("------------------" + (index + 1) + "/" + messages.length + "----------------------"
						+ subject);
				println("-------------------------------------------------------------------------------------------");
				println("-------------------------------------------------------------------------------------------");
				printAllHeaders(message);

				if (message.getContent() instanceof String) {

					println("\tContent---------------Type=" + message.getContentType());
					String body = message.getContent().toString();
					body = body.length() > 100 ? body.substring(0, 100) + "..." : body;
					println("\t\t" + toSingleLine(body));

				} else {

					Map output = processMultipart((Multipart) message.getContent());
					Object[] keys = output.keySet().toArray();
					for (int i = 0; i < keys.length; i++) {
						println("\t" + keys[i].toString().toUpperCase()
								+ "-------------------------------------------");
						if (keys[i].toString() == "attachments") {

							List attachments = (List) output.get("attachments");
							for (int j = 0; j < attachments.size(); j++) {
								Map attachment = (Map) attachments.get(j);
								/* You can save attachments to your local machine by uncomment line below */
								// String toFile = saveFileFromEmailAttachment(attachment);
								// println("File_Saved_To=" + toFile);
								println("\t\tFile_Name=" + attachment.get("fileName"));
							}
						} else {

							String body = output.get(keys[i].toString()).toString().trim();
							body = body.length() > 100 ? body.substring(0, 100) + "..." : body;
							println("\t\t[[[" + toSingleLine(body) + "]]]");
						}
					}
				}
				if (total == index + 1) {
					println("-------------------------------------------------------------------------------------------");
					println("-------------------------------------------------------------------------------------------");
					println("-------------------------------------------------------------------------------------------");
				}
			}
			inbox.close(false);
			store.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static void printAllFolders(Store store) throws Exception {

		println("Folders:::");
		Folder[] folders = store.getDefaultFolder().list();
		for (Folder folder : folders) {
			println("\t" + folder.getFullName());
			for (Folder subFolder : folder.list()) {
				println("\t\t" + subFolder.getFullName());
			}
		}
	}

	private static void printAllHeaders(Message message) throws Exception {

		Enumeration enumeration = message.getAllHeaders();
		while (enumeration.hasMoreElements()) {
			Header header = (Header) enumeration.nextElement();
			boolean show = header.getName().equals("Received");
			show = show && header.getName().startsWith("DKIM-");
			if (show) {
				println("\t" + header.getName() + "===" + toSingleLine(header.getValue()));
			}
		}
	}

	private static SearchTerm getSearchCriteria() throws Exception {

		if (true) {
			// return null;
			// return new FlagTerm(new Flags(Flags.Flag.SEEN), false);
			// return new
			// MessageIDTerm("CAD-oc7fMFqioVurtMPnGm63mWAA51wELBaLhtm38zvthTv0+DQ@mail.gmail.com");
		}

		FlagTerm unread = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
		FromTerm fromTerm = new FromTerm(new InternetAddress("pritomkucse@gmail.com"));
		Calendar cal = Calendar.getInstance();
		/* Set date to 1 day back from now */
		cal.roll(Calendar.DATE, false);
		ReceivedDateTerm latest = new ReceivedDateTerm(DateTerm.GT, cal.getTime());
		SearchTerm andTerm = new AndTerm(unread, latest);
		SearchTerm notFromTerm = new NotTerm(new FromTerm(new InternetAddress("black_listed_domain.com")));
		SubjectTerm subjectTerm = new SubjectTerm("Notable");
		OrTerm orTerm = new OrTerm(fromTerm, new OrTerm(andTerm, subjectTerm));
		AndTerm andTerm1 = new AndTerm(orTerm, notFromTerm);

		/**
		 * (FROM_pritomkucse@gmail.com OR (NOT_REED AND YESTERDAY) OR
		 * SUBJECT_CONTAINS_Notable) AND NOT_FROM_*@black_listed_domain.com
		 */
		
		/* Custom search term, actually download email from server then check (slow) */
		SearchTerm searchTerm = new SearchTerm() {

			@Override
			public boolean match(Message message) {
				try {
					if (message.getSubject().contains("forwarding")) {
						return true;
					}
				} catch (MessagingException ex) {
					ex.printStackTrace();
				}
				return false;
			}
		};
		return andTerm1;
	}

	private static String saveFileFromEmailAttachment(Map attachment) {

		try {
			File dir = createAndGetDirectory();
			String fileName = attachment.get("fileName").toString();
			File toFile = new File(dir, fileName);
			MimeBodyPart mimeBodyPart = (MimeBodyPart) attachment.get("mimeBodyPart");
			mimeBodyPart.saveFile(toFile);
			return toFile.getAbsolutePath();

		} catch (Exception e) {

			e.printStackTrace();
			return e.getMessage();
		}
	}

	private static File createAndGetDirectory() {

		File file = new File("attachments");
		if (file.exists()) {
			file.mkdir();
		}
		return file;
	}

	private static Map processMultipart(Multipart multipart) throws Exception {

		Map output = new HashMap();
		output.put("html", "");
		output.put("text", "");
		List attachments = new ArrayList();
		for (int i = 0; i < multipart.getCount(); i++) {
			Map result = processBodyPart(multipart.getBodyPart(i));
			if (result != null) {
				if (result.containsKey("type")) {
					if (result.get("type").toString().equalsIgnoreCase("html")) {
						output.put("html", result.get("content").toString());
					} else if (result.get("type").toString().equalsIgnoreCase("text")) {
						output.put("text", result.get("content").toString());
					} else if (result.get("type").toString().equalsIgnoreCase("attachment")) {
						attachments.add(result);
					}
				}
				if (result.containsKey("html")) {
					output.put("html", result.get("html").toString());
				}
				if (result.containsKey("text")) {
					output.put("text", result.get("text").toString());
				}
				if (result.containsKey("attachments")) {
					List thisAttachments = (List) result.get("attachments");
					for (int i2 = 0; i2 < thisAttachments.size(); i2++) {
						attachments.add(thisAttachments.get(i2));
					}
				}
			}
		}
		output.put("attachments", attachments);
		return output;
	}

	private static Map processBodyPart(BodyPart bodyPart) throws Exception {

		if (bodyPart.isMimeType("text/html") && bodyPart.getFileName() == null) {

			Map data = new HashMap();
			data.put("type", "html");
			data.put("content", bodyPart.getContent().toString());
			return data;
		} else if (bodyPart.isMimeType("text/plain") && bodyPart.getFileName() == null) {

			Map data = new HashMap();
			data.put("type", "text");
			data.put("content", bodyPart.getContent().toString());
			return data;
		} else if (Part.ATTACHMENT.equalsIgnoreCase(bodyPart.getDisposition()) && bodyPart.getFileName() != null) {

			try {
				Map map = new HashMap();
				map.put("type", "attachment");
				map.put("fileName", bodyPart.getFileName());
				String fileType = bodyPart.getContentType();
				map.put("fileType", fileType.contains(":") ? fileType.substring(0, fileType.indexOf(";")) : fileType);
				map.put("mimeBodyPart", bodyPart);
				return map;
			} catch (Exception ex) {

				println("Error_Content=" + bodyPart.getContentType());
				ex.printStackTrace();
			}
		} else if (bodyPart.getContentType().contains("multipart")) {

			Map o = processMultipart((Multipart) bodyPart.getContent());
			return o;
		}
		return null;
	}

	private static String toSingleLine(String str) throws Exception {

		return str.replaceAll("\\s+", " ");
	}

	private static void println(Object o) {

		System.out.println(o);
	}
}
