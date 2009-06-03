package net.azib.java.students.t040750.homework.io;


import net.azib.java.students.t040750.homework.generic.DecathlonData;
import net.azib.java.students.t040750.homework.main.DecathlonDemo;
import net.azib.java.students.t040750.homework.parser.Parser;
import net.azib.java.students.t040750.org.apache.commons.cli.Option;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@link InputHandler} class provides the method for
 * selecting the appropriate handler which will process the
 * input data according to the provided parameter.
 * 
 * @author Karpz
 *
 */
public class InputHandler {
	
	/**
	 * Reads from the requested input and generates an array containing 
	 * the competition's data.
	 * 
	 * @param input - the requested input option
	 * @return array containing the competition data
	 */
	public static List<DecathlonData> readInput(Option input) {
		Parser parser = new Parser();
		List<DecathlonData> decathlonData = new ArrayList<DecathlonData>();
		
		if (input.getOpt().equals(DecathlonDemo.CSV)) {
			try {
				decathlonData = parser.loadCSVData(new FileInputStream(input.getValue()));
			} catch (FileNotFoundException e) {
				throw new RuntimeException("CSV input file not found!", e);
			}
		}
		else if (input.getOpt().equals(DecathlonDemo.DB)) {
			decathlonData = parser.loadDBData(input.getValue());
		}
		else if (input.getOpt().equals(DecathlonDemo.CONSOLE)) {
			decathlonData = parser.loadCMDData();
		}
		
		return decathlonData;
	}
	
}
