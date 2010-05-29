package net.azib.java.students.t092859.homework.output;

import net.azib.java.students.t092859.homework.core.DecathlonResult;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.apache.commons.io.IOUtils;

/**
 * CSVResultWriter
 *
 * @author konstantin
 */
public class CSVResultWriter implements DecathlonResultWriter {

	Writer CSVOutput;
	
	/**
	 * @param CSVOutput - Writer where CSVResultWriter will write
	 */
	public CSVResultWriter(Writer CSVOutput) {
		this.CSVOutput = CSVOutput;
	}
	
	/**
	 * Writes provided results to CSV
	 * 
	 * @param results - results sorted in order of ascending places
	 * @param places - places corresponding to results
	 */
	@Override
	public void writeResults(List<DecathlonResult> results, List<String> places) {
		System.out.println("Writing CSV..");
		
		for(int i = 0; i < results.size(); i++)
		{
			DecathlonResult result = results.get(i);
			List<String> resultSummary = result.getSummary();
			try {
				CSVOutput.write(places.get(i) + ",");
				
				for(int j = 0; j < resultSummary.size(); j++)
				{
					if(j == 1) //name output
						CSVOutput.write("\"" + resultSummary.get(j) + "\"");
					else
						CSVOutput.write(resultSummary.get(j));
					if(j < resultSummary.size() - 1) //writing last element, no comma needed
						CSVOutput.write(",");
				}
				CSVOutput.write("\n");
			}
			catch (IOException e) {
				System.err.println("Error writing to CSV file");
			}
		}
		IOUtils.closeQuietly(CSVOutput);
		System.out.println("CSV written successfully");
	}

}
