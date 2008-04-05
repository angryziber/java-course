package net.azib.java.students.t040719.homework;

import static org.junit.Assert.*;
//import static org.easymock.EasyMock.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;

/**
 * AthleteTest
 *
 * @author romi
 */
public class AthleteTest {
	private String[] testData = {"12.61","5.00","9.22","1.50","59.39","16.43","21.60","2.60","35.81","5:25.72"}; 
	
	@Test
	public void testGetName() {
		Athlete ath = new Athlete("Suzi Quattro", "29.02.2008", "EE", testData);
		assertEquals("Suzi Quattro", ath.getName());
	}

	@Test
	public void testGetCountryCode() {
		Athlete ath = new Athlete("s s", "29.02.2008", "EE", testData);
		assertEquals("EE", ath.getCountryCode());
	}

	@Test
	public void testGetCountryName() {
		Athlete ath = new Athlete("s s", "29.02.2008", "EE", testData);
		assertEquals("ESTONIA", ath.getCountryName());
	}
	
	@Test
	public void testGetBirtdayString() throws  ParseException {
		Date d = new SimpleDateFormat("dd.MM.yyyy").parse("29.02.2008");
		Athlete ath = new Athlete("s s", "29.02.2008", "EE", testData);
		assertEquals(DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale(System.getProperty("user.language"))).format(d), ath.getBirthdayString());
	}
	
	@Test
	public void testGetBirtday() throws ParseException {
		Date d = new SimpleDateFormat("dd.MM.yyyy").parse("29.02.2008");
		Athlete ath = new Athlete("s s", "29.02.2008", "EE", testData);
		assertEquals(d, ath.getBirthday());
	}
	
	@Test
	public void isValidNameFails(){
		assertEquals(false, Athlete.isValidName("ss"));
	}
	
	@Test
	public void isValidNameSucceeds() {
		assertEquals(true, Athlete.isValidName("s s"));
	}
	
	@Test
	public void wrongNumberOfParameters() {
		try {
			new Athlete("s s", "29.02.2008", "EE", new String[5]);
			assertTrue(false);
		}
		catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}
	
	@Test
	public void testGetDecathlonPoints() throws  ParseException {
		Athlete ath = new Athlete("s s", "29.02.2008", "EE", testData);
		assertEquals(4234, ath.getDecathlonPoints());
	}
}
