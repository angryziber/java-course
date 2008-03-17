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

	static final String WELCOME_TEXT = "Please enter binary numbers, 'x' to end";
	static final String ERROR_TEXT = " is not a binary number";
	
	private final PrintStream out;

	private final Scanner input;
	
	public BinaryParser() {
		this(new Scanner(System.in), System.out);
	}

	BinaryParser(Scanner input, PrintStream out) {
		this.input = input;
		this.out = out;
	}

	public void processInput() {
		out.println(WELCOME_TEXT);
		while (input.hasNext()) {
			if (input.hasNext("[01]+")) {
				int n = Integer.parseInt(input.next(), 2);
				out.println(n + " (0x" + Integer.toHexString(n).toUpperCase() + ")");
			}
			else if (input.hasNext("x")){
				break;
			}
			else {
				out.println("'" + input.next() + "'" + ERROR_TEXT);
			}
			
		}
	}
	
	public static void main(String[] args) {
		new BinaryParser().processInput();
	}
}
