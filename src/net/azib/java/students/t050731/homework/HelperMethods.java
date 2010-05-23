package net.azib.java.students.t050731.homework;

import java.io.File;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;

/**
 * SupportFunctions
 * 
 * This class contains support methods required by other classes
 * 
 * @author Raigo
 */
public class HelperMethods {

	/**
	 * This method converts minute part from string to seconds
	 * 
	 * @param textWithMinutes
	 *            text containing minute part, separated by colon
	 * 
	 * @return double representation of seconds
	 */
	protected double convertMinutesToSeconds(String textWithMinutes) {
		String minutes;
		String seconds;
		String millis;
		double minuteValue = 0;
		double secondValue = 0;
		double milliValue = 0;

		if (textWithMinutes.contains(":") == true) {
			minutes = textWithMinutes.substring(0, textWithMinutes.indexOf(":"));
			minuteValue = Double.valueOf(minutes.trim()).doubleValue();

			if (textWithMinutes.contains(".") == true) {
				seconds = textWithMinutes.substring(textWithMinutes.indexOf(":") + 1, textWithMinutes.indexOf("."));

				millis = textWithMinutes.substring(textWithMinutes.indexOf("."));
				milliValue = Double.valueOf(millis.trim()).doubleValue();
			}
			else {
				seconds = textWithMinutes.substring(textWithMinutes.indexOf(":") + 1);
			}
			secondValue = Double.valueOf(seconds.trim()).doubleValue();
			return minuteValue * 60 + secondValue + milliValue;

		}
		else {
			return Double.valueOf(textWithMinutes.trim()).doubleValue();
		}
	}

	/**
	 * This method converts double value to its minute representation
	 * 
	 * @param valueWithSeconds
	 *            double value representing seconds
	 * 
	 * @return String containing minute part, separated by colon
	 */
	protected String convertSecondsToMinutes(double valueWithSeconds) {
		try {
			DecimalFormat format = new DecimalFormat("#.00");
			StringBuilder builder = new StringBuilder();
			String minuteValue = null;
			String secondValue = null;

			if (valueWithSeconds >= 60) {
				minuteValue = String.valueOf(((int) ((valueWithSeconds - valueWithSeconds % 60) / 60)));
				secondValue = format.format(valueWithSeconds % 60);
				builder.append(minuteValue);
				builder.append(":");
				builder.append(secondValue);
				return builder.toString().replace(",", ".");
			}
			else
				return format.format(valueWithSeconds).replace(",", ".");
		}
		catch (NumberFormatException e) {
			return String.valueOf(valueWithSeconds);
		}
	}

	/**
	 * Creates string representations from athlete objects
	 * 
	 * @param athletes
	 *            arraylist containing athlete objects
	 * 
	 * @return arraylist of athlete string representations
	 */
	protected ArrayList<String> createAthleteStrings(ArrayList<Athlete> athletes) {
		Collections.sort(athletes, new ScoreComparator());
		assignPositions(athletes);
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator('.');
		DecimalFormat df = new DecimalFormat("#.00", dfs);

		ArrayList<String> athleteStrings = new ArrayList<String>();
		for (Athlete a : athletes) {
			athleteStrings.add("Position: " + a.getPosition() + ", " + "score: " + a.getTotalScore() + ", " + a.getName() + ", "
					+ a.getDateOfBirthAsShortString() + ", " + a.getCountry() + ", " + df.format(a.getShortSprintResult()) + ", "
					+ df.format(a.getLongJumpResult()) + ", " + df.format(a.getShotPutResult()) + ", "
					+ df.format(a.getHighJumpResult()) + ", " + convertSecondsToMinutes(a.getLongSprintResult()) + ", "
					+ df.format(a.getHurdlesResult()) + ", " + df.format(a.getDiscusThrowResult()) + ", "
					+ df.format(a.getPoleVaultResult()) + ", " + df.format(a.getJavelinThrowResult()) + ", "
					+ convertSecondsToMinutes(a.getRaceResult()));
		}
		return athleteStrings;
	}

