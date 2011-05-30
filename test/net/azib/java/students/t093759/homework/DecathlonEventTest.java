package net.azib.java.students.t093759.homework;

import org.junit.Test;

import java.util.EnumMap;
import java.util.Map;

import static net.azib.java.students.t093759.homework.DecathlonEvent.*;
import static org.junit.Assert.assertEquals;

/**
 * @author dionis
 *         5/30/119:33 PM
 */
public class DecathlonEventTest {
	@Test
	public void resultsForThousandComputeExample() {
		for (Map.Entry<DecathlonEvent, Double> entry : mapWithBenchmarkFor1000PointsForEvent().entrySet()) {
			assertEquals(1000, entry.getKey().compute(entry.getValue()), 0);
		}
	}

	private Map<DecathlonEvent, Double> mapWithBenchmarkFor1000PointsForEvent() {
		Map<DecathlonEvent, Double> results = new EnumMap<DecathlonEvent, Double>(DecathlonEvent.class);
		results.put(ONE_HUNDRED_METER_SPRINT, 10.395);
		//results.put(LONG_JUMP, 7.76*100);//because in cm
		results.put(SHOT_PUT, 18.4);
//		results.put(HIGH_JUMP, 2.20*100);//because in cm
		results.put(FOUR_HUNDRED_METER_SPRINT, 46.17);
		results.put(ONE_HUNDRED_TEN_METER_HURDLES, 13.8);
		results.put(DISCUS_THROW, 56.17);
		results.put(POLE_VAULT, 5.28*100);//because in cm
		results.put(JAVELIN_THROW, 77.19);
		results.put(THOUSAND_FIVE_HUNDRED_METER_SPRINT, 233.79);
		return results;
	}
}
