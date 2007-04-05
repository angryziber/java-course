package net.azib.java.students.t020544;

import java.io.InputStream;
import java.util.Scanner;

/**
 * BinaryParser
 * 
 * A BinaryParser interactive console program, which uses java.util.Scanner for
 * parsing of binary numbers coming from the standard input, displaying them in
 * decimal and hexadecimal formats. 'x' ends the program.
 * 
 * @author Julija
 */
public class BinaryParser {

	public static void main(String[] args) {
		InputStream in = System.in;
		Scanner scanner = new Scanner(in);

		displayNumber(scanner);

	}

	/**
	 * @param scanner
	 */
	private static void displayNumber(Scanner scanner) {
		try {
			System.out.println("Enter binary number or x to end the program: ");
			while (!scanner.hasNext("x")) {
				
				int decimalNumber = scanner.useRadix(2).nextInt();

				System.out.println("Decimal: " + decimalNumber);
				System.out.println("Hexadecimal: " + Integer.toHexString(decimalNumber));
				
				System.out.println();
				System.out.println("Enter number: ");
			}
			System.out.println("Bye");
		}
		catch (Exception e) {
			System.out.println("Wrong format ");
		}

	}

}