package net.azib.java.students.t030629.homework.io;

import org.junit.Test;
import org.junit.Before;

import java.io.File;
import java.net.URISyntaxException;
import java.util.Arrays;

import net.azib.java.students.t030629.homework.base.OrderedAthlete;
import net.azib.java.students.t030629.homework.base.Athlete;
import net.azib.java.students.t030629.homework.base.utils.OrderedAthleteWrapper;
import net.azib.java.students.t030629.homework.AthleteCreatorTestHelper;
import net.azib.java.students.t030629.homework.DecathlonCalculator;

import javax.xml.parsers.ParserConfigurationException;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 16.05.2008
 * <br>Time: 11:50:31
 */
public class HTMLSaverTest {

    static {
        DecathlonCalculator.initProperties();
    }

    private OrderedAthlete orderedAthlete;
    private OrderedAthlete[] orderedAthletes;

    @Before
    public void createOrderedAthletes() throws ParserConfigurationException {
        Athlete[] athletes = AthleteCreatorTestHelper.createAthletes(0, 1);
        this.orderedAthlete = new OrderedAthleteWrapper().wrap(athletes[0])[0];
        DecathlonCalculator.sortAthletesByResult(Arrays.asList(athletes));
        this.orderedAthletes = new OrderedAthleteWrapper().wrap(athletes);

    }


    @Test
    public void test() throws URISyntaxException {
        File parent = new File(getClass().getResource(".").toURI());

/*
        Athlete[] unsortedAthletes = AthleteCreatorTestHelper.createAthletes(0, 1, 0);
        DecathlonCalculator.sortAthletesByResult(Arrays.asList(unsortedAthletes));
        this.orderedAthletes = new OrderedAthleteWrapper().wrap(unsortedAthletes);
*/

        new HTMLSaver(new File(parent, "HTMLresults.html")).save(orderedAthletes);
    }

}
