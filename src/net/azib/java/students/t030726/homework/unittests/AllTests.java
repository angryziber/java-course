package net.azib.java.students.t030726.homework.unittests;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * AllTests
 *
 * @author NTAdmin
 */
public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for net.azib.java.students.t030726.homework.unittests");
		//$JUnit-BEGIN$
		suite.addTestSuite(FifteenHundredMeterRunEventTest.class);
		suite.addTestSuite(GenericDecathlonEventTest.class);
		suite.addTestSuite(HighJumpEventTest.class);
		suite.addTestSuite(FourHundredMeterSprintTest.class);
		suite.addTestSuite(DiscusThrowEventTest.class);
		suite.addTestSuite(HundredAndTenMeterHurdlesEventTest.class);
		suite.addTestSuite(JavelinThrowEventTest.class);
		suite.addTestSuite(RunnerDecathlonEventTest.class);
		suite.addTestSuite(HundredMeterSprintTest.class);
		suite.addTestSuite(LongJumpEventTest.class);
		suite.addTestSuite(ShotPutEventTest.class);
		suite.addTestSuite(FieldDecathlonEventTest.class);
		suite.addTestSuite(PoleVaultEventTest.class);
		suite.addTestSuite(DecathlonChampionshipParticipatorTest.class);
		suite.addTestSuite(DecathlonChampionshipTest.class);
		//$JUnit-END$
		return suite;
	}

}
