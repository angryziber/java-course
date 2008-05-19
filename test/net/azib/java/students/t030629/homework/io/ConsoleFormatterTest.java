package net.azib.java.students.t030629.homework.io;

import org.junit.Test;
import static junit.framework.Assert.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.Locale;
import java.util.Date;
import java.util.Arrays;

import net.azib.java.students.t030629.homework.base.*;
import net.azib.java.students.t030629.homework.base.utils.OrderedAthleteWrapper;
import net.azib.java.students.t030629.homework.AthleteCreatorTestHelper;
import net.azib.java.students.t030629.homework.DecathlonCalculator;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 14.05.2008
 * <br>Time: 13:04:08
 */
public class ConsoleFormatterTest extends AbstractFormatterTest {
    private OrderedAthleteFormatter formatter = new ConsoleFormatter();
    private static final String LN = System.getProperty("line.separator");

    static {
        DecathlonCalculator.initProperties();
    }

    @Test
    public void correctNameFormatting() {
        String name = "Siim Kallas";
        assertEquals("Name: " + name, formatter.formatName(name));
    }

    @Test
    public void correctBirthdayFormatting() {
        assertEquals("Date of birth: 1.01.1970", formatter.formatBirthday(new Date(0)));
    }

    @Test
    public void correctCountryFormatting() {
        assertEquals("Country: " + Locale.US.getDisplayCountry(Locale.US), formatter.formatCountry(Locale.US));
    }

    @Test
    public void correctResultFormatting() throws IOException, ParseException {
        Athlete athlete = AthleteCreatorTestHelper.createAthletes(0)[0];

        try {
            assertEquals(
                "#10: 1500 m race >> 6:51.01 (min:sec) <<",
                    formatter.formatResult(athlete.getResults().getResultFor(DecathlonEvent.RACE_1500M))
            );
            assertEquals(
                "#1: 100 m sprint >> 13.43 (sec) <<",
                    formatter.formatResult(athlete.getResults().getResultFor(DecathlonEvent.SPRINT_100M))
            );
            assertEquals(
                "#8: Pole vault >> 2.20 (m) <<",
                    formatter.formatResult(athlete.getResults().getResultFor(DecathlonEvent.POLE_VAULT))
            );
        } catch (Results.UnfilledResultException e) {
            //do nothing
        }
    }

    @Test
    public void correctResultsFormatting() throws IOException, ParseException {
        Athlete athlete = AthleteCreatorTestHelper.createAthletes(0)[0];
        StringBuilder sb = new StringBuilder();
        sb.append("#1: 100 m sprint >> 13.43 (sec) <<").append(LN);
        sb.append("#2: Long jump >> 4.35 (m) <<").append(LN);
        sb.append("#3: Shot put >> 8.64 (m) <<").append(LN);
        sb.append("#4: High jump >> 1.50 (m) <<").append(LN);
        sb.append("#5: 400 m sprint >> 1:06.06 (min:sec) <<").append(LN);
        sb.append("#6: 110 m hurdles >> 19.05 (sec) <<").append(LN);
        sb.append("#7: Discus throw >> 24.89 (m) <<").append(LN);
        sb.append("#8: Pole vault >> 2.20 (m) <<").append(LN);
        sb.append("#9: Javelin throw >> 33.48 (m) <<").append(LN);
        sb.append("#10: 1500 m race >> 6:51.01 (min:sec) <<").append(LN);

        assertEquals(sb.toString(), formatter.formatResults(athlete.getResults()));
    }

    @Test
    public void correctPlaceFormatting() {
        assertEquals("Place: 1st", formatter.formatPlace(new Place(1)));
        assertEquals("Place: 2nd", formatter.formatPlace(new Place(2)));
        assertEquals("Place: 3rd", formatter.formatPlace(new Place(3)));
        assertEquals("Place: 4th", formatter.formatPlace(new Place(4)));
        assertEquals("Place: 5th", formatter.formatPlace(new Place(5)));
        assertEquals("Place: 8th", formatter.formatPlace(new Place(8)));
        assertEquals("Place: 11th", formatter.formatPlace(new Place(11)));
        assertEquals("Place: 13th", formatter.formatPlace(new Place(13)));
        assertEquals("Place: 21st", formatter.formatPlace(new Place(21)));
        assertEquals("Place: 23rd", formatter.formatPlace(new Place(23)));
        assertEquals("Place: 2-4", formatter.formatPlace(new Place(2, 4)));

    }

    @Test
    public void correctAthleteFormatting() throws IOException, ParseException {
        Athlete[] athletes = AthleteCreatorTestHelper.createAthletes(0, 1);
        DecathlonCalculator.sortAthletesByResult(Arrays.asList(athletes));
        StringBuilder sb = new StringBuilder();

        sb.append("########################").append(LN);
        sb.append("Place: 1st (4234)").append(LN);
        sb.append("Name: Siim Susi, Date of birth: 1.01.1976, Country: Estonia").append(LN);
        sb.append("#1: 100 m sprint >> 12.61 (sec) <<").append(LN);
        sb.append("#2: Long jump >> 5.00 (m) <<").append(LN);
        sb.append("#3: Shot put >> 9.22 (m) <<").append(LN);
        sb.append("#4: High jump >> 1.50 (m) <<").append(LN);
        sb.append("#5: 400 m sprint >> 59.39 (min:sec) <<").append(LN);
        sb.append("#6: 110 m hurdles >> 16.43 (sec) <<").append(LN);
        sb.append("#7: Discus throw >> 21.60 (m) <<").append(LN);
        sb.append("#8: Pole vault >> 2.60 (m) <<").append(LN);
        sb.append("#9: Javelin throw >> 35.81 (m) <<").append(LN);
        sb.append("#10: 1500 m race >> 5:25.72 (min:sec) <<").append(LN).append(LN);

        sb.append("########################").append(LN);
        sb.append("Place: 2nd (3100)").append(LN);
        sb.append("Name: ������� ������, Date of birth: 21.10.1980, Country: Ukraine").append(LN);
        sb.append("#1: 100 m sprint >> 13.43 (sec) <<").append(LN);
        sb.append("#2: Long jump >> 4.35 (m) <<").append(LN);
        sb.append("#3: Shot put >> 8.64 (m) <<").append(LN);
        sb.append("#4: High jump >> 1.50 (m) <<").append(LN);
        sb.append("#5: 400 m sprint >> 1:06.06 (min:sec) <<").append(LN);
        sb.append("#6: 110 m hurdles >> 19.05 (sec) <<").append(LN);
        sb.append("#7: Discus throw >> 24.89 (m) <<").append(LN);
        sb.append("#8: Pole vault >> 2.20 (m) <<").append(LN);
        sb.append("#9: Javelin throw >> 33.48 (m) <<").append(LN);
        sb.append("#10: 1500 m race >> 6:51.01 (min:sec) <<").append(LN).append(LN);

        assertEquals(sb.toString(), formatter.format(new OrderedAthleteWrapper().wrap(athletes)));
    }
}
