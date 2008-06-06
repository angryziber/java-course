package net.azib.java.students.t061932.homework;

import java.util.*;
import java.math.*;

class Athlete {
	private String name;
	private String country;
	private Calendar birthDate;
	private double hundredMeterSprint; //in seconds
	private double longJump;
	private double  shot;
	private double highJump;
	private double fourHundredMeterSprint; // in seconds
	private double hurdles; //in seconds
	private double discusThrow;
	private double poleVault;
	private double javelinThrow;
	private double race; //in seconds
	private double pointTotal;
	
	/**
	 * This constructor creates an Athlete  objected with its 
	 * name, country and birthdate set to those provided in arguments.
	 * <p>
	 * @param 		name the first and the second name of the athlete
	 * @param 		country the country for with the athlete participated
	 * @param 		year athletes year of birth
	 * @param 		month athletes month of birth
	 * @param 		day athletes day of birth
	 */
	public Athlete(String name, String country, int year, int month, int day)
	{
		setName(name);
		setBirthDate(year, month, day);
		setCountry(country);
	}

	/**
	 * This method returns the precalculated summary of athletes points for all competitions
	 * <p>
	 * @return      athletes point summary for all 10 competitions
	 * @see         calculatePoints()
	 */
	public double getPoints()
	{
		return pointTotal;
	}
	
	/**
	 * This method returns the first and the last name of the athlete
	 * <p>
	 * @return      athletes first and last name in one String object
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * This method returns the birtdate of the athlete in a format dd.mm.yyyy
	 * <p>
	 * @return      athletes birthdate represented by a String object
	 */
	public String getBirthDate()
	{
		 Integer year = birthDate.get(Calendar.YEAR);
		 Integer month = birthDate.get(Calendar.MONTH);
		 Integer day = birthDate.get(Calendar.DAY_OF_MONTH);
		 return day.toString() + "." + month.toString() + "." + year.toString();
	}
	
	/**
	 * This method returns the name  of the country for wich the athlete participated in an ISO 2-letter format
	 * <p>
	 * @return      athletes country
	 */
	public String getCountry()
	{
		return country;
	}
	
	/**
	 * This method is used to set athletes results in 10 competions.
	 * Raw results are provided by the array of double values. 
	 * The results are considered to be stored sequently in the array in a propper order, which is:
	 * 100 m sprint (sec)
     * Long jump (m)
     * Shot put (m)
     * High jump (m)
     * 400 m sprint (sec)
     * 110 m hurdles (sec)
     * Discus throw (m)
     * Pole vault (m)
     * Javelin throw (m)
     * 1500 m race (sec) 
	 * <p>
	 * @param 		resultArray an array that contains raw results in the mentioned above order
	 */
	public void setResults(double[] resultArray)
	{
		hundredMeterSprint = resultArray[0];
		longJump = resultArray[1];
		shot = resultArray[2];
		highJump = resultArray[3];
		fourHundredMeterSprint = resultArray[4];
		hurdles = resultArray[5];
		discusThrow = resultArray[6];
		poleVault  = resultArray[7];
		javelinThrow = resultArray[8];
		race = resultArray[9];
		pointTotal = calculatePoints();
	}
	
	/**
	 * This method returns an array of double values that contains raw athletes results 
	 * in the order mentioned in setResults()
	 * <p>
	 * @return      an array of raw results
	 * @see			Athlete.setResults(double[] resultArray)
	 */
	public double[] getResults()
	{
		double[] results = { hundredMeterSprint, 
		longJump,
		shot,
		highJump,
		fourHundredMeterSprint,
		hurdles,
		discusThrow,
		poleVault,
		javelinThrow,
		race };
		return results;
	}
	
	private double calculatePoints()
	{
		double hMeterSprintPoints = 25.437*Math.pow(18 - hundredMeterSprint, 1.81);
		double longJumpPoints = 0.14354*Math.pow(longJump*100 - 220, 1.40);
		double shotPoints = 51.39*Math.pow(shot - 1.5, 1.05);
		double highJumpPoints = 0.8465*Math.pow(highJump*100 - 75, 1.42);
		double fMeterSprintPoints = 1.53775*Math.pow(82 - fourHundredMeterSprint, 1.81);
		double hurdlesPoints = 5.74352*Math.pow(28.5 - hurdles, 1.92);
		double discusThrowPoints = 12.91*Math.pow(discusThrow - 4, 1.1);
		double poleVaultPoints = 0.2797*Math.pow(poleVault*100 - 100 , 1.35);
		double javelinThrowPoints = 10.14*Math.pow(javelinThrow - 7, 1.08);
		double racePoints = 0.03768*Math.pow(480 - race, 1.85);
		
		return (hMeterSprintPoints + longJumpPoints + shotPoints + highJumpPoints + fMeterSprintPoints + hurdlesPoints + discusThrowPoints + poleVaultPoints + javelinThrowPoints +racePoints);
	}
	
	private void setName(String name)
	{
		this.name = name;
	}
	
	private void setBirthDate(int year, int month, int day)
	{
		birthDate = Calendar.getInstance();
		birthDate.set(year, month, day);
	}
	private void setCountry(String country)
	{
		this.country = country;
	}

}