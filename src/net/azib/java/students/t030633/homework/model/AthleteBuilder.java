package net.azib.java.students.t030633.homework.model;

import java.util.Date;

/**
 * Interface for building athletes.
 *
 * @author t030633
 */
public interface AthleteBuilder {

	/**
	 * @param name - String, name for the athlete
	 * @return AthleteBuilder
	 */
	public AthleteBuilder name(String name);

	/**
	 * @param date - Date, birth date for the athlete
	 * @return AthleteBuilder
	 */
	public AthleteBuilder date(Date date);

	/**
	 * @param country - String, country for the athlete
	 * @return AthleteBuilder
	 */
	public AthleteBuilder country(String country);

	/**
	 * @param event - an event that the athlete participated in
	 * @param performance - performance in the event
	 * @return AthleteBuilder
	 */
	public AthleteBuilder addResult(Event event, Double performance);
	
	/**
	 * @return Athlete
	 */
	public Athlete build();

}