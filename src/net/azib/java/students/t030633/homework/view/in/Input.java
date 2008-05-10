package net.azib.java.students.t030633.homework.view.in;

import net.azib.java.students.t030633.homework.model.Athlete;
import net.azib.java.students.t030633.homework.model.AthleteBuilder;

import java.io.IOException;
import java.util.List;

/**
 * Decathlon input interface - all inputs provide a list of athletes.
 * 
 * @author t030633
 */
public interface Input {

	/**
	 * @param builder -
	 *            AthleteBuilder to build athletes
	 * @return List<Athlete> - a list of athletes
	 * @throws IOException
	 *             if reading fails
	 */
	List<Athlete> read(AthleteBuilder builder) throws IOException;

}
