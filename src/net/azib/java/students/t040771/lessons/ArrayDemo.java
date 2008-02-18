package net.azib.java.students.t040771.lessons;

import java.util.Scanner;

/**
 * ArrayDemo
 *
 * @author t040771
 */
public class ArrayDemo {
	public static void main(String[] args) {
		int n;
		int len = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter n:");
		n = scanner.nextInt();
		String[] sArray = new String[n];
		for(int i=0;i<n;i++) {
			System.out.print("Enter string " + (i + 1) + ":");
			sArray[i] = scanner.next();
			len += sArray[i].length();
		}
		
		for(String a: sArray) {
			System.out.println(a);
		}
		
		System.out.println("Kokku massiivis " + len + " tähte");
	}
}
