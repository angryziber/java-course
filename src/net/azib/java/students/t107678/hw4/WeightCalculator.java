package net.azib.java.students.t107678.hw4;

import net.azib.java.lessons.enums.Planet;
public class WeightCalculator {

    public static final double G = 9.81;
    public static void main(String[] args) {
        final double weight = 83.5;
		final double mass = weight / G;

        for (Planet p : Planet.values()) {
            System.out.println("My weight on " + p.name() + " is " + Math.round(p.surfaceWeight(mass)) + " kg");



        }
    }
}