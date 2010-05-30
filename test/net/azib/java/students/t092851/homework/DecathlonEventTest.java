package net.azib.java.students.t092851.homework;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * DecathlonEventTest
 *
 * @author Lauri
 */
public class DecathlonEventTest {
	@Test
	public void testCalcPoints() {
		assertTrue(DecathlonEvent.EVENT_100_METERS.calcPoints(10.395)  == 1000);
		assertTrue(DecathlonEvent.EVENT_LONG_JUMP.calcPoints(7.76)     == 1000);
		assertTrue(DecathlonEvent.EVENT_SHOT_PUT.calcPoints(18.4)      == 1000);
		assertTrue(DecathlonEvent.EVENT_HIGH_JUMP.calcPoints(2.208)    == 1000);
		assertTrue(DecathlonEvent.EVENT_400_METERS.calcPoints(46.17)   == 1000);
		assertTrue(DecathlonEvent.EVENT_HURDLES.calcPoints(13.804)     == 1000);
		assertTrue(DecathlonEvent.EVENT_DISCUS.calcPoints(56.17)       == 1000);
		assertTrue(DecathlonEvent.EVENT_POLE_VAULT.calcPoints(5.287)   == 1000);
		assertTrue(DecathlonEvent.EVENT_JAVELIN.calcPoints(77.19)      == 1000);
		assertTrue(DecathlonEvent.EVENT_1500_METERS.calcPoints(233.79) == 1000);		
	}
	
	@Test
	public void testGetIndex() {
		int counter = 0;
		
		for (DecathlonEvent event : DecathlonEvent.values()) {
			assertTrue(event.getIndex() == counter);
			counter++;
		}
		assertTrue(DecathlonEvent.countEvents() == counter);
	}
	
	@Test
	public void testCountEvents() {
		// Decathlon has always 10 events
		assertTrue(DecathlonEvent.countEvents() == 10);
	}
}
