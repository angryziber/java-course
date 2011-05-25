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
 * @version 1.1 20.05.2011
 */
public class StandardInputStrategy implements Strategy {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(Competition competition) {

		InputStreamReader instream = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(instream);

		try {
			getCompetitionData(competition, in);
			getAthletesDataFromUserInput(competition, in);
		} catch (IOException e) {
			System.err.println("\n>>> ERROR: while reading user input");
			competition.setAthletesList(null);
			e.printStackTrace();
		}
	}

	/**
	 * Gets decathlon competition data from user input and sets it for specified Competition instance.
	 *
	 * @param competition an instance of decathlon competition
	 * @param in a BufferedReader for user input
	 * @throws IOException if there are problems reading from user input
	 */
	void getCompetitionData(Competition competition, BufferedReader in) throws IOException {

		System.out.println("\nNOTICE: before you could start inputting competition results,");
		System.out.println("you should provide some data about the event itself.\n");

		String message;
		Validator val;

		message = ">>> Enter the name of competition: ";
		val = new StringValidator();
		competition.setName(readValue(val, message, in));

		message = ">>> Enter the location where it took place: ";
		val = new StringValidator();
		competition.setLocation(readValue(val, message, in));

		message = ">>> Enter the date (yyyy-mm-dd): ";
		val = new DateValidator();
		competition.setDate(readValue(val, message, in));

	}


	/**
	 * Gets athletes data from user input and sets it for specified Competition instance.
	 *
	 * @param competition an instance of decathlon competition
	 * @param in a BufferedReader for user input
	 * @throws IOException if there are problems reading form user input
	 */
	private void getAthletesDataFromUserInput(Competition competition, BufferedReader in) throws IOException {

		List<Athlete> athletes = competition.getAthletesList();
		Athlete currentAthlete;
		boolean anotherEntry;

		System.out.println("\nNOTICE: now you could start inputting results of the competition participants\n");

		while (true) {

			String message;
			Validator val;

			message = ">>> Enter the full name of an athlete: ";
			val = new StringValidator();
			athletes.add(new Athlete(readValue(val, message, in)));
			currentAthlete = athletes.get(athletes.size() - 1);

			message = ">>> Enter the date of birth (yyyy-mm-dd): ";
			val = new DateValidator();
			currentAthlete.setDateOfBirth(readValue(val, message, in));

			message = ">>> Enter ISO 2-letter country code: ";
			val = new CountryCodeValidator();
			currentAthlete.setCountryCode(readValue(val, message, in));


			System.out.println("\nPlease, provide competition results for " + currentAthlete.getName());
			System.out.println("--------------------------------------------------------------");

			for (Event event : Event.values()) {

				message = ">>> " + event.getName() + " (" + event.getUnits() + "): ";
				val = new ResultValueValidator();
				double value = Utils.convertToProperUnits(readValue(val, message, in), event.getType());
				currentAthlete.getResults().add(new Result(event, value));
			}

			anotherEntry = isThereAnotherEntry(in);

			if (!anotherEntry)
				break;
		}
	}


	/**
	 * Tests whether there is another athlete entry to add.
	 *
	 * @param in a BufferedReader for user input
	 * @return true if there is another athlete entry; false otherwise
	 * @throws IOException if there are problems reading from user input
	 */
	private static boolean isThereAnotherEntry(BufferedReader in) throws IOException {

		boolean anotherEntry = false;
		String userResponse;

		while (true){

			System.out.print("\nAny other participants (yes/no)? ");
			userResponse = in.readLine().toLowerCase();

			if (userResponse.equals("yes")) {
				System.out.println();
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

		return anotherEntry;
	}


	/**
	 * Reads a string specified by the user, validates it against some pattern and
	 * if validation is successful returns the string back; otherwise, user would
	 * have to provide a new value until the validation process is successful.
	 *
	 * @param validator an instance of specified validator
	 * @param message a message notifying a user of what to input
	 * @param reader an instance of a BufferedReader for user input
	 * @return a string representation of user input
	 * @throws IOException if there are problems reading from user input
	 */
	private String readValue(Validator validator, String message, BufferedReader reader) throws IOException {

		boolean correctValue = false;
		String value = null;
		while(!correctValue){
			System.out.print(message);
			value = reader.readLine();
			correctValue = validator.validate(value);
		}

		return value;
	}


	/**
	 * Purpose: provides an interface for concrete validator implementations.
	 *
	 * @author Artjom Kruglenkov / 092877
	 */
	public interface Validator {

		/**
		 * Tests whether specified string value validates against a pattern.
		 *
		 * @param value the string value provided by the user
		 * @return true if the string value validates against the pattern
		 */
		public boolean validate(String value);
	}

	/**
	 * Purpose: provides a validation for name format.
	 *
	 * @author Artjom Kruglenkov / 092877
	 */
	public class StringValidator implements Validator {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean validate(String value) {
			if(value.length() <= 35) {
				return true;
			} else {
				System.out.println("\n*** Invalid string format!");
				System.out.println("*** The input string length can't be longer than 35 characters.");
				System.out.println("*** Try again.\n");
				return false;
			}
		}
	}

	/**
	 * Purpose: provides a validation for date format.
	 *
	 * @author Artjom Kruglenkov / 092877
	 */
	public class DateValidator implements Validator {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean validate(String value) {
			if(value.matches("\\b(19|20)[0-9]{2}[-](0[1-9]|1[012])[-](0[1-9]|[12][0-9]|3[01])\\b")){
				return true;
			} else {
				System.out.println("\n*** Invalid date format!");
				System.out.println("*** The date should be in the specified format, that is yyyy-mm-dd");
				System.out.println("*** and fall in the interval from 1900-01-01 to 2099-12-31.");
				System.out.println("*** Try again.\n");

				return false;
			}
		}
	}

	/**
	 * Purpose: provides a validation for country code format.
	 *
	 * @author Artjom Kruglenkov / 092877
	 */
	public class CountryCodeValidator implements Validator {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean validate(String value) {
			if(value.matches("[A-Z]{2}")) {
				return true;
			} else {
				System.out.println("\n*** Invalid country code format!");
				System.out.println("*** The country code should have ISO 2-letter format");
				System.out.println("*** This means that there should be a succession of two capital letters");
				System.out.println("*** which as agreed upon by ISO organization is a short form for your country name");
				System.out.println("*** Try again.\n");
				return false;
			}
		}
	}

	/**
	 * Purpose: provides validation for result value format.
	 *
	 * @author Artjom
	 */
	public class ResultValueValidator implements Validator {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean validate(String value) {
			if(value.matches("^[0-9]+(:[0-9]{1,2})?(?:\\.[0-9]{1,2})?$")) {
				return true;
			} else {
				System.out.println("\n*** Invalid result value format!");
				System.out.println("*** Only numbers are allowed as an input");
				System.out.println("*** Try again.\n");
				return false;
			}
		}
	}
}
