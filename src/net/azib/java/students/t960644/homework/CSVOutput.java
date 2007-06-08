package net.azib.java.students.t960644.homework;

import java.io.PrintStream;

/**
 * CSVOutput
 *
 * Class for outputting competition results to a CSV file (stream).
 */
public class CSVOutput {
	/**
	 * Writes the results list to the printstream as CSV
	 * @param out PrintStream to print the results to
	 * @param competition a filled and sorted Competition
	 */
	public void writeData(PrintStream out,Competition competition) {
		for (Result r:competition.getResults()){
			out.println(writeLine(r));
		}
	}
	/**
	 * Creates a StringBuffer that contains a single line of the results as CSV 
	 * @param result a filled Result 
	 * @return StringBuffer containing the fields seperated by ','
	 */
	protected StringBuffer writeLine(Result result) {
		return new StringBuffer(result.getPosition()).append(",").
			append(Integer.toString(result.calcResult())).append(",").
			append(quotation(result.getAthlete().getName())).append(",").
			append(result.getAthlete().getBirthDate()).append(",").
			append(result.getAthlete().getCountryCode()).append(",").
			append(result.getStringRace100()).append(",").
			append(result.getStringLongJump()).append(",").
			append(result.getStringShotPut()).append(",").
			append(result.getStringHighJump()).append(",").
			append(result.getStringRace400()).append(",").
			append(result.getStringHurdles110()).append(",").
			append(result.getStringDiscusThrow()).append(",").
			append(result.getStringPoleVault()).append(",").
			append(result.getStringJavelinThrow()).append(",").
			append(result.getStringRace1500());
	}
	/**
	 * Surrounds a string with '"' characters.
	 * @param src a String to add '"' character to the beginning and end
	 * @return a StringBuffer containing '"'+original string+'"'
	 */
	protected StringBuffer quotation(String src) {
		return new StringBuffer(src).insert(0,'"').append('"');
	}
	
}