	/**
	 * Verifies data and creates athlete
	 * 
	 * @param nameIn
	 *            string containing athlete's name
	 * @param dateIn
	 *            string containing athlete's birth date
	 * @param countryIn
	 *            string containing athlete's country code
	 * @param shortSprintResultIn
	 *            string containing athlete's short sprint result
	 * @param longJumpResultIn
	 *            string containing long jump result
	 * @param shotPutResultIn
	 *            string containing athlete's shot put result
	 * @param highJumpResultIn
	 *            string containing athlete's high jump result
	 * @param longSprintResultIn
	 *            string containing athlete's long sprint result
	 * @param hurdlesResultIn
	 *            string containing athlete's hurdles result
	 * @param discusThrowResultIn
	 *            string containing athlete's discus throw result
	 * @param poleVaultResultIn
	 *            string containing athlete's pole vault result
	 * @param javelinThrowResultIn
	 *            string containing athlete's javelin throw result
	 * @param raceResultIn
	 *            string containing athlete's race result
	 * 
	 * @return Athlete object
	 * @throws ParseException
	 */
	protected Athlete verifyAndCreateAthlete(String nameIn, String dateIn, String countryIn, String shortSprintResultIn,
			String longJumpResultIn, String shotPutResultIn, String highJumpResultIn, String longSprintResultIn,
			String hurdlesResultIn, String discusThrowResultIn, String poleVaultResultIn, String javelinThrowResultIn,
			String raceResultIn) throws ParseException {

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

		if (verifyName(nameIn).equals(""))
			System.out.println("Warning: athlete does not have any name.");
		name = nameIn;

		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		dateOfBirth = dateFormat.parse(dateIn);

		if (verifyCountryCode(countryIn) == false)
			System.out.println("Warning: athlete does not live in any of the countries on Earth.");
		country = countryIn;

		shortSprintResult = Double.valueOf(shortSprintResultIn);
		CalculateTrackScores scoreShortSprint = CalculateTrackScores.valueOf("SPRINT_100M");
		totalScore += scoreShortSprint.calculateTrackScore(shortSprintResult);

		longJumpResult = Double.valueOf(longJumpResultIn);
		longJumpResult = longJumpResult * 100;
		CalculateFieldScores scoreLongJump = CalculateFieldScores.valueOf("LONG_JUMP");
		totalScore += scoreLongJump.calculateFieldScore(longJumpResult);

		shotPutResult = Double.valueOf(shotPutResultIn);
		CalculateFieldScores scoreShotPut = CalculateFieldScores.valueOf("SHOT_PUT");
		totalScore += scoreShotPut.calculateFieldScore(shotPutResult);

		highJumpResult = Double.valueOf(highJumpResultIn);
		highJumpResult = highJumpResult * 100;
		CalculateFieldScores scoreHighJump = CalculateFieldScores.valueOf("HIGH_JUMP");
		totalScore += scoreHighJump.calculateFieldScore(highJumpResult);

		longSprintResult = Double.valueOf(convertMinutesToSeconds(longSprintResultIn));
		CalculateTrackScores scoreLongSprint = CalculateTrackScores.valueOf("SPRINT_400M");
		totalScore += scoreLongSprint.calculateTrackScore(longSprintResult);

		hurdlesResult = Double.valueOf(hurdlesResultIn);
		CalculateTrackScores scoreHurdles = CalculateTrackScores.valueOf("HURDLES");
		totalScore += scoreHurdles.calculateTrackScore(hurdlesResult);

		discusThrowResult = Double.valueOf(discusThrowResultIn);
		CalculateFieldScores scoreDiscusThrow = CalculateFieldScores.valueOf("DISCUS_THROW");
		totalScore += scoreDiscusThrow.calculateFieldScore(discusThrowResult);

		poleVaultResult = Double.valueOf(poleVaultResultIn);
		poleVaultResult = poleVaultResult * 100;
		CalculateFieldScores scorePoleVault = CalculateFieldScores.valueOf("POLE_VAULT");
		totalScore += scorePoleVault.calculateFieldScore(poleVaultResult);

		javelinThrowResult = Double.valueOf(javelinThrowResultIn);
		CalculateFieldScores scoreJavelinThrow = CalculateFieldScores.valueOf("JAVELIN_THROW");
		totalScore += scoreJavelinThrow.calculateFieldScore(javelinThrowResult);

		raceResult = Double.valueOf(convertMinutesToSeconds(raceResultIn));
		CalculateTrackScores scoreRace = CalculateTrackScores.valueOf("SPRINT_1500M");
		totalScore += scoreRace.calculateTrackScore(raceResult);

		Athlete athlete = new Athlete(name, dateOfBirth, country, shortSprintResult, longJumpResult, shotPutResult,
				highJumpResult, longSprintResult, hurdlesResult, discusThrowResult, poleVaultResult, javelinThrowResult,
				raceResult, totalScore);
		return athlete;
	}

