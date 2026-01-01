package com.all.core.java.regex;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExampleTest {

	private static final Logger logger = Logger.getLogger(RegexExampleTest.class.getName());

	public static void main(String[] args) {

		// Create a pattern to be searched
		Pattern pattern = Pattern.compile(" ");
		// Search above pattern in "geeksforgeeks.org"
		Matcher matcher = pattern.matcher("href=\"mailto:hari.e@headinfotech.com\"");

		System.out.println(matcher.matches());
		// Print starting and ending indexes of the pattern in text
		/*
		 * while (matcher.find()) System.out.
		 * println("Find out how many groups are present in the expression -- " +
		 * matcher.groupCount() + " -- Pattern found from -- " + matcher.start() +
		 * " -- to -- " + (matcher.end() - 1));
		 */
		// target="_blank"hari.e@headinfotech.com/a/i/font/divdivfont

	}
}
