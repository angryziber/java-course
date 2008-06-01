package net.azib.java.students.t010588.homework.exporter;

import static org.junit.Assert.assertTrue;

import net.azib.java.students.t010588.homework.DecathlonCalculator;

import java.io.File;
import java.net.URL;

import org.junit.Test;

/**
 * Tests if XMLExporter export data into XML
 *
 * @author Vjatseslav Rosin, 010588
 */
public class XMLExporterTest extends AbstractExporterTest {

	/**
	 * Test method for
	 * {@link net.azib.java.students.t010588.homework.exporter.XMLExporter#exportAthletes(java.util.List)}.
	 *
	 * @throws InternalException
	 */
	@Test
	public void testExportAthletes() throws InternalException {
		URL dirUrl = DecathlonCalculator.class.getResource("./");
		File exportFile = new File(dirUrl.getPath() + generateFilename() + ".xml");

		new XMLExporter(exportFile).exportAthletes(athletes);
		assertTrue(exportFile.exists());
	}
}