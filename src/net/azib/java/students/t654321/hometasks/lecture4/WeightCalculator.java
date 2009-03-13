/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.azib.java.students.t654321.hometasks.lecture4;

import net.azib.java.lessons.enums.Planet;

/**
 *
 * @author karlb
 */
public class WeightCalculator {

    public static void main(String... args) {

        float weightOnEarth = 90f;
        String name = "Karl";

        for (Planet planet : Planet.values()) {
            System.out.println(planet.surfaceWeightAsString(name, weightOnEarth));
        }
    }
}
