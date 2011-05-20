package net.azib.java.students.t103784.homework;

import java.io.*;
import java.util.List;

/**
 * @author      Ott Madis Ozolit <karuott321@hotmail.com>
 * @version     1.6
 * @since       2011.0520
 *
 */
public class CSVOutputTest extends Output {

	/**
	 * Tests whether the CSV output works.
	 *
	 * By feeding some preset valid data into the system using
	 * a reader, I check if the output can get the data from the input properly.
	 */
	@org.junit.Test
	public void testOutputs () {
		List<Athlete> contestants;
		MockInput input = new MockInput();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("src\\net\\azib\\java\\students\\t103784\\homework\\tests\\CSVTest.csv"));
		} catch (FileNotFoundException e) {
			System.out.println("Test input failed (no such test file)");
		}
		contestants = input.readAthleteFromCSV(reader);
		try {
			outputToCSV(contestants);
		} catch (FileNotFoundException e) {
			System.out.println("Test output failed (no such file)");
		}
	}

	class MockInput extends Input {

	}
}
