package com.all.core.java.misc;

import java.io.File;
import java.io.PrintStream;

public class ReadFolderAndFiles {

	static void RecursivePrint(File[] arr, int index, int level) {

		// terminate condition
		if (index == arr.length) {
			// System.out.print("index " + index + " ");
			return;
		}
		// tabs for internal levels
		for (int i = 0; i < level; i++)
			System.out.print("\t");
		// for files
		if (arr[index].isFile())
			System.out.println(arr[index].getName() + " " + (arr[index].length() / 1024) / 1024 + " mb");
		// for sub-directories
		else if (arr[index].isDirectory()) {
			System.out.println("[" + arr[index].getName() + "]");
			// recursion for sub-directories
			RecursivePrint(arr[index].listFiles(), 0, level + 1);
		}
		// recursion for main directory
		RecursivePrint(arr, ++index, level);
	}

	// Driver Method
	public static void main(String[] args) {
		System.out.println("Main method");
		// Provide full path for directory(change accordingly)
		String maindirpathC = "C:\\Users\\Anurag\\Downloads\\NCERT";
		String maindirpathD = "D:\\workspaceKepler\\EmailReader";
		String maindirpathE = "E:\\21022020 MobileBackUp";
		// File object
		File maindir = new File(maindirpathC);
		// File maindir = new File(maindirpathD);
		// File maindir = new File(maindirpathE);
		try {
			// Instantiating the File class
			File file = new File("E:\\Project-Anurag\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\input_output\\ReadFileFolderName.txt");
			// Instantiating the PrintStream class
			PrintStream stream = new PrintStream(file);
			System.out.println("From now on " + file.getAbsolutePath() + " will be your console");
			System.setOut(stream);
			// Printing values to file
			System.out.println("Hello, how are you");
			System.out.println("Welcome to Tutorialspoint");
		} catch (Exception e) {
			System.out.println("Exception " + e);
		}
		if (maindir.exists() && maindir.isDirectory()) {
			// array for files and sub-directories
			// of directory pointed by maindir
			File arr[] = maindir.listFiles();
			System.out.println("**********************************************");
			System.out.println("Files from main directory : " + maindir);
			System.out.println("**********************************************");
			// Calling recursive method
			RecursivePrint(arr, 0, 0);
		}
	}
}
