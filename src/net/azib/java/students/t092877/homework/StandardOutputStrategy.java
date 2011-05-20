package net.azib.java.students.t092877.homework;

import java.util.List;

class StandardOutputStrategy implements Strategy {

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
