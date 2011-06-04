package net.azib.java.students.t093759.homework;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static net.azib.java.students.t093759.homework.AthleteDataLoaderHelper.MIN_SEC_MILLI_FORMAT;
import static net.azib.java.students.t093759.homework.AthleteDataLoaderHelper.SEC_MILLI_FORMAT;

/**
 * Athlete loader utility class .
 *
 * @author dionis
 *         5/29/119:56 PM
 */
public class ConsoleLoader implements AthletesLoader {
	/**
	 * When this constant will appear in input, athlete won't.
	 */
	private static final String ATHLETE_STOP_LOADING_CONDITION = "stop";
	private static final String ATHLETE_SKIP_LOADING_CONDITION = "skip";
	InputStream in = System.in;
	private static final AthleteDataLoaderHelper ATHLETE_DATA_LOADER_HELPER = AthleteDataLoaderHelper.getInstance();
	String localizedPatternOfDateOfBirth = ((SimpleDateFormat) DateFormat.getDateInstance()).toLocalizedPattern();
	private BufferedReader bufferedReader;

	/**
	 * @param additionalParams Parameters are ignored.
	 */
	@Override
	public List<Athlete> load(Object... additionalParams) {
		List<Athlete> athletes = new ArrayList<Athlete>(100);
		bufferedReader = new BufferedReader(new InputStreamReader(in));
		while (true) {
			System.out.println("To stop loading athletes please enter " + ATHLETE_STOP_LOADING_CONDITION + IOUtils.LINE_SEPARATOR
					+ "To skip loading athletes please enter " + ATHLETE_SKIP_LOADING_CONDITION);
			try {
				athletes.add(loadAthlete());
			} catch (StopLoadingAthletesException e) {
				break;
			} catch (SkipLoadingAthleteException ignore) {
			}
		}

		return athletes;
	}

