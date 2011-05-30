package net.azib.java.students.t093759.homework;

import java.util.Collection;

/**
 * @author dionis
 *         5/29/1110:23 PM
 */
public interface AthletesSaver {
	/**
	 * Save collection of athletes.
	 * @param athletes Athletes to be saved.
	 * @param additionalParameters Some additional parameters that could be needed for persistence.
	 */
	void save(Collection<Athlete> athletes, Object... additionalParameters);
}
