package net.azib.java.students.t092855.homework;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * ConsoleOutputTest
 *
 * @author t092855
 */
public class ConsoleOutputTest {
	private final String LS = System.getProperty("line.separator");
	/**
	 * Unit test for {@link net.azib.java.students.t092855.homework.ConsoleOutput#writeOutput(Competition, String...)}
	 * @throws java.text.ParseException date parsing fails
	 */
	@Test
	public void outputIsWrittenCorrectly() throws ParseException {
		double[] testResults1 = {9.58, 8.22, 23.12, 2.45, 43.18, 12.87, 74.08, 6.14, 98.48, 206.00};
		double[] testResults2 = {10.45, 8.22, 23.12, 2.45, 43.18, 12.87, 74.08, 6.14, 98.48, 206.00};
		int testPoints1 = 1202 + 1117 + 1295 + 1244 + 1156 + 1126 + 1383 + 1277 + 1331 + 1218;
		int testPoints2 = 987 + 1117 + 1295 + 1244 + 1156 + 1126 + 1383 + 1277 + 1331 + 1218;

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ConsoleOutput consoleOutput = new ConsoleOutput();
		consoleOutput.output = new PrintStream(outputStream);

		Competition competition = new Competition();

		Athlete athlete = createAnAthlete("Siim Piim",
				formatBirthday("12.11.1967"),
				"EE",
				new DecathlonEvents(testResults1));
        competition.addAthlete(athlete);

		athlete = createAnAthlete("Jim Beam",
				formatBirthday("01.01.1795"),
				"US",
				new DecathlonEvents(testResults1));
        competition.addAthlete(athlete);

		athlete = createAnAthlete("James Last",
				formatBirthday("14.04.1972"),
				"GB",
				new DecathlonEvents(testResults2));
		competition.addAthlete(athlete);

		consoleOutput.writeOutput(competition);

		String expectedOutput = "Here are the points" + LS;
		expectedOutput += "1-2 " + testPoints1 + " Jim Beam " + formatBirthday("01.01.1795") + " US " +
				"9.58 8.22 23.12 2.45 43.18 12.87 74.08 6.14 98.48 206.0 " + LS;
		expectedOutput += "1-2 " + testPoints1 + " Siim Piim " + formatBirthday("12.11.1967") + " EE " +
				"9.58 8.22 23.12 2.45 43.18 12.87 74.08 6.14 98.48 206.0 " + LS;
		expectedOutput += "3 " + testPoints2 + " James Last " + formatBirthday("14.04.1972") + " GB " +
				"10.45 8.22 23.12 2.45 43.18 12.87 74.08 6.14 98.48 206.0 " + LS;

		assertEquals(expectedOutput, outputStream.toString());
	}

	private Athlete createAnAthlete(String name, String birthday, String country, DecathlonEvents decathlonEvents) {
		Athlete athlete = new Athlete();
		athlete.setName(name);
		athlete.setBirthday(birthday);
		athlete.setCountry(country);
		athlete.setDecathlonEvent(decathlonEvents);
		return athlete;
	}

	private String formatBirthday(String birthday) throws ParseException {
		SimpleDateFormat dateFormat = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.MEDIUM);
		Date date = new SimpleDateFormat("dd.MM.yyyy").parse(birthday);
		return dateFormat.format(date);
	}
}
