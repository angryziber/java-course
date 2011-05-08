package net.azib.java.students.t073756.homework.io;

import net.azib.java.students.t073756.homework.Athlete;
import net.azib.java.students.t073756.homework.Place;
import net.azib.java.students.t073756.homework.Result;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class CsvOutputTest {

	private File f;

	@Before
	public void setUp() throws Exception {
		f = File.createTempFile("tmp", null);
		f.deleteOnExit();
	}

	@Test
	public void testWriteAthletes() throws Exception {
		CsvOutput out = new CsvOutput(f);

		List<Athlete> athletes = new TestInputProcessor(null).readAthletes();
		Result result = athletes.get(0).getResult();
		result.setOverallResult(1500);
		result.setPlace(new Place(1));

		out.writeAthletes(athletes);

		List<String> lines = IOUtils.readLines(new FileInputStream(f));
		assertEquals(1, lines.size());

		assertEquals("1,1500,Siim Susi,01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72", lines.iterator().next());
	}
}
