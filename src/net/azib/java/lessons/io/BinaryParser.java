package net.azib.java.lessons.io;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * BinaryParser
 *
 * @author anton
 */
public class BinaryParser {
	private static final Pattern BIN = Pattern.compile("[0-1]+");
	private static final Pattern EXIT = Pattern.compile("[Xx]");
	
	static final String WELCOME_TEXT = "Enter numbers in binary for conversion, 'x' to end";
	static final String NOT_A_NUMBER_TEXT = " is not a binary number";
	
	private Scanner input;
	private PrintStream out;

	public BinaryParser() {
		this(new Scanner(System.in), System.out);
	}

	BinaryParser(Scanner scanner, PrintStream output) {
		this.input = scanner;
		this.out = output;
	}
	
	public void processInput() {
		out.println(WELCOME_TEXT);
		while (input.hasNext()) {
			if (input.hasNext(BIN)) {
				output(nextBin());
			}
			else if (input.hasNext(EXIT)) {
				input.next(EXIT);
				break;
			}
			else {
				error(input.next());
			}
		}
	}
	
	private int nextBin() {
		return Integer.parseInt(input.next(BIN), 2);
	}

	void output(int n) {
		out.println(Integer.toString(n) + " (0x" + Integer.toHexString(n) + ")");
	}
	
	void error(String s) {
		out.println("'" + s + "'" + NOT_A_NUMBER_TEXT);
	}
	
	public static void main(String[] args) {
		new BinaryParser().processInput();
	}
	
}
