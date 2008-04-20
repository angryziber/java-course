package net.azib.java.students.t072054.hometask1;

import net.azib.java.lessons.enums.Planet;
import java.io.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * WeightCalculator
 * 
 * @author Roman
 */
public class WeightCalculator {
	public static void main(String[] args) {
		Planet pl;
		String string = "";
		int weight;

		System.out.println("Enter your weight...");

		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);

		try {

			string = reader.readLine();

		}
		catch (Exception e) {
		}
		weight = Integer.parseInt(string);
		
	}

}
