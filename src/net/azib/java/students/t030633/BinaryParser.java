package net.azib.java.students.t030633;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * BinaryParser
 * 
 * @author t030633
 */
public class BinaryParser {

	private int number;
	private Scanner scanner;
	private Pattern pattern;

	public BinaryParser() {
		scanner = new Scanner(System.in);
		pattern = Pattern.compile("[0,1]*");
	}

	public BinaryParser(InputStream is) {
		scanner = new Scanner(is);
		pattern = Pattern.compile("[0,1]*");
	}

	public void readBinary() {
		if (!scanner.hasNext(pattern))
			throw new InputMismatchException(scanner.next());
		number = Integer.parseInt(scanner.next(pattern), 2);
	}

	public int getInteger() {
		return number;
	}

	public String getDecimalString() {
		return Integer.toString(number);
	}

	public String getHexString() {
		return Integer.toHexString(number);
	}

	public static void main(String[] args) {

		BinaryParser binParser = new BinaryParser();

		while (true) {

			System.out.print("Bin: ");

			try {
				binParser.readBinary();
				System.out.println("Dec: " + binParser.getDecimalString());
				System.out.println("Hex: " + binParser.getHexString());
			}
			catch (InputMismatchException e) {
				if (e.getMessage().compareTo("x") == 0)
					break;
				else
					System.out.println("Enter a binary number. (x to exit)");
			}

		}

	}

}
