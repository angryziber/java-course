package net.azib.java.students.t050720.homework;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Input
 *
 * @author Marek
 */
public interface Input {

	/**
	 * @param records
	 * @throws FileNotFoundException 
	 * @throws IOException 
	 */
	void readInto(ArrayList<Record> records) throws FileNotFoundException, IOException;

}
