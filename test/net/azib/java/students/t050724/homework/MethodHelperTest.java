package net.azib.java.students.t050724.homework;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Test;


/**
 * MethodHelperTest
 *
 * @author xom
 */
public class MethodHelperTest {
	
	SupportClass supporter = new SupportClass();
	
	@Test
	public void testGetAthleteResultWithMins() throws Exception {
		
		assertEquals("1:00.12", supporter.getAthleteResultWithMins(60.12));
		assertEquals("45.00", supporter.getAthleteResultWithMins(45));
		assertEquals("2:01.10", supporter.getAthleteResultWithMins(121.1));
	}
	
	@Test
	public void testCheckCorrectAthleteName() throws Exception {
		assertEquals("Õige Nimi", supporter.checkAthleteName("Õige Nimi"));
	}
	
	@Test(expected=Exception.class)
	public void testCheckFlawedAthleteName() throws Exception {
		assertEquals("foo", supporter.checkAthleteName("Õige 9imi"));
	}
	
	@Test
	public void testCheckAthleteDate() throws Exception {
		Date d = Date.valueOf("1985-11-27");
		assertEquals(d, supporter.checkAthleteDate("27.11.1985"));	
	}
	
	@Test
	public void testCheckAthleteCountry() throws Exception {
		assertEquals("EE", supporter.checkAthleteCountry("EE"));	
	}
	
	@Test
	public void testSetAthleteResultDoubleWithMins() throws Exception {
		
		assertEquals(61.12, supporter.setAthleteResultDoubleWithMins("1:01.12"), 0.001);
		assertEquals(17.1, supporter.setAthleteResultDoubleWithMins("17.1"), 0.001);
	}
	
	
}
