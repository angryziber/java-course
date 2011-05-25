package net.azib.java.students.t092855.homework;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * OutputModeTest
 * Unit tests for {@link net.azib.java.students.t092855.homework.OutputMode}
 *
 * @author t092855
 */
public class OutputModeTest {

	/**
	 * Unit test for {@link net.azib.java.students.t092855.homework.OutputMode#parseOutputMode(String)}
	 */
	@Test
	public void parseOutputModeWorks() {
		OutputMode outputMode = OutputMode.OUTPUT_MODE_NONE;
		assertEquals(OutputMode.OUTPUT_MODE_CONSOLE, outputMode.parseOutputMode("-console"));
		assertEquals(OutputMode.OUTPUT_MODE_CSV, outputMode.parseOutputMode("-csv"));
		assertEquals(OutputMode.OUTPUT_MODE_XML, outputMode.parseOutputMode("-xml"));
		assertEquals(OutputMode.OUTPUT_MODE_HTML, outputMode.parseOutputMode("-html"));
	}

	/**
	 * Unit test for {@link net.azib.java.students.t092855.homework.OutputMode#parseAndSetOutputParameter(String)}
	 */
	@Test
	public void parseAndSetOutputParameterWorks() {
		OutputMode outputMode = OutputMode.OUTPUT_MODE_CSV;
		assertTrue(outputMode.parseAndSetOutputParameter("decathlon.csv"));
		assertFalse(outputMode.parseAndSetOutputParameter("-xml"));

		String testParameter = "/temp/decathlon.csv";
		assertTrue(outputMode.parseAndSetOutputParameter(testParameter));
		assertEquals(testParameter, outputMode.getOutputParameter());
	}
}
