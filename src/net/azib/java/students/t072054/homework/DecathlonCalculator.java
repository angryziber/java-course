package net.azib.java.students.t072054.homework;

import java.util.ArrayList;
import java.util.Map;

import java.util.LinkedHashMap;

/**
 * DecathlonCalculator
 * 
 * @author r_vassiljev
 */

public class DecathlonCalculator {
	// Input/output methods
	private static final int CONSOLE = 1;
	private static final int CSV = 2;
	private static final int DB = 3;
	private static final int XML = 4;
	private static final int HTML = 5;

	// Stages of parsing file
	private static final int INPUT_METHOD = 0;
	private static final int INPUT_STRING = 1;
	private static final int INPUT_INTEGER = 2;
	private static final int OUTPUT_METHOD = 3;
	private static final int OUTPUT_STRING = 4;
	private static final int PARSE_FINISHED = 5;

	private static int input_method;
	private static int output_method;
	private static String input_string;
	private static int input_num;
	private static String input_route;
	private static String output_route;

	/**
	 * Starting point of application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		Map<Integer, String[]> result_map1 = new LinkedHashMap<Integer, String[]>();
		Map<Integer, String[]> result_map2 = new LinkedHashMap<Integer, String[]>();
		Map<Integer, String[]> result_map3 = new LinkedHashMap<Integer, String[]>();

		// Initial value
		input_num = 1;

		ResultShower res_show = new ShowResults();

		LoadNewResults lnr = new LoadNewResults();

		ArrayList<Integer> results_array = new ArrayList<Integer>();

		commandLineParsing(args);

		switch (input_method) {
		case DB:
			lnr.loadResultsDB(result_map1, result_map2, result_map3);
			break;
		case CSV:
			lnr.loadResultsCSV(result_map1, result_map2, result_map3, input_route);
			break;
		case CONSOLE:
			lnr.loadResultsConsole(result_map1, result_map2, result_map3);
			break;
		}

		// Check for name of competition
		try {
			if (input_method == DB) {
				input_num = getEventID(result_map2, input_string);
				if (input_num == -1)
					input_num = Integer.valueOf(input_string);
			}
		}
		catch (Exception e) {
			System.out.println("Competition name not found exception");
		}

		switch (output_method) {
		case CONSOLE:
			if (input_num == 0)
				input_num = 1;
			results_array = SortingID.SortByID(result_map1, result_map2, result_map3, input_num);
			if (input_num == 0)
				input_num = 1;
			res_show.ShowResultsConsole(result_map1, result_map2, result_map3, results_array, input_num);
			break;
		case XML:
			if (input_num == 0)
				input_num = 1;
			results_array = SortingID.SortByID(result_map1, result_map2, result_map3, input_num);
			if (input_num == 0)
				input_num = 1;
			try {
				res_show.ShowResultsXML(result_map1, result_map2, result_map3, results_array, input_num, output_route);
			}
			catch (Exception e) {
				System.out.println("XML creating exception!");
			}
			break;
		case CSV:
			if (input_num == 0)
				input_num = 1;
			results_array = SortingID.SortByID(result_map1, result_map2, result_map3, input_num);
			if (input_num == 0)
				input_num = 1;
			try {
				res_show.ShowResultsCSV(result_map1, result_map2, result_map3, results_array, input_num, output_route);
			}
			catch (Exception e) {
				System.out.println("CSV creating exception!");
			}
			break;
		case HTML:
			System.out.println("HTML is not supported!");
			break;
		}
	}

	/**
	 * Command line parsing
	 * 
	 * @param args
	 * @return Test string input and output routes and parameters
	 */
	public static String commandLineParsing(String args[]) {
		int stage = INPUT_METHOD;
		String return_value;

		// Initialization of static members
		input_route = null;
		output_route = null;
		input_method = 0;
		output_method = 0;
		input_num = 0;

		for (String s : args) {
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
				input_string = s;
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

		return_value = input_route + " " + output_route + " " + input_method + " " + output_method + " " + input_string;

		return return_value;
	}

	/**
	 * Returns event ID by it's name
	 * 
	 * @param result_map2
	 * @param name
	 * @return Event ID
	 */
	public static int getEventID(Map<Integer, String[]> result_map2, String name) {
		int id = 0;

		for (int i = 0; i < result_map2.size(); i++) {
			if (result_map2.get(i)[3].equalsIgnoreCase(name)) {
				id = Integer.parseInt((result_map2.get(i)[0]));
				return id;
			}
		}

		return -1;
	}
}
