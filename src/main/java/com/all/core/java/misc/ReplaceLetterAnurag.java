package com.all.core.java.misc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

public class ReplaceLetterAnurag {

	public static void main(String[] args) {

		Random random = new Random();
		String strName = "ANUR@G";
		String tempLetter = null;
		TreeSet<String> treeSet = new TreeSet<String>();
		try {
			// Assume default encoding.
			FileWriter fileWriter = new FileWriter("D:\\workspaceKepler\\EmailReader\\src\\Replaceletter.txt");
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (int i = 0; i < 10000; i++) {
				int randomInt = random.nextInt(6);
				System.out.println("randomInt " + randomInt);
				tempLetter = strName.replace(strName.charAt(randomInt), '_');
				treeSet.add(tempLetter);
				if (randomInt < 5) {
					tempLetter = tempLetter.replace(tempLetter.charAt(randomInt + 1), '_');
					treeSet.add(tempLetter);
				}
				if (randomInt < 4) {
					tempLetter = tempLetter.replace(tempLetter.charAt(randomInt + 2), '_');
					treeSet.add(tempLetter);
				}
				if (randomInt < 3) {
					tempLetter = tempLetter.replace(tempLetter.charAt(randomInt + 3), '_');
					treeSet.add(tempLetter);
				}
				// System.out.println("-----------------");
			}
			// ----------------------------------------------------------------------------------
			String tempLetter2 = null;
			tempLetter = "ANUR@G";
			for (int j = 0; j < tempLetter.length(); j++) {
				tempLetter2 = tempLetter.replace(tempLetter.charAt(j), '_');
				for (int k = 1; k < tempLetter.length(); k++) {
					tempLetter = tempLetter2.replace(tempLetter2.charAt(k), '_');
					treeSet.add(tempLetter);
				}
				tempLetter = "ANUR@G";
				// System.out.println("-----------------");
			}
			tempLetter = "ANUR@_";
			for (int j = 0; j < tempLetter.length(); j++) {
				tempLetter2 = tempLetter.replace(tempLetter.charAt(j), '_');
				for (int k = 1; k < tempLetter.length(); k++) {
					tempLetter = tempLetter2.replace(tempLetter2.charAt(k), '_');
					treeSet.add(tempLetter);
				}
				tempLetter = "ANUR@_";
				// System.out.println("-----------------");
			}
			tempLetter = "ANUR__";
			for (int j = 0; j < tempLetter.length(); j++) {
				tempLetter2 = tempLetter.replace(tempLetter.charAt(j), '_');
				for (int k = 1; k < tempLetter.length(); k++) {
					tempLetter = tempLetter2.replace(tempLetter2.charAt(k), '_');
					treeSet.add(tempLetter);
				}
				tempLetter = "ANUR__";
				// System.out.println("-----------------");
			}
			tempLetter = "ANU___";
			for (int j = 0; j < tempLetter.length(); j++) {
				tempLetter2 = tempLetter.replace(tempLetter.charAt(j), '_');
				for (int k = 1; k < tempLetter.length(); k++) {
					tempLetter = tempLetter2.replace(tempLetter2.charAt(k), '_');
					treeSet.add(tempLetter);
				}
				tempLetter = "ANU___";
				// System.out.println("-----------------");
			}
			tempLetter = "AN____";
			for (int j = 0; j < tempLetter.length(); j++) {
				tempLetter2 = tempLetter.replace(tempLetter.charAt(j), '_');
				for (int k = 1; k < tempLetter.length(); k++) {
					tempLetter = tempLetter2.replace(tempLetter2.charAt(k), '_');
					treeSet.add(tempLetter);
				}
				tempLetter = "AN____";
				// System.out.println("-----------------");
			}
			// ----------------------------------------------------------------------------------
			tempLetter = "_NUR@G";
			for (int j = 0; j < tempLetter.length(); j++) {
				tempLetter2 = tempLetter.replace(tempLetter.charAt(j), '_');
				for (int k = 1; k < tempLetter.length(); k++) {
					tempLetter = tempLetter2.replace(tempLetter2.charAt(k), '_');
					treeSet.add(tempLetter);
				}
				tempLetter = "_NUR@G";
				// System.out.println("-----------------");
			}
			tempLetter = "__UR@G";
			for (int j = 0; j < tempLetter.length(); j++) {
				tempLetter2 = tempLetter.replace(tempLetter.charAt(j), '_');
				for (int k = 1; k < tempLetter.length(); k++) {
					tempLetter = tempLetter2.replace(tempLetter2.charAt(k), '_');
					treeSet.add(tempLetter);
				}
				tempLetter = "__UR@G";
				// System.out.println("-----------------");
			}
			tempLetter = "___R@G";
			for (int j = 0; j < tempLetter.length(); j++) {
				tempLetter2 = tempLetter.replace(tempLetter.charAt(j), '_');
				for (int k = 1; k < tempLetter.length(); k++) {
					tempLetter = tempLetter2.replace(tempLetter2.charAt(k), '_');
					treeSet.add(tempLetter);
				}
				tempLetter = "___R@G";
				// System.out.println("-----------------");
			}
			tempLetter = "____@G";
			for (int j = 0; j < tempLetter.length(); j++) {
				tempLetter2 = tempLetter.replace(tempLetter.charAt(j), '_');
				for (int k = 1; k < tempLetter.length(); k++) {
					tempLetter = tempLetter2.replace(tempLetter2.charAt(k), '_');
					treeSet.add(tempLetter);
				}
				tempLetter = "____@G";
				// System.out.println("-----------------");
			}
			// ----------------------------------------------------------------------------------
			for (String strWrite : treeSet.descendingSet()) {
				bufferedWriter.write(strWrite);
				bufferedWriter.newLine();
			}
			bufferedWriter.close();
			FileReader fileReader = new FileReader("D:\\workspaceKepler\\EmailReader\\src\\ReadLetter.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String readingLine = "";
			ArrayList arrayList = new ArrayList();
			int count = 0;
			while ((readingLine = bufferedReader.readLine()) != null) {
				count++;
				// System.out.println("readingLine " + readingLine + " readingLine.length " +
				// readingLine.length());
			}
			System.out.println("count " + count);
			System.out.println("");
			System.out.println("Done ");
		} catch (IOException ioe) {
			System.out.println("IOException: " + ioe);
		}
	}
}
