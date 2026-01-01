package com.all.core.java.misc;

import java.util.logging.Logger;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;


public class AddingNumber {

	private static final Logger logger = Logger.getLogger(AddingNumber.class.getName());

	public static void main(String[] args) {
		// generatingLuckyAge();
		// System.out.println("");
		// generatingLuckyYear();
		// System.out.println("");
		// generatingLuckyMobileNumber();
		// System.out.println("");
		generatingLuckyCreditCard();
		System.out.println("");
	}

	public static void generatingLuckyAge() {
		// create multimap to store key and values
		Multimap<Integer, Integer> multiMap = ArrayListMultimap.create();
		for (Integer i = 1; i < 100; i++) {
			// Logic for Generating Lucky Age
			// System.out.println("i " + i);
			// System.out.println("i.toString().charAt(0) " + i.toString().charAt(0));
			char charA = i.toString().charAt(0);
			String strA = String.valueOf(charA);
			Integer intA = Integer.parseInt(strA);
			// System.out.println("intA: " + intA);
			Integer intB = 0;
			if (i.toString().length() == 2) {
				// System.out.println("i.toString().charAt(1) " + i.toString().charAt(1));
				char charB = i.toString().charAt(1);
				String strB = String.valueOf(charB);
				intB = Integer.parseInt(strB);
				// System.out.println("intB: " + intB);
			}
			Integer addNumber = intA + intB;
			// System.out.println("addNumber: " + addNumber);
			// System.out.println();
			if (addNumber.toString().length() == 1)
				multiMap.put(addNumber, i);
			// System.out.println("addNumber.toString().length() " +
			// addNumber.toString().length());
			if (addNumber.toString().length() == 2) {
				// System.out.println("addNumber.toString().charAt(0) " +
				// addNumber.toString().charAt(0));
				char charC = addNumber.toString().charAt(0);
				String strC = String.valueOf(charC);
				Integer intC = Integer.parseInt(strC);
				// System.out.println("intC: " + intC);
				// System.out.println("addNumber.toString().charAt(1) " +
				// addNumber.toString().charAt(1));
				char charD = addNumber.toString().charAt(1);
				String strD = String.valueOf(charD);
				Integer intD = Integer.parseInt(strD);
				// System.out.println("intD: " + intD);
				Integer againAddNumber = intC + intD;
				// System.out.println("againAddNumber: " + againAddNumber);
				// System.out.println();
				if (againAddNumber.toString().length() == 1)
					multiMap.put(againAddNumber, i);
			}
		}
		System.out.println("Lucky Age multiMap: " + multiMap);
	}

