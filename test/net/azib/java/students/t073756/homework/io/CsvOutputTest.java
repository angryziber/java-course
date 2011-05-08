package net.azib.java.students.t073756.homework.io;

import net.azib.java.students.t073756.homework.Athlete;
import net.azib.java.students.t073756.homework.Place;
import net.azib.java.students.t073756.homework.Result;
import net.azib.java.students.t073756.homework.TestHelper;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static junit.framework.Assert.assertEquals;

public class CsvOutputTest {
	@Test
	public void testWriteAthletes() throws Exception {
		File f = TestHelper.createTempFile();
		CsvOutput out = new CsvOutput(f);

		List<Athlete> athletes = new TestInputProcessor(null).readAthletes();
		Result result = athletes.get(0).getResult();
		result.setOverallResult(1500);
		result.setPlace(new Place(1));

		out.writeAthletes(athletes);

		List<String> lines = FileUtils.readLines(f);
		assertEquals(1, lines.size());

		assertEquals("1,1500," + TestHelper.legalCsvLine, lines.iterator().next());
	}
}
