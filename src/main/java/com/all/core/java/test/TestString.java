package com.all.core.java.test;

import java.util.logging.Logger;

public class TestString {

	private static final Logger logger = Logger.getLogger(TestString.class.getName());

	public static void main(String args[]) {
		String str = "line.separator" + "," + "<h1>Amazon SES SMTP Email Test</h1>" + ","
				+ "<p>This email was sent with Amazon SES using the " + ","
				+ "<a href='https://github.com/javaee/javamail'>Javamail Package</a>" + ","
				+ " for <a href='https://www.java.com'>Java</a>.";
		System.out.println(str);
		System.out.println("---> " + System.getProperty("line.separator"));
	}
}
