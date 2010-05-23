package net.azib.java.students.t050731.homework;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * InputAthleteFromConsole
 * 
 * This class handles the input from console
 * 
 * @author Raigo
 */
public class InputAthletesFromConsole {
	private Scanner in = new Scanner(System.in);
	private HelperMethods helper = new HelperMethods();

	/**
	 * This method reads athlete information interactively from console
	 */
	protected ArrayList<Athlete> readFromConsole() {
		boolean quit = false;
		ArrayList<Athlete> athleteList = new ArrayList<Athlete>();

		String name;
		Date dateOfBirth;
		String country;
		double shortSprintResult = 0;
		double longJumpResult = 0;
		double shotPutResult = 0;
		double highJumpResult = 0;
		double longSprintResult = 0;
		double hurdlesResult = 0;
		double discusThrowResult = 0;
		double poleVaultResult = 0;
		double javelinThrowResult = 0;
		double raceResult = 0;
		int totalScore = 0;

		while (quit == false) {
			totalScore = 0;

			System.out.println("Enter athlete's name.");
			name = getValidName();

			System.out.println("Enter athlete's birthdate (dd.mm.yyyy).");
			dateOfBirth = getValidBirthDate();

			System.out.println("Enter athlete's 2 letter country code.");
			country = getValidCountryCode();
			country = country.toUpperCase();

			System.out.println("Enter athlete's 100m sprint result (sec).");
			shortSprintResult = verifDoubleResultFormat();
			CalculateTrackScores scoreShortSprint = CalculateTrackScores.valueOf("SPRINT_100M");
			totalScore += scoreShortSprint.calculateTrackScore(shortSprintResult);

			System.out.println("Enter athlete's long jump result (m).");
			longJumpResult = verifDoubleResultFormat();
			longJumpResult = longJumpResult * 100;
			CalculateFieldScores scoreLongJump = CalculateFieldScores.valueOf("LONG_JUMP");
			totalScore += scoreLongJump.calculateFieldScore(longJumpResult);

			System.out.println("Enter athlete's shot put result (m).");
			shotPutResult = verifDoubleResultFormat();
			CalculateFieldScores scoreShotPut = CalculateFieldScores.valueOf("SHOT_PUT");
			totalScore += scoreShotPut.calculateFieldScore(shotPutResult);

			System.out.println("Enter athlete's high jump result (m).");
			highJumpResult = verifDoubleResultFormat();
			highJumpResult = highJumpResult * 100;
			CalculateFieldScores scoreHighJump = CalculateFieldScores.valueOf("HIGH_JUMP");
			totalScore += scoreHighJump.calculateFieldScore(highJumpResult);

			System.out.println("Enter athlete's 400m sprint result (min:sec).");
			longSprintResult = verifyResultWithMinutePart();
			CalculateTrackScores scoreLongSprint = CalculateTrackScores.valueOf("SPRINT_400M");
			totalScore += scoreLongSprint.calculateTrackScore(longSprintResult);

			System.out.println("Enter athlete's 110m hurdles result (s).");
			hurdlesResult = verifDoubleResultFormat();
			CalculateTrackScores scoreHurdles = CalculateTrackScores.valueOf("HURDLES");
			totalScore += scoreHurdles.calculateTrackScore(hurdlesResult);

			System.out.println("Enter athlete's discus throw result (m).");
			discusThrowResult = verifDoubleResultFormat();
			CalculateFieldScores scoreDiscusThrow = CalculateFieldScores.valueOf("DISCUS_THROW");
			totalScore += scoreDiscusThrow.calculateFieldScore(discusThrowResult);

			System.out.println("Enter athlete's pole vault result (m).");
			poleVaultResult = verifDoubleResultFormat();
			poleVaultResult = poleVaultResult * 100;
			CalculateFieldScores scorePoleVault = CalculateFieldScores.valueOf("POLE_VAULT");
			totalScore += scorePoleVault.calculateFieldScore(poleVaultResult);

			System.out.println("Enter athlete's javelin throw result (m).");
			javelinThrowResult = verifDoubleResultFormat();
			CalculateFieldScores scoreJavelinThrow = CalculateFieldScores.valueOf("JAVELIN_THROW");
			totalScore += scoreJavelinThrow.calculateFieldScore(javelinThrowResult);

			System.out.println("Enter athlete's 1500m race result (min:sec).");
			raceResult = verifyResultWithMinutePart();
			CalculateTrackScores scoreRace = CalculateTrackScores.valueOf("SPRINT_1500M");
			totalScore += scoreRace.calculateTrackScore(raceResult);

			Athlete athlete = new Athlete(name, dateOfBirth, country, shortSprintResult, longJumpResult, shotPutResult,
					highJumpResult, longSprintResult, hurdlesResult, discusThrowResult, poleVaultResult, javelinThrowResult,
					raceResult, totalScore);

			athleteList.add(athlete);

			System.out.println("Do you wish to enter another athlete? (yes/no)");
			quit = getQuitcondition();
		}
		return athleteList;
	}

	private String getValidName() {
		String nameHelper = "";

		while (true) {
			nameHelper = in.nextLine().trim();
			if (helper.verifyName(nameHelper).equals("") == false)
				break;
			else
				System.out.println("Enter a valid name.");
		}
		return nameHelper;
	}

	private Date getValidBirthDate() {
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		Date date = new Date();
		Date dateHelper = new Date();
		while (true) {
			try {
				dateHelper = dateFormat.parse(in.nextLine());
				if (dateHelper.after(date)) {
					System.out.println("Athlete has not been born yet. Enter a birthdate that is earlier than today.");
				}
				else {
					return dateHelper;
				}
			}
			catch (ParseException e) {
				System.out.println("Enter a valid birthdate (required format: dd.mm.yyyy).");
			}
		}
	}

	private String getValidCountryCode() {
		String code = "";

		while (true) {
			code = in.nextLine();
			if (helper.verifyCountryCode(code) == true)
				break;
			else
				System.out.println("Enter a valid country code.");
		}
		return code;
	}

	private double verifDoubleResultFormat() {
		double resultHelper = 0;

		while (true) {
			try {
				resultHelper = Double.valueOf(in.nextLine().trim().replace(',', '.')).doubleValue();
				break;
			}
			catch (NumberFormatException e) {
				System.out.println("Enter a valid result.");
			}
		}
		return resultHelper;
	}

	private double verifyResultWithMinutePart() {
		String resultHelper = "";

		while (true) {
			resultHelper = in.nextLine();
			if (resultHelper.matches("([0-9]+:)?[0-9]{1,2}(\\.[0-9]{1,2})?"))
				break;
			else
				System.out.println("Enter a valid result.");
		}
		if (resultHelper.contains(":") == true) {
			return helper.convertMinutesToSeconds(resultHelper);
		}
		else {
			return Double.valueOf(resultHelper.trim()).doubleValue();
		}
	}

	private boolean getQuitcondition() {
		String conditionHelper;

		while (true) {
			conditionHelper = in.nextLine();
			if (conditionHelper.equals("yes"))
				return false;
			else if (conditionHelper.equals("no"))
				return true;
			else
				System.out.println("Enter 'yes' or 'no'.");
		}
	}
}