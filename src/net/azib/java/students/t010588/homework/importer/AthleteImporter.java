package net.azib.java.students.t010588.homework.importer;

import net.azib.java.students.t010588.homework.Athlete;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Common interface for athlete importer
 *
 * @author Vjatseslav Rosin, 010588
 */
public interface AthleteImporter {

	/** Default date format for input */
	public DateFormat DATE_FORMAT = new SimpleDateFormat("dd.mm.yyyy");

	/**
	 * @return list of imported athletes
	 */
	public List<Athlete> getAthletes();

}
