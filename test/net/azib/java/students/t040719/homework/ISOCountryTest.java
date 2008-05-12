package net.azib.java.students.t040719.homework;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * ISOCountryTest
 *
 * @author romi
 */
public class ISOCountryTest {
	
	@Test
	public void isValidCountryCodeFails(){
		assertEquals(false, ISOCountry.isValidCountryCode("EN"));
	}
	
	@Test
	public void isValidCountryCodeSucceeds(){
		assertEquals(true, ISOCountry.isValidCountryCode("ET"));
	}

	@Test
	public void getCountryNameFails(){
		assertEquals("", ISOCountry.getCountryName("EN"));
	}
	
	@Test
	public void getCountryNameSucceeds(){
		assertEquals("ESTONIA", ISOCountry.getCountryName("EE"));
	}
}
