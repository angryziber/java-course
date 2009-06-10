package net.azib.java.students.t030520.homework.event;

/**
 * An Event interface for both track and field events. 
 *
 * @author t030520
 */
public interface Event {

	/**
	 * @return the name of event enum type.
	 */
	public String getName();

	/**
	 * @return true if events are equal.
	 */
	public boolean equals(Event event);

	/**
	 * @param result the result of event.
	 * @return the calculated points.
	 */
	public int getPoints(float result);

}
