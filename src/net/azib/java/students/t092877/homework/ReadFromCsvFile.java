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

public class ReadFromCsvFile implements Strategy {

	private File pathname;

	public ReadFromCsvFile(File pathname) {
		this.pathname = pathname;
	}

	@Override
	public void execute(Competition competition) {

		List<Athlete> athletes = competition.getAthletesList();
		List<String> athleteDataAsStrInput = new ArrayList<String>();
		String userInput = null;

		InputStreamReader instream = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(instream);

		System.out.println("\nNOTICE: before the program starts processing decathlon competition results");
		System.out.println("from the specified file, you should provide some data about the event itself.");

		System.out.print("\n>>> Enter the name of competition: ");
		try {
			userInput = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
		competition.setName(userInput);

		System.out.print(">>> Enter the location where it took place: ");
		try {
			userInput = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
		competition.setLocation(userInput);

		System.out.print(">>> Enter the date in specified format (yyyy-mm-dd): ");
		try {
			userInput = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
		competition.setDate(userInput);

		try {
			BufferedReader fin = new BufferedReader(new InputStreamReader(new FileInputStream(pathname), "utf-8"));

			System.out.println("\nProcessing file - " + pathname + "...");

			try {
				String line = fin.readLine();

				while(line != null) {
					athleteDataAsStrInput.add(line);
					line = fin.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			System.err.println("\n>>> ERROR: The specified file is missing!");
			//e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO: handle exception
		}

		String[] elements;

		try {

		for (String line : athleteDataAsStrInput) {
			elements = line.split(",");
			String name = elements[0].replace("\"", "");
			String dateOfBirth = elements[1];
			String countryCode = elements[2];

			Athlete athlete = new Athlete(name, dateOfBirth, countryCode);
			athletes.add(athlete);

			String[] resultsAsStr = Arrays.copyOfRange(elements, 3, elements.length);
			List<Result> results = new ArrayList<Result>();

			int i = 0;
			for (Event event : Event.values()) {


					Result result = new Result(event, Utils.convertToProperUnits(resultsAsStr[i], event.getType()));
					results.add(result);
					i++;
			}

			athlete.setResults(results);
		}

		} catch (NumberFormatException e) {

			System.err.println("\n>>> ERROR: The specified input file has invalid format!");
			athletes = null;

		}

		competition.setAthletesList(athletes);
	}
}
