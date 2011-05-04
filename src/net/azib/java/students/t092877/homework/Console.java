package net.azib.java.students.t092877.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

public class Console {

	public static List<Athlete> input() {

		System.out.println("One by one enter names and the results of the participants");

		String userChoise;
		Athlete currentAthlete;

		while (true) {
			System.out.print("\nEnter the name of an athlete: ");
			InputStreamReader istream = new InputStreamReader(System.in);
			BufferedReader in = new BufferedReader(istream);

			try {
				Utility.athletes.add(new Athlete(in.readLine()));
			} catch (IOException e) {
				e.printStackTrace();
			}

			currentAthlete = Utility.athletes.get(Utility.athletes.size() - 1);

			System.out.print("\nEnter the date of birth: ");
			try {
				currentAthlete.setDateOfBirth(in.readLine());
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			System.out.print("\nEnter 2-letter country code: ");
			try {
				currentAthlete.setCountryCode(in.readLine());
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			System.out.println("\nNow you could input individual event results for " + currentAthlete.getName());
			System.out.println("----------------------------------------------------------------------");

			for (Event event : Event.values()) {
				System.out.printf(">>> %s (%s): ", event.getName(), event.getUnits() );
				try {
					currentAthlete.getResults().add(new Result(event, Utility.convertToProperUnits(in.readLine(), event.getType())));

				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

			System.out.print("\nAny other participants (yes/no)? ");
			try {
				userChoise = in.readLine().toLowerCase();

				if (!(userChoise.equals("yes"))) {
					Collections.sort(Utility.athletes);
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
	        }
		}

		return Utility.athletes;
	}

	public static void printTableHeader() {
		System.out.println();
		System.out.println("--------+--------+--------+----------------------+-------+-----------+----------+-----------" +
        				   "+-----------+--------------+--------------+------------+---------------+-----------+");
		System.out.printf(
				" %6s | %6s | %6s | %-20s | %5s | %9s | %8s | %9s | %9s | %12s | %12s | %10s | %13s | %9s |\n",
						"Place", "Points", "Nation", "Athlete", "100m", "long jump", "shot put", "high jump",
						"400m", "110m hurdles", "discus throw", "pole vault", "javelin throw", "1500m");

		System.out.printf(
				" %6s | %6s | %6s | %-20s | %5s | %9s | %8s | %9s | %9s | %12s | %12s | %10s | %13s | %9s |\n",
				"", "", "", "", "(sec)", "(m)", "(m)", "(m)", "(min:sec)", "(sec)", "(m)", "(m)", "(m)",
				"(min:sec)");

		System.out.println("--------+--------+--------+----------------------+-------+-----------+----------+-----------" +
				           "+-----------+--------------+--------------+------------+---------------+-----------+");
	}

//		public static void printTableRow(Athlete athlete) {
//
//		System.out.printf(
//						" %6d | %6s | %-20s | %5.2f | %9.2f | %8.2f | %9.2f | %9.2f | %12.2f | %12.2f | %10.2f | %13.2f | %9.2f |\n",
//						athlete.getTotalScore(), athlete.getCountryCode(), athlete.getName(), athlete.getResults().get(0).getValue(),
//						athlete.getResults().get(1).getValue(), athlete.getResults().get(2).getValue(), athlete.getResults().get(3).getValue(),
//						athlete.getResults().get(4).getValue(), athlete.getResults().get(5).getValue(), athlete.getResults().get(6).getValue(),
//						athlete.getResults().get(7).getValue(), athlete.getResults().get(8).getValue(), athlete.getResults().get(9).getValue());
//
//		System.out.println("--------+--------+----------------------+-------+-----------+----------+-----------" +
//				           "+-----------+--------------+--------------+------------+---------------+-----------+");
//
//	}


		public static void printTableRow(Athlete athlete) {

		System.out.printf(
						" %6s | %6d | %6s | %-20s | %5s | %9s | %8s | %9s | %9s | %12s | %12s | %10s | %13s | %9s |\n",
						athlete.getPlace(), athlete.getTotalScore(), athlete.getCountryCode(), athlete.getName(),
						athlete.getResults().get(0).getOriginalValue(), athlete.getResults().get(1).getOriginalValue(),
						athlete.getResults().get(2).getOriginalValue(), athlete.getResults().get(3).getOriginalValue(),
						athlete.getResults().get(4).getOriginalValue(), athlete.getResults().get(5).getOriginalValue(),
						athlete.getResults().get(6).getOriginalValue(), athlete.getResults().get(7).getOriginalValue(),
						athlete.getResults().get(8).getOriginalValue(), athlete.getResults().get(9).getOriginalValue());

		System.out.println("--------+--------+--------+----------------------+-------+-----------+----------+-----------" +
				           "+-----------+--------------+--------------+------------+---------------+-----------+");

	}
		public static void output(List<Athlete> athletes) {

		printTableHeader();
		for (Athlete athlete : athletes) {
			athlete.setPlace(String.valueOf(athletes.indexOf(athlete) + 1));
			printTableRow(athlete);
		}
	}
}
