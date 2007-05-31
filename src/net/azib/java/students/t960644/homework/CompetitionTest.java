package net.azib.java.students.t960644.homework;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Test;

/**
 * CompetitionTest
 * 
 * @author Lembit
 */
public class CompetitionTest {

	@Test
	public void testAddAthlete() throws Exception {
		Competition competition = new Competition();
		Athlete athlete = new Athlete();
		competition.addAthlete(athlete);
		assertTrue(!competition.getAthletes().isEmpty());
	}

	@Test
	public void testfindAthlete() throws Exception {
		Competition competition = new Competition();
		Athlete athlete = new Athlete();
		athlete.setId(14);
		athlete.setName("Juku Viiding");
		athlete.setBorn(Date.valueOf("1980-1-1"));
		athlete.setCountryCode("EE");
		competition.addAthlete(athlete);
		Athlete found = competition.findAthleteById(10);
		assertNull(found);
		found = competition.findAthleteById(14);
		assertEquals(found,athlete);
		found=competition.findAthleteByName("Juku Viiding",Date.valueOf("1980-1-2"),"EE");
		assertNull(found);
		found=competition.findAthleteByName("Juku Viiding",Date.valueOf("1980-1-1"),"EE");
		assertEquals(found,athlete);
	}
}
