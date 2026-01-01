package com.all.core.java.email.validator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Hashtable;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class EmailValidator {

	private static final Logger logger = Logger.getLogger(EmailValidator.class.getName());

	public boolean isValidEmailFormat(String email) {

		String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(emailRegex);
		return pattern.matcher(email).matches();
	}

	public boolean isDomainValid(String email) {

		String domain = email.substring(email.indexOf("@") + 1);

		try {
			Hashtable<String, String> env = new Hashtable<>();
			env.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
			DirContext ictx = new InitialDirContext(env);
			Attributes attrs = ictx.getAttributes(domain, new String[] { "MX" });
			Attribute attr = attrs.get("MX");
			return attr != null;

		} catch (NamingException e) {
			return false;
		}
	}

	public boolean isEmailActive(String email) {

		String domain = email.substring(email.indexOf("@") + 1);
		int smtpPort = 25; // Default SMTP port

		try {
			Socket socket = new Socket(domain, smtpPort);

			System.out.println("getKeepAlive- " + socket.getKeepAlive());
			System.out.println("getLocalPort- " + socket.getLocalPort());
			System.out.println("getOOBInline- " + socket.getOOBInline());
			System.out.println("getPort- " + socket.getPort());
			System.out.println("getReceiveBufferSize- " + socket.getReceiveBufferSize());
			System.out.println("getReuseAddress- " + socket.getReuseAddress());
			System.out.println("getSendBufferSize- " + socket.getSendBufferSize());
			System.out.println("getSoLinger- " + socket.getSoLinger());
			System.out.println("getSoTimeout- " + socket.getSoTimeout());
			System.out.println("getTcpNoDelay- " + socket.getTcpNoDelay());
			System.out.println("getTrafficClass- " + socket.getTrafficClass());
			System.out.println("getChannel- " + socket.getChannel());
			System.out.println("getInetAddress- " + socket.getInetAddress());
			System.out.println("getInputStream- " + socket.getInputStream());
			System.out.println("getLocalAddress- " + socket.getLocalAddress());
			System.out.println("getLocalSocketAddress- " + socket.getLocalSocketAddress());
			System.out.println("getOutputStream- " + socket.getOutputStream());
			System.out.println("getRemoteSocketAddress- " + socket.getRemoteSocketAddress());

			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			// HELO command
			writer.write("HELO example.com\r\n");
			writer.flush();
			reader.readLine();

			// MAIL FROM command
			writer.write("MAIL FROM: <anuragvasubharti@gmail.com>\r\n");
			writer.flush();
			reader.readLine();

			// RCPT TO command
			writer.write("RCPT TO: <" + email + ">\r\n");
			writer.flush();
			String response = reader.readLine();

			// QUIT command
			writer.write("QUIT\r\n");
			writer.flush();

			return response.contains("250");

		} catch (IOException e) {
			return false;
		}
	}

	public static void main(String[] args) {

		EmailValidator validator = new EmailValidator();
		String email = "Anurag.Bharti@synechron.com";

		if (!validator.isValidEmailFormat(email)) {
			System.out.println("Invalid email format.");
		} else if (!validator.isDomainValid(email)) {
			System.out.println("Invalid email domain.");
		} else if (!validator.isEmailActive(email)) {
			System.out.println("Email address is not active.");
		} else {
			System.out.println("Email address is valid and active.");
		}
	}
}