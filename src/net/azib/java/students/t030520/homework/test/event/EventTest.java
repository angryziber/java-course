package net.azib.java.students.t030520.homework.test.event;

import net.azib.java.students.t030520.homework.event.FieldEvent;
import net.azib.java.students.t030520.homework.event.TrackEvent;

import junit.framework.Assert;

import org.junit.Test;

/**
 * The test class for testing functionality of the Event.
 *
 * @author t030520
 */
public class EventTest {

	/**
	 * Tests the calculation of points. 
	 */
	@Test
	public void testGetPoints() {
		Assert.assertEquals(1174, TrackEvent.SPRINT100.getPoints(9.69f));
		Assert.assertEquals(1312, FieldEvent.LONGJUMP.getPoints(895f));
		Assert.assertEquals(1295, FieldEvent.SHOTPUT.getPoints(23.12f));
		Assert.assertEquals(1244, FieldEvent.HIGHJUMP.getPoints(245f));
		Assert.assertEquals(1156, TrackEvent.SPRINT400.getPoints(43.18f));
		Assert.assertEquals(1126, TrackEvent.HURDLES110.getPoints(12.87f));
		Assert.assertEquals(1383, FieldEvent.DISCUSTHROW.getPoints(74.08f));
		Assert.assertEquals(1277, FieldEvent.POLEVAULT.getPoints(614f));
		Assert.assertEquals(1331, FieldEvent.JAVELINTHROW.getPoints(98.48f));
		Assert.assertEquals(1218, TrackEvent.RACE1500.getPoints(206f));
	}
}
