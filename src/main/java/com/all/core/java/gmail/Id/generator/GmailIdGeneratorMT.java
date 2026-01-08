package com.all.core.java.gmail.Id.generator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class GmailIdGeneratorMT {

	private static final String BASE_PATH = "E:\\Project-Anurag\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\gmail\\Id\\generator\\";

	private static final String INPUT_FILE = BASE_PATH + "words_ending_with_l.txt";
	private static final String OUTPUT_FILE = BASE_PATH + "generated_gmail_ids.txt";

	private static final String DOMAIN = "@gmail.com";
	private static final int[] WORD_LENGTHS = { 6, 7, 8, 9, 13, 14 };
	private static final int[] DIGIT_LENGTHS = { 6, 7, 8, 9 };

	private static final List<String> PATTERNS = List.of("sakshi*************l", "sakshi**************l",
			"sakshi.*************l", "sakshi.**************l", "sakshivirha********l", "sakshivirha*********l",
			"sakshi.virha*******l", "sakshi.virha********l", "sakshi.virha.******l", "sakshi.virha.*******l",

			"sakshi*************8", "sakshi**************8", "sakshi.*************8", "sakshi.**************8",
			"sakshivirha********8", "sakshivirha*********8", "sakshi.virha*******8", "sakshi.virha********8",
			"sakshi.virha.******8", "sakshi.virha.*******8");

	private static final AtomicLong TOTAL_COUNT = new AtomicLong();

	public static void main(String[] args) throws Exception {

		List<String> words = loadValidWords();

		ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

		BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE));
		Object lock = new Object();

		for (String pattern : PATTERNS) {
			executor.submit(() -> generateForPattern(pattern, words, writer, lock));
		}

		executor.shutdown();
		executor.awaitTermination(1, TimeUnit.HOURS);

		writer.write("\nTOTAL EMAIL IDs GENERATED: " + TOTAL_COUNT.get());
		writer.close();

		System.out.println("\nTOTAL EMAIL IDs GENERATED: " + TOTAL_COUNT.get());
	}

	// ================= LOGIC =================

	private static void generateForPattern(String pattern, List<String> words, BufferedWriter writer, Object lock) {

		int starCount = countStars(pattern);
		int fixedLength = pattern.replace("*", "").length();

		for (String word : words) {

			if (word.length() != starCount)
				continue;

			String local = pattern.replace("*", "") + word;

			if (!isValidLocal(local))
				continue;

			String email = local + DOMAIN;

			synchronized (lock) {
				try {
					writer.write(email);
					writer.newLine();
					System.out.println(email);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			TOTAL_COUNT.incrementAndGet();
		}

		if (pattern.endsWith("8")) {
			for (int len : DIGIT_LENGTHS) {
				if (len != starCount)
					continue;

				long max = (long) Math.pow(10, len - 1);

				for (long i = 0; i < max; i++) {
					String digits = String.format("%0" + (len - 1) + "d", i) + "8";
					String local = pattern.replace("*", "") + digits;

					if (!isValidLocal(local))
						continue;

					String email = local + DOMAIN;

					synchronized (lock) {
						try {
							writer.write(email);
							writer.newLine();
							System.out.println(email);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					TOTAL_COUNT.incrementAndGet();
				}
			}
		}
	}

	// ================= HELPERS =================

	private static List<String> loadValidWords() throws Exception {
		List<String> result = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE));
		String line;

		while ((line = br.readLine()) != null) {
			line = line.trim().toLowerCase();
			if (line.endsWith("l") && isAllowedLength(line.length()) && !hasRepeatedLetters(line)) {
				result.add(line);
			}
		}
		br.close();
		return result;
	}

	private static boolean isAllowedLength(int len) {
		for (int i : WORD_LENGTHS)
			if (i == len)
				return true;
		return false;
	}

	private static boolean hasRepeatedLetters(String s) {
		for (int i = 1; i < s.length(); i++)
			if (s.charAt(i) == s.charAt(i - 1))
				return true;
		return false;
	}

	private static int countStars(String s) {
		int c = 0;
		for (char ch : s.toCharArray())
			if (ch == '*')
				c++;
		return c;
	}

	private static boolean isValidLocal(String s) {
		if (s.startsWith(".") || s.endsWith("."))
			return false;
		if (s.contains(".."))
			return false;
		return s.matches("[a-z0-9.+]+");
	}
}
