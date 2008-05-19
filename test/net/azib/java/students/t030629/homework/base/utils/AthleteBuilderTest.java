package net.azib.java.students.t030629.homework.base.utils;

import org.junit.Test;
import org.junit.Before;

import java.util.Locale;
import static junit.framework.Assert.*;
import net.azib.java.students.t030629.homework.DecathlonCalculator;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 14.05.2008
 * <br>Time: 13:37:21
 */
public class AthleteBuilderTest {
    private AthleteBuilder builder;

    static {
        DecathlonCalculator.initProperties();
    }

    @Before
    public void initBuilder() {
        builder = new AthleteBuilder();
    }

    @Test (expected = AthleteBuilder.UnsupportedCountryException.class)
    public void unknownCountryRejected() throws AthleteBuilder.UnsupportedCountryException {
        builder.addCountry("BUBAMARA11151325342545234523462361324");
    }

    @Test
    public void correctCountryParsing() throws AthleteBuilder.UnsupportedCountryException {
        Locale locale = builder.getLocaleFor("US");
        assertEquals("en", locale.getLanguage());
    }

    @Test (expected = AthleteBuilder.IncompleteAthleteException.class)
    public void incompleteAthleteDetected() throws AthleteBuilder.IncompleteAthleteException {
        builder.newAthlete();
        builder.addName("Some Name");
        builder.getAthlete();
    }
}
