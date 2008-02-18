package net.azib.java.students.t980814.lec2;

import java.util.Scanner;

/**
 * Array
 *
 * @author t980814
 */
public class Array {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n;
		int numberOfCharacters = 0;
		String[] words;
		
		System.out.println("Enter n:");
		n = scanner.nextInt();
		words = new String[n];
		for (int i = 0; i < n; i++)
		{
			System.out.println("Enter " + (i+1) + ". word:");
			words[i] = scanner.next();		
			numberOfCharacters += words[i].length();
		}
		
		System.out.println(words.length + " words and " + numberOfCharacters + " letters were entered.");
	}
}
