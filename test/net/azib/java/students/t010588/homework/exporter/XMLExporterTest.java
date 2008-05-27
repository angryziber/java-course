package net.azib.java.students.t010588.homework.exporter;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

/**
 * Tests if XMLExporter export data into XML
 *
 * @author Vjatseslav Rosin, 010588
 */
public class XMLExporterTest extends ExporterTest {

	/**
	 * Test method for
	 * {@link net.azib.java.students.t010588.homework.exporter.XMLExporter#exportAthletes(java.util.List)}.
	 *
	 * @throws InternalException
	 */
	@Test
	public void testExportAthletes() throws InternalException {
		new XMLExporter(new File("results.xml")).exportAthletes(athletes);
		assertTrue(new File("results.xml").exists());
	}
}