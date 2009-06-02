package net.azib.java.students.t090437.homework;

import java.util.SortedSet;

/**
 * CompetitionResultsProducer
 *
 * Interface for classes what implement functionality to 
 * output the competition data.
 * 
 * @author Ronald
 */
public interface CompetitionResultsProducer {
	/**
	 * Sets the data from what the output will be produced.
	 * @param competitors
	 */
	public void setCompetitionResults(SortedSet<Competitor> competitors);
	
	/**
	 * Produces the results from the competition data. Competition data must be 
	 * set with setCompetitionResults() before this method can be called.
	 * @throws MyException
	 */
	public void produceResults() throws MyException;
}
