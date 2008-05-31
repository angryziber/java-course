package net.azib.java.students.t010588.homework.importer;

import net.azib.java.students.t010588.homework.ResultsConverter;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tests if DatabaseImporter has athletes after fetching from database
 *
 * @author Vjatseslav Rosin, 010588
 */
public class DatabaseImporterTest {

	/**
	 * Test method for
	 * {@link net.azib.java.students.t010588.homework.importer.DatabaseImporter#getAthletes()}.
	 *
	 * @throws WrongFormatException
	 */
	@Test
	public void testGetAthletes() throws WrongFormatException {
		assertTrue(new DatabaseImporter(ResultsConverter.class.getResourceAsStream(DBConstants.DEFAULT_DB_PROP_FILE_NAME), "1")
				.getAthletes().size() > 0);
	}
}
