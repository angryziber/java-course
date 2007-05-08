package net.azib.java.students.t020556.homework;

import static org.junit.Assert.*;

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

	@Test
	@Before
	public void testName() {
		String name = "Василий Пупкин";
		
		comp.setName(name);
		assertEquals(name, comp.getName());		
	}
	
	@Test
	public void testLocale(){
		String locale = "ee";
		
		comp.setLocale(locale);
		
		assertNull(comp.getLocale());
		
		comp.setLocale(locale.toUpperCase());
		assertEquals(new Locale(locale), comp.getLocale());
	}
	
	@Test
	public void testResultValid() throws Exception {
		for(DecathlonEvent field : DecathlonEvent.values())
			comp.put(field, field.calculatePoints("10.4"));			
		
		assertTrue(comp.getFinalResult() > 1000);
		
		Competitor comp2 = new Competitor(comp.clone());
		comp.remove(DecathlonEvent.A_100_M);
		
		assertTrue(comp.getFinalResult() == 0);
		assertTrue(comp.compareTo(comp2) < 0);
	}
}
