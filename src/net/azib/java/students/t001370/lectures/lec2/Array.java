package net.azib.java.students.t001370.lectures.lec2;

import java.util.Scanner;

/**
 * Array
 *
 * @author t001370
 */
public class Array {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int 	nofSymbol = 0;
		int 	nofStrings;
		
		System.out.print("Enter n: ");
		nofStrings = scanner.nextInt();
		
		for (int i = 0; i < nofStrings; i++) {
			nofSymbol += scanner.next().length();
		}
		System.out.println("No. of chars in strings: " + nofSymbol);
	}
}
