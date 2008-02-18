package net.azib.java.students.t040750;

import java.util.Scanner;

/**
 * Array
 *
 * @author t040750
 */
public class ArrayDemo {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input;
		int i = 0, n, charCount = 0;
			
			while(true) {
				System.out.print("Sisesta n: ");
				input = scanner.next(); //kui jadas on space, siis loeb mitme sisendina
					
					if(validInt(input)) {
						n = Integer.parseInt(input);
						break;
					}
					
				System.out.println("Vigane sisend. Proovi uuesti!");
			}
			
			String[] inputArray = new String[n];
			
			while(i < n) {
				System.out.print("Sisesta " + (i + 1) + ". sisend: ");
				inputArray[i] = scanner.next();
				
				//charCount += inputArray[i].length();
				i++;
			}
			
			int[] inputArray2 = new int[n];
			int charCount2 = 0;
			
			for (int j:inputArray2) {	//For-each loop
				charCount2 += inputArray2[j];
			}
		
		System.out.println("Sisestatud tähemärkide arv oli: " + charCount);
		
	}
	
	/*
	 * Check if String can be converted to int and whether it is not negative
	*/
	private static boolean validInt(String input) {
		try {
			if(Integer.parseInt(input) < 0) {
				return false;
			}
			
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
}
