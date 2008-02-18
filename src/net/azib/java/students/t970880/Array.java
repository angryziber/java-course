package net.azib.java.students.t970880;

import java.util.Scanner;

/**
 * Array
 *
 * @author vvj
 */
public class Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
		System.out.println("enter int:");
		Scanner scanner = new Scanner (System.in);
		int i = scanner.nextInt(10);
		System.out.println("you entered " + i);
		String[] strArray = new String[i];
		int kokku = 0;
		int k = 0;
		for (String s1 : strArray){
			
			System.out.println("enter string number " + k++);
			s1 = scanner.next();
			kokku += s1.length();
		}
		System.out.println("kokku = " + kokku);
	}

}
