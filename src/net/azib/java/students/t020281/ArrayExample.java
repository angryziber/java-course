package net.azib.java.students.t020281;

import java.util.Scanner;


/**
 * ArrayExample
 *
 * @author Trial
 */
public class ArrayExample {
	
	public static void main(String[] args) {
		System.out.print("Please insert number of words: ");
		Scanner scanner = new Scanner (System.in);
		int i = scanner.nextInt(10);
		String[] s = new String[i];
		int sum = 0;
		for (int j = 0; j < s.length; j++) {
			System.out.println(j+" word: ");
			s[j]= scanner.next();
		}
		
		for (String s1 : s){
			sum = sum + s1.length();
		}
			
		System.out.println("All words lenghts sum is "+sum);
	}
	
}
