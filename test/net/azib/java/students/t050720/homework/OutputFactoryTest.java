package net.azib.java.students.t050720.homework;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests OutputFactory class
 *
 * @author Marek
 */
public class OutputFactoryTest {

	/**
	 * get console output
	 * Test method for {@link net.azib.java.students.t050720.homework.OutputFactory#getOutputPlugin(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testGetConsoleOutputPlugin() {
		OutputFactory f=new OutputFactory();
		Output obj=f.getOutputPlugin("-console", "");
		assertEquals(obj.getClass().getName(), (new ConsoleOutput()).getClass().getName());
	}

	/**
	 * get CSV output
	 */
	@Test
	public void testGetCSVOutputPlugin() {
		OutputFactory factory=new OutputFactory();
		Output obj=factory.getOutputPlugin("-csv", "s");
		assertEquals(obj.getClass().getName(), (new CSVOutput("s")).getClass().getName());
	}
	
	/**
	 * get HTML output
	 */
	@Test
	public void testGetHTMLOutputPlugin() {
		OutputFactory factory=new OutputFactory();
		Output obj=factory.getOutputPlugin("-html", "s");
		assertEquals(obj.getClass().getName(), (new HTMLOutput("s")).getClass().getName());
	}
	
	/**
	 * get XML output
	 */
	@Test
	public void testGetXMLOutputPlugin() {
		OutputFactory factory=new OutputFactory();
		Output obj=factory.getOutputPlugin("-xml", "s");
		assertEquals(obj.getClass().getName(), (new XMLOutput("s")).getClass().getName());
	}
	
	/**
	 * get default output (should be console)
	 */
	public void testGetDefaultOutputPlugin() {
		OutputFactory factory=new OutputFactory();
		Output obj=factory.getOutputPlugin("", "s");
		assertEquals(obj.getClass().getName(), (new ConsoleOutput()).getClass().getName());
	}
	
	/**
	 * get invalid output, should return console
	 */
	public void testGetInvalidOutputPlugin() {
		OutputFactory factory=new OutputFactory();
		Output obj=factory.getOutputPlugin("2353252l", "s");
		assertEquals(obj.getClass().getName(), (new ConsoleOutput()).getClass().getName());
	}
}
