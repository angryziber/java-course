package net.azib.java.students.t050545.homework;

import net.azib.java.students.t050545.homework.sportman.Sportman;


/**
 * SportmanLoader
 *
 * @author libricon
 */

public interface SportmanLoader {
	/**
	 *  Method return new Sportman class object, 
	 *  if there is no more, return NULL
	 * @return The next competitor
	 * @throws Exception all kind of exeptions, from IO, Parsing or DATABASE 
	 */
	Sportman nextSportman() throws Exception;
}
