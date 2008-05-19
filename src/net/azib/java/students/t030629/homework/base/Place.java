package net.azib.java.students.t030629.homework.base;

/**
 * Class represents the place of the {@link net.azib.java.students.t030629.homework.base.Athlete}
 * in a list of {@link net.azib.java.students.t030629.homework.base.Athlete Athletes}.

 * In most cases place is just an index in the final list of competitors,
 * however the athletes with the same score are said to share multiple places.
 *
 * <br><br>User: Anton Chepurov
 * <br>Date: 13.05.2008
 * <br>Time: 15:07:04
 */
public class Place {
    private final int start;
    private final int end;

    /**
     * Shortcut constructor, for a unique single place
     * @param place the only unique place
     */
    public Place(int place) {
        this(place, place);
    }

    /**
     * Full constructor
     * @param start starting place
     * @param end ending place (equals to starting place, if the place is unique)
     */
    public Place(int start, int end) {
        this.start = start;
        this.end = end;
    }

    /**
     * @return starting place
     */
    public int getStart() {
        return start;
    }

    /**
     * @return <code>true</code> if the place is unique
     */
    public boolean isSingle() {
        return start == end;
    }

    /**
     * @return either a single place or spanning places
     */
    public String toString() {
        return isSingle() ? "" + start : start + "-" + end;
    }
}
