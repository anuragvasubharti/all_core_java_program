package com.all.core.java.gmail.Id.generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class GmailIdDigitGenerator {

	private static final String BASE_PATH = "E:\\Project-Anurag\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\gmail\\Id\\generator\\";

	private static final String OUTPUT_FILE = BASE_PATH + "gmail_ids_digits.txt";
	private static final String DOMAIN = "@gmail.com";

	private static final int[] DIGIT_LENGTHS = { 6, 7, 8, 9 };

	private static final List<String> PATTERNS = List.of("sakshi**************8", "sakshi.*************8",
			"sakshivirha*********8", "sakshi.virha********8", "sakshi.virha.*******8");

	private static final AtomicLong COUNT = new AtomicLong();

	public static void main(String[] args) throws Exception {

		ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

		BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE));

		for (String pattern : PATTERNS) {
			pool.submit(() -> processPattern(pattern, writer));
		}

		pool.shutdown();
		pool.awaitTermination(1, TimeUnit.HOURS);

		writer.write("\nTOTAL EMAIL IDs GENERATED: " + COUNT.get());
		writer.close();

		System.out.println("\nTOTAL EMAIL IDs GENERATED: " + COUNT.get());
	}

	private static void processPattern(String pattern, BufferedWriter writer) {
		try {
			int starCount = countStars(pattern);
			if (!allowedDigitLength(starCount))
				return;

			long limit = (long) Math.pow(10, starCount - 1);

			for (long i = 0; i < limit; i++) {
				String num = String.format("%0" + (starCount - 1) + "d", i) + "8";

				String local = pattern.replace("*", "") + num;

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

	private static boolean allowedDigitLength(int len) {
		for (int i : DIGIT_LENGTHS)
			if (i == len)
				return true;
		return false;
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
