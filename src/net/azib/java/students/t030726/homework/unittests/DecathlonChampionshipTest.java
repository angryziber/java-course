package net.azib.java.students.t030726.homework.unittests;

import net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship;
import net.azib.java.students.t030726.homework.decathlon.DecathlonChampionshipParticipator;
import net.azib.java.students.t030726.homework.decathlon.DiscusThrowEvent;
import net.azib.java.students.t030726.homework.decathlon.FifteenHundredMeterRunEvent;
import net.azib.java.students.t030726.homework.decathlon.FourHundredMeterSprint;
import net.azib.java.students.t030726.homework.decathlon.HighJumpEvent;
import net.azib.java.students.t030726.homework.decathlon.HundredAndTenMeterHurdlesEvent;
import net.azib.java.students.t030726.homework.decathlon.HundredMeterSprint;
import net.azib.java.students.t030726.homework.decathlon.JavelinThrowEvent;
import net.azib.java.students.t030726.homework.decathlon.LongJumpEvent;
import net.azib.java.students.t030726.homework.decathlon.PoleVaultEvent;
import net.azib.java.students.t030726.homework.decathlon.ShotPutEvent;

import junit.framework.TestCase;

/**
 * DecathlonChampionshipTest
 *
 * @author NTAdmin
 */
