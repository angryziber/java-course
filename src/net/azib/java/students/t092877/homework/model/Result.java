package net.azib.java.students.t092877.homework.model;

import net.azib.java.students.t092877.homework.model.Event;

/**
 * Result.java
 * Purpose: models the result of decathlon event
 *
 * @author Artjom Kruglenkov / 092877
 * @version 1.0 20.05.2011
 */
public class Result {

	private Event event;
	private double value;

	/**
	 * Creates a new Result instance from an instance of specified Event and its result value.
	 *
	 * @param event an instance of specified decathlon event
	 * @param value a result value of specified decathlon event
	 */
	public Result(Event event, double value) {
		this.event = event;
		this.value = value;
	}

	/**
	 * Returns a type of event for specified result.
	 *
	 * @return a type of event
	 */
	public Event getEvent() {
		return event;
	}

	/**
	 *  Sets a type of event for corresponding result.
	 *
	 * @param event a type of event
	 */
	public  void setEvent(Event event) {
		this.event = event;
	}

	/**
	 * Returns a result value.
	 *
	 * @return a result value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Sets a result value.
	 *
	 * @param value a result value
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * Returns a score for the specified decathlon event based on a result value.
	 *
	 * @return a score for the specified decathlon event
	 */
	public int getScore(){
		return event.getScore(value);
	}
}

