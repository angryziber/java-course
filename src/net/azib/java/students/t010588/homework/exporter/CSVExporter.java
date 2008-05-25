package net.azib.java.students.t010588.homework.exporter;

import net.azib.java.students.t010588.homework.Athlete;
import net.azib.java.students.t010588.homework.Result;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

/**
 * Exports results into plain text file in CSV format
 *
 * @author Vjatseslav Rosin, 010588
 */
public class CSVExporter implements AthleteExporter {

	private File file;

	/**
	 * @param csvFile
	 *            destination to export results
	 */
	public CSVExporter(File csvFile) {
		this.file = csvFile;
	}

	public void exportAthletes(List<Athlete> athletes) throws InternalException {
		try {
			BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF8"));
			try {
				String athleteLine = null;

				for (Athlete athlete : athletes) {
					String place = "";
					if (athlete.getFirstPlace() == athlete.getLastPlace())
						place = athlete.getFirstPlace() + "";
					else
						place = athlete.getFirstPlace() + "-" + athlete.getLastPlace();

					athleteLine = place + ",";
					athleteLine += athlete.getScore() + ",";
					athleteLine += athlete.getName() + ",";
					athleteLine += DATE_FORMAT.format(athlete.getBirhday()) + ",";
					athleteLine += String.valueOf(athlete.getCountry()) + ",";

					Result[] results = athlete.getResults();

					for (int i = 0; i < results.length; i++) {
						athleteLine += results[i];
						if (i != athlete.getResults().length - 1)
							athleteLine += ",";
					}

					athleteLine += System.getProperty("line.separator");

					output.write(athleteLine);
				}
			}
			finally {
				output.close();
			}
		}
		catch (IOException ex) {
			throw new InternalException(ex.getMessage());
		}
	}
}
