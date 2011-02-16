package net.azib.java.students.t092861.lecture2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * @author Stanislav / 092861
 * 
 */
public class NumbersDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();
		Factorial factorial = new Factorial();
		DecimalFormat df = new DecimalFormat("#,###");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numberFi, numberFa = 0;
		try {
			System.out
					.print("Please enter the last index of Fibonacci sequence: ");
			String lineFi = br.readLine();
			numberFi = Integer.parseInt(lineFi);
			System.out.println("Fibonacci F" + numberFi + "= "
					+ df.format(fibonacci.generate(numberFi)));

			System.out
					.print("Please enter the last index of Factorial sequence: ");
			String lineFa = br.readLine();
			numberFa = Integer.parseInt(lineFa);
			System.out.println("Factorial F" + numberFa + "= "
					+ df.format(factorial.generate(numberFa)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Error: " + e.getMessage());
			System.out.println("I/O error occurs. Cannot read the number!");
		}
		catch (NumberFormatException en) {
			// TODO Auto-generated catch block
			System.err.println("Error: " + en.getMessage());
			System.out.println("You must enter only numbers!");
		}

	}
}
