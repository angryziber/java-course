package net.azib.java.students.t072073.homework;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.DataFormatException;

/**
 * AthleteParser
 * 
 * @author janika
 * @description  validating and parsing the raw user given data for Athlete
 */
public class AthleteParser {
	
	private static int NAME = 0;
	private static int DATE_OF_BIRTH = 1;
	private static int COUNTRY_ISO_CODE = 2;
	private static int SHORT_SPRINT = 3;
	private static int LONG_JUMP = 4;
	private static int SHOT_PUT = 5;
	private static int HIGH_JUMP = 6;
	private static int LONG_SPRINT = 7;
	private static int HURDLES = 8;
	private static int DISCUS_THROW = 9;
	private static int POLE_VAULT = 10;
	private static int JAVELIN_THROW = 11;
	private static int RACE = 12;
	private static final int[] NUMERIC_RESULT_INDEX = { 
		SHORT_SPRINT, LONG_JUMP, SHOT_PUT, HIGH_JUMP, HURDLES, DISCUS_THROW, POLE_VAULT, JAVELIN_THROW
		};
	private static final int[] MINUTE_SECOND_RESULT_INDEX = {LONG_SPRINT, RACE};
	
	private String name;
	private String dateOfBirth;
	private String countryISOCode;
	private double shortSprint;
	private double longJump;
	private double shotPut;
	private double highJump;
	private double longSprint;
	private double hurdles;
	private double discusThrow;
	private double poleVault;
	private double javelinThrow;
	private double race;


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @return the countryISOCode
	 */
	public String getCountryISOCode() {
		return countryISOCode;
	}

	/**
	 * @return the shortSprint
	 */
	public double getShortSprint() {
		return shortSprint;
	}

	/**
	 * @return the longJump
	 */
	public double getLongJump() {
		return longJump;
	}

	/**
	 * @return the shotPut
	 */
	public double getShotPut() {
		return shotPut;
	}

	/**
	 * @return the highJump
	 */
	public double getHighJump() {
		return highJump;
	}

	/**
	 * @return the longSprint
	 */
	public double getLongSprint() {
		return longSprint;
	}

	/**
	 * @return the hurdles
	 */
	public double getHurdles() {
		return hurdles;
	}

	/**
	 * @return the discusThrow
	 */
	public double getDiscusThrow() {
		return discusThrow;
	}

	/**
	 * @return the poleVault
	 */
	public double getPoleVault() {
		return poleVault;
	}

	/**
	 * @return the javelinThrow
	 */
	public double getJavelinThrow() {
		return javelinThrow;
	}

	/**
	 * @return the race
	 */
	public double getRace() {
		return race;
	}

	
	/**
	 * athleteData[0] = name 
	 * athleteData[1] = date of birth 
	 * athleteData[2] =  country (check that is two characters) 
	 * athleteData[3] = 100m sprint (numeric) 
	 * athleteData[4] = long jump (numeric; to double) 
	 * athleteData[5] = shot put (numeric; to double) 
	 * athleteData[6] = high jump (numeric; to double) 
	 * athleteData[7] = 400m sprint (numeric; to seconds, to double)
	 * athleteData[8] = 110 hurdles (numeric; to double) 
	 * athleteData[9] = discus throw (numeric; to double) 
	 * athleteData[10] = pole vault (numeric; to double) 
	 * athleteData[11] = javelin throw (numeric; to double)
	 * athleteData[12] = 1500m race (numeric; to seconds, to double)
	 * @return 
	 */
	private void initialize(String[] athleteData) {
		this.name = athleteData[NAME];
		this.dateOfBirth = athleteData[DATE_OF_BIRTH];
		this.countryISOCode = athleteData[COUNTRY_ISO_CODE];
		this.shortSprint = Double.parseDouble(athleteData[SHORT_SPRINT]);
		this.longJump = Double.parseDouble(athleteData[LONG_JUMP]);
		this.shotPut = Double.parseDouble(athleteData[SHOT_PUT]);
		this.highJump = Double.parseDouble(athleteData[HIGH_JUMP]);
		this.longSprint = convertToSeconds(athleteData[LONG_SPRINT]);
		this.hurdles = Double.parseDouble(athleteData[HURDLES]);
		this.discusThrow = Double.parseDouble(athleteData[DISCUS_THROW]);
		this.poleVault = Double.parseDouble(athleteData[POLE_VAULT]);
		this.javelinThrow = Double.parseDouble(athleteData[JAVELIN_THROW]);
		this.race = convertToSeconds(athleteData[RACE]);
	}

