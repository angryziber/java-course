package net.azib.java.students.t030629.homework.base.utils;

import org.junit.Test;
import net.azib.java.students.t030629.homework.base.Athlete;
import net.azib.java.students.t030629.homework.AthleteCreatorTestHelper;
import net.azib.java.students.t030629.homework.DecathlonCalculator;

import java.io.IOException;
import java.text.ParseException;
import static junit.framework.Assert.*;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 13.05.2008
 * <br>Time: 13:18:44
 */
public class AthleteResultComparatorTest {

    static {
        DecathlonCalculator.initProperties();
    }

    @Test
    public void testCompareMethod() throws IOException, ParseException {
        AthleteResultComparator comparator = new AthleteResultComparator();
        Athlete[] athlets = AthleteCreatorTestHelper.createAthletes(1, 2);// 1st and 2nd place

        assertEquals(AthleteResultComparator.FIRST_LARGER, comparator.compare(athlets[0], athlets[1]));
        assertEquals(AthleteResultComparator.FIRST_SMALLER, comparator.compare(athlets[1], athlets[0]));
        assertEquals(AthleteResultComparator.EQUAL, comparator.compare(athlets[0], athlets[0]));

    }
}
