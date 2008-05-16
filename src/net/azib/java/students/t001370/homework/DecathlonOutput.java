package net.azib.java.students.t001370.homework;

import java.io.File;
import java.util.Collection;

/**
 * DecathlonOuput
 * Base class for all outpt methods
 * @author maksim
 */
public abstract class DecathlonOutput {

	/**
	 * Abstract method
	 * Write decathlon competition results to output
	 * @param competitors - Collection of athletes
	 * @param outputFile
	 */
	public abstract void writeData(Collection<Athlete> competitors, File outputFile);
	
	/**
	 * Calculate competitor place in competition. Assuming the competitors are already sorted
	 * @param compCount - athlete's count 
	 * @param lastCompPlace - previous athlete's place in competition
	 * @param lastCompScore - previous athlete's total score
	 * @param currCompScore - current athlete's total score 
	 * @return current athlete's place in competition
	 */
	int calculateCompatetorPlace(int compCount, int lastCompPlace, int lastCompScore, int currCompScore){
		int competitorPlace = 0;
		
		if (lastCompScore != currCompScore){
			competitorPlace = compCount;
		}
		else if(lastCompScore == currCompScore){
			competitorPlace = lastCompPlace;
		}
		
		return competitorPlace;
	}
}
