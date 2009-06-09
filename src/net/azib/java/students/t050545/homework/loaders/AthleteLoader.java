package net.azib.java.students.t050545.homework.loaders;

import net.azib.java.students.t050545.homework.sport.AthleteScore;
import net.azib.java.students.t050545.homework.utils.ArgumentParser;
import net.azib.java.students.t050545.homework.utils.ReadException;

import java.text.ParseException;

/**
 * AthleteLoader
 * 
 * @author libricon
 */

public interface AthleteLoader extends ArgumentParser {
	/**
	 * @return AthleteScore or null
	 * @throws ReadException 
	 * @throws ParseException
	 */
	AthleteScore nextAthleteScore() throws ReadException, ParseException;

	/** Close opened resources */
	void close();

}
