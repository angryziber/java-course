package net.azib.java.students.t654321;

import java.util.Scanner;

/**
 * Lecture2
 *
 * @author t999902
 */
public class Lecture2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int i = 1;
		int numberOfCharacters = 0;
		System.out.println("Enter number of strings");
		int n = scanner.nextInt();
		while(i < n + 1){
			System.out.println("Enter string nr." + i);
			String str = scanner.next();
			char[] characterArray = str.toCharArray();
			int len = 0;
			for (char chr : characterArray){
				System.out.println("Character " + chr);
				len++;
			}
			numberOfCharacters = numberOfCharacters + len;
			i++;
		}
		System.out.println("Entered " + numberOfCharacters + " characters");
	}
}
