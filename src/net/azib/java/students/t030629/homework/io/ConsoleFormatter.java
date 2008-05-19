package net.azib.java.students.t030629.homework.io;

import net.azib.java.students.t030629.homework.base.*;
import net.azib.java.students.t030629.homework.DecathlonCalculator;

import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.text.MessageFormat;

/**
 * Class formats an array of {@link net.azib.java.students.t030629.homework.base.OrderedAthlete OrderedAthletes}
 * for displaying in console in human-readable format.
 *
 * <br><br>User: Anton Chepurov
 * <br>Date: 14.05.2008
 * <br>Time: 13:03:38
 */
public class ConsoleFormatter implements OrderedAthleteFormatter {
    private static final String LN = System.getProperty("line.separator");

    /* Simple PREFIXES */
    private static final String NAME_PREFIX = "Name: ";
    private static final String DATE_OF_BIRTH_PREFIX = "Date of birth: ";
    private static final String COUNTRY_PREFIX = "Country: ";
    private static final String PLACE_PREFIX = "Place: ";
    private static final String ATHLETES_DELIM = "########################";
    /* Complex PATTERNS (for MessageFormat) */
    private static final String RESULT_PATTERN = "#{0,number}: {1} >> {2} ({3}) <<";
    private static final String ATHLETE_PATTERN =
            "{0} ({1,number,####})" + LN +
            "{2}, {3}, {4}" + LN +
            "{5}";

    /* Helpers */
    private static final OrderedAthleteFormatter formatter = new CSVFormatter();
    private static final ResultNormalizer normalizer = new DefaultNormalizer();
    private static final MessageFormat resultFormat = new MessageFormat(RESULT_PATTERN);
    private static final MessageFormat athleteFormat = new MessageFormat(ATHLETE_PATTERN);


    /**
     * @see net.azib.java.students.t030629.homework.io.OrderedAthleteFormatter
     */
    public String format(OrderedAthlete... athletes) {
        StringBuilder sb = new StringBuilder();

        for (OrderedAthlete athlete : athletes) {
            sb.append(ATHLETES_DELIM).append(LN).append(athleteFormat.format(new Object[]{
                    formatPlace(athlete.getPlace()),
                    athlete.getAthlete().getResults().getTotalScore(),
                    formatName(athlete.getAthlete().getName()),
                    formatBirthday(athlete.getAthlete().getBirthday()),
                    formatCountry(athlete.getAthlete().getLocale()),
                    formatResults(athlete.getAthlete().getResults())
            })).append(LN);
        }
        return sb.toString();
    }

    /**
     * @see net.azib.java.students.t030629.homework.io.OrderedAthleteFormatter
     */
    public String formatName(String name) {
        return NAME_PREFIX + name;
    }

    /**
     * @see net.azib.java.students.t030629.homework.io.OrderedAthleteFormatter
     */
    public String formatBirthday(Date date) {
        return DATE_OF_BIRTH_PREFIX + new SimpleDateFormat(System.getProperty(DecathlonCalculator.DATE_PATTERN)).format(date);
    }

    /**
     * @see net.azib.java.students.t030629.homework.io.OrderedAthleteFormatter
     */
    public String formatCountry(Locale locale) {
        return COUNTRY_PREFIX + locale.getDisplayCountry(Locale.US);
    }

    /**
     * @see net.azib.java.students.t030629.homework.io.OrderedAthleteFormatter
     */
    public String formatResults(Results results) {
        StringBuilder sb = new StringBuilder();
        for (Result result : results.getResults()) {
            sb.append(formatResult(result)).append(LN);
        }
        return sb.toString();
    }

    /**
     * @see net.azib.java.students.t030629.homework.io.OrderedAthleteFormatter
     */
    public String formatResult(Result result) {
        DecathlonEvent event = result.getEvent();
        
        return resultFormat.format(new Object[]{
                event.ordinal() + 1,
                event.toString(),
                formatter.formatResult(result),
                normalizer.getNormalizedUnit(event)
        });
    }

    /**
     * @see net.azib.java.students.t030629.homework.io.OrderedAthleteFormatter
     */
    public String formatPlace(Place place) {
        /* ChoiceFormat and MessageFormat too simple to perform duly */
        if (place.isSingle()) {
            String suffix;
            String placeString = place.toString();
            int placeInt = place.getStart();
            if (placeInt > 4 && placeInt < 21) {
                suffix = "th";
            } else {
                if (placeString.endsWith("1")) {
                    suffix = "st";
                } else if (placeString.endsWith("2")) {
                    suffix = "nd";
                } else if (placeString.endsWith("3")) {
                    suffix = "rd";
                } else {
                    suffix = "th";
                }
            }
            return PLACE_PREFIX + placeInt + suffix;
        } else {
            return PLACE_PREFIX + place.toString();
        }
    }
}
