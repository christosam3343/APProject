package models;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoggingExample {
	private static final Logger logger = LogManager.getLogger(LoggingExample.class);
	public static void main(String[] args) {
		
		logger.info("Test Info");
		logger.trace("Test Trace");
		logger.warn("Test warn");
		logger.error("Test Error");
		logger.fatal("Test Fatal");
		logger.debug("Test Debug");
	}

}
