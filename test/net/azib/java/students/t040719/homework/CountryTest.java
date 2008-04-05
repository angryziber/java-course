package net.azib.java.students.t040719.homework;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * CountryTest
 *
 * @author romi
 */
public class CountryTest {
	
	@Test
	public void getCountryNameFails() {
		assertEquals("", ISOCountry.getCountryName("XX"));
	}
	
	@Test
	public void getCountryNameSucceeds() {
		assertEquals("SPAIN", ISOCountry.getCountryName("ES"));
	}
	
	@Test
	public void isValidCountryFails() {
		assertEquals(false, ISOCountry.isValidCountryCode("XX"));
	}
	
	@Test
	public void isValidCountrySucceeds() {
		assertEquals(true, ISOCountry.isValidCountryCode("US"));
	}
	
	
}
