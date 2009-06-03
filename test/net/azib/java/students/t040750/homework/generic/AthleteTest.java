package net.azib.java.students.t040750.homework.generic;

import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.junit.Test;

public class AthleteTest {

	/**
	 * Test the constructor with preset values
	 * @throws Exception
	 */
	@Test
	public void testConstructor() throws Exception {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		Athlete athlete = new Athlete("Erki Nool",
				new java.sql.Date(df.parse("1970-06-25").getTime()), "EE");
		
		assertEquals("Erki Nool", athlete.name);
		assertEquals("1970-06-25", athlete.birthday.toString());
		assertEquals("EE", athlete.nationality);
	}
	
	/**
	 * Test the overridden toString method and the default constructor.
	 * @throws Exception
	 */
	@Test
	public void testToString() throws Exception {
		Athlete athlete = new Athlete();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		assertEquals(null, athlete.getName());
		assertEquals(null, athlete.getBirthday());
		assertEquals(null, athlete.getNationality());
		
		athlete.setName("Василий Пупкин");
		athlete.setBirthday(new java.sql.Date(df.parse("1980-10-21").getTime()));
		athlete.setNationality("UA");
		
		assertEquals("Василий Пупкин", athlete.toString());
		assertEquals("1980-10-21", athlete.getBirthday().toString());
		assertEquals("UA", athlete.getNationality());
	}
}
