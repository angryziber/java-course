package net.azib.java.students.t104971.homework.athletics.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * @author Jaroslav Judin
 */
public class InputParser {

    public static double parseResult(String value) {
        try {
            if (value.contains(":")) {
                String[] time = value.split(":");
                if (time.length == 2) {
                    return Double.valueOf(time[0]) * 60 + Double.valueOf(time[1]);
                }
            }
            return Double.valueOf(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static String parseName(String name) {
        return matchValue("^[A-Z]{1}[a-z]+\\s[A-Z]{1}[a-z]+$", name);
    }

    public static Date parseDate(String value) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            String expression = "^[0-3]{1}[0-9]{1}\\.[0-1]{1}[0-9]{1}\\.[1,2]{1}[0,9]{1}[0-9]{2}$";
            return Pattern.matches(expression, value) ? format.parse(value) : null;
        } catch (ParseException e) {
            return null;
        }
    }

    public static String parseCountry(String country) {
        return matchValue("^[A-Z]{2}$", country);
    }

    private static String matchValue(String expression, String value) {
       return Pattern.matches(expression, value) ? value : null;
    }
}
