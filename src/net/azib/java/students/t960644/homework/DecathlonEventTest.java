package net.azib.java.students.t960644.homework;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 * DecathlonEventTest
 *
 * @author Lembit
 */
public class DecathlonEventTest {
	
	@Test
	public void testForZero() throws Exception {
		assertEquals(DecathlonEvent.RACE_100M.eventScore(0.0),0);
		assertEquals(DecathlonEvent.RACE_100M.eventScore(18.0),0);
		assertEquals(DecathlonEvent.LONG_JUMP.eventScore(2.20),0);
		assertEquals(DecathlonEvent.SHOT_PUT.eventScore(1.5),0);
		assertEquals(DecathlonEvent.HIGH_JUMP.eventScore(0.75),0);
		assertEquals(DecathlonEvent.RACE_400M.eventScore(82),0);
		assertEquals(DecathlonEvent.HURDLES_110M.eventScore(28.5),0);
		assertEquals(DecathlonEvent.DISCUS_THROW.eventScore(4.0),0);
		assertEquals(DecathlonEvent.POLE_VAULT.eventScore(1.0),0);
		assertEquals(DecathlonEvent.JAVELIN_THROW.eventScore(7.0),0);
		assertEquals(DecathlonEvent.RACE_1500M.eventScore(480.0),0);
	}
	
	@Test
	public void testForScore() throws Exception {
		assertEquals(DecathlonEvent.RACE_100M.eventScore(11.33),789);
		assertEquals(DecathlonEvent.LONG_JUMP.eventScore(7.18),857);
		assertEquals(DecathlonEvent.SHOT_PUT.eventScore(13.49),697);
		assertEquals(DecathlonEvent.HIGH_JUMP.eventScore(1.94),749);
		assertEquals(DecathlonEvent.RACE_400M.eventScore(50.19),806);
		assertEquals(DecathlonEvent.HURDLES_110M.eventScore(15.17),829);
		assertEquals(DecathlonEvent.DISCUS_THROW.eventScore(43.76),741);
		assertEquals(DecathlonEvent.POLE_VAULT.eventScore(4.5),760);
		assertEquals(DecathlonEvent.JAVELIN_THROW.eventScore(60.84),750);
		assertEquals(DecathlonEvent.RACE_1500M.eventScore(277.86),694);
	}
	@Test
	public void testResultFormat() throws Exception {
		assertEquals(DecathlonEvent.RACE_100M.eventResultFormat(15.2),"15.200");
		assertEquals(DecathlonEvent.RACE_1500M.eventResultFormat(361.9),"6:01.900");
		assertEquals(DecathlonEvent.JAVELIN_THROW.eventResultFormat(62),"62.00");
	}

}
