package net.azib.java.students.t030726.homework.unittests;

import net.azib.java.students.t030726.homework.decathlon.FifteenHundredMeterRunEvent;
import net.azib.java.students.t030726.homework.decathlon.RunnerDecathlonEvent;

import junit.framework.TestCase;

/**
 * FifteenHundredMeterRunEventTest
 *
 * @author Deniss Nikiforov
 */
public class FifteenHundredMeterRunEventTest extends TestCase {
	private final double aParameter = 0.03768;
	private final double bParameter = 480;
	private final double cParameter = 1.85;
	private String result = "1:12.235";
	private FifteenHundredMeterRunEvent fixture  = null;
	
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		this.fixture = new FifteenHundredMeterRunEvent(this.result);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		this.fixture = null;
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.FifteenHundredMeterRunEvent#FifteenHundredMeterRunEvent(java.lang.String)}.
	 */
	public void testFifteenHundredMeterRunEvent() {
		RunnerDecathlonEvent sample = null;
		try {
			sample = new RunnerDecathlonEvent(this.result, this.aParameter, this.bParameter, this.cParameter);
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
