package net.azib.java.students.t110013.homework.writers;

import net.azib.java.students.t110013.homework.model.Athlete;

import java.util.List;

/**
 * An interface for different AthletesWriter implementations. Specifies only one method, which is called from
 * the model of application.
 * @author Vadim
 */
public interface AthletesWriter {

	/**
	 * Writes Athletes' data to the specified destination.
	 * @param athletes a List of athletes to be written
     * @see Athlete
	 */
	public void writeAthletes(List<Athlete> athletes);
}
