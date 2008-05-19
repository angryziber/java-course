package net.azib.java.students.t030629.homework.base;

/**
 * Class for containing the results of an {@link net.azib.java.students.t030629.homework.base.Athlete}
 * for a Decathlon competition.
 * <p>
 * This class has been introduced to facilitate possible further extensions of the athlete results (e.g.
 * to contain the results for the different competitions).
 *
 * <br><br>User: Anton Chepurov
 * <br>Date: 13.05.2008
 * <br>Time: 12:05:37
 */
public class Results {
    private static final String UNFILLED_RESULT_TEXT = "Result unfilled for the following event: ";

    private final Result[] results;
    private short totalScore;

    /**
     * Constructor
     */
    public Results() {
        results = new Result[DecathlonEvent.values().length];
        totalScore = 0;
    }

    /**
     * Automatically adds the result to the total results and counts the total score.
     * @param newResult to be added.
     */
    public void addResult(Result newResult) {
        results[newResult.getEvent().ordinal()] = newResult;
        totalScore += newResult.getScore();
    }

    /**
     * @return the total score for all the filled events
     */
    public short getTotalScore() {
        return totalScore;
    }

    /**
     * @return the results
     */
    public Result[] getResults() {
        return results;
    }

    /**
     * Gets result for the specified event
     * @param event to get the result for
     * @return the result
     * @throws UnfilledResultException if the specified event hasn't been filled with a result so far
     */
    public Result getResultFor(DecathlonEvent event) throws UnfilledResultException {
        Result result = results[event.ordinal()];
        if (result == null) {
            throw new UnfilledResultException(UNFILLED_RESULT_TEXT + event);
        } else {
            return result;
        }
    }

    /**
     * @return <code>true</code> if all the events have been initialized with results.
     * <code>false</code> otherwise.
     */
    public boolean areComplete() {
        for (Result result : results)
            if (result == null) return false;
        return true;
    }

    /**
     * Helper class, to see the descriptive exception occurring when asking for a result of an unfilled event
     */
    public class UnfilledResultException extends Exception {
        public UnfilledResultException(String message) {
            super(message);
        }
    }
}
