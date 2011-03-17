package net.azib.java.students.t103640.enums;

import net.azib.java.lessons.enums.Planet;

public class WeightCalculator {
    public static void main(String[] args) {
          Planet[] planet = {
                  Planet.MERCURY,
                  Planet.VENUS,
                  Planet.EARTH,
                  Planet.MARS,
                  Planet.JUPITER,
                  Planet.SATURN,
                  Planet.URANUS,
                  Planet.NEPTUNE

          };
        double myGirlfriendsMass = 66;
        for(int i = 0; i<planet.length; i++)
        System.out.println("On planet " + planet[i] + " she weighs " + planet[i].surfaceWeight(myGirlfriendsMass) / 9.81 + " kg");
    }
}
