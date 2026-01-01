package com.all.core.java.email.sender;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.SortedSetMultimap;
import com.google.common.collect.TreeMultimap;

import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.AuthenticationFailedException;
import jakarta.mail.Authenticator;
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

public class SendAttachmentInEmailSakshi {

	private static final Logger logger = LogManager.getLogger(SendAttachmentInEmailSakshi.class);

	static int count = 0;

	public static void main(String[] args) {

		String to = null;
		String fileName = "G:\\workspace-spring-tool-suite-4-4.24.0.RELEASE\\Email\\src\\email\\InputEmail2.txt";
		String line = null;

		SortedSetMultimap<String, String> myTreeMultimapList = TreeMultimap.create();
		SortedSetMultimap<String, String> myTreeMultimapReverseList = TreeMultimap.create();
		String stringLine = null;

		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String[] splitStr = null;

			while ((stringLine = bufferedReader.readLine()) != null) {
				if (stringLine.contains("@")) {
					splitStr = stringLine.split("@");
					myTreeMultimapList.put(splitStr[1], stringLine);
				}
			}

			/*
			 * String[] reverseStringEmail = null;
			 * 
			 * for (String stringEmail : myTreeMultimapList.values()) {
			 * 
			 * if (stringEmail.contains("@")) { reverseStringEmail = stringEmail.split("@");
			 * String reverseString = new StringBuffer(stringEmail).reverse().toString();
			 * myTreeMultimapReverseList.put(reverseStringEmail[1], stringEmail); } }
			 */

			// Always close files.
			bufferedReader.close();

		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}

		// Sender's email ID needs to be mentioned
		String from = "sakshivirhajobsearch@yahoo.com";
		final String username = "sakshivirhajobsearch"; // change accordingly
		final String password = "hwlylwcnkurnmnwy"; // change accordingly

		// Assuming you are sending email through relay.jangosmtp.net
		// String host = "imap.mail.yahoo.com";

		Properties properties = new Properties();
		properties.put("mail.store.protocol", "imaps");
		properties.put("mail.imaps.host", "imap.mail.yahoo.com");
		properties.put("mail.imaps.port", "993");
		properties.put("mail.imaps.ssl.enable", "true");

		// Get the Session object.
		Session session = Session.getInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			System.out.println("Email id list size: " + myTreeMultimapList.size());
			System.out.println();
			for (String eMailID : myTreeMultimapList.values()) {
				to = eMailID;

				// Create a default MimeMessage object.
				Message message = new MimeMessage(session);

				// Set From: header field of the header.
				message.setFrom(new InternetAddress(from));

				// Set To: header field of the header.
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

				// Set Subject: header field
				message.setSubject(
						"Actively looking for a Cloud/DevOps Engineer job opportunity—immediate joining (Pune, Hyderabad, Jabalpur)");

				// Create the message part
				BodyPart messageBodyPart = new MimeBodyPart();

				String strSakshiCoverLetter1 = "Respected Sir/Ma'am,\r\n" + "\r\n"
						+ "I am writing to express my keen interest in the cloud engineer position. With 5 years (combining 3 years of IT experience as a cloud and DevOps engineer with 2 years of non-IT experience as a teacher) of hands-on experience in designing, implementing, and maintaining cloud-based solutions, I am confident in my ability to make a significant contribution to your team and organization.\r\n"
						+ "\r\n"
						+ "Throughout my career, I have extensively worked with cloud platforms such as AWS, Azure, and Google Cloud Platform, demonstrating proficiency in deploying and managing cloud infrastructure, optimizing performance, ensuring security, and enhancing scalability. Whether it's designing resilient architectures, automating deployment processes, or troubleshooting complex issues, I consistently deliver results while adhering to best practices and industry standards.\r\n"
						+ "\r\n"
						+ "A key strength of mine is the ability to collaborate effectively with cross-functional teams to understand business requirements and translate them into robust cloud solutions. I have a proven track record of successfully leading cloud migration projects, optimizing existing cloud environments, and providing technical guidance and support to colleagues and clients alike.\r\n"
						+ "\r\n"
						+ "I am genuinely excited about the opportunity to bring my skills and expertise to your team and organization, and I am eager to be part of a collaborative environment where I can continue to learn and grow professionally.\r\n"
						+ "\r\n"
						+ "I am highly motivated, adaptable, and passionate about staying updated with the latest advancements in cloud technologies. I am confident that my combination of technical skills, hands-on experience, and dedication to excellence make me an ideal candidate for the Cloud Engineer position.\r\n"
						+ "\r\n"
						+ "Please find my resume attached for your review, and I am available at your convenience to discuss further or schedule an interview.\r\n"
						+ "\r\n" + "Regards,\r\n" + "Sakshi Virha";

				// Now set the actual message
				messageBodyPart.setText(strSakshiCoverLetter1);

				// Create a multipart message
				Multipart multipart = new MimeMultipart();

				// Set text message part
				multipart.addBodyPart(messageBodyPart);

				// Part two is attachment
				messageBodyPart = new MimeBodyPart();
				String filename = "D:\\Sakshi\\CV\\SAKSHI-VIRHA-10-09-2024-All.docx";

				DataSource source = new FileDataSource(filename);
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName(filename);
				multipart.addBodyPart(messageBodyPart);

				// Send the complete message parts
				message.setContent(multipart);

				// Send message
				message.setSentDate(new Date());

				try {
					Transport.send(message);
					System.out.println(to);
					count++;
				} catch (AuthenticationFailedException afe) {
					afe.printStackTrace();
				} catch (AddressException ae) {
					ae.printStackTrace();
				} catch (MessagingException me) {
					me.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
				// System.out.println("Sent message successfully... " + to);

				if (count == 200) {
					System.out.println("Called Transport.close()...");
				}
			}
			System.out.println();
			System.out.println("Done... " + count);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
