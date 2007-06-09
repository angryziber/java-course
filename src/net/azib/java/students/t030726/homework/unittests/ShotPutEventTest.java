package net.azib.java.students.t030726.homework.unittests;

import net.azib.java.students.t030726.homework.decathlon.FieldDecathlonEvent;
import net.azib.java.students.t030726.homework.decathlon.ShotPutEvent;

import junit.framework.TestCase;

/**
 * ShotPutEventTest
 *
 * @author NTAdmin
 */
public class ShotPutEventTest extends TestCase {

	private final double aParameter = 51.39;
	private final double bParameter = 1.5;
	private final double cParameter = 1.05;
	private final double result = 12.126;
	private ShotPutEvent fixture = null;
	
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		this.fixture = new ShotPutEvent(this.result);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		this.fixture = null;
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.ShotPutEvent#ShotPutEvent(double)}.
	 */
	public void testShotPutEvent() {
		FieldDecathlonEvent sample = null;
		try {
			sample = new FieldDecathlonEvent(this.result, this.aParameter, this.bParameter, this.cParameter);
		}
		catch (Exception e) {
			fail("Correct parameters should not cause exceptions");
		}
		assert(sample instanceof FieldDecathlonEvent);
		int expectedResult = sample.getPoints();
		int gotResult = this.fixture.getPoints();
		assertEquals(expectedResult, gotResult);
	}

}
