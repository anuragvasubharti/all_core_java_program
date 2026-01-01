package com.all.core.java.misc;

public class Singleton {

	private static Singleton instance;

	private Singleton() {
	}

	public Singleton getInstance() {
		return this.instance;
	}
}
