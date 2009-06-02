package net.azib.java.students.t090437.homework.test;

import net.azib.java.students.t090437.homework.BadDataFormatException;
import net.azib.java.students.t090437.homework.TimeResult;

import org.junit.*;



/**
 * MyTimeClassTest
 *
 * @author Ronald
 */
public class MyTimeClassTest {
	@Test
	public void testIfObjectFromDoubleIsGreatedCorrectly() {
		TimeResult timeObj = TimeResult.createObj(99.99);
		String timeStr = timeObj.toString();
		Assert.assertTrue(timeStr.equals("1:39.99"));
	}
	@Test
	public void testIfParsesSecondsCorrectly() {
		try {
			Assert.assertTrue(equateDoubles(TimeResult.createObj("5.01").getSec(), 5.01, 0.001));
		}
		catch (BadDataFormatException e) {
			Assert.assertTrue(false);
		}		
	}
	
	@Test
	public void testIfParsesSecondsAndMinutesCorrectly() {
		try {
			Assert.assertTrue(equateDoubles(TimeResult.createObj("10:2.0").getSec(), 602.0, 0.091));
		}
		catch (BadDataFormatException e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test
	public void testIfBadFormatIsDetected() {
		try {
			TimeResult.createObj("10,2");
		}
		catch (BadDataFormatException e) {
			return;
		}
		Assert.assertTrue(false);
	}
	
	private boolean equateDoubles(double a, double b, double acc) {
		if(a < b + acc && a > b - acc) {
			return true;
		} else {
			return false;
		}
	}
}
