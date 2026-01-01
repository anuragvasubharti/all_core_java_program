package com.all.core.java.security;

import java.util.logging.Logger;

/*at least 8 characters, max of 12
at least one uppercase
at least one lowercase
at least one number
at least one symbol @#$%=:?*/

public class PasswordUtils {

	private static final Logger logger = Logger.getLogger(PasswordUtils.class.getName());

	/**
	 * Minimum length for a decent password
	 */
	// protected static final int MAX_LENGTH = 8;
	// protected static final int MAX_LENGTH = 9;
	protected static final int MAX_LENGTH = 10;
	// protected static final int MAX_LENGTH = 11;
	// protected static final int MAX_LENGTH = 12;
	// protected static final int MAX_LENGTH = 13;
	// protected static final int MAX_LENGTH = 14;
	// protected static final int MAX_LENGTH = 15;
	// protected static final int MAX_LENGTH = 16;

	/**
	 * The random number generator.
	 */
	private static java.util.Random random = new java.util.Random();
	/**
	 * I, L and O are good to leave out as are numeric zero and one.
	 */

	// Usernames can contain letters (a-z), numbers (0-9), dashes (-), underscores
	// (_), apostrophes ('), and periods (.).

	/*
	 * private static final String DIGITS = "0123456789"; private static final
	 * String LOCASE_CHARACTERS = "abcdefghjklmnopqrstuvwxyz"; private static final
	 * String UPCASE_CHARACTERS = "ABCDEFGHJKLMNOPQRSTUVWXYZ"; // Usernames can't
	 * contain an ampersand (&), equal sign (=), brackets (<,>), plus sign (+),
	 * comma (,), or more than one period (.) in a row. private static final String
	 * SYMBOLS = "#$@%=:?"; private static final String ALL = DIGITS +
	 * LOCASE_CHARACTERS + UPCASE_CHARACTERS + SYMBOLS;
	 */

	private static final String DIGITS = "012356789";
	private static final String LOCASE_CHARACTERS = "abdefghijklmnprstuvy";
	private static final String UPCASE_CHARACTERS = "ABDEFGHIJKLMNPRSTUVY";
	private static final String SYMBOLS = "#$@%";
	private static final String ALL = DIGITS + LOCASE_CHARACTERS + SYMBOLS;

	private static final char[] digitsArray = DIGITS.toCharArray();
	private static final char[] locaseArray = LOCASE_CHARACTERS.toCharArray();
	private static final char[] upcaseArray = UPCASE_CHARACTERS.toCharArray();
	private static final char[] symbolsArray = SYMBOLS.toCharArray();
	private static final char[] allArray = ALL.toCharArray();

	/**
	 * Generate a random password based on security rules
	 *
	 * - at least 8 characters, max of 12 - at least one uppercase - at least one
	 * lowercase - at least one number - at least one symbol
	 *
	 * @return
	 */
	public static String generatePassword() {
		StringBuilder sb = new StringBuilder();

		// get at least one lowercase letter
		sb.append(locaseArray[random.nextInt(locaseArray.length)]);

		// get at least one uppercase letter
		sb.append(upcaseArray[random.nextInt(upcaseArray.length)]);

		// get at least one digit
		sb.append(digitsArray[random.nextInt(digitsArray.length)]);

		// get at least one symbol
		sb.append(symbolsArray[random.nextInt(symbolsArray.length)]);

		// fill in remaining with random letters
		// for (int i = 0; i < MAX_LENGTH - 4; i++) {

		// for (int i = 0; i < 4; i++) {
		// for (int i = 0; i < 5; i++) {
		// for (int i = 0; i < 6; i++) {
		// for (int i = 0; i < 7; i++) {
		// for (int i = 0; i < 8; i++) {
		// for (int i = 0; i < 9; i++) {
		// for (int i = 0; i < 10; i++) {
		// for (int i = 0; i < 11; i++) {
		for (int i = 0; i < 10; i++) {
			sb.append(allArray[random.nextInt(allArray.length)]);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		// generate the password
		String thePassword = PasswordUtils.generatePassword();
		// now print it out
		System.out.println("Generated password is: " + thePassword);
	}
}