	public static void generatingLuckyYear() {
		// create multimap to store key and values
		Multimap<Integer, Integer> multiMap = ArrayListMultimap.create();
		for (Integer i = 1975; i < 2101; i++) {
			// Logic for Generating Lucky Year
			// System.out.println("i " + i);
			// System.out.println("i.toString().charAt(0) " + i.toString().charAt(0));
			char charE = i.toString().charAt(0);
			String strE = String.valueOf(charE);
			Integer intE = Integer.parseInt(strE);
			// System.out.println("intE: " + intE);
			// System.out.println("i.toString().charAt(1) " + i.toString().charAt(1));
			char charF = i.toString().charAt(1);
			String strF = String.valueOf(charF);
			Integer intF = Integer.parseInt(strF);
			// System.out.println("intF: " + intF);
			// System.out.println("i.toString().charAt(2) " + i.toString().charAt(2));
			char charG = i.toString().charAt(2);
			String strG = String.valueOf(charG);
			Integer intG = Integer.parseInt(strG);
			// System.out.println("intG: " + intG);
			// System.out.println("i.toString().charAt(3) " + i.toString().charAt(3));
			char charH = i.toString().charAt(3);
			String strH = String.valueOf(charH);
			Integer intH = Integer.parseInt(strH);
			// System.out.println("inth: " + intH);
			Integer addNumber = intE + intF + intG + intH;
			// System.out.println("addNumber: " + addNumber);
			// System.out.println();
			if (addNumber.toString().length() == 1)
				multiMap.put(addNumber, i);
			if (addNumber.toString().length() == 2) {
				// System.out.println("addNumber.toString().charAt(0) " +
				// addNumber.toString().charAt(0));
				char charL = addNumber.toString().charAt(0);
				String strL = String.valueOf(charL);
				Integer intL = Integer.parseInt(strL);
				// System.out.println("intL: " + intL);
				// System.out.println("addNumber.toString().charAt(1) " +
				// addNumber.toString().charAt(1));
				char charM = addNumber.toString().charAt(1);
				String strM = String.valueOf(charM);
				Integer intM = Integer.parseInt(strM);
				// System.out.println("intM: " + intM);
				Integer againAddNumber = intL + intM;
				// System.out.println("againAddNumber: " + againAddNumber);
				// System.out.println();
				if (againAddNumber.toString().length() == 1)
					multiMap.put(againAddNumber, i);
				if (againAddNumber.toString().length() == 2) {
					// System.out.println("againAddNumber.toString().charAt(0) "+
					// i.toString().charAt(0));
					char charN = addNumber.toString().charAt(0);
					String strN = String.valueOf(charN);
					Integer intN = Integer.parseInt(strN);
					// System.out.println("intN: " + intN);
					// System.out.println("againAddNumber.toString().charAt(i) " +
					// i.toString().charAt(1));
					char charO = addNumber.toString().charAt(1);
					String strO = String.valueOf(charO);
					Integer intO = Integer.parseInt(strO);
					// System.out.println("intO: " + intO);
					Integer againAddNumber2 = intL + intM;
					// System.out.println("againAddNumber2: " + againAddNumber2);
					// System.out.println();
					if (againAddNumber2.toString().length() == 1)
						multiMap.put(againAddNumber2, i);
				}
			}
		}
		System.out.println("Lucky Year multiMap: " + multiMap);
	}

