package net.azib.java.students.t030726.homework.unittests;

import net.azib.java.students.t030726.homework.decathlon.HundredAndTenMeterHurdlesEvent;
import net.azib.java.students.t030726.homework.decathlon.RunnerDecathlonEvent;

import junit.framework.TestCase;

/**
 * HundredAndTenMeterHurdlesEventTest
 *
 * @author NTAdmin
 */
public class HundredAndTenMeterHurdlesEventTest extends TestCase {
	private final double aParameter = 5.74352;
	private final double bParameter = 28.5;
	private final double cParameter = 1.92;
	private final double handTime = 0.24;
	private String result = "1:12.235";
	private HundredAndTenMeterHurdlesEvent fixture = null;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		this.fixture = new HundredAndTenMeterHurdlesEvent(this.result);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		this.fixture = null;
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.HundredAndTenMeterHurdlesEvent#HundredAndTenMeterHurdlesEvent(java.lang.String)}.
	 */
	public void testHundredAndTenMeterHurdlesEvent() {
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
