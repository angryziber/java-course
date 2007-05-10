package net.azib.java.students.t020556.homework;

import java.util.PriorityQueue;

/**
 * IDecathlonResultReader interface exposes methods to read Dechatlon results in
 * a specific fashion
 *
 * @author Agu Aarna
 * 
 * @version 1
 */
public interface IDecathlonResultReader {
	/**
	 * readResults reads the results from the specified stream
	 *
	 * @author Agu Aarna
	 * 
	 * @version 1
	 */
	public PriorityQueue<Competitor> readResults();
}
