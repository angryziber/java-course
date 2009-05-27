package net.azib.java.students.t030520.homework.event;

/**
 * An Event interface for both track and field events. 
 *
 * @author t030520
 */
public interface Event {

	/**
	 * @return the A coefficient.
	 */
	public float getA();

	/**
	 * @return the B coefficient.
	 */
	public float getB();

	/**
	 * @return the B coefficient.
	 */
	public float getC();

	/**
	 * @return the name of event enum type.
	 */
	public String getName();

	/**
	 * @return true if events are equal.
	 */
	public boolean equals(Event event);

}
