package net.azib.java.students.t060401.homework;

import net.azib.java.students.t060401.homework.decathlon.DecathlonEvent;
import net.azib.java.students.t060401.homework.decathlon.DecathlonEventEnum;
import net.azib.java.students.t060401.homework.decathlon.FieldEvent;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * FieldEventTest
 *
 * @author Astrid Pärn
 */
public class FieldEventTest {

	DecathlonEvent event;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		event = new FieldEvent(DecathlonEventEnum.DISCUS_THROW);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link net.azib.java.students.t060401.homework.decathlon.FieldEvent#getPoints()}.
	 */
	@Test
	public void testGetPoints() {
		event.setPerformance("0");
		assertEquals(0, event.getPoints());
		event.setPerformance("18");
		assertEquals(235, event.getPoints());
	}

	/**
	 * Test method for {@link net.azib.java.students.t060401.homework.decathlon.FieldEvent#setPerformance(double)}.
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
	 * Test method for {@link net.azib.java.students.t060401.homework.decathlon.FieldEvent#setPerformance(java.lang.String)}.
	 */
	@Test
	public void testSetPerformanceString() {
		String testValue = "12.40";
		try {
			event.setPerformance(testValue);
		} catch (IllegalArgumentException e) {
			fail("Should not get exception with performance string "+testValue);
		}
		testValue = "12.404563";
		try {
			event.setPerformance(testValue);
		} catch (IllegalArgumentException e) {
			fail("Should not get exception with performance string "+testValue);
		}
		testValue = "12:40.12";
		try {
			event.setPerformance("12:40.12");
			System.out.println("fail "+event.toString());
			fail("Should fail with performance string 12:40.12");
		} catch (IllegalArgumentException e) {
			// expected
		}
		testValue = null;
		try {
			event.setPerformance(testValue);
			fail("Should fail with empty performance string ");
		} catch (IllegalArgumentException e) {
			//expected
		}
		testValue = "";
		try {
			event.setPerformance("");
			fail("Should fail with empty performance string");
		} catch (IllegalArgumentException e) {
			//expected
		}
		testValue = "aa";
		try {
			event.setPerformance("aa");
			fail("Should fail with performance string "+testValue);
		} catch (IllegalArgumentException e) {
			//expected
		}
		testValue = "2.12.23";
		try {
			event.setPerformance("2.12.23");
			fail("Should fail with performance string "+testValue);
		} catch (IllegalArgumentException e) {
			//expected
		}
		testValue = "-2";
		try {
			event.setPerformance("-2");
			fail("Should fail with negative performance value "+testValue);
		} catch (IllegalArgumentException e) {
			//expected
		}
	}

	/**
	 * Test method for {@link net.azib.java.students.t060401.homework.decathlon.FieldEvent#toString()}.
	 */
	@Test
	public void testToString() {
		event.setPerformance("18");
		assertEquals("18.00", event.toString());
		event.setPerformance("18.45678");
		assertEquals("18.46", event.toString());
		event.setPerformance("18.45478");
		assertEquals("18.45", event.toString());
	}

}
