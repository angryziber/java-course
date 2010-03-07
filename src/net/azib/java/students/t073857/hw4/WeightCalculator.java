package net.azib.java.students.t073857.hw4;
import net.azib.java.lessons.enums.Planet;

import java.text.DecimalFormat;
import java.text.NumberFormat;
/**
 * WeightCalculator
 *
 * @author Joonas Vali
 */
public class WeightCalculator{
	public void printAllWeights(double mass){
		System.out.println("Outprint for mass "+mass+"kg");
		NumberFormat newtonFormat = new DecimalFormat("0.0N");		
		for(Planet p : Planet.values()){
			System.out.println("Planet "+p+" : "+newtonFormat.format(getWeight(mass, p)));
		}
	}
	
	public double getWeight(double mass, Planet planet){
		return planet.surfaceWeight(mass);
	}
}
