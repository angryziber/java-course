package net.azib.java.students.t050720.homework;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Contains tests for the ArgumentsParser class.
 *
 * @author Marek
 */
public class ArgumentsParserTest {

	/**
	 * Tests empty array behavior.
	 */
	@Test
	public void testEmptyArray() {
		String[] args=new String[1];
		ArgumentsParser parser=new ArgumentsParser(args);
		assertEquals("-console", parser.inputType());
	}
	/**
	 * Tests input type.
	 * Test method for {@link net.azib.java.students.t050720.homework.ArgumentsParser#inputType()}.
	 */
	@Test
	public void testInputType() {
		String[] args = new String[2];
		args[0]=new String("-db");
		args[1]=new String("1");
		ArgumentsParser parser= new ArgumentsParser(args);
		assertEquals("-db", parser.inputType());
	}

	/**
	 * Tests input parameter.
	 * Test method for {@link net.azib.java.students.t050720.homework.ArgumentsParser#inputParams()}.
	 */
	@Test
	public void testInputParams() {
		String[] args = new String[2];
		args[0]=new String("-db");
		args[1]=new String("1");
		ArgumentsParser parser= new ArgumentsParser(args);
		assertEquals("1", parser.inputParams());
	}
	
	/**
	 * Tests empty input type.
	 */
	@Test
	public void testEmptyInputType() {
		String[] args = new String[2];
		args[0]=new String("");
		args[1]=new String("");
		ArgumentsParser parser= new ArgumentsParser(args);
		assertEquals("-console", parser.inputType());
	}

	/**
	 * Tests empty input parameter
	 * Test method for {@link net.azib.java.students.t050720.homework.ArgumentsParser#inputParams()}.
	 */
	@Test
	public void testEmptyInputParams() {
		String[] args = new String[2];
		args[0]=new String("");
		args[1]=new String("");
		ArgumentsParser parser= new ArgumentsParser(args);
		assertEquals("", parser.inputParams());
	}

	/**
	 * Tests output type
	 * Test method for {@link net.azib.java.students.t050720.homework.ArgumentsParser#outputType()}.
	 */
	@Test
	public void testOutputType() {
		String[] args = new String[4];
		args[0]=new String("-csv");
		args[1]=new String("1");
		args[2]=new String("-csv");
		args[3]=new String("1");
		ArgumentsParser parser= new ArgumentsParser(args);
		assertEquals("-csv", parser.outputType());
	}

	/**
	 * Tests empty output parameter
	 * Test method for {@link net.azib.java.students.t050720.homework.ArgumentsParser#outputParams()}.
	 */
	@Test
	public void testEmptyOutputParams() {
		String[] args = new String[2];
		args[0]=new String("");
		args[1]=new String("");
		ArgumentsParser parser= new ArgumentsParser(args);
		assertEquals("", parser.outputParams());
	}

	/**
	 * Tests empty output type
	 */
	@Test
	public void testEmptyOutputType() {
		String[] args = new String[2];
		args[0]=new String("");
		args[1]=new String("");
		ArgumentsParser parser= new ArgumentsParser(args);
		assertEquals("-console", parser.outputType());
	}

	/**
	 * Tests output parameter
	 */
	@Test
	public void testOutputParams() {
		String[] args = new String[4];
		args[0]=new String("-csv");
		args[1]=new String("1");
		args[2]=new String("-csv");
		args[3]=new String("12345");
		ArgumentsParser parser= new ArgumentsParser(args);
		assertEquals("12345", parser.outputParams());
	}

}
