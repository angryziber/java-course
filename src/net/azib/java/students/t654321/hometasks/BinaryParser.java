package net.azib.java.students.t654321.hometasks;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * BinaryParser
 * 
 * @author Karl
 */
public class BinaryParser {

	public String WELCOME_TEXT = "Please enter binary number, x to end";
	public String ERROR_TEXT = "Is not binary number";

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
			else if (input.hasNext("x")) {
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
