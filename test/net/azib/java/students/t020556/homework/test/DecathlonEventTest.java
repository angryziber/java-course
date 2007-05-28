package net.azib.java.students.t020556.homework.test;

import static org.junit.Assert.*;

import net.azib.java.students.t020556.homework.DecathlonEvent;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;


/**
 * DecathlonEventTest
 *
 * @author agu
 */
public class DecathlonEventTest {
	
	public DecathlonEvent runningEvent = DecathlonEvent.RACE_1500M;
	public DecathlonEvent fieldEvent = DecathlonEvent.DISCUS_THROW;
	
	/**
	 * Test method for 
	 * {@link net.azib.java.students.t020556.homework.DecathlonEvent#calculatePoints}.
	 */
	@Test
	public void testCalculateRunningPoints(){
		//prep
		DateFormat df = DateFormat.getDateInstance();
		Calendar cal = df.getCalendar();
		
		if(cal.get(Calendar.MINUTE) > 2)
			cal.set(Calendar.MINUTE, 2);
		
		Date now = cal.getTime();
		String timeShort = cal.get(Calendar.SECOND) + ".0";
		String timeLong = 
			cal.get(Calendar.MINUTE) + ":" + 
			cal.get(Calendar.SECOND) + "." + 
			cal.get(Calendar.MILLISECOND);
		
		//test
		assertTrue(
			runningEvent.calculatePoints("0:" + timeShort) == 
				runningEvent.calculatePoints(timeShort));
		assertTrue(
			runningEvent.calculatePoints(timeLong) == runningEvent.calculatePoints(now));
	}

	/**
	 * Test method for 
	 * {@link net.azib.java.students.t020556.homework.DecathlonEvent#calculatePoints}.
	 */
	@Test
	public void testCalculateFieldPoints(){
		assertTrue(
			fieldEvent.calculatePoints("53.45") == fieldEvent.calculatePoints(53.45));
		assertTrue(
			fieldEvent.calculatePoints("0007.3") == fieldEvent.calculatePoints(7.3));		
	}

	/**
	 * Test method for 
	 * {@link net.azib.java.students.t020556.homework.DecathlonEvent#getName}.
	 */
	@Test
	public void testName(){
		assertEquals(fieldEvent.getName(), "discus throw");
	}
}
