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

public class EnglishWordGmailGenerator {

	private static final String BASE_PATH = "E:\\Project-Anurag\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\gmail\\Id\\generator\\";

	private static final String INPUT_FILE = BASE_PATH + "words_ending_with_l.txt";
	private static final String OUTPUT_FILE = BASE_PATH + "gmail_english_word_ids.txt";
	private static final String DOMAIN = "@gmail.com";

	private static final int[] WORD_LENGTHS = { 2, 3, 4, 7, 8, 9, 10, 13, 14, 15 };

	private static final String[] PATTERNS = { "sakshi*************l", "sakshi.************l", "sakshivirha********l",
			"sakshi.virha*******l", "sakshi.virha.******l", "sakshivirha.cloud**l", "sakshivirha.cloud.*l",
			"sakshivirha.devops*l" };

	private static final ExecutorService EXECUTOR = Executors
			.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

	private static final AtomicLong COUNTER = new AtomicLong(0);

	public static void main(String[] args) throws Exception {

		List<String> words = loadWords();

		BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE));

		for (String pattern : PATTERNS) {
			EXECUTOR.submit(() -> processPattern(pattern, words, writer));
		}

		EXECUTOR.shutdown();
		EXECUTOR.awaitTermination(1, TimeUnit.HOURS);

		writer.write("\nTOTAL EMAIL IDs GENERATED: " + COUNTER.get());
		writer.close();

		System.out.println("\nTOTAL EMAIL IDs GENERATED: " + COUNTER.get());
	}

	private static void processPattern(String pattern, List<String> words, BufferedWriter writer) {
		try {
			for (String word : words) {
				for (int digits = 1; digits <= 3; digits++) {

					String num = "1".repeat(digits);
					String local = pattern.replace("*", "") + num + word;

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
		} catch (Exception ignored) {
		}
	}

	private static List<String> loadWords() throws Exception {
		List<String> list = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE));
		String line;

		while ((line = br.readLine()) != null) {
			line = line.trim().toLowerCase();
			if (line.endsWith("l") && isAllowedWordLength(line.length()) && !hasRepeatedChars(line)) {
				list.add(line);
			}
		}
		br.close();
		return list;
	}

	private static boolean isAllowedWordLength(int len) {
		for (int l : WORD_LENGTHS)
			if (l == len)
				return true;
		return false;
	}

	private static boolean hasRepeatedChars(String s) {
		for (int i = 1; i < s.length(); i++)
			if (s.charAt(i) == s.charAt(i - 1))
				return true;
		return false;
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
