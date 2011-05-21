package net.azib.java.students.t092877.homework.io;
import net.azib.java.students.t092877.homework.util.Utils;
import net.azib.java.students.t092877.homework.model.Athlete;
import net.azib.java.students.t092877.homework.model.Competition;
import net.azib.java.students.t092877.homework.model.Event;
import net.azib.java.students.t092877.homework.model.Result;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * CsvFileInputStrategy.java
 * Purpose: provides implementation for csv-file input
 *
 * @author Artjom Kruglenkov / 092877
 * @version 1.1 20.05.2011
 */
public class CsvFileInputStrategy extends StandardInputStrategy implements Strategy {

	private File pathname;

	/**
	 * Creates a new CsvFileInputStrategy instance from File pathname.
	 *
	 * @param pathname the pathname for csv-file input
	 */
	public CsvFileInputStrategy(File pathname) {
		this.pathname = pathname;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(Competition competition) {

		InputStreamReader instream = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(instream);

		try {
			getCompetitionData(competition, in);

			in = new BufferedReader(new InputStreamReader(new FileInputStream(pathname), "utf-8"));
			getAthletesDataFromCsvFile(competition, in);

		} catch (FileNotFoundException e) {
			System.err.println("\n>>> ERROR: specified directory doesn't exit!");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			System.err.println("\n>>> ERROR: unsupported file encoding. Make sure that your file is in UTF-8 encoding!");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("\n>>> ERROR: while reading user input");
			e.printStackTrace();
		}
	}

	/**
	 * Gets athletes data from csv-file and sets it for specified Competition instance.
	 *
	 * @param competition an instance of decathlon competition
	 * @param in an instance of BufferedReader for user input
	 */
	private void getAthletesDataFromCsvFile(Competition competition, BufferedReader in) {

		List<Athlete> athletes = competition.getAthletesList();
		List<String> athleteDataAsStr = new ArrayList<String>();

		try {
			String line = in.readLine();

			while(line != null) {
				athleteDataAsStr.add(line);
				line = in.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {

			String[] elements;
			for (String line : athleteDataAsStr) {

				elements = line.split(",");
				String name = elements[0].replace("\"", "");
				String dateOfBirth = Utils.convertToDashSeparatedYearMonthDayFormat(elements[1]);
				String countryCode = elements[2];

				Athlete athlete = new Athlete(name, dateOfBirth, countryCode);

				String[] resultsAsStr = Arrays.copyOfRange(elements, 3, elements.length);
				List<Result> results = new ArrayList<Result>();

				int i = 0;
				for (Event event : Event.values()) {

					double value = Utils.convertToProperUnits(resultsAsStr[i], event.getType());
					Result result = new Result(event, value);
					results.add(result);
					i++;
				}

				athlete.setResults(results);
				athletes.add(athlete);
			}

			System.out.println("\nProcessing file - " + pathname + "...");

		} catch (NumberFormatException e) {
			System.err.println("\n>>> ERROR: impossible to read from csv-file");
			//e.printStackTrace();
			competition.setAthletesList(null);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("\n>>> ERROR: impossible to read from csv-file");
			//e.printStackTrace();
			competition.setAthletesList(null);
		}
	}
}
