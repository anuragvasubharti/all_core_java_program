package com.all.core.java.email.validator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class RegexMultipleEmailAddressValidation {

	private static final Logger logger = Logger.getLogger(RegexMultipleEmailAddressValidation.class.getName());

	/**
	 * Define a regular expression to validate multiple email addresses. I think the
	 * following expression is more complex that it has to be. We can think of
	 * refactoring it at some later point. But it works just fine right now.
	 */
	public static String regex = "(([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4}))(((;|,|; | ;| ; | , | ,){1}"
			+ "([A-Za-z0-9_\\-\\.])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,4}))*)";

	public static String regex1 = "^[A-Za-z0-9+_.-=/\"]+@(.+)$";

	public static String regex2 = "((?=.*[a-z])(?=.*d)(?=.*[@#$%])(?=.*[A-Z]).{6,16})";

	/*
	 * Regex for password validation (?=.*[a-z]) : This matches the presence of at
	 * least one lowercase letter. (?=.*d) : This matches the presence of at least
	 * one digit i.e. 0-9. (?=.*[@#$%]) : This matches the presence of at least one
	 * special character. ((?=.*[A-Z]) : This matches the presence of at least one
	 * capital letter. {6,16} : This limits the length of password from minimum 6
	 * letters to maximum 16 letters.
	 */

	public static int countInvalid = 0;
	public static int countValid = 0;

	public static void main(String[] args) {
		/**
		 * Validate various email addresses
		 */

		String inputFileName = "D:\\workspaceKepler\\CoreJavaPoject\\src\\OutputEmail.txt";
		// String inputFileName =
		// "D:\\workspaceKepler\\EmailReader\\src\\OutputEmail1.txt";

		// String inputFileName = "C:\\Users\\Anurag\\Desktop\\New
		// folder\\1923_Input.txt";

		String line = null;
		// Set<String> aList = new HashSet<String>();
		Set<String> aList = new TreeSet<String>();
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(inputFileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			// -------------------------------------------------------------

			String outputFileName = "D:\\workspaceKepler\\CoreJavaPoject\\src\\InputEmail.txt";

			// String outputFileName = "C:\\Users\\Anurag\\Desktop\\New
			// folder\\1923_Output.txt";

			// Assume default encoding.
			FileWriter fileWriter = new FileWriter(outputFileName);

			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			// --------------------------------------------------------------

			while ((line = bufferedReader.readLine()) != null) {
				// System.out.println("line --- > " + line);
				String[] arrayOfString = line.split(" ");
				for (String string : arrayOfString) {
					string = string.replace("<", "\n");
					string = string.replace(">", "\n");
					string = string.replace(":", "\n");
					string = string.replace("/", "\n");
					string = string.replace("\"", "\n");
					string = string.replace(";", "\n");
					string = string.replace("[", "\n");
					string = string.replace("]", "\n");

					// string = string.replaceAll(" ","");
					string = string.toString().trim();
					// System.out.println("After calling all methods splitFromString " + string);
					aList.add(string);
				}
			}

			// Sorting HashSet using
			List<String> tempList = new ArrayList<String>(aList);
			Collections.sort(tempList);

			System.out.println("List size... " + tempList.size());
			for (String eMailID : tempList) {
				// System.out.println("eMailID " + eMailID);

				boolean b = isValid(eMailID);
				if (b != false) {
					countValid++;
					// System.out.println("Valid eMail ID "+ eMailID);
					bufferedWriter.write(eMailID);
					bufferedWriter.newLine();
				} else {
					System.out.println("InValid eMail ID " + eMailID);
					// tempList.remove((String) eMailID);
					countInvalid++;
				}
			}
			// Always close files.
			bufferedWriter.close();
			bufferedReader.close();
			System.out.println("");
			System.out.println("Total Valid eMail ID... " + countValid);
			System.out.println("Total Invalid eMail ID... " + countInvalid);

		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + inputFileName + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + inputFileName + "'");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		/*
		 * isValid("billgates@badmicrosoft.com"); isValid("billgates@nation.wide.com");
		 * isValid("123@badmicrosoft.com"); isValid("'billgates@badmicrosoft.com'");
		 * isValid("billgates@badmicrosoft.123"); isValid("abc.def@badmicrosoft.com");
		 * isValid("abc.\\def@badmicrosoft.com"); isValid("abc_def@badmicrosoft.com");
		 * isValid("abc_def.@badmicrosoft.com"); isValid("abc_def-@badmicrosoft.com");
		 * isValid("^billgates@badmicrosoft.com");
		 * isValid("billgates@badmicrosoft.com;noreply@badmicrosoft.com");
		 * isValid("billgates@badmicrosoft.com,noreply@badmicrosoft.com");
		 * isValid("billgates@badmicrosoft.com;;noreply@badmicrosoft.com");
		 * isValid("billgates@badmicrosoft.com;,noreply@badmicrosoft.com");
		 * isValid("billgates@badmicrosoft.com; noreply@badmicrosoft.com");
		 * isValid("billgates@badmicrosoft.com ; noreply@badmicrosoft.com");
		 * isValid("billgates@badmicrosoft.com , noreply@badmicrosoft.com");
		 * isValid("billgates@badmicrosoft.com,,noreply@badmicrosoft.com");
		 * isValid("billgates@badmicrosoft.com  noreply@badmicrosoft.com");
		 * isValid("billgates@badmicrosoft.verybad@microsoft.com");
		 */

	}

	/**
	 * @param email - The Email Address to be validated
	 * @return true if the email address is valid, else return false.
	 * 
	 *         Uses the regular expression defined above to do the validation.
	 */
	public static boolean isValid(String email) {
		// System.out.println(email + " >>>>>>>> is Valid? " + Pattern.matches(regex,
		// email));
		// return Pattern.matches(regex, email);
		return Pattern.matches(regex1, email);
		// return Pattern.matches(regex2, email);
	}

}