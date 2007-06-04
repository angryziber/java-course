package net.azib.java.students.t030656.homework;

import static org.junit.Assert.*;

import net.azib.java.students.t030656.homework.Event;

import org.junit.*;
/**
 * PoitsCalculatorTest
 *
 * @author Sprot
 */
public class EnumEventTest {

	/**
	 * tests event enum
	 */
	@Test
	public void testGetPoints() {
		assertEquals("Failed! RUN100", 789, Event.RUN100.getPoints(11.33));
		assertEquals("Failed! LONGJUMP", 0, Event.LONGJUMP.getPoints(7.18));
		assertEquals("Failed! SHOTPUT", 697, Event.SHOTPUT.getPoints(13.49));
		assertEquals("Failed! HIGHJUMP", 0, Event.HIGHJUMP.getPoints(11.33));
		assertEquals("Failed! RUN400", 4286, Event.RUN400.getPoints(1.94));
		assertEquals("Failed! RUNHURDLES", 829, Event.RUNHURDLES.getPoints(15.17));
		assertEquals("Failed! DISCUSTHROW", 741, Event.DISCUSTHROW.getPoints(43.76));
		assertEquals("Failed! POLEVAULT", 0, Event.POLEVAULT.getPoints(4.5));
		assertEquals("Failed! JAVELINTHROW", 750, Event.JAVELINTHROW.getPoints(60.84));
		assertEquals("Failed! RUN1500", 694, Event.RUN1500.getPoints(277.86));
	}
}
