package net.azib.java.students.t103800.homework.decathlon.argument;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArgumentTest {

	@Test
	public void testGetMethod() {
		Argument arg = new Argument(null, null);
		assertNull(arg.getMethod());
		arg = new Argument(Argument.Method.CONSOLE, null);
		assertEquals(Argument.Method.CONSOLE, arg.getMethod());
		arg = new Argument(Argument.Method.XML, null);
		assertEquals(Argument.Method.XML, arg.getMethod());
	}

	@Test
	public void testGetParameter() {
		Argument arg = new Argument(null, null);
		assertNull(arg.getParameter());
		arg = new Argument(null, "lammas");
		assertEquals("lammas", arg.getParameter());
		arg = new Argument(null, "¤%YMOTMdfgü");
		assertEquals("¤%YMOTMdfgü", arg.getParameter());
	}

	@Test
	public void testStringToMethod() throws ArgumentException {
		assertEquals(Argument.Method.CSV, Argument.stringToMethod("-csv"));
		assertEquals(Argument.Method.CONSOLE, Argument.stringToMethod("-console"));
		assertEquals(Argument.Method.HTML, Argument.stringToMethod("-html"));
	}

	@Test(expected=ArgumentException.class)
	public void testStringToMethodToFail1() throws ArgumentException {
		assertEquals(Argument.Method.CSV, Argument.stringToMethod("console"));
	}

	@Test(expected=ArgumentException.class)
	public void testStringToMethodToFail2() throws ArgumentException {
		assertEquals(Argument.Method.CSV, Argument.stringToMethod("-kapalapa"));
	}
}
