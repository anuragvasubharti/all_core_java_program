package com.all.core.java.gmail.Id.generator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class WordsEndingWithLFilter {

	// Allowed word lengths
	private static final Set<Integer> VALID_LENGTHS = new HashSet<>(
			Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14));

	public static void main(String[] args) {

		String inputFile = "E:\\Project-Sakshi\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\gmail\\Id\\generator\\filtered_l_words.txt";
		String outputFile = "words_ending_with_l.txt";

		Set<String> filteredWords = new TreeSet<>(); // auto-sorted & unique

		try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {

			String line;
			while ((line = reader.readLine()) != null) {
				String word = line.trim().toLowerCase();

				if (isValidWord(word)) {
					filteredWords.add(word);
				}
			}

		} catch (IOException e) {
			System.err.println("Error reading input file: " + e.getMessage());
			return;
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

			for (String word : filteredWords) {
				writer.write(word);
				writer.newLine();
			}

		} catch (IOException e) {
			System.err.println("Error writing output file: " + e.getMessage());
			return;
		}

		System.out.println("====================================");
		System.out.println("Filtering completed successfully!");
		System.out.println("Total words generated: " + filteredWords.size());
		System.out.println("Output file: " + outputFile);
		System.out.println("====================================");
	}

	private static boolean isValidWord(String word) {
		return word.endsWith("l") && word.matches("[a-z]+") && VALID_LENGTHS.contains(word.length());
	}
}