package net.azib.java.students.t072054.homework;

/**
 * DecathlonCalculator
 * 
 * @author r_vassiljev
 */
public class DecathlonCalculator {
	// Input/output methods
	public static final int CONSOLE = 1;
	public static final int CSV = 2;
	public static final int DB = 3;
	public static final int XML = 4;
	public static final int HTML = 5;

	// Stages of parsing file
	public static final int INPUT_METHOD = 0;
	public static final int INPUT_STRING = 1;
	public static final int INPUT_INTEGER = 2;
	public static final int OUTPUT_METHOD = 3;
	public static final int OUTPUT_STRING = 4;
	public static final int PARSE_FINISHED = 5;

	private static int input_method;
	private static int output_method;
	private static int input_num;
	private static String input_route;
	private static String output_route;

	public static void main(String args[]) {
		CommandLineParsing(args);
	}

	public static String CommandLineParsing(String args[]) {
		int stage = INPUT_METHOD;
		String return_value;
		
		// Initialization of static members
		input_route = null;
		output_route = null;
		input_method = 0;
		output_method = 0;
		input_num = 0;

		for (String s : args) {
			//System.out.println(s);
			if (stage == INPUT_METHOD) {
				if (s.equals("-console")) {
					input_method = CONSOLE;
					stage = OUTPUT_METHOD;
				}
				else if (s.equals("-csv")) {
					input_method = CSV;
					stage = INPUT_STRING;
				}
				else if (s.equals("-db")) {
					input_method = DB;
					stage = INPUT_INTEGER;
				}
			}
			else if (stage == INPUT_STRING) {
				input_route = s;
				stage = OUTPUT_METHOD;
			}
			else if (stage == INPUT_INTEGER) {
				char first_letter;

				first_letter = s.charAt(0);
				input_num = first_letter - 48;
				stage = OUTPUT_METHOD;
			}
			else if (stage == OUTPUT_METHOD) {
				if (s.equals("-console")) {
					output_method = CONSOLE;
					stage = OUTPUT_STRING;
				}
				else if (s.equals("-csv")) {
					output_method = CSV;
					stage = OUTPUT_STRING;
				}
				else if (s.equals("-xml")) {
					output_method = XML;
					stage = OUTPUT_STRING;
				}
				else if (s.equals("-html")) {
					output_method = HTML;
					stage = OUTPUT_STRING;
				}
			}
			else if (stage == OUTPUT_STRING) {
				output_route = s;
				stage = PARSE_FINISHED;
			}
		}
		
		// DEBUG output
		//System.out.println("Input route = " + input_route);
		//System.out.println("Output route = " + output_route);
		
		return_value = input_route + " " + output_route + " " + input_method + " " + output_method + " " + input_num;
		
		return return_value;
	}
}
