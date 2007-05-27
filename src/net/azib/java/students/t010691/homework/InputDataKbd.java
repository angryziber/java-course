package net.azib.java.students.t010691.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * InputDataKbd
 *
 * Interactive data input.
 * Rows containing competition results are entered manually by means of a keyboard.
 * Each row corresponds to a single athlete.
 * Values are separated by spaces.
 * Competitor's name must be sorrounded by double quotes
 * in order to ignore spaces that otherwise are considered as separators.
 * To finish data input, an empty string must be entered.
 * 
 * @author Ilja Lutov
 */
class InputDataKbd extends InputData {
	
	/**
	 * Constructor
	 * 
	 * Initializes input data source
	 */
	public InputDataKbd() {
		try {
			inputBuffer = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
		}
		catch (UnsupportedEncodingException e) {
			System.out.println("Error: unsupported encoding");
		}
	}
	
	/**
	 * Reads single line from input buffer.
	 * All parameters must separated by spaces.
	 * Athlete's name must be surrounded by double quotes
	 * 
	 * @see net.azib.java.students.t010691.homework.InputData#nextResult()
	 */
	public Competitor nextResult() {
		try {
			System.out.print("> ");
			String data = inputBuffer.readLine();
			
			// Parse string:
			// 1. retrieve athlete's name (double quotes included)
			// 2. retrieve other data by excluding athlete's name
			// 3. substitute all spaces with commas (athlete's name is not affected) 
			// 4. concatenate ahtlete's name (spaces are preserved) and other data (separated by commas)
			data = data.replaceFirst("\\s*(\".*?\").*", "$1") + data.replaceFirst("\\s*\".*?\"", "").replaceAll("\\s+", ",");
			
			// Split comma-separated values into array of strings and
			// create competitor instance
			Competitor competitor = createCompetitorFromRawData(data.split(","));
			
			// Finish reading in case of empty line.
			// Read next line if data is not valid.
			return data.isEmpty() ? null : competitor == null ? nextResult() : competitor;
		}
		catch (IOException e) {
			System.out.println("Error: could not read from stream");
		}
		return null;
	}
	
	/**
	 * Does nothing
	 * 
	 * @see net.azib.java.students.t010691.homework.InputData#close()
	 */
	public void close() {}

	// Input data source
	private BufferedReader inputBuffer;
}
