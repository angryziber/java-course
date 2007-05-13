package net.azib.java.students.t020556.homework;

import java.io.OutputStream;
import java.util.PriorityQueue;

/**
 * IDecathlonResultWriter interface exposes methods to write Dechatlon results in a specific fashion
 *
 * @author agu
 */
public interface IDecathlonResultWriter {
	
	/**
	 * writeResults method writes the decathlon results according to the implementation
	 * 
	 * @author Agu Aarna
	 * 
	 * @param reader - specific reader which is specialized in decathlon results reading
	 * 
	 * @version 1
	 */
	public void writeResults(IDecathlonResultReader reader);

	/**
	 * writeResults method writes the decathlon results according to the implementation
	 * 
	 * @author Agu Aarna
	 * 
	 * @param compQ - a prioritized queue of competitors
	 * 
	 * @version 1
	 */
	public void writeResults(PriorityQueue<Competitor> compQ);

	/**
	 * setStream method sets a stream to which an implementation class may write to
	 * 
	 * @author Agu Aarna
	 * 
	 * @param out - an output stream to which to write to
	 * 
	 * @version 1
	 */
	public void setStream(OutputStream out);
}
