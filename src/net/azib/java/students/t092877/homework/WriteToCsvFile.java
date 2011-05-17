package net.azib.java.students.t092877.homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class WriteToCsvFile implements Strategy {

	private File pathname;

	public WriteToCsvFile(File pathname) {
		this.pathname = pathname;
	}


	@Override
	public void execute(Competition competition) {

		List<Athlete> athletes = competition.getAthletesList();
		if (athletes == null) {

			System.out.println("\n>>> ACTION: output to csv-file terminated...");
			System.out.println("The input file provided has invalid format or empty.");
			System.out.println("As a result, the output to specified CSV-file was terminated");
			System.out.println("Before continuing operation, please, ensure the validity of input data.");
			return;
		}

		Utils.sortAthletes(athletes);
		List<String> athleteDataAsStrOutput = new ArrayList<String>();

		for (Athlete athlete : athletes) {

			StringBuilder line = new StringBuilder();

			line.append(athlete.getPlace() + ",");
			line.append(athlete.getTotalScore() + ",");
			line.append("\"" + athlete.getName() + "\",");
			line.append(athlete.getDateOfBirth() + ",");
			line.append(athlete.getCountryCode());

			List<Result> results = athlete.getResults();

			int i = 0;
			for (Event event : Event.values()) {

				Result currentEventResult = results.get(i);
				String value = Utils.convertToOriginalUnits(currentEventResult.getValue(), event.getType());
				line.append("," + value);
				i++;
			}

			athleteDataAsStrOutput.add(line.toString());
		}

		try {
			BufferedWriter fout = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathname), "utf-8"));

			for (String line : athleteDataAsStrOutput) {
				fout.write(line);
				fout.newLine();
				fout.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.printf("\nResults for decahtlon competition %s were saved to %s", competition, pathname.getAbsolutePath());
	}
}
