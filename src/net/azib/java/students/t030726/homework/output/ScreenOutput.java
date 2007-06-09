package net.azib.java.students.t030726.homework.output;


import net.azib.java.lessons.logging.JavaUtilLogging;
import net.azib.java.students.t030726.homework.decathlon.DecathlonChampionship;
import net.azib.java.students.t030726.homework.decathlon.RatedDecathlonCompetition;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Screen output class. Outputs all data in a human-readable manner
 * @author Deniss Nikiforov
 *
 */
public class ScreenOutput implements IOutput {
	private RatedDecathlonCompetition competition = null;
	private Logger log;


	public ScreenOutput(RatedDecathlonCompetition competition) {
		this.log = Logger.getLogger(JavaUtilLogging.class.getName());
		this.competition = competition;
	}
	

	/**
	 * Prints the single participator info onto the screen
	 * @param single
	 * @throws Exception
	 */
	private void outputSingleParticipatorInfo(DecathlonChampionship single) throws Exception {
		System.out.println();
		System.out.println("Participator position: " + single.getPosition());
		System.out.println("Participator points: " + String.valueOf(single.getPoints()));
		System.out.println("Participator name: " + String.valueOf(single.getParticipator().getParticipatorName()));
		System.out.println("Participator date of birth: " + String.valueOf(single.getParticipator().getDateOfBirth()));
		System.out.println("Participator country code: " + String.valueOf(single.getParticipator().getParticipatorCountryCode()));
		System.out.println("Participator 100 m sprint achievement: " + String.valueOf(single.getHundredMeterSprintRawResult()));
		System.out.println("Participator long jump result: " + String.valueOf(single.getLongJumpRawResult()));
		System.out.println("Participator shot put result: " + String.valueOf(single.getShotPutRawResult()));
		System.out.println("Participator high jump result: " + String.valueOf(single.getHighJumpRawResult()));
		System.out.println("Participator 400m sprint result: " + String.valueOf(single.getFourHundredMeterSprintRawResult()));
		System.out.println("Participator 110m hurles result: " + String.valueOf(single.getHurdlesRawResult()));
		System.out.println("Participator discus throw result: " + String.valueOf(single.getDiscusThrowRawResult()));
		System.out.println("Participator pole vault result: " + String.valueOf(single.getPoleVaultRawResult()));
		System.out.println("Participator javelin throw result: " + String.valueOf(single.getJavelinThrowRawResult()));
		System.out.println("Participator 1500m race result: " + String.valueOf(single.getLongRunRawResult()));
		System.out.println("-----------------------------------------------------------------------------------------");
	
	}
	
	/**
	 * Bulk printing. 
	 * @throws Exception 
	 */
	public void dump() throws Exception {
		while (this.competition.hasNext()) {
			try {
				this.outputSingleParticipatorInfo(competition.getNext());
			} catch (Exception e) {
				this.log.log(Level.SEVERE, "Cannot Dump", e);
				throw e;
			}
		}
		
	}

	
}
