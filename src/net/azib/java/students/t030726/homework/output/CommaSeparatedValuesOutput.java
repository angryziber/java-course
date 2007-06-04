package output;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import decathlon.DecathlonChampionship;
import decathlon.RatedDecathlonCompetition;

/**
 * Class is responsible for writing CSV formatted data into the CSV file.
 * @author Deniss Nikiforov
 *
 */
public class CommaSeparatedValuesOutput implements IOutput {
	private String filePath = null;
	private String[] rawLines = null;
	
	public CommaSeparatedValuesOutput(String filePath, RatedDecathlonCompetition competition) {
		this.filePath = filePath;
		try {
			this.rawLines = this.prepareDump(competition);
		} catch (Exception e) {
			e.printStackTrace();
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
				e.printStackTrace();
			}
		} 
		return temp;
	}

	
	/**
	 * Dumping the file data to disk
	 */
	public void dump() {
		try {
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.filePath), "UTF-16"));
			for(int counter = 0; counter < this.rawLines.length; counter++) {
				out.write(this.rawLines[counter].toString());
				out.newLine();
			}
			out.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return;
		
	}
	
	
}
