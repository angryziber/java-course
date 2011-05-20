package net.azib.java.students.t110013.homework.model;

/**
 * @author Vadim
 */

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

/**
 * @author Vadim
 */
public class AthleteTest {
    Athlete athlete1 = prepareTestAthlete("Bryan Clay", 4200);
    Athlete athlete2 = prepareTestAthlete("Christian Plaziat", 4200);
    Athlete athlete3 = prepareTestAthlete("Torsten Voss", 3199);

    @Test
    public void athletesAreComparedByTheirTotalScore() {
        assertTrue(athlete1.compareTo(athlete3) >= 1);
	    assertTrue(athlete3.compareTo(athlete1) <= -1);
        assertTrue(athlete1.compareTo(athlete2) == 0);
    }

    @Test
    public void athletesAreEqualIfTheirTotalScoresAreEqual() {
        assertTrue(athlete1.equals(athlete2));
        assertFalse(athlete1.equals(athlete3));
    }

    @Test
    public void equalAthletesWillHaveEqualHashCodes() {} {
        assertThat(athlete1.hashCode(), equalTo(athlete2.hashCode()));
        assertThat(athlete1.hashCode(), not(equalTo(athlete3.hashCode())));
    }

    private Athlete prepareTestAthlete(String name, int totalScore) {
        Athlete athlete = new Athlete();

        athlete.setName(name);
	    athlete.setTotalScore(totalScore);

        return athlete;
    }
}
