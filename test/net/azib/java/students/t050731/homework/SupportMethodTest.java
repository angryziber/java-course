package net.azib.java.students.t050731.homework;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Test;

/**
 * SupportMethodTest
 *
 * @author Raigo
 */
public class SupportMethodTest {
	
	HelperMethods sp = new HelperMethods();	
	@Test
	public void testMinutesToSeconds()
	{	
		assertEquals(220.2, sp.convertMinutesToSeconds("3:40.20"), 0.01);
		assertEquals(72, sp.convertMinutesToSeconds("1:12"), 0.01);
		assertEquals(13.1, sp.convertMinutesToSeconds("13.1"), 0.01);
	}
	
	@Test
	public void testSecodsToMinutes()
	{			
		assertEquals("3:40.20", sp.convertSecondsToMinutes(220.2));
		assertEquals("1:12.00", sp.convertSecondsToMinutes(72));
		assertEquals("13.10", sp.convertSecondsToMinutes(13.1));
	}
	
	@Test
	public void testFormatDBDate()
	{
		Date date = Date.valueOf("1994-03-04");
		assertEquals("04.03.1994", sp.formatDate(date));
		date = Date.valueOf("2000-01-01");
		assertEquals("01.01.2000", sp.formatDate(date));
	}
	
	@Test
	public void testVerifyName()
	{
		assertEquals("el pedro la bueno pomm", sp.verifyName("el pedro la bueno pomm"));
		assertEquals("el fahir king of all 9 states.", sp.verifyName("el fahir king of all 9 states."));
		assertEquals("", sp.verifyName(""));
	}
	
	@Test
	public void testCountryCode()
	{
		assertEquals(true, sp.verifyCountryCode("ee"));
		assertEquals(true, sp.verifyCountryCode("EE"));
		assertEquals(false, sp.verifyCountryCode("123"));
	}
}
