package net.azib.java.students.t030633.homework.view;

import net.azib.java.students.t030633.homework.model.Athlete;
import net.azib.java.students.t030633.homework.model.AthleteBuilder;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

/**
 * Decathlon input interface - all inputs provide a list of athletes.
 * 
 * @author t030633
 */
public interface Input extends Closeable {

	/**
	 * @param builder -
	 *            AthleteBuilder, gives a builder instance to input
	 * @return Input
	 */
	Input builder(AthleteBuilder builder);

	/**
	 * @return List<Athlete> - a list of athletes
	 * @throws IOException
	 *             if read fails
	 */
	List<Athlete> read() throws IOException;

}
