package net.azib.java.students.t010588.homework.exporter;

import org.junit.Test;

/**
 * Tests if ConsoleExporter export data into console
 *
 * @author Vjatseslav Rosin, 010588
 */
public class ConsoleExporterTest extends ExporterTest {

	/**
	 * Test method for
	 * {@link net.azib.java.students.t010588.homework.exporter.ConsoleExporter#exportAthletes(java.util.List)}.
	 */
	@Test
	public void testExportAthletes() {
		new ConsoleExporter().exportAthletes(athletes);
	}
}