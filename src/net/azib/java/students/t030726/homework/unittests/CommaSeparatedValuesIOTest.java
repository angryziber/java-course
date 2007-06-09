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
import net.azib.java.students.t030726.homework.input.CommaSeparatedValuesInput;

import junit.framework.TestCase;

/**
 * CommaSeparatedValuesOutputTest
 *
 * @author Deniss Nikiforov
 */
public class CommaSeparatedValuesIOTest extends TestCase {
	private CommaSeparatedValuesInput fixture = null;
	//This is a relative path, so should be fine
	private String targetTestHelperFile = "src/net/azib/java/students/t030726/homework/unittests/helper.csv";
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		this.fixture = new CommaSeparatedValuesInput(this.targetTestHelperFile);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		this.fixture = null;
	}

	private DecathlonChampionship instantiateExpectedObject() throws Exception {
		DecathlonChampionship temp = new DecathlonChampionship(
				new DecathlonChampionshipParticipator("Szőrös Szűk", "HU","3-04-1972"));
		temp.setHundredMeterSprintData(new HundredMeterSprint("13.75"));
		temp.setLongJumpEventData(new LongJumpEvent(4.84));
		temp.setShotPutEventData(new ShotPutEvent(10.12));
		temp.setHighJumpEventData(new HighJumpEvent(1.50));
		temp.setFourHundredMeterSprintEventData(new FourHundredMeterSprint("1:08.44"));
		temp.setHundredAndTenMeterHurdlesEventData(new HundredAndTenMeterHurdlesEvent("19.18"));
		temp.setDiscusThrowEventData(new DiscusThrowEvent(30.85));
		temp.setPoleVaultEventData(new PoleVaultEvent(2.80));
		temp.setJavelinThrowEventData(new JavelinThrowEvent(33.88));
		temp.setFifteenHundredMeterRunEventData(new FifteenHundredMeterRunEvent("6:22.75"));
		
		return temp;
	}
	
	public void testCSVLoadAndParse() throws Exception {
		DecathlonChampionship out = null;
		try {
			out = this.fixture.getNext();
		} catch (Exception ex) {
			fail("Valid input should produce no exceptions");
		}
		DecathlonChampionship expectedResult = this.instantiateExpectedObject();
		int res = out.compareTo(expectedResult);
		assert(res == 0);
	}

}
