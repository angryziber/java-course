package net.azib.java.students.t092855.homework;

import org.junit.Test;

import java.text.DateFormat;
import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * AthleteTest
 * Unit tests for {@link net.azib.java.students.t092855.homework.Athlete}
 *
 * @author t092855
 */
public class AthleteTest {
	private final Athlete athlete = new Athlete();

	/**
	 * Unit test for {@link net.azib.java.students.t092855.homework.Athlete#setName(String)}
	 */
	@Test
	public void namesAreCorrect() {
		assertTrue(athlete.setName("Siim Piim"));
		assertTrue(athlete.setName("Karl Filipp Tamm"));
		assertTrue(athlete.setName("Karl-Filipp Tamme-Tõru"));
		assertTrue(athlete.setName("Jamie O'Connell"));
		assertTrue(athlete.setName("József Fenyő"));
		assertTrue(athlete.setName("Василий Пупкин"));
		assertTrue(athlete.setName("José Maria  González Desperado"));
		assertTrue(athlete.setName("Mąrtęn Kołobrźeg"));
		assertTrue(athlete.setName("Janis Litoměřice"));
		assertTrue(athlete.setName("Marat Zuckermann"));
		assertTrue(athlete.setName("Munehiro Kaneko"));
		assertTrue(athlete.setName("Mumbalele-Nsowu Mensah-Bonsu Pops"));
		assertTrue(athlete.setName("Maria von Schanbacher"));
	}

	/**
	 * Unit test for {@link net.azib.java.students.t092855.homework.Athlete#setName(String)}
	 */
	@Test
	public void namesAreIncorrect() {
		assertFalse(athlete.setName("siim piim"));
		assertFalse(athlete.setName("Siim"));
		assertFalse(athlete.setName("Piim"));
		assertFalse(athlete.setName("Karl Filipp Tamm6"));
		assertFalse(athlete.setName("Karl Filipp@Tamm"));
		assertFalse(athlete.setName(""));
	}

	/**
	 * Unit test for {@link net.azib.java.students.t092855.homework.Athlete#setCountry(String)}
	 */
	@Test
	public void countryIsCorrect() {
		assertTrue(athlete.setCountry("EE"));
		assertTrue(athlete.setCountry("IL"));
		assertTrue(athlete.setCountry("JP"));
		assertTrue(athlete.setCountry("ES"));
		assertTrue(athlete.setCountry("HU"));
	}

	/**
	 * Unit test for {@link net.azib.java.students.t092855.homework.Athlete#setCountry(String)}
	 */
	@Test
	public void countryIsIncorrect() {
		assertFalse(athlete.setCountry("E"));
		assertFalse(athlete.setCountry("Ee"));
		assertFalse(athlete.setCountry("EEE"));
		assertFalse(athlete.setCountry(""));
		assertFalse(athlete.setCountry("ee5"));
	}

	/**
	 * Unit test for {@link net.azib.java.students.t092855.homework.Athlete#setBirthday(String)}
	 */
	@Test
	public void dateIsCorrect() {
		assertTrue(athlete.setBirthday(DateFormat.getDateInstance(DateFormat.MEDIUM).format(new Date())));
		assertTrue(athlete.setBirthday("12.11.1967"));
	}

	/**
	 * Unit test for {@link net.azib.java.students.t092855.homework.Athlete#setBirthday(String)}
	 */
	@Test
	public void dateIsIncorrect() {
		assertFalse(athlete.setBirthday(DateFormat.getDateInstance(DateFormat.LONG).format(new Date())));
		assertFalse(athlete.setBirthday("12-11-89"));
	}
}
