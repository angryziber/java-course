package net.azib.java.students.t093759.homework;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static java.lang.Double.valueOf;

/**
 * @author dionis
 *         5/30/113:57 AM
 */
public class CSVLoader implements AthletesLoader {
	final static SimpleDateFormat MIN_SEC_MILLI_FORMAT = new SimpleDateFormat("mm:ss.SSS");
	final static SimpleDateFormat SEC_MILLI_FORMAT = new SimpleDateFormat("ss.SSS");

	/**
	 * @param additionalParams Filename with results in .csv.
	 * @return List of loaded athletes or empty list.
	 */
	@Override
	public List<Athlete> load(Object... additionalParams) {
		if (additionalParams.length < 1) throw new IllegalArgumentException("One parameter needed.");
		if (!(additionalParams[0] instanceof String))
			throw new IllegalArgumentException("Parameter should be a string.");
		List<Athlete> athletes = new ArrayList<Athlete>(100);
		try {
			List<String> lines = FileUtils.readLines(new File((String) additionalParams[0]), "UTF-8");
			for (String line : lines) {
				if (line.trim().isEmpty()) continue;
				try {
					athletes.add(loadOneAthlete(line));
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return athletes;
	}

	private Athlete loadOneAthlete(String lineWithAthleteData) throws Exception {
		Athlete.Builder builder = new Athlete.Builder();
		loadAllAthleteFieldsUsing(builder, lineWithAthleteData);
		return builder.build();
	}

	private void loadAllAthleteFieldsUsing(Athlete.Builder builder, String lineWithAthleteData) throws Exception {
		String[] str = lineWithAthleteData.split(",");
		int i = 0;
		loadNameUsing(builder, str[i++]);
		loadDateOfBirthUsing(builder, str[i++]);
		loadCountryISO2LetterCodeUsing(builder, str[i++]);
		loadOneHundredMeterSprintTimeUsing(builder, str[i++]);
		loadLongJumpLengthUsing(builder, str[i++]);
		loadShotPutLengthUsing(builder, str[i++]);
		loadHighJumpHeightUsing(builder, str[i++]);
		loadFourHundredMeterSprintTimeUsing(builder, str[i++]);
		loadOneHundredTenMeterHurdlesTimeUsing(builder, str[i++]);
		loadDiscusThrowLengthUsing(builder, str[i++]);
		loadPoleVaultHeightUsing(builder, str[i++]);
		loadJavelinThrowLengthUsing(builder, str[i++]);
		loadThousandFiveHundredMeterRaceTimeUsing(builder, str[i]);
	}

	private void loadThousandFiveHundredMeterRaceTimeUsing(Athlete.Builder builder, String string) throws Exception {
		builder.setThousandFiveHundredMeterRaceTime(parseMinutesAndSecondsAndMillisFromString(string));
	}

	private void loadShotPutLengthUsing(Athlete.Builder builder, String string) throws Exception {
		builder.setShotPutLength(getDoubleFromString(string));
	}

	private void loadPoleVaultHeightUsing(Athlete.Builder builder, String string) throws Exception {
		builder.setPoleVaultHeight(getDoubleFromString(string));
	}

	private void loadOneHundredTenMeterHurdlesTimeUsing(Athlete.Builder builder, String string) throws Exception {
		builder.setOneHundredTenMeterHurdlesTime(parseSecondsAndMillisFromString(string));
	}

	double parseMinutesAndSecondsAndMillisFromString(String source) throws ParseException, StopLoadingAthletesException, SkipLoadingAthleteException {
		return parseSomeDateIntoDoubleAccordingTo(MIN_SEC_MILLI_FORMAT, source);
	}

	double parseSecondsAndMillisFromString(String source) throws ParseException, StopLoadingAthletesException, SkipLoadingAthleteException {
		return parseSomeDateIntoDoubleAccordingTo(SEC_MILLI_FORMAT, source);
	}

	private double parseSomeDateIntoDoubleAccordingTo(SimpleDateFormat format, String source) throws ParseException, StopLoadingAthletesException, SkipLoadingAthleteException {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(format.parse(source));
		double divisor = Math.pow(10, source.split("\\.")[1].trim().length());
		return calendar.get(Calendar.MINUTE) * 60 + calendar.get(Calendar.SECOND) + calendar.get(Calendar.MILLISECOND) / divisor;
	}

	private void loadOneHundredMeterSprintTimeUsing(Athlete.Builder builder, String string) throws Exception {
		builder.setOneHundredMeterSprintTime(parseSecondsAndMillisFromString(string));
	}

	private void loadLongJumpLengthUsing(Athlete.Builder builder, String string) throws Exception {
		builder.setLongJumpLength(getDoubleFromString(string));
	}

	private void loadJavelinThrowLengthUsing(Athlete.Builder builder, String string) throws Exception {
		builder.setJavelinThrowLength(getDoubleFromString(string));
	}

	private void loadHighJumpHeightUsing(Athlete.Builder builder, String string) throws Exception {
		builder.setHighJumpHeight(getDoubleFromString(string));
	}

	private void loadFourHundredMeterSprintTimeUsing(Athlete.Builder builder, String string) throws Exception {
		try {
			builder.setFourHundredMeterSprintTime(parseMinutesAndSecondsAndMillisFromString(string));
		} catch (ParseException e) {
			builder.setFourHundredMeterSprintTime(parseSecondsAndMillisFromString(string));
		}
	}

	private void loadDiscusThrowLengthUsing(Athlete.Builder builder, String string) throws Exception {
		builder.setDiscusThrowLength(getDoubleFromString(string));
	}

	private void loadDateOfBirthUsing(Athlete.Builder builder, String string) throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new SimpleDateFormat("d.MM.yyyy").parse(string));
		builder.setDateOfBirth(calendar);

	}

	private void loadCountryISO2LetterCodeUsing(Athlete.Builder builder, String string) throws Exception {
		builder.setCountryISO2LetterCode(string);
	}

	private void loadNameUsing(Athlete.Builder builder, String string) throws Exception {
		builder.name(string.replaceAll("\"", ""));
	}

	double getDoubleFromString(String string) throws Exception {
		try {
			return valueOf(string);
		} catch (Exception e) {
			exceptionInnerHandler(e);
			throw new Exception();
		}
	}

	private void exceptionInnerHandler(Exception e) throws Exception {
		if (e instanceof StopLoadingAthletesException) throw new StopLoadingAthletesException();
		else if (e instanceof SkipLoadingAthleteException) throw new SkipLoadingAthleteException();
	}
}