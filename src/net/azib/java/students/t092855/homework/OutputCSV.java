package net.azib.java.students.t092855.homework;

import java.io.*;
import java.text.DateFormat;
import java.util.Iterator;

/**
 * Decathlon CSV Output. <br>
 *     For outputting decathlon data to CSV file.
 *
 * @author t092855
 */
public class OutputCSV implements OutputStrategy{

	/**
	 * Writes competition data to CSV file. The file is in UTF-8 encoding without BOM.
	 * Element separator is ",".
	 * @param competition data
	 * @param args file name
	 */
	@Override
	public void writeOutput(Competition competition, String... args) {
		String fileName = args[0];

		if (fileName.isEmpty()) {
			System.out.println(Error.ERROR_OUT_FILE_NO_NAME.getErrorText());
			return;
		}
		if (competition.getCompetitors().isEmpty())
			return;

		BufferedWriter bufferedWriter = null;
		try {
			OutputStreamWriter outputStream = new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8");
			bufferedWriter = new BufferedWriter(outputStream);

			Iterator<Athlete> iterator = competition.getCompetitors().iterator();

			do {
				Athlete athlete = iterator.next();
				if (athlete != null) {
					bufferedWriter.write(formatLineCSV(competition.getAthletePlace(athlete), athlete));
					bufferedWriter.newLine();
				}
			}  while (iterator.hasNext());

			bufferedWriter.flush();

		} catch (FileNotFoundException e) {
			System.out.println(Error.ERROR_CSV_FILE.getErrorText() + " " + fileName);
		} catch (IOException e) {
			System.out.println(Error.ERROR_CSV_FILE_WRITE.getErrorText() + " " + fileName);
		}
		finally {
				try {
					if (bufferedWriter != null)
					bufferedWriter.close();
				} catch (IOException e) {
					System.out.println(Error.ERROR_FILE_CLOSING_FAILED.getErrorText() + " " + fileName);
				}
		}
	}

	/**
	 * Formats Athlete data in a line for CSV file. Element separator is ",".
	 * @param athletePlace Athletes place in the competition.
	 * @param athlete The athlete
	 * @return CSV line containing athlete data
	 */
	String formatLineCSV(String athletePlace, Athlete athlete) {
		StringBuilder stringBuilder = new StringBuilder();
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);

		stringBuilder.append(athletePlace).append(",");
		stringBuilder.append(athlete.getAthleteEvents().getTotalPoints()).append(",");
		stringBuilder.append("\"").append(athlete.getName()).append("\"").append(",");
		stringBuilder.append(dateFormat.format(athlete.getBirthday())).append(",");
		stringBuilder.append(athlete.getCountry());
		for (int i = 0; i < athlete.getAthleteEvents().getDecathlonResults().length; i++) {
			stringBuilder.append(",").append(athlete.getAthleteEvents().getDecathlonResults()[i]);
		}

		return stringBuilder.toString();
	}
}
