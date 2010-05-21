package net.azib.java.students.t093052.homework;

import static org.junit.Assert.*;

import org.junit.Test;

import static net.azib.java.students.t093052.homework.CompetitionType.RACE_1500M;
import static net.azib.java.students.t093052.homework.CompetitionType.HIGH_JUMP;
import static net.azib.java.students.t093052.homework.CompetitionType.SPRINT_100M;

public class CompetitionTypeTest {
	@Test
	public void calculatePoints() throws Exception {
		assertEquals(1202, SPRINT_100M.calculatePoints("9.58"));
		assertEquals("sprint100m", SPRINT_100M.getName());
		
		assertEquals(95, RACE_1500M.calculatePoints("6:50.76"));
		assertEquals("race1500m", RACE_1500M.getName());
		
		assertEquals(12908, HIGH_JUMP.calculatePoints("9.58"));
		assertEquals("highJump", HIGH_JUMP.getName());
	}
}
