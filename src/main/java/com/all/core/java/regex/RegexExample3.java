package com.all.core.java.regex;

import java.util.logging.Logger;
import java.util.regex.Pattern;

public class RegexExample3 {

	private static final Logger logger = Logger.getLogger(RegexExample3.class.getName());

	public static void main(String args[]) {

		System.out.println(Pattern.matches("[amn]", "abcd"));// false (not a or m or n)
		System.out.println(Pattern.matches("[amn]", "a"));// true (among a or m or n)
		System.out.println(Pattern.matches("[amn]", "ammmna"));// false (m and a comes more than once)
	}
}
