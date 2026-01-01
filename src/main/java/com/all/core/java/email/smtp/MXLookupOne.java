package com.all.core.java.email.smtp;

import java.util.Hashtable;
import java.util.logging.Logger;

import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class MXLookupOne {

	private static final Logger logger = Logger.getLogger(MXLookupOne.class.getName());

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

			while (servers.hasMore()) {
				Attribute attr = (Attribute) servers.next();
				for (int i = 0; i < attr.size(); i++) {
					String mxRecord = (String) attr.get(i);
					System.out.println("MX Record: " + mxRecord);
				}
			}
			ictx.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
