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
		int 	nofSymbol1 = 0;
		int 	nofSymbol2 = 0;
		int 	nofStrings;
		
		System.out.print("Enter n: ");
		nofStrings = scanner.nextInt();

		String[] words = new String[nofStrings];
		
		for (int i = 0; i < nofStrings; i++) {
			words[i] = scanner.next();
			
			nofSymbol1 += words[i].length();
		}
		
		for (String string : words) {
			nofSymbol2 += string.length();
		}
		System.out.println("No. of chars in chars1: " + nofSymbol1);
		System.out.println("No. of chars in chars2: " + nofSymbol2);
	}
}
