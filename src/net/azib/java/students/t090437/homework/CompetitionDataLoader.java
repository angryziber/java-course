package net.azib.java.students.t090437.homework;

import java.util.SortedSet;

/**
 * CompetitionDataLoader
 *
 * @author Ronald
 */
public interface CompetitionDataLoader {
	public void loadData() throws MyException;
	public SortedSet<Competitor> getResults();
}
