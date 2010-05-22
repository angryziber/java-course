package net.azib.java.students.t050720.homework;

import java.util.ArrayList;

/**
 * <b>Output</b><br/>
 * 
 * Common interface for all output objects.
 *
 * @author Marek
 */
public interface Output {

	/**
	 * Output the data passed in records via the output that the current object represents.
	 * 
	 * @param records contains the data that gets sent 
	 * @throws Exception 
	 * 
	 */
	void flush(ArrayList<Record> records) throws Exception;

}
