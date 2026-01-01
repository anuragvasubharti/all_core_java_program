package com.all.core.java.basics;

import java.util.logging.Logger;

public class OddEven {

	private static final Logger logger = Logger.getLogger(OddEven.class.getName());

	public static void main(String[] args) {

		int n = 100;
		System.out.print("Even Numbers from 1 to " + n + " are: ");
		
		for (int i = 1; i <= n; i++) {
			// if number%2 == 0 it means its an even number
			if (i % 2 == 0) {
				System.out.print(i + " ");
			} else {
				System.out.print(i + " ");
			}
		}
	}
}
