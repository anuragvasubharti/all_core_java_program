package com.all.core.java.email.smtp;

import java.util.Hashtable;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class MXLookup {

	private static final Logger logger = Logger.getLogger(MXLookup.class.getName());

	public static void main(String[] args) {

		String domain = "gmail.com"; // Replace with the domain you want to check

		try {
			Hashtable<String, String> env = new Hashtable<>();
			env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.dns.DnsContextFactory");
			DirContext dirContext = new InitialDirContext(env);
			Attributes attributes = dirContext.getAttributes(domain, new String[] { "MX" });
			NamingEnumeration<?> mxRecords = attributes.get("MX").getAll();
			System.out.println("MX Records for domain: " + domain);

			while (mxRecords.hasMore()) {
				System.out.println(mxRecords.next());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
