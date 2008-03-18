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
	private BigInteger lastInput;
	
	public BinaryParser() {
		this(System.in);
	}
	
	public BinaryParser(InputStream in) {
		scanner = new Scanner(in);
		lastInput = new BigInteger("-1");
	}
/*	
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
*/
	public boolean processInput() {
		String thisString = scanner.next();
		if (thisString.equalsIgnoreCase("x"))
			return false;
		else if (thisString.matches("[0-1]+"))
			lastInput = new BigInteger(thisString, 2);
		else
			lastInput = BigInteger.valueOf(-1);
		return true;
	}
	
	public String getDecimal() {
		if (lastInput.equals(new BigInteger("-1")))
			return "Enter binary number!";
		else
			return lastInput.toString(10);
	}
	
	public String getHex() {
		if (lastInput.equals(new BigInteger("-1")))
			return "Enter binary number!";
		else
			return lastInput.toString(16);
	}
	
	public static void main(String[] args) {
		BinaryParser bp = new BinaryParser(System.in);
		System.out.print("Enter binary number (or 'x' to terminate): ");
		while (bp.processInput()) {
			System.out.println("Decimal: " + bp.getDecimal());
			System.out.println("Hex: " + bp.getHex());
			System.out.print("Enter binary number (or 'x' to terminate): ");
		}
	}
}