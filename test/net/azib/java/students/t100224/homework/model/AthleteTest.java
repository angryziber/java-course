package net.azib.java.students.t100224.homework.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AthleteTest {

	private Athlete athlete = new Athlete();

	@Test
	public void athleteHasAName() {
		athlete.setName("John");
		assertEquals("John", athlete.getName());
	}

	@Test
	public void athleteHasACountry() {
		athlete.setCountry("EE");
		assertEquals("EE", athlete.getCountry());
	}
}
