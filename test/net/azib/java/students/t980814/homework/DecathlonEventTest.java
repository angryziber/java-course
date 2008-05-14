package net.azib.java.students.t980814.homework;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * DecathlonEventTest
 *
 * @author dell
 */
public class DecathlonEventTest {

	private final String[] DECATHLON_EVENTS = {
		"race_100m",
		"long_jump",
		"shot_put",
		"high_jump",
		"race_400m",
		"hurdles_110m",
		"discus_throw",
		"pole_vault",
		"javelin_throw",
		"race_1500m"
	};
	
	@Test
	public void testGetAllKeys() {
		assertArrayEquals("The decathlon event keys in DecathlonEvent enum are not correct",
						  DECATHLON_EVENTS, DecathlonEvent.getAllKeys());
	}
	
	@Test
	public void testGetEventByKeyRace100m() {
		DecathlonEvent event = DecathlonEvent.getDecathlonEventByKey(DECATHLON_EVENTS[0]);
		assertEquals("Decathlon event enum didn't give the RACE_100M",
					 DecathlonEvent.RACE_100M,
					 event);
		assertEquals("The hasNext() output is not correct", true, event.hasNext()); 

		assertEquals("The next() is not working correctly",
					 DecathlonEvent.LONG_JUMP,
					 event.next()); 
	}

	@Test
	public void testGetEventByKeyLongJump() {
		DecathlonEvent event = DecathlonEvent.getDecathlonEventByKey(DECATHLON_EVENTS[1]);
		assertEquals("Decathlon event enum didn't give the LONG_JUMP",
				 DecathlonEvent.LONG_JUMP,
				 event);
		assertEquals("The hasNext() output is not correct", true, event.hasNext()); 

		assertEquals("The next() is not working correctly",
				 DecathlonEvent.SHOT_PUT,
				 event.next()); 
	}
	
	@Test
	public void testGetEventByKeyShotPut() {
		DecathlonEvent event = DecathlonEvent.getDecathlonEventByKey(DECATHLON_EVENTS[2]);
		assertEquals("Decathlon event enum didn't give the SHOT_PUT",
				 DecathlonEvent.SHOT_PUT,
				 event);
		assertEquals("The hasNext() output is not correct", true, event.hasNext()); 

		assertEquals("The next() is not working correctly",
				 DecathlonEvent.HIGH_JUMP,
				 event.next()); 
	}
	
	@Test
	public void testGetEventByKeyHighJump() {
		DecathlonEvent event = DecathlonEvent.getDecathlonEventByKey(DECATHLON_EVENTS[3]);
		assertEquals("Decathlon event enum didn't give the HIGH_JUMP",
				 DecathlonEvent.HIGH_JUMP,
				 event);
		assertEquals("The hasNext() output is not correct", true, event.hasNext()); 

		assertEquals("The next() is not working correctly",
				 DecathlonEvent.RACE_400M,
				 event.next()); 
	}

	@Test
	public void testGetEventByKeyRace400m() {
		DecathlonEvent event = DecathlonEvent.getDecathlonEventByKey(DECATHLON_EVENTS[4]);
		assertEquals("Decathlon event enum didn't give the RACE_400M",
				 DecathlonEvent.RACE_400M,
				 event);
		assertEquals("The hasNext() output is not correct", true, event.hasNext()); 

		assertEquals("The next() is not working correctly",
				 DecathlonEvent.HURDLES_110M,
				 event.next()); 
	}
	
	@Test
	public void testGetEventByKeyHurdles110m() {
		DecathlonEvent event = DecathlonEvent.getDecathlonEventByKey(DECATHLON_EVENTS[5]);
		assertEquals("Decathlon event enum didn't give the HURDLES_110M",
				 DecathlonEvent.HURDLES_110M,
				 event);
		assertEquals("The hasNext() output is not correct", true, event.hasNext()); 

		assertEquals("The next() is not working correctly",
				 DecathlonEvent.DISCUS_THROW,
				 event.next()); 
	}
	
	@Test
	public void testGetEventByKeyDiscusThrow() {
		DecathlonEvent event = DecathlonEvent.getDecathlonEventByKey(DECATHLON_EVENTS[6]);
		assertEquals("Decathlon event enum didn't give the DISCUS_THROW",
				 DecathlonEvent.DISCUS_THROW,
				 event);
		assertEquals("The hasNext() output is not correct", true, event.hasNext()); 

		assertEquals("The next() is not working correctly",
				 DecathlonEvent.POLE_VAULT,
				 event.next()); 
	}
	
	@Test
	public void testGetEventByKeyPoleVault() {
		DecathlonEvent event = DecathlonEvent.getDecathlonEventByKey(DECATHLON_EVENTS[7]);
		assertEquals("Decathlon event enum didn't give the POLE_VAULT",
				 DecathlonEvent.POLE_VAULT,
				 event);
		assertEquals("The hasNext() output is not correct", true, event.hasNext()); 

		assertEquals("The next() is not working correctly",
				 DecathlonEvent.JAVELIN_THROW,
				 event.next()); 
	}

