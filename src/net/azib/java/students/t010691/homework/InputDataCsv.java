package net.azib.java.students.t010691.homework;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * InputDataCsv
 * 
 * CSV source.
 * Data is stored in a file composed of rows.
 * Each row corresponds to a single competitor.
 * Results are separated by commas.
 *
 * @author Ilja Lutov
 */
class InputDataCsv extends InputData {

	/**
	 * Constructor
	 * 
	 * Initializes input data source
	 * 
	 * @param filePath path to a file containig competition data
	 */
	public InputDataCsv(String filePath) {
		try {
			inputFile = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
		}
		catch (FileNotFoundException e) {
			System.out.println("Error: file does not exist: '" + filePath + "'"); 
		}
		catch (UnsupportedEncodingException e) {
			System.out.println("Error: unsupported encoding");
		}
	}

	/**
	 * Reads single line from a file and returns corresponding competitor instance
	 * 
	 * @see net.azib.java.students.t010691.homework.InputData#nextResult()
	 */
	public Competitor nextResult() {
		try {
			String data = inputFile.readLine();
			
			// Split data into array of strings and create competitor instance
			Competitor competitor = createCompetitorFromRawData(data.split("\\s*,\\s*"));
			
			// Return null if no more data left.
			// Read next result if data is not valid.
			return data == null ? null : competitor == null ? nextResult() : competitor;
		}
		catch (NullPointerException e) {
			return null;
		}
		catch (IOException e) {
			System.out.println("Error: could not read from stream");
			return null;
		}
	}
	
	/**
	 * Close file
	 * 
	 * @see net.azib.java.students.t010691.homework.InputData#close()
	 */
	public void close() {
		try {
			inputFile.close();
		}
		catch (IOException e) {
			System.out.println("Error: unable to close resource");
		}
	}

	// Source file containing competition data
	private BufferedReader inputFile;
}
