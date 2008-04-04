package net.azib.java.students.t040719.homework;

import static org.junit.Assert.*;
//import static org.easymock.EasyMock.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.jdom.JDOMException;
import org.junit.Test;

/**
 * AthleteTest
 *
 * @author romi
 */
public class AthleteTest {

	@Test
	public void testGetName() throws JDOMException, IOException {
		Athlete ath = new Athlete("Suzi Quattro", "29.02.2008", "EE", null);
		assertEquals("Suzi Quattro", ath.getName());
	}

	@Test
	public void testGetCountryCode() throws JDOMException, IOException {
		Athlete ath = new Athlete("s s", "29.02.2008", "EE", null);
		assertEquals("EE", ath.getCountryCode());
	}

	@Test
	public void testGetCountryName() throws JDOMException, IOException {
		Athlete ath = new Athlete("s s", "29.02.2008", "EE", null);
		assertEquals("ESTONIA", ath.getCountryName());
	}
	
	@Test
	public void testGetBirtdayString() throws JDOMException, IOException, ParseException {
		Date d = new SimpleDateFormat("dd.MM.yyyy").parse("29.02.2008");
		Athlete ath = new Athlete("s s", "29.02.2008", "EE", null);
		assertEquals(DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale(System.getProperty("user.language"))).format(d), ath.getBirthdayString());
	}
	
	@Test
	public void testGetBirtday() throws JDOMException, IOException, ParseException {
		Date d = new SimpleDateFormat("dd.MM.yyyy").parse("29.02.2008");
		Athlete ath = new Athlete("s s", "29.02.2008", "EE", null);
		assertEquals(d, ath.getBirthday());
	}
	
	@Test
	public void isValidNameFails() throws JDOMException, IOException {
		assertEquals(false, Athlete.isValidName("ss"));
	}
	
	@Test
	public void isValidNameSucceeds() throws JDOMException, IOException {
		assertEquals(true, Athlete.isValidName("s s"));
	}
}
