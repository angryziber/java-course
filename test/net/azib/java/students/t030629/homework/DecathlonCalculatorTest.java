package net.azib.java.students.t030629.homework;

import org.junit.Test;
import static junit.framework.Assert.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import net.azib.java.students.t030629.homework.base.Athlete;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 10.05.2008
 * <br>Time: 14:19:24
 */
public class DecathlonCalculatorTest {

    @Test
    public void testInitProperties() {
        DecathlonCalculator.initProperties();
        assertNotNull(System.getProperty(DecathlonCalculator.ENCODING_KEY));
        assertNotNull(System.getProperty(DecathlonCalculator.DATE_PATTERN_KEY));
        assertEquals(DecathlonCalculator.DEFAULT_ENCODING, System.getProperty(DecathlonCalculator.ENCODING_KEY));
        assertEquals(DecathlonCalculator.DEFAULT_DATE_PATTERN, System.getProperty(DecathlonCalculator.DATE_PATTERN_KEY));
    }

    @Test
    public void testSorting() throws IOException, ParseException {
        /* Create athletes */
        Athlete[] unsortedAthletes = AthleteCreatorTestHelper.createUnsortedAthletes();
        Athlete[] sortedAthletes = AthleteCreatorTestHelper.createSortedAthletes();
        /* Initial list */
        List<Athlete> athlets = new ArrayList<Athlete>(unsortedAthletes.length);
        athlets.addAll(Arrays.asList(unsortedAthletes));

//        System.out.println("Initial:");
//        for (Athlete athlete : athlets) System.out.println(athlete.getName() + ": " + athlete.getResults().getTotalScore());

        /* Sort list */
        DecathlonCalculator.sortAthletesByResult(athlets);
//        System.out.println("Sorted LIST:");
//        for (Athlete athlete : athlets) System.out.println(athlete.getName() + ": " + athlete.getResults().getTotalScore());
//        System.out.println("Initial:");
//        for (Athlete unsortedAthlete : unsortedAthletes) System.out.println(unsortedAthlete.getName() + ": " + unsortedAthlete.getResults().getTotalScore());

        assertEquals(sortedAthletes[0].getName(), athlets.get(0).getName());
        assertEquals(sortedAthletes[1].getName(), athlets.get(1).getName());
        assertEquals(sortedAthletes[2].getName(), athlets.get(2).getName());
    }

}
