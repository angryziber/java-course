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
	private float[] eventResults = new float[10]; //{"12.61","5.00","9.22","1.50","59.39","16.43","21.60","2.60","35.81","5:25.72"};
	private Date date; 
	
	@Test
	public void testGetName() {
		Athlete ath = new Athlete("Suzi Quattro", date, "EE", eventResults);
		assertEquals("Suzi Quattro", ath.getName());
	}

	@Test
	public void testGetCountryCode() {
		Athlete ath = new Athlete("s s", date, "EE", eventResults);
		assertEquals("EE", ath.getCountryCode());
	}

	@Test
	public void testGetCountryName() {
		Athlete ath = new Athlete("s s", date, "EE", eventResults);
		assertEquals("ESTONIA", ath.getCountryName());
	}
	
	@Test
	public void testGetBirtdayString() throws  ParseException {
		Date d = new SimpleDateFormat("dd.MM.yyyy").parse("29.02.2008");
		date = new SimpleDateFormat("dd.MM.yyyy").parse("29.02.2008");
		Athlete ath = new Athlete("s s", date, "EE", eventResults);
		assertEquals(DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale(System.getProperty("user.language"))).format(d), ath.getBirthdayString());
	}
	
	@Test
	public void testGetBirtday() throws ParseException {
		Date d = new SimpleDateFormat("dd.MM.yyyy").parse("29.02.2008");
		Athlete ath = new Athlete("s s", d, "EE", eventResults);
		assertEquals(d, ath.getBirthday());
	}
	
		
	@Test
	public void wrongNumberOfParameters() {
		try {
			new Athlete("s s", date, "EE", new float[5]);
			assertTrue(false);
		}
		catch(IllegalArgumentException e){
			assertTrue(true);
		}
	}
	
	@Test
	public void testGetDecathlonPoints() throws  ParseException {
		float[] realResults = {12.61f,5.00f,9.22f,1.50f,59.39f,16.43f,21.60f,2.60f,35.81f,325.72f};
		Athlete ath = new Athlete("s s", date, "EE", realResults);
		assertEquals(4234, ath.getDecathlonPoints());
	}
}
