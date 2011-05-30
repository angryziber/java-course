package net.azib.java.students.t093759.homework;

import java.util.Collection;

/**
 * @author dionis
 *         5/29/1110:07 PM
 */
public interface AthleteLoader {
	/**
	 * Load collection of athletes and return them.
	 *
	 * @param additionalParams Some additional parameters could be passed if necessary.
	 * @return Collection of loaded athletes or empty collection.
	 */
	Collection<Athlete> load(Object... additionalParams);
}