public class DecathlonChampionshipTest extends TestCase {
	private DecathlonChampionship fixture = null;
	DecathlonChampionshipParticipator tempParticipator = null;
	private HundredMeterSprint hundredSprint = null;
	private LongJumpEvent longJump = null;
	private ShotPutEvent shotPut = null;
	private HighJumpEvent highJump = null;
	private FourHundredMeterSprint fourHundredSprint = null;
	private HundredAndTenMeterHurdlesEvent hurdlesEvent = null;
	private DiscusThrowEvent discusThrow = null;
	private PoleVaultEvent poleVault = null;
	private JavelinThrowEvent javelinThrow = null;
	private FifteenHundredMeterRunEvent longRun = null;
	private String runnerEventResult = "1:18.125";
	private double fieldEventResult = 15.123;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		this.tempParticipator = new DecathlonChampionshipParticipator("Tester", "EE", "10.10.1990");
		this.fixture = new DecathlonChampionship(tempParticipator);
		this.hundredSprint = new HundredMeterSprint(this.runnerEventResult);
		this.longJump = new LongJumpEvent(this.fieldEventResult);
		this.shotPut = new ShotPutEvent(this.fieldEventResult);
		this.highJump = new HighJumpEvent(this.fieldEventResult);
		this.fourHundredSprint = new FourHundredMeterSprint(this.runnerEventResult);
		this.hurdlesEvent = new HundredAndTenMeterHurdlesEvent(this.runnerEventResult);
		this.discusThrow = new DiscusThrowEvent(this.fieldEventResult);
		this.poleVault = new PoleVaultEvent(this.fieldEventResult);
		this.javelinThrow = new JavelinThrowEvent(this.fieldEventResult);
		this.longRun = new FifteenHundredMeterRunEvent(this.runnerEventResult);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		this.tempParticipator = null;
		this.fixture = null;
		this.hundredSprint = null;
		this.longJump = null;
		this.shotPut = null;
		this.highJump = null;
		this.fourHundredSprint = null;
		this.hurdlesEvent = null;
		this.discusThrow = null;
		this.poleVault = null;
		this.javelinThrow = null;
		this.longRun = null;
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship#getHundredMeterSprintRawResult()}.
	 */
	public void testGetHundredMeterSprintRawResult() {
		try {
			this.fixture.setHundredMeterSprintData(this.hundredSprint);
		}
		catch (InstantiationException e) {
			fail("Correct values should not produce exceptions");
		}
		String gotResult = null;
		try {
			gotResult = this.fixture.getHundredMeterSprintRawResult();
		}
		catch (InstantiationException e) {
			fail("Correct values should not produce exceptions");
		}

		assert(gotResult.equals(this.runnerEventResult));
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship#getLongJumpRawResult()}.
	 */
	public void testGetLongJumpRawResult() {
		try {
			this.fixture.setLongJumpEventData(this.longJump);
		}
		catch (InstantiationException e) {
			fail("Correct values should not produce exceptions");
		}
		String gotResult = null;
		try {
			gotResult = this.fixture.getLongJumpRawResult();
		}
		catch (InstantiationException e) {
			fail("Correct values should not produce exceptions");
		}
		
		assert(gotResult.equals(this.fieldEventResult));
		
		
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship#getShotPutRawResult()}.
	 */
	public void testGetShotPutRawResult() {
		try {
			this.fixture.setShotPutEventData(this.shotPut);
		}
		catch (InstantiationException e) {
			fail("Correct values should not produce exceptions");
		}
		String gotResult = null;
		
		try {
			gotResult = this.fixture.getShotPutRawResult();
		}
		catch (InstantiationException e) {
			fail("Correct values should not produce exceptions");
		}
		
		assert(gotResult.equals(this.fieldEventResult));
		
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship#getHighJumpRawResult()}.
	 */
	public void testGetHighJumpRawResult() {
		try {
			this.fixture.setHighJumpEventData(this.highJump);
		}
		catch (InstantiationException e) {
			fail("Correct values should not produce exceptions");
		}
		
		String gotResult = null;
		
		try {
			gotResult = this.fixture.getHighJumpRawResult();
		}
		catch (InstantiationException e) {
			fail("Correct values should not produce exceptions");
		}
		
		assert(gotResult.equals(this.fieldEventResult));
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship#getFourHundredMeterSprintRawResult()}.
	 */
	public void testGetFourHundredMeterSprintRawResult() {
		try {
			this.fixture.setFourHundredMeterSprintEventData(this.fourHundredSprint);
		}
		catch (InstantiationException e) {
			fail("Correct values should not produce exceptions");
		}
		
		String gotResult = null;
		
		try {
			gotResult = this.fixture.getFourHundredMeterSprintRawResult();
		}
		catch (InstantiationException e) {
			fail("Correct values should not produce exceptions");
		}
		
		assert(gotResult.equals(this.runnerEventResult));
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship#getHurdlesRawResult()}.
	 */
	public void testGetHurdlesRawResult() {
		try {
			this.fixture.setHundredAndTenMeterHurdlesEventData(this.hurdlesEvent);
		}
		catch (InstantiationException e) {
			fail("Correct values should not produce exceptions");
		}
		
		String gotResult = null;
		
		try {
			gotResult = this.fixture.getHurdlesRawResult();
		}
		catch (InstantiationException e) {
			fail("Correct values should not produce exceptions");
		}
		
		assert(gotResult.equals(this.runnerEventResult));
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship#getDiscusThrowRawResult()}.
	 */
	public void testGetDiscusThrowRawResult() {
		try {
			this.fixture.setDiscusThrowEventData(this.discusThrow);
		}
		catch (InstantiationException e) {
			fail("Correct values should not produce exceptions");
		}
		
		String gotResult = null;
		
		try {
			gotResult = this.fixture.getDiscusThrowRawResult();
		}
		catch (InstantiationException e) {
			fail("Correct values should not produce exceptions");
		}
		
		assert(gotResult.equals(this.fieldEventResult));
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship#getPoleVaultRawResult()}.
	 */
	public void testGetPoleVaultRawResult() {
		try {
			this.fixture.setPoleVaultEventData(this.poleVault);
		}
		catch (InstantiationException e) {
			fail("Correct values should not produce exceptions");
		}
		
		String gotResult = null;
		
		try {
			gotResult = this.fixture.getPoleVaultRawResult();
		}
		catch (InstantiationException e) {
			fail("Correct values should not produce exceptions");
		}
		
		assert(gotResult.equals(this.fieldEventResult));
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship#getJavelinThrowRawResult()}.
	 */
	public void testGetJavelinThrowRawResult() {
		try {
			this.fixture.setJavelinThrowEventData(this.javelinThrow);
		}
		catch (InstantiationException e) {
			fail("Correct values should not produce exceptions");
		}
		
		String gotResult = null;
		
		try {
			gotResult = this.fixture.getJavelinThrowRawResult();
		}
		catch (InstantiationException e) {
			fail("Correct values should not produce exceptions");
		}
		
		assert(gotResult.equals(this.fieldEventResult));
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship#getLongRunRawResult()}.
	 */
	public void testGetLongRunRawResult() {
		try {
			this.fixture.setFifteenHundredMeterRunEventData(this.longRun);
		}
		catch (InstantiationException e) {
			fail("Correct values should not produce exceptions");
		}
		
		String gotResult = null;
		
		try {
			gotResult = this.fixture.getLongRunRawResult();
		}
		catch (InstantiationException e) {
			fail("Correct values should not produce exceptions");
		}
		
		assert(gotResult.equals(this.runnerEventResult));
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship#setPosition(java.lang.String)}.
	 */
	public void testSetAndGetPosition() {
		String samplePosition = "15";
		this.fixture.setPosition(samplePosition);
		String gotResult = null;
		try {
			gotResult = this.fixture.getPosition();
		}
		catch (Exception e) {
			fail("Reading of position with a correct value should not throw an exception");
		}
		
		assertEquals(samplePosition, gotResult);
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship#setHundredMeterSprintData(net.azib.java.students.t030726.homework.decathlon.HundredMeterSprint)}.
	 */
	public void testSetHundredMeterSprintData() {
		try {
			this.fixture.setHundredMeterSprintData(this.hundredSprint);
		}
		catch (InstantiationException e) {
			fail("This should not cause an exception with correct parameters");
		}
		try {
			this.fixture.setHundredMeterSprintData(this.hundredSprint);
		}
		catch (InstantiationException e) {
			return;
		}
		fail("Attempting to rewrite should throw an exception");

	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship#setLongJumpEventData(net.azib.java.students.t030726.homework.decathlon.LongJumpEvent)}.
	 */
	public void testSetLongJumpEventData() {
		try {
			this.fixture.setLongJumpEventData(this.longJump);
		}
		catch (InstantiationException e) {
			fail("This should not cause an exception with correct parameters");
		}
		try {
			this.fixture.setLongJumpEventData(this.longJump);
		}
		catch (InstantiationException e) {
			return;
		}
		fail("Attempting to rewrite should throw an exception");
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship#setShotPutEventData(net.azib.java.students.t030726.homework.decathlon.ShotPutEvent)}.
	 */
	public void testSetShotPutEventData() {
		try {
			this.fixture.setShotPutEventData(this.shotPut);
		}
		catch (InstantiationException e) {
			fail("This should not cause an exception with correct parameters");
		}
		
		
		try {
			this.fixture.setShotPutEventData(this.shotPut);
		}
		catch (InstantiationException e) {
			return;
		}
		fail("Attempting to rewrite should throw an exception");
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship#setHighJumpEventData(net.azib.java.students.t030726.homework.decathlon.HighJumpEvent)}.
	 */
	public void testSetHighJumpEventData() {
		try {
			this.fixture.setHighJumpEventData(this.highJump);
		}
		catch (InstantiationException e) {
			fail("This should not cause an exception with correct parameters");
		}
		
		try {
			this.fixture.setHighJumpEventData(this.highJump);
		}
		catch (InstantiationException e) {
			return;
		}
		fail("Attempting to rewrite should throw an exception");
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship#setFourHundredMeterSprintEventData(net.azib.java.students.t030726.homework.decathlon.FourHundredMeterSprint)}.
	 */
	public void testSetFourHundredMeterSprintEventData() {
		try {
			this.fixture.setFourHundredMeterSprintEventData(this.fourHundredSprint);
		}
		catch (InstantiationException e) {
			fail("This should not cause an exception with correct parameters");
		}
		
		try {
			this.fixture.setFourHundredMeterSprintEventData(this.fourHundredSprint);
		}
		catch (InstantiationException e) {
			return;
		}
		fail("Attempting to rewrite should throw an exception");
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship#setHundredAndTenMeterHurdlesEventData(net.azib.java.students.t030726.homework.decathlon.HundredAndTenMeterHurdlesEvent)}.
	 */
	public void testSetHundredAndTenMeterHurdlesEventData() {
		try {
			this.fixture.setHundredAndTenMeterHurdlesEventData(this.hurdlesEvent);
		}
		catch (InstantiationException e) {
			fail("This should not cause an exception with correct parameters");
		}
		
		try {
			this.fixture.setHundredAndTenMeterHurdlesEventData(this.hurdlesEvent);
		}
		catch (InstantiationException e) {
			return;
		}
		fail("Attempting to rewrite should throw an exception");
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship#setDiscusThrowEventData(net.azib.java.students.t030726.homework.decathlon.DiscusThrowEvent)}.
	 */
	public void testSetDiscusThrowEventData() {
		try {
			this.fixture.setDiscusThrowEventData(this.discusThrow);
		}
		catch (InstantiationException e) {
			fail("This should not cause an exception with correct parameters");
		}
		
		try {
			this.fixture.setDiscusThrowEventData(this.discusThrow);
		}
		catch (InstantiationException e) {
			return;
		}
		fail("Attempting to rewrite should throw an exception");
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship#setPoleVaultEventData(net.azib.java.students.t030726.homework.decathlon.PoleVaultEvent)}.
	 */
	public void testSetPoleVaultEventData() {
		try {
			this.fixture.setPoleVaultEventData(this.poleVault);
		}
		catch (InstantiationException e) {
			fail("This should not cause an exception with correct parameters");
		}
		
		try {
			this.fixture.setPoleVaultEventData(this.poleVault);
		}
		catch (InstantiationException e) {
			return;
		}
		fail("Attempting to rewrite should throw an exception");
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship#setJavelinThrowEventData(net.azib.java.students.t030726.homework.decathlon.JavelinThrowEvent)}.
	 */
	public void testSetJavelinThrowEventData() {
		try {
			this.fixture.setJavelinThrowEventData(this.javelinThrow);
		}
		catch (InstantiationException e) {
			fail("This should not cause an exception with correct parameters");
		}
		
		try {
			this.fixture.setJavelinThrowEventData(this.javelinThrow);
		}
		catch (InstantiationException e) {
			return;
		}
		fail("Attempting to rewrite should throw an exception");
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship#setFifteenHundredMeterRunEventData(net.azib.java.students.t030726.homework.decathlon.FifteenHundredMeterRunEvent)}.
	 */
	public void testSetFifteenHundredMeterRunEventData() {
		try {
			this.fixture.setFifteenHundredMeterRunEventData(this.longRun);
		}
		catch (InstantiationException e) {
			fail("This should not cause an exception with correct parameters");
		}
		
		try {
			this.fixture.setFifteenHundredMeterRunEventData(this.longRun);
		}
		catch (InstantiationException e) {
			return;
		}
		fail("Attempting to rewrite should throw an exception");
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship#getParticipator()}.
	 */
	public void testGetParticipator() {
		DecathlonChampionshipParticipator gotResult = null;
		gotResult = this.fixture.getParticipator();
		
		assert(this.tempParticipator.equals(gotResult));
		
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship#getPoints()}.
	 */
	public void testGetPoints() {
		int points = 0;
		points += this.hundredSprint.getPoints();
		points += this.longJump.getPoints();
		points += this.shotPut.getPoints();
		points += this.highJump.getPoints();
		points += this.fourHundredSprint.getPoints();
		points += this.hurdlesEvent.getPoints();
		points += this.discusThrow.getPoints();
		points += this.poleVault.getPoints();
		points += this.javelinThrow.getPoints();
		points += this.longRun.getPoints();
		int expectedResult = points;
		int gotResult = 0;
		try {
			gotResult = this.fixture.getPoints();
		}
		catch (Exception e) {
			//We are OK here, we should get an exception, because the Championship doesn't have any events in it.
		}
		
		try {
			this.fixture.setHundredMeterSprintData(this.hundredSprint);
			this.fixture.setLongJumpEventData(this.longJump);
			this.fixture.setShotPutEventData(this.shotPut);
			this.fixture.setHighJumpEventData(this.highJump);
			this.fixture.setFourHundredMeterSprintEventData(this.fourHundredSprint);
			this.fixture.setHundredAndTenMeterHurdlesEventData(this.hurdlesEvent);
			this.fixture.setDiscusThrowEventData(this.discusThrow);
			this.fixture.setPoleVaultEventData(this.poleVault);
			this.fixture.setJavelinThrowEventData(this.javelinThrow);
			this.fixture.setFifteenHundredMeterRunEventData(this.longRun);
		}
		catch (InstantiationException e) {
			fail("There should not be any exceptions with correct values");
		}
		
		try {
			gotResult = this.fixture.getPoints();
		}
		catch (Exception e) {
			fail("Now, that everything is initialized, there should be no exceptions");
		}
		
		assertEquals(expectedResult, gotResult);
	}

	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship#compareTo(java.lang.Object)}.
	 */
	public void testLesserCompareTo() {
		DecathlonChampionship first = null; //this shall be smaller
		DecathlonChampionship second = null;
		LongJumpEvent weakLongJumpEvent = null;
		first = new DecathlonChampionship(this.tempParticipator);
		second = new DecathlonChampionship(this.tempParticipator);
		
		try {
			weakLongJumpEvent = new LongJumpEvent(1.12);
		}
		catch (Exception e) {
			fail("Correct values should not produce exceptions");
		}
		
		try {
			first.setHundredMeterSprintData(this.hundredSprint);
			first.setLongJumpEventData(weakLongJumpEvent);
			first.setShotPutEventData(this.shotPut);
			first.setHighJumpEventData(this.highJump);
			first.setFourHundredMeterSprintEventData(this.fourHundredSprint);
			first.setHundredAndTenMeterHurdlesEventData(this.hurdlesEvent);
			first.setDiscusThrowEventData(this.discusThrow);
			first.setPoleVaultEventData(this.poleVault);
			first.setJavelinThrowEventData(this.javelinThrow);
			first.setFifteenHundredMeterRunEventData(this.longRun);
		}
		catch (InstantiationException e) {
			fail("Correct values should not produce exceptions");
		}
		
		try {
			second.setHundredMeterSprintData(this.hundredSprint);
			second.setLongJumpEventData(this.longJump);
			second.setShotPutEventData(this.shotPut);
			second.setHighJumpEventData(this.highJump);
			second.setFourHundredMeterSprintEventData(this.fourHundredSprint);
			second.setHundredAndTenMeterHurdlesEventData(this.hurdlesEvent);
			second.setDiscusThrowEventData(this.discusThrow);
			second.setPoleVaultEventData(this.poleVault);
			second.setJavelinThrowEventData(this.javelinThrow);
			second.setFifteenHundredMeterRunEventData(this.longRun);
		}
		catch (InstantiationException e) {
			fail("Correct values should not produce exceptions");
		}
		
		int gotResult = first.compareTo(second);
		
		assert(gotResult < 0);
	}
	
	
	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship#compareTo(java.lang.Object)}.
	 */
	public void testEqualCompareTo() {
		DecathlonChampionship first = null; //this shall be smaller
		DecathlonChampionship second = null;
		first = new DecathlonChampionship(this.tempParticipator);
		second = new DecathlonChampionship(this.tempParticipator);

		
		try {
			first.setHundredMeterSprintData(this.hundredSprint);
			first.setLongJumpEventData(this.longJump);
			first.setShotPutEventData(this.shotPut);
			first.setHighJumpEventData(this.highJump);
			first.setFourHundredMeterSprintEventData(this.fourHundredSprint);
			first.setHundredAndTenMeterHurdlesEventData(this.hurdlesEvent);
			first.setDiscusThrowEventData(this.discusThrow);
			first.setPoleVaultEventData(this.poleVault);
			first.setJavelinThrowEventData(this.javelinThrow);
			first.setFifteenHundredMeterRunEventData(this.longRun);
		}
		catch (InstantiationException e) {
			fail("Correct values should not produce exceptions");
		}
		
		try {
			second.setHundredMeterSprintData(this.hundredSprint);
			second.setLongJumpEventData(this.longJump);
			second.setShotPutEventData(this.shotPut);
			second.setHighJumpEventData(this.highJump);
			second.setFourHundredMeterSprintEventData(this.fourHundredSprint);
			second.setHundredAndTenMeterHurdlesEventData(this.hurdlesEvent);
			second.setDiscusThrowEventData(this.discusThrow);
			second.setPoleVaultEventData(this.poleVault);
			second.setJavelinThrowEventData(this.javelinThrow);
			second.setFifteenHundredMeterRunEventData(this.longRun);
		}
		catch (InstantiationException e) {
			fail("Correct values should not produce exceptions");
		}
		
		int gotResult = first.compareTo(second);
		
		assert(gotResult == 0);
	}
	
	/**
	 * Test method for {@link net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship#compareTo(java.lang.Object)}.
	 */
	public void testLargerCompareTo() {
		DecathlonChampionship first = null; //this shall be smaller
		DecathlonChampionship second = null;
		LongJumpEvent weakLongJumpEvent = null;
		first = new DecathlonChampionship(this.tempParticipator);
		second = new DecathlonChampionship(this.tempParticipator);
		
		try {
			weakLongJumpEvent = new LongJumpEvent(1.12);
		}
		catch (Exception e) {
			fail("Correct values should not produce exceptions");
		}
		
		try {
			first.setHundredMeterSprintData(this.hundredSprint);
			first.setLongJumpEventData(this.longJump);
			first.setShotPutEventData(this.shotPut);
			first.setHighJumpEventData(this.highJump);
			first.setFourHundredMeterSprintEventData(this.fourHundredSprint);
			first.setHundredAndTenMeterHurdlesEventData(this.hurdlesEvent);
			first.setDiscusThrowEventData(this.discusThrow);
			first.setPoleVaultEventData(this.poleVault);
			first.setJavelinThrowEventData(this.javelinThrow);
			first.setFifteenHundredMeterRunEventData(this.longRun);
		}
		catch (InstantiationException e) {
			fail("Correct values should not produce exceptions");
		}
		
		try {
			second.setHundredMeterSprintData(this.hundredSprint);
			second.setLongJumpEventData(weakLongJumpEvent);
			second.setShotPutEventData(this.shotPut);
			second.setHighJumpEventData(this.highJump);
			second.setFourHundredMeterSprintEventData(this.fourHundredSprint);
			second.setHundredAndTenMeterHurdlesEventData(this.hurdlesEvent);
			second.setDiscusThrowEventData(this.discusThrow);
			second.setPoleVaultEventData(this.poleVault);
			second.setJavelinThrowEventData(this.javelinThrow);
			second.setFifteenHundredMeterRunEventData(this.longRun);
		}
		catch (InstantiationException e) {
			fail("Correct values should not produce exceptions");
		}
		
		int gotResult = first.compareTo(second);
		
		assert(gotResult > 0);
	}

}
