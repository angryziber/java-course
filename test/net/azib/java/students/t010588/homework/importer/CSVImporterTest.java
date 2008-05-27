package net.azib.java.students.t010588.homework.importer;

import java.io.File;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tests if CSVImporter has athletes after loading CSV file
 *
 * @author Vjatseslav Rosin, 010588
 */
public class CSVImporterTest {

	/**
	 * Test method for
	 * {@link net.azib.java.students.t010588.homework.importer.CSVImporter#getAthletes()}.
	 *
	 * @throws WrongFormatException
	 */
	@Test(expected = WrongFormatException.class)
	public void testGetAthletesFromNotExistingFile() throws WrongFormatException {
		new CSVImporter(new File("."));
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t010588.homework.importer.CSVImporter#getAthletes()}.
	 *
	 * @throws WrongFormatException
	 */
	@Test
	public void testGetAthletes() throws WrongFormatException {
		assertTrue(new CSVImporter(new File("test.csv")).getAthletes().size() > 0);
	}
}