package net.azib.java.students.t030620.homework.output;

import net.azib.java.students.t030620.homework.beans.DecathleteScoreKeeper;
import net.azib.java.students.t030620.homework.enums.Competition;
import net.azib.java.students.t030620.homework.util.CompetitionUtil;
import net.azib.java.students.t030620.homework.util.Utils;

import java.util.Collection;

/**
 * ConsoleOutputProvider
 *
 * @author Maksim Konstantinov 030620
 */
public class ConsoleOutputProvider implements OutputProvider {
	
	private static final int LENGTH_NAME  = 32;
	private static final int LENGTH_DATE  = 14;
	private static final int LENGTH_SCORE = 6;
	private static final int LENGTH_CODE  = 4;
	private static final int LENGTH_PLACE = 6;
	private static final int LENGTH_VALUE = 24;
	
	
	/**
	 * Outputs the collection of Decathlon score to the console
	 * 
	 * @param scores sorted collection of DecathleteScoreKeeper 
	 * @param param - not needed here, pass null
	 */
	@Override
	public void output(Collection<DecathleteScoreKeeper> scores, Object param) throws Exception {
		
		StringBuilder header = new StringBuilder(" "+fillUp("#", LENGTH_PLACE)
							+" | "+fillUp("score", LENGTH_SCORE)
							+" | "+fillUp("name", LENGTH_NAME)
							+" | "+fillUp("date of birth", LENGTH_DATE)
							+" | "+fillUp("code", LENGTH_CODE));
		
		for(Competition c : Competition.values()) {
			header.append(" | "+fillUp(c.getName(), LENGTH_VALUE));
		}
		
		Utils.prompt(header.toString());
		
		StringBuilder sb;
		for(DecathleteScoreKeeper score : scores) {
			sb = new StringBuilder();
			
			sb.append(" "+fillUp(score.getPlace(), LENGTH_PLACE)
							+" | "+fillUp(""+score.getScore(), LENGTH_SCORE)
							+" | "+fillUp(score.getName(), LENGTH_NAME)
							+" | "+fillUp(Utils.formatDate(score.getDate()), LENGTH_DATE)
							+" | "+fillUp(score.getCountryCode(), LENGTH_CODE));
			
			for(Competition c : Competition.values()) {
				String output = CompetitionUtil.formatCompetitionResult(score.getScores().get(c), c);

				sb.append(" | "+fillUp(output, LENGTH_VALUE));
			}
			Utils.prompt(sb.toString());
		}

	}
	
	private String fillUp(String string, int length) {
		if(string.length() > length){
			return string.substring(0, length-3)+"...";
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < length - string.length(); i++) {
			sb.append(" ");
		}
		
		return string+sb.toString();
	}

}
