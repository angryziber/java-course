package net.azib.java.students.t093759.homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static java.lang.Double.valueOf;

/**
 * Helper(utility) class for athlete data loading.
 *
 * @author dionis
 *         6/4/11 7:17 PM
 */
public class AthleteDataLoaderHelper {
	private static final SimpleDateFormat MIN_SEC_MILLI_FORMAT = new SimpleDateFormat("mm:ss.SSS");
	private static final SimpleDateFormat SEC_MILLI_FORMAT = new SimpleDateFormat("ss.SSS");
	private static final String DEFAULT_DATE_OF_BIRTH_FORMAT = "d.MM.yyyy";

	private static AthleteDataLoaderHelper instance;

	/**
	 * Get instance of athlete data loader helper.
	 *
	 * @return Instance.
	 */
	public static AthleteDataLoaderHelper getInstance() {
		if (instance == null) {
			instance = new AthleteDataLoaderHelper();
		}
		return instance;
	}

	private AthleteDataLoaderHelper() {
	}

	/**
	 * Load 1500 m race time into athlete builder in format 'mm:ss.SSS' or 'ss.SSS'.
	 * Where:
	 * 'mm' are minutes
	 * 'ss' are seconds
	 * 'SSS' are milliseconds
	 *
	 * @param builder Athlete builder instance where result will be put.
	 * @param string  String to parse from
	 * @throws Exception Exception will be thrown if it's unable to parse time.
	 */
	public void loadThousandFiveHundredMeterRaceTimeUsing(Athlete.Builder builder, String string) throws Exception {
		double time;
		try {
			time = parseSecondsAndMillisFromString(string);
		} catch (ParseException e) {
			time = parseMinutesAndSecondsAndMillisFromString(string);
		}
		builder.setThousandFiveHundredMeterRaceTime(time);
	}

	/**
	 * Load 110 m hurdles time into athlete builder in format 'mm:ss.SSS' or 'ss.SSS'.
	 * Where:
	 * 'mm' are minutes
	 * 'ss' are seconds
	 * 'SSS' are milliseconds
	 *
	 * @param builder Athlete builder instance where result will be put.
	 * @param string  String to parse from
	 * @throws Exception Exception will be thrown if it's unable to parse time.
	 */
	public void loadOneHundredTenMeterHurdlesTimeUsing(Athlete.Builder builder, String string) throws Exception {
		double time;
		try {
			time = parseSecondsAndMillisFromString(string);
		} catch (ParseException e) {
			time = parseMinutesAndSecondsAndMillisFromString(string);
		}
		builder.setOneHundredTenMeterHurdlesTime(time);
	}

	/**
	 * Load 110 m sprint time into athlete builder in format 'mm:ss.SSS' or 'ss.SSS'.
	 * Where:
	 * 'mm' are minutes
	 * 'ss' are seconds
	 * 'SSS' are milliseconds
	 *
	 * @param builder Athlete builder instance where result will be put.
	 * @param string  String to parse from
	 * @throws Exception Exception will be thrown if it's unable to parse time.
	 */
	public void loadOneHundredMeterSprintTimeUsing(Athlete.Builder builder, String string) throws Exception {
		double time;
		try {
			time = parseSecondsAndMillisFromString(string);
		} catch (ParseException e) {
			time = parseMinutesAndSecondsAndMillisFromString(string);
		}
		builder.setOneHundredMeterSprintTime(time);
	}

	/**
	 * Load 400 m sprint time into athlete builder in format 'mm:ss.SSS' or 'ss.SSS'.
	 * Where:
	 * 'mm' are minutes
	 * 'ss' are seconds
	 * 'SSS' are milliseconds
	 *
	 * @param builder Athlete builder instance where result will be put.
	 * @param string  String to parse from
	 * @throws Exception Exception will be thrown if it's unable to parse length.
	 */
	public void loadFourHundredMeterSprintTimeUsing(Athlete.Builder builder, String string) throws Exception {
		try {
			builder.setFourHundredMeterSprintTime(parseMinutesAndSecondsAndMillisFromString(string));
		} catch (ParseException e) {
			builder.setFourHundredMeterSprintTime(parseSecondsAndMillisFromString(string));
		}
	}

	/**
	 * Load shot put length in meter into athlete builder in format 'meter.centimeter'.
	 * Where:
	 * 'meter' means part in meters.
	 * 'centimeter' means part in centimeters.
	 *
	 * @param builder Athlete builder instance where result will be put.
	 * @param string  String to parse from
	 * @throws Exception Exception will be thrown if it's unable to parse length.
	 */
	public void loadShotPutLengthUsing(Athlete.Builder builder, String string) throws Exception {
		builder.setShotPutLength(getDoubleFromString(string));
	}

	/**
	 * Load shot put length in meter into athlete builder in format 'meter.centimeter'.
	 * Where:
	 * 'meter' means part in meters.
	 * 'centimeter' means part in centimeters.
	 *
	 * @param builder Athlete builder instance where result will be put.
	 * @param string  String to parse from
	 * @throws Exception Exception will be thrown if it's unable to parse length.
	 */
	public void loadPoleVaultHeightUsing(Athlete.Builder builder, String string) throws Exception {
		builder.setPoleVaultHeight(getDoubleFromString(string));
	}

