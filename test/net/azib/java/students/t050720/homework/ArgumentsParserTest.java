package net.azib.java.students.t050720.homework;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * ArgumentsParserTest
 *
 * @author Marek
 */
public class ArgumentsParserTest {

	/**
	 * Test method for {@link net.azib.java.students.t050720.homework.ArgumentsParser#inputType()}.
	 */
	@Test
	public void testInputType() {
		String[] args = new String[2];
		args[0]=new String("db");
		args[1]=new String("1");
		ArgumentsParser parser= new ArgumentsParser(args);
		assertEquals("db", parser.inputType());
	}

	/**
	 * Test method for {@link net.azib.java.students.t050720.homework.ArgumentsParser#inputParams()}.
	 */
	@Test
	public void testInputParams() {
		String[] args = new String[2];
		args[0]=new String("db");
		args[1]=new String("1");
		ArgumentsParser parser= new ArgumentsParser(args);
		assertEquals("1", parser.inputParams());
	}

	/**
	 * Test method for {@link net.azib.java.students.t050720.homework.ArgumentsParser#outputType()}.
	 */
	@Test
	public void testOutputType() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link net.azib.java.students.t050720.homework.ArgumentsParser#outputParams()}.
	 */
	@Test
	public void testOutputParams() {
		fail("Not yet implemented");
	}

}
