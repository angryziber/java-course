package net.azib.java.students.t020556.homework;

import static org.junit.Assert.*;

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
	
	public DecathlonEvent runningEvent = DecathlonEvent.A_1500_M;
	public DecathlonEvent fieldEvent = DecathlonEvent.DISCUS_THROW;
	
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
			runningEvent.calculatePoints("0:" + timeShort) == runningEvent.calculatePoints(timeShort));
		assertTrue(
			runningEvent.calculatePoints(timeLong) == runningEvent.calculatePoints(now));
		assertEquals(runningEvent.getName(), "1500m race");
	}

	@Test
	public void testCalculateFieldPoints(){
		assertTrue(
			fieldEvent.calculatePoints("53.45") == fieldEvent.calculatePoints(53.45));
		assertTrue(
			fieldEvent.calculatePoints("0007.3") == fieldEvent.calculatePoints(7.3));		
	}

	@Test
	public void testName(){
		assertEquals(fieldEvent.getName(), "discus throw");
	}
}
