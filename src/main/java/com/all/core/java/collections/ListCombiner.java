package com.all.core.java.collections;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;

public class ListCombiner {

	private static final Logger logger = Logger.getLogger(ListCombiner.class.getName());

	public static void main(String[] args) {

		String file1 = "E:\\Project-Anurag\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\input_output\\ListCombiner1";
		String file2 = "E:\\Project-Anurag\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\input_output\\ListCombiner2";

		try {
			// Read all lines from both files into lists
			List<String> list1 = Files.readAllLines(Paths.get(file1));
			List<String> list2 = Files.readAllLines(Paths.get(file2));
			// Generate and print combinations
			for (String item1 : list1) {
				for (String item2 : list2) {
					System.out.println(item1 + item2);
				}
			}
		} catch (IOException e) {

			System.err.println("Error reading files: " + e.getMessage());
		}
	}
}
