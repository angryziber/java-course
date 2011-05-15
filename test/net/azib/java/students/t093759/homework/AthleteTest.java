package net.azib.java.students.t093759.homework;

import org.junit.Test;

import java.util.*;

/**
 * @author dionis
 *         5/15/11 11:55 AM
 */
public class AthleteTest {
	@Test(expected = IllegalArgumentException.class)
	public void athleteNameShouldConsistOnlyFromCharacters() {
		new Athlete.Builder().name("Param Pam 123");
	}

	@Test
	public void goodNamesExamples() {
		String[] names = {"József Fenyő", "Василий Пупкин", "Mąrtęn Kołobrźeg", "José Mañana Perez"};
		for (String name : names) {
			new Athlete.Builder().name(name);
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void dateOfBirthShouldBeLessThanCurrentDate() {
		new Athlete.Builder().setDateOfBirth(Calendar.getInstance());
	}

	@Test
	public void peopleDoNotLiveMoreThan120Years() {
		Calendar dateInPast = Calendar.getInstance();
		dateInPast.add(Calendar.YEAR, -120);
		new Athlete.Builder().setDateOfBirth(dateInPast);
	}
	//	System.out.println(Arrays.asList(Locale.getISOCountries()));
}
