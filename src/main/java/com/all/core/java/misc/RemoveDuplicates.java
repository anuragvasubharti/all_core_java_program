package com.all.core.java.misc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class RemoveDuplicates {

	private static final Logger logger = Logger.getLogger(RemoveDuplicates.class.getName());

	public static void main(String[] args) {

		// Read contents of file1
		String fileNameOne = "E:\\all_corejava_program\\src\\main\\java\\com\\all\\corejava\\program\\Yahoo-Fail-Mail-ID.txt";
		String stringLineOne = null;
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReaderOne = new FileReader(fileNameOne);
			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReaderOne = new BufferedReader(fileReaderOne);
			while ((stringLineOne = bufferedReaderOne.readLine()) != null) {
				System.out.println("stringLineOne: " + stringLineOne);
			}
			bufferedReaderOne.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Read contents of file2
		String fileNameTwo = "G:\\workspace-spring-tool-suite-4-4.24.0.RELEASE\\Email\\src\\email\\Yahoo-Sent-Mail-ID.txt";
		String stringLineTwo = null;
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReaderTwo = new FileReader(fileNameTwo);
			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReaderTwo = new BufferedReader(fileReaderTwo);
			while ((stringLineTwo = bufferedReaderTwo.readLine()) != null) {
				System.out.println("stringLineTwo: " + stringLineTwo);
			}
			bufferedReaderTwo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Set<String> set1 = readFile(fileNameOne);
		Set<String> set2 = readFile(fileNameTwo);

		// Remove duplicates from each set
		Set<String> uniqueSet1 = new HashSet<>(set1);
		Set<String> uniqueSet2 = new HashSet<>(set2);

		// Remove common elements from both sets
		uniqueSet1.removeAll(set2);
		uniqueSet2.removeAll(set1);

		// Write the contents of uniqueSet1 to a new file
		writeToFile("G:\\workspace-spring-tool-suite-4-4.24.0.RELEASE\\Email\\src\\email\\Yahoo-Fail-Mail-ID2.txt",
				uniqueSet1);

		// Write the contents of uniqueSet2 to a new file
		writeToFile("G:\\workspace-spring-tool-suite-4-4.24.0.RELEASE\\Email\\src\\email\\Yahoo-Sent-Mail-ID2.txt",
				uniqueSet2);
	}

	private static Set<String> readFile(String filename) {

		Set<String> set = new HashSet<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				set.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return set;
	}

	private static void writeToFile(String filename, Set<String> set) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
			for (String line : set) {
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
