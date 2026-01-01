package com.all.core.java.basics;

import java.util.logging.Logger;

public class HelloWorld {

	private static final Logger logger = Logger.getLogger(HelloWorld.class.getName());

	private String name;

	public HelloWorld() {
		super();
	}

	public HelloWorld(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void printHello() {
		System.out.println("Hello  " + name);
	}
}
