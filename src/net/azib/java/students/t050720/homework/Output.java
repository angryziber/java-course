package net.azib.java.students.t050720.homework;

import java.util.ArrayList;

/**
 * Output
 *
 * @author Marek
 */
public interface Output {

	/**
	 * @param records 
	 * @throws Exception 
	 * 
	 */
	void flush(ArrayList<Record> records) throws Exception;

}
