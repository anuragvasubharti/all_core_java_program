package com.all.core.java.email.reader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

import jakarta.mail.Address;
import jakarta.mail.Flags;
import jakarta.mail.Folder;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.NoSuchProviderException;
import jakarta.mail.Session;
import jakarta.mail.Store;
import jakarta.mail.search.FlagTerm;

public class EmailReaderTest {
	
	private static final Logger logger = Logger.getLogger(EmailReaderTest.class.getName());
	
	static int count = 0;
	
	public static void main(String args[]) {
		
		Properties props = System.getProperties();
		// System.out.println("props ---> " + props);
		props.setProperty("mail.store.protocol", "imaps");
		
		try {
			Session session = Session.getDefaultInstance(props, null);
			Store store = session.getStore("imaps");
			System.out.println("---> " + store);
			// Replace with the valid username of your Email ID.
			// Replace with a valid password of your Email ID.
			// IMAP host for gmail.
			// store.connect("imap.gmail.com", "anuragbhartimatrimony@gmail.com","Vasu2516Vasu");
			// store.connect("imap.gmail.com", "anuragvasubharti@gmail.com","Vasu2516Vasu");
			// store.connect("imap.gmail.com", "anuragvasubhartijobs@gmail.com","Vasu2516Vasu");
			// store.connect("imap.gmail.com", "vasuanuragbharti@gmail.com","Vasu2516Vasu");
			// store.connect("imap.gmail.com", "vasubharti@gmail.com","Vasu2516Vasu");
			// IMAP host for yahoo.
			store.connect("imap.mail.yahoo.com", "anuragvasubharti@yahoo.com","Vasu2516Vasu");
			// store.connect("imap.mail.yahoo.com", "anuragvasubhartijobs@yahoo.com","vasu0716vasu");
			// IMAP host for gmail.
			// store.connect("imap.gmail.com", "sanjuktadash.407@gmail.com","vasu2516vasu");
			// store.connect("imap.gmail.com", "sanjuktadash.jhilu@gmail.com","Sanju2516sanju");
			// store.connect("imap.gmail.com", "sonjuktadash.jhilu@gmail.com","Sanju2516sanju");x
			// store.connect("imap.gmail.com", "sanjuktadash09@gmail.com","vasu2516vasu");
			// store.connect("imap.gmail.com", "sanjuktadash111@gmail.com","Vasu2516Vasu");
			// store.connect("imap.gmail.com", "sanjuktadash1983@gmail.com","Vasu2516Vasu");
			// store.connect("imap.gmail.com", "sanjuktadashjobsearch@gmail.com","vasu2516vasu");
			// IMAP host for yahoo.
			// store.connect("imap.mail.yahoo.com", "dash.sanjukta@yahoo.com","vasu2516vasu");
			// store.connect("imap.mail.yahoo.com", "sanjukta.dash25@yahoo.com","vasu1625vasu");
			// store.connect("imap.mail.yahoo.com", "sanjuktadash1983@yahoo.com","vasu2516vasu");
			//  All Sanju
			// store.connect("imap.gmail.com", "bujji.sanju@gmail.com","Sanju2516sanju");x
			// store.connect("imap.gmail.com", "haks.sanju@gmail.com","Sanju2516sanju");x
			// store.connect("imap.gmail.com", "sanjukta.charming@gmail.com","Sanju2516sanju");x
			// store.connect("imap.gmail.com", "sanjukta.jhilu@gmail.com","Sanju2516sanju");x
			// store.connect("imap.gmail.com", "sanjukta.thilu@gmail.com","Sanju2516sanju");x
			// store.connect("imap.gmail.com", "sanjuktasadh.407@gmail.com","Sanju2516sanju");x
			// store.connect("imap.gmail.com", "sanjuktasash.407@gmail.com","Sanju2516sanju");x
			// store.connect("imap.gmail.com", "sanjukthadash.407@gmail.com","Sanju2516sanju");x
			// store.connect("imap.gmail.com", "sanjuldadash.407@gmail.com","Sanju2516sanju");x
			// store.connect("imap.gmail.com", "sanjuldadash111@gmail.com","Sanju2516sanju");x
			// store.connect("imap.mail.yahoo.com", "sanjukta_dash@yahoo.com","vasu2516vasu");x
			// store.connect("imap.mail.yahoo.com", "sanjuktadash_2007@yahoo.co.in","vasu2516vasu");x
			// store.connect("imap.mail.yahoo.com", "sanjukthadash_2007@yahoo.co.in","vasu2516vasu");x
			// sanju_kumari@elitehrpractices.comx
			// sanjukta.dash@hotmail.comx
			// sanjukta_dash@outlook.comx
			// sanjukta_dash@ymail.comx
			// store.connect("imap.gmail.com", "chaks.sanju@gmail.com","Sanju2516sanju");
			// store.connect("imap.gmail.com", "coolsanjuforu@gmail.com","Sanju2516sanju");
			// store.connect("imap.gmail.com", "manav.sanjusingh@gmail.com","Sanju2516sanju");
			// store.connect("imap.gmail.com", "sanjay.sanju119@gmail.com","Sanju2516sanju");
			// store.connect("imap.gmail.com", "sanju.choubisa@gmail.com","Sanju2516sanju");
			// store.connect("imap.gmail.com", "sanju.nadimpalli@gmail.com","Sanju2516sanju");
			// store.connect("imap.gmail.com", "sanju.sanju.singh@gmail.com","Sanju2516sanju");
			// store.connect("imap.gmail.com", "sanju19march@gmail.com","Sanju2516sanju");
			// store.connect("imap.gmail.com", "sanju2.bansal@gmail.com","Sanju2516sanju");
			// store.connect("imap.gmail.com", "sanjuhbk4u@gmail.com","Sanju2516sanju");
			// store.connect("imap.gmail.com", "sanjukenshin21@gmail.com","Sanju2516sanju");
			// store.connect("imap.gmail.com", "sanjukit@gmail.com","Sanju2516sanju");
			// store.connect("imap.gmail.com", "sanjukta.tawde@gmail.com","Sanju2516sanju");
			// store.connect("imap.gmail.com", "sanjuktachoudhury20@gmail.com","Sanju2516sanju");
			// store.connect("imap.gmail.com", "sanjuktadash.407@gmail.com","Sanju2516sanju");
			// store.connect("imap.gmail.com", "sanjuktadash.jhilu@gmail.com","Sanju2516sanju");
			// store.connect("imap.gmail.com", "sanjuktadash09@gmail.com","Sanju2516sanju");
			// store.connect("imap.gmail.com", "sanjuktadash111@gmail.com","Sanju2516sanju");
			// store.connect("imap.gmail.com", "sanjuktadash1983@gmail.com","Sanju2516sanju");
			// store.connect("imap.gmail.com", "sanjuktadash407@gmail.com","Sanju2516sanju");
			// store.connect("imap.gmail.com", "sanjuktadashjhilu@gmail.com","Sanju2516sanju");
			// store.connect("imap.gmail.com", "sanjuktadashjobsearch@gmail.com","Sanju2516sanju");
			// store.connect("imap.gmail.com", "sanjuktadashmatrimony@gmail.com","Sanju2516sanju");
			// store.connect("imap.gmail.com", "sanjulda.charming@gmail.com","Sanju2516sanju");
			// store.connect("imap.gmail.com", "sanjupardeshi@gmail.com","Sanju2516sanju");
			// store.connect("imap.gmail.com", "sanjus007@gmail.com","Sanju2516sanju");
			// store.connect("imap.gmail.com", "sanjus555@gmail.com","Sanju2516sanju");
			// store.connect("imap.gmail.com", "sanjushinde17@gmail.com","Sanju2516sanju");
			// store.connect("imap.gmail.com", "sanjusmile6@gmail.com","Sanju2516sanju");
			// store.connect("imap.gmail.com", "sonarsanju23@gmail.com","Sanju2516sanju");
			// store.connect("imap.gmail.com", "sysanju@gmail.com","Sanju2516sanju");
			// store.connect("imap.mail.yahoo.com", "dash.sanjukta@yahoo.com","vasu2516vasu");
			// store.connect("imap.mail.yahoo.com", "sanju_g05@yahoo.com","vasu2516vasu");
			// store.connect("imap.mail.yahoo.com", "sanju_hirwani@yahoo.com","vasu2516vasu");
			// store.connect("imap.mail.yahoo.com", "sanjukta.dash25@yahoo.com","vasu2516vasu");
			// store.connect("imap.mail.yahoo.com", "sanjuktadash1983@yahoo.com","vasu2516vasu");
			// sanju@handigital.com
			System.out.println(store);
			Folder[] folders = store.getDefaultFolder().list("*");
		    for (Folder folder : folders) {
		        if ((folder.getType() & Folder.HOLDS_MESSAGES) != 0) {
		            System.out.println(folder.getFullName() + ": " + folder.getMessageCount());
		        }
		    }
		    // Gmail
		    // Folder inbox = store.getFolder("Inbox");
		    // Yahoo Folder Name and mail count
		    /*121-in-airtel-com: 365
		    2008: 168
		    2009: 814
		    2010: 1115
		    2011: 1960
		    2012: 355
		    2013: 85
		    2014: 299
		    2015: 32
		    2016: 134
		    2017: 196
		    24SevenIndia.com: 1
		    Bulk Mail: 85
		    AVBGmail: 0
		    Archive: 0
		    Axis Bank CC: 28
		    Draft: 1
		    HDFC: 96
		    HP-VT094PA-CNF93531FF: 8
		    Inbox: 370
		    IndusInd Bank: 62
		    Insurance: 1
		    Jhilu: 3
		    MAILER-DAEMON: 0
		    NIIT Imperia: 83
		    RSystemsMail: 0
		    Reliance: 8
		    SC E-Statement: 32
		    SC alert: 234
		    Sanjuktadash.407: 0
		    Sanjuktadash.jhilu: 0
		    Sent: 144
		    Seventymm.com: 127
		    Sparkle for the Day: 69
		    Surendra Manikpuri: 0
		    Syntelinc: 91
		    TechMahindra.com: 46
		    Trash: 0
		    air: 387
		    airtel.payments: 78
		    bhartiairtel: 14
		    bhartianuragvasu: 29
		    citibankstatement: 337
		    eBay: 98
		    ebill-airtel: 86
		    icici credit_cards: 1298
		    incomtax: 16
		    irctc: 6
		    rechargeitnow: 21
		    save-the-children: 50
		    sbicards.sbistatements: 50
		    service.icicisecurities.com: 38
		    temp: 0
		    vasu: 167*/
			// Folder inbox = store.getFolder("DeletedMail");
			// Folder inbox = store.getFolder("Draft");
			Folder inbox = store.getFolder("Inbox");
			// Folder inbox = store.getFolder("MAILER-DAEMON");
			// Folder inbox = store.getFolder("Naukri.com Jobs");
			// Folder inbox = store.getFolder("Neha Dangi");
			// Folder inbox = store.getFolder("Sent");
			// Folder inbox = store.getFolder("TimesJobs Job");
			// Folder inbox = store.getFolder("Trash");
			// Folder inbox = store.getFolder("2017");
			inbox.open(Folder.READ_ONLY);
			BufferedReader optionReader = new BufferedReader(new InputStreamReader(System.in));
			// System.out.println("Press (U) to get only unread mails OR Press (A) to get
			// all mails:");
			try {
				char answer = 'A'; // (char) optionReader.read();
				if (answer == 'A' || answer == 'a') {
					showAllMails(inbox);
				} else if (answer == 'U' || answer == 'u') {
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
	static void showAllMails(Folder inbox) {
		
		try {
			System.out.println("showAllMails");
			String fileNameOut = "D:\\workspace\\EmailReader\\src\\OutputEmail.txt";
			// String fileNameOut2 = "D:\\workspace\\EmailReader\\src\\OutputEmail2.txt";
			// Assume default encoding.
			FileWriter fileWriter = new FileWriter(fileNameOut);
			// FileWriter fileWriter2 = new FileWriter(fileNameOut2);
			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			// BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);
			HashSet<String> aList = new HashSet<String>();
			// HashSet<Address> addList = new HashSet<Address>();
			int countA = 0;
			Message msg[] = inbox.getMessages();
			System.out.println("MAILS: " + msg.length);
			for (Message message : msg) {
				try {
					Date d = new Date();
					// System.out.println("Current Date: "+ d);
					// System.out.println("DATE: " + message.getSentDate().toString());
					// String str = message.getSentDate().toString();
					// aList.add(str);
					System.out.println("FROM: " + message.getFrom()[0].toString());
					String strFrom = message.getFrom()[0].toString();
					String[] arrayOfSplitFromString = strFrom.split(" ");
					for (String splitFromString : arrayOfSplitFromString) {
						// System.out.println("After split " + splitFromString);
						aList.add(splitFromString);
					}
					// System.out.println("SUBJECT: "	+ message.getSubject().toString());
					// String str = message.getSubject().toString();
					// aList.add(str);
					// System.out.println("CONTENT: " + message.getContent().toString());
					// String str = message.getContent().toString();
					// aList.add(str);
					// System.out.println("---> " + message.toString());
					// System.out.println(message.getContent().toString());
					// System.out.println(message.getContentType().toString());
					// System.out.println(message.getDescription().toString());
					// System.out.println(message.getDisposition().toString());
					// System.out.println(message.getFileName().toString());
					// System.out.println(message.getLineCount());
					// System.out.println(message.getMessageNumber());
					// System.out.println(message.getSize());
					// System.out.println(message.getSubject().toString());
					// System.out.println(message.getAllHeaders().toString());
					/*Enumeration e = message.getAllHeaders();
					while (e.hasMoreElements()) {
						Header h = (Header)e.nextElement();
						System.out.println("vvv1 " + h.getName());
						System.out.println("vvv2 " + h.getValue());
						System.out.println("vvv3 " + h.toString());
						System.out.println();
					}*/
					// System.out.println(message.getAllRecipients().toString());
					Address[] address1 = message.getAllRecipients();
					// System.out.println("Address1 -- > " + address1.length);
					for (Address addressString1 : address1) {
						// System.out.println("Address1 -- > " + addressString.toString());
						String splitAddressString1 = addressString1.toString();
						String[] arrayOfSplitAddressString1 = splitAddressString1.split(" ");
						for (String addString1 : arrayOfSplitAddressString1) {
							// System.out.println("addString1 " + addString1);
							aList.add(addString1);
						}
					}
					// System.out.println("888 " + addList);					
					// System.out.println(message.getClass().toString());
					/*System.out.println(message.getDataHandler().toString());
					DataHandler dh = message.getDataHandler();
					System.out.println("---166 " + dh.getContent());
					System.out.println("---266 " + dh.getContentType());
					System.out.println("---366 " + dh.getName());
					System.out.println("---466 " + dh.toString());*/
					/*System.out.println("---566 " + dh.getAllCommands());
					CommandInfo[] commandInfo = (CommandInfo[])dh.getAllCommands();
					System.out.println("--CommandInfo " + commandInfo.length);
					for(CommandInfo o : commandInfo){
						System.out.println("CommandInfo -- > " + o.getCommandName().toString());
					}*/
					// System.out.println("---666 " + dh.getClass());
					// System.out.println("---766 " + dh.getDataSource());
					// System.out.println("---866 " + dh.getInputStream());
					// System.out.println("---966 " + dh.getOutputStream());
					/*System.out.println("---1066 " + dh.getPreferredCommands());
					CommandInfo[] commandInfo1 = (CommandInfo[])dh.getPreferredCommands();
					System.out.println("--CommandInfo1 " + commandInfo1.length);
					for(CommandInfo o : commandInfo1){
						System.out.println("CommandInfo1 -- > " + o.getCommandName().toString());
					}*/
					/*System.out.println("---1166 " + dh.getAllCommands());
					CommandInfo[] commandInfo2 = (CommandInfo[])dh.getAllCommands();
					System.out.println("--CommandInfo2 " + commandInfo2.length);
					for(CommandInfo o : commandInfo2){
						System.out.println("CommandInfo2 -- > " + o.getCommandName().toString());
					}*/
					/*System.out.println("---1266 " + dh.getTransferDataFlavors());
					DataFlavor[] dataFlavor = dh.getTransferDataFlavors();
					System.out.println("--DataFlavor " + dataFlavor.length);
					for(DataFlavor o : dataFlavor){
						System.out.println("DataFlavor -- > " + o.toString());
					}*/
					// System.out.println(message.getFlags().toString());
					// System.out.println(message.getFolder().toString());
					// System.out.println(message.getFrom().toString());
					Address[] address2 = message.getFrom();
					// System.out.println("Address2 -- > " + address2.length);
					for (Address addressString2 : address2) {
						// System.out.println("Address2 -- > " + addressString2.toString());
						String splitAddressString2 = addressString2.toString();
						String[] arrayOfSplitAddressString2 = splitAddressString2.split(" ");
						for (String addString2 : arrayOfSplitAddressString2) {
							// System.out.println("addString2 " + addString2);
							aList.add(addString2);
						}
					}
					// System.out.println(message.getInputStream().toString());
					// System.out.println(message.getReceivedDate().toString());
					// System.out.println(message.getSentDate().toString());
					// System.out.println(message.getSession().toString());
					System.out.println("------------------------------------------ " + countA);
					countA++;
					// Current Date: Wed Sep 05 21:30:53 IST 2018
					// DATE: Fri May 16 00:47:01 IST 2014
					// if(message.getSentDate().toString() == "Fri May 16") break;
					if (countA == 10)
						break;
				} catch (Exception e) {
					System.out.println("No Information" + e.toString());
				}
			}
			System.out.println("aList " + aList.size());
			// System.out.println("addList " + addList.size());
			// Removing duplicate
			/*for (Object obj : aList) {
				System.out.println("Removing duplicate");
				if (aList.contains((String) obj)) {
					aList.remove((String) obj);
					count++;
				}
			}*/
			// Sorting HashSet using 
			List<String> tempList = new ArrayList<String>(aList); 
			// Collections.sort(tempList);
			for (String str : aList) {
				// System.out.println("-----> " + str);
				// String reverse = new StringBuffer(str).reverse().toString();
				// bufferedWriter.write(str + ";");
				bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
			/*for (Address str2 : addList) {
            	// System.out.println("-----> " + str);
            	// String reverse = new StringBuffer(str).reverse().toString();
            	bufferedWriter2.write(str2 + ";");
                bufferedWriter2.newLine();
            }*/
            // Always close files.
            bufferedWriter.close();
            //bufferedWriter2.close();
		} catch (MessagingException e) {
			System.out.println(e.toString());
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}
	static void showUnreadMails(Folder inbox) {
		
		try {
			System.out.println("showUnreadMails");
			String fileNameOut = "E:\\Project-Anurag\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\input_output\\OutputEmail.txt";
			// Assume default encoding.
			FileWriter fileWriter = new FileWriter(fileNameOut);
			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			HashSet<String> aList = new HashSet<String>();
			int countA = 0;
			FlagTerm ft = new FlagTerm(new Flags(Flags.Flag.SEEN), false);
			Message msg[] = inbox.search(ft);
			System.out.println("MAILS: " + msg.length);
			for (Message message : msg) {
				try {
					System.out.println("DATE: " + message.getSentDate().toString());
					System.out.println("FROM: " + message.getFrom()[0].toString());
					String str = message.getFrom()[0].toString();
					aList.add(str);
					System.out.println("aList " + aList.size());
					// System.out.println("SUBJECT: " + message.getSubject().toString());
					// System.out.println("CONTENT: " + message.getContent().toString());
					System.out.println("------------------------------------------ " + countA);
					countA++;
					// if(countA == 10) break;
				} catch (Exception e) {
					System.out.println("No Information" + e.toString());
				}
			}
			System.out.println("aList " + aList.size());
			// Removing duplicate 
            /*for (String str2 : aList){
            	System.out.println("Removing duplicate");
                if(aList.contains(str2)){
                    aList.remove((String)str2);
                    count ++;
                }
            }*/
            for (String str : aList) {
            	System.out.println("-----> " + str);
            	// String reverse = new StringBuffer(str).reverse().toString();
            	bufferedWriter.write(str + ";");
                bufferedWriter.newLine();
            }
            // Always close files.
            bufferedWriter.close();
		} catch (MessagingException e) {
			System.out.println(e.toString());
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}
}