	/**
	 * Sets date format to 'dd.MM.yyyy'
	 * 
	 * @param dateIn
	 *            input date
	 * @return Formatted date
	 */
	protected String formatDate(Date dateIn) {
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		return format.format(dateIn);

	}

	/**
	 * Gets the full path of file
	 * 
	 * @param fileName
	 *            contains file name of full file path
	 * @return File path including full file path
	 */
	protected String getFullPath(String fileName) {
		File directory = new File(fileName);
		if (directory.isDirectory() == false) {
			fileName = directory.getAbsolutePath();
		}
		return fileName;
	}

	/**
	 * Checks if a file exists
	 * 
	 * @param fileName
	 *            contains file name of full file path
	 * @return true if file exists, false otherwise
	 */
	protected boolean checkIfFileExits(String fileName) {
		File f = new File(fileName);
		if (f.exists())
			return true;
		else
			return false;
	}

	/**
	 * Does some name verification
	 * 
	 * @param nameHelper
	 * @return name, empty string if name is empty
	 */
	protected String verifyName(String nameHelper) {
		if (nameHelper.matches("[.]*")) {
			return "";
		}
		else if (nameHelper.matches("[^0-9]+")) {
			return nameHelper;
		}
		else {
			System.out.println("Athlete has a funky name, but let's allow it.");
			return nameHelper;
		}
	}

	/**
	 * Checks if country code is valid
	 * 
	 * @param code
	 *            string representation of country code
	 * @return true if valid code, false otherwise
	 */
	protected boolean verifyCountryCode(String code) {
		for (String country : Locale.getISOCountries()) {
			if (country.equalsIgnoreCase(code)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Assigns positions to athlete objects
	 * 
	 * @param athletes
	 *            arraylist containing athlete objects
	 */
	protected void assignPositions(ArrayList<Athlete> athletes) {
		ArrayList<Integer> scores = new ArrayList<Integer>();
		int athleteIndex = 0;
		int limit = 0;
		String posStr = "";

		for (Athlete a : athletes) {
			if (scores.contains(a.getTotalScore()) == false) {
				scores.add(a.getTotalScore());
			}
		}

		ArrayList<Integer> scoreCounts = new ArrayList<Integer>(scores.size());
		for (int i = 0; i < scores.size(); i++) {
			scoreCounts.add(0);
		}

		for (Athlete a : athletes) {
			if (scores.contains(a.getTotalScore())) {
				scoreCounts.set(scores.indexOf(a.getTotalScore()), scoreCounts.get(scores.indexOf(a.getTotalScore())) + 1);
			}
		}

		for (int i = 0; i < scores.size(); i++) {
			limit = athleteIndex + scoreCounts.get(i);
			posStr = "[" + (athleteIndex + 1) + " - " + limit + "]";
			
			for (int j = athleteIndex; j < limit; j++) {
				if (scoreCounts.get(i) == 1)
					athletes.get(j).setPosition(String.valueOf(j + 1));
				else
					athletes.get(j).setPosition(posStr);
				athleteIndex++;
			}
		}
	}
}
