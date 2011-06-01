package net.azib.java.students.t093759.homework;

import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import static net.azib.java.students.t093759.homework.DecathlonEvent.*;

/**
 * This class should be used if you want to output a List of athletes on a Standard output stream.
 *
 * @author dionis
 *         5/30/114:52 AM
 */
public class ConsoleOutput implements AthletesOutput {
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("d.MM.yyyy");
	private static final NumericDataRepresentHelper NUMERIC_DATA_REPRESENT_HELPER = NumericDataRepresentHelper.getInstance();
	OutputStream out = System.out;

	/**
	 * @param athletes             Athletes to be displayed.
	 * @param additionalParameters All parameters are ignored.
	 */
	@Override
	public void output(List<Athlete> athletes, Object... additionalParameters) {
		try {
			out.write(buildStringForAllAthletes(athletes).getBytes());
			out.flush();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	private String buildStringForAllAthletes(List<Athlete> athletes) {
		Collections.sort(athletes);
		StringBuilder stringBuilder = new StringBuilder(8000);
		boolean isFirstLine = true;
		int counter = 1;
		for (Athlete athlete : athletes) {
			if (isFirstLine)
				isFirstLine = false;
			else
				stringBuilder.append(System.getProperty("line.separator"));

			buildOnePersonsDataForRepresentation(stringBuilder, athlete, counter++);
		}
		return stringBuilder.toString();
	}

	private void buildOnePersonsDataForRepresentation(StringBuilder stringBuilder, Athlete athlete, int place) {
		stringBuilder.append(place).append(',')
				.append(NUMERIC_DATA_REPRESENT_HELPER.representPoints(athlete.computePoints())).append(',')
				.append('"').append(athlete.getName()).append('"').append(',')
				.append(DATE_FORMAT.format(athlete.getDateOfBirth().getTime())).append(',')
				.append(athlete.getCountryISO2LetterCode()).append(',')
				.append(NUMERIC_DATA_REPRESENT_HELPER.representSeconds(athlete.get(ONE_HUNDRED_METER_SPRINT))).append(',')
				.append(NUMERIC_DATA_REPRESENT_HELPER.representMeters(athlete.get(LONG_JUMP))).append(',')
				.append(NUMERIC_DATA_REPRESENT_HELPER.representMeters(athlete.get(SHOT_PUT))).append(',')
				.append(NUMERIC_DATA_REPRESENT_HELPER.representMeters(athlete.get(HIGH_JUMP))).append(',')
				.append(NUMERIC_DATA_REPRESENT_HELPER.representMinuteAndSeconds(athlete.get(FOUR_HUNDRED_METER_SPRINT))).append(',')
				.append(NUMERIC_DATA_REPRESENT_HELPER.representSeconds(athlete.get(ONE_HUNDRED_TEN_METER_HURDLES))).append(',')
				.append(NUMERIC_DATA_REPRESENT_HELPER.representMeters(athlete.get(DISCUS_THROW))).append(',')
				.append(NUMERIC_DATA_REPRESENT_HELPER.representMeters(athlete.get(POLE_VAULT))).append(',')
				.append(NUMERIC_DATA_REPRESENT_HELPER.representMeters(athlete.get(JAVELIN_THROW))).append(',')
				.append(NUMERIC_DATA_REPRESENT_HELPER.representMinuteAndSeconds(athlete.get(THOUSAND_FIVE_HUNDRED_METER_SPRINT)));
	}
}
