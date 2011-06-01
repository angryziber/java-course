package net.azib.java.students.t093759.homework;

import java.util.Collections;
import java.util.List;

/**
 * @author dionis
 *         5/30/113:57 AM
 */
public class CSVLoader implements AthletesLoader {
	/**
	 * @param additionalParams Filename with results in .csv.
	 * @return List of loaded athletes or empty collection.
	 */
	@Override
	public List<Athlete> load(Object... additionalParams) {
		if(additionalParams.length<1) throw new IllegalArgumentException("One parameter needed.");
		if(!(additionalParams[0] instanceof String)) throw new IllegalArgumentException("Parameter should be a string.");


		return Collections.emptyList();
	}
}
