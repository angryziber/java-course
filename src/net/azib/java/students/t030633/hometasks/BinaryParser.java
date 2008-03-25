package net.azib.java.students.t030633.hometasks;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * BinaryParser
 * 
 * @author t030633
 */
public class BinaryParser {

	static final String INIT_MESSAGE = "Binary Parser. (x to exit)";
	static final String ESCAPE = "x";
	static final String BINARY = "[01]+";
	private final Scanner in;
	private final PrintStream out;

	public BinaryParser() {
		this(new Scanner(System.in), System.out);
	}

	public BinaryParser(Scanner scanner, PrintStream printStream) {
		this.in = scanner;
		this.out = printStream;
	}

	public void parse() {
		out.println(INIT_MESSAGE);
		while (in.hasNext()) {
			if (in.hasNext(BINARY)) {
				int number = Integer.parseInt(in.next(BINARY), 2);
				out.println(number + " (0x" + Integer.toHexString(number).toUpperCase() + ")");
			}
			else if (in.hasNext(ESCAPE)) {
				in.next();
				break;
			}
			else
				out.println(in.next() + " is not a binary number.");
		}
	}

	public static void main(String[] args) {
		new BinaryParser().parse();
	}

}
