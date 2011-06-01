package net.azib.java.students.t093759.homework;

import java.util.List;

/**
 * @author dionis
 *         5/29/1110:23 PM
 */
public interface AthletesOutput {
	/**
	 * Save list of athletes.
	 *
	 * @param athletes             Athletes to be saved.
	 * @param additionalParameters Some additional parameters that could be needed for persistence.
	 */
	void output(List<Athlete> athletes, Object... additionalParameters);
}
