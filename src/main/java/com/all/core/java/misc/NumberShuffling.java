package com.all.core.java.misc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public class NumberShuffling {
	
	public static void main(String[] args) {
		
		int count = 0;
		// List<Integer> passwords = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
		List<Integer> passwords = Arrays.asList(0, 0, 1, 1, 2, 3, 5, 6, 6, 7, 7, 8, 9, 9);
		System.out.println("---> " + passwords.size());
		;
		String fileNameOut = "D:\\workspaceKepler\\EmailReader\\src\\OutputEmail1.txt";
		Set<String> combinationsOfString = new TreeSet<String>();
		// List<String> combinationsOfString = new ArrayList<String>();
		try {
			// Assume default encoding.
			FileWriter fileWriter = new FileWriter(fileNameOut);
			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (long i = 0; i < 999999999; i++) {

				Collections.shuffle(passwords);
				String numberShuffling = toFlatString(passwords);
				combinationsOfString.add(numberShuffling.substring(0, 4));
				// combinationsOfString.add(numberShuffling.toString());
				// System.out.println("Number Count: " + i);
				if (count == 5000) {
					break;
				}
				count++;
			}
			System.out.println("Size " + combinationsOfString.size());

			// Collections.sort(combinationsOfString);
			for (String str : combinationsOfString) {

				System.out.println(" str ---> " + str);
				// System.out.print(str);
				bufferedWriter.write(str);
				// bufferedWriter.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String toFlatString(List<Integer> list) {
		StringBuilder sb = new StringBuilder();
		for (int i : list)
			sb.append(i);
		return sb.toString();
	}
}
