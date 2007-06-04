package input;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

import decathlon.DecathlonChampionship;
import decathlon.DecathlonChampionshipParticipator;
import decathlon.DiscusThrowEvent;
import decathlon.FifteenHundredMeterRunEvent;
import decathlon.FourHundredMeterSprint;
import decathlon.HighJumpEvent;
import decathlon.HundredAndTenMeterHurdlesEvent;
import decathlon.HundredMeterSprint;
import decathlon.InvalidDataFormatException;
import decathlon.JavelinThrowEvent;
import decathlon.LongJumpEvent;
import decathlon.PoleVaultEvent;
import decathlon.ShotPutEvent;

/**
 * Class is responsible for reading data from the database and providing an iterator-like interface to self for easy data reading
 * @author Deniss Nikiforov
 *
 */
public class CommaSeparatedValuesInput implements IInput {
//	Constants are added for readability sake. They relate to positions in a CSV file from where to read the info (starting from zero)
	private final int NAME_INDEX = 0;
	private final int BIRTH_DATE_INDEX = 1;
	private final int COUNTRY_CODE_INDEX = 2;
	private final int HUNDRED_SPRINT_INDEX = 3;
	private final int LONG_JUMP_INDEX = 4;
	private final int SHOT_PUT_INDEX = 5;
	private final int HIGH_JUMP_INDEX = 6;
	private final int FOUR_HUNDRED_SPRINT_INDEX = 7;
	private final int HURDLES_INDEX = 8;
	private final int DISCUS_THROW_INDEX = 9;
	private final int POLE_VAULT_INDEX = 10;
	private final int JAVELIN_THROW_INDEX = 11;
	private final int LONG_RUN_INDEX = 12;
	
	//These are the lines read from CSV files (unformatted)
	ArrayList rawLines = null;
	//This is a list of DecathlonChampionship objects, it is save to allow multiple queries to the getter for it.
	ArrayList finalResult = new ArrayList();
	
	Iterator mainIterator = null;
	
	/**
	 * This reads the file line by line and saves those lines into an arraylist
	 * @param String filePath
	 * @return AeeayList
	 * @throws Exception
	 */
	private ArrayList readAllLines(String filePath) throws Exception {
		ArrayList out = new ArrayList();
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
			throw new InvalidDataFormatException();
		}
		participator = new DecathlonChampionshipParticipator(rawData[this.NAME_INDEX].trim(), rawData[this.COUNTRY_CODE_INDEX].trim(), 
				rawData[this.BIRTH_DATE_INDEX].trim());
		championship = new DecathlonChampionship(participator);
		
		//Initialize event data properties of the championship instance
		championship.setHundredMeterSprintData(new HundredMeterSprint(rawData[this.HUNDRED_SPRINT_INDEX].trim()));
		championship.setLongJumpEventData(new LongJumpEvent(Double.parseDouble(rawData[this.LONG_JUMP_INDEX].trim())));
		championship.setShotPutEventData(new ShotPutEvent(Double.parseDouble(rawData[this.SHOT_PUT_INDEX].trim())));
		championship.setHighJumpEventData(new HighJumpEvent(Double.parseDouble(rawData[this.HIGH_JUMP_INDEX].trim())));
		championship.setFourHundredMeterSprintEventData(new FourHundredMeterSprint(rawData[this.FOUR_HUNDRED_SPRINT_INDEX].trim()));
		championship.setHundredAndTenMeterHurdlesEventData(new HundredAndTenMeterHurdlesEvent(rawData[this.HURDLES_INDEX].trim()));
		championship.setDiscusThrowEventData(new DiscusThrowEvent(Double.parseDouble(rawData[this.DISCUS_THROW_INDEX].trim())));
		championship.setPoleVaultEventData(new PoleVaultEvent(Double.parseDouble(rawData[this.POLE_VAULT_INDEX].trim())));
		championship.setJavelinThrowEventData(new JavelinThrowEvent(Double.parseDouble(rawData[this.JAVELIN_THROW_INDEX].trim())));
		championship.setFifteenHundredMeterRunEventData(new FifteenHundredMeterRunEvent(rawData[this.LONG_RUN_INDEX].trim()));
		
		
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
