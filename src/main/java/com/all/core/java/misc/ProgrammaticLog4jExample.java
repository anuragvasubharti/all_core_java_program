package com.all.core.java.misc;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.appender.FileAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.layout.PatternLayout;

public class ProgrammaticLog4jExample {

	private static final Logger logger = LogManager.getLogger(ProgrammaticLog4jExample.class);

	public static void main(String[] args) {

		LoggerContext context = (LoggerContext) LogManager.getContext(false);
		Configuration config = context.getConfiguration();
		PatternLayout layout = PatternLayout.newBuilder().withPattern("%d [%t] %-5level %c - %msg%n").build();
		ConsoleAppender consoleAppender = ConsoleAppender.newBuilder().setName("Console").setLayout(layout)
				.setTarget(ConsoleAppender.Target.SYSTEM_OUT).build();
		consoleAppender.start();
		FileAppender fileAppender = FileAppender.newBuilder().setName("File").withFileName("applog3.txt")
				.setLayout(layout).build();
		fileAppender.start();
		config.addAppender(consoleAppender);
		config.addAppender(fileAppender);
		LoggerConfig rootLogger = config.getRootLogger();
		rootLogger.addAppender(consoleAppender, Level.DEBUG, null);
		rootLogger.addAppender(fileAppender, Level.DEBUG, null);
		rootLogger.setLevel(Level.DEBUG);
		context.updateLoggers();
		logger.debug("this is a debug log message");
		logger.info("this is an information log message");
		logger.warn("this is a warning log message");
	}
}
