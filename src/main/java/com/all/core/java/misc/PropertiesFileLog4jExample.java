package com.all.core.java.misc;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class PropertiesFileLog4jExample {

	private static final Logger logger = LogManager.getLogger(PropertiesFileLog4jExample.class);

	public static void main(String[] args) {

		logger.debug("this is a debug log message");
		logger.info("this is an information log message");
		logger.warn("this is a warning log message");
	}
}
