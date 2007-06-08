package net.azib.java.students.t060401.homework;

import net.azib.java.students.t060401.homework.decathlon.DecathlonEvent;
import net.azib.java.students.t060401.homework.decathlon.DecathlonEventEnum;
import net.azib.java.students.t060401.homework.decathlon.DecathlonResults;
import net.azib.java.students.t060401.homework.decathlon.FieldEvent;
import net.azib.java.students.t060401.homework.decathlon.RunningEvent;

import junit.framework.TestCase;

/**
 * DecathlonResultsTest
 *
 * @author Astrid Pärn
 */
public class DecathlonResultsTest extends TestCase {

	DecathlonResults results;
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		results = new DecathlonResults();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link net.azib.java.students.t060401.homework.decathlon.DecathlonResults#put(net.azib.java.students.t060401.homework.decathlon.DecathlonEvent)}.
	 */
	public void testPutDecathlonEvent() {
		DecathlonEventEnum key = DecathlonEventEnum.HURDLES_110M;
		DecathlonEvent event = new RunningEvent(key, "48.04");
		results.put(event);
		assertTrue(results.containsKey(key));
	}

	/**
	 * Test method for {@link net.azib.java.students.t060401.homework.decathlon.DecathlonResults#put(net.azib.java.students.t060401.homework.decathlon.DecathlonEventEnum, net.azib.java.students.t060401.homework.decathlon.DecathlonEvent)}.
	 */
	public void testPutDecathlonEventEnumDecathlonEvent() {
		DecathlonEventEnum key = DecathlonEventEnum.SPRINT_100M;
		DecathlonEvent event = new RunningEvent(key, "8.04");
		results.put(key, event);
		assertTrue(results.containsKey(key));
		
		DecathlonEventEnum key2 = DecathlonEventEnum.HIGH_JUMP;
		results.put(key2, event);
		assertTrue("Map should not contain event with different type key", !results.containsKey(key2));
	}

	/**
	 * Test method for {@link net.azib.java.students.t060401.homework.decathlon.DecathlonResults#isComplete()}.
	 */
	public void testIsComplete() {
		DecathlonEventEnum[] eventTypes = DecathlonEventEnum.values();
		for (int i = 0; i < eventTypes.length; i++) {
			assertFalse(results.isComplete());
			DecathlonEvent event = new RunningEvent(eventTypes[i], "8");
			results.put(event);
		}
		assertTrue(results.isComplete());
	}

	/**
	 * Test method for {@link net.azib.java.students.t060401.homework.decathlon.DecathlonResults#getPoints()}.
	 */
	public void testGetPoints() {
		DecathlonEvent event = new RunningEvent(DecathlonEventEnum.SPRINT_100M, "9.22");
		results.put(event);
		DecathlonEvent event1 = new FieldEvent(DecathlonEventEnum.HIGH_JUMP, "2.18");
		results.put(event1);
		assertEquals(2270,results.getPoints());
	}

	/**
	 * Test method for {@link net.azib.java.students.t060401.homework.decathlon.DecathlonResults#getResultsVector()}.
	 */
	public void testGetResultsVector() {
		DecathlonEventEnum[] eventTypes = DecathlonEventEnum.values();
		for (int i = 0; i < eventTypes.length; i++) {
			DecathlonEvent event = new RunningEvent(eventTypes[i], i+1);
			results.put(event);
		}
		String expected = "[01.00, 02.00, 03.00, 04.00, 05.00, 06.00, 07.00, 08.00, 09.00, 10.00]";
		String actual = results.getResultsVector().toString();
		assertEquals(expected, actual);
		
	}

}
