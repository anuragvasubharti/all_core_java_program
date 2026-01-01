package com.all.core.java.misc;

import java.util.Hashtable;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class MXRecordLookupFour {

	private static final Logger logger = Logger.getLogger(MXRecordLookupFour.class.getName());

	public static boolean mxRecordLookup(String strDomain) {
		String stringLine = strDomain.replace(",", "");
		if (stringLine.contains("@")) {
			String[] splitDomain = stringLine.split("@");
			String domain = splitDomain[1];
			// String domain = strDomain; // Replace with the domain you want to lookup
			try {
				// Set up the environment for creating the initial context
				Hashtable<String, String> env = new Hashtable<>();
				env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.dns.DnsContextFactory");
				env.put(Context.PROVIDER_URL, "dns:");
				// Create the initial directory context
				DirContext dirContext = new InitialDirContext(env);
				// Perform the DNS lookup for MX records
				Attributes attrs = dirContext.getAttributes(domain, new String[] { "MX" });
				Attribute attr = attrs.get("MX");
				if (attr == null) {
					System.out.println("No MX records found for domain: " + domain);
					return false;
				} else {
					// Iterate through the results and print the MX records
					NamingEnumeration<?> enumeration = attr.getAll();
					while (enumeration.hasMore()) {
						enumeration.next();
						// System.out.println(enumeration.next());
					}
					// System.out.println(stringLine);
					return true;
				}
			} catch (javax.naming.NameNotFoundException nnfe) {
				nnfe.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
