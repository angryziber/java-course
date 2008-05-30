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
	 * @throws DecathlonException is thrown in case data could not be written to output
	 */
	public abstract void writeData(Collection<Athlete> competitors, File outputFile) throws DecathlonException;
	
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
	
	/**
	 * Calculate competitor place in competition. Assuming the competitors are already sorted
	 * Also could be sharing place like 2-4 if competitors had the same final score
	 * @param compCount - athlete's count
	 * @param athletes - Collection of athletes
	 * @return current athlete's place in competition. 
	 */
	String calculateCompatetorPlace(int compCount, Collection<Athlete> athletes){
		
		String returnStr = null;
		int sharedStartingPos = 1;
		int sharedEndingPos = 1;
		
		Athlete[] aa = new Athlete[athletes.size()];
		athletes.toArray(aa);

		outer:for (int i = 0; i < aa.length; i++) {
			
			if (aa[i].competitionResults.getTotalScore() == aa[compCount - 1].competitionResults.getTotalScore()){
				//set beginning shared position
				sharedStartingPos = i + 1;
				
				for (int j = i; j < aa.length; j++) {
					
					//handle end of array differently
					if (j + 1 == aa.length){
						
						//set ending shared position
						if (aa[j].competitionResults.getTotalScore() != aa[compCount - 1].competitionResults.getTotalScore()) {
							sharedEndingPos = j;
						}
						else{
							sharedEndingPos = aa.length;
						}
						
						//break the pos calc loop if ending shared position is known
						break outer;
					}
					else if (aa[j].competitionResults.getTotalScore() != aa[compCount - 1].competitionResults.getTotalScore()) {
						
						//set ending shared position
						sharedEndingPos = j;
						
						//break the pos calc loop if ending shared position is known
						break outer;
					}
				}
			}
		}
		
		if (sharedStartingPos < sharedEndingPos) {
			//the athlete is sharing his position. should look like: 2-4
			returnStr = sharedStartingPos + "-" + sharedEndingPos;
		}
		else {
			returnStr = "" + sharedStartingPos;
		}
		
		return returnStr;
	}
}
