package net.azib.java.students.t030629.homework.io;

import org.junit.Test;
import static junit.framework.Assert.*;

import java.util.Date;
import java.util.Locale;
import java.io.IOException;
import java.text.ParseException;

import net.azib.java.students.t030629.homework.base.Athlete;
import net.azib.java.students.t030629.homework.base.Place;
import net.azib.java.students.t030629.homework.base.OrderedAthlete;
import net.azib.java.students.t030629.homework.base.utils.AthleteBuilder;
import net.azib.java.students.t030629.homework.base.utils.OrderedAthleteWrapper;
import net.azib.java.students.t030629.homework.AthleteCreatorTestHelper;
import net.azib.java.students.t030629.homework.DecathlonCalculator;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 13.05.2008
 * <br>Time: 23:33:45
 */
public class CSVFormatterTest extends AbstractFormatterTest{
    private OrderedAthleteFormatter formatter = new CSVFormatter();


    static {
        DecathlonCalculator.initProperties();
    }

    @Test
    public void correctNameFormatting(){
        String name = "Siim Kallas";
        assertEquals("\"" + name + "\"", formatter.formatName(name));
    }

    @Test
    public void correctBirthdayFormatting(){
        assertEquals("1.01.1970", formatter.formatBirthday(new Date(0)));
        assertEquals("10.01.1970", formatter.formatBirthday(new Date(9 * 24 * 3600 * 1000)));
    }

    @Test
    public void correctCountryFormatting(){
        assertEquals(Locale.US.getCountry(), formatter.formatCountry(Locale.US));
    }

    @Test
    public void correctResultFormatting() throws AthleteBuilder.UnsupportedCountryException, IOException, AthleteBuilder.IncompleteAthleteException, ParseException {
        String athleteData1 = "\"Sz?r?s Sz?k\",3.04.1972,HU,13.75,4.84,10.12,1.50,1:08.44,19.18,30.85,2.80,33.88,6:22.75";
        String athleteData2 = "\"Sz?r?s Sz?k\",3.04.1972,HU,13.75,4.84,10.12,1.50,59.44,19.18,30.85,2.80,33.88,1:00.75";
        Athlete athlete1 = CSVLoader.loadAthleteFromLine(athleteData1);
        Athlete athlete2 = CSVLoader.loadAthleteFromLine(athleteData2);

        assertEquals("13.75", formatter.formatResult(athlete1.getResults().getResults()[0]));
        assertEquals("4.84", formatter.formatResult(athlete1.getResults().getResults()[1]));
        assertEquals("1:08.44", formatter.formatResult(athlete1.getResults().getResults()[4]));
        assertEquals("6:22.75", formatter.formatResult(athlete1.getResults().getResults()[9]));

        assertEquals("59.44", formatter.formatResult(athlete2.getResults().getResults()[4]));
        assertEquals("1:00.75", formatter.formatResult(athlete2.getResults().getResults()[9]));
    }

    @Test
    public void correctResultsFormatting() throws AthleteBuilder.UnsupportedCountryException, IOException, AthleteBuilder.IncompleteAthleteException, ParseException {
        String athleteData1 = "\"Sz?r?s Sz?k\",3.04.1972,HU,13.75,4.84,10.12,1.50,1:08.44,19.18,30.85,2.80,33.88,6:22.75";
        String athleteData2 = "\"Sz?r?s Sz?k\",3.04.1972,HU,13.75,4.84,10.12,1.50,59.44,19.18,30.85,2.80,33.88,1:00.75";
        Athlete athlete1 = CSVLoader.loadAthleteFromLine(athleteData1);
        Athlete athlete2 = CSVLoader.loadAthleteFromLine(athleteData2);

        assertEquals("13.75,4.84,10.12,1.50,1:08.44,19.18,30.85,2.80,33.88,6:22.75", formatter.formatResults(athlete1.getResults()));
        assertEquals("13.75,4.84,10.12,1.50,59.44,19.18,30.85,2.80,33.88,1:00.75", formatter.formatResults(athlete2.getResults()));
    }

    @Test
    public void correctPlaceFormatting() {
        assertEquals("1", formatter.formatPlace(new Place(1)));
        assertEquals("99", formatter.formatPlace(new Place(99)));
        assertEquals("5-17", formatter.formatPlace(new Place(5, 17)));
        assertEquals("2", formatter.formatPlace(new Place(2, 2)));
        assertEquals("2-3", formatter.formatPlace(new Place(2, 3)));
    }

    @Test
    public void correctAthleteFormatting() throws AthleteBuilder.UnsupportedCountryException, IOException, AthleteBuilder.IncompleteAthleteException, ParseException {
        String athleteData = "\"Sz?r?s Sz?k\",3.04.1972,HU,13.75,4.84,10.12,1.50,1:08.44,19.18,30.85,2.80,33.88,6:22.75";
        Athlete athlete = CSVLoader.loadAthleteFromLine(athleteData);

        assertEquals(
                "1-5,3495," + athleteData + System.getProperty("line.separator"),
                formatter.format(new OrderedAthleteWrapper().buildOrderedAthlete(new Place(1,5), athlete))
        );

    }

    @Test
    public void correctAthletesFormatting() throws IOException, ParseException {
        String ln = System.getProperty("line.separator");
        String[] athleteData = AthleteCreatorTestHelper.createAthleteData(AthleteCreatorTestHelper.getSortedAthleteIndices());

        /* Create Athletes */
        Athlete[] athletes = AthleteCreatorTestHelper.createSortedAthletes();
        /* Create OrderedAthletes */
        OrderedAthlete[] orderedAthletes = new OrderedAthleteWrapper().wrap(athletes);

        StringBuilder expected = new StringBuilder();
        for (int i = 0; i < orderedAthletes.length; i++) {
            OrderedAthlete orderedAthlete = orderedAthletes[i];
            expected.append(orderedAthlete.getPlace().toString()).append(",");
            expected.append(orderedAthlete.getAthlete().getResults().getTotalScore()).append(",");
            expected.append(athleteData[i]).append(ln);
        }
        String actual = formatter.format(orderedAthletes);
        assertEquals(expected.toString(), actual);

    }



}
