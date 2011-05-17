package net.azib.java.students.t092877.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ReadFromStandardInput implements Strategy {

	@Override
	public void execute(Competition competition) {

		boolean anotherEntry;
		String userInput = null;
		Athlete currentAthlete;
		List<Athlete> athletes = competition.getAthletesList();

		InputStreamReader instream = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(instream);

		System.out.println("\nNOTICE: before you could start inputting competition results,");
		System.out.println("you should provide some data about the event itself.");

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

		System.out.println("\nNOTICE: now you could start inputting results of the participants");

		while (true) {

			System.out.print("\n>>> Enter the name of an athlete: ");
			try {
				userInput = in.readLine();
				athletes.add(new Athlete(userInput));
			} catch (IOException e) {
				e.printStackTrace();
			}

			currentAthlete = athletes.get(athletes.size() - 1);

			System.out.print(">>> Enter the date of birth (yyyy-mm-dd): ");
			try {
				currentAthlete.setDateOfBirth(in.readLine());
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			System.out.print(">>> Enter 2-letter country code: ");
			try {
				userInput = in.readLine();
				currentAthlete.setCountryCode(userInput);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			System.out.println("\nPlease, provide competition results for " + currentAthlete.getName());
			System.out.println("--------------------------------------------------------------");

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

		competition.setAthletesList(athletes);
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
}

