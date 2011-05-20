package net.azib.java.students.t092877.homework;
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

class CsvFileInputStrategy implements Strategy {

	private File pathname;

	public CsvFileInputStrategy(File pathname) {
		this.pathname = pathname;
	}

	@Override
	public void execute(Competition competition) {

		getCompetitionData(competition);

	}


	private void getCompetitionData(Competition competition) {

		InputStreamReader instream = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(instream);

		System.out.println("\nNOTICE: before the program starts processing competition results,");
		System.out.println("please, provide some data about the event itself.");

		try {

			System.out.print("\n>>> Enter the name of competition: ");
			competition.setName(in.readLine());

			System.out.print(">>> Enter the location where it took place: ");
			competition.setLocation(in.readLine());

			System.out.print(">>> Enter the date (yyyy-mm-dd): ");
			competition.setDate(in.readLine());

		} catch (IOException e) {
			System.err.println("\n>>> ERROR: while reading user input");
			e.printStackTrace();
		}

		getAthletesDataFromCsvFile(competition);
	}



	private void getAthletesDataFromCsvFile(Competition competition) {

		List<Athlete> athletes = competition.getAthletesList();
		List<String> athleteDataAsStr = new ArrayList<String>();

		try {

			BufferedReader fin = new BufferedReader(new InputStreamReader(new FileInputStream(pathname), "utf-8"));

			try {
				String line = fin.readLine();

				while(line != null) {
					athleteDataAsStr.add(line);
					line = fin.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			System.err.println("\n>>> ERROR: specified file is missing!");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			System.err.println("\n>>> ERROR: unsupported file encoding. Make sure that your file is in UTF-8 encoding!");
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
