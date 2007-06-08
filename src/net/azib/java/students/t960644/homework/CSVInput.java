package net.azib.java.students.t960644.homework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Pattern;

/**
 * CSVInput
 * 
 * Class for reading competition data from a CSV file.
 */
public class CSVInput {
	private InputStreamReader reader;

	/**
	 * Initializes the reader to read data from specified file.
	 * @param filename name of the file to read the csv data from
	 * @return boolean denoting successful read
	 * @throws FileNotFoundException
	 */
	public boolean initReader(String filename) throws FileNotFoundException {
		try {
			// reader = new
			// InputStreamReader(CSVInput.class.getResourceAsStream(filename),"UTF-8");
			reader = new InputStreamReader(new FileInputStream(filename), "UTF-8");
			return reader != null;
		}
		catch (UnsupportedEncodingException e) {
			return false;
			// e.printStackTrace();
		}
	}
	/**
	 * Reads the performance results from the InputStreamReader
	 * @param competition an empty instantiated Competition to fill
	 */
	public void readResults(Competition competition) {
		Vector<String> lineElements;
		for (String line : readFullLines(reader)) {
			lineElements = readLineElements(line);
			if (lineElements.size() == 13) {
				try {
					Athlete athlete = new Athlete();
					Result result = new Result();
					athlete.setName(lineElements.elementAt(0));
					athlete.setBirthDate(lineElements.elementAt(1));
					athlete.setCountryCode(lineElements.elementAt(2));
					result.setRace100(lineElements.elementAt(3));
					result.setLongJump(lineElements.elementAt(4));
					result.setShotPut(lineElements.elementAt(5));
					result.setHighJump(lineElements.elementAt(6));
					result.setRace400(lineElements.elementAt(7));
					result.setHurdles110(lineElements.elementAt(8));
					result.setDiscusThrow(lineElements.elementAt(9));
					result.setPoleVault(lineElements.elementAt(10));
					result.setJavelinThrow(lineElements.elementAt(11));
					result.setRace1500(lineElements.elementAt(12));
					result.setAthlete(athlete);
					competition.addAthlete(athlete);
					competition.addResult(result);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * Reads data from the Readable and seperates it to lines.
	 * @param input Readable containing Strings seperated by CR or LF or both
	 * @return a Vector of Strings
	 */
	protected Vector<String> readFullLines(Readable input) {
		Vector<String> res = new Vector<String>();
		Pattern pLF = Pattern.compile("$", Pattern.MULTILINE);
		Scanner sc = new Scanner(input).useDelimiter(pLF);
		while (sc.hasNext()) {
			res.add(sc.next());
		}
		return res;
	}
	/**
	 * Reads data seperated by commas from a string and divides it into elements. 
	 * @param src A String containing values separated with ',' character
	 * @return a Vector of values without characters ',' '"' LF CR removed 
	 */
	protected Vector<String> readLineElements(String src) {
		Vector<String> res = new Vector<String>();
		Scanner sc = new Scanner(src).useDelimiter(",");
		while (sc.hasNext()) {
			res.add(sc.next().replaceAll("\"", "").replaceAll("\n", "").replaceAll("\r", ""));
		}
		return res;
	}

}
