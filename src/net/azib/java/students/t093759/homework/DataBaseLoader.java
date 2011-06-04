package net.azib.java.students.t093759.homework;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dionis
 *         5/30/114:00 AM
 */
public class DataBaseLoader implements AthletesLoader {
	Connection connection;

	@Override
	public List<Athlete> load(Object... additionalParams) {
		if (additionalParams.length < 1) throw new IllegalArgumentException("One parameter should be");
		if (!(additionalParams[0] instanceof String)) throw new IllegalArgumentException("One parameter should be");

		List<Athlete> athletes = new ArrayList<Athlete>(100);
		return athletes;
	}
}
