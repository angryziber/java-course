package net.azib.java.students.t104971.homework.athletics.arithmetics;

import net.azib.java.students.t104971.homework.athletics.dto.Athlete;
import net.azib.java.students.t104971.homework.athletics.dto.Result;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

/**
 * @author Jaroslav Judin
 */
public class CalculatorTest {

    private List<Athlete> athletes;

    @Test
    public void testCalculate() throws Exception {
        Integer[][] results = new Integer[][]{{5, 5, 5, 5}, {1, 2, 3, 4}, {0, 0, 0, 0}};

        athletes = createAthletesList(results);
        Calculator calculator = new Calculator(athletes);

        for (int i = 0; i < athletes.size(); i++) {
            assertAthleteTotalScore(i, 0);
        }

        calculator.calculate();

        assertAthleteTotalScore(0, 20);
        assertAthleteTotalScore(1, 10);
        assertAthleteTotalScore(2, 0);

    }

    private void assertAthleteTotalScore(int index, int score) {
        if (index < athletes.size()) {
            assertEquals(score, athletes.get(index).getTotalScore());
        }
    }


    private List<Athlete> createAthletesList(Integer[][] results) {
        List<Athlete> athletes = new ArrayList<Athlete>();
        for (Integer[] res : results) {
            athletes.add(createAthleteWithResults(res));
        }
        return athletes;
    }

    private Athlete createAthleteWithResults(Integer... scores) {
        Athlete athlete = spy(new Athlete());
        List<Result> results = new ArrayList<Result>();
        for (Integer score : scores) {
            Result result = mock(Result.class);
            when(result.getScore()).thenReturn(score);
            results.add(result);
        }
        when(athlete.getResults()).thenReturn(results);
        return athlete;
    }
}
