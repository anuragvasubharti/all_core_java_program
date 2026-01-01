package com.all.core.java.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;
import java.util.logging.Logger;

public class ReadFileFromHarddisk {

	private static final Logger logger = Logger.getLogger(ReadFileFromHarddisk.class.getName());

	public static void main(String[] args) {

		try {

			TreeSet<String> fileOne = new TreeSet<String>();
			TreeSet<String> fileSecond = new TreeSet<String>();
			TreeSet<String> fileThird = new TreeSet<String>();

			FileReader fileReaderOne = new FileReader(
					"C:\\Users\\Anurag\\Desktop\\Gem Source IT Consulting Pvt Ltd\\linkedin\\new60.txt");
			// FileReader fileReaderOne = new FileReader("C:\\Users\\Anurag\\Desktop\\Gem
			// Source IT Consulting Pvt Ltd\\linkedin\\13212.txt");
			BufferedReader bufferedReaderOne = new BufferedReader(fileReaderOne);

			String fileOneLine;
			while ((fileOneLine = bufferedReaderOne.readLine()) != null) {
				// System.out.println(fileOneLine);
				fileOne.add(fileOneLine.toString().trim());
				fileThird.add(fileOneLine.toString().trim());
			}
			System.out.println("File One Size -- " + fileOne.size());
			fileReaderOne.close();

			FileReader fileReaderSecond = new FileReader(
					"C:\\Users\\Anurag\\Desktop\\Gem Source IT Consulting Pvt Ltd\\linkedin\\Bharti.txt");
			// FileReader fileReaderSecond = new FileReader("C:\\Users\\Anurag\\Desktop\\Gem
			// Source IT Consulting Pvt Ltd\\linkedin\\13212.txt");
			BufferedReader bufferedReaderSecond = new BufferedReader(fileReaderSecond);

			String fileSecondLine;
			while ((fileSecondLine = bufferedReaderSecond.readLine()) != null) {
				// System.out.println(fileSecondLine);
				fileSecond.add(fileSecondLine.toString().trim());
				fileThird.add(fileSecondLine.toString().trim());
			}
			System.out.println("File Second Size -- " + fileSecond.size());
			fileReaderSecond.close();

			System.out.println("File Third Size -- " + fileThird.size());
			System.out.println("--------------------------------------");

			// --------------------------------------------------------------------------------------------------------------------------------------------------

			Object[] objFileOne = fileOne.toArray();
			Object[] objFileSecond = fileSecond.toArray();

			for (int i = 0; i < objFileOne.length; i++) {
				for (int j = 0; j < objFileSecond.length; j++) {
					if (objFileOne[i].toString().trim().equals(objFileSecond[j].toString().trim())) {
						System.out.println("FileOne -- " + objFileOne[i].toString().trim());
						fileOne.remove(objFileOne[i].toString().trim());
					}
				}
			}
			System.out.println("One TreeSet Size After Remove -- " + fileOne.size());

			try {
				FileWriter writer = new FileWriter(
						"C:\\Users\\Anurag\\Desktop\\Gem Source IT Consulting Pvt Ltd\\linkedin\\NewFilterFileOne.txt",
						true);
				BufferedWriter bufferedWriter = new BufferedWriter(writer);

				for (String srtOneTemp : fileOne) {
					// System.out.println("srtOneTemp -- " + srtOneTemp);
					bufferedWriter.write(srtOneTemp);
					bufferedWriter.newLine();
				}
				System.out.println("New Filter File One Size -- " + fileOne.size());
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			// --------------------------------------------------------------------------------------------------------------------------------------------------
			System.out.println("--------------------------------------");

			for (int i = 0; i < objFileSecond.length; i++) {
				for (int j = 0; j < objFileOne.length; j++) {
					if (objFileSecond[i].toString().trim().equals(objFileOne[j].toString().trim())) {
						System.out.println("File Second -- " + objFileSecond[i].toString().trim());
						fileSecond.remove(objFileSecond[i].toString().trim());
					}
				}
			}
			System.out.println("Second TreeSet Size After Remove -- " + fileSecond.size());

			try {
				FileWriter writer = new FileWriter(
						"C:\\Users\\Anurag\\Desktop\\Gem Source IT Consulting Pvt Ltd\\linkedin\\NewFilterFileTwo.txt",
						true);
				BufferedWriter bufferedWriter = new BufferedWriter(writer);

				for (String strSecondTemp : fileSecond) {
					// System.out.println("strSecondTemp -- " + strSecondTemp);
					bufferedWriter.write(strSecondTemp);
					bufferedWriter.newLine();
				}
				System.out.println("New Filter File Second Size -- " + fileSecond.size());
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
