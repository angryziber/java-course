package net.azib.java.students.t020632;


import java.util.Scanner;

/**
 * BinaryParser
 *
 * @author Marek
 */
public class BinaryParser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int number;
		String s;
		
		while(true){
			
			System.out.println("Sisestage kahendarv");
			
			try{
				number = scanner.nextInt(2);
				s = Integer.toHexString(number);
			}
			catch(Exception e){ break;}
		
			System.out.println("Kümnendarv: " + number + ", hex: " + s);
		}
		
		System.out.println("Finished!");

	}

}
