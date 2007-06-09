package net.azib.java.students.t030726.homework.unittests;

import net.azib.java.students.t030726.homework.decathlon.FieldDecathlonEvent;
import net.azib.java.students.t030726.homework.decathlon.HighJumpEvent;

import junit.framework.TestCase;

/**
 * HighJumpEventTest
 *
 * @author Deniss Nikiforov
 */
public class HighJumpEventTest extends TestCase {
	private HighJumpEvent fixture = null;
	private final double aParameter = 0.8465;
	private final double bParameter = 75;
	private final double result = 15.156;
	private final double cParameter = 1.42;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		this.fixture = new HighJumpEvent(this.result);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		this.fixture = null;
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.HighJumpEvent#HighJumpEvent(double)}.
	 */
	public void testHighJumpEvent() {
		FieldDecathlonEvent sample = null;
		try {
			//This event requires conversion to cm
			sample = new FieldDecathlonEvent(this.result*100, this.aParameter, this.bParameter, this.cParameter);
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
