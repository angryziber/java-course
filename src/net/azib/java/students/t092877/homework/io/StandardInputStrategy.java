package net.azib.java.students.t092877.homework.io;

import net.azib.java.students.t092877.homework.util.Utils;
import net.azib.java.students.t092877.homework.model.Athlete;
import net.azib.java.students.t092877.homework.model.Competition;
import net.azib.java.students.t092877.homework.model.Event;
import net.azib.java.students.t092877.homework.model.Result;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * StandardInputStrategy.java
 * Purpose: provides implementation for interactive input
 *
 * @author Artjom Kruglenkov / 092877
 * @version 1.0 20.05.2011
 */
public class StandardInputStrategy implements Strategy {

	/**
	 * Executes the implementation for interactive input.
	 *
	 * @param competition an instance of decathlon competition
	 */
	@Override
	public void execute(Competition competition) {

		InputStreamReader instream = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(instream);

		getCompetitionData(competition, in);
	}

	/**
	 * Gets decathlon competition data from user input and sets it for specified Competition instance.
	 *
	 * @param competition an instance of decathlon competition
	 * @param in a BufferedReader for user input
	 */
	private void getCompetitionData(Competition competition, BufferedReader in) {

		System.out.println("\nNOTICE: before you could start inputting competition results,");
		System.out.println("you should provide some data about the event itself.");

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

		getAthletesDataFromUserInput(competition, in);
	}


	/**
	 * Gets athletes data from user input and sets it for specified Competition instance.
	 *
	 * @param competition an instance of decathlon competition
	 * @param in a BufferedReader for user input
	 */
	private void getAthletesDataFromUserInput(Competition competition, BufferedReader in) {

		List<Athlete> athletes = competition.getAthletesList();
		Athlete currentAthlete;
		boolean anotherEntry;

		System.out.println("\nNOTICE: now you could start inputting results of the participants");

		while (true) {

			try {

				System.out.print("\n>>> Enter the full name of an athlete: ");
				athletes.add(new Athlete(in.readLine()));
				currentAthlete = athletes.get(athletes.size() - 1);

				System.out.print(">>> Enter the date of birth (yyyy-mm-dd): ");
				currentAthlete.setDateOfBirth(in.readLine());

				System.out.print(">>> Enter 2-letter country code (e.g, EE for Estonia): ");
				currentAthlete.setCountryCode(in.readLine().toUpperCase());

				System.out.println("\nPlease, provide competition results for " + currentAthlete.getName());
				System.out.println("--------------------------------------------------------------");

				for (Event event : Event.values()) {

					System.out.printf(">>> %s (%s): ", event.getName(), event.getUnits());
					double value = Utils.convertToProperUnits(in.readLine(), event.getType());
					currentAthlete.getResults().add(new Result(event, value));
				}

			anotherEntry = isThereAnotherEntry(in);

			if (!anotherEntry)
				break;

			} catch (IOException e) {
				System.err.println("\n>>> ERROR: while reading user input");
				e.printStackTrace();
			}
		}
	}


	/**
	 * Tests whether there is another athlete entry to add.
	 *
	 * @param in a BufferedReader for user input
	 * @return true if there is another athlete entry; false otherwise
	 */
	private static boolean isThereAnotherEntry(BufferedReader in) {

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
