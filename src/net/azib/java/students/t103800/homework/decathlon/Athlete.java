package net.azib.java.students.t103800.homework.decathlon;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * This class stores data about athletes: birth date, country, name and results.
 * This class also includes the event enumeration which is used to calculate
 * the decathlon score of the athlete. It is possible to get data as a CSV element,
 * a string and as a CSV string.
 *
 * @see Event
 * @see CountryCodeException
 *
 * @author Jaan Aigro
 * @version 1.0
 * @since 27/05/2011
 */
public class Athlete {

	private final static String BIRTHDATE_FORMAT_STRING1 = "dd.MM.yyyy";
	private final static String BIRTHDATE_FORMAT_STRING2 = "yyyy-MM-dd";
	private final static SimpleDateFormat BIRTHDATE_FORMAT1 = generateLenientDateFormat(BIRTHDATE_FORMAT_STRING1);
	private final static SimpleDateFormat BIRTHDATE_FORMAT2 = generateLenientDateFormat(BIRTHDATE_FORMAT_STRING2);
	private final static SimpleDateFormat MINS_SECS_FORMAT = generateLenientDateFormat("mm:ss.SSS");

	private static final DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
	private static final DecimalFormat decimalResultFormat = new DecimalFormat("#0.00", decimalFormatSymbols);
	private static final DecimalFormat fullDecimalResultFormat = new DecimalFormat("00.00", decimalFormatSymbols);

	private String name;
	private Date birthdate;
	private String countryCode;
	private HashMap<Event, Double> results;

	/**
	 * Constructs a new athlete object which stores data about the athlete.
	 */
	public Athlete() {
		name = null;
		birthdate = null;
		countryCode = null;
		results = new HashMap<Event, Double>();
	}

	/**
	 * Sets the name of the athlete.
	 * @param name name.
	 */
	public void setName(String name) {
		if(name.contains("\"")) name = name.replace("\"", "");
		this.name = name;
	}

	/**
	 * Sets the birth date of the athlete. Format: day.month.year
	 * This method also validates the date(using SimpleDateFormat with lenient mode).
	 * It stores the birth date as a Date object.
	 * @see Date
	 * @param dateString Birth date as a string.
	 * @throws ParseException throws when failed to validate.
	 */
	public void setBirthDate(String dateString) throws ParseException {
		try {
			birthdate = BIRTHDATE_FORMAT1.parse(dateString);
		} catch (ParseException e) {
			birthdate = BIRTHDATE_FORMAT2.parse(dateString);
		}
	}

	/**
	 * Sets and validates the country code. The code must be 2 characters long.
	 * @param code country code.
	 * @throws CountryCodeException throws when such a country code does not exist.
	 */
	public void setCountryCode(String code) throws CountryCodeException {
		code = code.toUpperCase();
		if(!Arrays.asList(Locale.getISOCountries()).contains(code)) throw new CountryCodeException(code);
		countryCode = code;
	}

	/**
	 * Gets the name of the athlete.
	 * @return athlete name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the birth date of the athlete as a string in the format: day.month.year
	 * @return birth date as a string.
	 */
	public String getBirthDate() {
		if(birthdate == null) return null;
		return BIRTHDATE_FORMAT1.format(birthdate);
	}

	/**
	 * Gets the country code of the athlete.
	 * @return 2-letter country code.
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * Gets the result of an event. Returns in seconds(for time) or in meters(for length/height).
	 * @param event result in meters(length/height) or seconds(time).
	 * @return event result.
	 */
	public double getResult(Event event) {
		return results.get(event);
	}

	/**
	 * Gets the result of an event as a formatted string. Formation depends on the
	 * type of the competition. For time the result could be mins:seconds or seconds and for
	 * length/height it is a simple double value. Values are returned with the precision of
	 * two decimal points.
	 * @param event decathlon event.
	 * @return event result as a formatted string.
	 */
	public String getResultAsString(Event event) {
		switch(event) {
		case SPRINT100M: case SPRINT400M: case HURDLES110M: case RACE1500M:
			String minutes = "";
			if(results.get(event) >= 60) minutes += (int)(results.get(event) / 60) + ":";

			return minutes + fullDecimalResultFormat.format(results.get(event) % 60.0);
		case DISCUSTHROW: case JAVELINTHROW: case SHOTPUT: case LONGJUMP: case HIGHJUMP: case POLEVAULT:
			return decimalResultFormat.format(results.get(event));
		}
		return null;
	}

	/**
	 * Sets and validates the result of an event.
	 * @param event event.
	 * @param result event result in the correct format. For time mins:seconds or seconds
	 * and for length/height meters.
	 * @throws ParseException throws when the data is in a bad format.
	 */
	public void setResult(Event event, String result) throws ParseException {
		double parsedResult = 0;

		switch(event.getResultType()) {
		case MINS_ANDOR_SECS:
			if(!result.contains(":")) result = "0:" + result;
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(MINS_SECS_FORMAT.parse(result));

			String millisString = result.substring(result.indexOf(".") + 1).trim();
			int millis = (int) (Double.parseDouble(millisString) * Math.pow(10, 3 - millisString.length()));
			parsedResult = calendar.get(Calendar.MINUTE) * 60.0 + calendar.get(Calendar.SECOND) + millis / 1000.0;
			break;
		case METERS:
			parsedResult = Double.parseDouble(result);
			break;
		}

		results.put(event, parsedResult);
	}

