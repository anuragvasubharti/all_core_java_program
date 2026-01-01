package com.all.core.java.misc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailSyntaxValidator {
	// Define a regular expression pattern for email validation
	private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
	private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Usage: java EmailSyntaxValidator <email>");
			return;
		}

		String email = args[0];
		if (isEmailValid(email)) {
			System.out.println("The email address " + email + " has correct syntax.");
		} else {
			System.out.println("The email address " + email + " has incorrect syntax.");
		}
	}

	// Method to check if the email address has correct syntax
	public static boolean isEmailValid(String email) {
		Matcher matcher = EMAIL_PATTERN.matcher(email);
		return matcher.matches();
	}
}
