package net.azib.java.students.t092855.homework;


import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Console input strategy.
 * Gets decathlon data from console input.
 *
 * @author t092855
 */
public class ConsoleInput implements InputStrategy {
	Scanner input;
	PrintStream output;

	/**
	 * Default constructor for ConsoleInput.
	 * Uses System.in for data input and System.out for data output
	 */
	public ConsoleInput() {
		input = new Scanner(System.in);
		output = new PrintStream(System.out);
	}

	/**
	 * Get decathlon competition data from console
	 *
	 * @return competition data
	 */
	@Override
	public Competition getData(String... arg) {
		Competition competition = new Competition();

		input.useDelimiter(System.getProperty("line.separator"));
		while(true)
		{
			output.println("Do you want to add an athlete? (y/n)");
			if (getYes(input))
				break;
			Athlete athlete = new Athlete();
			getAthleteData(input, athlete);
			getAthleteResults(input, athlete);

			competition.addAthlete(athlete);
		}
		output.println("Athlete adding completed.");
		return competition;
	}

	private void getAthleteResults(Scanner scanner, Athlete athlete) {
		double[] results = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		int i = 0;

		for(DecathlonEvent events : DecathlonEvent.values()) {
			while(true) {
				output.print("Enter " + events.toString() + " result: ");
				String s = scanner.next();
				double temp = DecathlonEvents.validateAndConvertResult(s);
				if (temp < 0.0) {
					output.println(Error.ERROR_NUMBER_FORMAT.getErrorText());
				}
				else {
					results[i++] = temp;
					break;
				}
			}
		}
		athlete.setDecathlonEvent(new DecathlonEvents(results));
	}

	private void getAthleteData(Scanner scanner, Athlete athlete) {
		getAthleteName(scanner, athlete);
		getAthleteCountry(scanner, athlete);
		getAthleteBirthday(scanner, athlete);
	}

	private void getAthleteName(Scanner scanner, Athlete athlete) {
		while(true)
		{
			output.println("Please enter athlete's name:");
			String s = scanner.next();
			if(athlete.setName(s))
				break;
		}
	}

	private void getAthleteCountry(Scanner scanner, Athlete athlete) {
		while(true)
		{
			output.println("Please enter athlete's origin:");
			String s = scanner.next();
			if (athlete.setCountry(s))
				break;
		}
	}

	private void getAthleteBirthday(Scanner scanner, Athlete athlete) {
		while(true)
		{
			output.println("Please enter athlete's date of birth (in format: " +
					((SimpleDateFormat)DateFormat.getDateInstance(DateFormat.MEDIUM)).toPattern() + "):");
			String s = scanner.next();
			if (athlete.setBirthday(s))
				break;
		}
	}

	private boolean getYes(Scanner scanner) {
		String s = scanner.next();
		return s == null || !s.equalsIgnoreCase("y");
	}
}
