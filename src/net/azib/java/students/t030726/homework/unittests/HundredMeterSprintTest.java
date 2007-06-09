package net.azib.java.students.t030726.homework.unittests;

import net.azib.java.students.t030726.homework.decathlon.HundredMeterSprint;
import net.azib.java.students.t030726.homework.decathlon.RunnerDecathlonEvent;

import junit.framework.TestCase;

/**
 * HundredMeterSprintTest
 *
 * @author NTAdmin
 */
public class HundredMeterSprintTest extends TestCase {
	private final double aParameter = 25.437;
	private final double bParameter = 18.0;
	private final double cParameter = 1.81;
	private final double handTime = 0.24;
	private String result = "1:12.235";
	private HundredMeterSprint fixture = null;
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		this.fixture = new HundredMeterSprint(this.result);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		this.fixture = null;
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.HundredMeterSprint#HundredMeterSprint(java.lang.String)}.
	 */
	public void testHundredMeterSprint() {
		RunnerDecathlonEvent sample = null;
		try {
			sample = new RunnerDecathlonEvent(this.result, this.aParameter, this.bParameter, this.cParameter);
			sample.setHandTime(this.handTime);
		}
		catch (Exception e) {
			fail("There should be no exceptions with valid parameter values");
		}
		
		assert(sample instanceof RunnerDecathlonEvent);
	
		int expectedResult = sample.getPoints();
		int gotResult = this.fixture.getPoints();
		assertEquals(expectedResult, gotResult);
	}

}
