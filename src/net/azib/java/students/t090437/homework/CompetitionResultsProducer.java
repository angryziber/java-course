package net.azib.java.students.t090437.homework;

import java.util.SortedSet;

/**
 * CompetitionResultsProducer
 *
 * @author Ronald
 */
public interface CompetitionResultsProducer {
	public void setCompetitionResults(SortedSet<Competitor> competitors);
	public void produceResults() throws MyException;
}
