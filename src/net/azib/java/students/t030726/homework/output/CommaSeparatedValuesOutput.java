package net.azib.java.students.t030726.homework.output;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

import net.azib.java.lessons.logging.JavaUtilLogging;
import net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship;
import net.azib.java.students.t030726.homework.decathlon.RatedDecathlonCompetition;

/**
 * Class is responsible for writing CSV formatted data into the CSV file.
 * @author Deniss Nikiforov
 *
 */
public class CommaSeparatedValuesOutput implements IOutput {
	private String filePath = null;
	private String[] rawLines = null;
	private Logger log;
	
	public CommaSeparatedValuesOutput(String filePath, RatedDecathlonCompetition competition) throws Exception {
		this.log = Logger.getLogger(JavaUtilLogging.class.getName());
		this.filePath = filePath;
		try {
			this.rawLines = this.prepareDump(competition);
		} catch (Exception e) {
			this.log.log(Level.SEVERE, "Preparation to dump the file failed", e);
			throw e;
		}
		
	}
	
	/**
	 * Prepares the data to be dumped. A string is generated from the competition object
	 * @param competition
	 * @return
	 * @throws Exception
	 */
	private String[] prepareDump(RatedDecathlonCompetition competition) throws Exception {
		String[] temp = new String[competition.length()];
		String rawLine = null;
		DecathlonChampionship tempChampionship = null;
		int indexCounter = 0;
		while (competition.hasNext()) {
			tempChampionship = competition.getNext();
			rawLine = new String();
			try {
				//String buffer is used behind the scenes, so no worries here
				rawLine = tempChampionship.getPosition().toString() + "," + String.valueOf(tempChampionship.getPoints()) + "," + 
					tempChampionship.getParticipator().getParticipatorName() + "," + tempChampionship.getParticipator().getDateOfBirth() + 
					"," + tempChampionship.getParticipator().getParticipatorCountryCode() + "," + 
					String.valueOf(tempChampionship.getHundredMeterSprintRawResult()) + "," + 
					String.valueOf(tempChampionship.getLongJumpRawResult()) +
					"," + String.valueOf(tempChampionship.getShotPutRawResult()) + "," + String.valueOf(tempChampionship.getHighJumpRawResult()) + 
					"," + String.valueOf(tempChampionship.getFourHundredMeterSprintRawResult()) + "," + 
					String.valueOf(tempChampionship.getHurdlesRawResult()) + "," + String.valueOf(tempChampionship.getDiscusThrowRawResult()) + 
					"," + String.valueOf(tempChampionship.getPoleVaultRawResult()) + "," + 
					String.valueOf(tempChampionship.getJavelinThrowRawResult()) + "," + String.valueOf(tempChampionship.getLongRunRawResult());
					temp[indexCounter] = rawLine;	
					indexCounter++;
			} catch (Exception e) {
				this.log.log(Level.SEVERE, "Could not format the string", e);
				throw e;
			}
		} 
		return temp;
	}

	
	/**
	 * Dumping the file data to disk
	 * @throws Exception 
	 */
	public void dump() throws Exception {
		try {
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.filePath), "UTF-16"));
			for(int counter = 0; counter < this.rawLines.length; counter++) {
				out.write(this.rawLines[counter].toString());
				out.newLine();
			}
			out.close();
		} catch (UnsupportedEncodingException e) {
			this.log.log(Level.SEVERE, "Cannot Dump", e);
			throw e;
		} catch (FileNotFoundException e) {
			this.log.log(Level.SEVERE, "Cannot Dump", e);
			throw e;
		} catch (IOException e) {
			this.log.log(Level.SEVERE, "Cannot Dump", e);
			throw new Exception("File System Error");
		}
		return;
		
	}
	
	
}