	/**
	 * Load shot put length in meter into athlete builder in format 'meter.centimeter'.
	 * Where:
	 * 'meter' means part in meters.
	 * 'centimeter' means part in centimeters.
	 *
	 * @param builder Athlete builder instance where result will be put.
	 * @param string  String to parse from
	 * @throws Exception Exception will be thrown if it's unable to parse length.
	 */
	public void loadLongJumpLengthUsing(Athlete.Builder builder, String string) throws Exception {
		builder.setLongJumpLength(getDoubleFromString(string));
	}

	/**
	 * Load shot put length in meter into athlete builder in format 'meter.centimeter'.
	 * Where:
	 * 'meter' means part in meters.
	 * 'centimeter' means part in centimeters.
	 *
	 * @param builder Athlete builder instance where result will be put.
	 * @param string  String to parse from
	 * @throws Exception Exception will be thrown if it's unable to parse length.
	 */
	public void loadJavelinThrowLengthUsing(Athlete.Builder builder, String string) throws Exception {
		builder.setJavelinThrowLength(getDoubleFromString(string));
	}

	/**
	 * Load shot put length in meter into athlete builder in format 'meter.centimeter'.
	 * Where:
	 * 'meter' means part in meters.
	 * 'centimeter' means part in centimeters.
	 *
	 * @param builder Athlete builder instance where result will be put.
	 * @param string  String to parse from
	 * @throws Exception Exception will be thrown if it's unable to parse length.
	 */
	public void loadHighJumpHeightUsing(Athlete.Builder builder, String string) throws Exception {
		builder.setHighJumpHeight(getDoubleFromString(string));
	}

	/**
	 * Load shot put length in meter into athlete builder in format 'meter.centimeter'.
	 * Where:
	 * 'meter' means part in meters.
	 * 'centimeter' means part in centimeters.
	 *
	 * @param builder Athlete builder instance where result will be put.
	 * @param string  String to parse from
	 * @throws Exception Exception will be thrown if it's unable to parse length.
	 */
	public void loadDiscusThrowLengthUsing(Athlete.Builder builder, String string) throws Exception {
		builder.setDiscusThrowLength(getDoubleFromString(string));
	}

	/**
	 * Load date of birth into athlete builder specified date format.
	 *
	 * @param builder    Athlete builder instance where result will be put.
	 * @param string     String to parse from.
	 * @param dateFormat Date format to parse from.
	 * @throws Exception Exception will be thrown if it's unable to parse date of birth.
	 */
	public void loadDateOfBirthUsing(Athlete.Builder builder, String string, String dateFormat) throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new SimpleDateFormat(dateFormat).parse(string));
		builder.setDateOfBirth(calendar);
	}

	/**
	 * Load Country ISO2 Letter code (two letter country code).
	 *
	 * @param builder Athlete builder instance where result will be put.
	 * @param string  String to parse from.
	 * @throws Exception Exception will be thrown if it's unable to parse country ISO2 letter country code.
	 */
	public void loadCountryISO2LetterCodeUsing(Athlete.Builder builder, String string) throws Exception {
		builder.setCountryISO2LetterCode(string);
	}

	/**
	 * Load date of birth into athlete builder in format 'd.MM.yyyy'.
	 * Where:
	 * 'd' is a day of month.
	 * 'MM' is month part
	 * 'yyyy' is year part
	 *
	 * @param builder Athlete builder instance where result will be put.
	 * @param string  String to parse from.
	 * @throws Exception Exception will be thrown if it's unable to parse date of birth.
	 */
	public void loadDateOfBirthUsing(Athlete.Builder builder, String string) throws Exception {
		loadDateOfBirthUsing(builder, string, DEFAULT_DATE_OF_BIRTH_FORMAT);
	}

	/**
	 * Load athletes name.
	 *
	 * @param builder Athlete builder instance where result will be put.
	 * @param string  String to parse from. If string contains symbol " (double quote) it will be removed.
	 * @throws Exception Exception will be thrown if it's unable to parse athletes name.
	 */
	public void loadNameUsing(Athlete.Builder builder, String string) throws Exception {
		builder.name(string.replaceAll("\"", ""));
	}

	private double getDoubleFromString(String string) throws Exception {
		return valueOf(string);
	}

	private double parseSomeDateIntoDoubleAccordingTo(SimpleDateFormat format, String source) throws ParseException, StopLoadingAthletesException, SkipLoadingAthleteException {
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(format.parse(source));
		double divisor = Math.pow(10, source.split("\\.")[1].trim().length());
		return calendar.get(Calendar.MINUTE) * 60 + calendar.get(Calendar.SECOND) + calendar.get(Calendar.MILLISECOND) / divisor;
	}

	private double parseSecondsAndMillisFromString(String source) throws ParseException, StopLoadingAthletesException, SkipLoadingAthleteException {
		return parseSomeDateIntoDoubleAccordingTo(SEC_MILLI_FORMAT, source);
	}

	private double parseMinutesAndSecondsAndMillisFromString(String source) throws ParseException, StopLoadingAthletesException, SkipLoadingAthleteException {
		return parseSomeDateIntoDoubleAccordingTo(MIN_SEC_MILLI_FORMAT, source);
	}
}
