package net.azib.java.students.t030630.homework;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * a class that holds information and results of an athlete at competition
 * 
 * @author Sergei
 */
public class Athlete {

	private String name;
	private Date dateOfBirth;
	private String country;
	private float sec100mSprint;
	private float mLongJump;
	private float mShotPut;
	private float mHighJump;
	private MinSecHolder minSec400mSprint;
	private float sec110mHurdles;
	private float mDiscusThrow;
	private float mPoleVault;
	private float mJavelinthrow;
	private MinSecHolder minSec1500mRace;
	private int points;
	private String place;
	private boolean isDataFormatCorrect;

	public Athlete(String InputData) {
		if (isDataFormatCorrect = parseInputData(InputData))
			points = calcPoints();
		place = "not defined";
	}

	public boolean isDataCorrect() {
		return isDataFormatCorrect;
	}

	/**
	 * parses input data and writes it to variables
	 * 
	 * @param inputData
	 *            information about athlete: competition results and personal
	 *            info
	 * @throws ParseException
	 * @throws NumberFormatException
	 */
	private boolean parseInputData(String inputData) {
		String[] input = inputData.split(",");
		if (input.length != 13) {
			System.err.println("Some data is missed. Expected 13 instead of " + input.length + " tokens");
			return false;
		}

		if (input[0].indexOf("\"") != -1 || input[0].indexOf("\"") != input[0].lastIndexOf("\""))
			name = input[0].substring(input[0].indexOf("\"") + 1, input[0].lastIndexOf("\""));
		else
			name = input[0];
		DateFormat df = new SimpleDateFormat("dd.mm.yyyy");
		try {
			dateOfBirth = df.parse(input[1]);
		}
		catch (ParseException e) {
			System.err.println("Format of birthday is incorrect. It must be in format: dd.MM.yyyy");
			return false;
		}

		country = "";
		Locale[] locales = Locale.getAvailableLocales();
		for (Locale locale : locales) {
			if (locale.getCountry().equals(input[2].trim()) || locale.getDisplayCountry().equals(input[2].trim()))
				country = locale.getDisplayCountry();
		}
		if (country.equals("") && input[2].length() != 2) {
			System.err.println("Format of Country data is incorrect. It must have 2 letters instead of " + input[2].length());
			return false;
		}

		try {
			sec100mSprint = Float.parseFloat(input[3]);
			mLongJump = Float.parseFloat(input[4]);
			mShotPut = Float.parseFloat(input[5]);
			mHighJump = Float.parseFloat(input[6]);
			minSec400mSprint = new MinSecHolder(input[7]);
			sec110mHurdles = Float.parseFloat(input[8]);
			mDiscusThrow = Float.parseFloat(input[9]);
			mPoleVault = Float.parseFloat(input[10]);
			mJavelinthrow = Float.parseFloat(input[11]);
			minSec1500mRace = new MinSecHolder(input[12]);
		}
		catch (NumberFormatException e) {
			System.err.println("Incorrect data format while reading competition results");
			return false;
		}
		return true;
	}

	public int getPoints() {
		return points;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public float getSec100mSprint() {
		return sec100mSprint;
	}

	public String getName() {
		return name;
	}

	/**
	 * formula of calculating points for running events
	 * 
	 * @param A
	 *            constant
	 * @param B
	 *            constant
	 * @param C
	 *            constant
	 * @param P
	 *            performance
	 */
	private int calcPointsForRunningEvents(float A, float B, float C, float P) {
		return (int) (A * Math.pow(B - P, C));
	}

	/**
	 * formula of calculating points for field events
	 * 
	 * @param A
	 *            constant
	 * @param B
	 *            constant
	 * @param C
	 *            constant
	 * @param P
	 *            performance
	 */
	private int calcPointsForFieldEvents(float A, float B, float C, float P) {
		return (int) (A * Math.pow(P - B, C));
	}

	/**
	 * calculates total points got at competition
	 */
	private int calcPoints() {
		return (int) (calcPointsForRunningEvents(25.437f, 18.0f, 1.81f, sec100mSprint)
				+ calcPointsForFieldEvents(0.14354f, 220f, 1.40f, (mLongJump * 100))
				+ calcPointsForFieldEvents(51.39f, 1.5f, 1.05f, mShotPut)
				+ calcPointsForFieldEvents(0.8465f, 75f, 1.42f, (mHighJump * 100))
				+ calcPointsForRunningEvents(1.53775f, 82f, 1.81f, minSec400mSprint.getInsec())
				+ calcPointsForRunningEvents(5.74352f, 28.5f, 1.92f, sec110mHurdles)
				+ calcPointsForFieldEvents(12.91f, 4.0f, 1.1f, mDiscusThrow)
				+ calcPointsForFieldEvents(0.2797f, 100f, 1.35f, (mPoleVault * 100))
				+ calcPointsForFieldEvents(10.14f, 7.0f, 1.08f, mJavelinthrow) + calcPointsForRunningEvents(0.03768f, 480f,
				1.85f, minSec1500mRace.getInsec()));
	}

	/**
	 * show Athlete personal information(name, points, birthday, country) and
	 * results got at competition
	 */
	public String getAthletePersonalInfoAndResults() {
		StringBuilder athleteCompleteInfo = new StringBuilder();
		DateFormat df = new SimpleDateFormat("dd.mm.yyyy");
		athleteCompleteInfo.append(place).append(",").append(points).append(",").append(name).append(",").append(
				df.format(dateOfBirth)).append(",").append(country).append(",").append(sec100mSprint).append(",").append(
				mLongJump).append(",").append(mShotPut).append(",").append(mHighJump).append(",").append(
				minSec400mSprint.getInsec()).append(",").append(sec110mHurdles).append(",").append(mDiscusThrow).append(",")
				.append(mPoleVault).append(",").append(mJavelinthrow).append(",").append(minSec1500mRace.getInsec());
		return athleteCompleteInfo.toString();
	}

	public String getCountry() {
		return country;
	}

	public float getMLongJump() {
		return mLongJump;
	}

	public float getMShotPut() {
		return mShotPut;
	}

	public float getMHighJump() {
		return mHighJump;
	}

	public MinSecHolder getMinSec400mSprint() {
		return minSec400mSprint;
	}

	public float getSec110mHurdles() {
		return sec110mHurdles;
	}

	public float getMDiscusThrow() {
		return mDiscusThrow;
	}

	public float getMPoleVault() {
		return mPoleVault;
	}

	public float getMJavelinthrow() {
		return mJavelinthrow;
	}

	public MinSecHolder getMinSec1500mRace() {
		return minSec1500mRace;
	}

	public String getPlace() {
		return place;
	}
}
