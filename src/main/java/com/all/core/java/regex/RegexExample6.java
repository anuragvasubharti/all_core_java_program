package com.all.core.java.regex;

import java.util.logging.Logger;
/*Create a regular expression that accepts alpha numeric characters only. Its 
length must be 6 characters long only.*/
import java.util.regex.Pattern;

public class RegexExample6 {

	private static final Logger logger = Logger.getLogger(RegexExample6.class.getName());

	public static void main(String args[]) {

		System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "arun32"));// true
		System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "kkvarun32"));// false (more than 6 char)
		System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "JA2Uk2"));// true
		System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "arun$2"));// false ($ is not matched)
	}
}
