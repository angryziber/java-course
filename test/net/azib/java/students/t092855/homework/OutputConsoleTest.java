package net.azib.java.students.t092855.homework;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * OutputConsoleTest
 *
 * @author t092855
 */
public class OutputConsoleTest {
	private final String LS = System.getProperty("line.separator");
	private final double[] testResults1 = {9.58, 8.22, 23.12, 2.45, 43.18, 12.87, 74.08, 6.14, 98.48, 206.00};
	private final double[] testResults2 = {10.45, 8.22, 23.12, 2.45, 43.18, 12.87, 74.08, 6.14, 98.48, 206.00};
	private final int testPoints1 = 1202 + 1117 + 1295 + 1244 + 1156 + 1126 + 1383 + 1277 + 1331 + 1218;
	private final int testPoints2 = 987 + 1117 + 1295 + 1244 + 1156 + 1126 + 1383 + 1277 + 1331 + 1218;

	/**
	 * Unit test for {@link OutputConsole#writeOutput(Competition, String...)}
	 * @throws java.text.ParseException date parsing fails
	 */
	@Test
	public void outputIsWrittenCorrectlyWithMocking() throws ParseException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		OutputConsole outputConsole = new OutputConsole();
		outputConsole.output = new PrintStream(outputStream);

		DecathlonEvents decathlonEvents1 = mock(DecathlonEvents.class);
		when(decathlonEvents1.getTotalPoints()).thenReturn(testPoints1);
		when(decathlonEvents1.getDecathlonResults()).thenReturn(testResults1);

		DecathlonEvents decathlonEvents2 = mock(DecathlonEvents.class);
		when(decathlonEvents2.getTotalPoints()).thenReturn(testPoints2);
		when(decathlonEvents2.getDecathlonResults()).thenReturn(testResults2);

		Athlete athlete1 = mock(Athlete.class);
		when(athlete1.getName()).thenReturn("Jim Beam");
		when(athlete1.getBirthday()).thenReturn(new SimpleDateFormat("dd.MM.yyyy").parse("01.01.1795"));
		when(athlete1.getCountry()).thenReturn("US");
		when(athlete1.getAthleteEvents()).thenReturn(decathlonEvents1);

		Athlete athlete2 = mock(Athlete.class);
		when(athlete2.getName()).thenReturn("Siim Piim");
		when(athlete2.getBirthday()).thenReturn(new SimpleDateFormat("dd.MM.yyyy").parse("12.11.1967"));
		when(athlete2.getCountry()).thenReturn("EE");
		when(athlete2.getAthleteEvents()).thenReturn(decathlonEvents1);

		Athlete athlete3 = mock(Athlete.class);
		when(athlete3.getName()).thenReturn("James Last");
		when(athlete3.getBirthday()).thenReturn(new SimpleDateFormat("dd.MM.yyyy").parse("14.04.1972"));
		when(athlete3.getCountry()).thenReturn("GB");
		when(athlete3.getAthleteEvents()).thenReturn(decathlonEvents2);

		// did not find a way to generate a generic class without warning
		@SuppressWarnings("unchecked")
		Iterator<Athlete> iterator = (Iterator<Athlete>)mock(Iterator.class);
		when(iterator.hasNext()).thenReturn(true).thenReturn(true).thenReturn(false);
		when(iterator.next()).thenReturn(athlete1).thenReturn(athlete2).thenReturn(athlete3).thenReturn(null);

		// did not find a way to generate a generic class without warning
		@SuppressWarnings("unchecked")
		Collection<Athlete> athleteCollection = (Collection<Athlete>)mock(Collection.class);
		when(athleteCollection.isEmpty()).thenReturn(false);
		when(athleteCollection.iterator()).thenReturn(iterator);

		Competition competition = mock(Competition.class);
		when(competition.getCompetitors()).thenReturn(athleteCollection);
		when(competition.getAthletePlace(athlete1)).thenReturn("1-2");
		when(competition.getAthletePlace(athlete2)).thenReturn("1-2");
		when(competition.getAthletePlace(athlete3)).thenReturn("3");

		outputConsole.writeOutput(competition);

		String expectedOutput = "Here are the points" + LS;
		expectedOutput += "1-2 " + testPoints1 + " Jim Beam " + formatBirthday("01.01.1795") + " US " +
				"9.58 8.22 23.12 2.45 43.18 12.87 74.08 6.14 98.48 206.0 " + LS;
		expectedOutput += "1-2 " + testPoints1 + " Siim Piim " + formatBirthday("12.11.1967") + " EE " +
				"9.58 8.22 23.12 2.45 43.18 12.87 74.08 6.14 98.48 206.0 " + LS;
		expectedOutput += "3 " + testPoints2 + " James Last " + formatBirthday("14.04.1972") + " GB " +
				"10.45 8.22 23.12 2.45 43.18 12.87 74.08 6.14 98.48 206.0 " + LS;
		assertEquals(expectedOutput, outputStream.toString());
	}

	/**
	 * Unit test for {@link OutputConsole#writeOutput(Competition, String...)}
	 * @throws java.text.ParseException date parsing fails
	 */
	@Test
	public void outputIsWrittenCorrectly() throws ParseException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		OutputConsole outputConsole = new OutputConsole();
		outputConsole.output = new PrintStream(outputStream);

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

		outputConsole.writeOutput(competition);

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
