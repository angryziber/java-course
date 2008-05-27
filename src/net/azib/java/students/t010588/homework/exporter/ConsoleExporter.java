package net.azib.java.students.t010588.homework.exporter;

import net.azib.java.students.t010588.homework.Athlete;
import net.azib.java.students.t010588.homework.Result;

import java.util.List;

/**
 * Exports results into console
 *
 * @author Vjatseslav Rosin, 010588
 */
public class ConsoleExporter implements AthleteExporter {

	public void exportAthletes(List<Athlete> athletes) {
		for (Athlete athlete : athletes) {
			String place = "";
			if (athlete.getFirstPlace() == athlete.getLastPlace())
				place = athlete.getFirstPlace() + "";
			else
				place = athlete.getFirstPlace() + "-" + athlete.getLastPlace();

			System.out.println(place + ". " + athlete.getName() + " (" + DATE_FORMAT.format(athlete.getBirhday()) + ", "
					+ String.valueOf(athlete.getCountry()) + "), " + athlete.getScore());
			int i = 1;
			for (Result result : athlete.getResults()) {
				System.out.println("\t" + (i++) + ") " + result + " (" + result.getPoints() + ")");
			}
		}
	}
}
