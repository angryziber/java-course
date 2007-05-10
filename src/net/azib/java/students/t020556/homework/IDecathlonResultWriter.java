package net.azib.java.students.t020556.homework;

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
}
