package net.azib.java.students.t030620.homework.output;

import net.azib.java.students.t030620.homework.beans.DecathleteScoreKeeper;
import net.azib.java.students.t030620.homework.enums.Competition;
import net.azib.java.students.t030620.homework.util.CompetitionUtil;
import net.azib.java.students.t030620.homework.util.Utils;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;

/**
 * CSVOutputProvider
 *
 * @author Maksim Konstantinov 030620
 */
public class CSVOutputProvider implements OutputProvider {
	
	/**
	 * Outputs the collection of Decathlon score to the specified file in csv format
	 * 
	 * @param scores sorted collection of DecathleteScoreKeeper 
	 * @param param File instance for the CSV content to be written in
	 */
	
	@Override
	public void output(Collection<DecathleteScoreKeeper> scores, Object param) throws Exception {
		File outputFile = (File)param;
		outputFile.createNewFile();
		FileUtils.writeStringToFile(outputFile, getOutputString(scores), "UTF-8");
	}
	
	private String getOutputString(Collection<DecathleteScoreKeeper> scores) {
		StringBuilder sb = new StringBuilder();
		for (DecathleteScoreKeeper score : scores) {
			sb.append(score.getPlace());
			sb.append(","+score.getScore());
			sb.append(",\""+score.getName()+"\"");
			sb.append(","+Utils.formatDate(score.getDate()));
			sb.append(","+score.getCountryCode());
			for(Competition c : Competition.values()) {
				String output = CompetitionUtil.formatCompetitionResult(score.getScores().get(c), c);
				sb.append(","+output);
			}
			sb.append("\n");
		}
		
		return sb.toString();
		
	}

}
