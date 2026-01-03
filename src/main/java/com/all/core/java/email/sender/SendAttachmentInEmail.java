package com.all.core.java.email.sender;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.BodyPart;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
/*mail:
 host: smtp.mail.yahoo.com
 port: 587
 username: ipnaasp@yahoo.com
 password: ....
 protocol: smtp
 tls: true
 properties.mail.smtp:
 auth: true
 starttls.enable: true
 ssl.trust: smtp.mail.yahoo.com*/

public class SendAttachmentInEmail {

	private static final Logger logger = LogManager.getLogger(SendAttachmentInEmail.class);

	static int count = 0;
	Transport transport;

	public static void main(String[] args) {

		SendAttachmentInEmail sendAttachmentInEmail = new SendAttachmentInEmail();
		sendAttachmentInEmail.sendEmail();
	}

	public void sendEmail() {

		String to = null;
		// String fileName = "D:\\workspaceKepler\\EmailReader\\src\\InputEmail1.txt";
		// String fileName = "D:\\workspaceKepler\\EmailReader\\src\\InputEmail2.txt";
		String fileName = "E:\\Project-Anurag\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\input_output\\anuragvasubharti@gmail.com-2019 - 1 - 0.txt";
		String line = null;
		Set<String> aList = new TreeSet<String>();
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);
			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while ((line = bufferedReader.readLine()) != null) {
				String string = line;
				aList.add(string);
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		} catch (Exception e) {
			System.out.println("Exception");
			e.printStackTrace();
		}
		// Sender's email ID needs to be mentioned
		// Anurag
		// String from = "anuragvasubharti@gmail.com";
		// final String username = "anuragvasubharti"; //change accordingly
		// final String password = "Vasu2516Vasu"; //change accordingly
		// ----------------------------------------------------------------------------
		String from = "anuragvasubhartijobs@yahoo.com";
		// final String username = "anuragvasubhartijobs@yahoo.com"; //change
		// accordingly
		final String username = "anuragvasubhartijobs"; // change accordingly
		final String password = "txvuoeuukchxsctp"; // change accordingly
		// Sanjukta
		// String from = "sanjukta.dash25@yahoo.com";
		// final String username = "sanjukta.dash25@yahoo.com"; // change accordingly
		// final String password = "vasu1625vasu"; // change accordingly
		// String from = "dash.sanjukta@yahoo.com";
		// final String username = "dash.sanjukta@yahoo.com"; // change accordingly
		// final String password = "vasu2516vasu"; // change accordingly
		// String from = "sanjuktadash1983@yahoo.com";
		// final String username = "sanjuktadash1983@yahoo.com"; // change accordingly
		// final String password = "vasu2516vasu"; // change accordingly
		// ----------------------------------------------------------------------------
		// String from = "sanjuktadashjobsearch@gmail.com";
		// final String username = "sanjuktadashjobsearch"; // change accordingly
		// final String password = "vasu2516vasu"; // change accordingly
		// --------------------------------------------------------------------------------------------------
		// Port 587 - SSL checkbox not checked - uses STARTTLS
		// Port 465- SSL checkbox checked - uses SMTPS
		// Assuming you are sending email through relay.jangosmtp.net
		// String host = "smtp.gmail.com";
		String host = "smtp.mail.yahoo.com";
		// String port = "25";
		// String port = "465";
		String port = "587";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true"); // Enabling SMTP Authentication
		props.put("mail.smtp.host", host); // SMTP Host
		props.put("mail.smtp.port", port); // SMTP Port
		props.put("mail.smtp.socketFactory.port", port);
		props.put("mail.smtp.starttls.enable", "true");
		// props.put("mail.smtp.socketFactory.port", "465");
		// props.put("mail.smtp.port", "465");
		// Get the Session object.
		Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			// Recipient's email ID needs to be mentioned.
			// String to = "anuragvasubhartijobs@yahoo.com";
			// Sorting HashSet using
			List<String> tempList = new ArrayList<String>(aList);
			Collections.sort(tempList);
			System.out.println("Total MailID tempList.size()... " + tempList.size() + " " + tempList);
			for (String eMailID : tempList) {
				to = eMailID;
				// Create a default MimeMessage object.
				Message message = new MimeMessage(session);
				// Set From: header field of the header.
				message.setFrom(new InternetAddress(from));
				// Set To: header field of the header.
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
				// Set Subject: header field
				message.setSubject("Looking for a New Java Job Opportunity, Join ASAP.");
				// message.setSubject("Looking for a New Java Job Opportunity, Join ASAP.
				// Reference - Linkedin Connection");
				// message.setSubject("Looking for a New Pega Job Opportunity, Join ASAP.
				// Reference - Linkedin Connection");
				// message.setSubject("Sanjukta missed your number so please call/message to
				// her/me. It is urgent");
				// Create the message part
				BodyPart messageBodyPart = new MimeBodyPart();
				String strAnurag = "Respected Sir/Madam," + "\n" + "\n"
						+ "I would like to take this opportunity to introduce myself to your organization. "
						+ "My professional career exhibits a record of strong achievements and significant contributions. "
						+ "My Professional Experience demonstrates my willingness to assume more than the typical level of responsibility and to achieve in a challenging environment. "
						+ "Through my work experience, I acquired in-depth computer proficiency and a profound belief in the importance of effective communication in today’s growing entrepreneurial endeavour."
						+ "\n" + "\n"
						+ "I am looking for an organization that offers career growth, has strong identity and recognizes human values making the best use of my abilities, multiple faceted skills and provide valuable inputs to enhance the same. "
						+ "I have an urge to utilize my Qualification and creative skills in an environment that is conducive to career development."
						+ "\n"
						+ "I enclose my resume providing you with in-depth information on the years. More importantly, I have enhanced each company’s reputation, keeping existing company satisfaction."
						+ "\n" + "\n"
						+ "I hope you have an appropriate opening matching my qualification and experience and give me an opportunity to interact with your kind self to prove my worth."
						+ "\n" + "\n" + "Looking forward to a positive reply" + "\n" + "\n" + "Yours truly" + "\n"
						+ "\n" + "Anurag Bharti" + "\n" + "+91 9502119933";
				// + "\n" + "\n" + "Sent from Java Programming";
				String strAnurag2 = "Respected Sir/Madam," + "\n" + "\n"
						+ "I am Anurag Bharti having work experience as a Project Lead in Java/J2EE technology and have near about 10 years hands on experience in Java/J2EE. "
						+ "\n" + "\n"
						+ "I am actively looking new job opportunity as a Full Stack Developer in Java/J2EE technology. "
						+ "\n" + "\n"
						+ "Please let me know if you have any Full Stack Developer  in Java/J2EE job opportunity in your organization. "
						+ "\n" + "\n" + "Feel free to connect: anuragvasubhartijobs@yahoo.com " + "\n" + "\n"
						+ "1st Preferred Location: Hyderabad and Bhubaneswar " + "\n" + "\n" + "Yours truly" + "\n"
						+ "\n" + "Anurag Bharti" + "\n" + "+91 9502119933";
				// + "\n" + "\n" + "Sent from Java Programming";
				String strSanjukta = "Respected Sir/Madam," + "\n" + "\n"
						+ "I would like to take this opportunity to introduce myself to your organization. "
						+ "My professional career exhibits a record of strong achievements and significant contributions. "
						+ "My Professional Experience demonstrates my willingness to assume more than the typical level of responsibility and to achieve in a challenging environment. "
						+ "Through my work experience, I acquired in-depth computer proficiency and a profound belief in the importance of effective communication in today’s growing entrepreneurial endeavour."
						+ "\n" + "\n"
						+ "I am looking for an organization that offers career growth, has strong identity and recognizes human values making the best use of my abilities, multiple faceted skills and provide valuable inputs to enhance the same. "
						+ "I have an urge to utilize my Qualification and creative skills in an environment that is conducive to career development."
						+ "\n"
						+ "I enclose my resume providing you with in-depth information on the years. More importantly, I have enhanced each company’s reputation, keeping existing company satisfaction."
						+ "\n" + "\n"
						+ "I hope you have an appropriate opening matching my qualification and experience and give me an opportunity to interact with your kind self to prove my worth."
						+ "\n" + "\n" + "Looking forward to a positive reply" + "\n" + "\n" + "Yours truly" + "\n"
						+ "\n"
						// + "Sanjukta Dash" + "\n" + "8074863953" + "\n" + "dash.sanjukta@yahoo.com";
						+ "Sanjukta Dash" + "\n" + "+91 8074863953" + "\n" + "sanjukta.dash25@yahoo.com" + "\n" + "\n"
						+ "Sent from Pega Programming";
				// Now set the actual message
				// messageBodyPart.setText(strSanjukta);
				messageBodyPart.setText(strAnurag);
				// Create a multipart message
				Multipart multipart = new MimeMultipart();
				// Set text message part
				multipart.addBodyPart(messageBodyPart);
				// Part two is attachment
				messageBodyPart = new MimeBodyPart();
				String filename = "C:\\Users\\Anurag\\Desktop\\Anurag_Bharti_16_11_2019.docx";
				// String filename = "C:\Users\Anurag\Desktop\Sanjukta_Dash_2019.docx";
				DataSource source = new FileDataSource(filename);
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName(filename);
				multipart.addBodyPart(messageBodyPart);
				// Send the complete message parts
				message.setContent(multipart);
				// Send message
				// Transport.send(message);
				message.setSentDate(new Date());
				try {
					// System.out.println("---1Closed");
					transport.send(message);
					// System.out.println("---2Closed");
					if (count == 200) {
						// if((count - 1) <= tempList.size()){
						// System.out.println("Completed MailID tempList.size() = " + tempList.size() +
						// " ...");
						// transport.close();
						break;
					}
				} catch (NullPointerException ex) {

					System.out.println("NullPointerException 1");
					ex.printStackTrace();
					// transport.close();
					/*
					 * ex.getClass(); ex.getLocalizedMessage(); ex.getMessage();
					 * ex.getNextException(); ex.getStackTrace(); ex.getSuppressed();
					 * ex.printStackTrace(); ex.getCause(); ex.getPos(); ex.getRef();
					 * ex.printStackTrace();
					 */
				} catch (AddressException ex) {

					System.out.println("AddressException 1");
					// transport.close();
					/*
					 * ex.getClass(); ex.getLocalizedMessage(); ex.getMessage();
					 * ex.getNextException(); ex.getStackTrace(); ex.getSuppressed();
					 * ex.printStackTrace(); ex.getCause(); ex.getPos(); ex.getRef();
					 * ex.printStackTrace();
					 */
				} catch (MessagingException ex) {

					System.out.println("MessagingException 1");
					// transport.close();
					ex.getCause();
					ex.getClass();
					ex.getLocalizedMessage();
					ex.getMessage();
					ex.getNextException();
					ex.getStackTrace();
					ex.getSuppressed();
					ex.printStackTrace();
					// throw new RuntimeException(ex);
				} catch (Exception e) {
					System.out.println("Exception 1");
					e.printStackTrace();
				}
				System.out.println("Sent message successfully... Count NO: " + count + " " + to);
				count++;
			}
			System.out.println("Completed MailID tempList.size() = " + tempList.size() + " ...");
			System.out.println("Done... " + count);
			// transport.close();

		} catch (NullPointerException ex) {

			System.out.println("NullPointerException 2");
			ex.printStackTrace();
			// transport.close();
			/*
			 * ex.getClass(); ex.getLocalizedMessage(); ex.getMessage();
			 * ex.getNextException(); ex.getStackTrace(); ex.getSuppressed();
			 * ex.printStackTrace(); ex.getCause(); ex.getPos(); ex.getRef();
			 * ex.printStackTrace();
			 */
		} catch (AddressException ex) {

			System.out.println("AddressException 2");
			// transport.close();
			ex.getClass();
			ex.getLocalizedMessage();
			ex.getMessage();
			ex.getNextException();
			ex.getStackTrace();
			ex.getSuppressed();
			ex.printStackTrace();
			ex.getCause();
			ex.getPos();
			ex.getRef();
			ex.printStackTrace();

		} catch (MessagingException ex) {

			System.out.println("MessagingException 2");
			ex.getCause();
			ex.getClass();
			ex.getLocalizedMessage();
			ex.getMessage();
			ex.getNextException();
			ex.getStackTrace();
			ex.getSuppressed();
			ex.printStackTrace();
			// throw new RuntimeException(ex);
		} catch (Exception e) {
			System.out.println("Exception 2");
			e.printStackTrace();
		}
	}
}
