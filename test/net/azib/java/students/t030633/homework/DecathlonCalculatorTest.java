package net.azib.java.students.t030633.homework;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * DecathlonCalculatorTest
 * 
 * @author t030633
 */
public class DecathlonCalculatorTest {

	private static final String LN = System.getProperty("line.separator");

	@Test
	public void helpIsPrinted() {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		DecathlonCalculator.setPrintStream(new PrintStream(output));
		DecathlonCalculator.main(new String[] {});
		assertEquals(DecathlonCalculator.HELP_MSG + LN, output.toString());
	}

	@Test
	public void tooFewArgumentsFail() {
		assertFalse(DecathlonCalculator.init(new String[] { "-console" }));
	}

	@Test
	public void tooManyArgumentsFail() {
		assertFalse(DecathlonCalculator.init(new String[] { "-csv", "a", "-csv", "b", "extra" }));
	}

	@Test
	public void argumentsConsoleAndConsolePass() {
		assertTrue(DecathlonCalculator.init(new String[] { "-console", "-console" }));
	}

	@Test
	public void argumentsDatabaseAndXMLPass() {
		assertTrue(DecathlonCalculator.init(new String[] { "-db", "-xml" }));
	}

	@Test
	public void argumentsCSVAndHTMLPass() {
		assertTrue(DecathlonCalculator.init(new String[] { "-csv", "-html" }));
	}

	@Test
	public void argumentsCSVAndCSVPass() {
		assertTrue(DecathlonCalculator.init(new String[] { "-csv", "-csv" }));
	}

	@Test
	public void argumentsWithoutDashFail() {
		assertFalse(DecathlonCalculator.init(new String[] { "csv", "html" }));
	}

}
