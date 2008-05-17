package net.azib.java.students.t001370.homework;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * IOMethodTest
 *
 * @author maksim
 */
public class IOMethodTest {

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.IOMethod#getIOArgument()}.
	 * Test method for {@link net.azib.java.students.t001370.homework.IOMethod#setIOArgument(java.lang.String)}.
	 */
	@Test
	public void testGetSetIOArgumentCSV() {

		String s = "results.csv";
		IOMethod m = IOMethod.CSV_INPUT;
		
		m.setIOArgument(s);
		
		assertTrue(m.getIOArgument().equals(s));
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.IOMethod#getIOArgument()}.
	 * Test method for {@link net.azib.java.students.t001370.homework.IOMethod#setIOArgument(java.lang.String)}.
	 */
	@Test
	public void testGetSetIOArgumentCSVInputAndOutput() {

		String sI = "resultsSource.csv";
		String sO = "resultsDestination.csv";
		IOMethod mI = IOMethod.CSV_INPUT;
		IOMethod mO = IOMethod.CSV_OUTPUT;
		
		mI.setIOArgument(sI);
		mO.setIOArgument(sO);
		
		assertTrue(!mI.getIOArgument().equals(mO.getIOArgument()));
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.IOMethod#getIOArgument()}.
	 * Test method for {@link net.azib.java.students.t001370.homework.IOMethod#setIOArgument(java.lang.String)}.
	 */
	@Test
	public void testGetSetIOArgumentCSVInputAndInput() {

		String sI1 = "resultsSource1.csv";
		String sI2 = "resultsSource2.csv";
		IOMethod mI1 = IOMethod.CSV_INPUT;
		IOMethod mI2 = IOMethod.CSV_INPUT;
		
		mI1.setIOArgument(sI1);
		mI2.setIOArgument(sI2);
		
		assertTrue(mI1.getIOArgument().equals(mI1.getIOArgument()));
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.IOMethod#parseInputMethod(java.lang.String)}.
	 */
	@Test
	public void testParseInputMethodConsole() {
		IOMethod m = IOMethod.NONE;
		String ioArg = "-console";
		
		m = m.parseInputMethod(ioArg);
		
		assertEquals(m.name(), "CONSOLE_INPUT");
		
	}
	
	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.IOMethod#parseInputMethod(java.lang.String)}.
	 */
	@Test
	public void testParseInputMethodCSV() {
		IOMethod m = IOMethod.NONE;
		String ioArg = "-csv";
		
		m = m.parseInputMethod(ioArg);
		
		assertEquals(m.name(), "CSV_INPUT");
	}

	
	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.IOMethod#parseInputMethod(java.lang.String)}.
	 */
	@Test
	public void testParseInputMethodDB() {
		IOMethod m = IOMethod.NONE;
		String ioArg = "-db";
		
		m = m.parseInputMethod(ioArg);
		
		assertEquals(m.name(), "DB_INPUT");
	}


	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.IOMethod#parseOutputMethod(java.lang.String)}.
	 */
	@Test
	public void testParseOutputMethodConsole() {
		IOMethod m = IOMethod.NONE;
		String ioArg = "-console";
		
		m = m.parseOutputMethod(ioArg);
		
		assertEquals(m.name(), "CONSOLE_OUTPUT");
	}
	
	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.IOMethod#parseOutputMethod(java.lang.String)}.
	 */
	@Test
	public void testParseOutputMethodCSV() {
		IOMethod m = IOMethod.NONE;
		String ioArg = "-csv";
		
		m = m.parseOutputMethod(ioArg);
		
		assertEquals(m.name(), "CSV_OUTPUT");
	}
	
	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.IOMethod#parseOutputMethod(java.lang.String)}.
	 */
	@Test
	public void testParseOutputMethodXML() {
		IOMethod m = IOMethod.NONE;
		String ioArg = "-xml";
		
		m = m.parseOutputMethod(ioArg);
		
		assertEquals(m.name(), "XML_OUTPUT");
	}
	
	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.IOMethod#parseOutputMethod(java.lang.String)}.
	 */
	@Test
	public void testParseOutputMethodHTML() {
		IOMethod m = IOMethod.NONE;
		String ioArg = "-html";
		
		m = m.parseOutputMethod(ioArg);
		
		assertEquals(m.name(), "HTML_OUTPUT");
	}
	

}
