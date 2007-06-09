package net.azib.java.students.t030726.homework.unittests;

import net.azib.java.students.t030726.homework.decathlon.FieldDecathlonEvent;
import net.azib.java.students.t030726.homework.decathlon.JavelinThrowEvent;

import junit.framework.TestCase;

/**
 * JavelinThrowEventTest
 *
 * @author Deniss Nikiforov
 */
public class JavelinThrowEventTest extends TestCase {
	private final double aParameter = 10.14;
	private final double bParameter = 7.0;
	private final double cParameter = 1.08;
	private final double result = 15.156;
	private JavelinThrowEvent fixture = null;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		this.fixture = new JavelinThrowEvent(this.result);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		this.fixture = null;
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.JavelinThrowEvent#JavelinThrowEvent(double)}.
	 */
	public void testJavelinThrowEvent() {
		FieldDecathlonEvent sample = null;
		try {
			sample = new FieldDecathlonEvent(this.result, this.aParameter, this.bParameter, this.cParameter);
		}
		catch (Exception e) {
			fail("Correct parameters should not cause any exceptions");
		}
		assert(sample instanceof FieldDecathlonEvent);
		int expectedResult = sample.getPoints();
		int gotResult = this.fixture.getPoints();
		assertEquals(expectedResult, gotResult);
	}

}
