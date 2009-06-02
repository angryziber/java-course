package net.azib.java.students.t040729.homework;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * CountryTest
 * 
 * @author ValleTon
 */
public class CountryTest {

	@Test
	public void testToString() throws Exception {
		Country c = new Country("EE");
		assertEquals("EE",c.toString());
	}
	
	@Test
	public void testWrongCountryCode() {
		try {
			@SuppressWarnings("unused")
			Country c = new Country("heh");
			fail("Country code test failed.");
		}
		catch (Exception e) {
		}
	}
}
