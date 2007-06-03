package net.azib.java.students.t060401.homework.test;

import net.azib.java.students.t060401.homework.decathlon.Athlete;
import net.azib.java.students.t060401.homework.util.Utils;

import static org.junit.Assert.fail;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

/**
 * AthletesTest
 * 
 * @author t060401
 */
public class AthletesTest {

	Athlete athlete;

	@Before
	public void createAthlete() {
		athlete = new Athlete();
	}

	@Test
	public void testValidateName() throws Exception {
		try {
			athlete.setName("Tina2");
			fail("Numbers should not be accepted in athlete name");
		} catch (IllegalArgumentException e){
			//expected
		}
		try {
			athlete.setName("Tina");
		} catch (IllegalArgumentException e){
			fail("Letters should be accepted in athlete's name");
		}
	}

	@Test
	public void testValidateBirthDate() throws Exception {

		try {
			athlete.setBirthTime("02.04.1983");
		} catch (IllegalArgumentException e){
			fail("02.04.1983 should be accepted as valid date");
		}
		try {
			athlete.setBirthTime("02.22.1983");
			fail("Date with illegal month should not be valid");
		} catch (IllegalArgumentException e){
			//expected
		}
		try {
			athlete.setBirthTime("tt.04.1983");
			fail("Date containing characters should not be accepted as valid date");
		} catch (IllegalArgumentException e){
			//excpected
		}

		Calendar date = Calendar.getInstance();
		date.add(Calendar.YEAR, 2);
		
		try {
			String dateInFuture = Utils.getDateAsString(date);
			athlete.setBirthTime(dateInFuture);
			fail("Date in future should not be valid");
		}
		catch (Exception e) {
			//expected
			System.out.println(e);
		}
	}
	
	@Test
	public void testValidateCountry() throws Exception {

		try {
			athlete.setCountry("aaa");
			fail("Country code should have 2 characters");
		} catch (IllegalArgumentException e){
			//excpected
		}
		try {
			athlete.setCountry("ET");
		} catch (IllegalArgumentException e){
			fail("'ET' should be valid country code");
		}
		try {
			athlete.setCountry("YY");
			fail("There should be no such country as 'YY'");
		} catch (IllegalArgumentException e){
			//excpected
		}
		try {
			athlete.setCountry(null);
			fail("Country code should not be empty");
		} catch (IllegalArgumentException e){
			//excpected
		}
	}
}
