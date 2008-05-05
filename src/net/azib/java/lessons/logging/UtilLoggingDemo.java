package net.azib.java.lessons.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * UtilLoggingDemo
 *
 * @author anton
 */
public class UtilLoggingDemo {	
	private static final Logger LOG = Logger.getLogger(UtilLoggingDemo.class.getName());
	
	public void doSomething() {
		int i = 1 / 0;
	}
	
	public static void main(String[] args) {
		try {
			LOG.info("Starting " + LOG.getName());
			new UtilLoggingDemo().doSomething();
		}
		catch (Exception e) {
			LOG.log(Level.SEVERE, "Unexpected bug", e);
		}
		finally {
			LOG.info("Finished");
		}
	}
	
}
