package com.all.core.java.gmail.Id.generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class GmailIdGeneratorSeq8 {

	private static final String OUTPUT_FILE = "gmail_ids_alphanumeric_seq8.txt";
	private static final String DOMAIN = "@gmail.com";

	private static final String[] PATTERNS = { // "sakshi**************8", "sakshi.*************8", "sakshivirha*********8",
			 "sakshi.virha********8", "sakshi.virha.*******8" };

	private static final ExecutorService EXECUTOR = Executors
			.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

	private static final AtomicLong COUNTER = new AtomicLong(0);

	public static void main(String[] args) throws Exception {

		BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE));

		for (String pattern : PATTERNS) {
			EXECUTOR.submit(() -> generate(pattern, writer));
		}

		EXECUTOR.shutdown();
		EXECUTOR.awaitTermination(1, TimeUnit.HOURS);

		writer.write("\nTOTAL EMAIL IDs GENERATED: " + COUNTER.get());
		writer.close();

		System.out.println("\nTOTAL EMAIL IDs GENERATED: " + COUNTER.get());
	}

	private static void generate(String pattern, BufferedWriter writer) {
		try {
			int starCount = countStars(pattern);

			// generate sequential numbers ending with 8
			long max = (long) Math.pow(10, starCount - 1);

			for (long i = 0; i < max; i++) {

				String digits = buildDigitsEndingWith8(starCount, i);
				String local = replaceStars(pattern, digits);

				if (!isValidLocal(local))
					continue;

				String email = local + DOMAIN;

				synchronized (writer) {
					writer.write(email);
					writer.newLine();
				}

				System.out.println(email);
				COUNTER.incrementAndGet();
			}
		} catch (Exception e) {
			e.printStackTrace();
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

	private static String replaceStars(String pattern, String fill) {
		StringBuilder sb = new StringBuilder();
		int idx = 0;

		for (char c : pattern.toCharArray()) {
			if (c == '*')
				sb.append(fill.charAt(idx++));
			else
				sb.append(c);
		}
		return sb.toString();
	}

	// builds sequential digits, last digit always 8
	private static String buildDigitsEndingWith8(int length, long number) {
		String num = Long.toString(number);
		StringBuilder sb = new StringBuilder();

		while (sb.length() + num.length() < length - 1) {
			sb.append('0');
		}

		sb.append(num);
		sb.append('8');
		return sb.toString();
	}

	private static boolean isValidLocal(String local) {
		if (local.length() < 20 || local.length() > 21)
			return false;
		if (local.startsWith(".") || local.endsWith("."))
			return false;
		if (local.contains(".."))
			return false;
		return local.matches("[a-zA-Z0-9.]+");
	}
}
