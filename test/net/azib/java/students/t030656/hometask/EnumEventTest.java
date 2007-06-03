package net.azib.java.students.t030656.hometask;

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
		assertEquals("Failed! RUN100", 312, Event.RUN100.getPoints(14));
		assertEquals("Failed! LONGJUMP", 1061, Event.LONGJUMP.getPoints(8.00));
		assertEquals("Failed! SHOTPUT", 6367, Event.SHOTPUT.getPoints(100));
		assertEquals("Failed! HIGHJUMP", 4570, Event.HIGHJUMP.getPoints(5.00));
		assertEquals("Failed! RUN400", 3537, Event.RUN400.getPoints(10));
		assertEquals("Failed! RUNHURDLES", 1556, Event.RUNHURDLES.getPoints(10));
		assertEquals("Failed! DISCUSTHROW", 1295, Event.DISCUSTHROW.getPoints(70));
		assertEquals("Failed! POLEVAULT", 1574, Event.POLEVAULT.getPoints(7.00));
		assertEquals("Failed! JAVELINTHROW", 1355, Event.JAVELINTHROW.getPoints(100));
		assertEquals("Failed! RUN1500", 1440, Event.RUN1500.getPoints(180.11));
	}
}
