package net.azib.java.students.t100224.homework.model;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static net.azib.java.students.t100224.homework.model.Decathlon.countPoints;
import static org.junit.Assert.assertEquals;


public class DecathlonTest {

	private Map<String, Float> performances = new HashMap<String, Float>();

	@Test
	public void eachPerformanceGets700Points() {

		performances.put("race_100m", 11.756f);
		performances.put("long_jump", 6.51f * 100);
		performances.put("shot_put", 13.53f);
		//  performances.put("high_jump", 1.88f * 100);
		performances.put("race_400m", 52.58f);
		performances.put("hurdles_110m", 16.29f);
		performances.put("discus_throw", 41.72f);
		//	performances.put("pole_vault", 4.29f * 100);
		performances.put("javelin_throw", 57.45f);
		performances.put("race_1500m", 276.96f);

		for (Map.Entry<String, Float> map : performances.entrySet()) {
			assertEquals(countPoints(map.getKey(), map.getValue()), 700);
		}
	}

	@Test
	public void eachPerformanceGets800Points() {

		performances.put("race_100m", 11.278f);
		performances.put("long_jump", 6.941f * 100);
		performances.put("shot_put", 15.16f);
		//	performances.put("high_jump", 1.99f * 100);
		performances.put("race_400m", 50.32f);
		performances.put("hurdles_110m", 15.419f);
		performances.put("discus_throw", 46.59f);
		//	performances.put("pole_vault", 4.63f * 100);
		performances.put("javelin_throw", 64.09f);
		performances.put("race_1500m", 261.77f);

		for (Map.Entry<String, Float> map : performances.entrySet()) {
			assertEquals(countPoints(map.getKey(), map.getValue()), 800);
		}
	}
}