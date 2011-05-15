package net.azib.java.students.t104607.homework;

import org.junit.Test;
import java.text.DateFormat;

import static junit.framework.Assert.assertEquals;

/**
 * @author 104607 IASM
 */
public class AthleteTest {
	@Test
	public void testGetScore() throws Exception {
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
		Athlete athlete = new Athlete("I.Murumüts",dateFormat.parse("12/12/1968"),"XY",
				9.58, 8.95, 23.12, 2.45, 43.18, 12.87, 74.08, 6.14, 98.48, 206.0);
		assertEquals(12544, athlete.getScore());
	}
}
