package net.azib.java.students.t010588.homework.exporter;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

/**
 * Tests if CSVExporter export data into CSV
 *
 * @author Vjatseslav Rosin, 010588
 */
public class CSVExporterTest extends ExporterTest {

	/**
	 * Test method for
	 * {@link net.azib.java.students.t010588.homework.exporter.CSVExporter#exportAthletes(java.util.List)}.
	 *
	 * @throws InternalException
	 */
	@Test
	public void testExportAthletes() throws InternalException {
		new CSVExporter(new File("results.csv")).exportAthletes(athletes);
		assertTrue(new File("results.csv").exists());
	}
}