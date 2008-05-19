package net.azib.java.students.t030629.homework.io;

import net.azib.java.students.t030629.homework.base.*;
import net.azib.java.students.t030629.homework.DecathlonCalculator;

import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.text.NumberFormat;
import java.text.DecimalFormat;
import java.math.BigDecimal;

/**
 * Class formats an array of {@link net.azib.java.students.t030629.homework.base.OrderedAthlete OrderedAthletes}
 * for outputing it into a CSV file.

 * <br><br>User: Anton Chepurov
 * <br>Date: 13.05.2008
 * <br>Time: 23:33:19
 */
public class CSVFormatter implements OrderedAthleteFormatter {
    private static final String LN = System.getProperty("line.separator");
    private ResultNormalizer defaultNormalizer = new DefaultNormalizer();

    /**
     * @see net.azib.java.students.t030629.homework.io.OrderedAthleteFormatter
     */
    public String format(OrderedAthlete... athletes) {
        StringBuilder sb = new StringBuilder();

        for (OrderedAthlete athlet : athletes) {
            Athlete baseAthlete = athlet.getAthlete();
            sb.append(formatPlace(athlet.getPlace())).append(",");
            sb.append(baseAthlete.getResults().getTotalScore()).append(",");
            sb.append(formatName(baseAthlete.getName())).append(",");
            sb.append(formatBirthday(baseAthlete.getBirthday())).append(",");
            sb.append(formatCountry(baseAthlete.getLocale())).append(",");
            sb.append(formatResults(baseAthlete.getResults())).append(LN);
        }
        return sb.toString();
    }

    /**
     * @see net.azib.java.students.t030629.homework.io.OrderedAthleteFormatter
     */
    public String formatName(String name) {
        return "\"" + name + "\"";
    }

    /**
     * @see net.azib.java.students.t030629.homework.io.OrderedAthleteFormatter
     */
    public String formatBirthday(Date date) {
        return new SimpleDateFormat(System.getProperty(DecathlonCalculator.DATE_PATTERN_KEY)).format(date);
    }

    /**
     * @see net.azib.java.students.t030629.homework.io.OrderedAthleteFormatter
     */
    public String formatCountry(Locale locale) {
        return locale.getCountry();
    }

    /**
     * @see net.azib.java.students.t030629.homework.io.OrderedAthleteFormatter
     */
    public String formatResults(Results results) {
        StringBuilder sb = new StringBuilder();
        for (Result result : results.getResults()) {
            sb.append(formatResult(result)).append(",");
        }
        return sb.substring(0, sb.length() - 1);
    }

    /**
     * @see net.azib.java.students.t030629.homework.io.OrderedAthleteFormatter
     */
    public String formatResult(Result result) {
        BigDecimal value = defaultNormalizer.denormalize(result.getEvent(), result.getResult());
        NumberFormat df = DecimalFormat.getInstance();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        switch (result.getEvent()) {
            case SPRINT_400M:
            case RACE_1500M:
                StringBuilder sb = new StringBuilder();
                BigDecimal[] decimals = value.divideAndRemainder(new BigDecimal(60));
                if (decimals[0].compareTo(BigDecimal.ZERO) == 1) {
                    sb.append(decimals[0].intValue()).append(':');
                }
                df.setMinimumIntegerDigits(2);
                sb.append(df.format(decimals[1]));
                return sb.toString().replaceAll(",", ".");
            default:
                return df.format(value).replaceAll(",", ".");
        }
    }

    /**
     * @see net.azib.java.students.t030629.homework.io.OrderedAthleteFormatter
     */
    public String formatPlace(Place place) {
        return place.toString();
    }
}