	public static void generatingLuckyMobileNumber() {
		// create multimap to store key and values
		Multimap<Integer, Long> multiMap = ArrayListMultimap.create();
		// Logic for Adding Mobile Number
		// for (Long mobileNumber = 9502999980l; mobileNumber < 9502999999l;
		// mobileNumber++) {
		for (Long mobileNumber = 9502119933l; mobileNumber < 9502119934l; mobileNumber++) {
			// System.out.println("mobileNumber " + mobileNumber);
			// System.out.println("mobileNumber.toString().charAt(0) " +
			// mobileNumber.toString().charAt(0));
			char charMob01 = mobileNumber.toString().charAt(0);
			String strMob01 = String.valueOf(charMob01);
			Integer intMob01 = Integer.parseInt(strMob01);
			// System.out.println("intMob01: " + intMob01);
			// System.out.println("mobileNumber.toString().charAt(1) " +
			// mobileNumber.toString().charAt(1));
			char charMob02 = mobileNumber.toString().charAt(1);
			String strMob02 = String.valueOf(charMob02);
			Integer intMob02 = Integer.parseInt(strMob02);
			// System.out.println("intMob02: " + intMob02);
			// System.out.println("mobileNumber.toString().charAt(2) " +
			// mobileNumber.toString().charAt(2));
			char charMob03 = mobileNumber.toString().charAt(2);
			String strMob03 = String.valueOf(charMob03);
			Integer intMob03 = Integer.parseInt(strMob03);
			// System.out.println("intMob03: " + intMob03);
			// System.out.println("mobileNumber.toString().charAt(3) " +
			// mobileNumber.toString().charAt(3));
			char charMob04 = mobileNumber.toString().charAt(3);
			String strMob04 = String.valueOf(charMob04);
			Integer intMob04 = Integer.parseInt(strMob04);
			// System.out.println("intMob04: " + intMob04);
			// System.out.println("mobileNumber.toString().charAt(4) " +
			// mobileNumber.toString().charAt(4));
			char charMob05 = mobileNumber.toString().charAt(4);
			String strMob05 = String.valueOf(charMob05);
			Integer intMob05 = Integer.parseInt(strMob05);
			// System.out.println("intMob05: " + intMob05);
			// System.out.println("mobileNumber.toString().charAt(5) " +
			// mobileNumber.toString().charAt(5));
			char charMob06 = mobileNumber.toString().charAt(5);
			String strMob06 = String.valueOf(charMob06);
			Integer intMob06 = Integer.parseInt(strMob06);
			// System.out.println("intMob06: " + intMob06);
			// System.out.println("mobileNumber.toString().charAt(6) " +
			// mobileNumber.toString().charAt(6));
			char charMob07 = mobileNumber.toString().charAt(6);
			String strMob07 = String.valueOf(charMob07);
			Integer intMob07 = Integer.parseInt(strMob07);
			// System.out.println("intMob07: " + intMob07);
			// System.out.println("mobileNumber.toString().charAt(7) " +
			// mobileNumber.toString().charAt(7));
			char charMob08 = mobileNumber.toString().charAt(7);
			String strMob08 = String.valueOf(charMob08);
			Integer intMob08 = Integer.parseInt(strMob08);
			// System.out.println("intMob08: " + intMob08);
			// System.out.println("mobileNumber.toString().charAt(8) " +
			// mobileNumber.toString().charAt(8));
			char charMob09 = mobileNumber.toString().charAt(8);
			String strMob09 = String.valueOf(charMob09);
			Integer intMob09 = Integer.parseInt(strMob09);
			// System.out.println("intMob09: " + intMob09);
			// System.out.println("mobileNumber.toString().charAt(9) " +
			// mobileNumber.toString().charAt(9));
			char charMob10 = mobileNumber.toString().charAt(9);
			String strMob10 = String.valueOf(charMob10);
			Integer intMob10 = Integer.parseInt(strMob10);
			// System.out.println("intMob10: " + intMob10);
			Integer addNumber = intMob01 + intMob02 + intMob03 + intMob04 + intMob05 + intMob06 + intMob07 + intMob08
					+ intMob09 + intMob10;
			// System.out.println("addNumber: " + addNumber);
			// System.out.println();
			if (addNumber.toString().length() == 1)
				multiMap.put(addNumber, mobileNumber);
			if (addNumber.toString().length() == 2) {
				// System.out.println("addNumber.toString().charAt(0) " +
				// addNumber.toString().charAt(0));
				char charMob11 = addNumber.toString().charAt(0);
				String strMob11 = String.valueOf(charMob11);
				Integer intMob11 = Integer.parseInt(strMob11);
				// System.out.println("intMob11: " + intMob11);
				// System.out.println("addNumber.toString().charAt(1) " +
				// addNumber.toString().charAt(1));
				char charMob12 = addNumber.toString().charAt(1);
				String strMob12 = String.valueOf(charMob12);
				Integer intMob12 = Integer.parseInt(strMob12);
				// System.out.println("intMob12: " + intMob12);
				Integer againAddNumber = intMob11 + intMob12;
				// System.out.println("againAddNumber: " + againAddNumber);
				// System.out.println();
				if (againAddNumber.toString().length() == 1)
					multiMap.put(againAddNumber, mobileNumber);
				if (againAddNumber.toString().length() == 2) {
					// System.out.println("againAddNumber.toString().charAt(0) " +
					// againAddNumber.toString().charAt(0));
					char charMob13 = againAddNumber.toString().charAt(0);
					String strMob13 = String.valueOf(charMob13);
					Integer intMob13 = Integer.parseInt(strMob13);
					// System.out.println("intMob13: " + intMob13);
					// System.out.println("againAddNumber.toString().charAt(i) " +
					// againAddNumber.toString().charAt(1));
					char charMob14 = againAddNumber.toString().charAt(1);
					String strMob14 = String.valueOf(charMob14);
					Integer intMob14 = Integer.parseInt(strMob14);
					// System.out.println("intMob14: " + intMob14);
					Integer againAddNumber2 = intMob13 + intMob14;
					// System.out.println("againAddNumber2: " + againAddNumber2);
					// System.out.println();
					if (againAddNumber2.toString().length() == 1)
						multiMap.put(againAddNumber2, mobileNumber);
				}
			}
		}
		System.out.println("Lucky Mobile Number multiMap: " + multiMap);
	}

