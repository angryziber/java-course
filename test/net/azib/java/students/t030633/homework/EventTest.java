package net.azib.java.students.t030633.homework;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * EventTest
 * 
 * @author t030633
 */
public class EventTest {

	/**
	 * Test methods for
	 * {@link net.azib.java.students.t030633.homework.Event}.
	 */
	@Test 
	public void thereAre10Events() {
		assertTrue(Event.values().length == 10);
	}
	@Test 
	public void eventsAreCorrect() {
		assertNotNull(Event.valueOf(Event.class, "M100"));
		assertNotNull(Event.valueOf(Event.class, "LONG"));
		assertNotNull(Event.valueOf(Event.class, "SHOT"));
		assertNotNull(Event.valueOf(Event.class, "HIGH"));
		assertNotNull(Event.valueOf(Event.class, "M400"));
		assertNotNull(Event.valueOf(Event.class, "HURDLES"));
		assertNotNull(Event.valueOf(Event.class, "DISCUS"));
		assertNotNull(Event.valueOf(Event.class, "POLE"));
		assertNotNull(Event.valueOf(Event.class, "JAVELIN"));
		assertNotNull(Event.valueOf(Event.class, "M1500"));
	}

	/**
	 * Test methods for
	 * {@link net.azib.java.students.t030633.homework.Event#points(double)}.
	 */
	@Test
	public void calculateZeroPoints() {
		for (Event e : Event.values())
			assertEquals(0, e.points(0D));
	}

	@Test
	public void calculatePointsForJavelin() {
		Event e = Event.JAVELIN;
		assertEquals(35, e.points(10.21D));
	}

	@Test
	public void calculatePointsForHurdles() {
		Event e = Event.HURDLES;
		assertEquals(960, e.points(14.11D));
	}

	@Test
	public void calculatePointsForShotPut() {
		Event e = Event.SHOT;
		assertEquals(384, e.points(8.3D));
	}

}
