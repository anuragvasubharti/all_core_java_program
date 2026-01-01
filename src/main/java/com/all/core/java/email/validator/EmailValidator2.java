package com.all.core.java.email.validator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class EmailValidator2 {

	private static final Logger logger = Logger.getLogger(EmailValidator2.class.getName());

	// Step 1: Regex Validation
	public static boolean isValidEmailAddress(String email) {

		// String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
		// String emailRegex =
		// "\"^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,}$\";";
		// String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,}$";

		// String EMAIL_PATTERN_UsingRFC5322Regex =
		// "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

		// Pattern pattern = Pattern.compile(EMAIL_PATTERN_UsingRFC5322Regex);
		// Matcher matcher = pattern.matcher(email);
		// return matcher.matches();
		return true;
	}

	// Step 2: Domain Check
	public static boolean hasMXRecord(String domain) {

		try {
			DirContext dirContext = new InitialDirContext();
			Attributes attributes = dirContext.getAttributes("dns:/" + domain, new String[] { "MX" });
			Attribute attribute = attributes.get("MX");

			System.out.println(attribute);

			return attribute != null;

		} catch (NamingException e) {
			// e.printStackTrace();
			return false;
		}
	}

	// Step 3: SMTP Verification
	public static boolean isValidSMTP(String email) {

		try {
			String[] parts = email.split("@");
			String domain = parts[1];
			List<String> mxList = getMXRecords(domain);

			if (mxList.isEmpty()) {
				return false;
			}

			for (String mx : mxList) {
				// StringBuffer stringBuffer = new StringBuffer(mx);
				// stringBuffer.deleteCharAt(stringBuffer.length() - 1);
				// System.out.println(stringBuffer);

				if (verifySMTP(email, mx)) {
					return true;
				}
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return false;
	}

	public static List<String> getMXRecords(String domain) {

		List<String> mxList = new ArrayList<>();
		try {
			DirContext dirContext = new InitialDirContext();
			Attributes attributes = dirContext.getAttributes("dns:/" + domain, new String[] { "MX" });
			Attribute attribute = attributes.get("MX");

			if (attribute != null) {
				for (int i = 0; i < attribute.size(); i++) {
					String[] parts = attribute.get(i).toString().split(" ");
					mxList.add(parts[1]);
				}
			}
		} catch (NamingException e) {
			// e.printStackTrace();
		}
		return mxList;
	}

	public static boolean verifySMTP(String email, String mx) {

		Socket socket = null;
		try {
			socket = new Socket(mx, 25);
			socket.setSoTimeout(10000); // Set timeout to 10 seconds

			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			OutputStream writer = socket.getOutputStream();

			if (!getResponse(reader).startsWith("220")) {
				return false;
			}

			writer.write("HELO example.com\r\n".getBytes());
			writer.flush();
			if (!getResponse(reader).startsWith("250")) {
				return false;
			}

			writer.write("MAIL FROM:<test@example.com>\r\n".getBytes());
			writer.flush();
			if (!getResponse(reader).startsWith("250")) {
				return false;
			}

			writer.write(("RCPT TO:<" + email + ">\r\n").getBytes());
			writer.flush();
			String response = getResponse(reader);
			writer.write("QUIT\r\n".getBytes());
			writer.flush();

			// System.out.println(email);
			// System.out.println(response);

			return response.startsWith("250");

		} catch (SocketTimeoutException e) {
			System.out.println("Connection timed out: " + e.getMessage());
			return false;
		} catch (Exception e) {
			// e.printStackTrace();
			return false;
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static String getResponse(BufferedReader reader) throws Exception {

		StringBuilder response = new StringBuilder();
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				response.append(line).append("\n");
				if (line.contains(" ")) {
					break;
				}
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}
		return response.toString();
	}

	public static void main(String[] args) {

		// String email = "anuragvasubharti@gmail.com";
		// String email = "anuragvasubharti@yahoo.com";
		String email = "netra.i@anlage.co.in";

		if (!isValidEmailAddress(email)) {
			System.out.println("Invalid email address format.");
			return;
		}

		String domain = email.split("@")[1];
		if (!hasMXRecord(domain)) {
			System.out.println("No MX record found for domain.");
			return;
		}

		if (isValidSMTP(email)) {
			System.out.println("Email is valid and exists.");
		} else {
			System.out.println("Email is invalid or does not exist.");
		}
	}
}
