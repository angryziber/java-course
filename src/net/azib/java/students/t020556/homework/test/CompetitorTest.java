package net.azib.java.students.t020556.homework.test;

import static org.junit.Assert.*;

import net.azib.java.students.t020556.homework.Competitor;
import net.azib.java.students.t020556.homework.DecathlonEvent;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.junit.Before;
import org.junit.Test;


/**
 * CompetitorTest
 *
 * @author agu
 */
public class CompetitorTest {
	
	private Competitor comp = new Competitor();
	
	/**
	 * Test method for 
	 * {@link net.azib.java.students.t020556.homework.Competitor#setDateOfBirth}.
	 */
	@Test
	public void testDateOfBirth() throws ParseException {
		DateFormat df = new SimpleDateFormat("mm.dd.yyyy");
		String dobFormatted = "01.01.1980";
		Date dob = df.parse(dobFormatted);
		
		comp.setDateOfBirth(dob);
		assertEquals(comp.getDateOfBirth(), dob);
		
		comp.setDateOfBirth(dobFormatted);
		assertEquals(comp.getDateOfBirth(), dob);
	}

	/**
	 * Test method for 
	 * {@link net.azib.java.students.t020556.homework.Competitor#setName}.
	 * {@link net.azib.java.students.t020556.homework.Competitor#getName}.
	 */
	@Test
	@Before
	public void testName() {
		String name = "Василий Пупкин";
		
		comp.setName(name);
		assertEquals(name, comp.getName());		
	}
	
	/**
	 * Test method for 
	 * {@link net.azib.java.students.t020556.homework.Competitor#setLocale}.
	 * {@link net.azib.java.students.t020556.homework.Competitor#getLocale}.
	 */
	@Test
	public void testLocale(){
		String locale = "ee";
		
		comp.setLocale(locale);
		
		assertNull(comp.getLocale());
		
		comp.setLocale(locale.toUpperCase());
		assertEquals(new Locale(locale), comp.getLocale());
	}
	
	/**
	 * Test method for 
	 * {@link net.azib.java.students.t020556.homework.Competitor#getFinalResult}.
	 * {@link net.azib.java.students.t020556.homework.Competitor#compareTo}.
	 */
	@Test
	public void testResult() throws Exception {
		comp.setResults(
			new String[]{
				"12.61", 
				"5.00", 
				"9.22", 
				"1.50",
				"59.39", 
				"16.43", 
				"21.60", 
				"2.60", 
				"35.81", 
				"5:25.72"});		
		
		assertTrue(comp.getFinalResult() > 1000);
		
		Competitor comp2 = new Competitor(comp.clone());
		comp.remove(DecathlonEvent.RACE_100M);
		
		assertTrue(comp.getFinalResult() == 0);
		assertTrue(comp.compareTo(comp2) < 0);
	}
}
