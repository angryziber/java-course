package net.azib.java.students.t050657.homework.ctrl.dataOutput;

import net.azib.java.students.t050657.homework.model.Competition;
import net.azib.java.students.t050657.homework.model.Result;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * CSVFileWritter
 *
 * @author Boriss
 */
public class CSVFileWriter implements DataWriter{

	/**
	 * Method to write competition to CSV file.
	 */
	public void writeCompetition(Competition competition) 
				throws IOException{
		String lineEnd = System.getProperty("line.separator");
		
		if(competition.getDescription() == null) {
			competition.setDescription("Competition");
		}
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(path + competition.getDescription() + ".csv"), "UTF8"));
		
		for(Result result : competition.getResults()) {
			writer.write(result.toString() + lineEnd);
		}

		writer.close();
	}
}
