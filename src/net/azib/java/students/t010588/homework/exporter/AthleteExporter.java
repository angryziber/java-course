package net.azib.java.students.t010588.homework.exporter;

import net.azib.java.students.t010588.homework.Athlete;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Common interface for athlete exporter
 *
 * @author Vjatseslav Rosin, 010588
 */
public interface AthleteExporter {

	/** Default date format for output */
	public static DateFormat DATE_FORMAT = new SimpleDateFormat("dd.mm.yyyy");

	/**
	 * @param athletes
	 *            list to store
	 */
	public void exportAthletes(List<Athlete> athletes) throws InternalException;

}
