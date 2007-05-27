package net.azib.java.students.t010691.homework;

/**
 * OutputData
 * 
 * Represents an abstract output data stream
 *
 * @author Ilja Lutov
 */
abstract class OutputData {
	
	/**
	 * Sends competition results to an output stream
	 * Must be overriden by child classes to implement a particular resource
	 * 
	 * @param competitor athlete's personal info and competition results
	 * @param place athlete's position within the list of competitors
	 */
	abstract public void write(Competitor competitor, String place);
	
	/**
	 * Saves information if needed and closes output data stream
	 * Must be overridden by child classes to deal with specific resource
	 */
	abstract public void close();
}