package com.all.core.java.gmail.Id.generator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GmailIdGenerator_Word {

	private static final int TOTAL_LENGTH = 20;
	private static final String DOMAIN = "@gmail.com";

	private static final int[] ALLOWED_LENGTHS = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14 };

	private static final List<String> PATTERNS = Arrays.asList(

			// "s*******************", 
			 "saakshicloud********" 
			// "sakahivirha*********", 
			// "sakshi**************",
			// "sakshibebo**********", 
			// "sakshibebovirha*****", 
			// "sakshibilhari*******", 
			// "sakshibilharijbp****",
			// "sakshibirha*********", 
			// "sakshicloud*********", 
			// "sakshidevops********", 
			// "sakshieng***********",
			// "sakshiengg**********", 
			// "sakshiengineer******", 
			// "sakshigulab*********", 
			// "sakshigulabvirha****",
			// "sakshiicloud********", 
			// "sakshijabalpur******", 
			// "sakshijbp***********", 
			// "sakshijbpbilhari****",
			// "sakshishashikala****", 
			// "sakshivirhabilhari**", 
			// "sakshivirhaeng******", 
			// "sakshivirhaengg*****",
			// "sakshivirhajbp******", 
			// "shashikalavirha*****", 
			// "shasikala***********",

			// "saakshi.cloud.******", 
			// "sakahi.virha.*******", 
			// "sakshi.*************", 
			// "sakshi.bebo.********",
			// "sakshi.bebo.virha.**", 
			// "sakshi.bilhari.*****", 
			// "sakshi.birha.*******", 
			// "sakshi.cloud.*******",
			// "sakshi.devops.******", 
			// "sakshi.eng.*********", 
			// "sakshi.engg.********", 
			// "sakshi.engineer.****",
			// "sakshi.gulab.*******", 
			// "sakshi.jabalpur.****", 
			// "sakshi.jbp.*********", 
			// "sakshi.shashikala.**",
			// "sakshi.virha.eng.***", 
			// "sakshi.virha.engg.**", 
			// "sakshi.virha.jbp.***", 
			// "sakshii.cloud.******",
			// "shashikala.virha.***", 
			// "shasikala.**********"
			 );

	public static void main(String[] args) throws Exception {

		List<String> words = loadWords("E:\\Project-Sakshi\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\gmail\\Id\\generator\\words_ending_with_l_4334.txt");

		BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\Project-Sakshi\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\gmail\\Id\\generator\\generated_gmail_ids_word.txt"));

		int totalCount = 0;

		for (String pattern : PATTERNS) {
			int stars = countStars(pattern);

			for (String word : words) {
				if (word.length() == stars && isAllowedLength(word.length())) {

					String local = pattern.replace("*", "") + word;

					if (local.length() != TOTAL_LENGTH)
						continue;
					if (!isValidGmailLocal(local))
						continue;

					String email = local + DOMAIN;

					System.out.println(email);
					writer.write(email);
					writer.newLine();

					totalCount++;
				}
			}
		}

		writer.write("\nTOTAL EMAIL IDs GENERATED: " + totalCount);
		writer.close();

		System.out.println("\nTOTAL EMAIL IDs GENERATED: " + totalCount);
	}

	// ------------------ HELPERS ------------------

	private static List<String> loadWords(String file) throws Exception {
		List<String> list = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;

		while ((line = br.readLine()) != null) {
			line = line.trim();
			if (line.endsWith("l") && isAllowedLength(line.length())) {
				list.add(line);
			}
		}
		br.close();
		return list;
	}

	private static boolean isAllowedLength(int len) {
		for (int a : ALLOWED_LENGTHS)
			if (a == len)
				return true;
		return false;
	}

	private static int countStars(String s) {
		int c = 0;
		for (char ch : s.toCharArray())
			if (ch == '*')
				c++;
		return c;
	}

	private static boolean isValidGmailLocal(String s) {

		// No start/end dot
		if (s.startsWith(".") || s.endsWith("."))
			return false;

		// No consecutive same chars
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i - 1))
				return false;
		}

		// No consecutive dots
		if (s.contains(".."))
			return false;

		// Allowed characters
		return s.matches("[a-zA-Z0-9.+]+");
	}
}
