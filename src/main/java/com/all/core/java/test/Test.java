package com.all.core.java.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class Test {

	private static final Logger logger = Logger.getLogger(Test.class.getName());

	static int count = 0;
	static int count2 = 0;
	static int countValid = 0;
	static int countExc = 0;

	public static void main(String args[]) {
		
		System.out.println("Main");

		// The name of the file to open.
		// String fileName =
		// "C:\\Users\\HOME\\Documents\\workspace-sts-3.7.2.RELEASE\\CoreJavaTest\\src\\OutputEmail.txt";
		// String fileName = "C:\\Users\\HOME\\Desktop\\Email\\OldMail.txt";
		// String fileName = "C:\\Users\\HOME\\Desktop\\Email\\LinkedIn.txt";
		// String fileName = "C:\\Users\\HOME\\Desktop\\Email\\LinkedInReverse.txt";

		String fileName = "E:\\Project-Anurag\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\input_output\\InputEmail.txt";
		// String fileName = "C:\\Users\\Anurag\\Desktop\\ALL13022018.xlsx";

		// The name of the file to write.
		// String fileNameOut =
		// "C:\\Users\\HOME\\Documents\\workspace-sts-3.7.2.RELEASE\\CoreJavaTest\\src\\FinalMailID.txt";
		// String fileNameOut = "C:\\Users\\HOME\\Desktop\\Email\\LinkedInReverse.txt";
		// String fileNameOut = "C:\\Users\\HOME\\Desktop\\Email\\LinkedInFinal.txt";
		String fileNameOut = "E:\\Project-Anurag\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\input_output\\OutputEmail.txt";

		// The name of the file to open.
		// String fileName2 = "C:\\Users\\Anurag\\Desktop\\TestYahoo\\FailMailID.txt";

		// This will reference one line at a time
		String line = null;
		String line2 = null;

		/*
		 * Set<String> aList = new TreeSet<String>(); Set<String> aList2 = new
		 * TreeSet<String>(); Set<String> aList3 = new TreeSet<String>(); Set<String>
		 * aList4 = new TreeSet<String>();
		 */
		Set<String> aList = new HashSet<String>();
		Set<String> aList2 = new HashSet<String>();
		Set<String> aList3 = new HashSet<String>();
		Set<String> aList4 = new HashSet<String>();

		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);
			// FileReader fileReader2 = new FileReader(fileName2);
			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			// BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
			// Assume default encoding.
			FileWriter fileWriter = new FileWriter(fileNameOut);
			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			while ((line = bufferedReader.readLine()) != null) {
				String string = line;
				// String[] abc = string.split(",");
				// System.out.println("-------> " + abc.length);
				aList.add(string);
			}
			/*
			 * while ((line2 = bufferedReader2.readLine()) = null) { String string = line2;
			 * aList2.add(string); }
			 */

			// Removing duplicate
			/*
			 * for (String str2 : aList2){ System.out.println("Removing duplicate");
			 * if(aList.contains(str2)){ aList.remove((String)str2); count2++; } }
			 */

			for (String str : aList) {
				String reverse = new StringBuffer(str).reverse().toString();

				// System.out.println("reverse ---> "+ reverse +" reverse.length() -----> "+
				// reverse.length());
				// if (emailValidator(str)) {
				// if (emailValidator(reverse)) {
				count++;
				bufferedWriter.write(reverse);
				// bufferedWriter.write(str);
				bufferedWriter.newLine();
				// }
			}
			/*
			 * while ((line = bufferedReader.readLine()) = null) { System.out.println(line);
			 * String string = line; String revers = new
			 * StringBuffer(string).reverse().toString(); System.out.println(revers);
			 * bufferedWriter.write(string); bufferedWriter.write(revers);
			 * bufferedWriter.newLine(); }
			 */

			// Always close files.
			bufferedWriter.close();
			bufferedReader.close();

			System.out.println("Total count: " + count);
			// System.out.println("Total duplicate count: "+count2);
			// System.out.println("Total countValid: "+countValid);
			// System.out.println("Total countExc: "+countExc);

		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}

	/*
	 * public static void main(String args[]) { // TreeSet of String Type
	 * //TreeSet<String> tset = new TreeSet<String>(); ArrayList<String> a = new
	 * ArrayList<String>(); HashSet<String> hset = new HashSet<String>();
	 * 
	 * // Adding elements to TreeSet<String> tset.add("ABC"); tset.add("String");
	 * tset.add("Test"); tset.add("Pen"); tset.add("Ink"); tset.add("Jack");
	 * //Displaying TreeSet System.out.println(tset); // TreeSet of Integer Type
	 * TreeSet<Integer> tset2 = new TreeSet<Integer>(); // Adding elements to
	 * TreeSet<Integer> tset2.add(88); tset2.add(7); tset2.add(101); tset2.add(0);
	 * tset2.add(3); tset2.add(222); System.out.println(tset2); }
	 */
}
