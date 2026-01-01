// Java program to read all mobile numbers 
// present in given file 
package com.all.core.java.misc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class MobileNumberExtraction {
	
	public static void main(String[] args) throws IOException {
		
		// Write Mobile Numbers to output.txt file
		PrintWriter pw = new PrintWriter("output.txt");

		// Regular expression for mobile number
		Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");

		// BufferedReader for reading from input.txt file
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		String line = br.readLine();

		while (line != null) {
			Matcher m = p.matcher(line);

			while (m.find()) {
				// Write the mobile number to output.txt file
				pw.println(m.group());
			}

			line = br.readLine();
		}
		pw.flush();
	}
}