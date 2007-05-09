package net.azib.java.students.t020556.homework;

import java.io.InputStream;
import java.util.PriorityQueue;

/**
 * IDechatlonResultReader interface exposes methods to read Dechatlon results in
 * a specific fashion
 *
 * @author Agu Aarna
 * 
 * @version 1
 */
public interface IDechatlonResultReader {
	/**
	 * readResults reads the results from the specified stream
	 *
	 * @author Agu Aarna
	 * 
	 * @version 1
	 */
	public PriorityQueue<Competitor> readResults();

	/**
	 * setStream sets the input stream internally
	 *
	 * @author Agu Aarna
	 * 
	 * @version 1
	 */
	public void setStream(InputStream in);
}
