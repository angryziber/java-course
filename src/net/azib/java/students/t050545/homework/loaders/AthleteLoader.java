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
	 * 
	 * @return sportman or null
	 * @throws ReadException
	 *             anykind of read exception
	 * @throws ParseException
	 */
	AthleteScore nextSportsman() throws ReadException, ParseException;

	/**
	 * Close open resources
	 */
	void close();

}
