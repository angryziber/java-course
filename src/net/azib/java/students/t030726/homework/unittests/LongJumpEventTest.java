package net.azib.java.students.t030726.homework.unittests;

import net.azib.java.students.t030726.homework.decathlon.FieldDecathlonEvent;
import net.azib.java.students.t030726.homework.decathlon.LongJumpEvent;

import junit.framework.TestCase;

/**
 * LongJumpEventTest
 *
 * @author NTAdmin
 */
public class LongJumpEventTest extends TestCase {
	private final double aParameter = 0.14354;
	private final double bParameter = 220;
	private final double cParameter = 1.40;
	private final double result = 15.155;
	private LongJumpEvent fixture = null;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		this.fixture = new LongJumpEvent(this.result);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		this.fixture = null;
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.LongJumpEvent#LongJumpEvent(double)}.
	 */
	public void testLongJumpEvent() {
		FieldDecathlonEvent sample = null;
		try {
			//Conversion to cm needed
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
