package net.azib.java.students.t090437.homework;

import java.util.SortedSet;

/**
 * CompetitionDataLoader
 * 
 * Interface for classes what implement functionality to 
 * load data about competitors and their results.
 *
 * @author Ronald
 */
public interface CompetitionDataLoader {
	/**
	 * This method must implement the functionality to 
	 * load the competition and competitor data.
	 * 
	 * @throws MyException is thrown when there has been a fatal error 
	 * in loading or processing the data. 
	 */
	public void loadData() throws MyException;
	
	/**
	 * 
	 * @return Return the data loaded and processed. When loadData() failed  
	 * or has not been called yet, the set will be empty.
	 */
	public SortedSet<Competitor> getResults();
}
