package net.azib.java.students.t010588.homework.importer;

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
		new CSVImporter(CSVImporterTest.class.getResourceAsStream(getClass().getSimpleName() + ".class"));
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t010588.homework.importer.CSVImporter#getAthletes()}.
	 *
	 * @throws WrongFormatException
	 */
	@Test
	public void testGetAthletes() throws WrongFormatException {
		assertTrue(new CSVImporter(CSVImporterTest.class.getResourceAsStream("csvTest.csv")).getAthletes().size() > 0);
	}
}