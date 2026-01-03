package com.all.core.java.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class Test_Two implements Comparable<String> {

	private static final Logger logger = Logger.getLogger(Test_Two.class.getName());

	static int count = 0;
	static Integer keyCount = 0;
	static int countValid = 0;
	static int countExc = 0;

	public static String regex = "(([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4}))(((;|,|; | ;| ; | , | ,){1}"
			+ "([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4}))*)";

	// public static String regex1 = "^[A-Za-z0-9+_.-=/\"]+@(.+)$";
	public static String regex1 = "^[A-Za-z0-9+_.-=/\"]+@$";

	public static void main(String args[]) {

		// The name of the file to open.
		String fileName = "E:\\Project-Anurag\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\input_output\\InputEmail.txt";
		// String fileName = "C:\\Users\\Anurag\\Desktop\\ALL13022018.xlsx";

		// The name of the file to write.
		String fileNameOut = "E:\\Project-Anurag\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\input_output\\OutputEmail.txt";

		// This will reference one line at a time
		String inputEmail = null;

		Set<String> treeSetList = new TreeSet<String>(Collections.reverseOrder());

		// Creating a TreeMap
		SortedMap<Integer, String> treeMapList = new TreeMap<>();
		// SortedMap<String, Integer> treeMapList = new TreeMap<>();

		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			// System.out.println(" "+ bufferedReader.read());
			// System.out.println(" "+ bufferedReader.readLine());
			// System.out.println(" "+ bufferedReader.toString());
			// System.out.println(" "+ bufferedReader.getClass());
			// System.out.println(" "+ bufferedReader.lines());
			// System.out.println(" "+ bufferedReader.markSupported());
			// System.out.println(" "+ bufferedReader.ready());
			// bufferedReader.reset();

			while ((inputEmail = bufferedReader.readLine()) != null) {

				if (Pattern.matches(regex1, inputEmail) != false) {
					// System.out.println("Valid Email ---> " + inputEmail);
					treeSetList.add(inputEmail);
					String[] splitEmail = inputEmail.split("@");
					for (String str : splitEmail) {
						System.out.println("-------------> " + str);
					}

				} else {
					System.out.println("InValid Email ------------> " + inputEmail);
				}

				// treeMapList.put(keyCount++, inputEmail);
				// treeMapList.put(line, keyCount++);
			}

			bufferedReader.close();

			// Printing the TreeSet (Output will be sorted based on *******)
			// System.out.println(treeSetList);

			// Printing the TreeMap (Output will be sorted based on keys)
			// System.out.println(treeMapList);

//-----------------------------------------------------------------------------------------------------------	        

			// Assume default encoding.
			FileWriter fileWriter = new FileWriter(fileNameOut);

			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			Object[] arrayList = treeSetList.toArray();

			System.out.println("");
			for (String str : treeSetList) {
				// System.out.println("str ---> " + str);
				// bufferedWriter.write(str);

				String reverse = new StringBuffer(str).reverse().toString();
				// System.out.println("reverse ---> " + reverse);
				bufferedWriter.write(reverse);

				bufferedWriter.newLine();
				count++;
			}

			// Always close files.
			bufferedWriter.close();
			System.out.println("");
			System.out.println("Total count: " + count);

		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	@Override
	public int compareTo(String o) {
		// TODO Auto-generated method stub
		return 0;
	}
}