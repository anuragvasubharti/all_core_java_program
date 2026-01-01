package com.all.core.java.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.TreeSet;
import java.util.logging.Logger;

public class TestStringGenNumber {

	private static final Logger logger = Logger.getLogger(TestStringGenNumber.class.getName());

	public static void main(String args[]) {

		String str = "line.separator" + "," + "<h1>Amazon SES SMTP Email Test</h1>" + ","
				+ "<p>This email was sent with Amazon SES using the " + ","
				+ "<a href='https://github.com/javaee/javamail'>Javamail Package</a>" + ","
				+ " for <a href='https://www.java.com'>Java</a>.";
		
		// System.out.println(str);
		// System.out.println("---> " + System.getProperty("line.separator"));
		
		FileWriter oneDigitFileWriter = null, twoDigitFileWriter = null, threeDigitFileWriter = null,
				fourDigitFileWriter = null, fiveDigitFileWriter = null, sixDigitFileWriter = null;
		BufferedWriter oneDigitBufferedWriter = null, twoDigitBufferedWriter = null, threeDigitBufferedWriter = null,
				fourDigitBufferedWriter = null, fiveDigitBufferedWriter = null, sixDigitBufferedWriter = null;
		String oneDigitFileOut = null, twoDigitFileOut = null, threeDigitFileOut = null, fourDigitFileOut = null,
				fiveDigitFileOut = null, sixDigitFileOut = null;
		File oneDigitFile = null, twoDigitFile = null, threeDigitFile = null, fourDigitFile = null,
				fiveDigitFile = null, sixDigitFile = null;
		try {
			oneDigitFile = new File("D:\\workspaceKepler\\EmailReader\\src\\oneDigitFile.txt");
			twoDigitFile = new File("D:\\workspaceKepler\\EmailReader\\src\\twoDigitFile.txt");
			threeDigitFile = new File("D:\\workspaceKepler\\EmailReader\\src\\threeDigitFile.txt");
			fourDigitFile = new File("D:\\workspaceKepler\\EmailReader\\src\\fourDigitFile.txt");
			fiveDigitFile = new File("D:\\workspaceKepler\\EmailReader\\src\\fiveDigitFile.txt");
			sixDigitFile = new File("D:\\workspaceKepler\\EmailReader\\src\\sixDigitFile.txt");
			// Create the file
			if (oneDigitFile.createNewFile() || twoDigitFile.createNewFile() || threeDigitFile.createNewFile()
					|| sixDigitFile.createNewFile() || fiveDigitFile.createNewFile() || oneDigitFile.createNewFile()) {
				System.out.println("File is created");
			} else {
				System.out.println("File already exists.");
			}
			oneDigitFileOut = oneDigitFile.getAbsolutePath();
			System.out.println("oneDigitFileOut " + oneDigitFileOut);
			// Assume default encoding.
			oneDigitFileWriter = new FileWriter(oneDigitFileOut);
			// Always wrap FileWriter in BufferedWriter.
			oneDigitBufferedWriter = new BufferedWriter(oneDigitFileWriter);
			// ---------------------------------------------------------------------------
			twoDigitFileOut = twoDigitFile.getAbsolutePath();
			System.out.println("twoDigitFileOut " + twoDigitFileOut);
			// Assume default encoding.
			twoDigitFileWriter = new FileWriter(twoDigitFileOut);
			// Always wrap FileWriter in BufferedWriter.
			twoDigitBufferedWriter = new BufferedWriter(twoDigitFileWriter);
			// ---------------------------------------------------------------------------
			threeDigitFileOut = threeDigitFile.getAbsolutePath();
			System.out.println("threeDigitFileOut " + threeDigitFileOut);
			// Assume default encoding.
			threeDigitFileWriter = new FileWriter(threeDigitFileOut);
			// Always wrap FileWriter in BufferedWriter.
			threeDigitBufferedWriter = new BufferedWriter(threeDigitFileWriter);
			// ---------------------------------------------------------------------------
			fourDigitFileOut = fourDigitFile.getAbsolutePath();
			System.out.println("fourDigitFileOut " + fourDigitFileOut);
			// Assume default encoding.
			fourDigitFileWriter = new FileWriter(fourDigitFileOut);
			// Always wrap FileWriter in BufferedWriter.
			fourDigitBufferedWriter = new BufferedWriter(fourDigitFileWriter);
			// ---------------------------------------------------------------------------
			fiveDigitFileOut = fiveDigitFile.getAbsolutePath();
			System.out.println("fiveDigitFileOut " + fiveDigitFileOut);
			// Assume default encoding.
			fiveDigitFileWriter = new FileWriter(fiveDigitFileOut);
			// Always wrap FileWriter in BufferedWriter.
			fiveDigitBufferedWriter = new BufferedWriter(fiveDigitFileWriter);
			// ---------------------------------------------------------------------------
			sixDigitFileOut = sixDigitFile.getAbsolutePath();
			System.out.println("sixDigitFileOut " + oneDigitFileOut);
			// Assume default encoding.
			sixDigitFileWriter = new FileWriter(sixDigitFileOut);
			// Always wrap FileWriter in BufferedWriter.
			sixDigitBufferedWriter = new BufferedWriter(sixDigitFileWriter);
			TreeSet<String> oneDigit = new TreeSet<String>();
			TreeSet<String> twoDigit = new TreeSet<String>();
			TreeSet<String> threeDigit = new TreeSet<String>();
			TreeSet<String> fourDigit = new TreeSet<String>();
			TreeSet<String> fiveDigit = new TreeSet<String>();
			TreeSet<String> sixDigit = new TreeSet<String>();
			for (int i = 0; i < 1000000; i++) {
				String numberAsString = String.valueOf(i);
				if (numberAsString.length() == 1) {
					numberAsString = "00000" + numberAsString;
					System.out.println(" numberAsString 1 " + numberAsString);
					oneDigit.add(numberAsString);
				}
				if (numberAsString.length() == 2) {
					numberAsString = "0000" + numberAsString;
					// System.out.println(" numberAsString 2 " + numberAsString);
					twoDigit.add(numberAsString);
				}
				if (numberAsString.length() == 3) {
					numberAsString = "000" + numberAsString;
					// System.out.println(" numberAsString 3 " + numberAsString);
					threeDigit.add(numberAsString);
				}
				if (numberAsString.length() == 4) {
					// numberAsString = "00" + numberAsString;
					// System.out.println(" numberAsString 4 " + numberAsString);
					fourDigit.add(numberAsString);
				}
				if (numberAsString.length() == 5) {
					numberAsString = "0" + numberAsString;
					// System.out.println(" numberAsString 5 " + numberAsString);
					fiveDigit.add(numberAsString);
				}
				if (numberAsString.length() == 6) {
					// System.out.println(" numberAsString 6 " + numberAsString);
					sixDigit.add(numberAsString);
				}
			}
			int i = 0;
			for (String strOne : oneDigit) {
				// System.out.println(" oneDigit " + oneDigit.size());
				oneDigitBufferedWriter.write(strOne + " ");
				if (i == 10) {
					oneDigitBufferedWriter.newLine();
					i = 0;
				}
				i++;
			}
			for (String strTwo : twoDigit) {
				twoDigitBufferedWriter.write(strTwo + " ");
				if (i == 10) {
					twoDigitBufferedWriter.newLine();
					i = 0;
				}
				i++;
			}
			for (String strThree : threeDigit) {
				threeDigitBufferedWriter.write(strThree + " ");
				if (i == 10) {
					threeDigitBufferedWriter.newLine();
					i = 0;
				}
				i++;
			}
			for (String strFour : fourDigit) {
				fourDigitBufferedWriter.write(strFour);
				fourDigitBufferedWriter.newLine();
				/*
				 * fourDigitBufferedWriter.write(strFour + " "); if(i == 10){
				 * fourDigitBufferedWriter.newLine(); i = 0; } i++;
				 */
			}
			for (String strFive : fiveDigit) {
				fiveDigitBufferedWriter.write(strFive);
				fiveDigitBufferedWriter.newLine();
				/*
				 * if(i == 10){ fiveDigitBufferedWriter.newLine(); i = 0; } i++;
				 */
			}
			for (String strSix : sixDigit) {
				sixDigitBufferedWriter.write(strSix);
				sixDigitBufferedWriter.newLine();
				/*
				 * if(i == 10){ sixDigitBufferedWriter.newLine(); i = 0; } i++;
				 */
			}

			oneDigitBufferedWriter.close();
			twoDigitBufferedWriter.close();
			threeDigitBufferedWriter.close();
			fourDigitBufferedWriter.close();
			fiveDigitBufferedWriter.close();
			sixDigitBufferedWriter.close();
			System.out.println("Done... ");

		} catch (Exception ioe) {
			ioe.printStackTrace();
		}
	}
}
