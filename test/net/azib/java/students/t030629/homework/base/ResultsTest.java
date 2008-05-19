package net.azib.java.students.t030629.homework.base;

import org.junit.Test;
import org.junit.Before;
import net.azib.java.students.t030629.homework.io.StringParser;
import net.azib.java.students.t030629.homework.io.DefaultNormalizer;
import net.azib.java.students.t030629.homework.io.ResultNormalizer;
import net.azib.java.students.t030629.homework.DecathlonCalculator;

import java.io.IOException;
import static junit.framework.Assert.*;

/**
 * <br><br>User: Anton Chepurov
 * <br>Date: 13.05.2008
 * <br>Time: 12:19:10
 */
public class ResultsTest {
    private Results results;
    private static ResultNormalizer normalizer = new DefaultNormalizer();

    static {
        DecathlonCalculator.initProperties();
    }

    @Before
    public void initResults() {
        results = new Results();
    }

    @Test
    public void testTotalScoreCalculation() throws IOException {
        DecathlonEvent event;
        String resultAsString;

        /* Add 1st result */
        event = DecathlonEvent.RACE_1500M;
        resultAsString = "206.00";
        results.addResult(createResult(event, resultAsString));
        /* Add 2nd result */
        event = DecathlonEvent.SHOT_PUT;
        resultAsString = "23.12";
        results.addResult(createResult(event, resultAsString));

        assertEquals(1218 + 1295, results.getTotalScore());
        assertEquals(1218 + 1295, results.getTotalScore());

        /* Add 3rd result */
        event = DecathlonEvent.HURDLES_110M;
        resultAsString = "12.91";
        results.addResult(createResult(event, resultAsString));

        assertEquals(1218 + 1295 + 1120, results.getTotalScore());
        assertEquals(1218 + 1295 + 1120, results.getTotalScore());
    }

    /* Helper method */
    private Result createResult(DecathlonEvent event, String resultAsString) throws IOException {
        return new Result(event, normalizer.normalize(event, StringParser.parseResult(event, resultAsString)));
    }

    @Test
    public void correctResultObtainedForSpecifiedEvent() throws IOException, Results.UnfilledResultException {
        DecathlonEvent event;
        String resultAsString;

        event = DecathlonEvent.RACE_1500M;
        resultAsString = "6:51.01";
        results.addResult(createResult(event, resultAsString));

        event = DecathlonEvent.LONG_JUMP;
        resultAsString = "4.35";
        results.addResult(createResult(event, resultAsString));

        Result resultForRace = results.getResultFor(DecathlonEvent.RACE_1500M);
        assertEquals(DecathlonEvent.RACE_1500M, resultForRace.getEvent());
        assertEquals(StringParser.parseResult(DecathlonEvent.RACE_1500M, "6:51.01"), resultForRace.getResult());
    }

    @Test (expected = Results.UnfilledResultException.class)
    public void unfilledResultExceptionThrown() throws IOException, Results.UnfilledResultException {
        String resultAsString;

        resultAsString = "6:51.01";
        results.addResult(createResult(DecathlonEvent.RACE_1500M, resultAsString));
        
        results.getResultFor(DecathlonEvent.SPRINT_100M);
    }

    @Test
    public void testIncompleteResults() throws IOException {
        String[] resultsAsString = {
                "13.43", "4.35", "8.64", "1.50", "1:06.06", "19.05", "24.89", "2.20", "33.48", "6:51.01"
        };
        for (DecathlonEvent event : DecathlonEvent.values()) {
            results.addResult(createResult(event, resultsAsString[event.ordinal()]));
            if (event == DecathlonEvent.RACE_1500M) {
                assertTrue(results.areComplete());
            } else {
                assertFalse(results.areComplete());
            }
        }
    }
}
