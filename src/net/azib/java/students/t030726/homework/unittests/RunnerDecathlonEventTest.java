package unittests;

import decathlon.InvalidDataFormatException;
import decathlon.RunnerDecathlonEvent;
import junit.framework.TestCase;

public class RunnerDecathlonEventTest extends TestCase {
	private RunnerDecathlonEvent fixtureSecondsOnly = null;
	private RunnerDecathlonEvent fixtureMinutesAndSeconds = null;
	private String achievedResultSecondsOnly = "43.3";
	private double achievedResultSecondsOnlyD = 43.3;
	private double achievedResultsMinutesAndSecondsD = 85;
	private String achievedResultMinutesAndSeconds = "1:25";
	private double sampleAParameter = 1.2345;
	private double sampleBParameter = 0.18;
	private double sampleCParameter = 1.80;
	private double sampleHandTime = 0.24;

	protected void setUp() throws Exception {
		super.setUp();
		this.fixtureSecondsOnly = new RunnerDecathlonEvent(this.achievedResultSecondsOnly, this.sampleAParameter, this.sampleBParameter, 
				this.sampleCParameter);
		this.fixtureMinutesAndSeconds = new RunnerDecathlonEvent(this.achievedResultMinutesAndSeconds, this.sampleAParameter, 
				this.sampleBParameter, this.sampleCParameter);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		this.fixtureMinutesAndSeconds = null;
		this.fixtureSecondsOnly = null;
	}

	
	private int computePoints(boolean useHandTime, boolean isSecondsOnly) {
		double handTime = 0.0;
		double achievedResult = 0.0;
		if(useHandTime) {
			handTime = this.sampleHandTime;
		}
		if(isSecondsOnly) {
			achievedResult = this.achievedResultSecondsOnlyD;
		} else {
			achievedResult = this.achievedResultsMinutesAndSecondsD;
		}
		int points = (int) (this.sampleAParameter * Math.pow((this.sampleBParameter - (achievedResult + handTime)), this.sampleCParameter));
		return points;
	}
	
	public void testGetPointsForSecondsOnly() {
		int expectedResult = this.computePoints(false, true);
		int gotResult = this.fixtureSecondsOnly.getPoints();
		assertEquals(expectedResult, gotResult);
	}
	
	public void testGetPointsForMinutesAndSeconds () {
		int expectedResult = this.computePoints(false, false);
		int gotResult = this.fixtureMinutesAndSeconds.getPoints();
		assertEquals(expectedResult, gotResult);
	}
	
	public void testGetPointsForMinutesAndSecondsWithHandTime() {
		int expectedResult = this.computePoints(true, false);
		try {
			this.fixtureMinutesAndSeconds.setHandTime(this.sampleHandTime);
		} catch (InvalidDataFormatException e) {
			fail("Setting hand time should not throw an exception");
		}
		int gotResult = this.fixtureMinutesAndSeconds.getPoints();
		assertEquals(expectedResult, gotResult);
	}
	
	public void testGetPointsForSecondsOnlyWithHandTime() {
		int expectedResult = this.computePoints(true, true);
		try {
			this.fixtureSecondsOnly.setHandTime(this.sampleHandTime);
		} catch (InvalidDataFormatException e) {
			fail("Correct hand time values should not throw expeptions");
		}
		int gotResult = this.fixtureSecondsOnly.getPoints();
		assertEquals(expectedResult, gotResult);
		
	}

	public void testZeroSetHandTime() {
		try {
			this.fixtureSecondsOnly.setHandTime(0);
		} catch (InvalidDataFormatException ex) {
			return;
		}
		fail("Hand time of zero should fail");
	}
	
	public void testNegativeSetHandTime() {
		try {
			this.fixtureSecondsOnly.setHandTime(-2.3456);
		} catch (InvalidDataFormatException ex) {
			return;
		}
		fail("Negative hand time should throw an exception");
	}
	
	public void testSetHandTime() {
		try {
			this.fixtureSecondsOnly.setHandTime(this.sampleHandTime);
		} catch (Exception ex) {
			fail("Saving a correct hand time should not produce any exceptions");
		}
		return;
	}

	public void testRunnerDecathlonEventWithBadAchievedResult() {
		try {
			RunnerDecathlonEvent sample = new RunnerDecathlonEvent(" :12", this.sampleAParameter, this.sampleBParameter, this.sampleCParameter);
		} catch (Exception ex) {
			return;
		}
		fail("Invalid achieved result should trigger an exception");
	}

}
