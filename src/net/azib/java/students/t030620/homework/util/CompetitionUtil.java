package net.azib.java.students.t030620.homework.util;

import net.azib.java.students.t030620.homework.beans.DecathleteScoreKeeper;
import net.azib.java.students.t030620.homework.enums.Competition;

import java.util.ArrayList;
import java.util.List;

/**
 * CompetitionUtil
 *
 * @author Lord HellBunny
 */
public class CompetitionUtil {

	
	
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