	@Test
	public void testGetEventByKeyJavelinThrow() {
		DecathlonEvent event = DecathlonEvent.getDecathlonEventByKey(DECATHLON_EVENTS[8]);
		assertEquals("Decathlon event enum didn't give the JAVELIN_THROW",
				 DecathlonEvent.JAVELIN_THROW,
				 event);
		assertEquals("The hasNext() output is not correct", true, event.hasNext()); 

		assertEquals("The next() is not working correctly",
				 DecathlonEvent.RACE_1500M,
				 event.next()); 
	}

	@Test
	public void testGetEventByKeyRace1500m() {
		DecathlonEvent event = DecathlonEvent.getDecathlonEventByKey(DECATHLON_EVENTS[9]);
		assertEquals("Decathlon event enum didn't give the RACE_1500M",
				 DecathlonEvent.RACE_1500M,
				 event);
		assertEquals("The hasNext() output is not correct", false, event.hasNext()); 
	}

	@Test
	public void testPointsCalculationRace100m() {
		assertEquals("Calculation of race 100m points (0) is incorrect",
					 0, DecathlonEvent.RACE_100M.calcPoints(18.0));
		assertEquals("Calculation of race 100m points (11.0) is incorrect",
				 861, DecathlonEvent.RACE_100M.calcPoints(11.0));
	}

	@Test
	public void testPointsCalculationLongJump() {
		assertEquals("Calculation of long jump points (0) is incorrect",
					 0, DecathlonEvent.LONG_JUMP.calcPoints(2.20));
		assertEquals("Calculation of long jump points (7.30) is incorrect",
				 886, DecathlonEvent.LONG_JUMP.calcPoints(7.30));
	}

	@Test
	public void testPointsCalculationShotPut() {
		assertEquals("Calculation of shot put points (0) is incorrect",
					 0, DecathlonEvent.SHOT_PUT.calcPoints(1.50));
		assertEquals("Calculation of shot put points (15.25) is incorrect",
				 805, DecathlonEvent.SHOT_PUT.calcPoints(15.25));
	}

	@Test
	public void testPointsCalculationHighJump() {
		assertEquals("Calculation of high jump points (0) is incorrect",
					 0, DecathlonEvent.HIGH_JUMP.calcPoints(0.75));
		assertEquals("Calculation of high jump points (15.25) is incorrect",
				 803, DecathlonEvent.HIGH_JUMP.calcPoints(2.00));
	}

	@Test
	public void testPointsCalculationRace400m() {
		assertEquals("Calculation of race 400m points (0) is incorrect",
					 0, DecathlonEvent.RACE_400M.calcPoints(90.0));
		assertEquals("Calculation of race 400m points (55.00s) is incorrect",
				 599, DecathlonEvent.RACE_400M.calcPoints(55.00));
	}

	@Test
	public void testPointsCalculationHurdles110m() {
		assertEquals("Calculation of hurdles 110m points (0) is incorrect",
					 0, DecathlonEvent.HURDLES_110M.calcPoints(29.0));
		assertEquals("Calculation of hurdles 110m points (16.20) is incorrect",
				 710, DecathlonEvent.HURDLES_110M.calcPoints(16.20));
	}

	@Test
	public void testPointsCalculationDiscusThrow() {
		assertEquals("Calculation of discus throw points (0) is incorrect",
					 0, DecathlonEvent.DISCUS_THROW.calcPoints(4.0));
		assertEquals("Calculation of discus throw points (45.99) is incorrect",
				 787, DecathlonEvent.DISCUS_THROW.calcPoints(45.99));
	}

	@Test
	public void testPointsCalculationPoleVault() {
		assertEquals("Calculation of pole vault points (0) is incorrect",
					 0, DecathlonEvent.POLE_VAULT.calcPoints(1.0));
		assertEquals("Calculation of pole vault points (4.95) is incorrect",
				 895, DecathlonEvent.POLE_VAULT.calcPoints(4.95));
	}

	@Test
	public void testPointsCalculationJavelinThrow() {
		assertEquals("Calculation of javelin throw points (0) is incorrect",
					 0, DecathlonEvent.JAVELIN_THROW.calcPoints(7.0));
		assertEquals("Calculation of javelin throw points (64.95) is incorrect",
				 813, DecathlonEvent.JAVELIN_THROW.calcPoints(64.95));
	}

	@Test
	public void testPointsCalculationRace1500m() {
		assertEquals("Calculation of race 1500m points (0) is incorrect",
					 0, DecathlonEvent.RACE_1500M.calcPoints(480.0));
		assertEquals("Calculation of race 1500m points (4:25:0) is incorrect",
				 778, DecathlonEvent.RACE_1500M.calcPoints(265.0));
	}
}
