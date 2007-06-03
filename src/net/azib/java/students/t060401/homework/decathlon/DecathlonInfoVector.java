/*
 * DecathlonInfoVector.java
 *
 * Created on laup�ev, 30. September 2006. a, 22:51
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package net.azib.java.students.t060401.homework.decathlon;

import net.azib.java.students.t060401.homework.util.Constants;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DecathlonInfoVector
 * 
 * Vector which holds athletes with their decathlon results.
 * 
 * @author t060401
 */
public class DecathlonInfoVector extends Vector<Athlete> {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	Logger log = Logger.getLogger(DecathlonInfoVector.class.getName());

	/** Creates a new instance of DecathlonInfoVector */
	public DecathlonInfoVector() {
	}

	/**
	 * Saves vector to CSV file with given file path. Every athlete is saved to a new line and athlete data is separated with commas.
	 * 
	 * @param filePath path of a file to save vector to
	 */
	public void saveDecathlonInfoVector(String filePath) {
		String fileContent = this.toString();
		if (fileContent != null) {
			try {
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"));
				out.write(fileContent);
				out.close();
				System.out.println("Wrote CSV file to " + filePath);
			}
			catch (Exception e) {
				System.out.println("Failed to write file: " + filePath + ". " + e);
			}
		}
	}

	/**
	 * Loads athletes from CSV file. Every athlete must be on a separate line and its data must be separated with commas
	 * 
	 * @param fileName name of a file to load data from
	 * @return
	 * @throws Exception
	 */
	public void loadDecathlonInfoFromFile(String fileName) throws Exception {
		try {
			File file = new File(fileName);

			BufferedReader breader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));

			String inLine = null;
			while ((inLine = breader.readLine()) != null) {
				String inputRow = inLine.trim();
				Athlete athlete = getAthlete(inputRow);
				if (athlete != null) {
					this.add(athlete);
				}
				else {
					log.log(Level.WARNING, "Input row could not be parsed: " + inputRow);
				}
			}
			breader.close();
		}
		catch (FileNotFoundException e) {
			throw new Exception("File could not be found", e);
		}
		catch (IOException e) {
			log.log(Level.WARNING, "I/O operation failed while getting file content as string." + e);
			throw new Exception("Error while parsing file", e);
		}
	}

	/**
	 * Puts data from the given string into an Athlete object. Validates the data for its correctness.
	 * 
	 * @param inputRow string which contains all the athlete's data separated with commas
	 * @return returns athlete
	 * @throws IllegalArgumentException if the string contains illegal data
	 */
	private Athlete getAthlete(String inputRow)throws IllegalArgumentException {
		Athlete athlete = null;
		if (inputRow == null) {
			log.log(Level.WARNING, "Input data should not be empty");
		}
		else {
			String[] data = inputRow.split(Constants.DATA_SEPARATOR);
			if (data.length == Constants.DATA_UNITS_IN_ROW) {
				try {
					String name = data[Constants.NAME_UNIT_POSITION];
					String birthDate = data[Constants.BIRTH_DATE_UNIT_POSITION];
					String country = data[Constants.COUNTRY_UNIT_POSITION];
					DecathlonResults results = new DecathlonResults();
					results.setSprint100m(data[Constants.SPRINT_100M_POSITION]);
					results.setLongJump(data[Constants.LONG_JUMP_POSITION]);
					results.setShotPut(data[Constants.SHOT_PUT_POSITION]);
					results.setHighJump(data[Constants.HIGH_JUMP_POSITION]);
					results.setSprint400m(data[Constants.SPRINT_400M_POSITION]);
					results.setHurdles110m(data[Constants.HURDLES_110M_POSITION]);
					results.setDiscusThrow(data[Constants.DISCUS_THROW_POSITION]);
					results.setPoleVault(data[Constants.POLE_VAULT_POSITION]);
					results.setJavelinThrow(data[Constants.JAVELIN_THROW_POSITION]);
					results.setRace1500m(data[Constants.RACE_1500M_POSITION]);
					athlete = new Athlete(name, birthDate, country);
					athlete.setDecathlonResults(results);
				}
				catch (IllegalArgumentException e) {
					log.log(Level.WARNING, "Input file contains invalid data. " + e);
					throw new IllegalArgumentException("Input file contains invalid data", e);
				}
			}
			else {
				log.log(Level.WARNING, "Input data does not contain needed units");
				throw new IllegalArgumentException("Input file does not contain all needed units");
			}
		}
		return athlete;
	}

	/**
	 * Sorts the athletes by decathlon score and adds score and place for every athlete in vector.
	 * 
	 * @return returns sorted vector of athletes with scores and places
	 */
	public Vector<Vector<Object>> toSortedVector() {
		Collections.sort(this);
		
		Vector<Vector<Object>> resultsVector = new Vector<Vector<Object>>();
		Vector<Athlete> abi = new Vector<Athlete>();

		for (int i = 0; i < this.size(); i++) {
			Athlete prev = this.elementAt(i);
			abi.add(prev);
			for (int j = i + 1; j < this.size(); j++) {
				Athlete next = this.elementAt(j);
				if (prev.compareTo(next) == 0) {
					abi.add(next);
					prev = next;
				}
				else {
					break;
				}
			}
			for (int j = 0; j < abi.size(); j++) {
				Vector<Object> athlete = abi.elementAt(j).toVector();
				int place = i + 1;
				if (abi.size() > 1) {
					int lastPlace = i + abi.size();
					athlete.add(0, place + "-" + lastPlace);
				}
				else {
					athlete.add(0, place);
				}
				resultsVector.add(athlete);
			}

			if (abi.size() > 1) {
				i += abi.size() - 1;
			}
			abi.clear();
		}
		return resultsVector;
	}

	/* 
	 * String representation of the vector. All the vector elements are separated with commas.
	 */
	public String toString() {
		String result = "";
		Vector<?> sorted = this.toSortedVector();
		Iterator<?> it = sorted.iterator();
		while (it.hasNext()) {
			Vector<?> athleteInfo = (Vector<?>) it.next();
			Iterator<?> detailsIter = athleteInfo.iterator();
			String detailsString = "";
			while (detailsIter.hasNext()) {
				String next = ""+detailsIter.next();
				if (detailsIter.hasNext()) {
					System.out.println( next+ ",");
					detailsString += next + ",";
				}
				else {
					System.out.println(next + "\n");
					detailsString += next + "\r\n";
				}
			}
			result+=detailsString;
		}
		return result;
	}
}
