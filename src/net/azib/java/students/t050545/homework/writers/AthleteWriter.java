package net.azib.java.students.t050545.homework.writers;

import net.azib.java.students.t050545.homework.ArgumentParser;
import net.azib.java.students.t050545.homework.LoadException;
import net.azib.java.students.t050545.homework.sport.Competition;

import java.util.List;

/**
 * SportmanWriter
 *
 * @author libricon
 */
public interface AthleteWriter extends ArgumentParser{
	
	/** Method  should write to it's outStream all result
	 * @param competition   a competitiona 
	 * @throws Exception 
	 */
	void printResultTable(Competition competition) throws Exception;
	/**
	 *  Method close streams 
	 */
	void close();
	
	

}
