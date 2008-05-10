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
		new DecathlonCalculator(new PrintStream(output)).main(new String[] {});
		assertEquals(DecathlonCalculator.HELP_MSG + LN, output.toString());
	}

	@Test
	public void tooFewArgumentsFail() {
		assertFalse(new DecathlonCalculator().init(new String[] { "-console" }));
	}

	@Test
	public void tooManyArgumentsFail() {
		assertFalse(new DecathlonCalculator().init(new String[] { "-csv", "a", "-csv", "b", "extra" }));
	}

	@Test
	public void argumentsConsoleAndConsolePass() {
		assertTrue(new DecathlonCalculator().init(new String[] { "-console", "-console" }));
	}

	@Test
	public void argumentsDatabaseAndXMLPass() {
		assertTrue(new DecathlonCalculator().init(new String[] { "-db", "-xml" }));
	}

	@Test
	public void argumentsCSVAndHTMLPass() {
		assertTrue(new DecathlonCalculator().init(new String[] { "-csv", "-html" }));
	}

	@Test
	public void argumentsCSVAndCSVPass() {
		assertTrue(new DecathlonCalculator().init(new String[] { "-csv", "-csv" }));
	}

	@Test
	public void argumentsWithoutDashFail() {
		assertFalse(new DecathlonCalculator().init(new String[] { "csv", "html" }));
	}

}
