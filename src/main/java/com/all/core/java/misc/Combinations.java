package com.all.core.java.misc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Set;
import java.util.TreeSet;

public class Combinations {

	// private StringBuilder output = new StringBuilder();
	private StringBuffer output = new StringBuffer();
	private final String inputstring;

	public Combinations(final String str) {
		inputstring = str;
		System.out.println("The input string  is  : " + inputstring);
	}

	public static void main(String args[]) {
		// Combinations combobj = new
		// Combinations("#$%@012356789abdefghijklmnprstuvy");
		// Combinations combobj = new Combinations("#$%@");
		Combinations combobj = new Combinations("0123456789");
		// Combinations combobj = new Combinations("abdefghijklmnprstuvy");
		// Combinations combobj = new
		// Combinations("##$%@00112356677899aaaaaaaaabdeefgghhhhiiijjkkllmmnnnpprrssstttuuuuuvy");
		// Combinations combobj = new
		// Combinations("aaaaaaaaabdeefgghhhhiiijjkkllmmnnnpprrssstttuuuuuvy");

		System.out.println("");
		System.out.println("All possible combinations are :  ");
		System.out.println("");
		combobj.combine();
	}

	public void combine() {
		combine(0);
	}

	int count = 0;
	String strTest = null;
	String fileNameOut = "D:\\workspaceKepler\\EmailReader\\src\\OutputEmail1.txt";
	Set<String> combinationsOfString = new TreeSet<String>();
	// List<String> combinationsOfString = new ArrayList<String>();

	public void combine(int start) {
		try {

			// Assume default encoding.
			FileWriter fileWriter = new FileWriter(fileNameOut);

			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			String sb = null;

			for (int i = start; i < inputstring.length(); ++i) {

				output.append(inputstring.charAt(i));
				// System.out.println(" charAt(i) " + inputstring.charAt(i) + "
				// inputstring.length() " + inputstring.length() + " output 111 ---> " +
				// output.toString());
				combinationsOfString.add(output.toString());
				sb = new StringBuffer(output.toString()).reverse().toString();
				combinationsOfString.add(sb);
				if (i < inputstring.length()) {
					combine(i + 1);
				}
				output.setLength(output.length() - 1);
				// if (output != null) {
				if (count == 100000) {
					break;
				}
				// }
				System.out.println(i + " output ---> " + output.toString());
				System.out.println(i + " sb ---> " + sb);
				count++;
			}
			// System.out.println("");
			for (String sbCombi : combinationsOfString) {

				if (sbCombi != null) {
					// System.out.println("sbCombi ### " + sbCombi.toString() + "
					// combinationsOfString $$$ " + combinationsOfString.size());
					bufferedWriter.write(sbCombi);
					bufferedWriter.newLine();
					/*
					 * if(count == 5000){ break; }
					 */
				}
				// count++;
			}
			// Always close files.
			bufferedWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}