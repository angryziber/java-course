package net.azib.java.students.t110013.homework.readers;

import net.azib.java.students.t110013.homework.model.Athlete;

import java.util.List;

/**
 * An interface for different AthletesReader implementations. Specifies only one method, which is called from
 * the model of application.
 * @author Vadim
 */
public interface AthletesReader {

	/**
	 * Returns a list of Athletes build from the specified source.
	 * @see Athlete
	 * @return a list of Athletes
	 */
    public List<Athlete> getAthletes();
}
