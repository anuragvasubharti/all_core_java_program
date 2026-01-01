package com.all.core.java.email.reader;

import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.mail.BodyPart;
import jakarta.mail.Folder;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Store;
import jakarta.mail.internet.MimeMultipart;

public class EmailReaderNew {
	
	private static final Logger logger = Logger.getLogger(EmailReaderNew.class.getName());
	
	private static final Properties properties = new Properties();

	static {
		
		try {
			properties.put("mail.store.protocol", "imaps");
			properties.put("mail.imaps.host", "imap.mail.yahoo.com");
			properties.put("mail.imaps.port", "993");
			properties.put("mail.imaps.ssl.enable", "true");
			
		} catch (ExceptionInInitializerError e) {
			throw new ExceptionInInitializerError();
		}
	}

	public static void main(String[] args) {
		
		long startTime = System.nanoTime();
		
		try {
			Session session = Session.getDefaultInstance(properties);
			Store store = session.getStore("imaps");
			store.connect("imap.mail.yahoo.com", "sakshivirhajobsearch", "wqnveteyywqsdzmp");
			// store.connect("imap.mail.yahoo.com", "anuragvasubhartijobs",
			// "pnuxnbipbanwrhoi");

			Folder[] folders = store.getDefaultFolder().list("*");
			// System.out.println("Folder and Sub Folder Names and inside Mail Counts are");
			for (Folder folder : folders) {
				if ((folder.getType() & Folder.READ_WRITE) != 0) {
					// System.out.println("Folder: " + folder.getFullName().toString().trim() + ": "
					// + folder.getMessageCount());
				}
			}

			// Yahoo Sakshi

			// Folder folderName = store.getFolder("0-Edureka");
			// Folder folderName = store.getFolder("0-NaukriService-2024");
			// Folder folderName = store.getFolder("000-Delay");
			// Folder folderName = store.getFolder("000-Failure");
			// Folder folderName = store.getFolder("000-Mail Delivery Failure");
			// Folder folderName = store.getFolder("000-Mail delivery failed");
			// Folder folderName = store.getFolder("000-Random");
			// Folder folderName = store.getFolder("000-Returned mail");
			// Folder folderName = store.getFolder("000-Undeliverable");
			// Folder folderName = store.getFolder("000-Undelivered");
			// Folder folderName = store.getFolder("000-Your message");
			// Folder folderName = store.getFolder("000-mailer-daemon");

			// Folder folderName = store.getFolder("001-Failure Notice");
			// Folder folderName = store.getFolder("002-Failure Notice");
			// Folder folderName = store.getFolder("003-Failure Notice");
			// Folder folderName = store.getFolder("004-Failure Notice");
			// Folder folderName = store.getFolder("005-Failure Notice");
			// Folder folderName = store.getFolder("006-Failure Notice");
			// Folder folderName = store.getFolder("007-Failure Notice");
			// Folder folderName = store.getFolder("008-Failure Notice");
			// Folder folderName = store.getFolder("009-Failure Notice");
			// Folder folderName = store.getFolder("010-Failure Notice");
			// Folder folderName = store.getFolder("011-Failure Notice");
			// Folder folderName = store.getFolder("012-Failure Notice");

			// Folder folderName = store.getFolder("2022");
			// Folder folderName = store.getFolder("2023");
			// Folder folderName = store.getFolder("2024");

			// Folder folderName = store.getFolder("Archive");
			// Folder folderName = store.getFolder("Bulk");
			// Folder folderName = store.getFolder("Debarati Ray");
			// Folder folderName = store.getFolder("Deepak Sati");
			// Folder folderName = store.getFolder("Draft");
			// Folder folderName = store.getFolder("Experience documents");
			// Folder folderName = store.getFolder("GitHub");

			Folder folderName = store.getFolder("Inbox");
			// Folder folderName = store.getFolder("Sent");

			// Folder folderName = store.getFolder("MySent-2024-1");
			// Folder folderName = store.getFolder("MySent-2024-2");
			// Folder folderName = store.getFolder("MySent-2024-3");

			// Folder folderName = store.getFolder("Temp-1");
			// Folder folderName = store.getFolder("Temp-2");
			// Folder folderName = store.getFolder("Temp-3");
			// Folder folderName = store.getFolder("Temp-4");
			// Folder folderName = store.getFolder("Temp-5");
			// Folder folderName = store.getFolder("Temp-6");
			// Folder folderName = store.getFolder("Temp-7");
			// Folder folderName = store.getFolder("Temp-8");
			// Folder folderName = store.getFolder("Temp-9");

			// Folder folderName = store.getFolder("Trash");
			// Folder folderName = store.getFolder("admin@corp2corpstaffinghub.com");
			// Folder folderName = store.getFolder("block");
			// Folder folderName = store.getFolder("me");

			// Yahoo Anurag Job

			// Folder folderName = store.getFolder("0-NaukriService-2024");
			// Folder folderName = store.getFolder("000-Delivery Status Notification
			// (Failure)");
			// Folder folderName = store.getFolder("000-Deliverydelayed");
			// Folder folderName = store.getFolder("000-Failure Notice");
			// Folder folderName = store.getFolder("000-postmaster");
			// Folder folderName = store.getFolder("000-Returned mail: see transcript for
			// details");
			// Folder folderName = store.getFolder("000-Undelivered Mail Returned to
			// Sender");
			// Folder folderName = store.getFolder("000-Your message couldn't be
			// delivered");

			// Folder folderName = store.getFolder("18-0000-0400");
			// Folder folderName = store.getFolder("18-0401-0800");
			// Folder folderName = store.getFolder("18-0801-1200");
			// Folder folderName = store.getFolder("19-0000-0400");
			// Folder folderName = store.getFolder("19-0401-0800");
			// Folder folderName = store.getFolder("19-0801-1200");
			// Folder folderName = store.getFolder("19-1201-1600");
			// Folder folderName = store.getFolder("19-1601-2000");
			// Folder folderName = store.getFolder("19-2001-2400");
			// Folder folderName = store.getFolder("19-2401-2800");
			// Folder folderName = store.getFolder("19-2801-3200");
			// Folder folderName = store.getFolder("20-0000-0400");
			// Folder folderName = store.getFolder("20-0401-0800");
			// Folder folderName = store.getFolder("20-0801-1200");
			// Folder folderName = store.getFolder("20-1201-1600");
			// Folder folderName = store.getFolder("20-1601-2000");
			// Folder folderName = store.getFolder("20-2001-2400");
			// Folder folderName = store.getFolder("20-2401-2800");
			// Folder folderName = store.getFolder("20-2801-3200");
			// Folder folderName = store.getFolder("20-3201-3600");
			// Folder folderName = store.getFolder("20-3601-4000");

			// Folder folderName = store.getFolder("2014");
			// Folder folderName = store.getFolder("2015");
			// Folder folderName = store.getFolder("2016");

			// Folder folderName = store.getFolder("21-0000-0400");
			// Folder folderName = store.getFolder("21-0401-0800");
			// Folder folderName = store.getFolder("21-0801-1200");
			// Folder folderName = store.getFolder("22-0000-0400");
			// Folder folderName = store.getFolder("22-0401-0800");
			// Folder folderName = store.getFolder("22-0801-1200");
			// Folder folderName = store.getFolder("23-0000-0400");
			// Folder folderName = store.getFolder("23-0401-0800");
			// Folder folderName = store.getFolder("24-0000-0400");
			// Folder folderName = store.getFolder("25-0000-0400");

			// edureka.co

			// Folder folderName = store.getFolder("Admin");
			// Folder folderName = store.getFolder("Anurag");
			// Folder folderName = store.getFolder("Archive");
			// Folder folderName = store.getFolder("Bulk");
			// Folder folderName = store.getFolder("Deepak Sati");
			// Folder folderName = store.getFolder("Draft");
			// Folder folderName = store.getFolder("Gemsource");
			// Folder folderName = store.getFolder("Gmail-1");
			// Folder folderName = store.getFolder("Gmail-2");
			// Folder folderName = store.getFolder("HCL");
			// Folder folderName = store.getFolder("HSBC");

			// Folder folderName = store.getFolder("IMPSent-2014");
			// Folder folderName = store.getFolder("IMPSent-2015");
			// Folder folderName = store.getFolder("IMPSent-2016");
			// Folder folderName = store.getFolder("IMPSent-2017");
			// Folder folderName = store.getFolder("IMPSent-2018");
			// Folder folderName = store.getFolder("IMPSent-2019");
			// Folder folderName = store.getFolder("IMPSent-2020");
			// Folder folderName = store.getFolder("IMPSent-2021");
			// Folder folderName = store.getFolder("IMPSent-2022");
			// Folder folderName = store.getFolder("IMPSent-2023");

			// Folder folderName = store.getFolder("Inbox");
			// Folder folderName = store.getFolder("Infosys");
			// Folder folderName = store.getFolder("Kumar Das");

			// Folder folderName = store.getFolder("MySent-2015");
			// Folder folderName = store.getFolder("MySent-2016");
			// Folder folderName = store.getFolder("MySent-2018");
			// Folder folderName = store.getFolder("MySent-2019");
			// Folder folderName = store.getFolder("MySent-2020");
			// Folder folderName = store.getFolder("MySent-2021");
			// Folder folderName = store.getFolder("MySent-2022");
			// Folder folderName = store.getFolder("MySent-2024");

			// Folder folderName = store.getFolder("Naukri.comJobs");
			// Folder folderName = store.getFolder("Re-Reply");
			// Folder folderName = store.getFolder("Sanaari");
			// Folder folderName = store.getFolder("Sent");
			// Folder folderName = store.getFolder("Synechron");
			// Folder folderName = store.getFolder("Syntel");
			// Folder folderName = store.getFolder("TCS");
			// Folder folderName = store.getFolder("TIAA");
			// Folder folderName = store.getFolder("TechMahindra");
			// Folder folderName = store.getFolder("Teliolabs");

			// Folder folderName = store.getFolder("Temp-1");
			// Folder folderName = store.getFolder("Temp-2");
			// Folder folderName = store.getFolder("Temp-3");
			// Folder folderName = store.getFolder("Temp-4");
			// Folder folderName = store.getFolder("Temp-5");

			// Folder folderName = store.getFolder("Trash");
			// Folder folderName = store.getFolder("Volante");
			// Folder folderName = store.getFolder("Wipro");
			// Folder folderName = store.getFolder("me");

			// Yahoo Anurag

			// Folder folderName = store.getFolder("2008");
			// Folder folderName = store.getFolder("2009");
			// Folder folderName = store.getFolder("2010");
			// Folder folderName = store.getFolder("2011");
			// Folder folderName = store.getFolder("2012");
			// Folder folderName = store.getFolder("2013");
			// Folder folderName = store.getFolder("2014");
			// Folder folderName = store.getFolder("2015");
			// Folder folderName = store.getFolder("2016");
			// Folder folderName = store.getFolder("2017");
			// Folder folderName = store.getFolder("2018");
			// Folder folderName = store.getFolder("2019");
			// Folder folderName = store.getFolder("2020");
			// Folder folderName = store.getFolder("2021");
			// Folder folderName = store.getFolder("2022");
			// Folder folderName = store.getFolder("2023");
			// Folder folderName = store.getFolder("2024");
			// Folder folderName = store.getFolder("2025");
			// Folder folderName = store.getFolder("9502110033");
			// Folder folderName = store.getFolder("9502119933");
			// Folder folderName = store.getFolder("Archive");
			// Folder folderName = store.getFolder("Bulk");
			// Folder folderName = store.getFolder("Call received from");
			// Folder folderName = store.getFolder("Draft");
			// Folder folderName = store.getFolder("FAlin");
			// Folder folderName = store.getFolder("HDFC Bank Account");
			// Folder folderName = store.getFolder("HDFC Bank Bill Pay");
			// Folder folderName = store.getFolder("HSBC India");
			// Folder folderName = store.getFolder("Inbox");
			// Folder folderName = store.getFolder("Job-EMail-1");
			// Folder folderName = store.getFolder("Job-EMail-2");
			// Folder folderName = store.getFolder("Job-EMail-3");
			// Folder folderName = store.getFolder("Job-EMail-4");
			// Folder folderName = store.getFolder("Job-EMail-5");
			// Folder folderName = store.getFolder("MAILER-DAEMON");
			// Folder folderName = store.getFolder("Sent");
			// Folder folderName = store.getFolder("StandardChartered");
			// Folder folderName = store.getFolder("Synechron");
			// Folder folderName = store.getFolder("Techmahindra");
			// Folder folderName = store.getFolder("TempFolder");
			// Folder folderName = store.getFolder("Trash");
			// Folder folderName = store.getFolder("Volante");
			// Folder folderName = store.getFolder("airtel-com");
			// Folder folderName = store.getFolder("icicibank.com");
			// Folder folderName = store.getFolder("incometaxindiaefiling.gov.in");
			// Folder folderName = store.getFolder("me");
			// Folder folderName = store.getFolder("nse-bse");
			// Folder folderName = store.getFolder("sbi.co.in");

			folderName.open(Folder.READ_WRITE);
			processEmails(folderName);

			store.close();
		} catch (MessagingException e) {
			logger.severe("Messaging Exception: " + e.getMessage());
		}
		long elapsedTime = System.nanoTime() - startTime;
		logger.info("Execution time: " + elapsedTime / 1_000_000_000 + " seconds");
	}

