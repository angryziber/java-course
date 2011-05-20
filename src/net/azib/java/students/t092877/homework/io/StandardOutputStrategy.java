package net.azib.java.students.t092877.homework.io;

import net.azib.java.students.t092877.homework.util.Utils;
import net.azib.java.students.t092877.homework.model.Athlete;
import net.azib.java.students.t092877.homework.model.Competition;
import net.azib.java.students.t092877.homework.model.Result;

import java.util.List;

/**
 * StandardOutputStrategy.java
 * Purpose: provides implementation for console output
 *
 * @author Artjom Kruglenkov / 092877
 * @version 1.0 20.05.2011
 */
public class StandardOutputStrategy implements Strategy {

	/**
	 * Executes the implementation for console output.
	 *
	 * @param competition an instance of decathlon competition
	 */
	@Override
	public void execute(Competition competition) {

		List<Athlete> athletes = competition.getAthletesList();

		if (athletes == null) {

			System.err.println("\n>>> ERROR: output to console terminated...");
			System.err.println("The input file provided has invalid format or empty.");
			System.exit(1);
		}

		Utils.sortAthletes(athletes);

		System.out.println("\nResults for decathlon competition " + competition);
		printTableHeader();

		for (Athlete athlete : athletes) {
			printTableRow(athlete);
		}
	}


	/**
	 * Outputs to console the header of table with decathlon competition results.
	 */
	private void printTableHeader() {

		System.out.println();
		System.out.println("------+------+------+----------------------------------+-----+---------+--------+" +
				           "---------+---------+------------+------------+----------+-------------+---------+");
		System.out.printf(
				"%6s|%6s|%6s|%-34s|%5s|%9s|%8s|%9s|%9s|%12s|%12s|%10s|%13s|%9s|\n",
						"Place", "Points", "Nation", "Athlete",
						"100m", "long jump", "shot put", "high jump", "400m",
						"110m hurdles", "discus throw", "pole vault", "javelin throw", "1500m");

		System.out.printf(
				"%6s|%6s|%6s|%-34s|%5s|%9s|%8s|%9s|%9s|%12s|%12s|%10s|%13s|%9s|\n",
						"", "", "", "",
						"(sec)", "(m)", "(m)", "(m)", "(min:sec)",
						"(sec)", "(m)", "(m)", "(m)", "(min:sec)");

		System.out.println("------+------+------+----------------------------------+-----+---------+--------+" +
        				   "---------+---------+------------+------------+----------+-------------+---------+");
	}


	/**
	 * Outputs to console the single row with specified athlete's results.
	 *
	 * @param athlete the specified athlete
	 */
	private void printTableRow(Athlete athlete) {

		List<Result> results = athlete.getResults();
		String[] originalUnits = new String[10];
		Result result;

		for (int i = 0; i < results.size(); i++) {
			result = results.get(i);
			originalUnits[i] = Utils.convertToOriginalUnits(result.getValue(), result.getEvent().getType());
		}

		System.out.printf(
						"%6s|%6d|%-6s|%-34s|%5s|%9s|%8s|%9s|%9s|%12s|%12s|%10s|%13s|%9s|\n",
						athlete.getPlace(),
						athlete.getTotalScore(),
						athlete.getCountryCode(),
						athlete.getName(),
						originalUnits[0],
						originalUnits[1],
						originalUnits[2],
						originalUnits[3],
						originalUnits[4],
						originalUnits[5],
						originalUnits[6],
						originalUnits[7],
						originalUnits[8],
						originalUnits[9]);

		System.out.println("------+------+------+----------------------------------+-----+---------+--------+" +
        				   "---------+---------+------------+------------+----------+-------------+---------+");
	}
}
