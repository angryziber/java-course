package net.azib.java.students.t960644.homework;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
/**
 * ConsoleOutputTest
 *
 * @author Lembit
 */
public class ConsoleOutputTest {
	
	@Test
	public void testpadLeft() throws Exception {
		ConsoleOutput co = new ConsoleOutput();
		assertTrue(co.padLeft("a", 1).toString().equals("a"));
		assertTrue(co.padLeft("aa", 1).toString().equals("aa"));
		assertTrue(co.padLeft("a", 2).toString().equals(" a"));
	}
	
	@Test
	public void testpadRight() throws Exception {
		ConsoleOutput co = new ConsoleOutput();
		assertTrue(co.padRight("a", 1).toString().equals("a"));
		assertTrue(co.padRight("aa", 1).toString().equals("aa"));
		assertTrue(co.padRight("a", 2).toString().equals("a "));		
	}
	@Test
	public void testSpaces() throws Exception {
		ConsoleOutput co = new ConsoleOutput();
		assertTrue(co.spaces(4).toString().equals("    "));
		assertTrue(co.spaces(0).toString().equals(""));
		assertTrue(co.spaces(-1).toString().equals(""));
	}

}
