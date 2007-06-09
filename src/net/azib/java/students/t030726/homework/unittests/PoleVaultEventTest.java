package net.azib.java.students.t030726.homework.unittests;

import net.azib.java.students.t030726.homework.decathlon.FieldDecathlonEvent;
import net.azib.java.students.t030726.homework.decathlon.PoleVaultEvent;

import junit.framework.TestCase;

/**
 * PoleVaultEventTest
 *
 * @author NTAdmin
 */
public class PoleVaultEventTest extends TestCase {
	private final double aParameter = 0.2797;
	private final double bParameter = 100;
	private final double cParameter = 1.35;
	private final double result = 12.126;
	private PoleVaultEvent fixture = null;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		this.fixture = new PoleVaultEvent(this.result);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		this.fixture = null;
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.PoleVaultEvent#PoleVaultEvent(double)}.
	 */
	public void testPoleVaultEvent() {
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
