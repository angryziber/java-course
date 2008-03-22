package net.azib.java.students.t980814;

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
		new PerformanceTimer(new PrintStream(out), new Runnable() {
			public void run() {
				try {
					Thread.sleep(0);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			public String toString() { return INFO_TXT; }
			} );
		assertEquals(PerformanceTimer.WELCOME_TEXT + INFO_TXT + LN + INFO_TXT + LN, out.toString()); 
	}

	@Test
	public void test1000msTimeUse() {
		final String INFO_TXT = "1000ms"; 
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		new PerformanceTimer(new PrintStream(out), new Runnable() {
			public void run() {
				try {
					Thread.sleep(1000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			public String toString() { return INFO_TXT; }
			} );
		assertEquals(PerformanceTimer.WELCOME_TEXT + INFO_TXT + LN + INFO_TXT + LN, out.toString()); 
	}
	
}
