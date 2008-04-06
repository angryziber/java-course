package net.azib.java.students.t040719.homework.io;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * InputParser - a class for handling data input of decathlon results
 *
 * @version 1.0
 * @author Romi Agar
 */
public class InputParser {

	private final PrintStream out;
	private final Scanner input;
	private InputMethod im;

	static final String NL = System.getProperty("line.separator");
	static final String INSTRUCTION_TEXT = "Please type:"+ NL + options(false) + "'x' to cancel.";
	static final String ERROR_TEXT = " is not valid input.";
	
	public InputParser(){
		this(new Scanner(System.in), System.out);
	}
	
	InputParser(Scanner input, PrintStream out){
		this.input = input;
		this.out = out;
		this.im = null;
	}
	
	static String options(boolean simple){
		String os = "";
		for(InputMethod inp : InputMethod.values()){
			if (!simple)
				os += "'" + inp + "' for " + inp.getSource() + " input" + NL;
			else
				os += inp;
		}
		return os;
	}
	
	public InputMethod processInput() {
		out.println(INSTRUCTION_TEXT);
		while (input.hasNext()) {
			if (input.hasNext("(?i)[" + options(true) + "]")) {
				this.im = InputMethod.valueOf(input.next().toUpperCase());
				break;
			}
			else if (input.hasNext("x")){
				break;
			}
			else {
				out.println("'" + input.next() + "'" + ERROR_TEXT);
			}
		}
		return this.im;
	}
	
}
