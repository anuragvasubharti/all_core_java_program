package com.all.core.java.gmail.Id.generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.concurrent.atomic.AtomicLong;

public class AlphanumericGmailGenerator {

	private static final String OUTPUT_FILE = "generated_gmail_ids_alnum.txt";
	private static final String DOMAIN = "@gmail.com";

	private static final String[] PATTERNS = { // "sakshi**************8", "sakshi.*************8", "sakshivirha*********8", 
			"sakshi.virha********8", "sakshi.virha.*******8" };

	private static final char[] ALPHA_NUM_DOT;

	static {
		StringBuilder sb = new StringBuilder();

		for (char c = 'a'; c <= 'z'; c++)
			sb.append(c);
		for (char c = 'A'; c <= 'Z'; c++)
			sb.append(c);
		for (char c = '0'; c <= '9'; c++)
			sb.append(c);
		sb.append('.');

		ALPHA_NUM_DOT = sb.toString().toCharArray();
	}

	private static final AtomicLong COUNTER = new AtomicLong(0);

	public static void main(String[] args) throws Exception {

		BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE));

		for (String pattern : PATTERNS) {
			generateForPattern(pattern, writer);
		}

		writer.write("\nTOTAL EMAIL IDs GENERATED: " + COUNTER.get());
		writer.close();

		System.out.println("\nTOTAL EMAIL IDs GENERATED: " + COUNTER.get());
	}

	// ---------------- CORE GENERATION ----------------

	private static void generateForPattern(String pattern, BufferedWriter writer) throws Exception {

		int starCount = countStars(pattern);

		// last char must be 8 → so starCount >= 1
		if (starCount < 1)
			return;

		char[] buffer = new char[starCount];
		generateRecursive(pattern, buffer, 0, writer);
	}

	private static void generateRecursive(String pattern, char[] buffer, int index, BufferedWriter writer)
			throws Exception {

		if (index == buffer.length) {

			// last generated char must be '8'
			if (buffer[buffer.length - 1] != '8')
				return;

			String local = replaceStars(pattern, buffer);

			if (!isValid(local))
				return;

			String email = local + DOMAIN;

			writer.write(email);
			writer.newLine();
			System.out.println(email);

			COUNTER.incrementAndGet();
			return;
		}

		for (char c : ALPHA_NUM_DOT) {
			buffer[index] = c;
			generateRecursive(pattern, buffer, index + 1, writer);
		}
	}

	// ---------------- HELPERS ----------------

	private static int countStars(String s) {
		int c = 0;
		for (char ch : s.toCharArray())
			if (ch == '*')
				c++;
		return c;
	}

	private static String replaceStars(String pattern, char[] replacement) {
		StringBuilder sb = new StringBuilder();
		int idx = 0;

		for (char c : pattern.toCharArray()) {
			if (c == '*')
				sb.append(replacement[idx++]);
			else
				sb.append(c);
		}
		return sb.toString();
	}

	private static boolean isValid(String local) {

		// length check
		if (local.length() < 20 || local.length() > 21)
			return false;

		// dot rules
		if (local.startsWith(".") || local.endsWith("."))
			return false;
		if (local.contains(".."))
			return false;

		// allowed chars
		return local.matches("[a-zA-Z0-9.]+");
	}
}
