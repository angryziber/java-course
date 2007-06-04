package net.azib.java.students.t960644.homework;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

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
		athlete.setBirthDate("1.1.1980");
		athlete.setCountryCode("EE");
		competition.addAthlete(athlete);
		Athlete found = competition.findAthleteById(10);
		assertNull(found);
		found = competition.findAthleteById(14);
		assertEquals(found,athlete);
		found=competition.findAthleteByName("Juku Viiding",competition.DATE_FORMAT.parse("02.01.1980"),"EE");
		assertNull(found);
		found=competition.findAthleteByName("Juku Viiding",competition.DATE_FORMAT.parse("01.01.1980"),"EE");
		assertEquals(found,athlete);
	}
	@Test
	public void testSetDate() throws Exception {
		Competition comp = new Competition();
		assertTrue(comp.getStringDate().equals(""));
		comp.setDate("5.6.2000");
		assertTrue(comp.getStringDate().equals("05.06.2000"));
	}
}
