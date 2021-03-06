package net.azib.java.students.t092855.homework;


import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * CSV input strategy.
 * Gets decathlon data from CSV file.
 *
 * @author t092855
 */
public class InputCSV implements InputStrategy {

	/**
	 * Get decathlon competition data from CSV.
	 * CSV file should be in UTF-8 encoding without BOM. Element separator should be ",".
	 *
	 * @return competition data
	 */
	@Override
	public Competition getData(String... arg) {
		Competition competition = new Competition();
		BufferedReader bufferedReader = null;
		String fileName = arg[0];
		try {
			InputStreamReader inputStream = new InputStreamReader(new FileInputStream(fileName), "UTF-8");
			bufferedReader = new BufferedReader(inputStream);

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				Athlete athlete = parseLine(line);

				if (athlete != null) {
					competition.addAthlete(athlete);
				}
				else {
					System.out.println(Error.ERROR_CSV_READ_LINE_FAILED.getErrorText() + " in: " + line);
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println(Error.ERROR_FILE_NOT_FOUND.getErrorText() + " " + fileName);
		} catch (UnsupportedEncodingException e) {
			System.out.println(Error.ERROR_FILE_WRONG_ENCODING.getErrorText() + " " + fileName);
		} catch (IOException e) {
			System.out.println(Error.ERROR_FILE_READ.getErrorText() + " " + fileName);
		} finally {
			try {
				if (bufferedReader != null)
					bufferedReader.close();
			} catch (IOException e) {
				System.out.println(Error.ERROR_FILE_CLOSING_FAILED.getErrorText() + " " + fileName);
			}
		}

		return competition;
	}

	/**
	 * Parses one line in CSV format and creates an athlete
	 * @param line line in CSV format. Separator: ","
	 * @return athlete, null if parsing fails.
	 */
	Athlete parseLine(String line) {
		String[] elements = line.split(",");

		Athlete athlete = new Athlete();
		if(!athlete.setName(elements[0].replace('\"', ' ')))
			return null;
		Date date;
		try {
			date = new SimpleDateFormat("dd.MM.yyyy").parse(elements[1].trim());
		} catch (ParseException e) {
			return null;
		}
		SimpleDateFormat dateFormat = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.MEDIUM);
		if(!athlete.setBirthday(dateFormat.format(date)))
			return null;
		if(!athlete.setCountry(elements[2].trim()))
			return null;

		int j = 3;
		double[] results = new double[10];

		for(int i = 0; i < results.length; i++) {
			double temp;
			try {
				temp = DecathlonEvents.validateAndConvertResult(elements[j].trim());
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(Error.ERROR_RESULT_MISSING.getErrorText());
				return null;
			}
			if (temp < 0.0) {
				System.out.println(Error.ERROR_NUMBER_FORMAT.getErrorText());
				return null;
			}
			else {
				results[i] = temp;
				j++;
			}
		}

		athlete.setDecathlonEvent(new DecathlonEvents(results));

		return athlete;
	}
}
