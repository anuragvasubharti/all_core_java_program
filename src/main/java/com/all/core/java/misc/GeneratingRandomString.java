package com.all.core.java.misc;

//https://programming.guide/java/generating-a-random-string.html
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;


public class GeneratingRandomString {
	
	public static void main(String[] args) {
		
		int length = 8;
		String digits = "0123456789";
		String specials = "~=+%*/()[]{}/@#$?|";
		String all = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz" + digits + specials;
		Random rnd = new Random();
		List<String> result = new ArrayList<>();
		Consumer<String> appendChar = s -> result.add("" + s.charAt(rnd.nextInt(s.length())));
		System.out.println("appendChar: " + appendChar);
		appendChar.accept(digits);
		appendChar.accept(specials);
		while (result.size() < length)
			appendChar.accept(all);
		Collections.shuffle(result, rnd);
		String str = String.join("", result);
		System.out.println("GeneratingRandomString " + str);
	}
}
