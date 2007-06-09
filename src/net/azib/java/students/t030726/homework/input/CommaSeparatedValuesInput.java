package net.azib.java.students.t030726.homework.input;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.azib.java.lessons.logging.JavaUtilLogging;
import net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship;
import net.azib.java.students.t030726.homework.decathlon.DecathlonChampionshipParticipator;
import net.azib.java.students.t030726.homework.decathlon.DiscusThrowEvent;
import net.azib.java.students.t030726.homework.decathlon.FifteenHundredMeterRunEvent;
import net.azib.java.students.t030726.homework.decathlon.FourHundredMeterSprint;
import net.azib.java.students.t030726.homework.decathlon.HighJumpEvent;
import net.azib.java.students.t030726.homework.decathlon.HundredAndTenMeterHurdlesEvent;
import net.azib.java.students.t030726.homework.decathlon.HundredMeterSprint;
import net.azib.java.students.t030726.homework.decathlon.InvalidDataFormatException;
import net.azib.java.students.t030726.homework.decathlon.JavelinThrowEvent;
import net.azib.java.students.t030726.homework.decathlon.LongJumpEvent;
import net.azib.java.students.t030726.homework.decathlon.PoleVaultEvent;
import net.azib.java.students.t030726.homework.decathlon.ShotPutEvent;

/**
 * Class is responsible for reading data from the database and providing an iterator-like interface to self for easy data reading
 * @author Deniss Nikiforov
 *
 */
public class CommaSeparatedValuesInput implements IInput {
	//Read-only variables are added for readability sake. They relate to positions in a CSV file from where to read the info (starting from zero)
	private final int nameIndex = 0;
	private final int birthDateIndex = 1;
	private final int countryCodeIndex = 2;
	private final int hundredSprintIndex = 3;
	private final int longJumpIndex = 4;
	private final int shotPutIndex = 5;
	private final int highJumpIndex = 6;
	private final int fourHundredMeterSprintIndex = 7;
	private final int hurdlesIndex = 8;
	private final int discusThrowIndex = 9;
	private final int poleVaultIndex = 10;
	private final int javelinThrowIndex = 11;
	private final int longRunIndex = 12;
	private Logger log = null;
	
	//These are the lines read from CSV files (unformatted)
	ArrayList rawLines = null;
	//This is a list of DecathlonChampionship objects, it is save to allow multiple queries to the getter for it.
	ArrayList<DecathlonChampionship> finalResult = new ArrayList<DecathlonChampionship>();
	
	Iterator mainIterator = null;
	
	/**
	 * This reads the file line by line and saves those lines into an arraylist
	 * @param String filePath
	 * @return ArrayList
	 * @throws Exception
	 */
	private ArrayList readAllLines(String filePath) throws Exception {
		ArrayList<String> out = new ArrayList<String>();
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-16"));
		

		String singleLine = null;
		do {
			
			singleLine = in.readLine();
			if(singleLine != null) {
				out.add(singleLine);
			}
			
		}while(singleLine != null);
		in.close();
		return out;
	}
	
	/**
	 * Reads the entire file and saves it into memory. Then extracts the iterator from the read lines object
	 * @param targetFilePath
	 * @throws Exception
	 */
	public CommaSeparatedValuesInput(String targetFilePath) throws Exception {
		this.log = Logger.getLogger(JavaUtilLogging.class.getName());
		this.rawLines = this.readAllLines(targetFilePath);
		this.mainIterator = this.rawLines.iterator();
	}
	
	
	/**
	 * Processed raw CSV line and instantiates appropriate objects to create the DecathlonChampionship object. 
	 * @param String line - The raw CSV line
	 * @return DecathlonChampionship
	 * @throws InstantiationException
	 * @throws Exception
	 */
	private DecathlonChampionship processSingleLine(String line) throws InstantiationException, Exception {
		DecathlonChampionship championship = null;
		DecathlonChampionshipParticipator participator = null;
		String[] rawData = line.split(",");
		if(rawData.length != 13) {
			this.log.log(Level.SEVERE, "The CSV file is corrupted. We get fewer/more parameters, then expected");
			throw new InvalidDataFormatException();
		}
		participator = new DecathlonChampionshipParticipator(rawData[this.nameIndex].trim(), rawData[this.countryCodeIndex].trim(), 
				rawData[this.birthDateIndex].trim());
		championship = new DecathlonChampionship(participator);
		
		//Initialize event data properties of the championship instance
		championship.setHundredMeterSprintData(new HundredMeterSprint(rawData[this.hundredSprintIndex].trim()));
		championship.setLongJumpEventData(new LongJumpEvent(Double.parseDouble(rawData[this.longJumpIndex].trim())));
		championship.setShotPutEventData(new ShotPutEvent(Double.parseDouble(rawData[this.shotPutIndex].trim())));
		championship.setHighJumpEventData(new HighJumpEvent(Double.parseDouble(rawData[this.highJumpIndex].trim())));
		championship.setFourHundredMeterSprintEventData(new FourHundredMeterSprint(rawData[this.fourHundredMeterSprintIndex].trim()));
		championship.setHundredAndTenMeterHurdlesEventData(new HundredAndTenMeterHurdlesEvent(rawData[this.hurdlesIndex].trim()));
		championship.setDiscusThrowEventData(new DiscusThrowEvent(Double.parseDouble(rawData[this.discusThrowIndex].trim())));
		championship.setPoleVaultEventData(new PoleVaultEvent(Double.parseDouble(rawData[this.poleVaultIndex].trim())));
		championship.setJavelinThrowEventData(new JavelinThrowEvent(Double.parseDouble(rawData[this.javelinThrowIndex].trim())));
		championship.setFifteenHundredMeterRunEventData(new FifteenHundredMeterRunEvent(rawData[this.longRunIndex].trim()));
		
		
		return championship;
	}
	
	/**
	 * Returns true if we still have something to read
	 */
	public DecathlonChampionship getNext() throws InstantiationException, Exception {
		DecathlonChampionship temp = this.processSingleLine((String)this.mainIterator.next());
		this.finalResult.add(temp);
		return temp;
	}

	/**
	 * Reads the next element
	 */
	public boolean hasNext() {
		return this.mainIterator.hasNext();
	}
	
	

}
