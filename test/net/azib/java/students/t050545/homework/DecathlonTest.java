package net.azib.java.students.t050545.homework;


import net.azib.java.students.t050545.homework.sport.Competition;
import net.azib.java.students.t050545.homework.sport.Person;
import net.azib.java.students.t050545.homework.sport.Places;
import net.azib.java.students.t050545.homework.sport.PointSystem;
import net.azib.java.students.t050545.homework.sport.AthleteScore;
import net.azib.java.students.t050545.homework.utils.DataChecker;

import static org.junit.Assert.assertEquals;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

/**
 * DecathlonTest
 * 
 * @author libricon
 */
public class DecathlonTest {

	@Test
	public void getScoreReturns1000() throws Exception {
		float[] arrayScore = new float[10];
		arrayScore[0] = 10.395f;
		arrayScore[1] = 776f;
		arrayScore[2] = 18.4f;
		arrayScore[3] = 220.8f;
		arrayScore[4] = 46.17f;
		arrayScore[5] = 13.8f;
		arrayScore[6] = 56.17f;
		arrayScore[7] = 528.5f;
		arrayScore[8] = 77.19f;
		arrayScore[9] = 233.79001f;
		PointSystem points = new PointSystem(arrayScore);
		assertEquals(" Hurra  ", 10000, points.getScore(), 10);
	}

	@Test
	public void testPersonClass() throws Exception {
		Person person = new Person("Jon Doe", "RU", new GregorianCalendar().getTime());
		assertEquals("Jon Doe", person.getName());
		assertEquals("RU", person.getCountry());
	}

	@Test
	public void testSportmanClass() throws Exception {
		float[] arrayScore = new float[10];
		arrayScore[0] = 10.395f;
		arrayScore[1] = 7.76f;
		arrayScore[2] = 18.4f;
		arrayScore[3] = 2.208f;
		arrayScore[4] = 46.17f;
		arrayScore[5] = 13.8f;
		arrayScore[6] = 56.17f;
		arrayScore[7] = 5.285f;
		arrayScore[8] = 77.19f;
		arrayScore[9] = 233.79001f;
		AthleteScore sportman = new AthleteScore(arrayScore, new Person("Kirill", "RU", new GregorianCalendar(1987, 4,29).getTime()));
		assertEquals("Kirill", sportman.getPerson().getName());
		assertEquals(10000, sportman.getPoints().getScore(), 10);
		//assertEquals(new GregorianCalendar(1987, 4, 29).getTime(), sportman.getPerson().getBirthDay().getTime());
	}

	@Test
	public void testCompetition() {
		float[] arrayScore = new float[10];
		arrayScore[0] = 10.395f;
		arrayScore[1] = 7.76f;
		arrayScore[2] = 18.4f;
		arrayScore[3] = 2.208f;
		arrayScore[4] = 46.17f;
		arrayScore[5] = 13.8f;
		arrayScore[6] = 56.17f;
		arrayScore[7] = 5.285f;
		arrayScore[8] = 77.19f;
		arrayScore[9] = 233.79001f;
		AthleteScore sportman0 = new AthleteScore(arrayScore, new Person("first", "RU", new GregorianCalendar(1987, 4, 29).getTime()));
		arrayScore[0] = 9f;
		AthleteScore sportman1 = new AthleteScore(arrayScore, new Person("first", "RU", new GregorianCalendar(1987, 4, 29).getTime()));
		AthleteScore sportman2 = new AthleteScore(arrayScore, new Person("second", "RU", new GregorianCalendar(1987, 4, 29).getTime()));
		Competition comp = new Competition();
		comp.addCompetitor(sportman0);
		comp.addCompetitor(sportman1);
		comp.addCompetitor(sportman2);
		Places[] places = comp.getPlaces();
		assertEquals(places[0].getPlaceNum(), "1-2");
		assertEquals(places[1].getPlaceNum(), "1-2");
		assertEquals(places[2].getPlaceNum(), "3");
	}

	@Test
	public void testDataChecker() throws ParseException {
		DataChecker checker = new DataChecker();
		assertEquals(true, checker.isValidCountry("RU"));
		assertEquals(true, checker.isValidCountry("EN"));
		assertEquals(true, checker.isValidCountry("FR"));
		assertEquals(checker.isValidDate("29.03.1987", new SimpleDateFormat("dd.MM.yyyy")), true);
		assertEquals(checker.isValidDate("29.02.1987", new SimpleDateFormat("dd.MM.yyyy")), false);
		assertEquals(checker.isValidDate("29.13.1987", new SimpleDateFormat("dd.MM.yyyy")), false);
		assertEquals(checker.isCorrectResult(10f), true);
		assertEquals(checker.isCorrectResult(-10f), false);
		GregorianCalendar greg = new GregorianCalendar();
		greg.clear();
		greg.set(1987, 02, 29);
		assertEquals(checker.toParseBirthDay("29.03.1987", new SimpleDateFormat("dd.MM.yyyy")).getTime(), greg.getTime());
		greg.set(0000, 00, 01);
		assertEquals(checker.toParseBirthDay("01.01.0000", new SimpleDateFormat("dd.MM.yyyy")).getTime(), greg.getTime());
		assertEquals("RU", checker.addCountry("ru"));

	}
}
