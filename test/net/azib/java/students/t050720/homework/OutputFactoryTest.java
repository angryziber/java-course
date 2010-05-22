package net.azib.java.students.t050720.homework;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * OutputFactoryTest
 *
 * @author Marek
 */
public class OutputFactoryTest {

	/**
	 * Test method for {@link net.azib.java.students.t050720.homework.OutputFactory#getOutputPlugin(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testGetConsoleOutputPlugin() {
		OutputFactory f=new OutputFactory();
		Output obj=f.getOutputPlugin("-console", "");
		assertEquals(obj.getClass().getName(), (new ConsoleOutput()).getClass().getName());
	}

	@Test
	public void testGetCSVOutputPlugin() {
		OutputFactory factory=new OutputFactory();
		Output obj=factory.getOutputPlugin("-csv", "s");
		assertEquals(obj.getClass().getName(), (new CSVOutput("s")).getClass().getName());
	}
	
	@Test
	public void testGetHTMLOutputPlugin() {
		OutputFactory factory=new OutputFactory();
		Output obj=factory.getOutputPlugin("-html", "s");
		assertEquals(obj.getClass().getName(), (new HTMLOutput("s")).getClass().getName());
	}
	
	@Test
	public void testGetXMLOutputPlugin() {
		OutputFactory factory=new OutputFactory();
		Output obj=factory.getOutputPlugin("-xml", "s");
		assertEquals(obj.getClass().getName(), (new XMLOutput("s")).getClass().getName());
	}
}
