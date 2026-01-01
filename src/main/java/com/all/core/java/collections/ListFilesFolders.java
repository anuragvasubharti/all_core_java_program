package com.all.core.java.collections;

import java.io.File;
import java.util.logging.Logger;

public class ListFilesFolders {

	private static final Logger logger = Logger.getLogger(ListFilesFolders.class.getName());

	public static void main(String[] args) {

		// Replace with your directory path
		File directory = new File("D:\\Sakshi\\Cloud-DevOps-Doc");

		// List all files and directories in the specified directory
		File[] filesAndDirs = directory.listFiles();
		if (filesAndDirs != null) {
			for (File file : filesAndDirs) {
				if (file.isDirectory()) {
					System.out.println("Directory: " + file.getName());
				} else {
					System.out.println("File: " + file.getName());
				}
			}
		} else {
			System.out.println("Directory does not exist or is not accessible.");
		}
	}
}
