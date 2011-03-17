package net.azib.java.students.t103640.enums;

import net.azib.java.lessons.enums.Planet;

public class WeightCalculator {
    public static void main(String[] args) {
	    double myGirlfriendsMass = 66;
	    for (Planet planet : Planet.values())
		    System.out.println("On planet " + planet + " she weighs " + planet.surfaceWeight(myGirlfriendsMass) / 9.81 + " kg");
    }
}
