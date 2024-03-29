package gui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// LoggingExample class for demonstrating logging
public class LoggingExample 
{
	// Initialize logger
	private static final Logger logger = LogManager.getLogger(LoggingExample.class);

	// Log different levels of messages
	public static void main(String[] args) 
	{
	        // Log different levels of messages
		logger.info("Test Info");
		logger.trace("Test Trace");
		logger.warn("Test warn");
		logger.error("Test Error");
		logger.fatal("Test Fatal");
		logger.debug("Test Debug");
	}

}
