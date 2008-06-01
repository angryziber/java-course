package net.azib.java.students.t010588.homework.exporter;

import net.azib.java.students.t010588.homework.DecathlonCalculator;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URL;

import org.junit.Test;

/**
 * Tests if CSVExporter export data into CSV
 *
 * @author Vjatseslav Rosin, 010588
 */
public class CSVExporterTest extends AbstractExporterTest {

	/**
	 * Test method for
	 * {@link net.azib.java.students.t010588.homework.exporter.CSVExporter#exportAthletes(java.util.List)}.
	 *
	 * @throws InternalException
	 */
	@Test
	public void testExportAthletes() throws InternalException {
		URL dirUrl = DecathlonCalculator.class.getResource("./");
		File exportFile = new File(dirUrl.getPath() + generateFilename() + ".csv");

		new CSVExporter(exportFile).exportAthletes(athletes);
		assertTrue(exportFile.exists());
	}
}