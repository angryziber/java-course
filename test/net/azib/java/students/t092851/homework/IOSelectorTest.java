package net.azib.java.students.t092851.homework;


import static org.junit.Assert.*;

import org.junit.Test;

/**
 * IOSelectorTest
 *
 * @author Lauri
 */
public class IOSelectorTest {
	
	@Test
	public void testConfigureIO() {
		checkIO(new String[] {"-console", "-console"}, DecathlonDataInputConsole.class, DecathlonDataOutputConsole.class);
		checkIO(new String[] {"-consoole", "-console"}, null, null);
		checkIO(new String[] {"-console", "console"}, null, null);
		checkIO(new String[] {"-db", "-console"}, null, null);
		checkIO(new String[] {"-db", "765676565", "-console"}, DecathlonDataInputDB.class, DecathlonDataOutputConsole.class);
		checkIO(new String[] {"-csv", "space inside.csv", "-xml", "3332"}, DecathlonDataInputCSV.class, DecathlonDataOutputXML.class);
		checkIO(new String[] {"-db", "competition", "-html", "results.html"}, DecathlonDataInputDB.class, DecathlonDataOutputHTML.class);
		checkIO(new String[] {"-db", "output parameter missing", "-html" }, null, null);
		checkIO(new String[] {"-csv", "-console"}, null, null);
		checkIO(new String[] {"-console", "-console", "extra is OK"}, DecathlonDataInputConsole.class, DecathlonDataOutputConsole.class);
	}
	
	
	private void checkIO(String[] args, Class<?> expectedInput, Class<?> expectedOutput) {
		IOSelector io = new IOSelector(args);
		DecathlonDataInput  testInput  = io.createDataInput();
		DecathlonDataOutput testOutput = io.createDataOutput();
		
		if (expectedInput == null || expectedOutput == null) {
			assertFalse(io.isValid());
			assertTrue(testInput  == null);
			assertTrue(testOutput == null);
		}
		else {
			assertTrue(io.isValid());
			assertFalse(testInput  == null);
			assertFalse(testOutput == null);
			assertTrue(testInput.getClass().equals(expectedInput));
			assertTrue(testOutput.getClass().equals(expectedOutput));
		}
	}
	
}
