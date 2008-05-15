package net.azib.java.students.t040719.homework.io;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 * OutputMethodTest
 *
 * @author romi
 */
public class OutputMethodTest {
	@Test
	public void testGetNames(){
		assertEquals("Console", OutputMethod.K.getOutputName());
		assertEquals("CSV file", OutputMethod.C.getOutputName());
		assertEquals("XML file", OutputMethod.X.getOutputName());
		assertEquals("HTML file", OutputMethod.H.getOutputName());
	}
	
	@Test
	public void testDataInput(){
		assertEquals(ConsoleOutput.class.getName(), OutputMethod.K.getOutput().getClass().getName());
		assertEquals(FileOutput.class.getName(), OutputMethod.C.getOutput().getClass().getName());
		assertEquals(FileOutput.class.getName(), OutputMethod.X.getOutput().getClass().getName());
		assertEquals(FileOutput.class.getName(), OutputMethod.H.getOutput().getClass().getName());
	}

}
