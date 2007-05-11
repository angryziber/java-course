package net.azib.java.students.t020556.homework;

import java.util.PriorityQueue;

/**
 * IDecathlonResultWriter
 *
 * @author agu
 */
public interface IDecathlonResultWriter {
	
	/**
	 * @author Agu Aarna
	 * 
	 * @param reader - specific reader which is specialized in decathlon results reading
	 * 
	 * @version 1
	 */
	public void writeResults(IDecathlonResultReader reader);

	/**
	 * @author Agu Aarna
	 * 
	 * @param compQ - a prioritized queue of competitors
	 * 
	 * @version 1
	 */
	public void writeResults(PriorityQueue<Competitor> compQ);
}
