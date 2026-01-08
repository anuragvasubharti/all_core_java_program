package com.all.core.java.gmail.Id.generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class DigitGmailGenerator {

	private static final String BASE_PATH = "E:\\Project-Anurag\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\gmail\\Id\\generator\\";

	private static final String OUTPUT_FILE = BASE_PATH + "gmail_digit_ids.txt";
	private static final String DOMAIN = "@gmail.com";

	private static final String[] PATTERNS = { //"sakshi**************8", "sakshi.*************8",
			"sakshivirha*********8", "sakshi.virha********8", "sakshi.virha.*******8", "sakshivirha.cloud.**8",
			"sakshivirha.cloud***8", "sakshivirha.devops**8", "sakshivirha.devops.*8" };

	private static final ExecutorService EXECUTOR = Executors
			.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

	private static final AtomicLong COUNTER = new AtomicLong(0);

	public static void main(String[] args) throws Exception {

		BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE));

		for (String pattern : PATTERNS) {
			EXECUTOR.submit(() -> generateForPattern(pattern, writer));
		}

		EXECUTOR.shutdown();
		EXECUTOR.awaitTermination(1, TimeUnit.HOURS);

		writer.write("\nTOTAL EMAIL IDs GENERATED: " + COUNTER.get());
		writer.close();

		System.out.println("\nTOTAL EMAIL IDs GENERATED: " + COUNTER.get());
	}

	private static void generateForPattern(String pattern, BufferedWriter writer) {
		try {
			int starCount = countStars(pattern);

			int[] allowedLengths = { 1, 2, 3 };

			for (int len : allowedLengths) {
				if (len != starCount)
					continue;

				long max = (long) Math.pow(10, len - 1);

				for (long i = 0; i < max; i++) {

					String digits = generateDigitsEndingWith8(len, i);
					String local = replaceStars(pattern, digits);

					if (!isValid(local))
						continue;

					String email = local + DOMAIN;

					synchronized (writer) {
						writer.write(email);
						writer.newLine();
					}

					System.out.println(email);
					COUNTER.incrementAndGet();
				}
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

	private static String replaceStars(String pattern, String digits) {
		StringBuilder sb = new StringBuilder();
		int index = 0;

		for (char c : pattern.toCharArray()) {
			if (c == '*')
				sb.append(digits.charAt(index++));
			else
				sb.append(c);
		}
		return sb.toString();
	}

	private static String generateDigitsEndingWith8(int length, long number) {
		String numStr = Long.toString(number);
		StringBuilder sb = new StringBuilder();

		while (sb.length() + numStr.length() < length - 1) {
			sb.append('0');
		}

		sb.append(numStr);
		sb.append('8');

		return sb.toString();
	}

	private static boolean isValid(String local) {
		if (local.length() < 20 || local.length() > 21)
			return false;
		if (local.startsWith(".") || local.endsWith("."))
			return false;
		if (local.contains(".."))
			return false;
		return local.matches("[a-z0-9.]+");
	}
}
