package com.all.core.java.stringutil;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class StringFindAllPermutations {

	private static final Logger logger = Logger.getLogger(StringFindAllPermutations.class.getName());

	public static Set<String> permutationFinder(String str) {

		Set<String> perm = new HashSet<String>();
		// Handling error scenarios
		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			perm.add("");
			return perm;
		}
		System.out.println("str.length() " + str.length());
		char initial = str.charAt(0); // first character
		String rem = str.substring(1); // Full string without first character
		Set<String> words = permutationFinder(rem);
		System.out.println("words.size() 1 " + words.size());
		for (String strNew : words) {
			System.out.println("words.size() 2 " + words.size());
			System.out.println("strNew " + strNew);
			for (int i = 0; i <= strNew.length(); i++) {
				perm.add(charInsert(strNew, initial, i));
			}
		}
		return perm;
	}

	public static String charInsert(String str, char c, int j) {

		String begin = str.substring(0, j);
		String end = str.substring(j);
		return begin + c + end;
	}

	public static void main(String[] args) {

		// String s = "ANURAG";
		// String s1 = "BHARTI";
		// String s2 = "A-BC";
		String s = "#$%@012356789abdefghijklmnprstuvy";
		// String s1 = "#$%@012356789ABDEFGHIJKLMNPRSTUVY";

		System.out.println("\nPermutations for " + s + " are: \n" + permutationFinder(s));
		System.out.println("");
		// System.out.println("\nPermutations for " + s1 + " are: \n" +
		// permutationFinder(s1));
		// System.out.println("\nPermutations for " + s2 + " are: \n" +
		// permutationFinder(s2));
	}
}
