package net.azib.java.students.t010687.homework;

import java.util.List;

/**
 * DecathlonDao
 *
 * @author Matu
 */
public interface DecathlonDao {
	public List <ResultsOfTheAthlet> getCompetition_id(int competitionID);
	public List <Competition> getCompetitions();
}
