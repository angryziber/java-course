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
		assertTrue(co.padLeft("a", 1).toString().equals("a|"));
		assertTrue(co.padLeft("aa", 1).toString().equals("aa|"));
		assertTrue(co.padLeft("a", 2).toString().equals(" a|"));
	}
	
	@Test
	public void testpadRight() throws Exception {
		ConsoleOutput co = new ConsoleOutput();
		assertTrue(co.padRight("a", 1).toString().equals("a|"));
		assertTrue(co.padRight("aa", 1).toString().equals("aa|"));
		assertTrue(co.padRight("a", 2).toString().equals("a |"));		
	}
	@Test
	public void testSpaces() throws Exception {
		ConsoleOutput co = new ConsoleOutput();
		assertTrue(co.spaces(4).toString().equals("    "));
		assertTrue(co.spaces(0).toString().equals(""));
		assertTrue(co.spaces(-1).toString().equals(""));
	}
	@Test
	public void testWriteLine() throws Exception {
		ConsoleOutput co = new ConsoleOutput();
		Result res = OutputTest.singleResult();
		System.out.println(co.writeLine(5, 20, res));
		assertTrue(co.writeLine(5, 20, res).toString().
				equals("    1| 8815|Peeter Hülss        |01.05.1986|EE|10.600|  7.63| 14.90|  2.03|  46.230|14.400| 43.40|  5.40| 67.01|4:29.580|"));
		
	}

}
