package com.all.core.java.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {

	public static void main(String args[]) {

		Pattern pattern = Pattern.compile(".n");
		// Matcher matcher = pattern.matcher("abc");
		Matcher matcher = pattern.matcher("anuragvasubharti@gmail.com");
		// Matcher matcher = pattern.matcher("abcdefghijklmnopqrstuvwxyz");
		boolean b = matcher.matches();
		System.out.println("b: " + b);

	}
}
