package net.azib.java.students.t072054.hometask1;

import java.io.*;

/**
 * Fibonacci
 * 
 * @author Roman
 */
public class Fibonacci {
	public static void main(String[] args) {
		int fibo_num = 0;
		long fibo_answer = 0;
		String string = "";

		System.out.println("Enter Fibonacci number index... ");

		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);
		try {

			string = reader.readLine();

		}
		catch (Exception e) {
		}
		
		fibo_num = Integer.parseInt(string);

		for (int i = 0; i <= fibo_num; i++) {
			fibo_answer += i;
		}

		System.out.println("The answer is: " + fibo_answer);
	}
}
