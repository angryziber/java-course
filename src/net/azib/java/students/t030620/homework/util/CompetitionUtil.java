package net.azib.java.students.t030620.homework.util;

import net.azib.java.students.t030620.homework.beans.DecathleteScoreKeeper;
import net.azib.java.students.t030620.homework.enums.Competition;

import java.util.ArrayList;
import java.util.List;

/**
 * CompetitionUtil
 * utility class for decathlon competition resuts processing
 *
 * @author Maksim Konstantinov 030620
 */
public class CompetitionUtil {

	
	
	/**
	 * Formats the competition result for output according to its type
	 * 
	 * @param d the conpetition result
	 * @param c the competition type
	 * @return
	 */
	public static String formatCompetitionResult (double d, Competition c) {
			
			if(c == Competition.LONG_JUMP || c == Competition.POLE_VAULT || c == Competition.HIGH_JUMP) {
				d = d/100;
			}
			
			String output;
			if(c == Competition.RACE || c == Competition.SPRINT_400) {
				output = Utils.formatSeconds(d);
			} else {
				output = Utils.formatDecimal(d);
			}
			
			return output;
			
		}
	
	/**
	 * Sets the place field for the each of input collection components accouring to its position in the list and score
	 * @param scores sorted collection of DecathleteScoreKeeper 
	 * @return list with of DecathleteScoreKeeper with the place set
	 */
	public static List<DecathleteScoreKeeper> setPlaces(List<DecathleteScoreKeeper> scores) {
			
			int i = 0;
			List<DecathleteScoreKeeper> buffer = new ArrayList<DecathleteScoreKeeper>(); 
			for(DecathleteScoreKeeper score : scores ) {			
				DecathleteScoreKeeper next = (i < scores.size()-1) ? scores.get(i+1) : null;
				if(next != null && score.getScore() == next.getScore()) {
					if(buffer.isEmpty()) {buffer.add(score);}
					buffer.add(next);
				} else if(!buffer.isEmpty()) {
					for(DecathleteScoreKeeper bufferedScore : buffer) {
						bufferedScore.setPlace(i+2 - buffer.size()+"-"+ (i+1));
					}
					buffer = new ArrayList<DecathleteScoreKeeper>(); 
				} else {
					score.setPlace(""+(i+1));
				}
				
				i++;
			}
			
			return scores;
			
		}
}
