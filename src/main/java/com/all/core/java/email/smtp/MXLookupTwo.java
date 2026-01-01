package com.all.core.java.email.smtp;

import java.util.Hashtable;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class MXLookupTwo {

	private static final Logger logger = Logger.getLogger(MXLookupTwo.class.getName());

	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println("Usage: java MXLookup <domain>");
			return;
		}

		String domain = args[0];
		try {
			// Set up environment for creating the initial context
			Hashtable<String, String> env = new Hashtable<>();
			env.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
			DirContext ictx = new InitialDirContext(env);

			// Perform a DNS lookup for MX records
			Attributes attrs = ictx.getAttributes(domain, new String[] { "MX" });
			NamingEnumeration<?> servers = attrs.getAll();

			// Pattern to match the priority and the mail server
			Pattern mxPattern = Pattern.compile("(\\d+)\\s+(.*)");

			while (servers.hasMore()) {

				Attribute attr = (Attribute) servers.next();
				for (int i = 0; i < attr.size(); i++) {
					String mxRecord = (String) attr.get(i);
					Matcher matcher = mxPattern.matcher(mxRecord);
					if (matcher.matches()) {
						String priority = matcher.group(1);
						String mailServer = matcher.group(2);
						System.out.println("Priority: " + priority + ", Mail Server: " + mailServer);
					} else {
						System.out.println("Invalid MX record format: " + mxRecord);
					}
				}
			}
			ictx.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
