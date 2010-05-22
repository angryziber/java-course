package net.azib.java.students.t050720.homework;

import java.util.ArrayList;

/**
 * <b>Input</b>
 * 
 * Is a common interface for all input objects.
 *
 * @author Marek
 */
public interface Input {

	/**
	 * Read data from the input source into the ArrayList of Record that gets passed as the argument.
	 * @param records is the destination of the read data.
	 * @throws Exception 
	 */
	void readInto(ArrayList<Record> records) throws Exception;

}
