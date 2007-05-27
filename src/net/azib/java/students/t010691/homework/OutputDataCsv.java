package net.azib.java.students.t010691.homework;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * OutputDataCsv
 * 
 * CSV output resource.
 * Competition results are written to CSV file.
 *
 * @author Ilja Lutov
 */
class OutputDataCsv extends OutputData {
	
	/**
	 * Constructor
	 * 
	 * Initializes file output stream
	 * 
	 * @param filePath path to a file that will contain competition results
	 */
	public OutputDataCsv (String filePath) {
		try {
			outputFile = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"));
		}
		catch (FileNotFoundException e) {
			System.out.println("Error: file does not exist: '" + filePath + "'"); 
		}
		catch (UnsupportedEncodingException e) {
			System.out.println("Error: unsupported encoding");
		}
	}
	
	/**
	 * Writes competitor data to a file.
	 * 
	 * @see net.azib.java.students.t010691.homework.OutputData#write(Competitor)
	 */
	public void write(Competitor competitor, String place) {
		String[] data = competitor.toStringArray();

		try {
			outputFile.write(
				place + "," +
				data[0] + "," +
				data[1] + "," +
				data[2] + "," +
				data[3] + "," +
				data[4] + "," +
				data[5] + "," +
				data[6] + "," +
				data[7] + "," +
				data[8] + "," +
				data[9] + "," +
				data[10] + "," +
				data[11] + "," +
				data[12] + "," +
				data[13] + "\r\n"
			);
		}
		catch (IOException e) {
			System.out.println("Error: could not write to stream");
		}
	}
	
	/**
	 * Close file
	 * 
	 * @see net.azib.java.students.t010691.homework.OutputData#close()
	 */
	public void close() {
		try {
			outputFile.close();
		}
		catch (IOException e) {
			System.out.println("Error: unable to close resource");
		}
		
		System.out.println("\nDone.\n");
	}

	// File that stores competition results
	private BufferedWriter outputFile;
}
