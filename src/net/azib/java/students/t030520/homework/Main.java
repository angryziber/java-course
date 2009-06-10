package net.azib.java.students.t030520.homework;

import net.azib.java.students.t030520.homework.command.InputCommand;
import net.azib.java.students.t030520.homework.command.OutputCommand;
import net.azib.java.students.t030520.homework.providers.InputProvider;
import net.azib.java.students.t030520.homework.providers.OutputProvider;
import net.azib.java.students.t030520.homework.sportsman.EventResult;
import net.azib.java.students.t030520.homework.sportsman.SportsmanWithResults;
import net.azib.java.students.t030520.homework.util.Utils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;

/**
 * The main class for running the program, which calculate the decathlon point.
 * The inputs are: console, csv, database.
 * The outputs are: console, csv, xml, html.
 *
 * @author t030520
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InputCommand inputCommand = readInputCommand(args);
		OutputCommand outputCommand = readOutputCommand(inputCommand, args);

		List<SportsmanWithResults> results = new ArrayList<SportsmanWithResults>();

		try {
			switch(inputCommand) {
			case CONSOLE:
				results = InputProvider.getResultsFromConsole();
				break;
			case CSV:
				results = InputProvider.getResultFromCsv(args[1]);
				break;
			case DB:
				results = Utils.isValidLong(args[1]) ?
						InputProvider.getResultFromBDByCompetitionId(Utils.convertToLong(args[1]))
						: InputProvider.getResultFromBDByCompetitionName(args[1]);
				break;
			}
		} catch (IOException e) {
			System.out.println("Could not proceed reading data from input.");
			System.exit(1);
		} catch (SQLException e) {
			System.out.println(e);
			System.exit(1);
		}

		calculateSportsmanPoints(results);
		Collections.sort(results);
		calculateSportsmanPositions(results);

		try {
			switch(outputCommand) {
			case CONSOLE:
				OutputProvider.writeResultToConsole(results);
				break;
			case CSV: 
				String filename = inputCommand.equals(InputCommand.CONSOLE) ? args[2] : args[3];
				OutputProvider.writeResultToCsvFile(results, filename);
				System.out.println("Csv file succesfully generated.");
				break;
			case XML: 
				filename = inputCommand.equals(InputCommand.CONSOLE) ? args[2] : args[3];
				OutputProvider.writeResultToXmlFile(results, filename);
				System.out.println("Xml file succesfully generated.");
				break;
			case HTML:
				filename = inputCommand.equals(InputCommand.CONSOLE) ? args[2] : args[3];
				OutputProvider.writeResultToHtmlFile(results, filename);
				System.out.println("Html file succesfully generated.");
				break;
			}
		} catch (IOException e) {
			System.out.println("Could not proceed writing data to output.");
			System.exit(1);
		}
	}

	// Should not return null
	private static InputCommand readInputCommand(String args[]) {

		String enteredCommand = null;
		String resultCommand = null;
		try {
			enteredCommand = args[0];
		} catch (ArrayIndexOutOfBoundsException ex) {
			enteredCommand = null;
		}

		for (InputCommand command : InputCommand.values()) {
			if (command.equals(enteredCommand)) {
				
				// Control the Parameters entered
				if (command.getPattern() != null) {
					String parameter = null;
					try {
						parameter = args[1];
					} catch (ArrayIndexOutOfBoundsException ex) {
						resultCommand = null;
						break;
					}
					Matcher m = command.getPattern().matcher(parameter);
					if (!m.matches()) {
						resultCommand = null;
						break;
					}
				}

				return command;
			}
		}

		if (resultCommand == null) {
			System.out.println(getError());
			System.exit(1);
		}

		return null;
	}

	// Should not return null
	private static OutputCommand readOutputCommand(InputCommand inputCommand, String args[]) {

		String enteredCommand = null;
		String resultCommand = null;
		try {
			enteredCommand = inputCommand.equals(InputCommand.CONSOLE.valueOf()) ? args[1] : args[2];
		} catch (ArrayIndexOutOfBoundsException ex) {
			enteredCommand = null;
		}

		for (OutputCommand command : OutputCommand.values()) {
			if (command.equals(enteredCommand)) {

				// Control the Parameters entered
				if (command.getPattern() != null) {
					String parameter = null;
					try {
						parameter = inputCommand.equals(InputCommand.CONSOLE.valueOf()) ? args[2] : args[3];
					} catch (ArrayIndexOutOfBoundsException ex) {
						resultCommand = null;
						break;
					}
					Matcher m = command.getPattern().matcher(parameter);
					if (!m.matches()) {
						resultCommand = null;
						break;
					}
				}

				return command;
			}
		}

		if (resultCommand == null) {
			System.out.println(getError());
			System.exit(1);
		}

		return null;
	}

	private static String getError() {
		return "Control the command parameters typed.\n" +
				"<program> -<input-method> [input-parameters] -<output-method> [output-parameters]\n" +
				"Input-method variants: <-console>, <-csv>, <-db>\n" +
				"Output-method variants: <-console>, <-csv>, <-xml>, <-html>";
	}

	private static void calculateSportsmanPoints(List<SportsmanWithResults> sportsmanWithResults) {
		for (SportsmanWithResults sportsman : sportsmanWithResults) {
			int points = 0;
			for (EventResult result : sportsman.getResults()) {
				points += result.getType().getPoints(result.getResult());
			}
			sportsman.setPoints(points);
		}
	}

	private static void calculateSportsmanPositions(List<SportsmanWithResults> sportsmanWithResults) {
		int startPosition = 0;
		for (SportsmanWithResults sportsman : sportsmanWithResults) {
			if (Utils.isEmpty(sportsman.getPlace())) {
				int lastPosition = getLastPosition(startPosition, sportsmanWithResults);
				if (startPosition == lastPosition) {
					sportsman.setPlace(String.valueOf(startPosition + 1));
				} else {
					for (int i = startPosition; i <= lastPosition; i++) {
						String position = String.valueOf(startPosition + 1) + "-" + String.valueOf(lastPosition + 1);
						sportsmanWithResults.get(i).setPlace(position);
					}
				}
			}
			startPosition++;
		}
	}

	private static int getLastPosition(int i, List<SportsmanWithResults> sportsmanWithResults) {
		int startPosition = i;
		if (startPosition + 1 == sportsmanWithResults.size() ||
				sportsmanWithResults.get(startPosition).getPoints() != sportsmanWithResults.get(startPosition+1).getPoints()) {
			return startPosition;
		} else {
			return getLastPosition(startPosition+1, sportsmanWithResults);
		}
	}
}
