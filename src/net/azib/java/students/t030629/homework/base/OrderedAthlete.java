package net.azib.java.students.t030629.homework.base;

/**
 * A wrapper class based on {@link Athlete} class.
 * Adds a {@link Place} object to the {@link Athlete} object.
 * <p>
 * <b>NB!</b> The class shouldn't be contemplated as an implementation of <code>Decorator</code>
 * design pattern, since it doesn't provide clients with the interface defined by
 * {@link net.azib.java.students.t030629.homework.base.Athlete} class. Though, this can be done
 * easily at any time.
 *
 * <br><br>User: Anton Chepurov
 * <br>Date: 13.05.2008
 * <br>Time: 15:06:05
 */
public class OrderedAthlete {

    private Athlete athlete;
    private Place place;

    /**
     * Full constructor, used by {@link net.azib.java.students.t030629.homework.base.utils.OrderedAthleteWrapper}
     * @param place of the athlete in a list of {@link net.azib.java.students.t030629.homework.base.OrderedAthlete OrderedAthletes}
     * @param athlete the base athlete
     */
    public OrderedAthlete(Place place, Athlete athlete) {
        this.place = place;
        this.athlete = athlete;
    }

    /**
     * @return the base athlete
     */
    public Athlete getAthlete() {
        return athlete;
    }

    /**
     * @return the place of the base athlete
     */
    public Place getPlace() {
        return place;
    }

}
