package net.azib.java.students.t030629.homework.base;

import java.math.BigDecimal;

/**
 * Class encapsulates a result of an {@link net.azib.java.students.t030629.homework.base.Athlete}
 * in a certain {@link net.azib.java.students.t030629.homework.base.DecathlonEvent}.
 * 
 * <br><br>User: Anton Chepurov
 * <br>Date: 12.05.2008
 * <br>Time: 14:53:31
 */
public class Result {

    private BigDecimal result;
    private DecathlonEvent event;
    /**
     * Score for the result as <code>short</code>, since the total current results for the athletes are far below
     * 32K (in fact, < 10K)
     * @see net.azib.java.students.t030629.homework.base.DecathlonEvent#calculateScore(java.math.BigDecimal)
     */
    private short score = -1;

    /**
     * Full constructor, used by {@link net.azib.java.students.t030629.homework.base.utils.AthleteBuilder AthleteBuilder}.
     * @param event of the result
     * @param result of the event in normal units
     */
    public Result(DecathlonEvent event, BigDecimal result) {
        this.event = event;
        this.result = result;
    }

    /**
     * @return the score for the result. The score is calculated if it hasn't been before.
     */
    public short getScore() {
        if (score == -1) {
            score = event.calculateScore(result);
        }
        return score;
    }

    /**
     * @return the event of the result
     */
    public DecathlonEvent getEvent() {
        return event;
    }

    /**
     * @return the result of the event in normal units
     */
    public BigDecimal getResult() {
        return result;
    }
}
