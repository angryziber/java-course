package net.azib.java.students.t010588.homework.exporter;

import static org.junit.Assert.assertTrue;

import net.azib.java.students.t010588.homework.DecathlonCalculator;

import java.io.File;
import java.net.URL;

import org.junit.Test;

/**
 * Tests if HTMLExporter export data into HTML
 *
 * @author Vjatseslav Rosin, 010588
 */
public class HTMLExporterTest extends ExporterTest {

	/**
	 * Test method for
	 * {@link net.azib.java.students.t010588.homework.exporter.HTMLExporter#exportAthletes(java.util.List)}.
	 *
	 * @throws InternalException
	 */
	@Test
	public void testExportAthletes() throws InternalException {
		URL dirUrl = DecathlonCalculator.class.getResource("./");
		File exportFile = new File(dirUrl.getPath() + generateFilename() + ".html");

		new HTMLExporter(exportFile, DecathlonCalculator.class.getResourceAsStream(HTMLExporter.DEFAULT_STYLE_FILE_NAME))
				.exportAthletes(athletes);
		assertTrue(exportFile.exists());
	}
}