package net.azib.java.students.t960644.homework;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


/**
 * AthleteTest
 *
 * @author Lembit
 */
public class AthleteTest {
	@Test
	public void testBirthDate() throws Exception {
		Athlete athlete = new Athlete();
		athlete.setBirthDate("30.11.1940");
		assertTrue(athlete.getBirthDate().equals("30.11.1940"));
	}

}
