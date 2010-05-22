package net.azib.java.students.t050720.homework;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * ArgumentsParserTest
 *
 * @author Marek
 */
public class ArgumentsParserTest {

	
	@Test
	public void testEmptyArray() {
		String[] args=new String[1];
		ArgumentsParser parser=new ArgumentsParser(args);
		assertEquals("-console", parser.inputType());
	}
	/**
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
	
	@Test
	public void testEmptyInputType() {
		String[] args = new String[2];
		args[0]=new String("");
		args[1]=new String("");
		ArgumentsParser parser= new ArgumentsParser(args);
		assertEquals("-console", parser.inputType());
	}

	/**
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

	
	@Test
	public void testEmptyOutputType() {
		String[] args = new String[2];
		args[0]=new String("");
		args[1]=new String("");
		ArgumentsParser parser= new ArgumentsParser(args);
		assertEquals("-console", parser.outputType());
	}

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
