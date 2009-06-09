package net.azib.java.students.t050545.homework.sport;

import net.azib.java.students.t050545.homework.sport.AthleteScore;
import net.azib.java.students.t050545.homework.sport.Competition;
import net.azib.java.students.t050545.homework.sport.Person;
import net.azib.java.students.t050545.homework.sport.Places;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

/**
 * CompetitionTest
 *
 * @author libricon
 */
public class CompetitionTest {
	
	@Test
	public void testGetName(){
		Competition comp = new Competition("MegaCup", 2);
		assertEquals("MegaCup", comp.getName());
	}
	
	@Test
	public void testGetID(){
		Competition comp = new Competition("MegaCup", 2);
		assertEquals(2, comp.getId());
	}
	@Test
	public void testGetPlaces() {
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
		AthleteScore sportman0 = 
			new AthleteScore(arrayScore, new Person("first1", "RU", new Date()));
		arrayScore[0] = 9f;
		AthleteScore sportman1 = 
			new AthleteScore(arrayScore, new Person("first2", "RU", new Date()));
		AthleteScore sportman2 = 
			new AthleteScore(arrayScore, new Person("second", "RU", new Date()));
		Competition comp = new Competition();
		comp.addCompetitor(sportman0);
		comp.addCompetitor(sportman1);
		comp.addCompetitor(sportman2);
		Places[] places = comp.getPlaces();
		assertEquals(places[0].getPlaceNum(), "1-2");
		assertEquals(places[1].getPlaceNum(), "1-2");
		assertEquals(places[2].getPlaceNum(), "3");
	}

}
