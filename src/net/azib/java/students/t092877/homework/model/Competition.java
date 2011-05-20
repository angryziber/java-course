package net.azib.java.students.t092877.homework.model;

import net.azib.java.students.t092877.homework.model.Athlete;

import java.util.ArrayList;
import java.util.List;

/**
 * Competition.java
 * Purpose: models the decathlon competition
 *
 * @author Artjom Kruglenkov  / 092877
 * @version 1.0 20.05.2011
 */
public class Competition {

	private String name;
	private String location;
	private String date;         // date of birth in yyyy-mm-dd format
	private List<Athlete> athletesList = new ArrayList<Athlete>();

	/**
	 * Returns the name of decathlon competition.
	 *
	 * @return the name of decathlon competition
	 */
	public String getName() {
		return name;
	}

	/**
	 *Sets the name of decathlon competition.
	 *
	 * @param name the name of decathlon competition
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the location of decathlon competition.
	 *
	 * @return the location of decathlon competition
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * Sets the location of decathlon competition.
	 *
	 * @param location the location of decathlon competition
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * Returns the date of decathlon competition.
	 *
	 * @return the date of decathlon competition
	 */
	public String getDate() {
		return date;
	}

	/**
	 * Sets the date of decathlon competition.
	 *
	 * @param date the date of decathlon competition
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Returns a list of athletes for decathlon competition.
	 *
	 * @return a list of athletes for decathlon competition
	 */
	public List<Athlete> getAthletesList() {
		return athletesList;
	}

	/**
	 * Sets a list of athletes for decathlon competition.
	 *
	 * @param athletesList the list of athletes for decathlon competition
	 */
	public void setAthletesList(List<Athlete> athletesList) {
		this.athletesList = athletesList;
	}

	/**
	 * Returns a string representation of this decathlon competition.
	 *
	 * @return a string representation of this decathlon competition
	 */
	public String toString() {
		return "\"" + getName().toUpperCase()
		            + "\" / " + getLocation()
		            + " / " + getDate();
	}
}


