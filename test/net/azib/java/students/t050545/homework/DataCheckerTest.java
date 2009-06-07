package net.azib.java.students.t050545.homework;

import static org.junit.Assert.assertEquals;

import net.azib.java.students.t050545.homework.utils.DataChecker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.junit.Test;

/**
 * DataCheckerTest
 *
 * @author libricon
 */
public class DataCheckerTest {
	
	@Test
	public void testIsValidDate() throws ParseException {
		assertEquals(DataChecker.isValidDate("29.03.1987", new SimpleDateFormat("dd.MM.yyyy")), true);
		assertEquals(DataChecker.isValidDate("29.02.1987", new SimpleDateFormat("dd.MM.yyyy")), false);
		assertEquals(DataChecker.isValidDate("29.13.1987", new SimpleDateFormat("dd.MM.yyyy")), false);
	}
	
	@Test
	public void testIsValidCountry() throws ParseException {
		assertEquals(true, DataChecker.isValidCountry("RU"));
		assertEquals(true, DataChecker.isValidCountry("En"));
		assertEquals(false, DataChecker.isValidCountry("3e"));
		assertEquals(true, DataChecker.isValidCountry("FR"));
	}
	
	@Test
	public void testParseBirthDay() throws ParseException{
		GregorianCalendar greg = new GregorianCalendar();
		greg.clear();
		greg.set(1987, 02, 29);
		assertEquals(DataChecker.toParseBirthDay("29.03.1987", new SimpleDateFormat("dd.MM.yyyy")).getTime(), greg.getTimeInMillis());
		greg.set(0000, 00, 01);
		assertEquals(DataChecker.toParseBirthDay("01.01.0000", new SimpleDateFormat("dd.MM.yyyy")).getTime(), greg.getTimeInMillis());
		
	}
	
	@Test
	public void testAddCountry(){
		assertEquals("RU", DataChecker.addCountry("RU"));
		assertEquals("EN", DataChecker.addCountry("En"));
		assertEquals("EE", DataChecker.addCountry("ee"));
	}

}
