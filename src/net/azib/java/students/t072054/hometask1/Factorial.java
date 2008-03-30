package net.azib.java.students.t072054.hometask1;

import java.io.*;

/**
 * Factorial
 * 
 * @author Roman
 */
public class Factorial {
	public static void main(String[] args) {
		double fact_answer = 1;
		double fact_num = 0;
		String string = "";

		System.out.println("Enter factorial number ... ");

		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);
		try {

			string = reader.readLine();

		}
		catch (Exception e) {
		}

		fact_num = Integer.parseInt(string);

		for (int i = 1; i <= fact_num; i++) {
			fact_answer = fact_answer * (i);
		}

		System.out.println("The answer is: " + fact_answer);
	}
}
