package net.azib.java.students.t030629.homework.base.utils;

import net.azib.java.students.t030629.homework.base.Athlete;

import java.util.Comparator;

/**
 * Class implements {@link java.util.Comparator} interface for instances of
 * {@link net.azib.java.students.t030629.homework.base.Athlete} class.
 * Instances are compared on the basis of <i>total score</i> obtained
 * during the competition.
 *
 * <br><br>User: Anton Chepurov
 * <br>Date: 13.05.2008
 * <br>Time: 12:58:48
 */
public class AthleteResultComparator implements Comparator<Athlete> {
    static byte FIRST_LARGER = -1;
    static byte FIRST_SMALLER = 1;
    static byte EQUAL = 0;

    /**
     * The higher the score, the lower the athlete's rank.
     *
     * @param o1 first compared athlete
     * @param o2 second compared athlete
     * @return  {@link #FIRST_LARGER} (-1) if the <code>o1</code> has a larger total score than <code>o2</code> ,
     *          {@link #EQUAL} (0) if the <code>o1</code> has the same score as <code>o2</code> or
     *          {@link #FIRST_SMALLER} (1) if the <code>o1</code> has a smaller total score than <code>o2</code>
     */
    public int compare(Athlete o1, Athlete o2) {
        short score1 = o1.getResults().getTotalScore();
        short score2 = o2.getResults().getTotalScore();
        return (score1 - score2 < 0) ? FIRST_SMALLER : (score1 == score2) ? EQUAL : FIRST_LARGER;
    }
}
