package net.azib.java.students.t030630.homework;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

/**
 * IOHandlerTest
 * 
 * @author Sergei
 */
public class IOHandlerTest {
	private IOHandler iohandler;
	private SortedSet<Athlete> athletes;
	private String fs = File.separator;
	private final String FILEPATH = "src" + fs + "net" + fs + "azib" + fs + "java" + fs + "students" + fs + "t030630" + fs
			+ "homework" + fs;

	@Before
	public void setUp() {
		athletes = new TreeSet<Athlete>(new Comparator<Athlete>() {
			@Override
			public int compare(Athlete o1, Athlete o2) {
				if (o2.getPoints() != o1.getPoints()) {
					if (o2.getName().hashCode() == o1.getName().hashCode()
							&& o2.getDateOfBirth().hashCode() == o1.getDateOfBirth().hashCode()
							&& o2.getCountry().hashCode() == o1.getCountry().hashCode())
						return 0;
					return o2.getPoints() - o1.getPoints();
				}
				else if (o2.getName().hashCode() != o1.getName().hashCode())
					return o2.getName().hashCode() - o1.getName().hashCode();
				else if (o2.getDateOfBirth().hashCode() != o1.getDateOfBirth().hashCode())
					return o2.getDateOfBirth().hashCode() - o1.getDateOfBirth().hashCode();
				else
					return o2.getCountry().hashCode() - o1.getCountry().hashCode();
			}
		});

		// further are listed 5 athletes that have the same results, but they
		// differ by Name, date of birthday or Country
		athletes.add(new Athlete("\"Василий Пупкин\",21.10.1984,UA,13.43,4.35,8.64,1.50,1:06.06,19.05,24.89,2.20,33.48,6:51.01")); // 3100
		athletes.add(new Athlete("\"Василий Пупкин\",21.10.1980,UA,13.43,4.35,8.64,1.50,1:06.06,19.05,24.89,2.20,33.48,6:51.01")); // 3100
		athletes.add(new Athlete("\"Василий Пупкин\",21.10.1984,RU,13.43,4.35,8.64,1.50,1:06.06,19.05,24.89,2.20,33.48,6:51.01")); // 3100
		athletes.add(new Athlete("\"Василий Пкин\",21.10.1984,UA,13.43,4.35,8.64,1.50,1:06.06,19.05,24.89,2.20,33.48,6:51.01")); // 3100
		athletes.add(new Athlete("\"Василий Пкин\",21.10.1980,RU,13.43,4.35,8.64,1.50,1:06.06,19.05,24.89,2.20,33.48,6:51.01")); // 3100

		// this athlete has the same personal information as the preceding one,
		// but different result(the last one) --> therefore this
		// athlete is omitted since there mustn't be at competition the athlete
		// with the same personal information
		athletes.add(new Athlete("\"Василий Пкин\",21.10.1980,RU,13.43,4.35,8.64,1.50,1:06.06,19.05,24.89,2.20,33.48,8:51.01")); // 3100

		// this one is copy of the first athlete --> therefore is omitted,
		// considered as a mistake(reentered results of the same athlete)
		athletes.add(new Athlete("\"Василий Пупкин\",21.10.1984,RU,13.43,4.35,8.64,1.50,1:06.06,19.05,24.89,2.20,33.48,6:51.01")); // 3100

		athletes.add(new Athlete("\"Siim Susi\",01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72")); // 4234
		athletes.add(new Athlete("\"Szőrös Szűk\",3.04.1972,HU,13.75,4.84,10.12,1.50,1:08.44,19.18,30.85,2.80,33.88,6:22.75")); // 3495
		athletes.add(new Athlete("\"Kim Musi\",01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72")); // 4234

		iohandler = new IOHandler();
		iohandler.setAthletes(athletes);
		iohandler.setPlacesToAthletes();

	}

	@Test
	public void testCorrectnessOfPlacesOfAthletes() throws Exception {

		int i = 0;
		String place = "";
		for (Athlete athl : iohandler.getAthletes()) {
			// System.out.println(athl.getPlace());
			if (i++ == 3)
				place = athl.getPlace();
		}
		assertEquals("4-8", place);
	}

	@Test
	public void testReadingOfFile() throws Exception {
		String fileName = FILEPATH + "decathlonInputTest.csv";
		iohandler.readInputFromCSVFile(fileName);
		Athlete athlete = new Athlete("\"Siim Susi\",01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72");
		athlete.setPlace("1-2");
		assertTrue(iohandler.getAthletes().contains(athlete));
	}

	@Test
	public void testReadingFromMySQLDatabase() throws Exception {
		IOHandler io = new IOHandler();
		io.readInputFromMySQLDatabase("Training in Tallinn");
		io.setPlacesToAthletes();
		Athlete athlete = new Athlete(
				"\"Erki Nool\",25.06.1970,Estonia,10.94,7.83,12.48,2.0,0:49.72,15.67,38.3,5.4,55.84,4:31.720001");
		athlete.setPlace("1");
		assertTrue(io.getAthletes().contains(athlete));
	}

	@Test
	public void testWritingToCSVFile() throws Exception {
		iohandler.writeOutputToCSVFile(FILEPATH + "decathlonOutputTest.csv");
		BufferedReader bufferedReader;
		bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(FILEPATH + "decathlonOutputTest.csv"),
				"UTF-8"));
		String[] lines = new String[athletes.size()];
		String line = "";
		int lineNumber = 0;
		while ((line = bufferedReader.readLine()) != null) {
			lines[lineNumber++] = line;
		}
		bufferedReader.close();
		lineNumber = 0;
		for (Athlete athl : athletes) {
			assertEquals(lines[lineNumber++], athl.getAthletePersonalInfoAndResults());
		}

	}
}
