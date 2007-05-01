package net.azib.java.lessons.logging;

import org.apache.log4j.Logger;

/**
 * Log4JLogging
 *
 * @author anton
 */
public class Log4JLogging {
	private static final Logger LOG = Logger.getLogger(Log4JLogging.class);

	public static void main(String[] args) {
		LOG.fatal("fatal");
		LOG.error("error");
		LOG.warn("warn");
		LOG.info("info");
		LOG.debug("debug");
	}
}
