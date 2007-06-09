package net.azib.java.students.t030726.homework.unittests;

import net.azib.java.students.t030726.homework.decathlon.FourHundredMeterSprint;
import net.azib.java.students.t030726.homework.decathlon.RunnerDecathlonEvent;

import junit.framework.TestCase;

/**
 * FourHundredMeterSprintTest
 *
 * @author NTAdmin
 */
public class FourHundredMeterSprintTest extends TestCase {
	private final double aParameter = 1.53775;
	private final double bParameter = 82;
	private final double cParameter = 1.81;
	private final double handTime = 0.14;
	private String result = "1:12.235";
	private FourHundredMeterSprint fixture = null;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		this.fixture = new FourHundredMeterSprint(this.result);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		this.fixture = null;
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.FourHundredMeterSprint#FourHundredMeterSprint(java.lang.String)}.
	 */
	public void testFourHundredMeterSprint() {
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
