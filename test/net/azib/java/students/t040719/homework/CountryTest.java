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
		assertEquals("", Country.getCountryName("XX"));
	}
	
	@Test
	public void getCountryNameSucceeds() {
		assertEquals("SPAIN", Country.getCountryName("ES"));
	}
	
	@Test
	public void isValidCountryFails() {
		assertEquals(false, Country.isValidCountryCode("XX"));
	}
	
	@Test
	public void isValidCountrySucceeds() {
		assertEquals(true, Country.isValidCountryCode("US"));
	}
	
}
