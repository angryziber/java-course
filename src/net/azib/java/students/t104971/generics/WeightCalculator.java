package net.azib.java.students.t104971.generics;

import net.azib.java.lessons.enums.Planet;

import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Jaroslav Judin
 */
public class WeightCalculator {

    private Map<Planet, BigDecimal> getCalculatedWeightOnAllPlanets(double weight) {
        Map<Planet, BigDecimal> result = new TreeMap<Planet, BigDecimal>();
        weight /= Planet.EARTH.surfaceGravity();
        for (Planet planet : Planet.values()) {
            result.put(planet, new BigDecimal(planet.surfaceWeight(weight)).setScale(2, BigDecimal.ROUND_HALF_EVEN));
        }
        return result;
    }


    public void printWeightOnAllPlanets(double weight) {
        for (Map.Entry<Planet, BigDecimal> e : getCalculatedWeightOnAllPlanets(weight).entrySet()) {
            System.out.println("Planet '" + e.getKey() + "' -> human weight: " + e.getValue());
        }
    }

    public static void main(String[] args) {
        new WeightCalculator().printWeightOnAllPlanets(80);
    }

}
