package net.azib.java.students.t092860.homework;

import java.util.List;

/**
 * Interface class to be implemented in order to retrieve data.
 */
public interface Input {
	
	/**
	 * Data class used to insert athletes info.
	 */
	public class Data extends Athlete{}
	
	/**
	 * Gets input data from particular input object.
	 * 
	 * @return  list of input data
	 * @throws Exception if data cannot be received or incorrect data is received.
	 */
	public List<Data> get() throws Exception;
}
