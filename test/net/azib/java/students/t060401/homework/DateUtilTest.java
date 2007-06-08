package net.azib.java.students.t060401.homework;

import net.azib.java.students.t060401.homework.util.DateUtil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * DateUtilTest
 * 
 * @author Astrid Pärn
 */
public class DateUtilTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t060401.homework.util.DateUtil#getDate(java.lang.String)}.
	 */
	@Test
	public void testGetDate() {
		String dateString = "12.02.1983";
		try {
			Date date = DateUtil.getDate(dateString);
			assertEquals("Sat Feb 12 00:00:00 EET 1983", date.toString());
		}
		catch (IllegalArgumentException e) {
			fail("Should not get exception with date string "+dateString);
		}
		dateString = "42.02.1983";
		try {
			DateUtil.getDate(dateString);
			fail("Should get exception with illegal month value "+dateString);
		}
		catch (IllegalArgumentException e) {
			// expected
		}
		dateString = null;
		try {
			DateUtil.getDate(dateString);
			fail("Should get exception with empty date string");
		}
		catch (IllegalArgumentException e) {
			// expected
		}
		dateString = "";
		try {
			DateUtil.getDate(dateString);
			fail("Should get exception with empty date string");
		}
		catch (IllegalArgumentException e) {
			// expected
		}
		dateString = "aa";
		try {
			DateUtil.getDate(dateString);
			fail("Should not get exception with date string "+dateString);
		}
		catch (IllegalArgumentException e) {
			// expected
		}
		dateString = "12.02.83";
		try {
			Date date = DateUtil.getDate(dateString);
			assertEquals("Wed Feb 12 00:00:00 EET 83", date.toString());
		}
		catch (IllegalArgumentException e) {
			fail("Should not get exception with date string "+dateString);
		}
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t060401.homework.util.DateUtil#getDateAsString(java.util.Date)}.
	 */
	@Test
	public void testGetDateAsStringDate() {
		String dateString = "12.02.1983";
		Date date = DateUtil.getDate(dateString);
		String dateAsString = DateUtil.getDateAsString(date);
		assertEquals(dateString, dateAsString);
		
		dateString = "12.02.83";
		date = DateUtil.getDate(dateString);
		dateAsString = DateUtil.getDateAsString(date);
		assertEquals(dateString, "12.02.0083");
	}
}
