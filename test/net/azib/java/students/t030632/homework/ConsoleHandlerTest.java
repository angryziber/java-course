package net.azib.java.students.t030632.homework;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;


/**
 * ConsoleHandlerTest
 *
 * @author Toni
 */
public class ConsoleHandlerTest {
	
	
	
	@Test
	public void testHandleInput() throws Exception {
		ConsoleHandler ch = new ConsoleHandler();
		assertTrue(!ch.handleInput(""));
		assertTrue(!ch.handleInput(System.getProperty("line.separator")));
		
	}
	@Test
	public void testHandleOutput() throws Exception {
		ConsoleHandler ch = new ConsoleHandler();
		assertTrue(!ch.handleOutput(""));
		assertTrue(!ch.handleOutput(System.getProperty("line.separator")));
		
	}
	@Test
	public void testHandleExit() throws Exception {
		ConsoleHandler ch = new ConsoleHandler();
		assertTrue(!ch.handleExit(""));
		assertTrue(!ch.handleExit(System.getProperty("line.separator")));
		
	}
	@Test
	public void testGetCompetitions()throws Exception{
		ConsoleHandler ch = new ConsoleHandler();
		List comps = ch.getCompetitions();
		assertTrue(comps.size()>0);
	}
	

	
}
