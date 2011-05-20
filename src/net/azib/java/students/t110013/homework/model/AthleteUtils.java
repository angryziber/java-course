package net.azib.java.students.t110013.homework.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import static java.lang.Double.parseDouble;

/**
 * An utility class with static methods. Used by different AthleteReader implementations to parse and validate raw
 * Athletes' data from various sources.
 * @author Vadim
 */
public class AthleteUtils {
    private static final int SECONDS_IN_MINUTE = 60;
    private static final Logger LOG = Logger.getLogger(AthleteUtils.class.getName());

	/**
	 * An utility method used to validate an unicode name of an Athlete. Contains a simple regular expression that
	 * defines legal characters. The legal characters are: unicode letters, parenthesis, dash and dot.
	 * @param string a unicode name
	 * @return the parameter String in the unchanged form
	 * @throws IllegalArgumentException if string does not match regular expression
	 */
    public static String validateName(String string) {
        if (string.matches("([\\p{L}\\s\\.\\-\\(\\)]{2,}){3,}"))
            return string;
        else {
            LOG.severe("Athlete's name is invalid.\n" +
                    "Full name is expected.\n" +
                    "Valid characters: unicode letters, dots, parenthesis and dashes.\n");
            throw new IllegalArgumentException();
        }
    }

	/**
	 * An utility method used to parse and validate a date of birth of an Athlete. Uses provided SimpleDateFormat to correctly
	 * parse the date from different sources.
	 * @param string a String representation of the date to be parsed
	 * @param dateFormat a SimpleDateFormat instance that will be used to parse and validate the parameter String
	 * @return a Date instance corresponding to the date in the parameter string
	 * @throws IllegalArgumentException if string cannot be parsed to date
	 */
    public static Date validateAndParseDate(String string, SimpleDateFormat dateFormat) {
        try {
            return dateFormat.parse(string);
        }
        catch (ParseException e) {
            LOG.severe("Athlete's date of birth is not in a valid format.\n" +
                    "Valid format: " + dateFormat.toPattern() + "\n");
            throw new IllegalArgumentException(e);
        }
    }

	/**
	 * An utility method used to validate a country of an Athlete. The country is validated against the ISO 2-letter code.
	 * A simple regular expression is used.
	 * @param string a country code
	 * @return the parameter String in the unchanged form
	 * @throws IllegalArgumentException if string does not match regular expression
	 */
    public static String validateCountry(String string) {
        if (string.matches("[A-Z][A-Z]"))
            return string;
        else {
            LOG.severe("Athlete's country code is not in a valid format.\n" +
                    "Valid format: [A-Z][A-Z], eg US.\n");
            throw new IllegalArgumentException();
        }
    }

	/**
	 * An utility method used to parse and validate a performance result of an Athlete. The performance result is
	 * expected to be either a distance in meters or time in mm:ss.SSS or sss.SSS format.
	 * @param string a performance result
	 * @return a double value representing the performance result
	 * @throws IllegalArgumentException if string cannot be parsed to double
	 */
    public static double validateAndParsePerformanceResult(String string) {
        String[] resultValues = string.split("[\\.:]");

        try {
            if (resultValues.length == 1 || resultValues.length == 2)
                return parseDouble(string);
            else if (resultValues.length == 3)
                return parseDouble(resultValues[0]) * SECONDS_IN_MINUTE + parseDouble(resultValues[1] + "." + resultValues[2]);
            else
                throw new NumberFormatException();
        }
        catch (NumberFormatException e) {
            LOG.severe("Athlete's performance result is not in a valid format.\n" +
                    "Valid formats: meters (for distance), mm:ss.SSS or sss.SSS (for time).\n");
            throw new IllegalArgumentException(e);
        }
    }
}
