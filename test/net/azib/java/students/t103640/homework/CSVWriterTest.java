package net.azib.java.students.t103640.homework;

import org.junit.Test;

import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;

import static junit.framework.Assert.assertTrue;

public class CSVWriterTest {
	/**
	 * Tests CSVWriter, also tests a little CSVReader, as it reads back and validates the data, it has written
	 * @throws ParseException when creating fake athlete something goes wrong with date, then throws it.
	 */

	@Test
	public void writeDataToCSVTest() throws ParseException {
		ArrayList<Athlete> fakeAthletes = createFakeAthleteList();

		DataToCSVWriter csvWriter = new DataToCSVWriter();

		String testFile = "csvTest.csv";

		csvWriter.writeDataToCSV(fakeAthletes, testFile);

		assertTrue(new File(testFile).exists());

		CSVReader csvReader = new CSVReader();
		ArrayList<String> data =  csvReader.readInData(testFile);
		String[] line1 = null;
		String[] line2 = null;

		for (String s : data) {
			if(line1 == null) line1 = s.split(",");
			else line2 = s.split(",");
		}

		assert line1 != null && line2 != null;
		assertTrue(line1[2].contains("Taavi"));
		assertTrue(line2[2].contains("James"));

	}

	/**
	 * A method that returns fake list of athletes, that can be used for testing purposes.
	 * @return  Returns fake list of athletes for testing
	 * @throws ParseException throws it when cant phrase dateCorrectly
	 */
	protected ArrayList<Athlete> createFakeAthleteList() throws ParseException {
		ArrayList<Athlete> fakeAthletes = new ArrayList<Athlete>();

		Athlete perfectScore = new Athlete();
		perfectScore.setScore(10000);
		perfectScore.setName("Taavi");
		perfectScore.setPlace("1");
		perfectScore.setCountry("EE");
		perfectScore.setBirthday(new CustomUtilities().checkDate("13.04.1991"));
		fakeAthletes.add(perfectScore);

		Athlete whimp = new Athlete();
		whimp.setScore(10);
		whimp.setName("James Cameron");
		whimp.setPlace("2");
		whimp.setCountry("US");
		whimp.setBirthday(new CustomUtilities().checkDate("1.1.1"));
		fakeAthletes.add(whimp);

		return fakeAthletes;
	}
}
