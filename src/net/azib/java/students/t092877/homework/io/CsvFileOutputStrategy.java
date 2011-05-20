package net.azib.java.students.t092877.homework.io;

import net.azib.java.students.t092877.homework.util.Utils;
import net.azib.java.students.t092877.homework.model.Athlete;
import net.azib.java.students.t092877.homework.model.Competition;
import net.azib.java.students.t092877.homework.model.Event;
import net.azib.java.students.t092877.homework.model.Result;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * CsvFileOutputStrategy.java
 * Purpose: provides implementation for csv-file output
 *
 * @author Artjom Kruglenkov / 092877
 * @version 1.0 20.05.2011
 */
public class CsvFileOutputStrategy implements Strategy {

	private File pathname;

	/**
	 * Creates a new CsvFileOutputStrategy instance from File pathname.
	 *
	 * @param pathname the pathname for csv-file output
	 */
	public CsvFileOutputStrategy(File pathname) {
		this.pathname = pathname;
	}

	/**
	 * Executes the implementation for csv-file output.
	 *
	 * @param competition an instance of decathlon competition
	 */
	@Override
	public void execute(Competition competition) {

		List<Athlete> athletes = competition.getAthletesList();

		if (athletes == null) {

			System.err.println("\n>>> ERROR: output to file terminated...");
			System.err.println("The input file provided has invalid format or empty.");
			System.exit(1);
		}

		Utils.sortAthletes(athletes);
		List<String> athleteDataAsStr = new ArrayList<String>();

		for (Athlete athlete : athletes) {

			StringBuilder line = new StringBuilder();

			line.append(athlete.getPlace() + ",");
			line.append(athlete.getTotalScore() + ",");
			line.append("\"" + athlete.getName() + "\",");
			line.append(Utils.convertToDotSeparetedDayMonthYearFormat(athlete.getDateOfBirth()) + ",");
			line.append(athlete.getCountryCode());

			List<Result> results = athlete.getResults();

			int i = 0;
			for (Event event : Event.values()) {

				Result currentEventResult = results.get(i);
				String value = Utils.convertToOriginalUnits(currentEventResult.getValue(), event.getType());
				line.append("," + value);
				i++;
			}

			athleteDataAsStr.add(line.toString());
		}

		try {

			BufferedWriter fout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathname), "utf-8"));

			for (String line : athleteDataAsStr) {
				fout.write(line);
				fout.newLine();
				fout.flush();
			}
		} catch (FileNotFoundException e) {
			System.err.println("\n>>> ERROR: the directory you are trying to save the file to doesn't exist");
			System.exit(1);
		} catch (UnsupportedEncodingException e) {
			System.err.println("\n>>> ERROR: unsupported encoding");
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			System.err.println("\n ERROR: writing the file");
			e.printStackTrace();
			System.exit(1);
		}

		System.out.printf("\nThe file with results for decathlon competition %s was saved to %s",
				              competition, pathname.getAbsolutePath());
	}
}