	/**
	 * Sets the result of an event. Units: seconds for time and meters for height and length.
	 * @param event event.
	 * @param result result in meters or seconds.
	 */
	public void setResult(Event event, double result) {
		results.put(event, result);
	}

	/**
	 * Returns the information about the athlete as a CSV string(without score).
	 * @return athlete data as a CSV string.
	 */
	public String getAsCSVString() {
		String csv = "\"" + name + "\"," + getBirthDate() + "," + countryCode;
		for(Event event : Event.values()) csv += "," + getResultAsString(event);
		return csv;
	}

	/**
	 * Returns the athlete as a nicely readable string where data is separated with
	 * commas and spaces.
	 * @return information about athlete.
	 */
	public String getAsReadableString() {
		String athleteInfo = "\"" + name + "\", " + getBirthDate() + ", " + countryCode;
		for(Event event : Event.values()) athleteInfo += ", " + getResultAsString(event);
		return athleteInfo;
	}

	/**
	 * Creates an XML element about the athlete. The data is stored inside this
	 * element using an element for each data field.
	 * @param document XML/HTML document to use.
	 * @return element where data is stored in its child elements.
	 */
	public Element toXMLElement(Document document) {
		Element athleteElement = document.createElement("athlete");

		Element nameElement = document.createElement("name");
		nameElement.appendChild(document.createTextNode(name));
		athleteElement.appendChild(nameElement);

		Element birthElement = document.createElement("birthdate");
		birthElement.appendChild(document.createTextNode(getBirthDate()));
		athleteElement.appendChild(birthElement);

		Element countryCodeElement = document.createElement("countrycode");
		countryCodeElement.appendChild(document.createTextNode(countryCode));
		athleteElement.appendChild(countryCodeElement);

		for(Event event : Event.values()) {
			Element resultElement = document.createElement(event.toString().toLowerCase());
			resultElement.appendChild(document.createTextNode(getResultAsString(event)));
			athleteElement.appendChild(resultElement);
		}

		return athleteElement;
	}

	/**
	 * Calculates the decathlon score.
	 * @return decathlon points.
	 */
	public int calculatePoints() {
		int points = 0;
		for(Event event : Event.values()) {
			switch(event) {
			case SPRINT100M: case SPRINT400M: case HURDLES110M: case RACE1500M:
				points += (int)(event.paramA * Math.pow(event.paramB - results.get(event), event.paramC));
				break;
			case DISCUSTHROW: case JAVELINTHROW: case SHOTPUT:
				points += (int)(event.paramA * Math.pow(results.get(event) - event.paramB, event.paramC));
				break;
			case LONGJUMP: case HIGHJUMP: case POLEVAULT:
				points += (int)(event.paramA * Math.pow(results.get(event) * 100.0 - event.paramB, event.paramC));
				break;
			}
		}
		return points;
	}

	/**
	 * Used to create a lenient date format.
	 * @param pattern the pattern describing the date and time format.
	 * @return the format.
	 */
	private static SimpleDateFormat generateLenientDateFormat(String pattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		dateFormat.setLenient(false);
		return dateFormat;
	}

	/**
	 * This enumeration is used to hold information about events and their
	 * parameters(which are used for calculating score). It holds also the information
	 * of the data format which should be used when parsing/formatting data about event
	 * results.
	 *
	 * @author Jaan Aigro
	 * @version 1.0
	 * @since 23/05/2011
	 */
	public enum Event {
		SPRINT100M(ResultType.MINS_ANDOR_SECS, 25.4347, 18.0, 1.81),
		LONGJUMP(ResultType.METERS, 0.14354, 220.0, 1.4),
		SHOTPUT(ResultType.METERS, 51.39, 1.5, 1.05),
		HIGHJUMP(ResultType.METERS, 0.8465, 75.0, 1.42),
		SPRINT400M(ResultType.MINS_ANDOR_SECS, 1.53775, 82.0, 1.81),
		HURDLES110M(ResultType.MINS_ANDOR_SECS, 5.74352, 28.5, 1.92),
		DISCUSTHROW(ResultType.METERS, 12.91, 4.0, 1.1),
		POLEVAULT(ResultType.METERS, 0.2797, 100.0, 1.35),
		JAVELINTHROW(ResultType.METERS, 10.14, 7.0, 1.08),
		RACE1500M(ResultType.MINS_ANDOR_SECS, 0.03768, 480.0, 1.85);

		private ResultType type;
		private final double paramA, paramB, paramC;

		/**
		 * Event constructor.
		 * @param type type which determines the type of formatting/parsing that
		 * should be used for the result of this event.
		 * @param paramA first parameter for calculating the decathlon score.
		 * @param paramB second parameter for calculating the decathlon score.
		 * @param paramC third parameter for calculating the decathlon score.
		 */
		Event(ResultType type, double paramA, double paramB, double paramC) {
			this.type = type;
			this.paramA = paramA;
			this.paramB = paramB;
			this.paramC = paramC;
		}

		/**
		 * Returns the type of formatting/parsing that should be used.
		 * @return type.
		 */
		public ResultType getResultType() {
			return type;
		}
	}

	/**
	 * Result types are used to determine which kind of parsing/formatting should be used
	 * for a certain event.
	 *
	 * @author Jaan Aigro
	 * @version 1.0
	 * @since 23/05/2011
	 */
	public enum ResultType {
		MINS_ANDOR_SECS, METERS;
	}
}