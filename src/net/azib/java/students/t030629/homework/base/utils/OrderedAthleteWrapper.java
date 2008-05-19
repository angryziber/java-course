package net.azib.java.students.t030629.homework.base.utils;

import net.azib.java.students.t030629.homework.base.Athlete;
import net.azib.java.students.t030629.homework.base.OrderedAthlete;
import net.azib.java.students.t030629.homework.base.Place;

/**
 * Class provides {@link #wrap(net.azib.java.students.t030629.homework.base.Athlete[])}
 * method for wrapping objects of {@link net.azib.java.students.t030629.homework.base.Athlete}
 * into objects of {@link net.azib.java.students.t030629.homework.base.OrderedAthlete}
 * that in addition to storing the Athlete iself also contains its
 * {@link net.azib.java.students.t030629.homework.base.Place} within the array of Athletes.
 * <p>
 * <b>NB!</b> The {@link net.azib.java.students.t030629.homework.base.OrderedAthlete} class
 * shouldn't be contemplated as an implementation of <code>Decorator</code> design pattern,
 * since it doesn't provide clients with the interface defined by
 * {@link net.azib.java.students.t030629.homework.base.Athlete} class. Though, this can be
 * done easily at any time.
 *
 * <br><br>User: Anton Chepurov
 * <br>Date: 13.05.2008
 * <br>Time: 15:05:44
 */
public class OrderedAthleteWrapper {
    private static final String UNSORTED_ARRAY_TEXT = "Unsorted array received as a parameter for wrap() method";
    private static final AthleteResultComparator comparator = new AthleteResultComparator();

    /**
     * Calculates and adds places to the Athletes.
     * Wraps {@link net.azib.java.students.t030629.homework.base.Athlete} into
     * {@link net.azib.java.students.t030629.homework.base.OrderedAthlete}
     * @param athletes  an array of {@link net.azib.java.students.t030629.homework.base.Athlete Athletes}
     *                  to wrap. <b>NB!</b> Must be in the sorted order! Otherwise {@link IllegalArgumentException}
     *                  will be thrown.
     * @return an array of wrapping {@link net.azib.java.students.t030629.homework.base.OrderedAthlete OrderedAthletes}
     */
    public OrderedAthlete[] wrap(Athlete... athletes) {
        checkForSortedArray(athletes);

        OrderedAthlete[] wrappedAthletes = new OrderedAthlete[athletes.length];

        for (int i = 0; i < athletes.length; i++) {

            /* Look ahead for the number of duplicate scores */
            int duplicatesCount = getDuplicatesCount(i, athletes);
            /* For every duplicate (including the currentAthlete), 
            *  set its place and wrap into OrderedAthlete */
            int duplicateIndex = 0;
            do {
                Place place = new Place(i + 1, i + duplicatesCount + 1);
                wrappedAthletes[i + duplicateIndex] = buildOrderedAthlete(place, athletes[i + duplicateIndex]);
                duplicateIndex++;
            } while (duplicateIndex <= duplicatesCount);

            /* Skip to the next unchecked athlete */
            i += duplicatesCount;
        }

        return wrappedAthletes;
    }

    /**
     * Builds an object of {@link net.azib.java.students.t030629.homework.base.OrderedAthlete}
     * out of objects of {@link net.azib.java.students.t030629.homework.base.Athlete} and
     * {@link net.azib.java.students.t030629.homework.base.Place}.
     * @param place of the athlete
     * @param athlete the base athlete for the {@link net.azib.java.students.t030629.homework.base.OrderedAthlete}
     * @return wrapper of Athlete with its Place inside.
     */
    public OrderedAthlete buildOrderedAthlete(Place place, Athlete athlete) {
        return new OrderedAthlete(place, athlete);
    }

    /**
     * Counts duplicate total scores in <code>athletes</code>
     * starting from specified index.
     * @param startingIndex index of athlete to start counting for. The actual counting starts from
     *                      index = <code>startingIndex + 1</code>
     * @param athletes      an array of athletes to search in
     * @return number   of duplicate scores, with the starting score excluded, so that if the score
     *                  is unique, then <code>0</code> is returned.
     */
    int getDuplicatesCount(int startingIndex, Athlete[] athletes) {
        short currentScore = athletes[startingIndex].getResults().getTotalScore();
        int count = 0;
        for (int i = startingIndex + 1; i < athletes.length; i++) {
            if (athletes[i].getResults().getTotalScore() == currentScore) {
                count++;
            } else break;
        }
        return count;
    }

    private void checkForSortedArray(Athlete... arrayToCheck) {
        Athlete previous = null;
        for (Athlete current : arrayToCheck) {
            /* Initialize previous */
            if (previous == null) {
                previous = current;
                continue;
            }

            /* Check for sorted (descending) order */
            if (previousIsSmaller(previous, current))
                throw new IllegalArgumentException(UNSORTED_ARRAY_TEXT);
            /* Update previous */
            previous = current;
        }
    }

    private boolean previousIsSmaller(Athlete previous, Athlete current) {
        return comparator.compare(previous, current) == AthleteResultComparator.FIRST_SMALLER;
    }

}
