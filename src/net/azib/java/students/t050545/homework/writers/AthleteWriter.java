package net.azib.java.students.t050545.homework.writers;

import net.azib.java.students.t050545.homework.sport.Competition;
import net.azib.java.students.t050545.homework.utils.ArgumentParser;
import net.azib.java.students.t050545.homework.utils.WriteException;


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
