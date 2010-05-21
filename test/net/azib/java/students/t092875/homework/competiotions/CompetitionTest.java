package net.azib.java.students.t092875.homework.competiotions;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * CompetitionTest
 *
 * @author Mihhail
 */
public class CompetitionTest {
	@Test
	public void testIsWithMinutes(){
		assertTrue(Competiotion.SPRINT_100M.isWithMinutes("5:28.10"));
		assertFalse(Competiotion.SPRINT_100M.isWithMinutes("28.10"));
	}
	
	@Test
	public void testEventResult(){
		assertEquals(1042, Competiotion.SPRINT_100M.points("10.22"));
		assertEquals(1312, Competiotion.LONG_JUMP.points("8.95"));
		assertEquals(1295, Competiotion.SHOT_PUT.points("23.12"));
		assertEquals(1244, Competiotion.HIGH_JUMP.points("2.45"));
		assertEquals(1156, Competiotion.SPRINT_400M.points("43.18"));
		assertEquals(1044, Competiotion.HURDLES_110M.points("13.47"));
		assertEquals(993,  Competiotion.DISCUS_THROW.points("55.87"));
		assertEquals(1152, Competiotion.POLE_VAULT.points("5.76"));
		assertEquals(1040, Competiotion.JAVELIN_THROW.points("79.80"));
		assertEquals(963,  Competiotion.RACE_1500M.points("3:58.70"));
	}
}
