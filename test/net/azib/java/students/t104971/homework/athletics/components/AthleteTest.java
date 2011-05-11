package net.azib.java.students.t104971.homework.athletics.components;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static junit.framework.Assert.assertEquals;

/**
 * @author Jaroslav Judin
 */
public class AthleteTest {

    private Athlete athlete;

    @Before
    public void setUp() throws Exception {
        athlete = new Athlete();
    }

    @Test
    public void testAddResult() throws Exception {
        assertEquals(0, athlete.getResults().size());
        athlete.addResult(ResultType.HIGH_JUMP, 25);
        athlete.addResult(ResultType.RACE_400_METERS, 15);
        assertEquals(2, athlete.getResults().size());
    }

    @Test
    public void testToString() throws Exception {
        final Calendar date = Calendar.getInstance();
        date.set(1985, 0, 31);

        athlete.setName("John Black");
        athlete.setCountry("US");
        athlete.setDateBirth(date.getTime());
        athlete.setTotalScore(1000);

        athlete.addResult(ResultType.HIGH_JUMP, 25);
        athlete.addResult(ResultType.RACE_400_METERS, 15);
        athlete.setPlace("1");

        assertEquals("Athlete{ place=1, totalScore=1000, name= John Black, country= US, dateBirth=31.01.1985}" +
                "\n\t\tResult{type=HIGH_JUMP, result=25.0, score=54189}" +
                "\n\t\tResult{type=RACE_400_METERS, result=15.0, score=3105}",
                athlete.toString());
    }
}
