package net.azib.java.students.t020556.homework;

import java.io.InputStream;
import java.util.LinkedHashSet;

/**
 * IDechatlonResultReader interface exposes methods to read Dechatlon results in
 * a specific fashion
 *
 * @author Agu Aarna
 * @version 1
 */
public interface IDechatlonResultReader {
	public LinkedHashSet<Competitor> readResults(InputStream input);
}
