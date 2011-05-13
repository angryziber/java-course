package net.azib.java.students.t092877.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Console {

	public static List<Athlete> input(Competition decathlon) {

		System.out.println("One by one enter names and the results of participants");

		boolean anotherEntry;
		String userInput;
		Athlete currentAthlete;
		List<Athlete> athletes = decathlon.getAthletesList();

		while (true) {
			System.out.print("\nEnter the name of an athlete: ");
			InputStreamReader instream = new InputStreamReader(System.in);
			BufferedReader in = new BufferedReader(instream);

			try {
				userInput = in.readLine();
				athletes.add(new Athlete(userInput));
			} catch (IOException e) {
				e.printStackTrace();
			}

			currentAthlete = athletes.get(athletes.size() - 1);

			System.out.print("Enter the date of birth: ");
			try {
				currentAthlete.setDateOfBirth(in.readLine());
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			System.out.print("Enter 2-letter country code: ");
			try {
				userInput = in.readLine();
				currentAthlete.setCountryCode(userInput);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			System.out.println("\nNow you could input individual event results for " + currentAthlete.getName());
			System.out.println("---------------------------------------------------------------------");

			for (Event event : Event.values()) {
				System.out.printf(">>> %s (%s): ", event.getName(), event.getUnits() );

				try {
					userInput = in.readLine();
					currentAthlete.getResults().add(new Result(event, Utils.convertToProperUnits(userInput, event.getType())));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			anotherEntry = determineUserResponse(in);

			if (!anotherEntry) {
				break;
			}
		}
		return athletes;
	}


	private static boolean determineUserResponse(BufferedReader in) {

		boolean anotherEntry = false;
		String userResponse;

		try {

			while (true){

				System.out.print("\nAny other participants (yes/no)? ");
				userResponse = in.readLine().toLowerCase();

				if (userResponse.equals("yes")) {
					anotherEntry = true;
					break;
				}
				else if (userResponse.equals("no")) {
					anotherEntry = false;
					break;
				}
				else
					System.out.println("Please, only respond with \"yes\" or \"no\"!");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return anotherEntry;
	}


	public static void output(List<Athlete> athletes) {

		Utils.sortAthletes(athletes);
		printTableHeader();

		for (Athlete athlete : athletes) {
			printTableRow(athlete);
		}
	}


	public static void printTableHeader() {

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


	public static void printTableRow(Athlete athlete) {

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
