package net.azib.java.students.t010588.homework.importer;

import static org.junit.Assert.assertTrue;

import java.io.File;

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
		assertTrue(new DatabaseImporter(new File("db.properties"), "1").getAthletes().size() > 0);
	}
}
