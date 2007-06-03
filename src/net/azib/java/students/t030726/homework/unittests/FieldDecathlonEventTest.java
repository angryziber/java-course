package unittests;

import decathlon.FieldDecathlonEvent;
import junit.framework.TestCase;

public class FieldDecathlonEventTest extends TestCase {
	private double sampleAParameter = 1.2345;
	private double sampleBParameter = 0.18;
	private double sampleCParameter = 1.80;
	private double achievedResult = 12.344;
	private FieldDecathlonEvent fixture = null;

	protected void setUp() throws Exception {
		super.setUp();
		this.fixture = new FieldDecathlonEvent(this.achievedResult, this.sampleAParameter, this.sampleBParameter, this.sampleCParameter);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		this.fixture = null;
	}
	
	private int computePoints() {
		int result = (int)(this.sampleAParameter * Math.pow((this.achievedResult - this.sampleBParameter), this.sampleCParameter));
		return result;
	}

	public void testGetPoints() {
		int expectedResult = this.computePoints();
		int gotResult = this.fixture.getPoints();
		assertEquals(expectedResult, gotResult);
	}

}
