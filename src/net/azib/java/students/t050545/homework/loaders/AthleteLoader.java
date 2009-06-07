package net.azib.java.students.t050545.homework.loaders;

import net.azib.java.students.t050545.homework.ArgumentParser;
import net.azib.java.students.t050545.homework.LoadException;
import net.azib.java.students.t050545.homework.sport.Sportman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;


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
	 * @throws Exception all kind of exeptions, from IO, Parsing or DATABASE 
	 */
	Sportman nextSportman() throws Exception;
	
	void close();
	
	
}
