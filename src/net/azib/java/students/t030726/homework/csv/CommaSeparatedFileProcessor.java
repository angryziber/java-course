package csv;
import decathlon.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * This is the CSV file processor. It reads tje CSV file and initializes a DecathlonChampionship object, which is the main object
 * to be used. It contains all relevant information required to produce the output
 * @author Deniss Nikiforov
 *
 */
public class CommaSeparatedFileProcessor {
	//Constants are added for readability sake. They relate to positions in a CSV file from where to read the info (starting from zero)
	private final int NAME_INDEX = 0;
	private final int COUNTRY_CODE_INDEX = 1;
	private final int HUNDRED_SPRINT_INDEX = 2;
	private final int LONG_JUMP_INDEX = 3;
	private final int SHOT_PUT_INDEX = 4;
	private final int HIGH_JUMP_INDEX = 5;
	private final int FOUR_HUNDRED_SPRINT_INDEX = 6;
	private final int HURDLES_INDEX = 7;
	private final int DISCUS_THROW_INDEX = 8;
	private final int POLE_VAULT_INDEX = 9;
	private final int JAVELIN_THROW_INDEX = 10;
	private final int LONG_RUN_INDEX = 11;
	
	//These are the lines read from CSV files (unformatted)
	ArrayList rawLines = null;
	//This is a list of DecathlonChampionship objects, it is save to allow multiple queries to the getter for it.
	ArrayList finalResult = null;

	public CommaSeparatedFileProcessor(String filePath) throws Exception {
		this.rawLines = this.readAllLines(filePath);
	}
	
	
	/**
	 * This reads the file line by line and saves those lines into an arraylist
	 * @param String filePath
	 * @return AeeayList
	 * @throws Exception
	 */
	private ArrayList readAllLines(String filePath) throws Exception {
		ArrayList out = new ArrayList();
		BufferedReader in = new BufferedReader(new FileReader(filePath));
		String singleLine = in.readLine();
		while(singleLine != null) {
			out.add(singleLine);
			singleLine = in.readLine();
		}
		in.close();
		return out;
	}
	
	/**
	 * This converts raw CSV lines to DecathlonChampionship objects through the use of processSingleLine function.
	 * The purpose here is to simplify and improve readability.
	 * @return ArrayList
	 * @throws Exception
	 */
	public ArrayList getAllResults() throws Exception {
		if(this.finalResult != null) {
			return this.finalResult;
		}
		ArrayList result = new ArrayList();
		for (Iterator it = this.rawLines.iterator(); it.hasNext(); ) {
			result.add(this.processSingleLine(it.next().toString()));
		}
		this.finalResult = result;
		return result;
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
		if(rawData.length != 14) {
			throw new InvalidDataFormatException();
		}
		participator = new DecathlonChampionshipParticipator(rawData[this.NAME_INDEX].trim(), rawData[this.COUNTRY_CODE_INDEX].trim());
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
	
	
}
