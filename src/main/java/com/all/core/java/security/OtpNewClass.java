package com.all.core.java.security;

// Java code to explain how to generate OTP 
// Here we are using random() method of util 
// class in Java 
import java.util.Random;
import java.util.logging.Logger;

public class OtpNewClass {

	private static final Logger logger = Logger.getLogger(OtpNewClass.class.getName());

	static char[] OTP(int len) {

		System.out.println("Generating OTP using random() : ");
		System.out.print("You OTP is : ");
		// Using numeric values
		String numbers = "012356789";
		// Using random method
		Random rndm_method = new Random();
		char[] otp = new char[len];
		for (int i = 0; i < len; i++) {
			// Use of charAt() method : to get character value
			// Use of nextInt() as it is scanning the value as int
			otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
		}
		return otp;
	}

	public static void main(String[] args) {

		int length = 4;
		System.out.println(OTP(length));
	}
}
