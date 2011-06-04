package net.azib.java.students.t093759.homework;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.Connection;
import java.util.List;

/**
 * @author dionis
 *         5/30/114:00 AM
 */
public class DataBaseLoader implements AthletesLoader {
	Connection connection;
	@Override
	public List<Athlete> load(Object... additionalParams) {
		throw new NotImplementedException();
	}
}
