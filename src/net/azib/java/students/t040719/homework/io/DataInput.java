package net.azib.java.students.t040719.homework.io;

import net.azib.java.students.t040719.homework.Athlete;

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
	 * @param parameters contains input identifier
	 * @return list of decathlon results
	 */
	List<Athlete> getResults(String... parameters);
}
