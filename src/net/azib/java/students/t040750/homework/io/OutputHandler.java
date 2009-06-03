package net.azib.java.students.t040750.homework.io;


import net.azib.java.students.t040750.homework.generic.DecathlonData;
import net.azib.java.students.t040750.homework.main.DecathlonDemo;
import net.azib.java.students.t040750.homework.parser.Parser;
import net.azib.java.students.t040750.org.apache.commons.cli.Option;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The {@link OutputHandler} class provides the methods for generating
 * the output data in the requested format and output it to the appropriate
 * target.
 * 
 * @author Karpz
 *
 */
public class OutputHandler {

	/**
	 * Write the competition data to the requested output.
	 *  
	 * @param output - the requested output option
	 * @param decathlonData - array containing the competition data which to output
	 * @throws Exception - when errors generating the output
	 */
	public static void outputData(Option output, List<DecathlonData> decathlonData) throws Exception {
		Parser parser = new Parser();
		ArrayList<DecathlonData> orderedData = 
			calculatePositions((ArrayList<DecathlonData>)decathlonData);
		
		if (output.getOpt().equals(DecathlonDemo.CSV)) {
			parser.outputCSVData(output.getValue(),orderedData);
		}
		else if (output.getOpt().equals(DecathlonDemo.XML)) {
			parser.outputXMLData(output.getValue(), orderedData);
		}
		else if (output.getOpt().equals(DecathlonDemo.HTML)) {
			parser.outputHTMLData(output.getValue(), orderedData);
		}
		else if (output.getOpt().equals(DecathlonDemo.CONSOLE)) {
			parser.outputCMDData(orderedData);
		}
	}
	
	/**
	 * Calculates the positions for the competition data objects 
	 * according to the total points and reorders the competition 
	 * data array accordingly. The higher the points the smaller the
	 * position index (starting from 1).
	 * 
	 * @param decathlonData - the initial competition data array
	 * @return reordered competition data array
	 */
	private static ArrayList<DecathlonData> calculatePositions(ArrayList<DecathlonData> decathlonData) {
		Collections.sort(decathlonData,Collections.reverseOrder());
		
		ArrayList<DecathlonData> newDecathlonData = new ArrayList<DecathlonData>();
		long previousPoints = 0;
		int iterator = 1;
		
		for (DecathlonData decData : decathlonData) {
			if (decData.getTotalPoints() == previousPoints) {
				decData.setPosition("-");
			}
			else {
				decData.setPosition(Integer.toString(iterator));
			}
			iterator++;
			previousPoints = decData.getTotalPoints();
			
			newDecathlonData.add(decData);
		}
		
		return newDecathlonData;
	}
	
}
