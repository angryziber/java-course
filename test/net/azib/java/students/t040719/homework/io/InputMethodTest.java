package net.azib.java.students.t040719.homework.io;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * InputMethodTest
 *
 * @author romi
 */
public class InputMethodTest {
	
	@Test
	public void testGetNames(){
		assertEquals("Console", InputMethod.K.getInputName());
		assertEquals("CSV file", InputMethod.C.getInputName());
		assertEquals("SQL database", InputMethod.D.getInputName());
	}
	
	@Test
	public void testDataInput(){
		assertEquals(ConsoleInput.class.getName(), InputMethod.K.getInput().getClass().getName());
		assertEquals(FileInput.class.getName(), InputMethod.C.getInput().getClass().getName());
		assertEquals(DatabaseInput.class.getName(), InputMethod.D.getInput().getClass().getName());
	}
	
}
