package com.all.core.java.test;

import java.util.logging.Logger;

public class TestOperator {

	private static final Logger logger = Logger.getLogger(TestOperator.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 10;
		int b = 20;
		int c = 30;
		int d = 40;
		int e = 50;
		int f = 60;

		if (a > b || b > c) {
			System.out.println("1");
		}
		if (b > c || c > b) {
			System.out.println("2");
		}
		if (a > b || c > b || c > d) {
			System.out.println("3");
		}
		if (a > b || b > c || d > c || d > e) {
			System.out.println("4");
		}
		if (c > d || d > a) {
			System.out.println("5");
		}
		if (a > b || b > c || c > d || e > a) {
			System.out.println("6");
		}
	}
}
