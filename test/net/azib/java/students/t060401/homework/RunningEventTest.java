package net.azib.java.students.t060401.homework;

import static org.junit.Assert.*;

import net.azib.java.students.t060401.homework.decathlon.DecathlonEvent;
import net.azib.java.students.t060401.homework.decathlon.DecathlonEventEnum;
import net.azib.java.students.t060401.homework.decathlon.RunningEvent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * RunningEventTest
 *
 * @author Astrid Pärn
 */
public class RunningEventTest {

	DecathlonEvent event;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		event = new RunningEvent(DecathlonEventEnum.HURDLES_110M);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link net.azib.java.students.t060401.homework.decathlon.RunningEvent#getPoints()}.
	 */
	@Test
	public void testGetPoints() {
		event.setPerformance("0");
		assertEquals(0, event.getPoints());
		event.setPerformance("18");
		assertEquals(524, event.getPoints());
	}
	
	/**
	 * Test method for {@link net.azib.java.students.t060401.homework.decathlon.RunningEvent#toString()}.
	 */
	@Test
	public void testToString() {
		event.setPerformance("12:4.10");
		assertEquals("12:04.10", event.toString());
		event.setPerformance("0:4.10");
		assertEquals("04.10", event.toString());
		event.setPerformance("18");
		assertEquals("18.00", event.toString());
		event.setPerformance("18.45678");
		assertEquals("18.46", event.toString());
		event.setPerformance("18.45478");
		assertEquals("18.45", event.toString());
	}


	/**
	 * Test method for {@link net.azib.java.students.t060401.homework.decathlon.RunningEvent#setPerformance(double)}.
	 */
	@Test
	public void testSetPerformanceDouble() {
		try {
			event.setPerformance(-2);
			fail("Should fail with negative performance value: -2");
		} catch (IllegalArgumentException e) {
			//expected
		}
		try {
			event.setPerformance(2);
		} catch (IllegalArgumentException e) {
			fail("Should not get exception with performance value 2");
		}
	}

	/**
	 * Test method for {@link net.azib.java.students.t060401.homework.decathlon.RunningEvent#setPerformance(java.lang.String)}.
	 */
	@Test
	public void testSetPerformanceString() {
		try {
			event.setPerformance("12.40");
		} catch (IllegalArgumentException e) {
			fail("Should not get exception with performance string 12.40");
		}
		try {
			event.setPerformance("12:40.12");
			
		} catch (IllegalArgumentException e) {
			fail("Should not get exception with performance string: 12:40.12");
		}
		try {
			event.setPerformance(null);
			fail("Should fail with empty performance string");
		} catch (IllegalArgumentException e) {
			//expected
		}
		try {
			event.setPerformance("");
			fail("Should fail with empty performance string");
		} catch (IllegalArgumentException e) {
			//expected
		}
		try {
			event.setPerformance("aa");
			fail("Should fail with performance string 'aa'");
		} catch (IllegalArgumentException e) {
			//expected
		}
		try {
			event.setPerformance("2.12.23");
			fail("Should fail with performance string 2.12.23");
		} catch (IllegalArgumentException e) {
			//expected
		}
		try {
			event.setPerformance("-2");
			fail("Should fail with negative performance value: -2");
		} catch (IllegalArgumentException e) {
			//expected
		}
	}
}
