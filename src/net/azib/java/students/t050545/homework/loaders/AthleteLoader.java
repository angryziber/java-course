package net.azib.java.students.t050545.homework.loaders;

import net.azib.java.students.t050545.homework.ArgumentParser;
import net.azib.java.students.t050545.homework.ReadException;
import net.azib.java.students.t050545.homework.sport.Sportman;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;


/**
 * SportmanLoader
 *
 * @author libricon
 */

public interface AthleteLoader extends ArgumentParser {
	/**
	 *  Method return new Sportman class object, 
	 *  if there is no more, return NULL
	 * @return The next competitor
	 * @throws ParseException 
	 * @throws IOException 
	 * @throws SQLException 
	 */
	Sportman nextSportman() throws ReadException, ParseException;
	
	void close();
	
	
}
