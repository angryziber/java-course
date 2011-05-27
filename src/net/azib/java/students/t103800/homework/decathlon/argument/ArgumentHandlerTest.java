package net.azib.java.students.t103800.homework.decathlon.argument;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArgumentHandlerTest {

	@Test
	public void testArgumentHandler() throws ArgumentException {
		new ArgumentHandler(new String[] {"-console", "-db", "dbparam"});
		new ArgumentHandler(new String[] {"-db", "param"});
		new ArgumentHandler(new String[] {"-csv", "asd", "-xml", "asd"});
	}

	@Test
	public void testGetNextArgument() throws ArgumentException {
		String args[] = {"-console"};
		ArgumentHandler argHandler = new ArgumentHandler(args);
		Argument arg = argHandler.getNextArgument();
		assertEquals(Argument.Method.CONSOLE, arg.getMethod());
		assertNull(arg.getParameter());

		args = new String[] {"-db", "magic", "-console"};
		argHandler = new ArgumentHandler(args);
		arg = argHandler.getNextArgument();
		assertEquals(Argument.Method.DB, arg.getMethod());
		assertEquals("magic", arg.getParameter());
		arg = argHandler.getNextArgument();
		assertEquals(Argument.Method.CONSOLE, arg.getMethod());

		args = new String[] {"-console", "-db", "asd", "-xml", "kkk.xml"};
		argHandler = new ArgumentHandler(args);
		arg = argHandler.getNextArgument();
		assertEquals(Argument.Method.CONSOLE, arg.getMethod());
		arg = argHandler.getNextArgument();
		assertEquals(Argument.Method.DB, arg.getMethod());
		assertEquals("asd", arg.getParameter());
		arg = argHandler.getNextArgument();
		assertEquals(Argument.Method.XML, arg.getMethod());
		assertEquals("kkk.xml", arg.getParameter());
	}

	@Test(expected=ArgumentException.class)
	public void testGetNextArgumentFailure1() throws ArgumentException {
		new ArgumentHandler(new String[] {"-asd"});
	}

	@Test(expected=ArgumentException.class)
	public void testGetNextArgumentFailure2() throws ArgumentException {
		new ArgumentHandler(new String[] {"-db", "dbstuff", "-console", "hmm"});
	}

}