package net.azib.java.students.t103758;

import net.azib.java.lessons.enums.Planet;

public class WeightCalculator {


  public static void main (String[] args) {
    
    //Planet planet = null;
    double someonesWeight = 80; //kg
    
    for (Planet planet : Planet.values()) {
      //planet.surfaceWeight(someonesWeight) / 10;
      System.out.println("Someones weight on " + planet + ": "+ planet.surfaceWeight(someonesWeight) / 9.807 + " kg");
    }
  }
}
