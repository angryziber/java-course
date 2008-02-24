package net.azib.java.students.t072073.lessons;

import java.util.Scanner;

/**
 * MyArray
 *
 * @author t072073
 */
public class MyArray {
	public static void main(String[] args) {
		System.out.println("Sisesta number:");
		Scanner scanner = new Scanner(System.in);
		int i = scanner.nextInt();
		String [] yourInput = new String [i];
		int result = 0;
		for (int a = 0; a < i; a++ ){
			System.out.println("Sisesta " + (a+1) + ". string.");
			yourInput[a] = scanner.next();		
		}		
		
		//for each
		for (String a : yourInput){
			result += a.length();
		}
		System.out.println(result);
		
		
	}

}
