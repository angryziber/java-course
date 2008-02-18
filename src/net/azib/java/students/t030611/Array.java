package net.azib.java.students.t030611;

import java.util.Scanner;



/**
 * Array
 * 
 * @author t030611
 */
public class Array {
	public static void main(String[] args) {
		int n;
		int charNum=0;
		String[] array;
		System.out.println("Enter number+: ");
		Scanner scanner= new Scanner(System.in);
		n=scanner.nextInt();
		array=new String[n];
		for(int i=0; i<n; i++){
			System.out.println("Enter "+(i+1)+" string");
			array[i]=scanner.next();
		}
		for(String s: array){
			charNum+=s.length();
		}
		System.out.println("Where were "+charNum+" symbols");
	}
}
