package com.all.core.java.regex;

import java.util.logging.Logger;
import java.util.regex.Pattern;

public class RegexExample2 {

	private static final Logger logger = Logger.getLogger(RegexExample2.class.getName());

	public static void main(String args[]) {

		System.out.println(Pattern.matches(".s", "as"));// true (2nd char is s)
		System.out.println(Pattern.matches(".s", "mk"));// false (2nd char is not s)
		// ???????
		System.out.println(Pattern.matches(".s", "mst"));// false (has more than 2 char)
		System.out.println(Pattern.matches(".s", "amms"));// false (has more than 2 char)
		System.out.println(Pattern.matches("..s", "mas"));// true (3rd char is s)
	}
}
