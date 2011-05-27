package net.azib.java.students.t103800.homework.decathlon;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.StringTokenizer;

import org.junit.Test;

public class AthleteTest {

	private static final String[] CSVResults = {
		"\"Siim Susi\",01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72",
		"\"Beata Kana\",28.02.1982,ZA,13.04,4.53,7.79,1.55,1:04.72,18.74,24.20,2.40,28.20,6:50.76",
		"\"José Mañana Perez\",03.04.1972,ES,13.75,4.84,10.12,1.50,1:08.44,19.18,30.85,2.80,33.88,6:22.75",
		"\"Василий Пупкин\",21.10.1980,UA,13.43,4.35,8.64,1.50,1:06.06,19.05,24.89,2.20,33.48,6:51.01"};

	private static final String[] NiceReadableResults = {
		"\"Siim Susi\", 01.01.1976, EE, 12.61, 5.00, 9.22, 1.50, 59.39, 16.43, 21.60, 2.60, 35.81, 5:25.72",
		"\"Beata Kana\", 28.02.1982, ZA, 13.04, 4.53, 7.79, 1.55, 1:04.72, 18.74, 24.20, 2.40, 28.20, 6:50.76",
		"\"José Mañana Perez\", 03.04.1972, ES, 13.75, 4.84, 10.12, 1.50, 1:08.44, 19.18, 30.85, 2.80, 33.88, 6:22.75",
		"\"Василий Пупкин\", 21.10.1980, UA, 13.43, 4.35, 8.64, 1.50, 1:06.06, 19.05, 24.89, 2.20, 33.48, 6:51.01"};

	@Test
	public void testAthlete() {
		Athlete athlete = new Athlete();
		assertNull(athlete.getName());
		assertNull(athlete.getBirthDate());
		assertNull(athlete.getCountryCode());
	}

	@Test
	public void testSetGetName() {
		Athlete athlete = new Athlete();
		athlete.setName("jüri");
		assertEquals("jüri", athlete.getName());
		athlete.setName("óri óri");
		assertEquals("óri óri", athlete.getName());
	}

	@Test
	public void testSetGetBirthDate() throws ParseException {
		Athlete athlete = new Athlete();
		athlete.setBirthDate("10.10.2003");
		assertEquals("10.10.2003", athlete.getBirthDate());
		athlete.setBirthDate("1.7.2011");
		assertEquals("01.07.2011", athlete.getBirthDate());
	}

	@Test(expected=ParseException.class)
	public void testSetGetBirthDateFailure1() throws ParseException {
		Athlete athlete = new Athlete();
		athlete.setBirthDate("29.02.1982");
	}

	@Test(expected=ParseException.class)
	public void testSetGetBirthDateFailure2() throws ParseException {
		Athlete athlete = new Athlete();
		athlete.setBirthDate("10.13.1982");
	}

	@Test
	public void testSetGetCountryCode() throws CountryCodeException {
		Athlete athlete = new Athlete();
		athlete.setCountryCode("us");
		assertEquals("US", athlete.getCountryCode());
		athlete.setCountryCode("Ee");
		assertEquals("EE", athlete.getCountryCode());
		athlete.setCountryCode("CH");
		assertEquals("CH", athlete.getCountryCode());
	}

	@Test(expected=CountryCodeException.class)
	public void testSetGetCountryCodeFailure1() throws CountryCodeException {
		Athlete athlete = new Athlete();
		athlete.setCountryCode("asd");
	}

	@Test(expected=CountryCodeException.class)
	public void testSetGetCountryCodeFailure2() throws CountryCodeException {
		Athlete athlete = new Athlete();
		athlete.setCountryCode("WW");
	}

	@Test
	public void testSetGetResult() throws ParseException {
		Athlete athlete = new Athlete();
		athlete.setResult(Athlete.Event.DISCUSTHROW, "50.25");
		assertEquals(50.25, athlete.getResult(Athlete.Event.DISCUSTHROW), 0.1);
		athlete.setResult(Athlete.Event.RACE1500M, "5:25.72");
		assertEquals(325.72, athlete.getResult(Athlete.Event.RACE1500M), 0.1);
		athlete.setResult(Athlete.Event.HURDLES110M, "14.3");
		assertEquals(14.30, athlete.getResult(Athlete.Event.HURDLES110M), 0.1);
		athlete.setResult(Athlete.Event.SHOTPUT, "31.2");
		assertEquals(31.2, athlete.getResult(Athlete.Event.SHOTPUT), 0.1);
		athlete.setResult(Athlete.Event.SPRINT400M, "1:0.1");
		assertEquals(60.1, athlete.getResult(Athlete.Event.SPRINT400M), 0.1);
	}

	@Test
	public void testGetResultAsString() throws ParseException {
		Athlete athlete = new Athlete();
		athlete.setResult(Athlete.Event.DISCUSTHROW, "50.25");
		assertEquals("50.25", athlete.getResultAsString(Athlete.Event.DISCUSTHROW));
		athlete.setResult(Athlete.Event.RACE1500M, "5:25.72");
		assertEquals("5:25.72", athlete.getResultAsString(Athlete.Event.RACE1500M));
		athlete.setResult(Athlete.Event.HURDLES110M, "14.3");
		assertEquals("14.30", athlete.getResultAsString(Athlete.Event.HURDLES110M));
		athlete.setResult(Athlete.Event.SHOTPUT, "31.2");
		assertEquals("31.20", athlete.getResultAsString(Athlete.Event.SHOTPUT));
		athlete.setResult(Athlete.Event.SPRINT400M, "1:0.1");
		assertEquals("1:00.10", athlete.getResultAsString(Athlete.Event.SPRINT400M));

	}

	@Test
	public void testGetAsCSVString() throws ParseException, CountryCodeException {
		Athlete athlete;

		for (String CSVResult : CSVResults) {
			athlete = new Athlete();
			StringTokenizer tokenizer = new StringTokenizer(CSVResult, ",");
			athlete.setName(tokenizer.nextToken());
			athlete.setBirthDate(tokenizer.nextToken());
			athlete.setCountryCode(tokenizer.nextToken());
			for (Athlete.Event event : Athlete.Event.values()) athlete.setResult(event, tokenizer.nextToken());
			assertEquals(CSVResult, athlete.getAsCSVString());
		}
	}

	@Test
	public void testGetAsReadableString() throws ParseException, CountryCodeException {
		Athlete athlete;

		for(int index = 0; index < CSVResults.length; index++) {
			athlete = new Athlete();
			StringTokenizer tokenizer = new StringTokenizer(CSVResults[index] , ",");
			athlete.setName(tokenizer.nextToken());
			athlete.setBirthDate(tokenizer.nextToken());
			athlete.setCountryCode(tokenizer.nextToken());
			for(Athlete.Event event : Athlete.Event.values()) athlete.setResult(event, tokenizer.nextToken());
			assertEquals(NiceReadableResults[index], athlete.getAsReadableString());
		}
	}
}