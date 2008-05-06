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

	private static int input_method;
	private static int output_method;
	private static int input_num;
	private static String input_route;
	private static String output_route;

	public static void main(String args[]) {
		command_line_parsing(args);
	}

	public static void command_line_parsing(String args[]) {
		int stage = 0;

		for (String s : args) {
			System.out.println(s);
			if (stage == 0) {
				if (s == "-console")
				{
					input_method = CONSOLE;
					stage = 2;
				}
				if (s == "-csv")
				{
					input_method = CSV;
					stage = 1;
				}
				if (s == "-db")
				{
					input_method = DB;
					stage = 1;
				}
			}
			if (stage == 1)
			{
				
			}
		}
	}
}
