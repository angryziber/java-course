package net.azib.java.students.t092877.homework;

import java.util.List;

public class WriteToStandardOutput implements Strategy {

	@Override
	public void execute(Competition competition) {

		List<Athlete> athletes = competition.getAthletesList();
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
		String[] orignalUnits = new String[10];
		Result result;

		for (int i = 0; i < results.size(); i++) {
			result = results.get(i);
			orignalUnits[i] = Utils.convertToOriginalUnits(result.getValue(), result.getEvent().getType());
		}

		System.out.printf(
						"%6s|%6d|%6s|%-34s|%5s|%9s|%8s|%9s|%9s|%12s|%12s|%10s|%13s|%9s|\n",
						athlete.getPlace(),
						athlete.getTotalScore(),
						athlete.getCountryCode(),
						athlete.getName(),
						orignalUnits[0],
						orignalUnits[1],
						orignalUnits[2],
						orignalUnits[3],
						orignalUnits[4],
						orignalUnits[5],
						orignalUnits[6],
						orignalUnits[7],
						orignalUnits[8],
						orignalUnits[9]);

		System.out.println("------+------+------+----------------------------------+-----+---------+--------+" +
        				   "---------+---------+------------+------------+----------+-------------+---------+");
	}
}


