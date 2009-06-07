package net.azib.java.students.t050545.homework.writers;

import net.azib.java.students.t050545.homework.ArgumentParser;
import net.azib.java.students.t050545.homework.WriteException;
import net.azib.java.students.t050545.homework.sport.Competition;


/**
 * SportmanWriter
 *
 * @author libricon
 */
public interface AthleteWriter extends ArgumentParser{
	
	/** Method  should write to it's outStream all result
	 * @param competition   a competition 
	 * @throws Exception 
	 */
	void printResultTable(Competition competition) throws WriteException;
	
	/** Method close streams  */
	void close();
	
	

}
