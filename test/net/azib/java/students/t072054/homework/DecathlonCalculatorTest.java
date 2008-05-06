package net.azib.java.students.t072054.homework;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * DecathlonCalculatorTest
 *
 * @author r_vassiljev
 */
public class DecathlonCalculatorTest {
	
	@Test
	public void CommandLineParsing1() {

		String[] a = new String[3];
		a[0] = "-console";
		a[1] = "-xml";
		a[2] = "results.xml";
		
		assertEquals(DecathlonCalculator.CommandLineParsing(a), "null results.xml 1 4 0");
	}
	
	@Test
	public void CommandLineParsing2() {

		String[] a = new String[4];
		a[0] = "-db";
		a[1] = "2";
		a[2] = "-html";
		a[3] = "/tmp/results.html";
		
		assertEquals(DecathlonCalculator.CommandLineParsing(a), "null /tmp/results.html 3 5 2");
	}
	
	@Test
	public void CommandLineParsing3() {

		String[] a = new String[3];
		a[0] = "-csv";
		a[1] = "my_input.csv";
		a[2] = "-console";
		
		assertEquals(DecathlonCalculator.CommandLineParsing(a), "my_input.csv null 2 1 0");
	}
}
