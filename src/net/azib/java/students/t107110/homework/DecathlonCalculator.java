package net.azib.java.students.t107110.homework;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * @author Eduard Shustrov
 */
public class DecathlonCalculator {
	private static final Logger LOG = Logger.getLogger(DecathlonCalculator.class);

	public static void main(final String[] args) {
		DOMConfigurator.configure(DecathlonCalculator.class.getResource("log4j.xml").getPath());
		try {
			new CommandLineParser(args);
		} catch (Exception e) {
			LOG.fatal(e.getMessage(), e);
		}
	}
}
