package com.all.core.java.gmail.Id.generator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;

public class GmailIdGenerator_Number {

	private static final int TOTAL_LENGTH = 20;
	private static final String DOMAIN = "@gmail.com";

	private static final int[] ALLOWED_DIGIT_LENGTHS = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 13, 14 };

	private static final List<String> PATTERNS = Arrays.asList(

			// "s*******************", 
			// "saakshicloud********", 
			// "sakahivirha*********", 
			// "sakshi**************",
			// "sakshibebo**********", 
			 "sakshibebovirha*****", 
			// "sakshibilhari*******", 
			 "sakshibilharijbp****",
			// "sakshibirha*********", 
			// "sakshicloud*********", 
			// "sakshidevops********", 
			// "sakshieng***********",
			// "sakshiengg**********", 
			// "sakshiengineer******", 
			// "sakshigulab*********", 
			 "sakshigulabvirha****",
			// "sakshiicloud********", 
			// "sakshijabalpur******", 
			// "sakshijbp***********", 
			 "sakshijbpbilhari****",
			 "sakshishashikala****", 
			 "sakshivirhabilhari**", 
			// "sakshivirhaeng******", 
			 "sakshivirhaengg*****",
			// "sakshivirhajbp******", 
			 "shashikalavirha*****", 
			// "shasikala***********",

			// "saakshi.cloud.******", 
			// "sakahi.virha.*******", 
			// "sakshi.*************", 
			// "sakshi.bebo.********",
			 "sakshi.bebo.virha.**", 
			 "sakshi.bilhari.*****", 
			// "sakshi.birha.*******", 
			// "sakshi.cloud.*******",
			// "sakshi.devops.******", 
			// "sakshi.eng.*********", 
			// "sakshi.engg.********", 
			 "sakshi.engineer.****",
			// "sakshi.gulab.*******", 
			 "sakshi.jabalpur.****", 
			// "sakshi.jbp.*********", 
			 "sakshi.shashikala.**",
			 "sakshi.virha.eng.***", 
			 "sakshi.virha.engg.**", 
			 "sakshi.virha.jbp.***", 
			// "sakshii.cloud.******",
			 "shashikala.virha.***" 
			// "shasikala.**********"
			 );

	public static void main(String[] args) throws Exception {

		BufferedWriter writer = new BufferedWriter(new FileWriter("E:\\Project-Sakshi\\all_core_java_program\\src\\main\\java\\com\\all\\core\\java\\gmail\\Id\\generator\\generated_gmail_ids_number.txt"));

		int totalCount = 0;

		for (String pattern : PATTERNS) {

			int starCount = countStars(pattern);

			if (!isAllowedDigitLength(starCount))
				continue;

			long max = (long) Math.pow(10, starCount);

			for (long i = 1; i < max; i++) {

				String number = String.format("%0" + starCount + "d", i);

				String local = pattern.replace("*", "") + number;

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

		writer.write("\nTOTAL EMAIL IDs GENERATED: " + totalCount);
		writer.close();

		System.out.println("\nTOTAL EMAIL IDs GENERATED: " + totalCount);
	}

	// ---------------- HELPERS ----------------

	private static boolean isAllowedDigitLength(int len) {
		for (int a : ALLOWED_DIGIT_LENGTHS)
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

		// no start/end dot
		if (s.startsWith(".") || s.endsWith("."))
			return false;

		// no consecutive dots
		if (s.contains(".."))
			return false;

		// allowed characters
		return s.matches("[a-zA-Z0-9.+]+");
	}
}
