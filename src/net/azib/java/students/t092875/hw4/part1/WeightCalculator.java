package net.azib.java.students.t092875.hw4.part1;

import net.azib.java.lessons.enums.Planet;

/**
 * WeightCalculator
 *
 * @author Mihhail
 */
public class WeightCalculator {
	public static void main(String[] args) {
		new WeightCalculator().getWeightOnDiffrentPlanets(70);
	} 
	
	public void getWeightOnDiffrentPlanets(int weight){
		for(Planet planet: Planet.values()){
			planet.surfaceWeight(weight);
			System.out.println("On planet "+planet.name()+" the surface wight of "+
					weight+" KG is "+planet.surfaceWeight(weight)+ " KG"
			);
		}
	}
}