	private static void processEmails(Folder folder) throws MessagingException {
		
		System.out.println("Folder: " + folder);
		System.out.println();
		Message[] messages = folder.getMessages();
		for (Message message : messages) {
			try {
				String emailContent = extractTextFromMessage(message);
				extractEmails(emailContent);
				// System.out.println(emailContent);
			} catch (Exception e) {
				logger.warning("Failed to process message: " + e.getMessage());
			}
		}
	}

	private static String extractTextFromMessage(Message message) throws Exception {
		
		if (message.isMimeType("text/plain")) {
			return message.getContent().toString();
		} else if (message.isMimeType("multipart/*")) {
			MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
			return getTextFromMimeMultipart(mimeMultipart);
		}
		return "";
	}

	private static String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws Exception {
		
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < mimeMultipart.getCount(); i++) {
			BodyPart bodyPart = mimeMultipart.getBodyPart(i);
			if (bodyPart.isMimeType("text/plain")) {
				result.append(bodyPart.getContent());
			}
		}
		return result.toString();
	}

	private static void extractEmails(String content) {
		
		String emailRegex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";
		// String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,}$";
		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(content);

		Set<String> emails = new TreeSet<>();
		while (matcher.find()) {
			emails.add(matcher.group());
		}
		emails.forEach(System.out::println);
	}
}
