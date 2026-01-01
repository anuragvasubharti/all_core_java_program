package com.all.core.java.regex;

import java.util.logging.Logger;
import java.util.regex.Pattern;

public class RegexExample5 {

	private static final Logger logger = Logger.getLogger(RegexExample5.class.getName());

	public static void main(String args[]) {

		System.out.println("metacharacters d....");// d means digit
		System.out.println(Pattern.matches("\\d", "abc"));// false (non-digit)
		System.out.println(Pattern.matches("\\d", "1"));// true (digit and comes once)
		System.out.println(Pattern.matches("\\d", "4443"));// false (digit but comes more than once)
		System.out.println(Pattern.matches("\\d", "323abc"));// false (digit and char)
		System.out.println("metacharacters D....");// D means non-digit
		System.out.println(Pattern.matches("\\D", "abc"));// false (non-digit but comes more than once)
		System.out.println(Pattern.matches("\\D", "1"));// false (digit)
		System.out.println(Pattern.matches("\\D", "4443"));// false (digit)
		System.out.println(Pattern.matches("\\D", "323abc"));// false (digit and char)
		System.out.println(Pattern.matches("\\D", "m"));// true (non-digit and comes once)
		System.out.println("metacharacters D with quantifier....");
		System.out.println(Pattern.matches("\\D*", "mak"));// true (non-digit and may come 0 or more times)
	}
}
