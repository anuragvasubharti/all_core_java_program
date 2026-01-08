package com.all.core.java.gmail.Id.generator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class GmailIdWordGenerator {

	private static final String BASE_PATH = "E:\\Project-Anurag\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\gmail\\Id\\generator\\";

	private static final String INPUT_FILE = BASE_PATH + "words_ending_with_l.txt";
	private static final String OUTPUT_FILE = BASE_PATH + "gmail_ids_words.txt";

	private static final String DOMAIN = "@gmail.com";
	private static final int[] ALLOWED_WORD_LENGTHS = { 6, 7, 8, 9, 13, 14 };

	private static final List<String> PATTERNS = List.of("sakshi*************l", "sakshi**************l",
			"sakshi.*************l", "sakshi.**************l", "sakshivirha********l", "sakshivirha*********l",
			"sakshi.virha*******l", "sakshi.virha********l", "sakshi.virha.******l", "sakshi.virha.*******l");

	private static final AtomicLong COUNT = new AtomicLong();

	public static void main(String[] args) throws Exception {

		List<String> words = loadWords();
		ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

		BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE));

		for (String pattern : PATTERNS) {
			pool.submit(() -> processPattern(pattern, words, writer));
		}

		pool.shutdown();
		pool.awaitTermination(1, TimeUnit.HOURS);

		writer.write("\nTOTAL EMAIL IDs GENERATED: " + COUNT.get());
		writer.close();

		System.out.println("\nTOTAL EMAIL IDs GENERATED: " + COUNT.get());
	}

	private static void processPattern(String pattern, List<String> words, BufferedWriter writer) {
		try {
			int starCount = countStars(pattern);
			for (String word : words) {
				if (word.length() != starCount)
					continue;

				String local = pattern.replace("*", "") + word;
				if (!validLocal(local))
					continue;

				String email = local + DOMAIN;

				synchronized (writer) {
					writer.write(email);
					writer.newLine();
				}

				System.out.println(email);
				COUNT.incrementAndGet();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static List<String> loadWords() throws Exception {
		List<String> list = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE))) {
			String line;
			while ((line = br.readLine()) != null) {
				line = line.trim().toLowerCase();
				if (line.endsWith("l") && allowedWordLength(line.length()) && noRepeatedLetters(line)) {
					list.add(line);
				}
			}
		}
		return list;
	}

	private static boolean allowedWordLength(int len) {
		for (int i : ALLOWED_WORD_LENGTHS)
			if (i == len)
				return true;
		return false;
	}

	private static boolean noRepeatedLetters(String s) {
		for (int i = 1; i < s.length(); i++)
			if (s.charAt(i) == s.charAt(i - 1))
				return false;
		return true;
	}

	private static boolean validLocal(String s) {
		int len = s.length();
		if (len != 20 && len != 21)
			return false;
		if (s.startsWith(".") || s.endsWith("."))
			return false;
		if (s.contains(".."))
			return false;
		return s.matches("[a-z0-9.]+");
	}

	private static int countStars(String s) {
		int c = 0;
		for (char ch : s.toCharArray())
			if (ch == '*')
				c++;
		return c;
	}
}
