package net.azib.java.students.t110013.homework.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import static java.lang.Double.parseDouble;

/**
 * @author Vadim
 */
public class AthleteUtils {
    private static final int SECONDS_IN_MINUTE = 60;
    private static final Logger LOG = Logger.getLogger(AthleteUtils.class.getName());

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

    public static String validateCountry(String string) {
        if (string.matches("[A-Z][A-Z]"))
            return string;
        else {
            LOG.severe("Athlete's country code is not in a valid format.\n" +
                    "Valid format: [A-Z][A-Z], eg US.\n");
            throw new IllegalArgumentException();
        }
    }

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
