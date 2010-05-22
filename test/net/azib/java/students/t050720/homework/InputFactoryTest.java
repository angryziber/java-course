package net.azib.java.students.t050720.homework;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * InputFactoryTest
 *
 * @author Marek
 */
public class InputFactoryTest {

	/**
	 * Test method for {@link net.azib.java.students.t050720.homework.InputFactory#getInputPlugin(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testConsoleGetInputPlugin() {
		InputFactory f=new InputFactory();
		Input i=null;
		try {
			i = f.getInputPlugin("-console", "");
		}
		catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown!");
		}
		assertEquals(i.getClass().getName(), (new ConsoleInput()).getClass().getName());
	}

}
/*
 * 		if(type.equals("-console"))
		{
			return new ConsoleInput();
		}
		else if(type.equals("-csv"))
		{
			return new CSVInput(parameters);
		}
		else if(type.equals("-db" ))
		{
			return new DatabaseInput(parameters);
		}
		else return new ConsoleInput();
 */