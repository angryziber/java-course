package net.azib.java.students.t030632.homework.test;

import static org.junit.Assert.*;

import org.junit.Test;

import net.azib.java.students.t030632.homework.Competitor;

/**
 * CompetitorTest
 *
 * @author Toni
 */
public class CompetitorTest {
@Test
	public void testCompetitor() throws Exception {
		String data = "\"Siim Susi\",01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:22.72";
		Competitor champ = new Competitor(data);
		assertEquals(4254, champ.getPoints());
	}
}
