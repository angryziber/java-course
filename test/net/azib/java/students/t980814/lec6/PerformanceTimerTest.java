package net.azib.java.students.t980814.lec6;

import net.azib.java.students.t980814.lec6.PerformanceTimer;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;



/**
 * PerformanceTimerTest
 *
 * @author dell
 * @param <PerformanceTimer>
 */
public class PerformanceTimerTest {

	private static final String LN = System.getProperty("line.separator");;

	@Test
	public void testWelcomeMessage() {
		final String INFO_TXT = "nothing"; 
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		new PerformanceTimer(new PrintStream(out), new Runnable() {
			public void run() {}
			public String toString() { return INFO_TXT; }
			} );
		assertEquals(PerformanceTimer.WELCOME_TEXT + INFO_TXT + LN + "0ms" + LN, out.toString()); 
	}
	
	@Test
	public void test0msTimeUse() {
		final String INFO_TXT = "0ms"; 
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		new PerformanceTimer(new PrintStream(out), new EmptyRunnable(INFO_TXT));
		assertEquals(PerformanceTimer.WELCOME_TEXT + INFO_TXT + LN + INFO_TXT + LN, out.toString()); 
	}

	@Test
	public void test1000msTimeUse() {
		final String INFO_TXT = "1000ms"; 
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		new PerformanceTimer(new PrintStream(out), new EmptyRunnable(INFO_TXT)) {
			@Override
			long stopTimer(long startTime) {
				// return a predefined value for this test
				return 1000;
			}
		};
		assertEquals(PerformanceTimer.WELCOME_TEXT + INFO_TXT + LN + INFO_TXT + LN, out.toString()); 
	}
	
	private class EmptyRunnable implements Runnable {
		private String s;

		public EmptyRunnable(String s) {
			this.s = s;
		}

		public void run() {
			// do nothing here
		}

		public String toString() {
			return s;
		}
	}
}
