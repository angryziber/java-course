package net.azib.java.students.t040719;

import java.util.Scanner;

/**
 * ArrayClass
 *
 * @author t040719
 */
public class ArrayClass {

	public static void main(String[] args) {
		System.out.println("Please enter n:");
		int n=0, len=0;
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		String[] s = new String[n];
		scanner.nextLine();
		for (int i = 0; i < n; i++){
			System.out.println("Please give me string nr " + (i+1) + ".");
			s[i] = scanner.nextLine();
			len += s[i].length();
		}
		System.out.println("Your entered:");
		for (String sb : s){
			System.out.println(": " + sb);
		}
		System.out.println("Altogether " + len + " characters were entered.");
	}
}
