package com.all.core.java.sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Logger;

public class MySortingRtoL {

	private static final Logger logger = Logger.getLogger(MySortingRtoL.class.getName());

	public static void main(String args[]) {

		try {
			String readingLine = null;
			StringBuffer stringBuffer = null;

			String fileName = "E:\\Project-Anurag\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\input_output\\InputEmail1.txt";
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(fileName);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String fileNameOut = "E:\\Project-Anurag\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\input_output\\OutputEmail2.txt";
			// Assume default encoding.
			FileWriter fileWriter = new FileWriter(fileNameOut);

			// Always wrap FileWriter in BufferedWriter.
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			Set<String> treeSet = new TreeSet<String>();
			// Set<Character> treeSet = new TreeSet<Character>();

			List<String> list = new ArrayList<String>();
			// List<Character[]> list = new ArrayList<Character[]>();

			while ((readingLine = bufferedReader.readLine()) != null) {

				// Logic 1
				String tempString = new StringBuffer(readingLine).reverse().toString().trim();
				treeSet.add(tempString);
				// System.out.println("line 1 ---> " + readingLine);
				// System.out.println("line 2 ---> " + tempString);

				// Logic 2
				char[] chStr = new char[readingLine.toCharArray().length];
				for (int i = 0, j = readingLine.toCharArray().length - 1; i < readingLine.toCharArray().length; i++) {

					chStr[i] = readingLine.charAt(j);
					j--;
				}

				String charArrayToString = String.valueOf(chStr);
				list.add(charArrayToString);
			}
			// System.out.println("list.size() " + list.size());
			Collections.sort(list);
			LinkedHashSet<StringBuffer> linkedset = new LinkedHashSet<StringBuffer>();

			for (String charString : list) {
				System.out.println(charString);
				StringBuffer sbString = new StringBuffer();
				sbString = sbString.append(charString).reverse();
				linkedset.add(sbString);
				// System.out.println(sbString + " ");
			}
			// System.out.println("linkedset.size() " + linkedset.size());
			for (StringBuffer charString : linkedset) {
				System.out.println(charString);
				bufferedWriter.write(charString.toString());
				bufferedWriter.newLine();
			}

			// ------------------------------------------------------------
			for (String str : treeSet) {
				// System.out.println("str " + str);
				str = new StringBuffer(str).reverse().toString().trim();
				// bufferedWriter.write(str);
				// bufferedWriter.newLine();
			}

			/*
			 * for(char[] chara : list){
			 * 
			 * int j = chara.length; for(int i = 0; i < chara.length; i++){
			 * 
			 * //System.out.print(i + " -> " + chara[i] + " " + chara.length + " ");
			 * System.out.print(chara[i]); bufferedWriter.write(chara[i]); if((i + 1) == j){
			 * System.out.println(""); bufferedWriter.newLine(); } } }
			 */

			bufferedWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
