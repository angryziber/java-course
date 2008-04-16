package net.azib.java.students.t030633.homework.view;

import net.azib.java.students.t030633.homework.model.Athlete;

import java.io.IOException;
import java.util.List;

/**
 * Decathlon output interface - all outputs write a list of athletes.
 * 
 * @author t030633
 */
public interface Output {

	/**
	 * @param out -
	 *            List<Athlete>, a list of athletes to output
	 * @throws IOException
	 *             if output fails
	 */
	void write(List<Athlete> out) throws IOException;

}
