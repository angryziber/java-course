package net.azib.java.students.t040750.lesson6;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * BinaryParser
 *
 * @author t040750
 */
public class BinaryParser {
	
	public static final String WELCOME_TEXT = "Please enter binary numbers, 'x' to end\n";
	
	private final PrintStream out;
	
	private final Scanner input;
	
	public BinaryParser(Scanner input, PrintStream out) {
		this.out = out;
		this.input = input;
	}
	
	public void processInput() {
		out.println(WELCOME_TEXT);
	}
}
