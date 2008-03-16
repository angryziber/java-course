package net.azib.java.students.t980814.lec5;

import java.io.InputStream;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * BinaryParser
 *
 * @author dell
 */
public class BinaryParser {

	private Scanner scanner;
	
	public BinaryParser(InputStream in) {
		scanner = new Scanner(in);
	}
	
	public boolean processInput() {
		String thisInput = scanner.next();
		if (thisInput.equalsIgnoreCase("x"))
			return false;
		else if (thisInput.matches("[0-1]+"))
		{
			BigInteger bigInt = new BigInteger(thisInput, 2);
			System.out.println("Decimal: " + bigInt);;
			System.out.println("Hex:     " + bigInt.toString(16));
			//System.out.println(Integer.parseInt(thisInput, 2));
		}
		else
			System.out.println("Not a binary number.");
		return true;
	}
	
	public static void main(String[] args) {
		BinaryParser bp = new BinaryParser(System.in);
		do {
			System.out.print("Enter binary number (or 'x' to terminate): ");
		}while (bp.processInput());
	}
}
