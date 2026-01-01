package com.all.core.java.misc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class EmailMailboxStatusChecker {

	private static final Logger logger = Logger.getLogger(EmailMailboxStatusChecker.class.getName());

	private static final Map<String, String> statusDescriptions = new HashMap<>();

	static {
		statusDescriptions.put("450", "Requested action not taken: mailbox unavailable (temporary)");
		statusDescriptions.put("451", "Requested action aborted: local error in processing");
		statusDescriptions.put("452", "Requested action not taken: insufficient system storage");
		statusDescriptions.put("550", "Requested action not taken: mailbox unavailable (permanent)");
		statusDescriptions.put("551", "User not local; please try forwarding");
		statusDescriptions.put("552", "Requested mail action aborted: exceeded storage allocation");
		statusDescriptions.put("553", "Requested action not taken: mailbox name not allowed");
		statusDescriptions.put("554", "Transaction failed (mailbox unavailable or blocked)");
	}

	public static void main(String[] args) throws Exception {

		File inputFile = new File("E:\\EmailMailboxStatusChecker\\emails.txt");
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter("mailbox_statuses.txt"));

		String sender = "check@yourdomain.com"; // Use a dummy sender

		String email;
		while ((email = reader.readLine()) != null) {
			email = email.trim();
			if (email.isEmpty())
				continue;

			try {
				String domain = email.substring(email.indexOf("@") + 1);
				List<String> mxHosts = getMXRecords(domain);
				if (mxHosts.isEmpty()) {
					writer.write(email + " - No MX record found\n");
					continue;
				}

				String mxHost = mxHosts.get(0);
				String result = checkSMTP(mxHost, sender, email);
				writer.write(email + " - " + result + "\n");

			} catch (Exception e) {
				writer.write(email + " - ERROR: " + e.getMessage() + "\n");
			}
		}

		reader.close();
		writer.close();
		System.out.println("Done. Output written to mailbox_statuses.txt");
	}

	private static List<String> getMXRecords(String domain) throws NamingException {

		Hashtable<String, String> env = new Hashtable<>();
		env.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
		DirContext ctx = new InitialDirContext(env);
		Attributes attrs = ctx.getAttributes(domain, new String[] { "MX" });
		Attribute attr = attrs.get("MX");

		List<String> mxList = new ArrayList<>();
		if (attr != null) {
			for (int i = 0; i < attr.size(); i++) {
				String record = (String) attr.get(i);
				String[] parts = record.split(" ");
				if (parts.length == 2) {
					String host = parts[1];
					if (host.endsWith(".")) {
						host = host.substring(0, host.length() - 1);
					}
					mxList.add(host);
				}
			}
		}
		return mxList;
	}

	private static String checkSMTP(String mxHost, String fromEmail, String toEmail) {

		try (Socket socket = new Socket(mxHost, 25);

				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

			String line = in.readLine();
			if (!line.startsWith("220"))
				return "No 220 greeting: " + line;

			sendCommand(out, in, "HELO yourdomain.com");
			sendCommand(out, in, "MAIL FROM:<" + fromEmail + ">");
			String rcptResponse = sendCommand(out, in, "RCPT TO:<" + toEmail + ">");
			sendCommand(out, in, "QUIT");

			String code = rcptResponse.length() >= 3 ? rcptResponse.substring(0, 3) : "???";
			String message = statusDescriptions.getOrDefault(code, "Other/Unknown response");

			return code + " - " + message + " - " + rcptResponse;

		} catch (Exception e) {
			return "Error: " + e.getMessage();
		}
	}

	private static String sendCommand(BufferedWriter out, BufferedReader in, String command) throws IOException {

		out.write(command + "\r\n");
		out.flush();
		return in.readLine();
	}
}
