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
        double MyGirlfriendsMass = 66;
        for(int i = 0; i<8; i++)
        System.out.println("On planet " + planet[i] + " she weighs " + planet[i].surfaceWeight(MyGirlfriendsMass) / 9.81 + " kg");
    }
}
