package net.azib.java.students.t020556.homework;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

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
	public void testEvents() throws Exception {
		for(DecathlonEvent.Field field : DecathlonEvent.Field.values()){
			comp.setEventResult(field, field.calculatePoints("100.4"));			
		}
		
		Map<DecathlonEvent.Field, Double> m = comp.getFieldEventMap();
		for(Map.Entry<DecathlonEvent.Field, Double> entry : m.entrySet()){
			assertNotNull(entry.getKey().getName());
			assertTrue(entry.getValue() > 0);
		}
	}
}
