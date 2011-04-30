package net.azib.java.students.t073756.homework.calculator;

import net.azib.java.students.t073756.homework.Athlete;
import net.azib.java.students.t073756.homework.DecathlonEvent;
import net.azib.java.students.t073756.homework.Result;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

import static junit.framework.Assert.assertEquals;
import static net.azib.java.students.t073756.homework.DecathlonEvent.HIGH_JUMP;
import static net.azib.java.students.t073756.homework.DecathlonEvent.M_1500;

/**
 * User: anton
 * Date: 4/2/11
 * Time: 6:18 PM
 */
public class ResultCalculatorTest {

    private Athlete athlete1;
    private Athlete athlete2;

    @Test
    public void shouldCalculateResultForTwoAthletes() throws Exception {
        athlete1 = createAthlete("5:15.22", "1.50");
        athlete2 = createAthlete("4:15.22", "0.50");

        initCalculator().calculateResult();

        assertEquals(M_1500.calculateScore("5:15.22") + HIGH_JUMP.calculateScore("1.50"),
                athlete1.getResult().getOverallResult());

        assertEquals(M_1500.calculateScore("4:15.22") + HIGH_JUMP.calculateScore("0.50"),
                athlete2.getResult().getOverallResult());
    }

    @Test
    public void shouldDividePlaces() throws Exception {
        athlete1 = createAthlete("5:15.22", "1.50");
        athlete2 = createAthlete("5:15.22", "0.50");

        dividePlaces();

        assertEquals("1", athlete1.getResult().getPlace().toString());
        assertEquals("2", athlete2.getResult().getPlace().toString());
    }

    @Test
    public void shouldAllowPlacesSharingPlaces() throws Exception {
        athlete1 = createAthlete("5:15.22", "1.50");
        athlete2 = createAthlete("5:15.22", "1.50");

        dividePlaces();

        assertEquals("1-2", athlete1.getResult().getPlace().toString());
        assertEquals("1-2", athlete2.getResult().getPlace().toString());
    }

    private void dividePlaces() {
        initCalculator().calculate();
    }

    private ResultCalculator initCalculator() {
        return new ResultCalculator(Arrays.asList(athlete1, athlete2));
    }

    private Athlete createAthlete(String run1500Result, String highJumpResult) {
        Athlete a = new Athlete();
        a.setResult(new Result());
        Map<DecathlonEvent, String> results = a.getResult().getResults();
        results.put(M_1500, run1500Result);
        results.put(HIGH_JUMP, highJumpResult);
        return a;
    }
}
