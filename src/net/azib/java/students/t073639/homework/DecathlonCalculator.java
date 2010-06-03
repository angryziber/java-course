package net.azib.java.students.t073639.homework;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Program behaviour depends on arguments.
 * <br>Inputs athletes to list and outputs sorted list of athletes in descending order of total points.
 * <br>Athlete in sorted list contains also place and total points.
 * <br>If number of arguments is less then 2 or larger then 4 it prints out help hint.
 * <br>If arguments are incorrect program reports that. 
 * 
 * @author t073639
 */
public class DecathlonCalculator {
	/**
	 * <p> Method respond to inputed arguments.
	 * <br>args[0] can be -console, -csv, -db
	 * <br>args[1] can be -console, name of csv file, db query sign
	 * <br>args[2] can be -console, -csv, -xml, -html
	 * <br>args[3] can be name of csv file, name of xml file, name of html file
	 * <br><b>No check for correctness of args[1] and args[3]</b>
	 * @param args - Arguments, which can be -console, -db, -csv, -xml, -html, file path, file name or db query sign
	 */
	public static void main(String[] args) {
		DecathlonCalculator dc = new DecathlonCalculator();
		dc.mainMethod(args);
	}

	private void mainMethod(String[] args) {
		if (args.length == 0 || args.length == 1 || args.length > 4) {
			System.out.println("Usage:");
			System.out.println("DecathlonCalculator -<input-method> [input-parameters] -<output-method> [output-parameters]\n" + "where\n"
					+ "\t* <input-method> is the name of the input method preceded by dash (-): -console, -csv, -db\n"
					+ "\t* [input-parameters] are optional parameters depending on the specified input method:\n"
					+ "\t\t-console - no parameters\n" + "\t\t-csv - input file name or path\n"
					+ "\t\t-db - competition id or name \n"
					+ "\t* <output-method> is the name of the output method preceded by dash (-): -conole, -csv, -xml, -html\n"
					+ "\t* [output-parameters] are optional parameters depending on the specified output method:\n"
					+ "\t\t-console - no parameters\n" + "\t\t-csv - output file name or path\n"
					+ "\t\t-xml - output file name or path\n" + "\t\t-html - output file name or path\n");

		}
		else {
			Console console;
			CSVControl csv;
			System.out.println("Arguments are:" + Arrays.toString(args));
			if (args[0].equals("-console") && args[1].equals("-console")) {
				console = new Console();
				console.inputResults();
				console.printFinalResults();
			}
			else if (args[0].equals("-console") && args[1].equals("-csv")) {
				console = new Console();
				console.inputResults();
				new CSVControl(console.getInputAthleteList()).printResultsToFile(args[2]);
			}
			else if (args[0].equals("-console") && args[1].equals("-xml")) {
				console = new Console();
				console.inputResults();
				new XMLControl(console.getInputAthleteList()).formatFile(args[2]);
			}

			else if (args[0].equals("-console") && args[1].equals("-html")) {
				console = new Console();
				console.inputResults();
				new XMLControl(console.getInputAthleteList()).transform2html(args[2]);
			}

			else if (args[0].equals("-csv") && args[2].equals("-console")) {
				csv = new CSVControl(args[1]);
				new Console(csv.getInputAthleteList()).printFinalResults();
			}

			else if (args[0].equals("-csv") && args[2].equals("-csv")) {
				new CSVControl(args[1].toString()).printResultsToFile(args[3].toString());
			}
			else if (args[0].equals("-csv") && args[2].equals("-xml")) {
				csv = new CSVControl(args[1]);
				new XMLControl(csv.getInputAthleteList()).formatFile(args[3]);
			}
			else if (args[0].equals("-csv") && args[2].equals("-html")) {
				csv = new CSVControl(args[1]);
				new XMLControl(csv.getInputAthleteList()).transform2html(args[3]);
			}

			else if (args[0].equals("-db") && args[2].equals("-console")) {
				new Console(new DBControl(args[1]).getInputAthleteList()).printFinalResults();
			}
			else if (args[0].equals("-db") && args[2].equals("-csv")) {
				new CSVControl(new DBControl(args[1]).getInputAthleteList()).printResultsToFile(args[3]);
			}
			else if (args[0].equals("-db") && args[2].equals("-xml")) {
				new XMLControl(new DBControl(args[1]).getInputAthleteList()).formatFile(args[3]);
			}
			else if (args[0].equals("-db") && args[2].equals("-html")) {
				new XMLControl(new DBControl(args[1]).getInputAthleteList()).transform2html(args[3]);
			}
			else
				System.out.println("\t*Error: Incorrect arguments");
		}
	}

	/**
	 * <p>Calculation single athlete's points.
	 * <br>BigDecimal is used for precise calculation.
	 * @param list - List of single athlete's results in decathlon.
	 * @return Total points in competition
	 */
	public static int getTotalPoints(List<String> list) {
		int i = 0;
		BigDecimal bdSum = BigDecimal.ZERO;
		Event e = Event.M100;
		while (i < list.size()) {
			BigDecimal bd = new BigDecimal(list.get(i));
			bdSum = bdSum.add(e.getPoints(bd)).setScale(0, BigDecimal.ROUND_FLOOR);
			e = e.next();
			i++;
		}
		return bdSum.intValue();
	}
}
