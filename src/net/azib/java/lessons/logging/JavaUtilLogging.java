package net.azib.java.lessons.logging;

import java.net.URL;
import java.util.logging.Logger;

/**
 * JavaUtilLogging
 *
 * @author anton
 */
public class JavaUtilLogging {
	public static void main(String[] args) {
		// configure java.util.logging
		URL loggingConfig = JavaUtilLogging.class.getClassLoader().getResource("logging.properties");
		System.setProperty("java.util.logging.config.file", loggingConfig.getPath());
		
		Logger log = Logger.getLogger(JavaUtilLogging.class.getName());
		log.severe("severe");
		log.warning("warning");
		log.info("info");
		log.config("config");
		log.fine("fine");
		log.finer("finer");
		log.finest("finest");
	}
}
