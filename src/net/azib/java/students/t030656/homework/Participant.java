package net.azib.java.students.t030656.homework;

import java.util.Calendar;




/**
 * Participant
 *
 * @author Sprot
 */
public class Participant {
	
	private String name;
	private Calendar dateOfBirth;
	private String country;
	private int points;
	private double[] results = {0,0,0,0,0,0,0,0,0,0}; 

	
	
	/**
	 * constructor
	 */
	public Participant(String name, String country, String dateOfBirth, double[] results) {
		this.name = name;
		this.country = country;
		this.results = results;
		points = calcPoints();
	}

	/**
	 * @return the points
	 */
	private int calcPoints() {
		return Event.RUN100.getPoints(results[0]) +
					Event.LONGJUMP.getPoints(results[1]) +
					Event.SHOTPUT.getPoints(results[2]) +
					Event.HIGHJUMP.getPoints(results[3]) +
					Event.RUN400.getPoints(results[4]) +
					Event.RUNHURDLES.getPoints(results[5]) +
					Event.DISCUSTHROW.getPoints(results[6]) +
					Event.POLEVAULT.getPoints(results[7]) +
					Event.JAVELINTHROW.getPoints(results[8]) +
					Event.RUN1500.getPoints(results[9]);
	}
	/**
	 * @return the points
	 */
	public int getPoints() {
		return points;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the dateOfBirth
	 */
	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @return the results
	 */
	public double[] getResults() {
		return results;
	}
}
