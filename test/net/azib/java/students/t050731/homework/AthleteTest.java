package net.azib.java.students.t050731.homework;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

/**
 * AthleteTest
 * 
 * @author Raigo
 */
public class AthleteTest {
	@Test
	public void testAthlete()
	{
	Date date = Date.valueOf("2000-12-12");
	Athlete athlete = new Athlete("la cuccaracha", date, "EE", 12.2, 480, 10.14, 120, 68.44, 18.12, 30.1, 250, 33.33, 389.66,
			3499);
	
		assertEquals("la cuccaracha", athlete.getName());
		assertEquals(date, athlete.getDateOfBirth());
		assertEquals("EE", athlete.getCountry());
		assertEquals(12.2, athlete.getShortSprintResult(),0.01);
		assertEquals(4.8, athlete.getLongJumpResult(), 0.01);
		assertEquals(10.14, athlete.getShotPutResult(), 0.01);
		assertEquals(1.2, athlete.getHighJumpResult(), 0.01);
		assertEquals(68.44, athlete.getLongSprintResult(), 0.01);
		assertEquals(18.12, athlete.getHurdlesResult(), 0.01);
		assertEquals(30.1, athlete.getDiscusThrowResult(), 0.01);
		assertEquals(2.5, athlete.getPoleVaultResult(), 0.01);
		assertEquals(33.33, athlete.getJavelinThrowResult(), 0.01);
		assertEquals(389.66, athlete.getRaceResult(), 0.01);
		assertEquals(3499, athlete.getTotalScore(), 0.01);
	}
}
