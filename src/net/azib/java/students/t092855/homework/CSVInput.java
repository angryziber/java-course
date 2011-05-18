package net.azib.java.students.t092855.homework;


import java.io.*;

public class CSVInput implements InputStrategy {

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

	Athlete parseLine(String line) {
		String[] elements = line.split(",");

		Athlete athlete = new Athlete();
		if(!athlete.setName(elements[0].replace('\"', ' ')))
			return null;
		if(!athlete.setBirthday(elements[1].trim()))
			return null;
		if(!athlete.setCountry(elements[2].trim()))
			return null;

		int i = 0;
		int j = 3;
		double[] results = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};

		for(DecathlonEvent event : DecathlonEvent.values()) {
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
				results[i++] = temp;
				j++;
			}
		}

		athlete.setDecathlonEvent(new DecathlonEvents(results));

		return athlete;
	}
}
