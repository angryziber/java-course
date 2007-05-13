package net.azib.java.students.t020556.homework;

import java.io.OutputStream;
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

	/**
	 * @author Agu Aarna
	 * 
	 * @param out - an output stream to which to write to
	 * 
	 * @version 1
	 */
	public void setStream(OutputStream out);
}
