package com.all.core.java.file;

import java.io.File;
import java.util.logging.Logger;

public class DirectoryReader {

	private static final Logger logger = Logger.getLogger(DirectoryReader.class.getName());

	public static void main(String[] args) {

		// Replace this with the directory path you want to read
		String directoryPath = "E:\\Project-Anurag\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\input_output\\Cloud-DevOps-Doc";

		// Create a File object representing the directory
		File directory = new File(directoryPath);

		// Check if the given path exists and is a directory
		if (directory.exists() && directory.isDirectory()) {
			// Call the recursive method to print directory structure
			listFilesAndFolders(directory, 0);
		} else {
			System.out.println("Directory not found.");
		}
	}

	// Recursive method to list files and folders
	public static void listFilesAndFolders(File directory, int level) {

		// Get list of files and directories in the current directory
		File[] files = directory.listFiles();

		if (files != null) {
			// Iterate through each file and directory
			for (File file : files) {
				// Print file or directory name with appropriate indentation
				for (int i = 0; i < level; i++) {
					System.out.print("\t"); // Use tabs for indentation
				}
				System.out.println(file.getName());

				// Recursive call for sub-directories
				if (file.isDirectory()) {
					listFilesAndFolders(file, level + 1);
				}
			}
		}
	}
}
