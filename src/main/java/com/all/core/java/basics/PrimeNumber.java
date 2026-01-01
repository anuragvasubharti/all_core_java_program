package com.all.core.java.basics;

import java.util.logging.Logger;

public class PrimeNumber {

	private static final Logger logger = Logger.getLogger(PrimeNumber.class.getName());

	public static void main(String args[]) {

		primenumber();
		System.out.println();
		System.out.println();
		oddEvenMethod();
	}

	public static void primenumber() {

		int startnumber = 2;
		int maxcheck = 200;
		int count;
		
		for (int i = startnumber; i <= maxcheck; i++) {
			// System.out.println("i " + i + " ");
			count = 0;
			for (int j = 1; j <= i; j++) {
				// System.out.print("j " + j + " ");
				int reminder = i % j;
				// System.out.println(" -- reminder " + reminder);
				if (i % j == 0) { // Not Prime Number
					count++;
					// System.out.print("Not Prime Number " + i + " ");
				}
			}
			if (count == 2)
				System.out.print("Prime Number " + i + "  ");
		}
	}

	public static void oddEvenMethod() {

		int n = 100;
		System.out.print("Even Numbers from 1 to " + n + " are: ");
		
		for (int i = 1; i <= n; i++) {
			// if number%2 == 0 it means its an even number
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
	}
}
