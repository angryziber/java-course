package net.azib.java.students.t093759.hometasks.fourth;

import net.azib.java.lessons.enums.Planet;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 15.03.11 6:43
 *
 * @author Dionis
 */
public class WeightCalculator {
	/**
	 * Calculate person´s weight on all planets in our solar system.
	 *
	 * @param weightOnPlanetEarthKg Weight of a person on planet Earth.
	 * @return Weight of a person on all planets in our Solar system.
	 */
	public Map<Planet, Double> calculate(double weightOnPlanetEarthKg) {
		Map<Planet, Double> weightOnPlanets = new LinkedHashMap<Planet, Double>();

		for (Planet planet : Planet.values()) {
			weightOnPlanets.put(planet, planet.surfaceWeight(weightOnPlanetEarthKg / Planet.EARTH.surfaceGravity()));
		}

		return weightOnPlanets;
	}

	public static void main(String[] args) {
		double personsWeightKg = 100.0;
		for (Map.Entry<Planet, Double> weightOnPlanetEntry : new WeightCalculator().calculate(personsWeightKg).entrySet()) {
			System.out.println(weightOnPlanetEntry.getKey() + ": " + weightOnPlanetEntry.getValue());
		}
	}
}
