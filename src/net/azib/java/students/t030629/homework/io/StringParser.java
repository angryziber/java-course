package net.azib.java.students.t030629.homework.io;

import net.azib.java.students.t030629.homework.base.DecathlonEvent;
import net.azib.java.students.t030629.homework.DecathlonCalculator;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.math.BigDecimal;
import java.io.IOException;

/**
 * Class performs parsing of String representations of
 * {@link net.azib.java.students.t030629.homework.base.Athlete Athlete's} name, date of birth and
 * event results, received mainly from CSV files or user's console input.
 *
 * <br><br>User: Anton Chepurov
 * <br>Date: 12.05.2008
 * <br>Time: 11:06:50
 */
public class StringParser {
    private static final String MALFORMED_RESULT_TEXT = "Malformed result: ";

    /** Forbid instantiation */
    private StringParser() {}

    /**
     * Parses name recieved from CSV file
     * @param nameAsString string representation of the name to parse
     * @return parsed pure name
     */
    public static String parseName(String nameAsString) {
        return nameAsString.replaceAll("\"", "");
    }

    /**
     * Parses string representation of the date
     * @param dateAsString the string representation of the date to parse
     * @return parsed {@link Date} object
     * @throws ParseException if {@link java.text.SimpleDateFormat} throws it
     */
    public static Date parseBirthday(String dateAsString) throws ParseException {
        return new SimpleDateFormat(System.getProperty(DecathlonCalculator.DATE_PATTERN)).parse(dateAsString);
    }

    /**
     * Parses the specified result of the specified event to the domain object ({@link java.math.BigDecimal})
     * @param event event of the result
     * @param resultAsString string representation of the result to be parsed
     * @return parsed result value
     * @throws IOException if <code>resultAsString</code> is malformed
     */
    public static BigDecimal parseResult(DecathlonEvent event, String resultAsString) throws IOException {
        switch (event) {
            case SPRINT_400M:
            case RACE_1500M:
                BigDecimal value;
                /* Split into minutes and seconds */
                String[] results = resultAsString.split(":");
                if (results.length > 2)
                    throw new IOException(MALFORMED_RESULT_TEXT + resultAsString);
                /* Parse and save seconds */
                value = new BigDecimal(results[results.length - 1].trim());
                /* Add minutes */
                if (results.length == 2) {
                    value = value.add(new BigDecimal(results[0].trim()).multiply(new BigDecimal(60)));
                }
                return value;
            default:
                return new BigDecimal(resultAsString);
        }
    }
}
