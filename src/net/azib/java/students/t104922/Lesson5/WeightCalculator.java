package net.azib.java.students.t104922.Lesson5;

import net.azib.java.lessons.enums.Planet;

public class WeightCalculator {
    public static void main(String[] args) {
        double myWeight = 65;
        for (Planet planet : Planet.values()){
            System.out.println("My weight on planet " + planet +  " is " + Math.round(planet.surfaceWeight(myWeight) / planet.EARTH.surfaceGravity()) + " kg");
        }
    }

}
