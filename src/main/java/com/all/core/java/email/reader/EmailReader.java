package com.all.core.java.email.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.logging.Logger;

import jakarta.mail.Flags;
import jakarta.mail.Folder;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.NoSuchProviderException;
import jakarta.mail.Session;
import jakarta.mail.Store;
import jakarta.mail.search.FlagTerm;
// https://rupalchatterjee.wordpress.com/2013/05/05/retrive-email-from-yahoo-gmail-server-using-imap-in-java/

public class EmailReader {
	
	private static final Logger logger = Logger.getLogger(EmailReader.class.getName());
	
	public static void main(String args[]) {
		
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");
        
        try {
                Session session = Session.getDefaultInstance(props, null);
                Store store = session.getStore("imaps");
                // IMAP host for gmail.
                // Replace  with the valid username of your Eumail ID.
                // Replace  with a valid password of your Email ID.
                // store.connect("imap.gmail.com", "anuragvasubharti", "Vasu2516Vasu");
                // IMAP host for yahoo.
                // store.connect("imap.mail.yahoo.com", "anuragvasubharti", "Vasu2516Vasu");
                store.connect("imap.mail.yahoo.com", "dash.sanjukta", "vasu2516vasu");
                // store.connect("imap.mail.yahoo.com", "sanjukta.dash25", "vasu2516vasu");
                // store.connect("imap.mail.yahoo.com", "sanjuktadash1983", "vasu2516vasu");
                System.out.println(store);
                // Folder inbox = store.getFolder("Inbox");
                Folder inbox = store.getFolder("MAILER-DAEMON@yahoo.com");
                inbox.open(Folder.READ_ONLY);
                BufferedReader optionReader = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Press (U) to get only unread mails OR Press (A) to get all mails:");
                try {
                    char answer = 'u';
                    // char answer = (char) optionReader.read();
                    if(answer=='A' || answer=='a'){
                        showAllMails(inbox);
                    }else if(answer=='U' || answer=='u'){
                        showUnreadMails(inbox);
                    }
                    optionReader.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
        } catch (NoSuchProviderException e) {
            System.out.println(e.toString());
            System.exit(1);
        } catch (MessagingException e) {
            System.out.println(e.toString());
            System.exit(2);
        }
    }
	static void showAllMails(Folder inbox){
        try {
            Message msg[] = inbox.getMessages();
            System.out.println("MAILS: "+msg.length);
            for(Message message:msg) {
                try {
                	/*System.out.println("ContentType: "+message.getContentType().toString());
                	System.out.println("Description: "+message.getDescription().toString());
                	System.out.println("Disposition: "+message.getDisposition().toString());
                	System.out.println("FileName: "+message.getFileName().toString());
                	System.out.println("LineCount: "+message.getLineCount());
                	System.out.println("MessageNumber: "+message.getMessageNumber());
                	System.out.println("Size: "+message.getSize());
                	System.out.println("Subject: "+message.getSubject().toString());
                	System.out.println("ATTACHMENT: "+message.ATTACHMENT.toString());
                	System.out.println("INLINE: "+message.INLINE.toString());
                	System.out.println("AllHeaders: "+message.getAllHeaders().toString());
                	System.out.println("AllRecipients: "+message.getAllRecipients().toString());
                	System.out.println("Content: "+message.getContent().toString());
                	System.out.println("DataHandler: "+message.getDataHandler().toString());
                	System.out.println("Flags: "+message.getFlags().toString());
                	System.out.println("Folder: "+message.getFolder().toString());
                	System.out.println("From: "+message.getFrom().toString());
                	System.out.println("Header: "+message.getHeader("0").toString());
                	System.out.println("InputStream: "+message.getInputStream().toString());
                	// System.out.println("MatchingHeaders: "+message.getMatchingHeaders(arg0));
                	// System.out.println("NonMatchingHeaders: "+message.getNonMatchingHeaders(arg0));
                	// System.out.println("MatchingHeaders: "+message.match(term));
                	System.out.println("ReceivedDate: "+message.getReceivedDate().toString());
                	System.out.println("ReplyTo: "+message.getReplyTo().toString());
                	System.out.println("SentDate: "+message.getSentDate().toString());
                	System.out.println("Session: "+message.getSession().toString());
                	System.out.println("isExpunged: "+message.isExpunged());*/
                    System.out.println("DATE: "+message.getSentDate().toString());
                    System.out.println("FROM: "+message.getFrom()[0].toString());           
                    System.out.println("SUBJECT: "+message.getSubject().toString());
                    // System.out.println("CONTENT: "+message.getContent().toString());
                    System.out.println("------------------------------------------");
                } catch (Exception e) {
                    System.out.println("No Information");
                }
            }
        } catch (MessagingException e) {
            System.out.println(e.toString());
        }
    }
	static void showUnreadMails(Folder inbox){       
        try {
            FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
            Message msg[] = inbox.search(ft);
            System.out.println("MAILS: "+msg.length);
            for(Message message:msg) {
                try {
                	/*System.out.println("ContentType: "+message.getContentType().toString());
                	System.out.println("Description: "+message.getDescription().toString());
                	System.out.println("Disposition: "+message.getDisposition().toString());
                	System.out.println("FileName: "+message.getFileName().toString());
                	System.out.println("LineCount: "+message.getLineCount());
                	System.out.println("MessageNumber: "+message.getMessageNumber());
                	System.out.println("Size: "+message.getSize());
                	System.out.println("Subject: "+message.getSubject().toString());
                	System.out.println("ATTACHMENT: "+message.ATTACHMENT.toString());
                	System.out.println("INLINE: "+message.INLINE.toString());
                	System.out.println("AllHeaders: "+message.getAllHeaders().toString());
                	System.out.println("AllRecipients: "+message.getAllRecipients().toString());
                	System.out.println("Content: "+message.getContent().toString());
                	System.out.println("DataHandler: "+message.getDataHandler().toString());
                	System.out.println("Flags: "+message.getFlags().toString());
                	System.out.println("Folder: "+message.getFolder().toString());
                	System.out.println("From: "+message.getFrom().toString());
                	System.out.println("Header: "+message.getHeader("0").toString());
                	System.out.println("InputStream: "+message.getInputStream().toString());
                	// System.out.println("MatchingHeaders: "+message.getMatchingHeaders(arg0));
                	// System.out.println("NonMatchingHeaders: "+message.getNonMatchingHeaders(arg0));
                	// System.out.println("MatchingHeaders: "+message.match(term));
                	System.out.println("ReceivedDate: "+message.getReceivedDate().toString());
                	System.out.println("ReplyTo: "+message.getReplyTo().toString());
                	System.out.println("SentDate: "+message.getSentDate().toString());
                	System.out.println("Session: "+message.getSession().toString());
                	System.out.println("isExpunged: "+message.isExpunged());*/
                    System.out.println("DATE: "+message.getSentDate().toString());
                    System.out.println("FROM: "+message.getFrom()[0].toString());           
                    System.out.println("SUBJECT: "+message.getSubject().toString());
                    // System.out.println("CONTENT: "+message.getContent().toString());
                    System.out.println("-------------------------------------------");
                } catch (Exception e) {
                    System.out.println("No Information");
                }
            }
        } catch (MessagingException e) {
            System.out.println(e.toString());
        }
    }
}
