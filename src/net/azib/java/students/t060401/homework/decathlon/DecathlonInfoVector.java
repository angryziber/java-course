package net.azib.java.students.t060401.homework.decathlon;

import net.azib.java.students.t060401.homework.decathlon.model.AthleteVO;
import net.azib.java.students.t060401.homework.decathlon.model.ResultsVO;
import net.azib.java.students.t060401.homework.util.LanguageUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
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

	private static final String DATA_SEPARATOR = ",";
	private static final int DATA_UNITS_IN_ROW = 13;
	private static final int NAME_UNIT_POSITION = 0;
	private static final int BIRTH_DATE_UNIT_POSITION = 1;
	private static final int COUNTRY_UNIT_POSITION = 2;

	private static final int SPRINT_100M_POSITION = 3;
	private static final int LONG_JUMP_POSITION = 4;
	private static final int SHOT_PUT_POSITION = 5;
	private static final int HIGH_JUMP_POSITION = 6;
	private static final int SPRINT_400M_POSITION = 7;
	private static final int HURDLES_110M_POSITION = 8;
	private static final int DISCUS_THROW_POSITION = 9;
	private static final int POLE_VAULT_POSITION = 10;
	private static final int JAVELIN_THROW_POSITION = 11;
	private static final int RACE_1500M_POSITION = 12;

	Logger log = Logger.getLogger(DecathlonInfoVector.class.getName());

	/** Creates a new instance of DecathlonInfoVector */
	public DecathlonInfoVector() {
	}

	/**
	 * Saves vector to CSV file with given file path. Every athlete is saved to
	 * a new line and data units are separated with commas.
	 * 
	 * @param filePath
	 *            path of a file to save vector to
	 */
	public void saveDecathlonInfoVector(String filePath) throws Exception {
		String fileContent = this.toString();
		if (fileContent != null) {
			try {
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"));
				out.write(fileContent);
				out.close();
				log.log(Level.INFO, "Wrote CSV file to " + filePath);
			}
			catch (Exception e) {
				log.log(Level.WARNING, "Failed to write file: " + filePath + ". " + e);
				throw new Exception(LanguageUtil.getString("DecathlonVector.ErrorSavingFile"), e);
			}
		}
	}

	/**
	 * Loads athletes from CSV file. Every athlete must be on a separate line
	 * and its data must be separated with commas
	 * 
	 * @param fileName
	 *            name of a file to load data from
	 * @return returns information message if loading data succeeded or failed
	 * @throws Exception throws exception if file cannot be found or if I/O operation fails while getting file content as string
	 */
	public String loadDecathlonInfoFromFile(String fileName) throws Exception {
		log.log(Level.INFO, "Loading data from file: "+fileName);
		String infoMessage = LanguageUtil.getString("LoadAthletes.DataLoaded");
		try {
			File file = new File(fileName);

			BufferedReader breader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));

			String inLine = null;
			int rowNumber = 0;
			while ((inLine = breader.readLine()) != null) {
				String inputRow = inLine.trim();
				Athlete athlete = null;
				try {
					athlete = getAthlete(inputRow);
				} catch (IllegalArgumentException e) {
					log.log(Level.WARNING, "Error parsing file row "+rowNumber+" ", e.getMessage());
					infoMessage = LanguageUtil.getString("DecathlonVector.UnparsableFileRow")+" "+rowNumber+" ."+e.getMessage();
				}
				if (athlete != null && athlete.isComplete()) {
						this.add(athlete);
				}
				else {
					log.log(Level.WARNING, "File contains unparsable row: " + rowNumber);
				}
				rowNumber++;
			}
			breader.close();
		}
		catch (FileNotFoundException e) {
			log.log(Level.WARNING, "File could not be found", e);
			throw new Exception(LanguageUtil.getString("DecathlonVector.FileNotFound"), e);
		}
		catch (IOException e) {
			log.log(Level.WARNING, "I/O operation failed while getting file content as string." + e);
			throw new Exception(LanguageUtil.getString("ErrorParsingFile"), e);
		}
		return infoMessage;
	}

	/**
	 * Load all athletes (with decathlon results) who participated competition
	 * with given ID.
	 * 
	 * @param competitionId
	 *            competition ID
	 * @return returns message for the user if data loading succeeded or failed
	 */
	public String loadDecathlonInfoFromDB(long competitionId) {
		String infoMessage = LanguageUtil.getString("LoadAthletes.DataLoaded");
		List<ResultsVO> resultsList = DecathlonDao.getResults(competitionId);
		Iterator<ResultsVO> resultsIter = resultsList.iterator();
		while (resultsIter.hasNext()) {
			ResultsVO resultsVO = (ResultsVO) resultsIter.next();
			long athleteId = resultsVO.getAthleteId();
			AthleteVO athleteVO = DecathlonDao.getAthlete(athleteId);
			Athlete athlete = new Athlete();
			try {
				athlete.setBirthTime(athleteVO.getBirthDate());
				athlete.setName(athleteVO.getName());
				athlete.setCountry(athleteVO.getCountry());
				DecathlonResults results = new DecathlonResults();
				DecathlonEvent event;
				event = new FieldEvent(DecathlonEventEnum.DISCUS_THROW, resultsVO.getDiscusThrow());
				results.put(event);
				event = new FieldEvent(DecathlonEventEnum.HIGH_JUMP, resultsVO.getHighJump());
				results.put(event);
				event = new RunningEvent(DecathlonEventEnum.HURDLES_110M, resultsVO.getHurdles110m());
				results.put(event);
				event = new FieldEvent(DecathlonEventEnum.JAVELIN_THROW, resultsVO.getJavelinThrow());
				results.put(event);
				event = new FieldEvent(DecathlonEventEnum.LONG_JUMP, resultsVO.getLongJump());
				results.put(event);
				event = new FieldEvent(DecathlonEventEnum.POLE_VAULT, resultsVO.getPoleVault());
				results.put(event);
				event = new RunningEvent(DecathlonEventEnum.RACE_1500M, resultsVO.getRace1500m());
				results.put(event);
				event = new FieldEvent(DecathlonEventEnum.SHOT_PUT, resultsVO.getShotPut());
				results.put(event);
				event = new RunningEvent(DecathlonEventEnum.SPRINT_100M, resultsVO.getSprint100m());
				results.put(event);
				event = new RunningEvent(DecathlonEventEnum.SPRINT_400M, resultsVO.getSprint400m());
				results.put(event);
				athlete.setDecathlonResults(results);
				if (athlete.isComplete()) {
					this.add(athlete);
				}
			} catch (Exception e){
				log.log(Level.WARNING, e.getMessage());
				infoMessage = LanguageUtil.getString("DecathlonVector.UnparsableDBData");
			}
		}
		return infoMessage;
	}

	/**
	 * Puts data from the given string into an Athlete object. Validates the
	 * data for its logical correctness.
	 * 
	 * @param inputRow
	 *            string which contains all the athlete's data separated with
	 *            commas
	 * @return returns athlete
	 * @throws IllegalArgumentException
	 *             if the string contains illegal data
	 */
	private Athlete getAthlete(String inputRow)throws IllegalArgumentException {
		Athlete athlete = null;
		if (inputRow == null) {
			log.log(Level.WARNING, "Input data should not be empty");
		}
		else {
			String[] data = inputRow.split(DATA_SEPARATOR);
			if (data.length == DATA_UNITS_IN_ROW) {
					String name = data[NAME_UNIT_POSITION];
					String birthDate = data[BIRTH_DATE_UNIT_POSITION];
					String country = data[COUNTRY_UNIT_POSITION];
					DecathlonResults results = new DecathlonResults();
					DecathlonEvent event;
					event = new FieldEvent(DecathlonEventEnum.DISCUS_THROW, data[DISCUS_THROW_POSITION]);
					results.put(event);
					event = new FieldEvent(DecathlonEventEnum.HIGH_JUMP, data[HIGH_JUMP_POSITION]);
					results.put(event);
					event = new RunningEvent(DecathlonEventEnum.HURDLES_110M, data[HURDLES_110M_POSITION]);
					results.put(event);
					event = new FieldEvent(DecathlonEventEnum.JAVELIN_THROW, data[JAVELIN_THROW_POSITION]);
					results.put(event);
					event = new FieldEvent(DecathlonEventEnum.LONG_JUMP, data[LONG_JUMP_POSITION]);
					results.put(event);
					event = new FieldEvent(DecathlonEventEnum.POLE_VAULT, data[POLE_VAULT_POSITION]);
					results.put(event);
					event = new RunningEvent(DecathlonEventEnum.RACE_1500M, data[RACE_1500M_POSITION]);
					results.put(event);
					event = new FieldEvent(DecathlonEventEnum.SHOT_PUT, data[SHOT_PUT_POSITION]);
					results.put(event);
					event = new RunningEvent(DecathlonEventEnum.SPRINT_100M, data[SPRINT_100M_POSITION]);
					results.put(event);
					event = new RunningEvent(DecathlonEventEnum.SPRINT_400M, data[SPRINT_400M_POSITION]);
					results.put(event);
					athlete = new Athlete(name, birthDate, country);
					athlete.setDecathlonResults(results);
			}
			else {
				log.log(Level.WARNING, "Input data does not contain needed units");
				throw new IllegalArgumentException(LanguageUtil.getString("DecathlonVector.IllegalDataUnitsCount"));
			}
		}
		return athlete;
	}

	/**
	 * Sorts athletes by the decathlon score and returns vector with athletes' personal data, decathlon results, scores and places.
	 * 
	 * @return returns sorted vector of athletes with scores and places
	 */
	public Vector<Vector<String>> toSortedVector() {
		Collections.sort(this);

		Vector<Vector<String>> resultsVector = new Vector<Vector<String>>();
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
				Vector<String> athlete = abi.elementAt(j).toVector();
				int place = i + 1;
				if (abi.size() > 1) {
					int lastPlace = i + abi.size();
					athlete.add(0, place + "-" + lastPlace);
				}
				else {
					athlete.add(0, Integer.toString(place));
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
	 * String representation of the sorted vector of athletes. All the vector elements are
	 * separated with commas.
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
				String next = "" + detailsIter.next();
				if (detailsIter.hasNext()) {
					detailsString += next + ",";
				}
				else {
					detailsString += next + "\r\n";
				}
			}
			result += detailsString;
		}
		return result;
	}
}
