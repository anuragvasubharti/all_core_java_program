package com.all.core.java.misc;

import java.util.TreeSet;

public class GenerateBday {
	public static void main(String[] args) {
		bDay();
	}

	public static TreeSet<String> bDay() { // 07-11-1987
		/*
		 * String[] date =
		 * {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15",
		 * "16","17","18","19","20","21","22","23","24","25","26","27","28","29","30",
		 * "31",};
		 */

		/*
		 * String[] date = {"01","02","03","04","05","06","07","08","09"}; String[]
		 * month = {"01","02","03","04","05","06","07","08","09","10","11","12"};
		 * String[] year =
		 * {"1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990"
		 * ,};
		 */

		String[] date = { "07" };
		String[] month = { "12", "11", "10", "09", "08", "07" };
		String[] year = { "1988", "1987", "1986", "1985" };

		int count = 0;

		TreeSet<String> bDay = new TreeSet<String>();

		for (int i = 0; i < year.length; i++) {
			// System.out.println("Year: " + year[i]);

			for (int j = 0; j < month.length; j++) {
				// System.out.println("Month: " + month[j]);

				for (int k = 0; k < date.length; k++) {
					// System.out.println("Date: " + date[k]);
					// System.out.println("Date: " + date[k] + " Month: " + month[i] + " Year: " +
					// year[i]);
					// System.out.print(date[k] + "-" + month[j] + "-" + year[i] + "\t");
					bDay.add(date[k] + "-" + month[j] + "-" + year[i]);
					count++;
					if (count == 10) {
						// System.out.println("");
						count = 0;
					}
					if (k == (date.length - 1)) {
						System.out.println("");
					}
				}
				// System.out.println("");
			}
			System.out.println("");
		}
		// System.out.println("Count: " + count);
		bDay.descendingSet();
		return bDay;
	}
}
