package net.azib.java.students.t107110.homework;

import org.apache.log4j.Logger;

/**
 * @author Eduard Shustrov
 */
public class DecathlonCalculator {
	private static final Logger LOG = Logger.getLogger(DecathlonCalculator.class);

	public static void main(final String[] args) {
		try {
			new CommandLineParser(args);
		} catch (Exception e) {
			LOG.fatal(e.getMessage(), e);
		}
	}
}
