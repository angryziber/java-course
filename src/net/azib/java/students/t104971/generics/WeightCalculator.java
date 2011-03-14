package net.azib.java.students.t104971.generics;

import net.azib.java.lessons.enums.Planet;

import java.math.BigDecimal;

/**
 * @author Jaroslav Judin
 */
public class WeightCalculator {

    public void calculateWeight(double weight) {
        weight /= Planet.EARTH.surfaceGravity();
        for (Planet planet : Planet.values()) {
            System.out.println("Planet '" + planet + "' -> human weight: "
                    + new BigDecimal(planet.surfaceWeight(weight)).setScale(2, BigDecimal.ROUND_HALF_EVEN));
        }
    }

    public static void main(String[] args) {
        new WeightCalculator().calculateWeight(80);
    }

}