	public static void generatingLuckyCreditCard() {
		// create multimap to store key and values
		Multimap<Integer, Long> multiMap = ArrayListMultimap.create();
		// Logic for Adding Credit Card Number
		for (Long ccNumber = 9999999999999980l; ccNumber < 9999999999999999l; ccNumber++) {
			// System.out.println("ccNumber " + ccNumber);
			// System.out.println("ccNumber.toString().charAt(0) " +
			// ccNumber.toString().charAt(0));
			char charCC01 = ccNumber.toString().charAt(0);
			String strCC01 = String.valueOf(charCC01);
			Integer intCC01 = Integer.parseInt(strCC01);
			// System.out.println("intCC01: " + intCC01);
			// System.out.println("ccNumber.toString().charAt(1) " +
			// ccNumber.toString().charAt(1));
			char charCC02 = ccNumber.toString().charAt(1);
			String strCC02 = String.valueOf(charCC02);
			Integer intCC02 = Integer.parseInt(strCC02);
			// System.out.println("intCC02: " + intCC02);
			// System.out.println("ccNumber.toString().charAt(2) " +
			// ccNumber.toString().charAt(2));
			char charCC03 = ccNumber.toString().charAt(2);
			String strCC03 = String.valueOf(charCC03);
			Integer intCC03 = Integer.parseInt(strCC03);
			// System.out.println("intCC03: " + intCC03);
			// System.out.println("ccNumber.toString().charAt(3) " +
			// ccNumber.toString().charAt(3));
			char charCC04 = ccNumber.toString().charAt(3);
			String strCC04 = String.valueOf(charCC04);
			Integer intCC04 = Integer.parseInt(strCC04);
			// System.out.println("intCC04: " + intCC04);
			// System.out.println("ccNumber.toString().charAt(4) " +
			// ccNumber.toString().charAt(4));
			char charCC05 = ccNumber.toString().charAt(4);
			String strCC05 = String.valueOf(charCC05);
			Integer intCC05 = Integer.parseInt(strCC05);
			// System.out.println("intCC05: " + intCC05);
			// System.out.println("ccNumber.toString().charAt(5) " +
			// ccNumber.toString().charAt(5));
			char charCC06 = ccNumber.toString().charAt(5);
			String strCC06 = String.valueOf(charCC06);
			Integer intCC06 = Integer.parseInt(strCC06);
			// System.out.println("intCC06: " + intCC06);
			// System.out.println("ccNumber.toString().charAt(6) " +
			// ccNumber.toString().charAt(6));
			char charCC07 = ccNumber.toString().charAt(6);
			String strCC07 = String.valueOf(charCC07);
			Integer intCC07 = Integer.parseInt(strCC07);
			// System.out.println("intCC07: " + intCC07);
			// System.out.println("ccNumber.toString().charAt(7) " +
			// ccNumber.toString().charAt(7));
			char charCC08 = ccNumber.toString().charAt(7);
			String strCC08 = String.valueOf(charCC08);
			Integer intCC08 = Integer.parseInt(strCC08);
			// System.out.println("intCC08: " + intCC08);
			// System.out.println("ccNumber.toString().charAt(8) " +
			// ccNumber.toString().charAt(8));
			char charCC09 = ccNumber.toString().charAt(8);
			String strCC09 = String.valueOf(charCC09);
			Integer intCC09 = Integer.parseInt(strCC09);
			// System.out.println("intCC09: " + intCC09);
			// System.out.println("ccNumber.toString().charAt(9) " +
			// ccNumber.toString().charAt(9));
			char charCC10 = ccNumber.toString().charAt(9);
			String strCC10 = String.valueOf(charCC10);
			Integer intCC10 = Integer.parseInt(strCC10);
			// System.out.println("intCC10: " + intCC10);
			// System.out.println("ccNumber.toString().charAt(10) " +
			// ccNumber.toString().charAt(10));
			char charCC11 = ccNumber.toString().charAt(10);
			String strCC11 = String.valueOf(charCC11);
			Integer intCC11 = Integer.parseInt(strCC11);
			// System.out.println("intCC11: " + intCC11);
			// System.out.println("ccNumber.toString().charAt(11) " +
			// ccNumber.toString().charAt(11));
			char charCC12 = ccNumber.toString().charAt(11);
			String strCC12 = String.valueOf(charCC12);
			Integer intCC12 = Integer.parseInt(strCC12);
			// System.out.println("intCC12: " + intCC12);
			// System.out.println("ccNumber.toString().charAt(12) " +
			// ccNumber.toString().charAt(12));
			char charCC13 = ccNumber.toString().charAt(12);
			String strCC13 = String.valueOf(charCC13);
			Integer intCC13 = Integer.parseInt(strCC13);
			// System.out.println("intCC13: " + intCC13);
			// System.out.println("ccNumber.toString().charAt(13) " +
			// ccNumber.toString().charAt(13));
			char charCC14 = ccNumber.toString().charAt(14);
			String strCC14 = String.valueOf(charCC14);
			Integer intCC14 = Integer.parseInt(strCC14);
			// System.out.println("intCC15: " + intCC14);
			// System.out.println("ccNumber.toString().charAt(14) " +
			// ccNumber.toString().charAt(14));
			char charCC15 = ccNumber.toString().charAt(14);
			String strCC15 = String.valueOf(charCC15);
			Integer intCC15 = Integer.parseInt(strCC15);
			// System.out.println("intCC15: " + intCC15);
			// System.out.println("ccNumber.toString().charAt(15) " +
			// ccNumber.toString().charAt(15));
			char charCC16 = ccNumber.toString().charAt(15);
			String strCC16 = String.valueOf(charCC16);
			Integer intCC16 = Integer.parseInt(strCC16);
			// System.out.println("intCC16: " + intCC16);
			Integer addNumber = intCC01 + intCC02 + intCC03 + intCC04 + intCC05 + intCC06 + intCC07 + intCC08 + intCC09
					+ intCC10 + intCC11 + intCC12 + intCC13 + intCC14 + intCC15 + intCC16;
			// System.out.println("addNumber: " + addNumber);
			// System.out.println();
			if (addNumber.toString().length() == 1)
				multiMap.put(addNumber, ccNumber);
			if (addNumber.toString().length() == 3) {
				// System.out.println("addNumber.toString().charAt(0) " +
				// addNumber.toString().charAt(0));
				char charCC17 = addNumber.toString().charAt(0);
				String strCC17 = String.valueOf(charCC17);
				Integer intCC17 = Integer.parseInt(strCC17);
				// System.out.println("intCC17: " + intCC17);
				// System.out.println("addNumber.toString().charAt(1) " +
				// addNumber.toString().charAt(1));
				char charCC18 = addNumber.toString().charAt(1);
				String strCC18 = String.valueOf(charCC18);
				Integer intCC18 = Integer.parseInt(strCC18);
				// System.out.println("intCC18: " + intCC18);
				// System.out.println("addNumber.toString().charAt(2) " +
				// addNumber.toString().charAt(2));
				char charCC19 = addNumber.toString().charAt(2);
				String strCC19 = String.valueOf(charCC19);
				Integer intCC19 = Integer.parseInt(strCC19);
				// System.out.println("intCC19: " + intCC19);
				Integer againAddNumber = intCC17 + intCC18 + intCC19;
				// System.out.println("againAddNumber: " + againAddNumber);
				// System.out.println();
				if (againAddNumber.toString().length() == 1)
					multiMap.put(againAddNumber, ccNumber);
				if (againAddNumber.toString().length() == 2) {
					// System.out.println("againAddNumber.toString().charAt(0) " +
					// againAddNumber.toString().charAt(0));
					char charCC20 = againAddNumber.toString().charAt(0);
					String strCC20 = String.valueOf(charCC20);
					Integer intCC20 = Integer.parseInt(strCC20);
					// System.out.println("intCC20: " + intCC20);
					// System.out.println("againAddNumber.toString().charAt(1) " +
					// againAddNumber.toString().charAt(1));
					char charCC21 = againAddNumber.toString().charAt(1);
					String strCC21 = String.valueOf(charCC21);
					Integer intCC21 = Integer.parseInt(strCC21);
					// System.out.println("intCC21: " + intCC21);
					Integer againAddNumber2 = intCC20 + intCC21;
					// System.out.println("againAddNumber2: " + againAddNumber2);
					// System.out.println();
					if (againAddNumber2.toString().length() == 1)
						multiMap.put(againAddNumber2, ccNumber);
				}
			}
		}
		System.out.println("Lucky Credit Card Number multiMap: " + multiMap);
	}
}
