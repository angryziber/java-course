package net.azib.java.students.t030629.homework.base.utils;

import org.junit.Test;
import net.azib.java.students.t030629.homework.base.Athlete;
import net.azib.java.students.t030629.homework.base.OrderedAthlete;
import net.azib.java.students.t030629.homework.base.Place;
import net.azib.java.students.t030629.homework.io.StringParser;
import net.azib.java.students.t030629.homework.AthleteCreatorTestHelper;
import net.azib.java.students.t030629.homework.DecathlonCalculator;

import java.io.IOException;
import java.text.ParseException;
import static junit.framework.Assert.*;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 13.05.2008
 * <br>Time: 15:15:08
 */
public class OrderedAthleteWrapperTest {

    static {
        DecathlonCalculator.initProperties();
    }

    @Test (expected = IllegalArgumentException.class)
    public void exceptionThrownForUnsortedList() throws IOException, ParseException {
        Athlete[] unsortedAthletes = AthleteCreatorTestHelper.createUnsortedAthletes();

        new OrderedAthleteWrapper().wrap(unsortedAthletes);
    }

    @Test
    public void testCorrectPlaces() throws IOException, ParseException {
        Athlete[] uniqueSortedAthletes = AthleteCreatorTestHelper.createSortedAthletes();

        OrderedAthlete[] uniqueOrderedAthleteList = new OrderedAthleteWrapper().wrap(uniqueSortedAthletes);
        assertEquals(new Place(1).toString(), uniqueOrderedAthleteList[0].getPlace().toString());
        assertEquals(new Place(2).toString(), uniqueOrderedAthleteList[1].getPlace().toString());
        assertEquals(new Place(3).toString(), uniqueOrderedAthleteList[2].getPlace().toString());

        Athlete[] duplicatedSortedAthletes = AthleteCreatorTestHelper.createDuplicatedSortedAthletes();
        OrderedAthlete[] duplOrderedAthleteList = new OrderedAthleteWrapper().wrap(duplicatedSortedAthletes);
        assertEquals(new Place(1).toString(), duplOrderedAthleteList[0].getPlace().toString());
        assertEquals(new Place(2, 3).toString(), duplOrderedAthleteList[1].getPlace().toString());
        assertEquals(new Place(2, 3).toString(), duplOrderedAthleteList[2].getPlace().toString());

    }

    @Test
    public void orderedAthleteCorrectlyBuilt() throws IOException, ParseException {
        int athleteIndex = 2;
        String name = StringParser.parseName(AthleteCreatorTestHelper.createAthleteData(athleteIndex)[0].split(",")[0]);
        Athlete athlete = AthleteCreatorTestHelper.createAthletes(athleteIndex)[0];
        OrderedAthlete orderedAthlete = new OrderedAthleteWrapper().buildOrderedAthlete(new Place(15, 111), athlete);

        assertEquals("15-111", orderedAthlete.getPlace().toString());
        assertEquals(name, orderedAthlete.getAthlete().getName());

    }

}
