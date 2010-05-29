package net.azib.java.students.t092859.homework.output;

import net.azib.java.students.t092859.homework.core.DecathlonResult;

import java.io.PrintStream;
import java.util.List;

/**
 * ConsoleResultWriter
 *
 * @author konstantin
 */
public class ConsoleResultWriter implements DecathlonResultWriter {

	 PrintStream outputStream;
		
	/**
	 * @param outputStream
	 */
	public ConsoleResultWriter() {
		outputStream = System.out;
	}

	/**
	 * Writes provided results to console
	 * 
	 * @param results - results sorted in order of ascending places
	 * @param places - places corresponding to results
	 */
	@Override
	public void writeResults(List<DecathlonResult> results, List<String> places) {
		String[] summaryNames = {"Points", "Name", "Date of birth", "Country code", "100m sprint", "Long jump", "Shot put", "High jump", 
				"400m sprint", "110m hurdles", "Discus throw", "Pole vault",
				"Javelin throw", "1500m race"};
		
		outputStream.println("\n\nAll results are given in [min:]sec or meters, as appropriate");
		for(int i = 0; i < results.size(); i++) {
			DecathlonResult result = results.get(i);
			outputStream.println("\nPlace: " + places.get(i));
			
			List<String> resultSummary = result.getSummary();
			
			for(int j = 0; j < 14; j++)
				outputStream.println("\t" + summaryNames[j] + ": " + resultSummary.get(j));
		}
	}
	
	/**
	 * Used for tests
	 * @param mockInput - replaces stdout as output
	 */
	void setTestOutput (PrintStream mockOutput){
		outputStream = mockOutput;
	}

}
