package net.azib.java.students.t040719.homework.io;

import net.azib.java.students.t040719.homework.Athlete;

import java.io.IOException;
import java.util.List;

/**
 * DataInput - an interface for obtaining decathlon results
 *
 * @version 1.0
 * @author Romi Agar
 */
public interface DataInput {
	/**
	 * Gets the decathlon results from various inputs.
	 * 
	 * @return list of decathlon results
	 * @throws IOException if input fails somehow
	 */
	List<Athlete> getResults() throws IOException;
}
