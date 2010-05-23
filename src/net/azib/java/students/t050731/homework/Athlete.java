package net.azib.java.students.t050731.homework;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Athlete
 * 
 * Athlete class, represents athlete object
 * 
 * @author Raigo
 */
public class Athlete {

	private String name;
	private Date dateOfBirth;
	private String country;
	private double shortSprintResult;
	private double longJumpResult;
	private double shotPutResult;
	private double highJumpResult;
	private double longSprintResult;
	private double hurdlesResult;
	private double discusThrowResult;
	private double poleVaultResult;
	private double javelinThrowResult;
	private double raceResult;
	private int totalScore;
	private String position;

	public Athlete(String inName, Date inDateOfBirth, String inCountry, double inShortSprint, double inLongJump,
			double inShotPut, double inHighJump, double inLongSprint, double inHurdles, double inDiscusThrow, double inPoleVault,
			double inJavelinThrow, double inRace, int inTotalScore) {

		this.name = inName;
		this.dateOfBirth = inDateOfBirth;
		this.country = inCountry;
		this.shortSprintResult = inShortSprint;
		this.longJumpResult = inLongJump;
		this.shotPutResult = inShotPut;
		this.highJumpResult = inHighJump;
		this.longSprintResult = inLongSprint;
		this.hurdlesResult = inHurdles;
		this.discusThrowResult = inDiscusThrow;
		this.poleVaultResult = inPoleVault;
		this.javelinThrowResult = inJavelinThrow;
		this.raceResult = inRace;
		this.totalScore = inTotalScore;
	}

	/**
	 * @return the name
	 */
	protected String getName() {
		return name;
	}

	/**
	 * @return the dateOfBirth
	 */
	protected Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @return the dateOfBirth
	 */
	protected String getDateOfBirthAsShortString() {
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		return dateFormat.format(dateOfBirth);
	}

	/**
	 * @return the country
	 */
	protected String getCountry() {
		return country;
	}

	/**
	 * @return the shortSprintResult
	 */
	protected double getShortSprintResult() {
		return shortSprintResult;
	}

	/**
	 * @return the longJumpResult
	 */
	protected double getLongJumpResult() {
		return longJumpResult/100;
	}

	/**
	 * @return the shotPutResult
	 */
	protected double getShotPutResult() {
		return shotPutResult;
	}

	/**
	 * @return the highJumpResult
	 */
	protected double getHighJumpResult() {
		return highJumpResult/100;
	}

	/**
	 * @return the longSprintResult
	 */
	protected double getLongSprintResult() {
		return longSprintResult;
	}

	/**
	 * @return the hurdlesResult
	 */
	protected double getHurdlesResult() {
		return hurdlesResult;
	}

	/**
	 * @return the discusThrowResult
	 */
	protected double getDiscusThrowResult() {
		return discusThrowResult;
	}

	/**
	 * @return the poleVaultResult
	 */
	protected double getPoleVaultResult() {
		return poleVaultResult/100;
	}

	/**
	 * @return the javelinThrowResult
	 */
	protected double getJavelinThrowResult() {
		return javelinThrowResult;
	}

	/**
	 * @return the raceResult
	 */
	protected double getRaceResult() {
		return raceResult;
	}

	/**
	 * @return the totalScore
	 */
	protected int getTotalScore() {
		return totalScore;
	}
	
	/**
	 * @return the position
	 */
	protected String getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	protected void setPosition(String position) {
		this.position = position;
	}
}