	/**
	 * 
	 * @param rawAthleteData - raw athlete data as string (from file or console)
	 * @throws DataFormatException
	 * @description validates the data from user to correct format for Athlete class
	 */
	public AthleteParser(String rawAthleteData) throws DataFormatException{
		String [] athleteData = rawAthleteData.split("[,]+");
		if (athleteData.length != 13){
			throw new DataFormatException("Not enough data! Check your commas");
		}
		else if(!isCountryCode(athleteData[2])){
			throw new DataFormatException("Country code "+ athleteData[2] +" must consist of two capital letters.");	
		}
		else if(!resultsAreNumeric(athleteData)){
			throw new DataFormatException("Please check yout data. All results must be numeric values");
		}
		else if(!sprintAndRaceInRightFormat(athleteData)){
			throw new DataFormatException("Please check yout data. Race and long sprint results must be minutes and seconds (e.g. 12:20)");
		}
		else{
			initialize(athleteData);
		}
	}
	
	/**
	 * 
	 * @param dbSet - result set from database
	 * @description - collects the data for Athlete
	 * @throws SQLException
	 */
	public AthleteParser(ResultSet dbSet) throws SQLException{
		this.name = dbSet.getString(1);
		Date dob = dbSet.getDate(2);
		this.dateOfBirth = dob == null ? null :new SimpleDateFormat("dd.MM.yyyy").format(dob);
        this.countryISOCode = dbSet.getString(3);
		this.shortSprint = dbSet.getDouble("race_100m");
		this.longJump = dbSet.getDouble("long_jump");
		this.shotPut = dbSet.getDouble("shot_put");
		this.highJump = dbSet.getDouble("high_jump");
		this.longSprint  = dbSet.getDouble("race_400m");
		this.hurdles = dbSet.getDouble("hurdles_110m");
		this.discusThrow = dbSet.getDouble("discus_throw");
		this.poleVault = dbSet.getDouble("pole_vault");
		this.javelinThrow = dbSet.getDouble("javelin_throw");
		this.race = dbSet.getDouble("race_1500m");
	}

	private boolean resultsAreNumeric(String[] args){
		for (int i = 0; i < NUMERIC_RESULT_INDEX.length; i++) {
			int index = NUMERIC_RESULT_INDEX[i];
			if (!isNumeric(args[index])) {
				System.out.println(args[index]);
				return false;
			}
		}
		return true;
	}

	private boolean isCountryCode(String code) {
		return code.matches("^[A-Z][A-Z]$");
	}

	private boolean isNumeric(String s) {
		return s.matches("^[0-9]*\\.?[0-9]*");
	}
	
	private boolean sprintAndRaceInRightFormat(String [] args){
		for (int i = 0; i < MINUTE_SECOND_RESULT_INDEX.length; i++) {
			int index = MINUTE_SECOND_RESULT_INDEX[i];
			if (!isMinutesAndSeconds(args[index])) {
				System.out.println(args[index]);
				return false;
			}
		}
		return true;
	}

	private boolean isMinutesAndSeconds(String s) {
		return s.matches("^[0-9]*:[0-9]*\\.?[0-9]*");
	}

	private double convertToSeconds(String rawTime) {
		String[] time = rawTime.split(":");
		double mins = Double.parseDouble(time[0]);
		double sec = Double.parseDouble(time[1]);
		return mins * 60 + sec;
	}
}