	private Athlete loadAthlete() throws StopLoadingAthletesException, SkipLoadingAthleteException {
		Athlete.Builder builder = new Athlete.Builder();

		loadAllAthleteFieldsUsing(builder);

		try {
			return builder.build();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	private void loadAllAthleteFieldsUsing(Athlete.Builder builder) throws StopLoadingAthletesException, SkipLoadingAthleteException {
		loadNameUsing(builder);
		loadDateOfBirthUsing(builder);
		loadCountryISO2LetterCodeUsing(builder);
		loadOneHundredMeterSprintTimeUsing(builder);
		loadLongJumpLengthUsing(builder);
		loadShotPutLengthUsing(builder);
		loadHighJumpHeightUsing(builder);
		loadFourHundredMeterSprintTimeUsing(builder);
		loadOneHundredTenMeterHurdlesTimeUsing(builder);
		loadDiscusThrowLengthUsing(builder);
		loadPoleVaultHeightUsing(builder);
		loadJavelinThrowLengthUsing(builder);
		loadThousandFiveHundredMeterRaceTimeUsing(builder);
	}

	private void loadThousandFiveHundredMeterRaceTimeUsing(Athlete.Builder builder) throws StopLoadingAthletesException, SkipLoadingAthleteException {
		try {
			System.out.print("1500 m race time s in format '" + MIN_SEC_MILLI_FORMAT.toPattern() + "': ");
//			builder.setThousandFiveHundredMeterRaceTime(parseMinutesAndSecondsAndMillisFromInputStream());
			ATHLETE_DATA_LOADER_HELPER.loadThousandFiveHundredMeterRaceTimeUsing(builder, getStringFromInputStream());
		} catch (Exception e) {
			exceptionInnerHandler(e);
			System.err.println(e.getMessage());
			loadThousandFiveHundredMeterRaceTimeUsing(builder);
		}
	}

	private void loadShotPutLengthUsing(Athlete.Builder builder) throws StopLoadingAthletesException, SkipLoadingAthleteException {
		try {
			System.out.print("shot put length m: ");
//			builder.setShotPutLength(getDoubleFromInputStream());
			ATHLETE_DATA_LOADER_HELPER.loadShotPutLengthUsing(builder, getStringFromInputStream());
		} catch (Exception e) {
			exceptionInnerHandler(e);
			System.err.println(e.getMessage());
			loadShotPutLengthUsing(builder);
		}
	}

	private void loadPoleVaultHeightUsing(Athlete.Builder builder) throws StopLoadingAthletesException, SkipLoadingAthleteException {
		try {
			System.out.print("pole vault height m: ");
//			builder.setPoleVaultHeight(getDoubleFromInputStream());
			ATHLETE_DATA_LOADER_HELPER.loadPoleVaultHeightUsing(builder, getStringFromInputStream());
		} catch (Exception e) {
			exceptionInnerHandler(e);
			System.err.println(e.getMessage());
			loadPoleVaultHeightUsing(builder);
		}
	}

	private void loadOneHundredTenMeterHurdlesTimeUsing(Athlete.Builder builder) throws StopLoadingAthletesException, SkipLoadingAthleteException {
		try {
			System.out.print("110 m hurdles time s in format '" + SEC_MILLI_FORMAT.toPattern() + "': ");
//			builder.setOneHundredTenMeterHurdlesTime(parseSecondsAndMillisFromInputStream());
			ATHLETE_DATA_LOADER_HELPER.loadOneHundredTenMeterHurdlesTimeUsing(builder, getStringFromInputStream());
		} catch (Exception e) {
			exceptionInnerHandler(e);
			System.err.println(e.getMessage());
			loadOneHundredTenMeterHurdlesTimeUsing(builder);
		}
	}

//	double parseMinutesAndSecondsAndMillisFromInputStream() throws ParseException, StopLoadingAthletesException, SkipLoadingAthleteException {
//		return parseSomeDateIntoDoubleAccordingTo(MIN_SEC_MILLI_FORMAT);
//	}
//
//	double parseSecondsAndMillisFromInputStream() throws ParseException, StopLoadingAthletesException, SkipLoadingAthleteException {
//		return parseSomeDateIntoDoubleAccordingTo(SEC_MILLI_FORMAT);
//	}

//	private double parseSomeDateIntoDoubleAccordingTo(SimpleDateFormat format) throws ParseException, StopLoadingAthletesException, SkipLoadingAthleteException {
//		Calendar calendar = new GregorianCalendar();
//		final String resultToParse = getStringFromInputStream();
//		calendar.setTime(format.parse(resultToParse));
//		double divisor = Math.pow(10, resultToParse.split("\\.")[1].trim().length());
//		return calendar.get(Calendar.MINUTE) * 60 + calendar.get(Calendar.SECOND) + calendar.get(Calendar.MILLISECOND) / divisor;
//	}

	private void loadOneHundredMeterSprintTimeUsing(Athlete.Builder builder) throws StopLoadingAthletesException, SkipLoadingAthleteException {
		try {
			System.out.print("100 m spring time s in format '" + SEC_MILLI_FORMAT.toPattern() + "': ");
//			builder.setOneHundredMeterSprintTime(parseSecondsAndMillisFromInputStream());
			ATHLETE_DATA_LOADER_HELPER.loadOneHundredMeterSprintTimeUsing(builder, getStringFromInputStream());
		} catch (Exception e) {
			exceptionInnerHandler(e);
			System.err.println(e.getMessage());
			loadOneHundredMeterSprintTimeUsing(builder);
		}
	}

	private void loadLongJumpLengthUsing(Athlete.Builder builder) throws StopLoadingAthletesException, SkipLoadingAthleteException {
		try {
			System.out.print("long jump length: ");
//			builder.setLongJumpLength(getDoubleFromInputStream());
			ATHLETE_DATA_LOADER_HELPER.loadLongJumpLengthUsing(builder, getStringFromInputStream());
		} catch (Exception e) {
			exceptionInnerHandler(e);
			System.err.println(e.getMessage());
			loadLongJumpLengthUsing(builder);
		}
	}

	private void loadJavelinThrowLengthUsing(Athlete.Builder builder) throws StopLoadingAthletesException, SkipLoadingAthleteException {
		try {
			System.out.print("Javelin throw length m: ");
//			builder.setJavelinThrowLength(getDoubleFromInputStream());
			ATHLETE_DATA_LOADER_HELPER.loadJavelinThrowLengthUsing(builder, getStringFromInputStream());
		} catch (Exception e) {
			exceptionInnerHandler(e);
			System.err.println(e.getMessage());
			loadJavelinThrowLengthUsing(builder);
		}
	}

	private void loadHighJumpHeightUsing(Athlete.Builder builder) throws StopLoadingAthletesException, SkipLoadingAthleteException {
		try {
			System.out.print("High jump length m: ");
//			builder.setHighJumpHeight(getDoubleFromInputStream());
			ATHLETE_DATA_LOADER_HELPER.loadHighJumpHeightUsing(builder, getStringFromInputStream());
		} catch (Exception e) {
			exceptionInnerHandler(e);
			System.err.println(e.getMessage());
			loadHighJumpHeightUsing(builder);
		}
	}

	private void loadFourHundredMeterSprintTimeUsing(Athlete.Builder builder) throws StopLoadingAthletesException, SkipLoadingAthleteException {
		try {
			System.out.print("400 meter sprint time s in format '" + MIN_SEC_MILLI_FORMAT.toPattern() + "': ");
//			builder.setFourHundredMeterSprintTime(parseMinutesAndSecondsAndMillisFromInputStream());
			ATHLETE_DATA_LOADER_HELPER.loadFourHundredMeterSprintTimeUsing(builder, getStringFromInputStream());
		} catch (Exception e) {
			exceptionInnerHandler(e);
			System.err.println(e.getMessage());
			loadFourHundredMeterSprintTimeUsing(builder);
		}
	}

	private void loadDiscusThrowLengthUsing(Athlete.Builder builder) throws StopLoadingAthletesException, SkipLoadingAthleteException {
		try {
			System.out.print("Discus throw length m: ");
//			builder.setDiscusThrowLength(getDoubleFromInputStream());
			ATHLETE_DATA_LOADER_HELPER.loadDiscusThrowLengthUsing(builder, getStringFromInputStream());
		} catch (Exception e) {
			exceptionInnerHandler(e);
			System.err.println(e.getMessage());
			loadDiscusThrowLengthUsing(builder);
		}
	}

	private void loadDateOfBirthUsing(Athlete.Builder builder) throws StopLoadingAthletesException, SkipLoadingAthleteException {
		try {
			System.out.print("Load date using " + Locale.getDefault() + " format '" + localizedPatternOfDateOfBirth + "': ");
//			Calendar calendar = Calendar.getInstance();
//			calendar.setTime(new SimpleDateFormat(localizedPatternOfDateOfBirth).parse(getStringFromInputStream()));
//			builder.setDateOfBirth(calendar);
			ATHLETE_DATA_LOADER_HELPER.loadDateOfBirthUsing(builder, getStringFromInputStream(), localizedPatternOfDateOfBirth);
		} catch (Exception e) {
			exceptionInnerHandler(e);
			System.err.println(e.getMessage());
			loadDateOfBirthUsing(builder);
		}
	}

	private void loadCountryISO2LetterCodeUsing(Athlete.Builder builder) throws StopLoadingAthletesException, SkipLoadingAthleteException {
		try {
			System.out.print("Country ISO2 letter code: ");
//			builder.setCountryISO2LetterCode(getStringFromInputStream());
			ATHLETE_DATA_LOADER_HELPER.loadCountryISO2LetterCodeUsing(builder, getStringFromInputStream());
		} catch (Exception e) {
			exceptionInnerHandler(e);
			System.err.println(e.getMessage());
			loadCountryISO2LetterCodeUsing(builder);
		}
	}

	private void loadNameUsing(Athlete.Builder builder) throws StopLoadingAthletesException, SkipLoadingAthleteException {
		try {
			System.out.print("Name: ");
//			builder.name(getStringFromInputStream());
			ATHLETE_DATA_LOADER_HELPER.loadNameUsing(builder, getStringFromInputStream());
		} catch (Exception e) {
			exceptionInnerHandler(e);
			System.err.println(e.getMessage());
			loadNameUsing(builder);
		}
	}

	String getStringFromInputStream() throws StopLoadingAthletesException, SkipLoadingAthleteException {
		String readString = "";
		try {
			readString = bufferedReader.readLine().trim();
			if (readString.toLowerCase().equals(ATHLETE_STOP_LOADING_CONDITION))
				throw new StopLoadingAthletesException();
			if (readString.toLowerCase().equals(ATHLETE_SKIP_LOADING_CONDITION))
				throw new SkipLoadingAthleteException();
		} catch (IOException e) {
			System.err.println("I don't know why, but read error appeared.");//
			throw new RuntimeException(e.getMessage(), e.getCause());
		}
		return readString;
	}

//	double getDoubleFromInputStream() throws Exception {
//		try {
//			return valueOf(getStringFromInputStream());
//		} catch (Exception e) {
//			exceptionInnerHandler(e);
//			throw new Exception();
//		}
//	}

	private void exceptionInnerHandler(Exception e) throws StopLoadingAthletesException, SkipLoadingAthleteException {
		if (e instanceof StopLoadingAthletesException) throw new StopLoadingAthletesException();
		else if (e instanceof SkipLoadingAthleteException) throw new SkipLoadingAthleteException();
	}
}
