package net.azib.java.students.t030633.homework.view.out;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * OutputMethodTest
 * 
 * @author t030633
 */
public class OutputMethodTest {

	@Test
	public void thereAreFourMethods() {
		assertTrue(OutputMethod.values().length == 4);
	}

	@Test
	public void requiredMethodsExist() {
		assertNotNull(OutputMethod.valueOf(OutputMethod.class, "HTML"));
		assertNotNull(OutputMethod.valueOf(OutputMethod.class, "CONSOLE"));
		assertNotNull(OutputMethod.valueOf(OutputMethod.class, "CSV"));
		assertNotNull(OutputMethod.valueOf(OutputMethod.class, "XML"));
	}

	@Test
	public void canGetClasses() {
		assertEquals(Console.class.getName(), OutputMethod.CONSOLE.getOutput().getClass().getName());
		assertEquals(CSV.class.getName(), OutputMethod.CSV.getOutput().getClass().getName());
		assertEquals(HTML.class.getName(), OutputMethod.HTML.getOutput().getClass().getName());
		assertEquals(XML.class.getName(), OutputMethod.XML.getOutput().getClass().getName());
	}

}
