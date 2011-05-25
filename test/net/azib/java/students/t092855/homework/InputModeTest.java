package net.azib.java.students.t092855.homework;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * InputModeTest
 * Unit tests for {@link net.azib.java.students.t092855.homework.InputMode}
 *
 * @author t092855
 */
public class InputModeTest {

	/**
	 * Unit test for {@link net.azib.java.students.t092855.homework.InputMode#parseInputMode(String)}
	 */
	@Test
	public void parseInputModeWorks() {
		InputMode inputMode = InputMode.INPUT_MODE_NONE;
		assertEquals(InputMode.INPUT_MODE_CONSOLE, inputMode.parseInputMode("-console"));
		assertEquals(InputMode.INPUT_MODE_CSV, inputMode.parseInputMode("-csv"));
		assertEquals(InputMode.INPUT_MODE_DB, inputMode.parseInputMode("-db"));
	}

	/**
	 * Unit test for {@link net.azib.java.students.t092855.homework.InputMode#parseAndSetInputParameter(String)}
	 */
	@Test
	public void parseAndSetInputParameterWorks() {
		InputMode inputMode = InputMode.INPUT_MODE_CSV;
		assertTrue(inputMode.parseAndSetInputParameter("decathlon_results.csv"));
		assertFalse(inputMode.parseAndSetInputParameter("-csv"));

		String testParameter = "/temp/decathlon.csv";
		assertTrue(inputMode.parseAndSetInputParameter(testParameter));
		assertEquals(testParameter, inputMode.getInputParameter());
	}
}
