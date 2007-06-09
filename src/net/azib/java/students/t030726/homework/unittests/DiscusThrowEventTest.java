package net.azib.java.students.t030726.homework.unittests;

import net.azib.java.students.t030726.homework.decathlon.DiscusThrowEvent;
import net.azib.java.students.t030726.homework.decathlon.FieldDecathlonEvent;

import junit.framework.TestCase;

/**
 * DiscusThrowEventTest
 *
 * @author Deniss Nikiforov
 */
public class DiscusThrowEventTest extends TestCase {
	private final double aParameter = 12.91;
	private final double bParameter = 4.0;
	private final double cParameter = 1.1;
	private final double result = 15.156;
	private DiscusThrowEvent fixture = null;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		this.fixture = new DiscusThrowEvent(this.result);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		this.fixture = null;
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.DiscusThrowEvent#DiscusThrowEvent(double)}.
	 */
	public void testDiscusThrowEvent() {
		//We test against a DieldDecathlonevent, as that one was tested by another unit test already
		FieldDecathlonEvent sample = null;
		try {
			sample = new FieldDecathlonEvent(this.result, this.aParameter, this.bParameter, this.cParameter);
		}
		catch (Exception e) {
			fail("There should not be any exceptions with correct values");
		}
		int expectedResult = sample.getPoints();
		int gotResult = this.fixture.getPoints();
		assertEquals(expectedResult, gotResult);	
	}
	
	

}
