package net.azib.java.students.t050545.homework.sport;

import net.azib.java.students.t050545.homework.sport.AthleteScore;
import net.azib.java.students.t050545.homework.sport.Person;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;

import org.junit.Test;

/**
 * AthleteScoreTest
 * 
 * @author libricon
 */
public class AthleteScoreTest {

	@Test
	public void testGetPerson() throws Exception {
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
		AthleteScore sportman = new AthleteScore(arrayScore, new Person("Kirill", "RU", new GregorianCalendar(1987, 4, 29)
				.getTime()));
		assertEquals("Kirill", sportman.getPerson().getName());
		assertEquals("RU", sportman.getPerson().getCountry());
		assertEquals(new GregorianCalendar(1987, 4, 29).getTime(), sportman.getPerson().getBirthDay());
	}
	
	@Test
	public void testGetPoints() throws Exception {
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
		AthleteScore sportman = new AthleteScore(arrayScore, new Person("Kirill", "RU", new GregorianCalendar(1987, 4, 29)
				.getTime()));
		assertEquals(1000, sportman.getPoints().getScores()[2],10);
		assertEquals(1000, sportman.getPoints().getScores()[5],10);
		assertEquals(1000, sportman.getPoints().getScores()[9],10);
		
		
	}
}
