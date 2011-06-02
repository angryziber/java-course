package net.azib.java.students.t093759.homework;

import java.util.List;

/**
 * @author dionis
 *         5/29/1110:07 PM
 */
public interface AthletesLoader {
	/**
	 * Load list of athletes and return them.
	 *
	 * @param additionalParams Some additional parameters could be passed if necessary.
	 * @return List of loaded athletes or empty list.
	 */
	List<Athlete> load(Object... additionalParams);
}
