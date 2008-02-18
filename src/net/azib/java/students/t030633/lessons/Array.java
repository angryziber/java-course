package net.azib.java.students.t030633.lessons;

import java.util.Scanner;

/**
 * Counts letters in n strings.
 * 
 * @author t030633
 */
public class Array {

	public static void main(String[] args) {

		int n, len = 0;

		System.out.print("Enter n: ");
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();

		String[] stringArray = new String[n];

		for (int i = 0; i < n; i++) {
			stringArray[i] = scanner.next();
			len += stringArray[i].length();
		}

		// for(String string : stringArray){
		// System.out.print(string);
		// }

		System.out.print("Kokku on seal tähti: " + len);

	}

}
