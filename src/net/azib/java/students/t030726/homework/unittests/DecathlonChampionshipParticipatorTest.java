package net.azib.java.students.t030726.homework.unittests;

import net.azib.java.students.t030726.homework.decathlon.DecathlonChampionshipParticipator;

import junit.framework.TestCase;

/**
 * DecathlonChampionshipParticipatorTest
 *
 * @author Deniss Nikiforov
 */
public class DecathlonChampionshipParticipatorTest extends TestCase {
	private final String sampleName = "Tester";
	private final String sampleCountryCode = "EE";
	private final String sampleDate = "01.01.1976";
	private DecathlonChampionshipParticipator fixture = null;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		this.fixture = new DecathlonChampionshipParticipator(this.sampleName, this.sampleCountryCode, this.sampleDate);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		this.fixture = null;
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.DecathlonChampionshipParticipator#getDateOfBirth()}.
	 */
	public void testGetDateOfBirth() {
		assertEquals(this.sampleDate, this.fixture.getDateOfBirth());
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.DecathlonChampionshipParticipator#getParticipatorName()}.
	 */
	public void testGetParticipatorName() {
		assertEquals(this.sampleName, this.fixture.getParticipatorName());
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.DecathlonChampionshipParticipator#getParticipatorCountryCode()}.
	 */
	public void testGetParticipatorCountryCode() {
		assertEquals(this.sampleCountryCode, this.fixture.getParticipatorCountryCode());
	}

}
